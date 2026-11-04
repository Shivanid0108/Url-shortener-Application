package com.url.shortener.service;

public class Base62Encoder {
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(long number){

        if(number < 0){
            throw new IllegalArgumentException("number must not be negative");
        }
        if(number == 0){
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while(number >0){
            int remainder = (int) (number % 62);
            result.append(ALPHABET.charAt(remainder));
            number = number / 62;
        }

        return result.reverse().toString();
    }

    public static long decode(String code){
        if(code == null || code.isEmpty()){
            throw new IllegalArgumentException("Code cannot be null or empty");
        }

        long total = 0;
        for(char c: code.toCharArray()){
            int value = ALPHABET.indexOf(c);

            if(value == -1){
                throw new IllegalArgumentException("Invalid character: " + c);

            }
            total = total * 62 + value;
        }
        return total;
    }
}
