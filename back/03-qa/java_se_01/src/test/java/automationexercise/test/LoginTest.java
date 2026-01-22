package automationexercise.test;

import automationexercise.driver.DriverFactory;
import automationexercise.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void teste01_deveRealizarLoginComSucesso() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.realizarLogin("vs@gmail.com", "123456");
        Assert.assertTrue(loginPage.estaLogado());
    }

    @Test
    public void teste02_deveFalharLoginComSenhaIncorreta() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.realizarLogin("vs@gmail.com", "senhaerrada");

        Assert.assertEquals(loginPage.obterMensagemErroLogin(), "Your email or password is incorrect!");
    }

    @Test
    public void teste03_deveRealizarLogout() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.realizarLogin("vs@gmail.com", "123456");
        loginPage.clicarEmLogout();

        Assert.assertTrue(loginPage.botaoLoginEstaVisivel());
    }

    @Test
    public void teste04_deveFalharAoCadastrarEmailExistente() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.preencherNomeCadastro("Rafael Linhares");
        loginPage.preencherEmailCadastro("vs@gmail.com");
        loginPage.clicarEmSignup();

        Assert.assertEquals(loginPage.obterMensagemErroCadastro(), "Email Address already exist!");
    }
}