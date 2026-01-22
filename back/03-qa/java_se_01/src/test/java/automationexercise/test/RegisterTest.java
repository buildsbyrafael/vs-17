package automationexercise.test;

import automationexercise.driver.DriverFactory;
import automationexercise.page.LoginPage;
import automationexercise.page.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void teste07_deveCadastrarUsuarioComSucesso() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        String email = "teste07_" + System.currentTimeMillis() + "@gmail.com";

        loginPage.preencherNomeCadastro("Teste Sete");
        loginPage.preencherEmailCadastro(email);
        loginPage.clicarEmSignup();

        SignupPage signupPage = new SignupPage(DriverFactory.getDriver());
        signupPage.preencherDadosDaConta("123456", "1", "January", "2000");
        signupPage.preencherDadosDeEndereco(
                "Teste", "Sete", "Rua 07",
                "India", "Estado", "Cidade", "00000", "99999999"
        );
        signupPage.clicarEmCriarConta();

        Assert.assertTrue(signupPage.contaFoiCriada());
    }

    @Test
    public void teste08_deveExcluirContaComSucesso() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        String email = "teste08_" + System.currentTimeMillis() + "@gmail.com";

        loginPage.preencherNomeCadastro("Teste Oito");
        loginPage.preencherEmailCadastro(email);
        loginPage.clicarEmSignup();

        SignupPage signupPage = new SignupPage(DriverFactory.getDriver());
        signupPage.preencherDadosDaConta("123456", "1", "January", "2000");
        signupPage.preencherDadosDeEndereco(
                "Teste", "Oito", "Rua 08",
                "India", "Estado", "Cidade", "00000", "88888888"
        );
        signupPage.clicarEmCriarConta();
        signupPage.clicarEmContinuar();
        signupPage.clicarEmDeletarConta();

        Assert.assertTrue(signupPage.contaFoiDeletada());
    }
}