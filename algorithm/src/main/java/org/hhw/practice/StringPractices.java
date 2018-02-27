package org.hhw.practice;

public class StringPractices {

    public static void main(String[] args) {
        String contnet = reverseString("abc");
        System.out.println(contnet);
    }

    public static String reverseString(String s) {
        char[] chs = s.toCharArray();
        int start = 0;
        int end = chs.length -1;
        while (start < end) {
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }

        return String.valueOf(chs);
    }


}
