# VS17-HoloNetBuilders
## ⚔️ JavaWars - O Resgate de Grogu

É um projeto de RPG desenvolvido em JAVA utilizando os princípios de POO, arquitetura MVC, Persistência de Dados e jogado diretamente pelo console.

## 📖 História
Há muito tempo atrás, em uma galáxia muito, muito distante, o pequeno Grogu foi sequestrado por Lady Nyx e agora cabe a você desbravar a galáxia e resgatá-lo. Escolha com sabedoria o personagem que irá levá-lo à vitória.

## 🕹️ Como funciona o jogo
O jogador pode escolher entre três classes de personagens:

* **🤺 Jedi:** Personagem com mais força (Foco em ataque)
* **🦁 Wookie:** Personagem furtivo (Equilibrado)
* **🤖 Droid:** Personagem com melhor defesa (Tanque)

Cada personagem terá os seguintes atributos:
* Vida e Vida Máxima
* Nível
* Agilidade
* Força
* Defesa
* Furtividade / Estamina

---

## 🚀 Funcionalidades Implementadas (Detalhes Técnicos)

### 1. Java Stream API & Comparator 🏆
Implementação de um **"Hall da Fama"** no controller. Utilizamos `Stream`, `sorted` e `Comparator` para filtrar e ordenar a lista de heróis vindos do banco de dados, exibindo o personagem mais forte (maior nível) no topo da lista.

### 2. Sistema de Progressão e Recompensas 🎁
* **Level Up Pós-Batalha:** Implementamos a lógica de evolução automática. Ao vencer uma batalha, a classe `LevelUp` recupera a vida do herói e atualiza seus status no banco.
* **Loot Interativo:** A classe `Recompensa` possui lógica de negócio. Ao derrotar inimigos, o jogador escolhe qual atributo (Força, Agilidade, Defesa) deseja aprimorar e essa alteração é persistida.

### 3. Expansão da Campanha e Boss Fight ⚔️
* Campanhas carregadas dinamicamente via Banco de Dados (Tabela `MISSAO`).
* Implementação da **Batalha Final contra Lady Nyx**, exigindo estratégia e evolução prévia.

### 4. Persistência de Dados (JDBC) 💾
O jogo deixou de rodar apenas na memória e agora possui conexão robusta com banco de dados **Oracle**:
* **Conexão:** Uso do padrão Singleton para conexão JDBC.
* **Segurança:** Uso estrito de `PreparedStatement` para evitar SQL Injection.
* **CRUD Completo:**
    * **Create:** Salva heróis e inimigos no banco (gerando IDs via Sequences).
    * **Read:** Carrega heróis, histórico de batalhas e missões.
    * **Update:** Atualiza o progresso do jogador (Nível, Vida, Atributos) após cada fase.
    * **Delete:** Remove personagens e limpa o histórico de batalhas (Cascade/Lógico).

---

## 🏗️ Decisões de Arquitetura

### Padrão MVC (Model-View-Controller)
O projeto separa responsabilidades de forma estrita:
* **model:** Contém a lógica de negócios e representação das tabelas.
* **view:** Gerencia toda a interface com o usuário (Console).
* **controller:** Orquestra o fluxo. O `JogoController` agora delega a persistência para os Repositórios.

### Padrão Repository (Data Access)
Adicionamos uma camada para isolar o código SQL:
* **Repository:** Classes responsáveis exclusivamente por acessar o banco (`PersonagemRepository`, `InimigoRepository`, `BatalhaRepositorio`, `MissaoRepository`). O Controller não conhece SQL, apenas chama métodos como `.adicionar()` ou `.listar()`.

---

## 📂 Mapeamento de Arquivos

Abaixo, a localização das classes principais atualizadas:

### 📦 Pacote: `JavaWars` (Raiz)
* `Main.java`: Ponto de entrada.

### 📦 Pacote: `controller`
* `JogoController.java`: Cérebro do jogo. Conecta View e Repositories.

### 📦 Pacote: `repository` (Novo)
* `ConexaoBancoDeDados.java`: Configuração do JDBC e credenciais Oracle.
* `*Repository.java`: Classes que executam o CRUD.

### 📦 Pacote: `model`
* Entidades que espelham as tabelas do banco (`Personagem`, `Inimigo`, `Missao`, `Batalha`).

### 📦 Pacote: `view`
* `HistoriaView.java`: Centraliza narrativa.
* `MenuView.java`: Menus interativos.

---

## 📝 Histórico de Atualizações

### [Etapa II & III] - Lógica e POO
* Implementação de Classes, Herança, Polimorfismo e Interfaces.

