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

import static org.hamcrest.Matchers.*;

public class GetProdutosTest {

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
    @DisplayName("Cenário 28: Listar todos os produtos (Positivo)")
    public void deveListarTodosProdutos() {
        produtoClient.listarProdutos()
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("quantidade", greaterThan(0))
                .body("produtos", hasSize(greaterThan(0)));
    }

    @Test
    @DisplayName("Cenário 29: Buscar produto por Nome inexistente (Negativo/Vazio)")
    public void deveBuscarProdutoPorNomeInexistente() {
        produtoClient.buscarProdutos("nome", "Nave Espacial X")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("quantidade", equalTo(0))
                .body("produtos", hasSize(0));
    }

    @Test
    @DisplayName("Cenário 30: Buscar produto por Preço específico inexistente (Negativo/Vazio)")
    public void deveBuscarProdutoPorPrecoInexistente() {
        produtoClient.buscarProdutos("preco", 9999)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("quantidade", equalTo(0));
    }

    @Test
    @DisplayName("Cenário 31: Buscar produto por ID existente (Positivo)")
    public void deveBuscarProdutoPorIdExistente() {
        ProdutoModel produto = ProdutoDataFactory.criarProdutoComNome("Mouse Postman " + System.nanoTime());
        String idProduto = produtoClient.cadastrarProduto(produto, tokenAdmin)
                .then()
                .statusCode(201)
                .extract().path("_id");

        produtoClient.buscarProdutoPorId(idProduto)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("nome", equalTo(produto.getNome()))
                .body("preco", equalTo(produto.getPreco()))
                .body("descricao", equalTo(produto.getDescricao()));
    }

    @Test
    @DisplayName("Cenário 32: Buscar produto por ID inexistente (Negativo)")
    public void deveBuscarProdutoPorIdInexistente() {
        produtoClient.buscarProdutoPorId("0000000000000000")
                .then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("message", equalTo("Produto não encontrado"));
    }

    @Test
    @DisplayName("Cenário 33: Buscar produto após exclusão (Negativo)")
    public void naoDeveBuscarProdutoAposExclusao() {
        ProdutoModel produto = ProdutoDataFactory.criarProdutoValido();
        String idProduto = produtoClient.cadastrarProduto(produto, tokenAdmin)
                .then().statusCode(201).extract().path("_id");

        produtoClient.excluirProduto(idProduto, tokenAdmin)
                .then()
                .statusCode(200);

        produtoClient.buscarProdutoPorId(idProduto)
                .then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("message", equalTo("Produto não encontrado"));
    }
}