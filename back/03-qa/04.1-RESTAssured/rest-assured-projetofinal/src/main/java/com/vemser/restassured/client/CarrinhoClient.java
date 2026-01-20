package com.vemser.restassured.client;

import com.vemser.restassured.model.CarrinhoModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CarrinhoClient {

    private static final String CARRINHOS_ENDPOINT = "/carrinhos";

    public Response cadastrarCarrinho(CarrinhoModel carrinho, String token) {
        return given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(carrinho)
                .when()
                .post(CARRINHOS_ENDPOINT);
    }

    public Response listarCarrinhos() {
        return given()
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .get(CARRINHOS_ENDPOINT);
    }

    public Response buscarCarrinhos(String query, Object value) {
        return given()
                .contentType(ContentType.JSON)
                .queryParam(query, value)
                .log().ifValidationFails()
                .when()
                .get(CARRINHOS_ENDPOINT);
    }

    public Response buscarCarrinhoPorId(String id) {
        return given()
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .get(CARRINHOS_ENDPOINT + "/" + id);
    }

    public Response cancelarCompra(String token) {
        return given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .delete(CARRINHOS_ENDPOINT + "/cancelar-compra");
    }

    public Response concluirCompra(String token) {
        return given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .when()
                .delete(CARRINHOS_ENDPOINT + "/concluir-compra");
    }
}