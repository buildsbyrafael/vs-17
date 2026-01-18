package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EditarUsuarioEmailInvalidoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Editar usuário com formato de e-mail inválido (Negativo)")
    public void naoDeveEditarComEmailInvalido() {
        String emailOriginal = "temp." + System.nanoTime() + "@qa.com.br";
        String payloadCriacao = "{\n" +
                "  \"nome\": \"Usuario Temp\",\n" +
                "  \"email\": \"" + emailOriginal + "\",\n" +
                "  \"password\": \"1234\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        String idUsuario = given()
                .contentType(ContentType.JSON)
                .body(payloadCriacao)
                .post("/usuarios")
                .then()
                .statusCode(201)
                .extract().path("_id");

        String payloadEdicao = "{\n" +
                "  \"nome\": \"Vitor QATeste\",\n" +
                "  \"email\": \"vitorqagmail.com\",\n" +
                "  \"password\": \"teste\",\n" +
                "  \"administrador\": \"false\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(payloadEdicao)
                .when()
                .put("/usuarios/" + idUsuario)
                .then()
                .statusCode(400)
                .body("email", equalTo("email deve ser um email válido"));
    }
}