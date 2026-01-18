package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class ExcluirUsuarioSemTokenTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Tentar excluir sem Token válido (Negativo)")
    public void naoDeveExcluirSemToken() {
        String idQualquer = "0000000000000000";

        given()
                .log().all()
                .header("Authorization", "Bearer token_invalido_123")
                .when()
                .delete("/usuarios/" + idQualquer)
                .then()
                .log().all()
                .statusCode(401) // Unauthorized
                .body("message", containsString("Token de acesso ausente"));
    }
}