package view;

import model.*;

import java.awt.*;

public class HistoriaView {

    private static final int LARGURA_PADRAO = 80;
    private static final String MARGEM = "  ";
    private static final long DELAY_PADRAO = 40;
    private static final String RESET = Cores.FUNDO_PRETO + Cores.BRANCO;

    private void mostrarSeparador(String caractere, String cor) {
        System.out.println(cor);
        System.out.println(caractere.repeat(LARGURA_PADRAO));
        System.out.println(RESET);
    }

    private String formatarTexto(String texto) {
        StringBuilder resultado = new StringBuilder();

        int larguraUtil = LARGURA_PADRAO - MARGEM.length();
        String[] linhas = texto.strip().split("\\R");

        for (String linha : linhas) {
            if (linha.isBlank()) {
                resultado.append("\n");
                continue;
            }

            String[] palavras = linha.split(" ");
            int tamanhoLinha = 0;

            resultado.append(MARGEM);
            tamanhoLinha = 0;

            for (String palavra : palavras) {
                if (tamanhoLinha + palavra.length() + 1 > larguraUtil) {
                    resultado.append("\n").append(MARGEM);
                    tamanhoLinha = 0;
                }
                resultado.append(palavra).append(" ");
                tamanhoLinha += palavra.length() + 1;
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

    private void centralizarTexto(String texto, String cor) {
        int padding = (LARGURA_PADRAO - texto.length()) / 2;
        System.out.print(cor);
        System.out.printf("%" + (padding + texto.length()) + "s\n", texto);
        System.out.print(RESET);
    }

    private void imprimirLentamente(String texto) {

        final String FORMATO_PADRAO = RESET;
        String textoFormatado = formatarTexto(texto);
        String[] linhas = textoFormatado.split("\\R");
        System.out.print(FORMATO_PADRAO);

        for (String linha : linhas) {
            for (char caractere : linha.toCharArray()) {
                System.out.print(caractere);
                System.out.flush();

                try {
                    Thread.sleep(HistoriaView.DELAY_PADRAO);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println();
        }
    }


//        ###### Prints da classe Missao ######

    public void voceMorreu() {
        mostrarSeparador("=", Cores.VERMELHO);
        System.out.println(Cores.VERMELHO + "  Você morreu antes de finalizar todas as missões!");
        System.out.println(RESET);
        mostrarSeparador("=", Cores.VERMELHO);
    }

    public void descansoMenu() {
        mostrarSeparador("=", Cores.AMARELO);
        System.out.println(Cores.CIANO);
        System.out.println("    ⛺ ---- Área Segura ----");
        System.out.println("\n  Você deseja fazer um descanso rápido?");
        System.out.println("  [1] Sim, preciso descansar (recupera energia).");
        System.out.println("  [2] Não, quero seguir em frente.");
        System.out.println(RESET);
        mostrarSeparador("=", Cores.AMARELO);
    }

    public void iniciarMissao(Missao missao) {
        System.out.println(Cores.AMARELO);
        System.out.println("  Você iniciou a missão: " + missao.getNome());
        System.out.println(RESET);
    }

    public void mostrarMissao1(Planeta planeta, Missao missao) {
        mostrarSeparador("=", Cores.AMARELO);
        System.out.println(Cores.CIANO + "  PLANETA: "+ planeta.getNome() + Cores.RESETAR);
        System.out.println(Cores.CIANO + "  MISSÃO: " + missao.getNome() + Cores.RESETAR);
        System.out.println(Cores.CIANO + "  OBJETIVO: " + missao.getDescricao() + Cores.RESETAR);
        mostrarSeparador("=", Cores.AMARELO);
    }

    public void mostrarFase1WAMPA() {
        mostrarSeparador("=", Cores.AMARELO);
        centralizarTexto("FASE 1: O POUSO E O GUARDIÃO DA ENTRADA", Cores.AMARELO);
        mostrarSeparador("=", Cores.AMARELO);
        System.out.println(RESET);

        this.imprimirLentamente("""
                Sua nave pousa com dificuldade nos planaltos de gelo.
                O vento uiva a 80km / h.O scanner aponta um sinal de
                calor fraco vindo de uma caverna ao norte, que parece
                ser uma entrada lateral soterrada da antiga base rebelde.
                O frio está drenando a energia do seu traje !
                Você encontra uma caverna e entra nela.
                O vento diminui, mas o cheiro de carne podre é forte.
                Um Wampa, com cicatrizes de queimadura de blaster recentes,
                ruge ao te ver. Alguém esteve aqui antes de você e não foi
                amigável.""");
        mostrarSeparador("=", Cores.AMARELO);
    }

    public void mostrarFase2VORIAN() {
        mostrarSeparador("=", Cores.AMARELO);
        centralizarTexto("FASE 2: A BASE ECHO ABANDONADA", Cores.AMARELO);
        System.out.println(RESET);
        mostrarSeparador("=", Cores.AMARELO);

        this.imprimirLentamente("""
                Você está dentro.
                Corredores de metal enferrujado e gelo.
                Você ouve vozes ecoando no hangar principal:
                - Carreguem logo isso! O império paga o dobro
                por peças de geradores de escudo!
                Você se esconde atrás de uma caixa de suprimentos
                e vê um grupo de saqueadores liderados
                por um homem com um casaco de pele pesado e um rifle 
                modificado.""");
    }

    public void mostrarVorianDialogo() {
        mostrarSeparador("=", Cores.AMARELO);
        centralizarTexto("O CONTRABANDISTA VORIAN", Cores.AMARELO);
        System.out.println(RESET);
        mostrarSeparador("=", Cores.AMARELO);
        this.imprimirLentamente("- Ora, ora... Um héroi? Ou só mais um concorrente? Não importa." +
                "Essa sucata é minha, e a informação que eu tenho vale mais que a sua vida\n");
        mostrarSeparador("=", Cores.AMARELO);
    }

    public void mostrarVorianRendimento() {
        mostrarSeparador("=", Cores.AMARELO);
        this.imprimirLentamente("""
                 Vorian cai de joelhos, largando o rifle:
                - Espere! Não atire! Eu falo! Eu sou só um intermediário!
                Ele joga um datapad (tablet) aos seus pés:
                - O Império... Eles não estão só procurando. Eles contrataram
                caçadores de recompensa.
                O próximo ponto de encontro deles é no palácio do Hutt!""");

        mostrarSeparador("=", Cores.AMARELO);
    }

    public void mostrarFase3Inicio() {
        mostrarSeparador("=", Cores.AMARELO);
        System.out.println(Cores.AMARELO);
        System.out.println("FASE 3: A DISTRAÇÃO");
        System.out.println(RESET);
        mostrarSeparador("=", Cores.AMARELO);
        this.imprimirLentamente("""
                Seguindo os dados de Vorian, você chega aos portões do Posto Avançado
                de Gorga. O lugar parece estranhamente vazio de guardas de elite.
                Apenas alguns Gamorreanos bêbados, envoltos em peles grossas, vigiam a
                entrada. Você derruba os guardas e acessa o terminal de agendamentos do 
                saguão.""");
        System.out.println("""
                  **********************************************************************
                  *                                                                    *
                  *    REGISTRO ENCONTRADO:                                            *
                  *                                                                    *
                  *    Reunião do Moff Imperial alterada.                              *
                  *    Local: Instalação Geotérmica Central 4 (O Coração Quente)       *
                  *    Motivo: Inspeção da nova remessa de Geradores de Energia.       *
                  *                                                                    *
                  *                                                                    *
                  **********************************************************************""");

        this.imprimirLentamente("""
                Você percebe: O Posto é uma distração.
                O Império está comprando a energia vital do planeta para alimentar seus
                Destróieres e Gorga está lá supervisionando.""");
    }

    public void mostrarFase4Durasteel() {
        mostrarSeparador("=", Cores.AMARELO);
        centralizarTexto("FASE 4: DURASTEEL", Cores.AMARELO);
        System.out.println(RESET);
        mostrarSeparador("=", Cores.AMARELO);
        this.imprimirLentamente("""
                Você invade a instalação industrial, encravada em uma montanha de gelo.
                É uma mistura de tubulações congeladas e alta tecnologia imperial roubada.
                Você está dentro. As paredes são de durasteel, e a alta concentração de
                energia faz o ar estalar.
                Você ouve o zumbido constante dos reatores. Corredores claustrofóbicos se
                estendem à frente, repletos de tubulações maciças de vapor.
                Até que você passa pelo último corredor e emerge em um vasto hangar subterrâneo.
                A visão é impressionante: uma caverna artificial com luzes fracas, onde uma
                passarela metálica se estende sobre um abismo.
                Abaixo, você vê o gigantesco Núcleo Geotérmico.
                No centro, sobre uma plataforma repulsora adornada com armas e troféus Wookiee,
                está Gorga, o Hutt.""");
    }

    public void mostrarGorganDialogo() {
        this.imprimirLentamente("""
                - Você veio até o meu tesouro, verme!
                - Nenhum Jedi ou caçador de recompensas vai estragar meu negócio com o Império.
                - Prepare-se para morrer!""");
        mostrarSeparador("=", Cores.AMARELO);
    }

    public void mostrarGorganFinal() {
        this.imprimirLentamente("""
                Com um último esforço, você acerta o ponto fraco da Plataforma Repulsora
                de Gorga. O motor do aparelho explode em faíscas azuis. Gorga grita, e a
                plataforma descontrolada não cai no Núcleo... ela se choca com força total 
                contra o Painel de Controle Principal do Reator!""");

        this.imprimirLentamente("""
                O painel explode.
                
                O durasteel racha e em instantes o fluxo de energia não é mais contido.
                O som da pressão de vapor geotérmico é ensurdecedor.
                O CALOR FOI LIBERADO!
                
                Você é atingido pela onda de choque e vapor que jorra para fora da montanha.
                Enquanto o calor começa a subir, estabilizando a temperatura da base, você se
                agarra a um pedaço de sucata. O corpo de Gorga e sua plataforma são incinerados
                pelo vapor, mas antes que desapareçam, você consegue arrancar de seus restos um
                Datapad Imperial.""");

        System.out.println("""
                  ***********************************************************************************\
                  *                                                                                 *\
                  *          Últimas transações:                                                    *\
                  *    Pagamento autorizado: Moff Gideon                                            *\
                  *    Entrega do ativo: completa                                                   *\
                  *    Destino: Bunker Imperial Secreto B-4 – Setor da Cratera Gelada de Hoth'      *\
                  *    Observação: Lady Nix aguarda a reprogramação do ativo.                       *\
                  *                                                                                 *\
                  ***********************************************************************************""");
    }

    public void mostrarFaseFinalInicio() {
        mostrarSeparador("=", Cores.AMARELO);
        centralizarTexto("FASE 4: A CONCLUSÃO", Cores.AMARELO);
        System.out.println(RESET);
        mostrarSeparador("=", Cores.AMARELO);
        this.imprimirLentamente("""
                Você localiza a entrada do Bunker Imperial B-4, escondida no coração
                da Cratera Gelada. É uma estrutura de durasteel negro, com paredes
                reforçadas para suportar bombardeio orbital. Este é o último lugar de Hoth.
                
                Um alarme silencioso dispara. Duas torres de defesa a laser emergem da neve,
                e três Droides de entinela armados deslizam em sua direção. Não há como passar
                despercebido. Você destrói as sentinelas e abate os droides, forçando o sistema
                de segurança.
                
                A porta principal de explosão de 2 metros de espessura começa a se abrir com um
                ruído de sucção. Você irrompe, com seu blaster fumegante na mão, na câmara central
                do bunker. O contraste com o exterior gelado é chocante: o ar aqui é quente,
                pressurizado e cheira a ozônio e tecnologia avançada. A sala é escura, iluminada
                apenas por luzes de serviço vermelhas.
                No centro da câmara, atrás de uma barreira de força pulsante que crepita com energia
                escura, está a figura que você procurava.
                
                Lady Nix é imponente.
                
                Ela veste uma armadura negra elegante, polida, com detalhes em vermelho carmesim,
                e uma capa pesada sobre os ombros. Ela não está olhando para você; seus olhos estão
                fixos em um pequeno berço flutuante que oscila ao seu lado.
                Lady Nix vira-se lentamente, sua expressão é fria, de desdém total. 
                Ela não está surpresa. 
                
                - Longe demais para um herói, forçando sua entrada pelo meu playground congelado.
                Ela gesticula em direção ao berço flutuante.
                
                -O Pequeno Ativo estava seguro aqui, bem no nariz do resto da Galáxia. Graças ao idiota
                do Gorga e seus esquemas de aquecimento, ele forneceu a energia perfeita para este escudo.
                Mas agora... Ela aperta o punho, e o crepitar da barreira de força se intensifica.
                -...agora você vai ser meu último experimento. A energia que você liberou no planeta será 
                absorvida pelo meu laboratório.
                Você é o último obstáculo antes que eu entregue meu projeto ao Império.
                Seus olhos encontram o pequeno ser no berço flutuante.
                
                Grogu te observa com seus grandes olhos verdes, assustado, mas esperando.""");
    }

    public void mostrarFinalJogo() {
        mostrarSeparador("=", Cores.VERDE);
        this.imprimirLentamente("""
                
                A barreira de força cai.
                Lady Nix está derrotada.
                Você se aproxima do berço flutuante.
                A Grogu, assustado, estende a mão para você.""");

        System.out.print(Cores.VERDE);
        System.out.println("""
                
                **********************************************************************************************
                
                MISSÃO CUMPRIDA! O Império está fora de Hoth, o calor está de volta, e Grogu está a salvo!
                
                *********************************************************************************************""");
        System.out.println(Cores.VERDE);
        AsciiArt.heroiVenceu();
    }

    public void mostrarTesteAtributo(Missao missao) {
        System.out.println(Cores.CIANO);
        this.imprimirLentamente("  Será necessário o atributo: " + missao.getAtributoNecessario());
        System.out.println(RESET);
    }

    public void mostrarResultadoDado(int rolarNormal, int bonus, String atributoNecessario) {
        System.out.println(Cores.CIANO);
        this.imprimirLentamente("  Resultado do dado " + rolarNormal + " e bonus de " + bonus + " devido ao seu atributo de " + atributoNecessario);
        System.out.println(RESET);
    }

    public void mostrarSucessoTeste() {
        mostrarSeparador("*", Cores.VERDE);
        this.imprimirLentamente("  Você teve sucesso! Passou sem a necessidade de lutar!");
        System.out.println(RESET);
        mostrarSeparador("*", Cores.VERDE);
    }

    public void mostrarFalhaTeste() {
        mostrarSeparador("*", Cores.VERMELHO);
        System.out.println(Cores.VERMELHO);
        this.imprimirLentamente("  Você falhou! Combate irá iniciar!");
        System.out.println(RESET);
        mostrarSeparador("*", Cores.VERMELHO);
    }

    public void mostrarCombateDireto() {
        mostrarSeparador("*", Cores.AMARELO);
        this.imprimirLentamente("\n  Batalha direta! Impossível de evitar!");
        System.out.println(RESET);
        mostrarSeparador("*", Cores.AMARELO);
    }

    public void mostrarDescanso() {
        System.out.println(Cores.VERDE);
        System.out.println("\n  ***** ENERGIA RECUPERADA! *****");
        System.out.println(RESET);
    }

    public void descansoIgnorado() {
        System.out.println(Cores.VERDE);
        System.out.println("\n  ***** Você segue sem descansar. *****");
        System.out.println(RESET);
    }

// ###### Prints da classe Batalha ######

    public void mostrarInicioCombate(String nomeJogador, String nomeInimigo) {
        System.out.println("\n");
        mostrarSeparador("=", Cores.AMARELO);
        System.out.print(Cores.AMARELO);
        String mensagem = "COMBATE INICIADO: " + nomeJogador + " vs " + nomeInimigo;
        int padding = (LARGURA_PADRAO - mensagem.length()) / 2;
        System.out.printf("%" + (padding + mensagem.length()) + "s\n", mensagem);
        System.out.print(RESET);
        mostrarSeparador("=", Cores.AMARELO);
        System.out.println();
    }

    public void mostrarVitoria(String nomeInimigo) {
        mostrarSeparador("=", Cores.VERDE);
        System.out.print(Cores.VERDE);
        centralizarTexto(" === VITÓRIA! O inimigo " + nomeInimigo + " foi derrotado! === ", Cores.VERDE);
        System.out.print(RESET);
        mostrarSeparador("=", Cores.VERDE);
    }

    public void mostrarDerrota() {
        mostrarSeparador("=", Cores.VERMELHO);
        System.out.print(Cores.VERMELHO);
        System.out.println(" === DERROTA... você caiu em combate. === ");
        System.out.print(RESET);
        mostrarSeparador("=", Cores.VERMELHO);
    }

    public void mostrarStatus(Personagem jogador, Atacavel inimigo) {
        mostrarSeparador("=", Cores.CIANO);
        System.out.print(Cores.AMARELO);
        System.out.println("  STATUS ATUAL");
        mostrarSeparador("-", Cores.CIANO);
        System.out.printf(Cores.CIANO + "  %-15s " + RESET + "| HP: " + Cores.VERDE + "%-3d/%-3d " + RESET + "| STA: %-2d | LVL: %d\n",
                jogador.getNome(), jogador.getVida(), jogador.getVidaMaxima(), jogador.getEstamina(), jogador.getNivel());
        System.out.printf(Cores.VERMELHO + "  %-15s " + RESET + "| HP: " + Cores.VERMELHO + "%-3d\n" + RESET,
                inimigo.getNome(), inimigo.getVida());
        mostrarSeparador("=", Cores.CIANO);
    }

    public void mostrarMenuAcao() {
        System.out.println("\nSua vez! Escolha uma ação: \n");
        System.out.printf("   [1] %-25s\n", "Ataque Básico");
        System.out.printf("   [2] %-25s\n", "Habilidade Especial (Gasta Estamina)");
    }

    public void mostrarInputInvalido() {
        System.out.println(Cores.ROXO);
        System.out.println("\nEntrada inválida! Você perdeu a vez.");
        System.out.println(RESET);
    }

    public void mostrarResultadoDadoAcao(int valorDado) {
        mostrarSeparador("-", Cores.AMARELO);
        System.out.print(Cores.AMARELO);
        System.out.println(Cores.AMARELO + "\n  🎲 Você rolou o dado e tirou: " + valorDado + Cores.RESETAR);
        mostrarSeparador("-", Cores.AMARELO);
    }

    public void mostrarHesitacao() {
        System.out.println(Cores.ROXO);
        System.out.println("\n  === Você hesitou e perdeu a vez! ===");
        System.out.println(RESET);
    }

    public void mostrarAtaqueBasico(String nomeJogador) {
        System.out.print(Cores.CIANO);
        this.imprimirLentamente("  \n" + nomeJogador + " realiza um ataque básico!\n");
        System.out.println(RESET);
    }

    public void mostrarHabilidadeJedi(String nomeJedi) {
        System.out.print(Cores.CIANO);
        this.imprimirLentamente(  nomeJedi + " usa o Empurrão da Força! Poder massivo!\n");
        System.out.println(RESET);
    }

    public void mostrarEnergiaInsuficiente() {
        System.out.print(Cores.VERMELHO);
        System.out.println("\n  Energia insuficiente! Ataque falhou.\n");
        System.out.println(RESET);
    }

    public void mostrarHabilidadeDroid(String nomeDroid) {
        System.out.print(Cores.CIANO);
        this.imprimirLentamente(nomeDroid + " ativa Sobrecarga! Raios de eletricidade atingem o inimigo!\n");
    }

    public void mostrarBateriaFraca() {
        System.out.print(Cores.CIANO);
        System.out.println("  Bateria fraca! Não foi possível sobrecarregar.\n");
        System.out.println(RESET);
    }

    public void mostrarHabilidadeWookie(String nomeWookie) {
        System.out.print(Cores.CIANO);
        this.imprimirLentamente("\n" + nomeWookie + " usou Emboscada! O inimigo não te viu!\n");
        System.out.println(RESET);
    }

    public void mostrarEmboscadaFalhou() {
        System.out.print(Cores.VERMELHO);
        System.out.println("\n  Você foi visto! Não conseguiu armar a emboscada.\n");
        System.out.println(RESET);
    }

    public void mostrarTurnoInimigo(String nomeInimigo){
        System.out.println("\n 🔻Turno do Inimigo: " + nomeInimigo);
    }

    public void mostrarDadoInimigo(int valorDadoInimigo) {
        System.out.println("\n  🎲 O inimigo rolou: " + valorDadoInimigo);
    }

    public void mostrarCritico(int valorDadoInimigo) {
        System.out.println(Cores.VERMELHO + "\n  CRÍTICO! O dado adicionou +" + valorDadoInimigo + " de dano!" + Cores.RESETAR);
    }

// ###### Prints da classe Recompensa ######

    public void bonusAplicado(String nomeAtributo, String nickname, int novoValor) {
        System.out.print(Cores.VERDE);
        System.out.println("  Aplicado bônus permanente à " + nomeAtributo + " de " + nickname + ".\n" +
                           "  Novo valor: " + novoValor);
        System.out.print(Cores.VERDE);
    }

    public void vidaMaxima(String nickname, int vidaMaxima) {
        mostrarSeparador("-", Cores.AMARELO);
        System.out.println(Cores.AMARELO);
        System.out.println("  ATENÇÃO: A vida de " + nickname + " já está no máximo (" + vidaMaxima + ").");
        System.out.println("  Esta recompensa **não pode ser aplicada**. Você deve escolher outro atributo.");
        System.out.println(RESET);
        mostrarSeparador("-", Cores.AMARELO);
    }

    public void restauracaoVida(int curaReal, int vidaAtual, int vidaMaxima) {
        System.out.print(Cores.VERDE);
        System.out.println("  Aplicado bônus de *** RESTAURAÇÃO DE VIDA ***. Vida recuperada: +" + curaReal);
        System.out.println("  Vida atual: " + vidaAtual + "/" + vidaMaxima);
        System.out.println(RESET);
    }

    public void atributoInvalido() {
        System.out.println(Cores.AZUL);
        System.out.println("\n ! Erro: Atributo inválido.\n");
        System.out.println(RESET);
    }

    public void mostrarRecompensa(String nomeRecompensa) {
        mostrarSeparador("=", Cores.VERDE);
        System.out.print(Cores.AMARELO);
        System.out.println("  RECEBIDO: " + nomeRecompensa + "!");
        System.out.println("  Use este item para aprimorar permanentemente ou restaurar um atributo do seu herói.");
        System.out.print(RESET);
        mostrarSeparador("=", Cores.VERDE);
    }

    public void menuRecompensa(Personagem heroi) {
        System.out.print(Cores.CIANO);
        System.out.println("\n  Qual atributo deseja modificar (editar/restaurar)?");
        mostrarSeparador("-", Cores.CIANO);
        System.out.println("  1. Agilidade (Atual: " + heroi.getAgilidade() + ")");
        System.out.println("  2. Furtividade (Atual: " + heroi.getFurtividade() + ")");
        System.out.println("  3. Força (Atual: " + heroi.getForca() + ")");
        System.out.println("  4. Defesa (Atual: " + heroi.getDefesa() + ")");
        System.out.println("  5. Vida (Atual: " + heroi.getVida() + "/" + heroi.getVidaMaxima() + ")");
        mostrarSeparador("-", Cores.CIANO);
        System.out.println("  Digite o número da opção (1-5): ");
        System.out.println(RESET);
    }

    public void opcaoInvalida() {
        System.out.print(Cores.VERMELHO);
        System.out.println("\n  Opção inválida. Por favor, digite um número entre 1 e 5.");
        System.out.print(RESET);
    }

    public void opcaoValida2() {
        System.out.print(Cores.VERMELHO);
        System.out.println("\n  Entrada inválida. Por favor, digite um número.");
        System.out.println(RESET);
    }

    // ###### Print classe Dado ######
    public void erroDado() {
        System.out.print(Cores.VERMELHO);
        System.out.println("  ERRO: Para o jogo funcionar o dado precisa ter no mínimo 6 lados, foi setado para 6 por padrão");
        System.out.println(RESET);
    }
}