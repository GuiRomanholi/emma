package br.com.fiap.emma.controller;

import br.com.fiap.emma.dto.ReadingRequest;
import br.com.fiap.emma.dto.ReadingResponse;
import br.com.fiap.emma.model.Reading;
import br.com.fiap.emma.service.ReadingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.net.URI;
import java.util.List;

@Tag(name = "Reading", description = "Operações com Reading")
@RestController
@RequestMapping(value = "/api/readings", produces = {"application/json"})
public class ReadingController {

    @Autowired
    private ReadingService service;

    @Operation(summary = "Retorna todas as leituras")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de leituras",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReadingResponse.class)))
    })
    @GetMapping
    public ResponseEntity<List<ReadingResponse>> findAll() {
        List<ReadingResponse> responses = service.findAll()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Retorna uma leitura por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Leitura encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReadingResponse.class))),
            @ApiResponse(responseCode = "404", description = "Leitura não encontrada",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public ResponseEntity<ReadingResponse> findById(@PathVariable Long id) {
        try {
            Reading r = service.findById(id);
            return ResponseEntity.ok(toResponse(r));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cria uma nova leitura para um Person (informe personId na URL)")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Leitura criada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReadingResponse.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping("/person/{personId}")
    public ResponseEntity<ReadingResponse> create(@PathVariable Long personId,
                                                  @RequestBody @Valid ReadingRequest request) {
        Reading reading = new Reading();
        reading.setDate(request.getDate());
        reading.setDescription(request.getDescription());
        reading.setHumor(request.getHumor());

        Reading saved = service.create(personId, reading);

        URI uri = URI.create("/readings/" + saved.getId());
        return ResponseEntity.created(uri).body(toResponse(saved));
    }

    @Operation(summary = "Atualiza uma leitura")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Atualizado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReadingResponse.class))),
            @ApiResponse(responseCode = "404", description = "Reading não encontrada",
                    content = @Content(schema = @Schema()))
    })
    @PutMapping("/{id}")
    public ResponseEntity<ReadingResponse> update(@PathVariable Long id,
                                                  @RequestBody @Valid ReadingRequest request) {
        try {
            Reading reading = new Reading();
            reading.setDate(request.getDate());
            reading.setDescription(request.getDescription());
            reading.setHumor(request.getHumor());

            Reading updated = service.update(id, reading);
            return ResponseEntity.ok(toResponse(updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Remove uma leitura")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Removido"),
            @ApiResponse(responseCode = "404", description = "Reading não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private ReadingResponse toResponse(Reading r) {
        Link self = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(ReadingController.class).findById(r.getId()))
                .withSelfRel();

        return new ReadingResponse(
                r.getId(),
                r.getDate(),
                r.getDescription(),
                r.getHumor(),
                r.getPerson().getId(),
                self
        );
    }
}
