package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EditarUsuarioPositivoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Editar usuário com sucesso (Positivo)")
    public void deveEditarUsuarioComSucesso() {
        String emailOriginal = "original." + System.nanoTime() + "@qa.com.br";
        String payloadCriacao = "{\n" +
                "  \"nome\": \"Usuario Original\",\n" +
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

        String emailNovo = "vitorqa" + System.nanoTime() + "@gmail.com";
        String payloadEdicao = "{\n" +
                "  \"nome\": \"Vitor QATeste\",\n" +
                "  \"email\": \"" + emailNovo + "\",\n" +
                "  \"password\": \"teste\",\n" +
                "  \"administrador\": \"false\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(payloadEdicao)
                .when()
                .put("/usuarios/" + idUsuario)
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));
    }
}