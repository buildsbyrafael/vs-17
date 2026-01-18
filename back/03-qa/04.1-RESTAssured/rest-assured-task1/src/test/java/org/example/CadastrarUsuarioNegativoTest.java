package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CadastrarUsuarioNegativoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Não deve cadastrar email duplicado (Negativo)")
    public void naoDeveCadastrarUsuarioComEmailExistente() {
        String payload = "{\n" +
                "  \"nome\": \"Fulano da Silva\",\n" +
                "  \"email\": \"fulano@qa.com\",\n" +
                "  \"password\": \"teste\",\n" +
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
                .body("message", equalTo("Este email já está sendo usado"));
    }
}