package com.url.shortener.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "links")


public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "long_url", nullable = false, length = 2048)
    private String longUrl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    protected Link(){

    }

    public Link( String longUrl){
        this.longUrl = longUrl;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public String getLongUrl(){
        return longUrl;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
}
