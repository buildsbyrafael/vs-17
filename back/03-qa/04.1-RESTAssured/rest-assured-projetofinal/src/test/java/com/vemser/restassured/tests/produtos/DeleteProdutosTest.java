package com.vemser.restassured.tests.produtos;

import com.vemser.restassured.client.LoginClient;
import com.vemser.restassured.client.ProdutoClient;
import com.vemser.restassured.client.UsuarioClient;
import com.vemser.restassured.factory.ProdutoDataFactory;
import com.vemser.restassured.factory.UsuarioDataFactory;
import com.vemser.restassured.model.ProdutoModel;
import com.vemser.restassured.model.UsuarioModel;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class DeleteProdutosTest {

    private static final ProdutoClient produtoClient = new ProdutoClient();
    private static final UsuarioClient usuarioClient = new UsuarioClient();
    private static final LoginClient loginClient = new LoginClient();
    private static String tokenAdmin;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://host.docker.internal:3000";

        UsuarioModel admin = UsuarioDataFactory.criarUsuarioValido();
        usuarioClient.cadastrarUsuario(admin).then().statusCode(201);

        UsuarioModel loginData = UsuarioModel.builder()
                .email(admin.getEmail())
                .password(admin.getPassword())
                .build();

        tokenAdmin = loginClient.realizarLogin(loginData)
                .then().statusCode(200).extract().path("authorization");
    }

    @Test
    @DisplayName("Cenário 13: Excluir produto com sucesso (Positivo)")
    public void deveExcluirProdutoComSucesso() {
        ProdutoModel produto = ProdutoDataFactory.criarProdutoComNome("Logitech MX Horizontal " + System.nanoTime());
        String idProduto = produtoClient.cadastrarProduto(produto, tokenAdmin)
                .then().statusCode(201).extract().path("_id");

        produtoClient.excluirProduto(idProduto, tokenAdmin)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));
    }

    @Test
    @DisplayName("Cenário 14: Excluir produto que não existe (Negativo)")
    public void deveTentarExcluirProdutoInexistente() {
        String idInexistente = "0000000000000000";

        produtoClient.excluirProduto(idInexistente, tokenAdmin)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("message", equalTo("Nenhum registro excluído"));
    }

    @Test
    @DisplayName("Cenário 15: Excluir produto sem Token de Acesso (Negativo)")
    public void naoDeveExcluirProdutoSemToken() {
        ProdutoModel produto = ProdutoDataFactory.criarProdutoValido();
        String idProduto = produtoClient.cadastrarProduto(produto, tokenAdmin)
                .then().extract().path("_id");

        produtoClient.excluirProduto(idProduto, "Bearer token_invalido_123")
                .then()
                .log().ifValidationFails()
                .statusCode(401)
                .body("message", containsString("Token de acesso ausente"));
    }
}