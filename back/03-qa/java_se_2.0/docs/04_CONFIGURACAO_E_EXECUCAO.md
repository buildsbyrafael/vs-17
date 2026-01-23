# ⚙️ Configuração, Execução e Escalabilidade

**Autor:** Mailton Nascimento

---

## 🌍 Gerenciamento de Ambientes (Deep Dive)

O projeto utiliza uma arquitetura de **Configuração em Camadas (Layered Configuration)** para suportar múltiplos ambientes (QA, DEV, PROD) sem duplicação de código.

### 🧠 Como Funciona o `EnvironmentManager`?

Toda vez que um teste inicia, a classe `EnvironmentManager` executa o seguinte algoritmo de decisão:

1.  **Leitura do Parâmetro**: Verifica se você passou `-Dtest.env` na linha de comando.
    *   Se passou (`mvn test -Dtest.env=prod`), ele usa "prod".
    *   Se **NÃO** passou, ele usa o padrão **"qa"** (definido na constante `DEFAULT_ENV`).

2.  **Carregamento em Cascata (Override)**:
    *   **Passo 1**: Carrega `src/main/resources/config/default.properties`.
        *   *Contém*: Configurações globais (Timeouts, Retry, Reports).
    *   **Passo 2**: Carrega `src/main/resources/config/{ambiente}.properties`.
        *   *Contém*: Apenas o que muda (URL, Usuário, Senha).
        *   *Efeito*: Este arquivo **SOBRESCREVE** as chaves do default.

### 📝 Exemplo Prático

Se `default.properties` diz `timeout=10` e `prod.properties` diz `timeout=30`:
- Ao rodar em **QA**: Timeout será 10 (valor do default).
- Ao rodar em **PROD**: Timeout será 30 (valor sobrescrito).

**Comandos de Execução:**
```bash
# QA (Padrão - carrega qa.properties)
mvn clean test

# DEV (carrega dev.properties)
mvn clean test -Dtest.env=dev

# PROD (carrega prod.properties)
mvn clean test -Dtest.env=prod
```

---

## 🚀 Execução em Selenium Grid (Docker)

Esta é a funcionalidade mais avançada do projeto. Permite rodar testes em navegadores que nem precisam estar instalados na sua máquina, usando Containers Docker.

### 1. Subir o Grid
Execute o script (requer Docker Desktop):
```bash
scripts/grid-start.bat
```
Isso vai subir:
-   1 Selenium Hub (Cérebro do Grid)
-   2 Chrome Nodes
-   2 Firefox Nodes
-   1 Edge Node

Acesse `http://localhost:4444` para ver o Grid vivo.

### 2. Configurar o Projeto para usar o Grid
Edite o arquivo `qa.properties` (ou passe via linha de comando):

```properties
execution.mode=grid
grid.enabled=true
grid.url=http://localhost:4444/wd/hub
```

### 3. Executar
Rode os testes normalmente. O `DriverManager` irá detectar o modo `grid` e enviará os testes para o Docker ao invés de abrir o navegador local.

---

## ⚡ Execução Paralela (Multi-Threading)

Para acelerar a execução, podemos rodar vários testes ao mesmo tempo.

**Configuração (`default.properties`):**
```properties
parallel.enabled=true
parallel.threads=4
```
Isso fará o Maven (Surefire) abrir 4 threads simultâneas. Como nosso `BaseTest` usa `ThreadLocal` para o Driver, cada thread terá seu próprio navegador isolado.

**Combinação Poderosa:** Grid + Paralelo = Testes voando! 🏎️💨

---

## 🏷️ Execução por Tags (Categorias)

Você não precisa rodar tudo sempre. Use as categorias para filtrar.

**No Código:**
```java
@Category({Smoke.class, Critical.class})
public void meuTeste() { ... }
```

**Na Execução:**
```bash
# Rodar apenas Smoke Tests (Testes de Fumaça)
mvn clean test -Dgroups=automationexercise.categories.Smoke

# Rodar Regressão Completa
mvn clean test -Dgroups=automationexercise.categories.Regression
```

---

## 📊 Relatórios Allure

Para ver o resultado bonito com gráficos e screenshots:

1.  Rode os testes.
2.  Execute:
    ```bash
    mvn allure:serve
    ```
O navegador abrirá automaticamente com o dashboard.

---

## 🧪 Desafio de Compatibilidade

Quer testar se seu site funciona no Firefox?
Basta alterar uma linha no `properties` ou comando:

```bash
mvn clean test -Dapp.browser=firefox
```

O projeto cuidará de baixar o driver (se local) ou requisitar um Firefox para o Grid (se remoto).
