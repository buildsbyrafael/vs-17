package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ListarUsuariosPositivoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Listar Usuários")
    public void deveListarUsuariosComSucesso() {
        given()
                .log().all()
                .when()
                .get("/usuarios")
                .then()
                .log().all()
                .statusCode(200)
                .body("quantidade", greaterThanOrEqualTo(0))
                .body("usuarios", hasSize(greaterThan(0)));
    }
}