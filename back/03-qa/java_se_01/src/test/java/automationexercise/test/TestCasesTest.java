package automationexercise.test;

import automationexercise.driver.DriverFactory;
import automationexercise.page.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesTest extends BaseTest {

    @Test
    public void teste06_deveAcessarPaginaDeTestCases() {
        TestCasesPage testCasesPage = new TestCasesPage(DriverFactory.getDriver());

        testCasesPage.irParaTestCases();

        Assert.assertTrue(testCasesPage.tituloEstaVisivel());
    }
}