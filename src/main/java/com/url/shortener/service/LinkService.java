package com.url.shortener.service;

import com.url.shortener.entity.Link;
import com.url.shortener.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    public String createShortLink(String longUrl){
        Link link = new Link(longUrl);
        Link saved = linkRepository.save(link);
        String code = Base62Encoder.encode(saved.getId());
        return code;
    }

    public String resolve(String code){
        long id = Base62Encoder.decode(code);
        Link link = linkRepository.findById(id).orElseThrow(() -> new LinkNotFoundException(code));
        return link.getLongUrl();
    }
}
