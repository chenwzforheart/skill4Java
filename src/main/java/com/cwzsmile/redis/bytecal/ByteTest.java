package com.cwzsmile.redis.bytecal;

import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * Created by csh9016 on 2019/3/19.
 */
public class ByteTest {

    public static void main(String[] args) {
        final BitSet bitSet = new BitSet(8);
        IntStream.range(0, 8).filter(i -> i % 2 == 0).forEach(bitSet::set);
        bitSet.set(3);
        bitSet.set(3, false);
        final boolean b = bitSet.get(3);
        bitSet.flip(6);
        bitSet.set(100);

        System.out.println(1 >>> 10);
    }
}
