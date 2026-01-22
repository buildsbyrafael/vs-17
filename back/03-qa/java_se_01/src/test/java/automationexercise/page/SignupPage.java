package automationexercise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {

    private By titleMr = By.id("id_gender1");
    private By passwordInput = By.id("password");
    private By daysSelect = By.id("days");
    private By monthsSelect = By.id("months");
    private By yearsSelect = By.id("years");

    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By addressInput = By.id("address1");
    private By countrySelect = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileInput = By.id("mobile_number");

    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");
    private By accountCreatedText = By.xpath("//b[contains(text(), 'Account Created')]");

    private By continueButton = By.cssSelector("a[data-qa='continue-button']");
    private By deleteAccountButton = By.xpath("//a[contains(@href, '/delete_account')]");
    private By accountDeletedText = By.xpath("//b[contains(text(), 'Account Deleted')]");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void preencherDadosDaConta(String senha, String dia, String mes, String ano) {
        clicar(titleMr);
        escrever(passwordInput, senha);
        selecionarPorValor(daysSelect, dia);
        selecionarPorTexto(monthsSelect, mes);
        selecionarPorValor(yearsSelect, ano);
    }

    public void preencherDadosDeEndereco(String nome, String sobrenome, String endereco, String pais, String estado, String cidade, String cep, String telefone) {
        escrever(firstNameInput, nome);
        escrever(lastNameInput, sobrenome);
        escrever(addressInput, endereco);
        selecionarPorValor(countrySelect, pais);
        escrever(stateInput, estado);
        escrever(cityInput, cidade);
        escrever(zipcodeInput, cep);
        escrever(mobileInput, telefone);
    }

    public void clicarEmCriarConta() {
        clicar(createAccountButton);
    }

    public boolean contaFoiCriada() {
        return elementoEstaVisivel(accountCreatedText);
    }

    public void clicarEmContinuar() {
        clicar(continueButton);
    }

    public void clicarEmDeletarConta() {
        clicar(deleteAccountButton);
    }

    public boolean contaFoiDeletada() {
        return elementoEstaVisivel(accountDeletedText);
    }

    private void selecionarPorValor(By by, String valor) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(valor);
    }

    private void selecionarPorTexto(By by, String texto) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(texto);
    }
}