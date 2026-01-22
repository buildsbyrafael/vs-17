package automationexercise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    private By pageTitle = By.xpath("//b[contains(text(), 'Test Cases')]");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean tituloEstaVisivel() {
        return elementoEstaVisivel(pageTitle);
    }
}