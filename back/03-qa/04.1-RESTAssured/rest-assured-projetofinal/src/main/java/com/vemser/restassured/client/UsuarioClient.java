package com.vemser.restassured.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.vemser.restassured.model.UsuarioModel;

import static io.restassured.RestAssured.given;

public class UsuarioClient {

    private static final String USUARIOS_ENDPOINT = "/usuarios";

    public Response cadastrarUsuario(UsuarioModel usuario) {
        return given()
                .contentType(ContentType.JSON)
                .body(usuario)
                .when()
                .post(USUARIOS_ENDPOINT);
    }

    public Response listarUsuarios() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(USUARIOS_ENDPOINT);
    }

    public Response buscarUsuarios(String query, String value) {
        return given()
                .contentType(ContentType.JSON)
                .queryParam(query, value)
                .when()
                .get(USUARIOS_ENDPOINT);
    }

    public Response buscarUsuarioPorId(String id) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(USUARIOS_ENDPOINT + "/" + id);
    }

    public Response editarUsuario(String id, UsuarioModel usuario) {
        return given()
                .contentType(ContentType.JSON)
                .body(usuario)
                .when()
                .put(USUARIOS_ENDPOINT + "/" + id);
    }

    public Response excluirUsuario(String id) {
        return given()
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .delete(USUARIOS_ENDPOINT + "/" + id);
    }

    public Response excluirUsuarioComToken(String id, String token) {
        return given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .delete(USUARIOS_ENDPOINT + "/" + id);
    }
}