package automationexercise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    private By contactUsLink = By.xpath("//a[contains(text(), 'Contact us')]");
    private By testCasesLink = By.xpath("//a[contains(text(), 'Test Cases')]");
    private By productsLink = By.xpath("//a[contains(text(), 'Products')]");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void escrever(By by, String texto) {
        driver.findElement(by).sendKeys(texto);
    }

    protected void clicar(By by) {
        driver.findElement(by).click();
    }

    protected String obterTexto(By by) {
        return driver.findElement(by).getText();
    }

    protected boolean elementoEstaVisivel(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public void aceitarAlerta() {
        driver.switchTo().alert().accept();
    }

    public void irParaContactUs() {
        clicar(contactUsLink);
    }

    public void irParaTestCases() {
        clicar(testCasesLink);
    }

    public void irParaProducts() {
        clicar(productsLink);
    }
}