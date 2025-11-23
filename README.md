# ⚡ EMMA — Assistente Inteligente de Bem-Estar e Eficiência Energética no Trabalho

A **EMMA** é um aplicativo mobile voltado para o bem-estar emocional e mental de trabalhadores, conectado ao conceito de **eficiência energética humana**, ajudando pessoas e organizações a utilizarem melhor sua “energia” física e mental no ambiente de trabalho.

O projeto une **saúde mental, produtividade sustentável e uso consciente de energia humana**, promovendo rotinas mais equilibradas, menor estresse e melhor desempenho profissional.

---

## 🎯 Ideia Principal

A EMMA permite que o usuário:

- Registre seu estado emocional diariamente
- Acompanhe a evolução do seu nível de energia mental
- Receba dicas personalizadas para melhorar o equilíbrio entre:
  - saúde mental
  - produtividade
  - qualidade de vida no trabalho

O aplicativo estimula hábitos saudáveis que reduzem o desperdício de energia física e mental no dia a dia profissional.

---

## 🧩 Problema (Contexto Energético e Social)

Com o crescimento do trabalho remoto e híbrido, muitos profissionais enfrentam:

- Alto consumo de energia mental devido à sobrecarga de tarefas
- Estresse constante e ansiedade
- Falta de pausas regenerativas
- Dificuldade de separação entre vida pessoal e profissional

Isso causa:

- **Esgotamento (burnout)**
- **Queda na produtividade**
- **Desperdício de energia humana**
- Impactos indiretos no consumo de energia elétrica (uso excessivo de equipamentos, aumento do tempo ativo desnecessário)

---

## 💡 Solução

A EMMA atua como um **assistente de bem-estar e eficiência energética humana**, utilizando tecnologia para otimizar o uso da energia mental do trabalhador.

O systema oferece:

- Registro diário de humor e nível de estresse
- Análise inteligente dos padrões emocionais
- Recomendações personalizadas para:
  - pausas estratégicas
  - alongamentos
  - respiração consciente
  - momentos de relaxamento

Além disso, o app apresenta **gráficos e relatórios semanais**, permitindo a visualização da evolução emocional e do nível de “energia mental sustentável”.

---

## ⚙️ Funcionalidades

### 📱 App Mobile (React Native + Expo)

- Tela de Login e Cadastro (autenticação via API JWT)
- Registro Diário de Humor:
  - Feliz
  - Neutro
  - Cansado
  - Estressado
- Gráfico Semanal de Humor
- Tela de Dicas de Bem-Estar:
  - Exercícios rápidos
  - Pausas guiadas
  - Práticas de relaxamento

---

## 🧠 Inteligência Artificial

A IA integrada ao sistema (WorkCare) analisa o histórico emocional do usuário e identifica padrões de:

- Estresse elevado
- Queda de bem-estar
- Sobrecarga mental

### Exemplos de Sugestões da IA

- Em caso de alto estresse:
  > "Faça uma pausa de 5 minutos e pratique uma respiração profunda."

- Em caso de humor baixo:
  > "Experimente uma breve caminhada para clarear a mente."

A IA atua como um mecanismo de **gestão inteligente da energia humana**, reduzindo desperdícios e otimizando a produtividade.

---

## 🌱 Relevância e Inovação (Critérios do Projeto)

### ✅ Relevância na Área Energética

O projeto aborda a **eficiência no uso da energia humana**, considerando que trabalhadores sobrecarregados geram:

- Maior consumo de recursos
- Menor produtividade
- Aumento de falhas operacionais

A EMMA propõe um novo olhar sobre **energia sustentável aplicada ao ser humano**.

### ✅ Inovação

- Integra saúde mental com o conceito de eficiência energética
- Uso de IA para análise comportamental
- Abordagem criativa que conecta tecnologia, bem-estar e sustentabilidade
- Uso de tecnologias modernas (React Native, Expo, APIs seguras com JWT)

### ✅ Impacto Positivo

- Redução de burnout
- Melhora da qualidade de vida
- Estímulo ao consumo consciente de energia
- Contribuição indireta à sustentabilidade ambiental

---

## 🛠️ Viabilidade e Usabilidade

### ✅ Viabilidade Técnica

O projeto é totalmente viável utilizando:

- React Native + Expo
- API REST com autenticação JWT
- Banco de dados para histórico emocional
- Algoritmos de análise de padrões comportamentais

### ✅ Facilidade de Uso

- Interface simples e intuitiva
- Fluxos diretos e claros
- Funcionalidades pensadas para integração natural à rotina de trabalho

### ✅ Compreensão Tecnológica

O projeto demonstra domínio sobre:

- Desenvolvimento mobile
- Segurança com autenticação JWT
- Uso prático de IA para análise de dados comportamentais
- Visualização de dados com gráficos

---

## ✔️ Pré-requisitos

Antes de começar, garanta que você tenha:

| Ferramenta / Recurso             | Necessário | Obs.                              |
| -------------------------------- | :--------: | --------------------------------- |
| Gradle                           |      ✅     | Build da aplicação                |
| Java 17                          |      ✅     | Versão configurada no App Service |


## 🎥 Link do Vídeo
[Link do Video de Java](https://www.youtube.com/watch?v=aB91T3yk46E)

[Link do Pitch](https://www.youtube.com/watch?v=5FUpD32GzOM)

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
