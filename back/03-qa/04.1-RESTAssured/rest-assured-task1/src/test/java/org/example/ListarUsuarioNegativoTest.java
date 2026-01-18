package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ListarUsuarioNegativoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Não deve encontrar usuário com ID inexistente (Negativo)")
    public void naoDeveEncontrarUsuarioInexistente() {
        String idInexistente = "0000000000000000";

        given()
                .log().all()
                .when()
                .get("/usuarios/" + idInexistente)
                .then()
                .log().all()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"));
    }
}