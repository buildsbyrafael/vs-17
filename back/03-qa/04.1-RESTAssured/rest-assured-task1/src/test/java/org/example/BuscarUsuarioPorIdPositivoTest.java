package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BuscarUsuarioPorIdPositivoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Buscar Usuário por ID com Sucesso (Positivo)")
    public void deveBuscarUsuarioPorIdComSucesso() {
        String idUsuario = "0uxuPY0cbmQhpEz1";

        given()
                .log().all()
                .when()
                .get("/usuarios/" + idUsuario)
                .then()
                .log().all()
                .statusCode(200) //
                .body("nome", equalTo("Fulano da Silva"))
                .body("_id", equalTo(idUsuario));
    }
}