package com.vemser.restassured.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.vemser.restassured.model.ProdutoModel;

import static io.restassured.RestAssured.given;

public class ProdutoClient {

    private static final String PRODUTOS_ENDPOINT = "/produtos";

    public Response cadastrarProduto(ProdutoModel produto, String token) {
        return given()
                .log().ifValidationFails()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(produto)
                .when()
                .post(PRODUTOS_ENDPOINT);
    }

    public Response cadastrarProdutoSemToken(ProdutoModel produto) {
        return given()
                .log().ifValidationFails()
                .contentType(ContentType.JSON)
                .body(produto)
                .when()
                .post(PRODUTOS_ENDPOINT);
    }

    public Response listarProdutos() {
        return given()
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .get(PRODUTOS_ENDPOINT);
    }

    public Response buscarProdutos(String query, Object value) {
        return given()
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .queryParam(query, value)
                .when()
                .get(PRODUTOS_ENDPOINT);
    }

    public Response buscarProdutoPorId(String id) {
        return given()
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .get(PRODUTOS_ENDPOINT + "/" + id);
    }

    public Response editarProduto(String id, ProdutoModel produto, String token) {
        return given()
                .log().ifValidationFails()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(produto)
                .when()
                .put(PRODUTOS_ENDPOINT + "/" + id);
    }

    public Response excluirProduto(String id, String token) {
        return given()
                .log().ifValidationFails()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .when()
                .delete(PRODUTOS_ENDPOINT + "/" + id);
    }
}