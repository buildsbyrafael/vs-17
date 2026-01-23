package automationexercise.helpers;

import automationexercise.config.EnvironmentManager;
import automationexercise.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Helper para gerenciar esperas (waits) de forma centralizada
 */
public class WaitHelper {

    private static WebDriverWait getWait() {
        WebDriver driver = DriverManager.getDriver();
        int timeout = EnvironmentManager.getExplicitWait();
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    /**
     * Aguarda elemento estar visível
     */
    public static WebElement waitForElementVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Aguarda elemento estar clicável
     */
    public static WebElement waitForElementClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Aguarda elemento estar presente no DOM
     */
    public static WebElement waitForElementPresent(By locator) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Aguarda elemento desaparecer
     */
    public static boolean waitForElementInvisible(By locator) {
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Aguarda texto estar presente no elemento
     */
    public static boolean waitForTextPresent(By locator, String text) {
        return getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /**
     * Aguarda URL conter texto específico
     */
    public static boolean waitForUrlContains(String urlPart) {
        return getWait().until(ExpectedConditions.urlContains(urlPart));
    }

    /**
     * Aguarda título da página conter texto
     */
    public static boolean waitForTitleContains(String title) {
        return getWait().until(ExpectedConditions.titleContains(title));
    }

    /**
     * Aguarda tempo fixo (usar apenas quando necessário)
     */
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
