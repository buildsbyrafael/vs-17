package automationexercise.helpers;

import automationexercise.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Helper para interações com elementos
 */
public class ElementHelper {

    private static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    /**
     * Clica em um elemento (com espera)
     */
    public static void click(By locator) {
        WebElement element = WaitHelper.waitForElementClickable(locator);
        element.click();
    }

    /**
     * Preenche um campo de texto (limpa antes)
     */
    public static void fillText(By locator, String text) {
        WebElement element = WaitHelper.waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Preenche sem limpar
     */
    public static void sendKeys(By locator, String text) {
        WebElement element = WaitHelper.waitForElementVisible(locator);
        element.sendKeys(text);
    }

    /**
     * Obtém texto de um elemento
     */
    public static String getText(By locator) {
        WebElement element = WaitHelper.waitForElementVisible(locator);
        return element.getText();
    }

    /**
     * Obtém atributo de um elemento
     */
    public static String getAttribute(By locator, String attribute) {
        WebElement element = WaitHelper.waitForElementPresent(locator);
        return element.getDomAttribute(attribute);
    }

    /**
     * Verifica se elemento está visível
     */
    public static boolean isDisplayed(By locator) {
        try {
            return WaitHelper.waitForElementVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Verifica se elemento está habilitado
     */
    public static boolean isEnabled(By locator) {
        WebElement element = WaitHelper.waitForElementPresent(locator);
        return element.isEnabled();
    }

    /**
     * Faz hover sobre elemento
     */
    public static void hover(By locator) {
        WebElement element = WaitHelper.waitForElementVisible(locator);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Clica usando JavaScript
     */
    public static void clickJS(By locator) {
        WebElement element = WaitHelper.waitForElementPresent(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Rola até o elemento
     */
    public static void scrollToElement(By locator) {
        WebElement element = WaitHelper.waitForElementPresent(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Pressiona tecla TAB
     */
    public static void pressTab(By locator) {
        WebElement element = WaitHelper.waitForElementVisible(locator);
        element.sendKeys(Keys.TAB);
    }

    /**
     * Pressiona ENTER
     */
    public static void pressEnter(By locator) {
        WebElement element = WaitHelper.waitForElementVisible(locator);
        element.sendKeys(Keys.ENTER);
    }
}
