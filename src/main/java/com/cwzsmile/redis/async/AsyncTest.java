package com.cwzsmile.redis.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by csh9016 on 2019/3/7.
 */
public class AsyncTest {

    public static final Random random = new Random();

    public static void main(String[] args) throws Exception{
       /* Future<Double> r1 = new AsyncTest().getPriceAsync("nihao");
        System.out.println(r1);
        System.out.println("查询到价格");
        Future<Double> r2 = new AsyncTest().getPriceAsync("nihao");
        System.out.println(r2);
        System.out.println("查询到价格1");
        System.out.println(r1.get());
        System.out.println(r2.get());*/
        System.out.println(new AsyncTest().getPriceStr("adfj"));
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPriceStr(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s","",price,code);
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
