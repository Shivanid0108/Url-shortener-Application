package com.url.shortener.dto;

public record CreateLinkResponse(String code, String shortUrl, String longUrl) {
}
