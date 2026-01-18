package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class LoginPositivoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    @DisplayName("Login com Sucesso")
    public void deveRealizarLoginComSucesso() {
        String payload = "{\n" +
                "  \"email\": \"fulano@qa.com\",\n" +
                "  \"password\": \"teste\"\n" +
                "}";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", startsWith("Bearer "));
    }
}