# 📊 Relatórios e Métricas com Allure

**Autor:** Mailton Nascimento

---

## 🧐 O Que é o Allure Report?

Testes automatizados geram milhares de logs que ninguém quer ler. O Allure transforma esses logs em um **Dashboard Gerencial**, permitindo que QAs, Desenvolvedores e Gerentes entendam a saúde do projeto em segundos.

---

## 🚀 Como Gerar o Relatório

Existem duas formas de visualizar o relatório:

### Opção 1: O Jeito "One-Click" (Recomendado)
Vá na pasta `scripts/` e execute:
-   📄 `gerar-relatorio.bat`

Isso vai abrir seu navegador padrão automaticamente com os resultados.

### Opção 2: Via Linha de Comando (Maven)
Se você gosta de terminal:
```bash
mvn allure:serve
```

> **Nota Técnica:** Este comando sobe um servidor web temporário. Para parar, tecle `Ctrl + C` no terminal.

---

## 📈 Entendendo o Dashboard

Quando o relatório abrir, você verá várias abas. Onde focar?

### 1. Overview (Visão Geral)
Mostra quantos testes passaram, falharam ou quebraram.
-   **FAILED (Vermelho)**: Bug real ou falha de asserção (`Assert.assertEquals` falhou).
-   **BROKEN (Amarelo)**: Erro de script (Seletor não encontrado, NullPointer, Timeout). Diferenciar isso é vital!

### 2. Graphs (Gráficos)
Mostra a tendência de execução. Se a linha vermelha está subindo ao longo da semana, a qualidade do software está caindo.

### 3. Suites & Behaviors
-   **Suites**: Agrupa testes pelas classes (ex: `LoginTest`, `CheckoutTest`).
-   **Behaviors**: Agrupa por funcionalidade de negócio (ex: "Fluxo de Venda", "Gestão de Usuário"), se você usar a anotação `@Epic` ou `@Feature` (Opcional, mas recomendado).

---

## 📸 Screenshots e Evidências

O framework está configurado para:
1.  **Capturar Screenshot Automaticamente** sempre que um teste falhar.
2.  Anexar esse print no passo exato do erro dentro do Allure.
3.  Mostrar o **Environment** correto (QA, DEV) graças à nossa configuração dinâmica no `BaseTest`.

---

## 🧹 Limpeza (MUITO IMPORTANTE)

Os resultados ficam acumulados na pasta `target/allure-results`. Se você rodar testes hoje e amanhã sem limpar, o relatório mostrará dados misturados.

**Como limpar antes de rodar:**
Sempre use o comando `clean` do Maven:
```bash
mvn clean test
```
Isso apaga a pasta `target` e garante um relatório fresco e confiável.
