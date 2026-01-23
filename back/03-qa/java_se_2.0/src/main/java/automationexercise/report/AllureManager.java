package automationexercise.report;

import io.qameta.allure.Allure;

/**
 * Helper para gerenciar relatórios Allure
 */
public class AllureManager {

    /**
     * Adiciona informação ao relatório
     */
    public static void addInfo(String name, String value) {
        Allure.addAttachment(name, value);
    }

    /**
     * Adiciona step ao relatório
     */
    public static void addStep(String description) {
        Allure.step(description);
    }

    /**
     * Adiciona parâmetro ao relatório
     */
    public static void addParameter(String name, String value) {
        Allure.parameter(name, value);
    }

    /**
     * Adiciona link ao relatório
     */
    public static void addLink(String name, String url) {
        Allure.link(name, url);
    }

    /**
     * Marca teste como quebrado (broken)
     */
    public static void markAsBroken(String reason) {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setStatusDetails(new io.qameta.allure.model.StatusDetails()
                    .setMessage(reason));
        });
    }

    /**
     * Gera o arquivo environment.properties com informações dinâmicas
     */
    public static void setAllureEnvironmentInformation(String browser, String environment, String url,
            boolean headless) {
        try {
            java.util.Properties props = new java.util.Properties();
            props.setProperty("Browser", browser);
            props.setProperty("Environment", environment);
            props.setProperty("URL", url);
            props.setProperty("Headless", String.valueOf(headless));
            props.setProperty("OS", System.getProperty("os.name"));
            props.setProperty("Java Version", System.getProperty("java.version"));

            java.io.File resultsDir = new java.io.File("target/allure-results");
            if (!resultsDir.exists()) {
                resultsDir.mkdirs();
            }

            try (java.io.FileOutputStream fos = new java.io.FileOutputStream(
                    new java.io.File(resultsDir, "environment.properties"))) {
                props.store(fos, "Allure Environment Information");
            }

            System.out.println("✅ Informações de ambiente geradas para o Allure");

        } catch (Exception e) {
            System.err.println("⚠️ Erro ao gerar informações de ambiente Allure: " + e.getMessage());
        }
    }
}
