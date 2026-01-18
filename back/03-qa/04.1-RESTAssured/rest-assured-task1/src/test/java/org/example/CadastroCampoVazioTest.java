package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CadastroCampoVazioTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Cadastro com campo obrigatório vazio (Negativo)")
    public void naoDeveCadastrarSemSenha() {
        String payload = "{\n" +
                "  \"nome\": \"Usuario Sem Senha\",\n" +
                "  \"email\": \"usuario.incompleto@qa.com.br\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/usuarios")
                .then()
                .log().all()
                .statusCode(400)
                .body("password", equalTo("password é obrigatório"));
    }
}