package automationexercise.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // mapeamento (Padrão)
    private static final By campoUsername = By.cssSelector("input[id='user-name']");

    private static final By campoSenha = By.cssSelector("input[id='password']");

    private static final By btnAcessar = By
            .cssSelector("input[id='login-button']");

    private static final By TextMsgmBtn = By
            .cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    private static final By msgmEmailIncorreto = By
            .cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p");

    // Ações (clicar, escrever etc)
    public LoginPage preencherCampoUsername(String email) {
        preencherInput(campoUsername, email);
        return this;
    }

    public LoginPage preencherCampoSenha(String senha) {
        preencherInput(campoSenha, senha);
        return this;
    }

    public LoginPage clicarBtnAcessar() {
        clicar(btnAcessar);
        return this;
    }

    public LoginPage validarTextoBtnAposLogin(String textValidate) {
        Assert.assertEquals(textValidate, lerTexto(TextMsgmBtn));
        return this;
    }

    public String validarMsgmEmailIncorreto() {
        return lerTexto(msgmEmailIncorreto);

    }

    public String fazerLogin(String email, String senha) {
        preencherInput(campoUsername, email);
        preencherInput(campoSenha, senha);
        clicar(btnAcessar);
        return lerTexto(TextMsgmBtn);
    }

    public String loginEmailIncorreto(String email, String senha) {
        preencherInput(campoUsername, email);
        preencherInput(campoSenha, senha);
        clicar(btnAcessar);
        return lerTexto(msgmEmailIncorreto);
    }
}
