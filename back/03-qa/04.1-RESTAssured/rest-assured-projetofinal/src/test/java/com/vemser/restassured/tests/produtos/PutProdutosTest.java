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

import static org.hamcrest.Matchers.equalTo;

public class PutProdutosTest {

    private static final ProdutoClient produtoClient = new ProdutoClient();
    private static final UsuarioClient usuarioClient = new UsuarioClient();
    private static final LoginClient loginClient = new LoginClient();
    private static String tokenAdmin;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";

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
    @DisplayName("Cenário 10: Editar produto com sucesso (Positivo)")
    public void deveEditarProdutoComSucesso() {
        ProdutoModel produtoParaTeste = ProdutoDataFactory.criarProdutoValido();
        String idParaEditar = produtoClient.cadastrarProduto(produtoParaTeste, tokenAdmin)
                .then().statusCode(201).extract().path("_id");

        ProdutoModel produtoEditado = ProdutoModel.builder()
                .nome("Logitech MX Vertical Editado " + System.nanoTime())
                .preco(999)
                .descricao("Mouse")
                .quantidade(381)
                .build();

        produtoClient.editarProduto(idParaEditar, produtoEditado, tokenAdmin)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));
    }

    @Test
    @DisplayName("Cenário 11: Editar produto sem permissão de administrador (Negativo)")
    public void naoDeveEditarProdutoSemPermissao() {
        ProdutoModel produtoAdmin = ProdutoDataFactory.criarProdutoValido();
        String idProduto = produtoClient.cadastrarProduto(produtoAdmin, tokenAdmin)
                .then().statusCode(201).extract().path("_id");

        UsuarioModel usuarioComum = UsuarioDataFactory.criarUsuarioNaoAdmin();
        usuarioClient.cadastrarUsuario(usuarioComum).then().statusCode(201);

        UsuarioModel loginComum = UsuarioModel.builder()
                .email(usuarioComum.getEmail())
                .password(usuarioComum.getPassword())
                .build();

        String tokenUsuarioComum = loginClient.realizarLogin(loginComum)
                .then().statusCode(200).extract().path("authorization");

        produtoClient.editarProduto(idProduto, produtoAdmin, tokenUsuarioComum)
                .then()
                .log().ifValidationFails()
                .statusCode(403)
                .body("message", equalTo("Rota exclusiva para administradores"));
    }

    @Test
    @DisplayName("Cenário 12: Editar quantidade do produto para número negativo (Negativo)")
    public void naoDeveEditarComQuantidadeNegativa() {
        ProdutoModel produto = ProdutoDataFactory.criarProdutoValido();
        String idProduto = produtoClient.cadastrarProduto(produto, tokenAdmin)
                .then().statusCode(201).extract().path("_id");

        produto.setQuantidade(-1);

        produtoClient.editarProduto(idProduto, produto, tokenAdmin)
                .then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("quantidade", equalTo("quantidade deve ser maior ou igual a 0"));
    }
}