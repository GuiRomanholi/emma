package br.com.fiap.emma.dto;

import br.com.fiap.emma.model.UserRole;

public record LoginResponseDTO(String token, Long id, String nome, String email, UserRole role
) {
}
