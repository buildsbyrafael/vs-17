# Task 02 (Parte 1): Pipeline Fail-Fast & Quality Gates

Este documento detalha a primeira etapa da atividade de CI/CD, focada na criação de um pipeline otimizado, que implementa a estratégia de **Fail-Fast** para economizar recursos de processamento.

## O que foi implementado neste código?

O `Jenkinsfile` foi desenvolvido para simular um ciclo de validação rigoroso, com as seguintes características:

### 1. Execução Paralela (Parallel Stages)
Utilizamos a diretiva `parallel` para rodar três verificações simultaneamente, ganhando tempo de execução:
* **Lint Backend:** Verifica o padrão de código Java.
* **Lint Frontend:** Verifica regras de TypeScript.
* **Security Scan:** Busca vulnerabilidades (SAST).

> **Recurso Fail-Fast:** Foi ativada a opção `parallelsAlwaysFailFast()`. Se qualquer um desses processos falhar, os outros são cancelados imediatamente.

### 2. Simulação de Testes Unitários (JUnit)
O pipeline gera, via script, um arquivo XML (`relatorio-testes.xml`) contendo propositalmente uma **falha de teste**.

Isso serve para demonstrar a capacidade do Jenkins de ler relatórios e alterar o status do build para `UNSTABLE`.

### 3. Bloqueio Inteligente (Conditional Build)
Antes de gastar recursos, gerando o artefato final (o arquivo `.jar`), o pipeline verifica a saúde do código:

```
if (currentBuild.result == 'UNSTABLE') {
    error("CRÍTICO: Testes falharam! Cancelando Build & Package...")
}