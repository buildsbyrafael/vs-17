import controller.JogoController;
import exceptions.BancoDeDadosException;

public class Main {

    public static void main(String[] args) throws BancoDeDadosException {
        JogoController jogo = new JogoController();
        jogo.jogar();
    }
}
