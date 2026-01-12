package controller;

import exceptions.BancoDeDadosException;
import model.*;

import java.util.List;

import repository.InimigoRepository;
import repository.BatalhaRepository;
import repository.MissaoRepository;
import view.HistoriaView;

public class MissaoController {
    private BatalhaRepository batalhaRepo = new BatalhaRepository();
    private InimigoRepository inimigoRepo = new InimigoRepository();
    
    public void iniciarJogo(Personagem heroiEscolhido, HistoriaView viewHistoria, MissaoRepository missaoRepository, Dado dado) throws BancoDeDadosException {
        Planeta planeta1 = new Planeta("Planeta Hoth", "Um planeta frio e gélido...");

        Inimigo inimigoWampa = new Inimigo("Soldado Wampa", 45, 10);
        Inimigo inimigoVorian = new Inimigo("Contrabandista Vorian", 65, 13);
        Inimigo inimigoGorgan = new Inimigo("Gorgan", 90, 17);
        LadyNyx bossLadyNyx = new LadyNyx("Lady Nyx", 100, 22);

        try {
            inimigoWampa = inimigoRepo.adicionar(inimigoWampa);
            inimigoVorian = inimigoRepo.adicionar(inimigoVorian);
            inimigoGorgan = inimigoRepo.adicionar(inimigoGorgan);

            Inimigo bossBase = new Inimigo("Lady Nyx", 100, 22);
            bossBase = inimigoRepo.adicionar(bossBase);
            bossLadyNyx.setIdInimigo(bossBase.getIdInimigo());
        } catch (BancoDeDadosException e) {
            System.err.println("⚠️ Erro ao salvar inimigos: " + e.getMessage());
        }

        List<Missao> missoesCapitulo1 = missaoRepository.buscarPorCapitulo(1);

        for (Missao missaoAtual : missoesCapitulo1) {
            Atacavel inimigoDaVez = null;

            if (missaoAtual.getOrdem() == 1) {
                inimigoDaVez = inimigoWampa;
                viewHistoria.mostrarMissao1(planeta1, missaoAtual);
                viewHistoria.mostrarFase1WAMPA();
            }
            else if (missaoAtual.getOrdem() == 2) {
                inimigoDaVez = inimigoVorian;
                viewHistoria.mostrarFase2VORIAN();
                viewHistoria.mostrarVorianDialogo();
            }

            missaoAtual.jogar(heroiEscolhido, dado, inimigoDaVez, viewHistoria);

            if (!heroiEscolhido.estaVivo()) return;

            if (missaoAtual.getOrdem() == 2 && !inimigoDaVez.estaVivo()) {
                viewHistoria.mostrarVorianRendimento();
            }

            // Salva o histórico
            batalhaRepo.registrarBatalha(heroiEscolhido.getIdPersonagem(), ((Inimigo) inimigoDaVez).getIdInimigo());
        }

        List<Missao> missoesCapitulo2 = missaoRepository.buscarPorCapitulo(2);

        for (Missao missaoAtual : missoesCapitulo2) {

            Atacavel inimigoDaVez = null;

            if (missaoAtual.getOrdem() == 1) {
                inimigoDaVez = inimigoGorgan;
                viewHistoria.mostrarFase3Inicio();
                viewHistoria.mostrarFase4Durasteel();
                viewHistoria.mostrarGorganDialogo();
            }
            else if (missaoAtual.getOrdem() == 2) {
                inimigoDaVez = bossLadyNyx;
                viewHistoria.mostrarFaseFinalInicio();
            }

            missaoAtual.jogar(heroiEscolhido, dado, inimigoDaVez, viewHistoria);

            if (!heroiEscolhido.estaVivo()) return;

            if (missaoAtual.getOrdem() == 1 && !inimigoDaVez.estaVivo()) {
                viewHistoria.mostrarGorganFinal();
            }
            else if (missaoAtual.getOrdem() == 2 && !inimigoDaVez.estaVivo()) {
                viewHistoria.mostrarFinalJogo();
            }
        }
    }
}
