package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginNegativoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Login com Credenciais Inválidas (Negativo)")
    public void deveRetornarErroComCredenciaisInvalidas() {
        String payload = "{\n" +
                "  \"email\": \"emailerrado@qa.com\",\n" +
                "  \"password\": \"senhaerrada\"\n" +
                "}";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(401) // Unauthorized
                .body("message", equalTo("Email e/ou senha inválidos"));
    }
}