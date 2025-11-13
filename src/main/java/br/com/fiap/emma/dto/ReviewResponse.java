package br.com.fiap.emma.dto;

import org.springframework.hateoas.Link;

public record ReviewResponse(Long id, String descricao, Long readingId, Link link) {}
