package com.vemser.restassured.tests.login;

import com.vemser.restassured.client.LoginClient;
import com.vemser.restassured.model.UsuarioModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class LoginTest {

    private final LoginClient loginClient = new LoginClient();

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://host.docker.internal:3000";
    }

    @Test
    @DisplayName("Cenário 01: Login com credenciais válidas (Positivo)")
    public void deveRealizarLoginComSucesso() {
        UsuarioModel usuarioValido = UsuarioModel.builder()
                .email("fulano@qa.com")
                .password("teste")
                .build();

        Response response = loginClient.realizarLogin(usuarioValido);

        response.then()
                .statusCode(200)
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", startsWith("Bearer"));
    }

    @Test
    @DisplayName("Cenário 02: Login com senha incorreta (Negativo)")
    public void naoDeveLogarComSenhaIncorreta() {
        UsuarioModel usuarioSenhaErrada = UsuarioModel.builder()
                .email("fulano@qa.com")
                .password("senhaerrada")
                .build();

        loginClient.realizarLogin(usuarioSenhaErrada)
                .then()
                .statusCode(401)
                .body("message", equalTo("Email e/ou senha inválidos"));
    }

    @Test
    @DisplayName("Cenário 03: Login com formato de email inválido (Negativo)")
    public void naoDeveLogarComEmailInvalido() {
        UsuarioModel usuarioEmailInvalido = UsuarioModel.builder()
                .email("emailsemarroba.com")
                .password("1234")
                .build();

        loginClient.realizarLogin(usuarioEmailInvalido)
                .then()
                .statusCode(400)
                .body("email", equalTo("email deve ser um email válido"));
    }
}