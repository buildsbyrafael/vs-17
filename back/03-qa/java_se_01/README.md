# Desafio #01 - Automação de Testes (Java SE)

Projeto de automação para o site **Automation Exercise**, utilizando **Selenium WebDriver**, **Java** e **TestNG**, estruturado no padrão **Page Object Model (POM)**.

## Plano de Automação (Escopo)

O objetivo deste projeto é garantir a qualidade dos fluxos críticos. Foram priorizados os seguintes cenários:

1.  **Login com Sucesso:** Valida acesso com credenciais válidas.
2.  **Falha de Login:** Valida mensagem de erro para credenciais inválidas.
3.  **Logout:** Garante que o usuário consegue sair do sistema.
4.  **Validação de Cadastro (Duplicidade):** Garante que não é possível cadastrar e-mail já existente.
5.  **Formulário de Contato:** Valida o envio de mensagens pelo "Contact Us".
6.  **Página de Test Cases:** Verifica acessibilidade da página de casos de teste.
7.  **Cadastro de Usuário (E2E):** Fluxo completo de criação de conta.
8.  **Exclusão de Conta (E2E):** Fluxo de ciclo de vida (Criar + Deletar) para garantir limpeza de dados.
9.  **Pesquisa de Produtos:** Valida a funcionalidade de busca do catálogo.
10. **Detalhes do Produto:** Valida a exibição das especificações do produto.

## Tecnologias Utilizadas

* **Linguagem:** Java 17.
* **Framework de Teste:** TestNG.
* **Automação Web:** Selenium WebDriver (4.27.0).
* **Gerenciador de Dependências:** Maven.
* **Padrão de Projeto:** Page Object Model (POM).

## Como Executar?

1.  Clone o repositório.
2.  Abra o projeto na sua IDE (IntelliJ/Eclipse).
3.  Espere o Maven baixar as dependências.
4.  Execute a suíte de testes:
    * Pela IDE: Clique direito na pasta `src/test/java` + **Run 'All Tests'**.
    * Via linha de comando: `mvn test`.