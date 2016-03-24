package com.artemnikitin.algo.strings;

public class LCS {

    public static void main(String[] args) {
        System.out.println(recursive("sdfsdfdsfsdf", "wtwrewdfdwewe"));
        System.out.println(dynamic("", ""));
    }

    public static String recursive(String first, String second) {
        int fl = first.length();
        int sl = second.length();
        if (fl == 0 || sl == 0) {
            return "";
        } else if (first.charAt(fl - 1) == second.charAt(sl - 1)) {
            return recursive(first.substring(0, fl - 1), second.substring(0, sl - 1)) + first.charAt(fl - 1);
        } else {
            String x = recursive(first, second.substring(0, sl - 1));
            String y = recursive(first.substring(0, fl - 1), second);
            return (x.length() > y.length()) ? x : y;
        }
    }

    public static String dynamic(String first, String second) {
        return "";
    }

}
