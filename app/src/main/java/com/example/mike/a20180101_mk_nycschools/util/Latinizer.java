package com.example.mike.a20180101_mk_nycschools.util;

public class Latinizer {
    static String vowels = "aeiouy";

    public static void main(String[] args) {
        System.out.println( convert("chicken Soup") );
    }

    public static String convert( String sentence ){

        String a[] = sentence.split(" ");
        String res = "";
        for (int i = 0; i < a.length; i++) {
            res += latinize(a[i]);
            res += " ";
        }
        return res;
    }

    private static String latinize( String s ){
        String l = s.toLowerCase();

        for (int i = 0; i < l.length(); i++) {
            if ( vowels.contains(  String.valueOf( l.charAt( i ) ) )){
                return l.substring(i, l.length())+l.substring(0, i)+"ay";
            }
        }
        return l;

    }

}
