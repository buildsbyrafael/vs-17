package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EditarUsuarioEmailDuplicadoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Editar usuário com um e-mail já cadastrado (Negativo)")
    public void naoDeveEditarComEmailExistente() {
        String emailExistente = "existente." + System.nanoTime() + "@gmail.com";
        String payloadUserExistente = "{\n" +
                "  \"nome\": \"Usuario Existente\",\n" +
                "  \"email\": \"" + emailExistente + "\",\n" +
                "  \"password\": \"1234\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(payloadUserExistente)
                .post("/usuarios")
                .then()
                .statusCode(201);

        String emailParaEditar = "editar." + System.nanoTime() + "@gmail.com";
        String payloadUserParaEditar = "{\n" +
                "  \"nome\": \"Usuario Para Editar\",\n" +
                "  \"email\": \"" + emailParaEditar + "\",\n" +
                "  \"password\": \"1234\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        String idUsuario = given()
                .contentType(ContentType.JSON)
                .body(payloadUserParaEditar)
                .post("/usuarios")
                .then()
                .statusCode(201)
                .extract().path("_id");

        String payloadEdicao = "{\n" +
                "  \"nome\": \"Vitor QATeste\",\n" +
                "  \"email\": \"" + emailExistente + "\",\n" +
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
                .body("message", equalTo("Este email já está sendo usado"));
    }
}