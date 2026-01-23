package automationexercise.driver;

import automationexercise.config.EnvironmentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Gerenciador de conexão com Selenium Grid
 */
public class GridManager {

    /**
     * Verifica se Grid está habilitado
     */
    public static boolean isGridEnabled() {
        return EnvironmentManager.getPropertyAsBoolean("grid.enabled");
    }

    /**
     * Cria driver remoto conectado ao Grid
     */
    public static WebDriver createRemoteDriver(String browser) {
        try {
            String gridUrl = EnvironmentManager.getProperty("grid.url");
            URL url = new URL(gridUrl + "/wd/hub");

            System.out.println("🌐 Conectando ao Selenium Grid: " + gridUrl);
            System.out.println("🌐 Navegador: " + browser);

            RemoteWebDriver driver = new RemoteWebDriver(url,
                    BrowserOptions.getCapabilities(browser));

            System.out.println("✅ Conectado ao Grid com sucesso!");

            return driver;

        } catch (Exception e) {
            throw new RuntimeException("❌ Erro ao conectar no Selenium Grid: " + e.getMessage(), e);
        }
    }

    /**
     * Verifica se Grid está disponível
     */
    public static boolean isGridAvailable() {
        try {
            String gridUrl = EnvironmentManager.getProperty("grid.url");
            URL url = new URL(gridUrl + "/status");

            // Tentar conectar
            url.openConnection().connect();
            return true;

        } catch (Exception e) {
            System.err.println("⚠️ Selenium Grid não está disponível em: " +
                    EnvironmentManager.getProperty("grid.url"));
            return false;
        }
    }

    /**
     * Obtém URL do Grid
     */
    public static String getGridUrl() {
        return EnvironmentManager.getProperty("grid.url");
    }
}
