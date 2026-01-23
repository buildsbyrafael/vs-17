package automationexercise.base;

import automationexercise.annotations.PagePath;
import automationexercise.config.EnvironmentManager;
import automationexercise.driver.DriverManager;
import automationexercise.report.AllureManager;
import automationexercise.report.ScreenshotHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.lang.reflect.Method;

/**
 * Classe base para todos os testes
 * Gerencia setup e teardown do WebDriver
 * 
 * Estratégia: 1 navegador por teste (isolamento completo)
 * - @Before: Abre navegador e navega para URL base (ou customizada
 * por @PagePath)
 * - @After: Fecha navegador
 * - Cada teste é independente e isolado
 */
public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            System.err.println("\n❌ TESTE FALHOU: " + description.getMethodName());
            System.err.println("📝 Erro: " + e.getMessage());

            // Capturar screenshot em caso de falha
            try {
                ScreenshotHelper.captureOnFailure(description.getMethodName());
                System.out.println("📸 Screenshot capturado");
            } catch (Exception ex) {
                System.err.println("⚠️ Erro ao capturar screenshot: " + ex.getMessage());
            }
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println("\n✅ TESTE PASSOU: " + description.getMethodName());
        }

        @Override
        protected void starting(Description description) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println("🚀 INICIANDO TESTE: " + description.getMethodName());
            System.out.println("=".repeat(80));
        }

        @Override
        protected void finished(Description description) {
            System.out.println("=".repeat(80));
            System.out.println("🏁 TESTE FINALIZADO: " + description.getMethodName());
            System.out.println("=".repeat(80) + "\n");
        }
    };

    @Before
    public void setUp() {
        try {
            System.out.println("📋 Setup: Abrindo navegador");

            // Gerar informações de ambiente para o relatório
            AllureManager.setAllureEnvironmentInformation(
                    EnvironmentManager.getBrowser(),
                    EnvironmentManager.getEnvironment(),
                    EnvironmentManager.getAppUrl(),
                    EnvironmentManager.isHeadless());

            // Determinar URL inicial
            String url = determineStartUrl();
            System.out.println("🌐 Navegando para: " + url);

            // Navegar para URL (cria o driver automaticamente)
            DriverManager.getDriver().get(url);

            System.out.println("✅ Setup concluído com sucesso");

        } catch (Exception e) {
            System.err.println("❌ Erro no setup: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @After
    public void tearDown() {
        try {
            System.out.println("🧹 Teardown: Fechando navegador");

            // Fechar driver
            DriverManager.quitDriver();

            System.out.println("✅ Teardown concluído com sucesso");

        } catch (Exception e) {
            System.err.println("⚠️ Erro no teardown: " + e.getMessage());
            // Não lançar exceção no teardown para não mascarar erro do teste
        }
    }

    /**
     * Determina a URL inicial baseada na anotação @PagePath
     */
    private String determineStartUrl() {
        String baseUrl = EnvironmentManager.getAppUrl();
        String path = "";

        try {
            // Verificar anotação no metodo de teste
            String methodName = testName.getMethodName();
            Method method = this.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(PagePath.class)) {
                path = method.getAnnotation(PagePath.class).value();
            } else if (this.getClass().isAnnotationPresent(PagePath.class)) {
                // Verificar anotação na classe se não houver no método
                path = this.getClass().getAnnotation(PagePath.class).value();
            }

        } catch (NoSuchMethodException e) {
            System.err.println("⚠️ Não foi possível encontrar método de teste: " + e.getMessage());
        }

        // Remover barra inicial do path se houver, para evitar //
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        // Adicionar barra final na baseUrl se não houver
        if (!baseUrl.endsWith("/")) {
            baseUrl += "/";
        }

        return baseUrl + path;
    }
}
