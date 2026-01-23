# Playbook de Automação de Testes - Projeto Automation Exercise

Este documento serve como guia definitivo para o desenvolvimento de testes automatizados neste projeto. Ele foi estruturado para servir de base para criação de materiais didáticos e apresentações.

---

## 1. Arquitetura do Projeto

O projeto segue uma estrutura híbrida onde o "Core" do framework reside em `src/main/java` e a implementação dos testes reside em `src/test/java`.

> 🤖 **Para o Gerador de PPT:**
> Crie um diagrama em blocos dividindo a tela em dois:
> - Título Esquerda: "Core (O Motor)" -> Ícone de Engrenagem -> `src/main/java` -> Drivers, Helpers, Config.
> - Título Direita: "Testes (A Implementação)" -> Ícone de Checklist -> `src/test/java` -> Pages, Tests, Runners.
> - Seta conectando "Testes" dependendo do "Core".

---

## 2. Guia Visual de Anotações e Pastas

Aqui explicamos o propósito das pastas e anotações com exemplos práticos.

### 2.1 Anotação `@PagePath` (O GPS do Teste)

Define para onde o navegador vai no início do teste.

**Exemplo Prático:**
```java
@PagePath("/login") // <--- O GPS aponta para cá
public class LoginTest extends BaseTest {
    // O teste já começa na página de login!
}
```

> 🤖 **Para o Gerador de PPT:**
> Crie uma ilustração estilo "Fluxo Lógico":
> 1. Bloco "Base URL" (ex: `automationexercise.com`)
> 2. Sinal de "+"
> 3. Bloco "PagePath" (ex: `/login`)
> 4. Seta "Resulta em"
> 5. Bloco "Navegador Aberto na URL Completa".

---

### 2.2 Categorias (`@Category`) (O Filtro)

Funcionam como etiquetas para organizar os testes em grupos.

**Exemplo Prático no Código:**
```java
// Este teste tem DUAS etiquetas: é Crítico e é de Smoke
@Category({ Smoke.class, Critical.class }) 
@Test
public void validarLogin() { ... }
```

**Como funciona a execução:**
Se rodarmos apenas a categoria `Smoke`, o JUnit vai ignorar todos os outros testes e rodar apenas este.

> 🤖 **Para o Gerador de PPT:**
> Crie uma imagem de um "Funil de Testes":
> - Várias bolinhas coloridas entrando no funil (representando todos os testes).
> - No meio do funil, uma peneira escrito "Filtro: @Category(Smoke)".
> - Saindo do funil, apenas as bolinhas vermelhas (Testes de Smoke).

---

### 2.3 Suítes (`@Suite`) (O Agrupador)

Agrupam vários testes para rodarem juntos. É como uma playlist de músicas.

**Exemplo Prático (`SmokeSuite.java`):**
```java
@RunWith(Categories.class)
@IncludeCategory(Smoke.class) // <--- Regra da Playlist: Só toca Smoke
@SuiteClasses({
    LoginTest.class,
    CadastroTest.class
})
public class SmokeSuite {}
```

> 🤖 **Para o Gerador de PPT:**
> Crie uma analogia com uma "Pasta de Arquivos" ou "Playlist Musical":
> - Uma pasta aberta chamada "Smoke Suite".
> - Dentro dela, ícones de arquivos representando `LoginTest` e `CadastroTest`.
> - Uma etiqueta na pasta dizendo "Apenas Smoke".

---

## 3. O Ciclo de Vida do Teste (`BaseTest`)

Todo teste herda de `BaseTest`. É ele que garante que o navegador abra e feche.

**Fluxo de Execução:**
1.  **@Before (`setUp`)**: Abre o navegador e vai para a URL.
2.  **@Test**: Executa os passos (clica, preenche, valida).
3.  **@After (`tearDown`)**: Fecha o navegador (mesmo se o teste falhar).

> 🤖 **Para o Gerador de PPT:**
> Crie uma "Linha do Tempo Horizontal":
> 1. Ponto Inicial (Verde): Ícone de Navegador Abrindo (`@Before`).
> 2. Meio (Azul): Ícone de Robô executando ações (`@Test`).
> 3. Ponto Final (Vermelho): Ícone de Navegador Fechando (`@After`).
> *Destaque que isso acontece para CADA teste individualmente.*

---

## 4. Gestão de Ambientes

Como testar em QA, DEV ou PROD sem mudar o código?

**Comando Mágico:**
```bash
mvn clean test -Dtest.env=dev
```

> 🤖 **Para o Gerador de PPT:**
> Crie uma imagem com 3 Portas:
> - Porta 1 (Verde): Placa "QA" (Aberta - Padrão).
> - Porta 2 (Amarelo): Placa "DEV" (Aberta com chave `-Dtest.env=dev`).
> - Porta 3 (Vermelho): Placa "PROD" (Aberta com chave `-Dtest.env=prod`).
> Um bonequinho (QA) escolhendo em qual porta entrar via linha de comando.

---

## 5. Docker e Grid (Infraestrutura)

Onde os testes rodam? Na minha máquina ou em um servidor?

**Arquitetura do Grid (`docker-compose`):**
O Hub é o "Gerente" e os Nodes são os "Trabalhadores".

> 🤖 **Para o Gerador de PPT:**
> Crie um diagrama de rede "Hub & Spoke":
> - No centro: Um servidor grande chamado "Selenium Hub".
> - Conectados a ele:
>   - 1 Computador com ícone do Chrome (Node Chrome).
>   - 1 Computador com ícone do Firefox (Node Firefox).
>   - 1 Computador com ícone do Edge (Node Edge).
> - O código de teste envia o comando para o Hub, e o Hub distribui para os Nodes.

---

## 6. Paralelismo (Modo Turbo)

Como rodar 4 testes ao mesmo tempo?

**Configuração no `pom.xml`:**
```xml
<parallel>classes</parallel>
<threadCount>4</threadCount>
```

> 🤖 **Para o Gerador de PPT:**
> Crie uma comparação "Fila vs Pista de Corrida":
> - Lado Esquerdo (Sem Paralelismo): 4 Carros em fila indiana, um esperando o outro.
> - Lado Direito (Com Paralelismo): 4 Carros lado a lado em uma pista de 4 faixas, todos correndo juntos.

---

## 7. Fluxo de Criação (Receita de Bolo)

Passo a passo para o estagiário criar o primeiro teste.

1.  **Crie a Página (`Page Object`)**: Mapeie os botões e campos.
2.  **Crie a Massa (`Factory`)**: Gere os dados de teste (CPF, Email).
3.  **Crie o Teste (`Test Class`)**: Junte a Página e a Massa e faça as validações.

> 🤖 **Para o Gerador de PPT:**
> Crie um fluxograma vertical de 3 passos:
> 1. Ícone de Mapa/Planta -> Texto: "Mapear Página (Page Object)".
> 2. Ícone de Dados/Planilha -> Texto: "Gerar Massa (Data Factory)".
> 3. Ícone de Check/Visto -> Texto: "Escrever e Rodar Teste".
> Seta para baixo conectando os passos.

---
*Documento otimizado para geração de material didático via IA - Janeiro/2026*
