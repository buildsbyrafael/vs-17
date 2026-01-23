package automationexercise.helpers;

import automationexercise.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Helper para execução de JavaScript
 */
public class JavaScriptHelper {

    private static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    private static JavascriptExecutor getJS() {
        return (JavascriptExecutor) getDriver();
    }

    /**
     * Executa JavaScript
     */
    public static Object executeScript(String script, Object... args) {
        return getJS().executeScript(script, args);
    }

    /**
     * Rola a página até o final
     */
    public static void scrollToBottom() {
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Rola a página até o topo
     */
    public static void scrollToTop() {
        executeScript("window.scrollTo(0, 0)");
    }

    /**
     * Aguarda página carregar completamente
     */
    public static void waitForPageLoad() {
        WaitHelper.waitForSeconds(1);
        getJS().executeScript("return document.readyState").equals("complete");
    }

    /**
     * Obtém título da página via JS
     */
    public static String getPageTitle() {
        return (String) executeScript("return document.title");
    }

    /**
     * Abre nova aba
     */
    public static void openNewTab() {
        executeScript("window.open()");
    }

    /**
     * Fecha aba atual
     */
    public static void closeCurrentTab() {
        executeScript("window.close()");
    }
}
