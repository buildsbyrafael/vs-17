package automationexercise.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Factory para criação de WebDrivers.
 * Centraliza a lógica de criação de drivers para diferentes navegadores.
 */
public class DriverFactory {

    /**
     * Cria um WebDriver baseado no tipo de navegador
     */
    public static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return createChromeDriver();
            case "firefox":
                return createFirefoxDriver();
            case "edge":
                return createEdgeDriver();
            default:
                throw new IllegalArgumentException("Navegador não suportado: " + browser);
        }
    }

    /**
     * Cria um ChromeDriver com opções configuradas
     */
    private static WebDriver createChromeDriver() {
        ChromeOptions options = BrowserOptions.getChromeOptions();
        return new ChromeDriver(options);
    }

    /**
     * Cria um FirefoxDriver com opções configuradas
     */
    private static WebDriver createFirefoxDriver() {
        FirefoxOptions options = BrowserOptions.getFirefoxOptions();
        return new FirefoxDriver(options);
    }

    /**
     * Cria um EdgeDriver com opções configuradas
     */
    private static WebDriver createEdgeDriver() {
        EdgeOptions options = BrowserOptions.getEdgeOptions();
        return new EdgeDriver(options);
    }
}
