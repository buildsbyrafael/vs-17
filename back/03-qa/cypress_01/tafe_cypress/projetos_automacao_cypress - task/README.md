# Projeto de Aula: Automação com Cypress

Este projeto foi criado para demonstrar a evolução de testes automatizados com Cypress, partindo de uma abordagem simples (Hardcoded) até uma estrutura robusta e escalável utilizando Page Object Model (POM).

## 🚀 Pré-requisitos

- **Node.js**: Certifique-se de ter o Node.js instalado (Versão 12 ou superior).

## 🛠️ Instalação

1. Clone ou baixe este repositório.
2. Abra um terminal na pasta do projeto.
3. Instale as dependências:

```bash
npm install
```

## 🏁 Como Executar

O projeto possui uma aplicação web simples (System Under Test) embutida na pasta `app/`. Para rodar os testes, precisamos que o servidor local esteja rodando.

### 1. Iniciar o servidor local
Em um terminal, execute:

```bash
npm start
```
Isso iniciará a aplicação em `http://localhost:8080`. Mantenha este terminal aberto.

### 2. Abrir o Cypress
Em outro terminal, execute:

```bash
npm run cy:open
```

Isso abrirá a janela do Cypress. Selecione **E2E Testing** e escolha o navegador de sua preferência (ex: Chrome).

## 📂 Estrutura das Aulas

Os testes estão organizados níveis de complexidade para facilitar o ensino:

1.  **Nível 1 - Simples (`cypress/e2e/1-simple`)**:
    -   Código direto, tudo em um arquivo.
    -   Seletores e dados hardcoded.
    -   Ideal para explicar `cy.visit`, `cy.get`, `cy.type`, `cy.click`.

2.  **Nível 2 - Intermediário (`cypress/e2e/2-intermediate`)**:
    -   Introdução a `beforeEach` (Hooks).
    -   Uso de **Custom Commands** (`cy.login()`).
    -   Redução de duplicação de código.

3.  **Nível 3 - Avançado (`cypress/e2e/3-advanced-pom`)**:
    -   **Page Object Model (POM)**: Separação completa da lógica de teste e interação com a página.
    -   **Fixtures**: Dados externos (`users.json`).
    -   Estrutura profissional e escalável.

## 📚 Documentação para o Professor

Consulte a pasta `docs/` para roteiros de aula e explicações detalhadas:
- [Guia de Ensino - Cypress](./docs/ENSINO_CYPRESS.md)

---
*Desenvolvido para ensino de QA Automation.*
