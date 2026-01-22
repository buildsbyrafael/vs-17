package automationexercise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    private By nameInput = By.cssSelector("input[data-qa='name']");
    private By emailInput = By.cssSelector("input[data-qa='email']");
    private By subjectInput = By.cssSelector("input[data-qa='subject']");
    private By messageInput = By.cssSelector("textarea[data-qa='message']");
    private By submitButton = By.cssSelector("input[data-qa='submit-button']");
    private By successMessage = By.cssSelector(".status.alert-success");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void preencherFormulario(String nome, String email, String assunto, String mensagem) {
        escrever(nameInput, nome);
        escrever(emailInput, email);
        escrever(subjectInput, assunto);
        escrever(messageInput, mensagem);
    }

    public void clicarEmEnviar() {
        clicar(submitButton);
    }

    public String obterMensagemSucesso() {
        return obterTexto(successMessage);
    }
}