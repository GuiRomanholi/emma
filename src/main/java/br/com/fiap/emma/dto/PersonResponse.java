package br.com.fiap.emma.dto;

import br.com.fiap.emma.model.UserRole;
import org.springframework.hateoas.Link;


public record PersonResponse(
        Long id, String name, String email, UserRole role) {}
