package com.url.shortener.controller;

import com.url.shortener.dto.CreateLinkRequest;
import com.url.shortener.dto.CreateLinkResponse;
import com.url.shortener.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/urls")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<CreateLinkResponse> create(@Valid @RequestBody CreateLinkRequest request){

        String code = linkService.createShortLink(request.longUrl());

        String shortUrl = "http://localhost:8080/" + code;
        CreateLinkResponse response = new CreateLinkResponse(code, shortUrl, request.longUrl());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
