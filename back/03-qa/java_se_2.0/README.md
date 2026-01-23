# 🚀 Automação de Testes com Selenium + Java

> Projeto educacional de automação de testes para alunos de QA

[![Java](https://img.shields.io/badge/Java-8+-orange.svg)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.17.0-green.svg)](https://www.selenium.dev/)
[![Maven](https://img.shields.io/badge/Maven-3.9.6-blue.svg)](https://maven.apache.org/)
[![Allure](https://img.shields.io/badge/Allure-2.25.0-yellow.svg)](https://docs.qameta.io/allure/)

---

## 🎯 Para Alunos: Comece Aqui!

### ⚡ Configuração Rápida (5 minutos)

1. **Certifique-se que tem Java instalado**
   ```powershell
   java -version
   ```
   Se não tiver, baixe em: https://adoptium.net/

2. **Execute o script de configuração**
   ```powershell
   .\setup-ambiente.ps1
   ```
   
   💡 **Se der erro**, execute primeiro:
   ```powershell
   Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy RemoteSigned
   ```

3. **Pronto! Agora execute os testes**
   ```
   Clique duas vezes em: scripts\executar-testes.bat
   ```

4. **Veja o relatório**
   ```
   Clique duas vezes em: scripts\gerar-relatorio.bat
   ```

📖 **Guia Completo para Alunos**: [GUIA_ALUNOS.md](GUIA_ALUNOS.md)

---

## 📚 O Que Este Projeto Faz?

Este projeto automatiza testes de uma aplicação web usando:
- 🌐 **Selenium**: Controla o navegador automaticamente
- ☕ **Java**: Linguagem de programação
- 🧪 **JUnit**: Framework para executar testes
- 📊 **Allure**: Gera relatórios bonitos e detalhados
- 🏭 **Maven**: Gerencia dependências e execução

---

## 🗂️ Estrutura do Projeto (Simplificada)

```
📦 automacao-testes/
│
├── 📁 src/
│   ├── 📁 main/java/              # Código de suporte
│   │   ├── config/                # Configurações (dev, qa, prod)
│   │   ├── driver/                # Gerenciamento do navegador
│   │   ├── data/                  # Dados de teste
│   │   └── util/                  # Utilitários
│   │
│   └── 📁 test/java/              # 🎯 SEUS TESTES FICAM AQUI
│       ├── page/                  # Páginas da aplicação
│       ├── test/                  # Classes de teste
│       └── support/               # Helpers e validações
│
├── 📁 tools/                      # Maven e Allure (auto-instalado)
├── 📁 scripts/                    # Scripts de atalho
├── 📁 docs/                       # Documentação completa
│
├── 📄 setup-ambiente.ps1          # ⚡ Execute este primeiro!
├── 📄 GUIA_ALUNOS.md              # 📖 Guia para alunos
└── 📄 pom.xml                     # Configuração do Maven
```

---

## 🎓 Como Criar Seu Primeiro Teste

### 1️⃣ Criar a Página (Page Object)

📁 `src/test/java/page/CadastroPage.java`

```java
package automationexercise.page;

import org.openqa.selenium.By;

public class CadastroPage extends BasePage {
    
    // Elementos
    private static final By campoNome = By.id("name");
    private static final By btnCadastrar = By.id("submit");
    
    // Ações
    public CadastroPage preencherNome(String nome) {
        preencherInput(campoNome, nome);
        return this;
    }
    
    public CadastroPage clicarCadastrar() {
        clicar(btnCadastrar);
        return this;
    }
}
```

### 2️⃣ Criar o Teste

📁 `src/test/java/test/CadastroTest.java`

```java
package automationexercise.test;

import automationexercise.page.CadastroPage;
import org.junit.Test;

public class CadastroTest extends BaseTest {
    
    CadastroPage cadastroPage = new CadastroPage();
    
    @Test
    public void testCadastroComSucesso() {
        cadastroPage
            .preencherNome("João Silva")
            .clicarCadastrar();
    }
}
```

### 3️⃣ Executar

```powershell
mvn clean test -Dtest=CadastroTest
```

Ou clique em: `scripts\executar-testes.bat`

---

## 🎯 Comandos Úteis

### Via Scripts (Mais Fácil)

| Script | O Que Faz |
|--------|-----------|
| `scripts\executar-testes.bat` | Executa todos os testes |
| `scripts\gerar-relatorio.bat` | Gera relatório Allure |
| `scripts\executar-ambiente.bat` | Escolhe ambiente (dev/qa/prod) |

### Via Linha de Comando

```powershell
# Executar todos os testes
mvn clean test

# Executar teste específico
mvn clean test -Dtest=LoginTest

# Executar em ambiente DEV
mvn clean test -Dtest.env=dev

# Gerar relatório Allure
mvn allure:serve
```

---

## 📊 Relatórios Allure

Após executar os testes, gere o relatório:

```powershell
mvn allure:serve
```

Ou clique em: `scripts\gerar-relatorio.bat`

O navegador abrirá automaticamente mostrando:
- ✅ Testes que passaram
- ❌ Testes que falharam
- 📸 Screenshots automáticos
- 📈 Gráficos e estatísticas

![Exemplo de Relatório Allure](https://docs.qameta.io/allure/images/tab_overview.png)

---

## 🌍 Ambientes

O projeto suporta 3 ambientes:

| Ambiente | Arquivo | Como Usar |
|----------|---------|-----------|
| **DEV** | `config/dev.properties` | `mvn test -Dtest.env=dev` |
| **QA** | `config/qa.properties` | `mvn test` (padrão) |
| **PROD** | `config/prod.properties` | `mvn test -Dtest.env=prod` |

Cada ambiente tem suas próprias:
- 🌐 URLs
- 👤 Credenciais de teste
- ⚙️ Configurações

---

## 📖 Documentação

### Para Alunos
- 📘 [GUIA_ALUNOS.md](GUIA_ALUNOS.md) - **Comece aqui!**
- 📗 [docs/QUICK_START.md](docs/QUICK_START.md) - Início rápido
- 📙 [docs/GUIA_DESENVOLVIMENTO.md](docs/GUIA_DESENVOLVIMENTO.md) - Guia completo

### Para Instrutores
- 📕 [docs/RESUMO_EXECUTIVO.md](docs/RESUMO_EXECUTIVO.md) - Visão estratégica
- 📔 [docs/ANALISE_PROJETO.md](docs/ANALISE_PROJETO.md) - Análise técnica
- 📓 [docs/PLANO_MELHORIAS.md](docs/PLANO_MELHORIAS.md) - Roadmap
- 📒 [docs/ANALISE_SIMPLIFICACAO.md](docs/ANALISE_SIMPLIFICACAO.md) - Simplificação

### Índice Completo
- 📚 [docs/INDEX.md](docs/INDEX.md) - Índice de toda documentação

---

## ❓ Problemas Comuns

### Maven não reconhecido

**Solução**: Execute o script de configuração novamente:
```powershell
.\setup-ambiente.ps1
```

### Java não encontrado

**Solução**: 
1. Instale o Java: https://adoptium.net/
2. Reinicie o PowerShell
3. Execute: `java -version`

### Testes não executam

**Solução**:
```powershell
# Baixar dependências
mvn clean install -DskipTests

# Tentar novamente
mvn clean test
```

---

## 🎯 Funcionalidades

### ✅ Implementado
- [x] Login com credenciais válidas
- [x] Gestão de múltiplos ambientes (dev, qa, prod)
- [x] Relatórios Allure detalhados
- [x] Screenshots automáticos em falhas
- [x] Configuração automática do ambiente

### 🔄 Em Desenvolvimento
- [ ] Mais testes de login
- [ ] Testes de cadastro
- [ ] Testes de carrinho
- [ ] Execução paralela

---

## 🤝 Contribuindo

### Para Alunos

1. Crie seu teste seguindo os exemplos
2. Execute e valide que funciona
3. Compartilhe com o instrutor

### Para Instrutores

1. Fork o projeto
2. Crie uma branch: `git checkout -b feature/minha-feature`
3. Commit: `git commit -m 'Adiciona nova feature'`
4. Push: `git push origin feature/minha-feature`
5. Abra um Pull Request

---

## 📞 Suporte

### Dúvidas?
- 💬 Pergunte ao instrutor
- 📖 Consulte [GUIA_ALUNOS.md](GUIA_ALUNOS.md)
- 📚 Veja a [documentação completa](docs/INDEX.md)

### Encontrou um Bug?
- 🐛 Reporte ao instrutor
- 📝 Descreva o problema detalhadamente
- 📸 Inclua screenshots se possível

---

## 🎓 Recursos de Aprendizado

### Selenium
- [Documentação Oficial](https://www.selenium.dev/documentation/)
- [Selenium com Java](https://www.selenium.dev/documentation/webdriver/)

### Java
- [Java Tutorial](https://docs.oracle.com/javase/tutorial/)
- [JUnit 4](https://junit.org/junit4/)

### Allure
- [Allure Documentation](https://docs.qameta.io/allure/)
- [Allure Examples](https://demo.qameta.io/allure/)

---

## 📊 Status do Projeto

| Métrica | Valor |
|---------|-------|
| **Testes Ativos** | 1 |
| **Cobertura** | ~10% |
| **Documentação** | ✅ Completa |
| **Ambientes** | 3 (dev, qa, prod) |
| **Nível** | 🎓 Educacional |

---

## 📄 Licença

Este é um projeto educacional para fins de aprendizado.

---

## 🙏 Agradecimentos

- Equipe de QA
- Alunos do curso
- Comunidade Selenium
- Contribuidores

---

<div align="center">

**Feito com ❤️ para alunos de QA**

[⬆ Voltar ao topo](#-automação-de-testes-com-selenium--java)

---

### 🚀 Comece Agora!

1. Execute: `.\setup-ambiente.ps1`
2. Leia: [GUIA_ALUNOS.md](GUIA_ALUNOS.md)
3. Crie seu primeiro teste!

</div>