### [Etapa IV] - Refatoração MVC
* Organização do projeto em camadas e Java Streams.

### [Etapa Final] - Banco de Dados (Atual)
* **feat:** Integração JDBC com Oracle.
* **feat:** Criação de tabelas `PERSONAGEM`, `INIMIGO`, `BATALHA`, `MISSAO`.
* **feat:** Implementação de `Repository Pattern`.
* **fix:** Tratamento de erros com `BancoDeDadosException` customizada.

---

## 🛠️ Pré-requisitos de Ambiente

Para rodar este projeto, você precisará de:

1.  **Java JDK 17+**
2.  **Docker Desktop** (Para rodar o banco Oracle)
3.  **DBeaver** ou **SQL Developer** (Para gerenciar o banco e rodar scripts)
4.  **Git**

## 🚀 Como executar o jogo (Passo a Passo)

### 1. Configurando o Banco de Dados (Docker) 🐳
Antes de abrir o Java, precisamos do banco rodando.

1.  Abra seu terminal e suba um container Oracle XE (exemplo de imagem comum):
    ```bash
    docker run -d --name bd-oracle -p 1521:1521 --restart=unless-stopped -e ORACLE_ALLOW_REMOTE=true -e ORACLE_PASSWORD=oracle -e RELAX_SECURITY=1 -v bd-oracle:/u01/app/oracle epiclabs/docker-oracle-xe-11g
    ```
2.  Abra o **DBeaver**, conecte-se ao banco (`localhost`, porta `1521`, SID `xe` ou `ORCLCDB`, user `system`, senha `oracle`).
3.  Crie o usuário/schema para o jogo rodando este SQL:
    ```sql
    CREATE USER JAVAWARS IDENTIFIED BY oracle;
    GRANT CONNECT, RESOURCE, CREATE VIEW TO JAVAWARS;
    GRANT UNLIMITED TABLESPACE TO JAVAWARS;
    ```
4.  Desconecte o `system` e conecte-se agora usando o usuário `JAVAWARS`.
5.  **Execute o script de criação:** Pegue o arquivo `script(versao2).sql` na raiz do projeto e rode no DBeaver para criar as tabelas e sequences.

### 2. Configurando o Projeto Java ☕

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/vemser/VS17-HoloNetBuilders.git](https://github.com/vemser/VS17-HoloNetBuilders.git)
    ```
2.  **Importe na IDE:** Abra a pasta raiz. Marque a pasta `src` como *Sources Root*.
3.  **Dependência JDBC:**
    * Vá em `File > Project Structure > Modules > Dependencies`.
    * Adicione o arquivo `.jar` do **ojdbc** (geralmente `ojdbc8.jar` ou `ojdbc11.jar`) que está na pasta `lib` ou baixe-o.
4.  **Verifique a Conexão:**
    * Abra `src/repository/ConexaoBancoDeDados.java`.
    * Confirme se `USER`, `PASS` e `SCHEMA` estão iguais aos que você criou no Docker (ex: `JAVAWARS`).
5.  **Execute:**
    * Rode a classe `Main.java`.
    * **Que a força esteja com você!**

---

## 🔗 Links úteis

* Fluxograma: [https://www.canva.com/design/DAG6j4KVH8k/MiJODPEhiuIhoBOWy-md4g/edit]
* Diagrama UML: [https://drive.google.com/file/d/1Act2iVWiDrCmKzttJNlbNTfzxF6Ta3yT/view?usp=sharing]
* Apresentação: [https://onedrive.live.com/personal/06f3405940b2f7a6/_layouts/15/Doc.aspx?sourcedoc=%7B045d1f12-10dd-4e6a-a667-055b1b00e45b%7D&action=default&redeem=aHR0cHM6Ly8xZHJ2Lm1zL3AvYy8wNmYzNDA1OTQwYjJmN2E2L0VSSWZYUVRkRUdwT3BtY0ZXeHNBNUZzQlNRVExqdEhQMWpVWjRGcHRYanlYRVE_ZT1TMWEzMmE&slrid=defde0a1-2085-a000-d6f4-2d02c24fd506&originalPath=aHR0cHM6Ly8xZHJ2Lm1zL3AvYy8wNmYzNDA1OTQwYjJmN2E2L0VSSWZYUVRkRUdwT3BtY0ZXeHNBNUZzQlNRVExqdEhQMWpVWjRGcHRYanlYRVE_cnRpbWU9QTdld3pFczIza2c&CID=485d78ba-1488-45d0-a740-de1dee07168a&_SRM=0:G:256&file=HoloNetBuilders.pptx]