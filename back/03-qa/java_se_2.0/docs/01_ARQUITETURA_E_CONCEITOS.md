# 🏗️ Arquitetura e Conceitos do Projeto de Automação

**Autor:** Mailton Nascimento

---

## 🚀 Visão Geral e Escalabilidade

Este projeto não é apenas um conjunto de scripts de teste. É um **Framework de Automação Enterprise**, desenhado para escalar, suportar múltiplos ambientes e rodar em infraestruturas complexas como Docker e Jenkins.

### 🌟 Capacidades do Projeto
1.  **Multi-Browser & Cross-Platform**: Pronto para rodar em Chrome, Firefox e Edge, tanto no Windows, Linux (Docker) ou MacOS.
2.  **Selenium Grid Nativo**: Arquitetura desacoplada que permite execução local ou remota (Grid) sem alterar uma linha de código do teste.
3.  **Execução Paralela**: Suporte a execução de múltiplos testes simultâneos (via Grid) para reduzir tempo de feedback.
4.  **Isolamento de Testes**: Cada teste possui seu próprio ciclo de vida de navegador (abre -> testa -> fecha), garantindo zero interferência.
5.  **Multi-Ambiente**: Configuração dinâmica para rodar em QA, DEV ou PROD com apenas um parâmetro.

---

## 🗺️ Mapa do Projeto (Estrutura de Pastas)

Entenda o que cada diretório faz no ecossistema:

### 📂 `src/main/java/automationexercise` (O "Core")
Aqui fica a inteligência do framework. Nada de testes aqui, apenas infraestrutura.

-   **`config/`**: Gerencia leitura de arquivos `.properties` e decide qual ambiente usar.
-   **`data/`**: Geradores de massa de dados (Faker) e DTOs (Data Transfer Objects) para transitar dados.
-   **`driver/`**: O coração do Selenium.
    -   `DriverManager`: Gerencia a instância do driver (ThreadLocal para paralelismo).
    -   `DriverFactory`: Fabrica os drivers locais.
    -   `GridManager`: Conecta com o Selenium Grid remoto.
-   **`helpers/`**: Classes utilitárias para reduzir código repetitivo nos testes.
    -   `ElementHelper`: Cliques, inputs e interações robustas.
    -   `WaitHelper`: Centraliza todas as esperas explícitas (Waits).
-   **`report/`**: Gerenciamento de Screenshots e integração com Allure.

### 📂 `src/test/java/automationexercise` (A Camada de Testes)
Onde a automação de negócio acontece.

-   **`base/`**: Contém `BaseTest`, a classe mãe de todos os testes. Ela configura o `@Before` (abre browser) e `@After` (fecha browser).
-   **`pages/`**: Padrão **Page Objects**. Cada página do site tem uma classe equivalente aqui com seus seletores e métodos.
-   **`tests/`**: Onde os cenários de teste (@Test) residem.
-   **`categories/`**: Interfaces para taguear testes (@Smoke, @Regression).
-   **`support/`**: Constantes de mensagens e validadores.

---

## 🧩 Fluxo da Arquitetura

1.  **Runner (Maven)** chama o teste.
2.  **BaseTest** inicia -> Chama **EnvironmentManager** para saber onde rodar.
3.  **DriverManager** pede um browser -> Decide se é Local ou Grid.
4.  **Teste** executa -> Chama **PageObjects** para interagir com a tela.
5.  **PageObjects** usam **ElementHelper** para clicar/digitar com segurança.
6.  **Allure** coleta os passos e screenshots.
7.  **BaseTest** finaliza -> Fecha o browser.

---

## 🛠️ Tecnologias Utilizadas
-   **Java 17**: Linguagem base.
-   **Selenium WebDriver 4**: Interação com browser.
-   **JUnit 4**: Executor de testes e asserções.
-   **Maven**: Gerenciador de dependências e build.
-   **Allure Report**: Relatórios ricos em HTML.
-   **Docker Compose**: Orquestração do Selenium Grid.
-   **Lombok**: Redução de código boilerplate.
