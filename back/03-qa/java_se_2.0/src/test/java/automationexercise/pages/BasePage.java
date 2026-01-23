package automationexercise.pages;

import automationexercise.helpers.ElementHelper;
import automationexercise.helpers.WaitHelper;
import org.openqa.selenium.By;

/**
 * Classe base para todas as Page Objects
 * Fornece métodos comuns para interação com elementos
 */
public class BasePage {

    /**
     * Preenche um campo de input
     */
    protected void preencherInput(By locator, String texto) {
        ElementHelper.fillText(locator, texto);
    }

    /**
     * Clica em um elemento
     */
    protected void clicar(By locator) {
        ElementHelper.click(locator);
    }

    /**
     * Lê o texto de um elemento
     */
    protected String lerTexto(By locator) {
        return ElementHelper.getText(locator);
    }

    /**
     * Pressiona TAB
     */
    protected void tab(By locator) {
        ElementHelper.pressTab(locator);
    }

    /**
     * Aguarda elemento estar visível
     */
    protected void aguardarElementoVisivel(By locator) {
        WaitHelper.waitForElementVisible(locator);
    }

    /**
     * Aguarda elemento estar clicável
     */
    protected void aguardarElementoClicavel(By locator) {
        WaitHelper.waitForElementClickable(locator);
    }

    /**
     * Verifica se elemento está visível
     */
    protected boolean isElementoVisivel(By locator) {
        return ElementHelper.isDisplayed(locator);
    }

    /**
     * Obtém atributo de um elemento
     */
    protected String obterAtributo(By locator, String atributo) {
        return ElementHelper.getAttribute(locator, atributo);
    }

    /**
     * Faz hover sobre elemento
     */
    protected void hover(By locator) {
        ElementHelper.hover(locator);
    }

    /**
     * Rola até o elemento
     */
    protected void rolarAteElemento(By locator) {
        ElementHelper.scrollToElement(locator);
    }
}
