package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ExcluirUsuarioInexistenteTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Tentar excluir usuário inexistente (Negativo)")
    public void deveRetornarMensagemNenhumRegistroExcluido() {
        String idInexistente = "0000000000000000";

        given()
                .log().all()
                .when()
                .delete("/usuarios/" + idInexistente)
                .then()
                .log().all()
                .statusCode(200) // Conforme seu Gherkin
                .body("message", equalTo("Nenhum registro excluído"));
    }
}