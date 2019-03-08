package com.cwzsmile.redis.async;

import lombok.Data;
import lombok.Setter;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by csh9016 on 2019/3/7.
 */

public class Shop {

    public static final Random random = new Random();
    public static List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("Five"),
            new Shop("BuyItAll"));
    private static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    //t.setDaemon(true);
                    return t;
                }
            });
    private String name;
    private double price;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
       /* Future<Double> r1 = new AsyncTest().getPriceAsync("nihao");
        System.out.println(r1);
        System.out.println("查询到价格");
        Future<Double> r2 = new AsyncTest().getPriceAsync("nihao");
        System.out.println(r2);
        System.out.println("查询到价格1");
        System.out.println(r1.get());
        System.out.println(r2.get());*/
        //System.out.println(new Shop().getPriceStr("adfj"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("查询");
        System.out.println(findPrices3("1234"));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }

    public static List<String> findPrices(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPrices1(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " price is " + shop.getPrice(product), executor))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static List<String> findPrices2(String product) {
        return shops.parallelStream()
                .map(shop -> shop.getPriceStr(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public static List<String> findPrices3(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPriceStr(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(
                        quote -> CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }


    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPriceStr(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", "", price, code);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
