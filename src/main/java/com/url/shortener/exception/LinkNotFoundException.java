package com.url.shortener.exception;

public class LinkNotFoundException extends RuntimeException{
    public LinkNotFoundException(String code){
        super("No link found for code: " + code);
    }
}
