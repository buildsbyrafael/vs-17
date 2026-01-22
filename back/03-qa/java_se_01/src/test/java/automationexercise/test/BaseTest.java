package automationexercise.test;

import automationexercise.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void inicializar() {
        DriverFactory.getDriver().get("https://www.automationexercise.com/login");
    }

    @AfterMethod
    public void finalizar() {
        DriverFactory.killDriver();
    }
}