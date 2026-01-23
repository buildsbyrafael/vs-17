package automationexercise.driver;

import automationexercise.config.EnvironmentManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**
 * Gerenciador de WebDriver com suporte a execução paralela e Selenium Grid.
 * Usa ThreadLocal para garantir que cada thread tenha sua própria instância do
 * driver.
 */
public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Retorna a instância do WebDriver para a thread atual
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    /**
     * Cria uma nova instância do WebDriver
     */
    private static WebDriver createDriver() {
        ExecutionMode mode = ExecutionMode.fromString(
                EnvironmentManager.getProperty("execution.mode", "local"));

        String browser = EnvironmentManager.getBrowser();

        System.out.println("🚀 Modo de execução: " + mode);
        System.out.println("🌐 Navegador: " + browser);

        WebDriver webDriver;

        switch (mode) {
            case GRID:
            case DOCKER:
                // Verificar se Grid está disponível
                if (!GridManager.isGridAvailable()) {
                    System.err.println("⚠️ Grid não disponível! Usando modo LOCAL.");
                    webDriver = DriverFactory.createDriver(browser);
                } else {
                    webDriver = GridManager.createRemoteDriver(browser);
                }
                break;

            case LOCAL:
            default:
                webDriver = DriverFactory.createDriver(browser);
                break;
        }

        configureDriver(webDriver);
        return webDriver;
    }

    /**
     * Configura o WebDriver com timeouts e opções
     */
    private static void configureDriver(WebDriver webDriver) {
        // Maximizar janela (se não for headless)
        if (!EnvironmentManager.isHeadless()) {
            try {
                webDriver.manage().window().maximize();
            } catch (Exception e) {
                System.err.println("⚠️ Não foi possível maximizar janela: " + e.getMessage());
            }
        }

        // Configurar timeouts
        webDriver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(EnvironmentManager.getImplicitWait()));

        webDriver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(EnvironmentManager.getPageLoadTimeout()));

        System.out.println("✅ Driver configurado com sucesso");
    }

    /**
     * Navega para a URL base da aplicação
     */
    public static void navigateToBaseUrl() {
        String url = EnvironmentManager.getAppUrl();
        System.out.println("🌐 Navegando para: " + url);
        getDriver().get(url);
    }

    /**
     * Fecha e remove o driver da thread atual
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            System.out.println("🔚 Fechando driver");
            try {
                driver.get().quit();
            } catch (Exception e) {
                System.err.println("⚠️ Erro ao fechar driver: " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}
