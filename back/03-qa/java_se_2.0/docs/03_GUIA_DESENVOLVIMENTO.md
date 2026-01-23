# 💻 Guia de Desenvolvimento: Criando um Teste do Zero

**Autor:** Mailton Nascimento

---

## 👨‍� Introdução: Pensando como Engenheiro de QA

Automatizar testes não é apenas fazer o robô clicar. É criar **código robusto, escalável e de fácil manutenção**. 

Neste guia, você não aprenderá apenas os comandos, mas os **motivos de design** por trás de cada decisão do nosso framework. Siga este fluxo para garantir que seu código seja profissional.

---

## 1. Estrutura da Classe de Teste

Quando você cria um arquivo em `src/test/.../tests`, siga este padrão. Entenda o porquê de cada linha:

```java
@PagePath("/checkout") // (3)
public class CheckoutTest extends BaseTest { // (1)
    
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test // (2)
    @Category({Smoke.class, Regression.class}) // (4)
    public void validarCompra() { ... }
}
```

### 🧠 Por que fazemos assim?

1.  **`extends BaseTest` (Herança):**
    *   **O Conceito:** Não queremos repetir código ("Don't Repeat Yourself").
    *   **O Motivo:** A classe `BaseTest` é preparada para fazer o trabalho sujo: abrir o navegador, configurar timeouts e fechar tudo no final. Ao herdar dela, seu teste ganha esses superpoderes automaticamente sem você escrever uma linha de setup.

2.  **`@Test` (Anotação JUnit):**
    *   **O Conceito:** Metadados.
    *   **O Motivo:** O Java não sabe o que é um teste e o que é um método comum. Essa anotação avisa ao JUnit: *"Ei, execute este método e me diga se passou ou falhou!"*.

3.  **`@PagePath("/url")` (Otimização):**
    *   **O Conceito:** Deep Linking (Links Profundos).
    *   **O Motivo:** Se você vai testar o Checkout, por que perder tempo logando na Home, clicando no Carrinho, depois em Finalizar? Use `@PagePath` para o robô abrir o navegador direto na URL que interessa. Economiza tempo e reduz pontos de falha.

4.  **`@Category` (Organização):**
    *   **O Conceito:** Estratégia de Execução.
    *   **O Motivo:** Em grandes empresas, temos milhares de testes. Não dá para rodar tudo a toda hora. As categorias permitem rodar apenas o que é crítico (`Smoke`) antes de um deploy rápido, ou tudo (`Regression`) de madrugada.

---

## 2. Page Objects e Seletores: A Arte de Encontrar Elementos

No Page Object (pasta `pages/`), sua missão é mapear a tela. A escolha do seletor define se seu teste será **robusto** ou **frágil**.

### 🏆 Hierarquia de Ouro dos Seletores

Sempre tente encontrar elementos nesta ordem de prioridade:

1.  🥇 **`By.id`**:
    *   **Por que:** É o CPF do elemento. Único e extremamente rápido para o navegador encontrar.
2.  🥈 **`By.name`**:
    *   **Por que:** Muito comum em formulários, geralmente é único dentro de um form.
3.  🥉 **`By.cssSelector`**:
    *   **Por que:** O "Canivete Suíço". Poderoso para encontrar elementos complexos (ex: `.btn-primary[type='submit']`). Mais rápido e legível que o XPath.
4.  ☠️ **`By.xpath`** (Evite ao máximo!):
    *   **Por que:** É lento e frágil. Se o desenvolvedor mudar uma `div` de lugar, seu XPath gigante (`/div/div[2]/span/a`) quebra. Use apenas se não houver outra opção.

### 📝 Nomes Variáveis Descritivos

*   ❌ `By x = By.id("btn");` -> Daqui a 2 semanas, você não saberá o que é `x`.
*   ✅ `By btnFinalizarCompra = By.id("btn");` -> O código documenta a si mesmo.

---

