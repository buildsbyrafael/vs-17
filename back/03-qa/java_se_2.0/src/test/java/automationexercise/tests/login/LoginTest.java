package automationexercise.tests.login;

import automationexercise.data.dto.LoginDto;
import automationexercise.data.factory.LoginData;
import automationexercise.pages.LoginPage;
import automationexercise.base.BaseTest;
import automationexercise.categories.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static automationexercise.support.constants.Messages.*;

import automationexercise.annotations.PagePath;

public class LoginTest extends BaseTest {

        LoginPage loginPage = new LoginPage();
        LoginData loginData = new LoginData();

        // Fluxo positivo - Cenário automatizado com execução de passo a passo
        @Test
        @Category({ Smoke.class, Critical.class, Login.class })
        @Epic("Login")
        @Story("Como usuário do sistema, " +
                        "desejo fazer login na aplicação " +
                        "quando inserir email e senha validos")
        @DisplayName("Test 1 - Validar Login com dados validos")
        public void validarLoginDadosValidos() {
                LoginDto usu = loginData.loginStandardUser(); // Criando a massa
                loginPage
                                .preencherCampoUsername(usu.getUsuario()) // Preenhce campo email
                                .preencherCampoSenha(usu.getSenha()) // Preenhce campo senha
                                .clicarBtnAcessar() // Clicar em botao
                                .validarTextoBtnAposLogin(MENSAGEM_LOGIN_SUCESSO); // Ler o texto no element //
                                                                                   // Validando os resultados
        }

        /*
         * / Fluxo positivo - Cenário automatizado com execução de passo a passo
         * 
         * @Test
         * 
         * @Epic("Login")
         * 
         * @Story("Como usuário do sistema, " +
         * "desejo fazer login na aplicação " +
         * "quando inserir email e senha validos")
         * 
         * @DisplayName("Test 2 - Validar Login com dados invalidos")
         * public void validarLoginDadosInvalidos(){
         * LoginDto usu = loginData.LoginDadoDinamicos(); // Criando a massa
         * loginPage.preencherCampoEmail(usu.getEmail()); // Preenhce campo email
         * loginPage.preencherCampoSenha(usu.getSenha()); // Preenhce campo senha
         * loginPage.clicarBtnAcessar(); // Clicar em botao
         * String msgm = loginPage.validarMsgmEmailIncorreto(); // Ler o texto no
         * elemento
         * Assert.assertEquals(msgm,MENSAGEM_LOGIN_INCORRETO); // Validando o resultado
         * }
         * 
         * // Fluxo alternativo - Cenário automatizado com execução de fluxo
         * 
         * @Test
         * public void validarLoginComDadosValidosTest3(){
         * 
         * LoginDto usu = loginData.loginDadosValidos(); // Criando a massa
         * String msgm = loginPage.fazerLogin(usu.getEmail(),usu.getSenha()); //
         * Executando fluxo
         * Assert.assertEquals(msgm,MENSAGEM_LOGIN_SUCESSO); // Validando o resultado
         * 
         * }
         * 
         * // Fluxo alternativo - Cenário automatizado com execução de fluxo
         * 
         * @Test
         * 
         * @Epic("Login")
         * 
         * @Story("Como usuário do sistema, " +
         * "desejo fazer login na aplicação " +
         * "quando inserir email e senha validos")
         * 
         * @DisplayName("Test 2 - Validar Login com dados invalidos")
         * public void validarLoginDadosInvalidosTest4(){
         * 
         * LoginDto usu = loginData.LoginDadoDinamicos(); // Criando a massa
         * String msgm = loginPage.loginEmailIncorreto(usu.getEmail(), usu.getSenha());
         * // Executando fluxo
         * Assert.assertEquals(msgm, MENSAGEM_LOGIN_INCORRETO); // Validando o resultado
         * 
         * }
         */
}
