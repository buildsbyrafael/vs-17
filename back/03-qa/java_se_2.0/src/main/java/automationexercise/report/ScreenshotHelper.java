package automationexercise.report;

import automationexercise.driver.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

/**
 * Helper para gerenciar screenshots e anexos do Allure
 */
public class ScreenshotHelper {

    /**
     * Captura screenshot e anexa ao Allure
     */
    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public static byte[] captureScreenshot(String name) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
            byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);

            // Anexar ao Allure também via stream
            Allure.addAttachment(name, "image/png",
                    new ByteArrayInputStream(screenshotBytes), "png");

            return screenshotBytes;
        } catch (Exception e) {
            System.err.println("Erro ao capturar screenshot: " + e.getMessage());
            return new byte[0];
        }
    }

    /**
     * Captura screenshot com nome padrão
     */
    public static byte[] captureScreenshot() {
        return captureScreenshot("Screenshot");
    }

    /**
     * Captura screenshot em caso de falha
     */
    public static void captureOnFailure(String testName) {
        captureScreenshot("Falha em: " + testName);
    }
}
