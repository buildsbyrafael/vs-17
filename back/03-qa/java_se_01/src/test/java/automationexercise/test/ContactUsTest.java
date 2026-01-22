package automationexercise.test;

import automationexercise.driver.DriverFactory;
import automationexercise.page.ContactPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseTest {

    @Test
    public void teste05_deveEnviarFormularioDeContatoComSucesso() {
        ContactPage contactPage = new ContactPage(DriverFactory.getDriver());

        contactPage.irParaContactUs();
        contactPage.preencherFormulario("Rafael", "vs@gmail.com", "Dúvida", "Gostaria de ajuda.");
        contactPage.clicarEmEnviar();
        contactPage.aceitarAlerta();

        Assert.assertEquals(contactPage.obterMensagemSucesso(), "Success! Your details have been submitted successfully.");
    }
}