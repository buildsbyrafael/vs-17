package automationexercise.driver;

import automationexercise.config.EnvironmentManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Configurações de opções para diferentes navegadores.
 * Centraliza todas as opções e preferências dos navegadores.
 */
public class BrowserOptions {

    /**
     * Retorna opções configuradas para Chrome
     */
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        // Modo headless
        if (EnvironmentManager.isHeadless()) {
            options.addArguments("--headless=new");
            System.out.println("🔇 Modo headless ativado para Chrome");
        }

        // Argumentos comuns
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        // Preferências
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + "\\downloads");
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Excluir switches de automação
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.setExperimentalOption("useAutomationExtension", false);

        return options;
    }

    /**
     * Retorna opções configuradas para Firefox
     */
    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();

        // Modo headless
        if (EnvironmentManager.isHeadless()) {
            options.addArguments("--headless");
            System.out.println("🔇 Modo headless ativado para Firefox");
        }

        // Preferências
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", System.getProperty("user.dir") + "\\downloads");
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

        return options;
    }

    /**
     * Retorna opções configuradas para Edge
     */
    public static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();

        // Modo headless
        if (EnvironmentManager.isHeadless()) {
            options.addArguments("--headless=new");
            System.out.println("🔇 Modo headless ativado para Edge");
        }

        // Argumentos comuns
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");

        return options;
    }

    /**
     * Retorna capabilities baseado no navegador (para Grid)
     */
    public static org.openqa.selenium.Capabilities getCapabilities(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return getChromeOptions();
            case "firefox":
                return getFirefoxOptions();
            case "edge":
                return getEdgeOptions();
            default:
                throw new IllegalArgumentException("Navegador não suportado: " + browser);
        }
    }
}
