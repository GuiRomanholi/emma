package br.com.fiap.emma.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/emma")
@Tag(name = "Emma Assistant", description = "Suporte emocional com IA")
public class EmmaAssistantController {

    private final ChatClient chatClient;

    public EmmaAssistantController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/feeling")
    @Operation(
            summary = "Obter apoio emocional baseado no sentimento",
            description = "Retorna dicas e estratégias acolhedoras baseadas no estado emocional informado."
    )
    @ApiResponse(responseCode = "200", description = "Resposta gerada com sucesso")
    public FeelingResponse getFeelingSupport(
            @Parameter(description = "Sentimento atual do usuário")
            @RequestParam(defaultValue = "sobrecarregado") String feeling
    ) {

        String response = chatClient.prompt()
                .system("""
                        Você é Emma, uma assistente de bem-estar gentil e empática.
                        Responda em primeira pessoa com 3 a 5 estratégias práticas.
                        Seja breve, acolhedora e sem dar conselhos médicos.
                    """)
                .user("Estou me sentindo: " + feeling)
                .call()
                .content();

        return new FeelingResponse(response);
    }

    public record FeelingResponse(String message) {}
}
