package br.com.fiap.emma.controller.web;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emma")
public class EmmaAssistantWebController {

    private final ChatClient chatClient;

    public EmmaAssistantWebController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/feeling")
    public String showFeelingForm() {
        return "emma/emma-feeling";
    }

    @PostMapping("/feeling")
    public String processFeelingAndDescription(
            @RequestParam String feeling,
            @RequestParam(required = false, defaultValue = "") String description,
            Model model) {

        String prompt = """
                Você é Emma, uma assistente de bem-estar gentil, empática e acolhedora.
                Responda em primeira pessoa com 3 a 5 estratégias práticas.
                Seja breve, empática e jamais forneça conselhos médicos ou diagnósticos.

                Sentimento informado: %s
                Descrição/contexto: %s
                """.formatted(feeling, description);

        String result = chatClient.prompt()
                .system("""
                        Você é Emma, uma assistente emocional solidária e acolhedora.
                        Sempre responda de forma compreensiva, empática, curta e prática.
                """)
                .user(prompt)
                .call()
                .content();

        model.addAttribute("response", result);
        model.addAttribute("feeling", feeling);
        model.addAttribute("description", description);

        return "emma/emma-feeling-result";
    }
}