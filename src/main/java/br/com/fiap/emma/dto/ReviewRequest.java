package br.com.fiap.emma.dto;

import jakarta.validation.constraints.NotBlank;

public class ReviewRequest {

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    private Long readingId;

    public ReviewRequest() {}

    public ReviewRequest(String descricao) {
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Long getReadingId() {
        return readingId;
    }

    public void setReadingId(Long readingId) {
        this.readingId = readingId;
    }
}
