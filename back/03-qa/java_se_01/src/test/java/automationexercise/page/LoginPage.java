package automationexercise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailInput = By.cssSelector("input[data-qa='login-email']");
    private By passwordInput = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By loggedInText = By.xpath("//*[contains(text(), 'Logged in as')]");
    private By loginErrorMessage = By.xpath("//p[contains(text(), 'incorrect')]");

    private By logoutButton = By.xpath("//a[contains(@href, '/logout')]");

    private By signupNameInput = By.cssSelector("input[data-qa='signup-name']");
    private By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private By signupErrorMessage = By.xpath("//p[contains(text(), 'exist')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void preencherEmail(String email) {
        escrever(emailInput, email);
    }

    public void preencherSenha(String senha) {
        escrever(passwordInput, senha);
    }

    public void clicarEmLogin() {
        clicar(loginButton);
    }

    public void realizarLogin(String email, String senha) {
        preencherEmail(email);
        preencherSenha(senha);
        clicarEmLogin();
    }

    public boolean estaLogado() {
        return elementoEstaVisivel(loggedInText);
    }

    public String obterMensagemErroLogin() {
        return obterTexto(loginErrorMessage);
    }

    public void clicarEmLogout() {
        clicar(logoutButton);
    }

    public boolean botaoLoginEstaVisivel() {
        return elementoEstaVisivel(loginButton);
    }

    public void preencherNomeCadastro(String nome) {
        escrever(signupNameInput, nome);
    }

    public void preencherEmailCadastro(String email) {
        escrever(signupEmailInput, email);
    }

    public void clicarEmSignup() {
        clicar(signupButton);
    }

    public String obterMensagemErroCadastro() {
        return obterTexto(signupErrorMessage);
    }
}