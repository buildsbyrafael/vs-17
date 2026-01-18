package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ExcluirUsuarioPositivoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Excluir usuário com sucesso (Positivo)")
    public void deveExcluirUsuarioComSucesso() {
        String emailAleatorio = "delete." + System.nanoTime() + "@qa.com.br";

        String payload = "{\n" +
                "  \"nome\": \"Usuario Para Deletar\",\n" +
                "  \"email\": \"" + emailAleatorio + "\",\n" +
                "  \"password\": \"1234\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        String idParaExcluir = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/usuarios")
                .then()
                .statusCode(201)
                .extract().path("_id");

        given()
                .log().all()
                .when()
                .delete("/usuarios/" + idParaExcluir)
                .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));
    }
}