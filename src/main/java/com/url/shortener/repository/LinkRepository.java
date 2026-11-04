package com.url.shortener.repository;

import com.url.shortener.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<Link> findById(Long id);
}
