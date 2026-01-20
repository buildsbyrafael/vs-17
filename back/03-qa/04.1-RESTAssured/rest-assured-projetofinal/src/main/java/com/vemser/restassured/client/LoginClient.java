package com.vemser.restassured.client;

import com.vemser.restassured.model.UsuarioModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginClient {

    private static final String LOGIN_ENDPOINT = "/login";

    public Response realizarLogin(UsuarioModel usuario) {
        return given()
                .contentType(ContentType.JSON)
                .body(usuario)
                .when()
                .post(LOGIN_ENDPOINT);
    }
}