## 3. Os 4 Mandamentos das Boas Práticas

Para ser um QA Sênior, você deve seguir estas regras religiosamente:

### 1. Independência (Atomocidade)
*   **Regra:** O "Teste B" nunca pode depender do sucesso do "Teste A".
*   **O Porquê:**
    *   Se rodarmos em paralelo (vários ao mesmo tempo), a ordem de execução muda.
    *   Se o Teste A falhar, ele não pode derrubar o Teste B (Efeito Dominó).
    *   Cada teste deve abrir seu navegador, criar seus dados, testar e fechar.

### 2. Massa de Dados Dinâmica
*   **Regra:** Nunca use "teste@gmail.com" ou "João". Use `DataFaker`.
*   **O Porquê:**
    *   Na primeira vez funciona. Na segunda, o sistema grita: *"Erro: Usuário já cadastrado!"*.
    *   Dados estáticos matam a automação recorrente. Dados dinâmicos garantem um "usuário novo" a cada execução.

### 3. Waits Inteligentes (NUNCA use Thread.sleep)
*   **Regra:** Proibido usar `Thread.sleep(5000)`. Use os métodos do `BasePage`.
*   **O Porquê:**
    *   **Sleep(5000)**: Você força o teste a parar 5 segundos, mesmo que a página carregue em 1 segundo. Você desperdiçou 4 segundos. Multiplique isso por 1000 testes e você perdeu horas.
    *   **Explicit Wait (WaitHelper)**: "Espere *ATÉ* o botão aparecer (máximo 10s)". Se aparecer em 0.5s, o teste segue. É performance pura.

### 4. Logs e Rastreabilidade
*   **Regra:** Deixe o framework trabalhar por você.
*   **O Porquê:**
    *   Quando um teste falha no servidor (CI/CD) de madrugada, você não estará lá vendo a tela.
    *   Os logs (Console e Relatório Allure) são sua "Caixa Preta" de avião. Eles contam a história do que aconteceu passo a passo para você corrigir o bug rapidamente.

---

## � Resumo do Workflow

1.  **Mapear**: Vá na página, inspecione e ache o melhor ID ou CSS.
2.  **Abstrair**: Crie a classe Page Object e coloque os seletores lá.
3.  **Automatizar**: Crie o Teste usando os métodos do Page Object.
4.  **Validar**: Use `Assert` para garantir que o resultado esperado ocorreu.

---

## 4. Suites de Teste: Suas "Playlists" de Execução

Imagine que você tem 500 testes. Você não quer rodar todos eles toda vez que mudar uma vírgula no código. Para isso, usamos as **Suites** na pasta `src/test/java/automationexercise/suites`.

### 🎵 O Que é uma Suite?
É uma classe Java que agrupa e executa outros testes. Pense nela como uma playlist do Spotify:
-   **RegressionSuite**: Toca TUDO (revisão completa).
-   **SmokeSuite**: Toca só os "Hits" (testes essenciais).

### 📝 Exemplo de Suite (SmokeSuite.java)

```java
@RunWith(Categories.class)
@Categories.IncludeCategory(Smoke.class) // Filtra apenas testes @Smoke
@Suite.SuiteClasses({
    LoginTest.class,     // Adicione suas classes de teste aqui
    CheckoutTest.class
})
public class SmokeSuite {
    // Classe vazia, serve apenas como agrupador
}
```

### 🧠 Por que usar Suites?
1.  **Foco**: Se você está mexendo no Login, rode apenas a Suite de Login.
2.  **Velocidade**: Uma Suite Smoke roda em 2 minutos. A Regressão completa pode levar 1 hora.
3.  **Organização**: No Jenkins (CI/CD), configuramos Jobs diferentes para Suites diferentes. O Job "Deploy Rápido" chama a `SmokeSuite`.

Para rodar uma suite via Maven:
```bash
mvn clean test -Dtest=SmokeSuite
```
