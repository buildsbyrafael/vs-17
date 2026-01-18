package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CadastrarUsuarioPositivoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Cadastrar Usuário com Sucesso (Positivo)")
    public void deveCadastrarUsuarioComSucesso() {
        String emailAleatorio = "usuario" + System.nanoTime() + "@qa.com.br";

        String payload = "{\n" +
                "  \"nome\": \"Usuario Teste Java\",\n" +
                "  \"email\": \"" + emailAleatorio + "\",\n" +
                "  \"password\": \"1234\",\n" +
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
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", notNullValue());
    }
}