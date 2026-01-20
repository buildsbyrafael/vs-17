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

public class PostProdutosTest {

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
    @DisplayName("Cenário 07: Cadastrar produto com sucesso (Positivo)")
    public void deveCadastrarProdutoComSucesso() {
        ProdutoModel produtoNovo = ProdutoDataFactory.criarProdutoValido();

        produtoClient.cadastrarProduto(produtoNovo, tokenAdmin)
                .then()
                .log().ifValidationFails()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"));
    }

    @Test
    @DisplayName("Cenário 08: Cadastrar produto com nome duplicado (Negativo)")
    public void naoDeveCadastrarProdutoComNomeDuplicado() {
        ProdutoModel produtoDuplicado = ProdutoDataFactory.criarProdutoComNome("Teclado Postman");
        produtoClient.cadastrarProduto(produtoDuplicado, tokenAdmin);

        produtoClient.cadastrarProduto(produtoDuplicado, tokenAdmin)
                .then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("message", equalTo("Já existe produto com esse nome"));
    }

    @Test
    @DisplayName("Cenário 09: Cadastrar produto sem Token de acesso (Negativo)")
    public void naoDeveCadastrarProdutoSemToken() {
        ProdutoModel produto = ProdutoDataFactory.criarProdutoValido();

        produtoClient.cadastrarProdutoSemToken(produto)
                .then()
                .log().ifValidationFails()
                .statusCode(401)
                .body("message", containsString("Token de acesso ausente"));
    }
}