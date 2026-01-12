# Task 02 (Parte 2): Pipeline de Análise com SonarQube (POC)

Este diretório contém a Prova de Conceito (POC) da integração contínua do projeto **JavaWars** com o **SonarQube**, implementando um Quality Gate que bloqueia o pipeline em caso de falha (na qualidade).

## Localização do Jenkinsfile

O arquivo de pipeline, utilizado nesta entrega, encontra-se dentro da pasta do projeto:

`back/03-qa/ci_cd/task02/part02/VS17-HoloNetBuilders/Jenkinsfile`

## O que foi implementado?

1.  **Scanner Manual:** Configuração do `sonar-scanner` via script, para analisar o projeto Java (sem gerenciadores como Maven/Gradle).
2.  **Quality Gate Restritivo:** Aplicação de uma regra de **Cobertura de Código < 80%** (Gate Impossivel) para forçar a reprovação, já que o projeto atual não possui testes unitários.
3.  **Pipeline Bloqueante:** O Jenkins aguarda o veredito do SonarQube (`waitForQualityGate`) e aborta a execução (`abortPipeline: true`) se o código for reprovado.

## Evidências

As evidências de execução encontram-se neste diretório (imagens), demonstrando:
* **Jenkins:** Pipeline interrompido com status de falha/abortado.
* **SonarQube:** Dashboard indicando `FAILED`, devido à cobertura ser 0.0%.

---
*Por Rafael Linhares.*