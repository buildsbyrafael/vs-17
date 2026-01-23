package automationexercise.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Gerenciador de configurações por ambiente.
 * Permite executar testes em diferentes ambientes (dev, qa, prod)
 * sem alterar código.
 * 
 * Uso:
 * - Padrão (QA): mvn clean test
 * - Dev: mvn clean test -Dtest.env=dev
 * - Prod: mvn clean test -Dtest.env=prod
 */
public class EnvironmentManager {

    private static final String ENV_KEY = "test.env";
    private static final String DEFAULT_ENV = "qa";
    private static Properties properties;

    static {
        loadConfiguration();
    }

    /**
     * Carrega a configuração do ambiente especificado
     */
    private static void loadConfiguration() {
        String environment = getEnvironment();
        properties = new Properties();

        try {
            // Carregar configurações padrão
            loadPropertiesFile("config/default.properties");

            // Sobrescrever com configurações do ambiente
            loadPropertiesFile(String.format("config/%s.properties", environment));

            System.out.println("✅ Configuração carregada para ambiente: " + environment);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar configurações: " + e.getMessage(), e);
        }
    }

    /**
     * Carrega um arquivo de properties
     */
    private static void loadPropertiesFile(String fileName) throws IOException {
        InputStream input = EnvironmentManager.class.getClassLoader()
                .getResourceAsStream(fileName);

        if (input == null) {
            throw new IOException("Arquivo de configuração não encontrado: " + fileName);
        }

        try {
            properties.load(input);
        } finally {
            input.close();
        }
    }

    /**
     * Retorna o ambiente atual
     */
    public static String getEnvironment() {
        return System.getProperty(ENV_KEY, DEFAULT_ENV);
    }

    /**
     * Retorna uma propriedade
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Propriedade não encontrada: " + key);
        }
        return value;
    }

    /**
     * Retorna uma propriedade com valor padrão
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Retorna uma propriedade como inteiro
     */
    public static int getPropertyAsInt(String key) {
        return Integer.parseInt(getProperty(key));
    }

    /**
     * Retorna uma propriedade como booleano
     */
    public static boolean getPropertyAsBoolean(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }

    // ========== Métodos de Conveniência ==========

    /**
     * Retorna a URL da aplicação
     */
    public static String getAppUrl() {
        return getProperty("app.url");
    }

    /**
     * Retorna o navegador configurado
     */
    public static String getBrowser() {
        return getProperty("app.browser");
    }

    /**
     * Retorna se deve executar em modo headless
     */
    public static boolean isHeadless() {
        return getPropertyAsBoolean("app.headless");
    }

    /**
     * Retorna o timeout implícito
     */
    public static int getImplicitWait() {
        return getPropertyAsInt("app.timeout.implicit");
    }

    /**
     * Retorna o timeout explícito
     */
    public static int getExplicitWait() {
        return getPropertyAsInt("app.timeout.explicit");
    }

    /**
     * Retorna o timeout de carregamento de página
     */
    public static int getPageLoadTimeout() {
        return getPropertyAsInt("app.timeout.page.load");
    }

    /**
     * Retorna o email do usuário de teste
     */
    public static String getTestUserEmail() {
        return getProperty("test.user.email");
    }

    /**
     * Retorna a senha do usuário de teste
     */
    public static String getTestUserPassword() {
        return getProperty("test.user.password");
    }

    /**
     * Retorna se deve capturar screenshot em falhas
     */
    public static boolean isScreenshotOnFailure() {
        return getPropertyAsBoolean("screenshot.on.failure");
    }

    /**
     * Retorna se deve capturar screenshot em sucessos
     */
    public static boolean isScreenshotOnSuccess() {
        return getPropertyAsBoolean("screenshot.on.success");
    }
}
