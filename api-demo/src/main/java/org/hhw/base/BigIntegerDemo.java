package org.hhw.base;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by houhongwei on 2017/12/18.
 */
public class BigIntegerDemo {

    public static void main(String[] args) {

        int biglength = 4;
        BigInteger value = BigInteger.probablePrime(biglength, new Random(20));

        String str = "ProbablePrime of bitlength " + biglength + " is " +value;

        // print bi value
        System.out.println( str );

        System.out.println(value.toString());

    }
}
