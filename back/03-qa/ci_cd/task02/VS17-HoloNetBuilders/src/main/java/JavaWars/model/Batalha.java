package model;

import repository.BatalhaRepository;
import exceptions.BancoDeDadosException;
import view.HistoriaView;

import java.util.List;
import java.util.Scanner;

public class Batalha {

    private Personagem jogador;
    private Atacavel inimigo;
    private Dado dado;
    private Scanner sc;
    private HistoriaView historiaView;
    private Recompensa recompensa;

    public Batalha(Personagem jogador, Atacavel inimigo, HistoriaView historiaView, Recompensa recompensa) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.dado = new Dado();
        this.sc = new Scanner(System.in);
        this.historiaView = historiaView;
        this.recompensa = recompensa;
    }

    // Luta

   public boolean iniciar() throws BancoDeDadosException {

        int vidaInicial = jogador.getVida();

        historiaView.mostrarInicioCombate(jogador.getNome(), inimigo.getNome());

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            turnoJogador();
            historiaView.mostrarStatus(jogador, inimigo);
            if (!inimigo.estaVivo()) {
                historiaView.mostrarVitoria(inimigo.getNome());

                if (recompensa!= null){
                    recompensa.oferecer(jogador, this.sc, historiaView);
                }
                registrarBatalha();
                return true;
            }
            turnoInimigo();
            historiaView.mostrarStatus(jogador, inimigo);
            if (!jogador.estaVivo()) {
                historiaView.mostrarDerrota();
                registrarBatalha();
                return false;
            }
        }
        return false;
    }

    private void mostrarStatus() {
        historiaView.mostrarStatus(jogador, inimigo);
    }

    private void turnoJogador() {
        historiaView.mostrarMenuAcao();

        int escolha = 0;
        try {
            escolha = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            historiaView.mostrarInputInvalido();
            sc.next();
            return;
        }

        int valorDado = dado.rolar();
        historiaView.mostrarResultadoDadoAcao(valorDado);


        switch (escolha) {
            case 1:
                realizarAtaqueBasico(valorDado);
                break;

            case 2:
                realizarAtaqueEspecial(valorDado);
                break;

            default:
               historiaView.mostrarHesitacao();
        }
    }

    private void realizarAtaqueBasico(int bonusDado) {
        int danoBase = jogador.getForca();
        int danoTotal = danoBase + bonusDado;

        historiaView.mostrarAtaqueBasico(jogador.getNome());
        inimigo.receberDano(danoTotal);
    }

    private void realizarAtaqueEspecial(int bonusDado) {
        if (jogador instanceof Jedi jedi) {
            if (jedi.getPontosDeForca() >= 10) {
                jedi.usarEmpurraoDaForca();
                int danoEspecial = (jedi.getForca() * 2) + jedi.getAgilidade() + bonusDado;
                historiaView.mostrarHabilidadeJedi(jedi.getNome());
                inimigo.receberDano(danoEspecial);
            } else {
                historiaView.mostrarEnergiaInsuficiente();
            }

        } else if (jogador instanceof Droid droid) {
            if (droid.getBateria() >= 10) {
                droid.ativarSobrecarga();
                int danoEspecial = (droid.getAgilidade() * 3) + bonusDado;
                historiaView.mostrarHabilidadeDroid(droid.getNome());
                inimigo.receberDano(danoEspecial);
            } else {
                historiaView.mostrarBateriaFraca();
            }

        } else if (jogador instanceof Wookie wookie) {
            if (wookie.getPontosDeFurtividade() >= 10) {
                wookie.usarEmboscada();
                int danoEspecial = (wookie.getFurtividade() * 3) + bonusDado;
                historiaView.mostrarHabilidadeWookie(wookie.getNome());
                inimigo.receberDano(danoEspecial);
            } else {
                historiaView.mostrarEmboscadaFalhou();
            }
        }
    }

    private void turnoInimigo() {
        historiaView.mostrarTurnoInimigo(inimigo.getNome());
        int valorDadoInimigo = dado.rolar();
        historiaView.mostrarDadoInimigo(valorDadoInimigo);
        int danoTotalInimigo = inimigo.getForca() + valorDadoInimigo;
        inimigo.atacar(jogador);

        if (valorDadoInimigo > 3) {
            historiaView.mostrarCritico(valorDadoInimigo);
            jogador.receberDano(valorDadoInimigo);
        }
    }
    private void registrarBatalha() {
        Integer idInimigo = null;
        if (inimigo instanceof Inimigo inimigoConcreto) {
            idInimigo = inimigoConcreto.getIdInimigo();
        }

        if (idInimigo != null) {
            try {
                BatalhaRepository repo = new BatalhaRepository();
                repo.registrarBatalha(jogador.getIdPersonagem(), idInimigo);
            } catch (BancoDeDadosException e) {
                throw new RuntimeException("Erro", e);
            }
        } else {
            throw new RuntimeException("Não foi possível obter o ID do inimigo para registrar a batalha.");
        }
    }

    public static List<BatalhaEntity> listarBatalhas() throws BancoDeDadosException {
        return new BatalhaRepository().listarBatalhas();
    }

    public static boolean atualizarRegistro(BatalhaEntity b) throws BancoDeDadosException {
        boolean sucesso = new BatalhaRepository().atualizarBatalha(b);
        return sucesso;
    }

    public static boolean removerRegistro(Integer id) throws BancoDeDadosException {
        boolean sucesso = new BatalhaRepository().apagarLogDeBatalha(id);
        return sucesso;
    }
}