package org.hhw.commondemo;

import org.apache.commons.lang.math.NumberUtils;

public class NumberUtil {
    public static void main(String[] args) {
        System.out.println(NumberUtils.isDigits("912.1"));
        System.out.println(Long.valueOf("0912"));
    }
}
