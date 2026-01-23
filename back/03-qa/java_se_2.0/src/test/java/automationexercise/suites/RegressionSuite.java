package automationexercise.suites;

import automationexercise.tests.login.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        // Regression roda TUDO
        LoginTest.class
})
public class RegressionSuite {
    // Executa todos os testes listados
}
