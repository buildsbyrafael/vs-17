# 🛠️ Preparação do Ambiente e Setup

**Autor:** Mailton Nascimento

---

## 📦 O Que é a Pasta `tools`?

Uma decisão arquitetural importante deste projeto foi a **portabilidade**. 
A pasta `tools/` é onde residem as ferramentas essenciais para rodar o projeto, isoladas do sistema operacional do aluno.

- Isola versões: Todos usam a MESMA versão do Maven e Allure.
- Evita conflitos: Não briga com outras versões instaladas no seu Windows.
- Facilitador: O script `setup-ambiente.ps1` baixa tudo automaticamente para cá.

---

## 🚦 Passo a Passo de Instalação (Automação)

Para começar, você só precisa de **Java 17+** instalado. O resto o projeto faz por você.

### 1. Executar o Script de Setup
Na raiz do projeto, abra o PowerShell e execute:
```powershell
.\setup-ambiente.ps1
```

**O que esse script faz nos bastidores?**
1. Verifica se você tem Java.
2. Baixa o **Maven** (gerenciador de dependências) para `tools/maven`.
3. Baixa o **Allure** (gerador de relatórios) para `tools/allure`.
4. Configura as **Variáveis de Ambiente** TEMPORÁRIAS para essa sessão (Path, MAVEN_HOME).
5. Cria scripts `.bat` facilitadores (`executar-testes.bat`).
6. Pergunta se quer baixar as bibliotecas do projeto (dependências do `pom.xml`).

---

## 🔧 Configuração Manual (Opcional)

Caso queira configurar seu PC manualmente "do zero" para qualquer projeto Java:

1. **Variáveis de Ambiente do Windows**:
   - `JAVA_HOME`: Caminho da instalação do JDK.
   - `MAVEN_HOME`: Caminho da pasta `bin` do Maven.
   - `Path`: Adicionar `%JAVA_HOME%\bin` e `%MAVEN_HOME%\bin`.

2. **Git**:
   - Ter Git instalado para clocar o repositório.
   - Configurar `git config --global core.longpaths true` (Windows tem limite de caracteres em caminhos).

---

## 🐳 Docker (Para Usuários Avançados)

Se você pretende usar a funcionalidade de **Selenium Grid** ou rodar em containers:

1. Instale o **Docker Desktop**.
2. Garanta que o Docker está rodando (`docker ps` no terminal).
3. O projeto possui um arquivo `docker-compose.yml` na raiz que sobe toda a infraestrutura necessária com um comando:
   ```bash
   scripts/grid-start.bat
   ```

---

## ✅ Checklist de Sucesso

Seu ambiente está pronto quando:
1. [ ] Java 17+ detectado.
2. [ ] Pasta `tools` contém `maven` e `allure`.
3. [ ] Comando `mvn -version` funciona (dentro do terminal do projeto ou após setup).
4. [ ] Dependências baixadas (`mvn clean install -DskipTests` funciona).
