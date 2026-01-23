package automationexercise.suites;

import automationexercise.categories.Smoke;
import automationexercise.tests.login.LoginTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(Smoke.class)
@Suite.SuiteClasses({
        // Liste as classes de teste aqui
        LoginTest.class
})
public class SmokeSuite {
    // Executa apenas testes marcados com @Smoke
}
