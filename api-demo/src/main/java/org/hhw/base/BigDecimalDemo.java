package org.hhw.base;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by houhongwei on 2017/12/26.
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        BigDecimal bigDecimal2 = new BigDecimal("1.00");

        System.out.println(bigDecimal1.compareTo(bigDecimal2));
        System.out.println(bigDecimal1.equals(bigDecimal2));

        Set<BigDecimal> map = new HashSet<>();
        map.add(bigDecimal1);
        map.add(bigDecimal2);
        System.out.println(map.toString());

        Set<BigDecimal> tree = new TreeSet<>();
        tree.add(bigDecimal1);
        tree.add(bigDecimal2);
        System.out.println(tree.toString());
    }
}
