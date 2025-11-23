# 🧘‍♀️ EMMA — Assistente de Bem-Estar para Profissionais

A **EMMA** é um aplicativo mobile focado em promover o bem-estar emocional e mental de trabalhadores. Seu objetivo é ajudar profissionais a acompanharem seu estado emocional, reduzirem o estresse e manterem uma rotina de trabalho mais saudável, equilibrada e sustentável.

---

## 🎯 Ideia Principal

A EMMA permite que o usuário registre como está se sentindo ao longo do dia, acompanhe sua evolução emocional e receba dicas de bem-estar personalizadas.

Por meio de uma interface simples e intuitiva, o app incentiva hábitos saudáveis e práticas de autocuidado, auxiliando na prevenção do estresse, da ansiedade e do burnout.

---

## 🧩 Problema

Com o crescimento do trabalho remoto e híbrido, muitos profissionais enfrentam:

- Aumento do estresse e ansiedade  
- Dificuldade em equilibrar vida pessoal e profissional  
- Sobrecarga mental e falta de pausas  
- Pressão contínua por produtividade  

Esses fatores impactam diretamente a saúde mental e o desempenho no trabalho, contribuindo para o esgotamento (burnout) e queda na qualidade de vida.

---

## 💡 Solução

A EMMA funciona como um **assistente digital de bem-estar emocional**, combinando tecnologia, design simples e práticas de autocuidado.

- O usuário registra diariamente seu humor e nível de estresse.  
- A IA analisa padrões emocionais ao longo do tempo.  
- O sistema oferece **dicas personalizadas** para melhorar o bem-estar.  
- Gráficos e relatórios semanais ajudam a visualizar a evolução emocional.  

Tudo isso em uma experiência amigável, leve e fácil de usar no dia a dia.

---

## 🧠 Inteligência Artificial

A IA do sistema (Emma) analisa os registros de humor e os padrões de comportamento para gerar recomendações personalizadas.

### Exemplos de Sugestões

- **Para altos níveis de estresse:**  
  > “Faça uma pausa de 5 minutos e pratique uma respiração profunda.”

- **Para humor baixo:**  
  > “Experimente uma breve caminhada para clarear a mente.”

As dicas são rápidas, simples e projetadas para caber na rotina profissional.

---

## ✔️ Pré-requisitos

Antes de começar, garanta que você tenha:

| Ferramenta / Recurso             | Necessário | Obs.                              |
| -------------------------------- | :--------: | --------------------------------- |
| Gradle                           |      ✅     | Build da aplicação                |
| Java 17                          |      ✅     | Versão configurada no App Service |


## 🎥 Link do Vídeo
[Link do Video de Java](https://www.youtube.com/watch?v=aB91T3yk46E)

---

## 🔗 Rotas Pricipais pra Teste (Swagger e Thymeleaf)

A API do projeto podia ser acessada via Swagger na rota:

[https://emma-rm557462.azurewebsites.net/swagger-ui/index.html](https://emma-rm557462.azurewebsites.net/swagger-ui/index.html)

Tambem pode acessar as páginas criadas com o thymeleaf (Recomendado):

[https://emma-rm557462.azurewebsites.net/login](https://emma-rm557462.azurewebsites.net/login)

## 🔗 Rotas Pricipais para teste Local

A API do projeto pode ser acessada via Swagger na rota, ou pela páginas html, e o banco tambem:

- [http://localhost:8081/register](http://localhost:8081/register)
- [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)
- [http://localhost:8081/h2-console](http://localhost:8081/h2-console)
`JDBC URL:	jdbc:h2:mem:testdb, User Name: sa, Password: deixar em branco`

> **Importante:**
> Crie um **Reading** antes de Fazer Uma Requisição para a AI, pois a Ai vai devolver uma **Solução** e colocar no **Review**. O ID gerado em um passo é usado no próximo.

## Rotas recomendadas para o Teste:
#### Exemplo 1: (Registrar Usuário)

```bash
{
  "name": "Geovanni",
  "email": "geovannilupa@gmail.com",
  "password": "Vermelho11",
  "role": "ADMIN"
}
```
#### Exemplo 1.5: (Logar Usuário)

```bash
{
    "email": "geovannilupa@gmail.com",
    "password": "Vermelho11"
}
```

#### Exemplo 2: (Criar Reading)

```bash
{
  "date": "2025-11-20T21:07:12.122Z",
  "description": "Eu errei no Trabalho",
  "humor": "Estressado",
  "personId": 1
}
```

#### Exemplo 3: (Criar Review)
#### Para Criar um review Basta Acessar a AI, colocar seu **feeling** uma **description** e qual o seu **reading** e ela retornará uma **message** para você e adicionara no **Review**


---

## 🧑‍💻 Integrantes do Grupo

- **Guilherme Romanholi Santos - RM557462**
- **Murilo Capristo - RM556794**
- **Nicolas Guinante Cavalcanti - RM557844**
