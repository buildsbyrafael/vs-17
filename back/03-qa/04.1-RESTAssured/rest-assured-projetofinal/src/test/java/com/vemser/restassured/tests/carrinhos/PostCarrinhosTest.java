package com.vemser.restassured.tests.carrinhos;

import com.vemser.restassured.client.CarrinhoClient;
import com.vemser.restassured.client.LoginClient;
import com.vemser.restassured.client.ProdutoClient;
import com.vemser.restassured.client.UsuarioClient;
import com.vemser.restassured.factory.CarrinhoDataFactory;
import com.vemser.restassured.factory.ProdutoDataFactory;
import com.vemser.restassured.factory.UsuarioDataFactory;
import com.vemser.restassured.model.CarrinhoModel;
import com.vemser.restassured.model.ProdutoModel;
import com.vemser.restassured.model.UsuarioModel;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostCarrinhosTest {

    private static final UsuarioClient usuarioClient = new UsuarioClient();
    private static final LoginClient loginClient = new LoginClient();
    private static final ProdutoClient produtoClient = new ProdutoClient();
    private static final CarrinhoClient carrinhoClient = new CarrinhoClient();

    private static String tokenAdmin;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000";

        UsuarioModel admin = UsuarioDataFactory.criarUsuarioValido();
        usuarioClient.cadastrarUsuario(admin).then().statusCode(201);

        tokenAdmin = loginClient.realizarLogin(UsuarioModel.builder()
                        .email(admin.getEmail()).password(admin.getPassword()).build())
                .then().extract().path("authorization");
    }

    @Test
    @DisplayName("Cenário 34: Cadastrar carrinho com sucesso (Positivo)")
    public void deveCadastrarCarrinhoComSucesso() {
        ProdutoModel produto = ProdutoDataFactory.criarProdutoValido();
        String idProduto = produtoClient.cadastrarProduto(produto, tokenAdmin)
                .then().statusCode(201).extract().path("_id");
        produto.set_id(idProduto);

        UsuarioModel usuarioComum = UsuarioDataFactory.criarUsuarioNaoAdmin();
        usuarioClient.cadastrarUsuario(usuarioComum).then().statusCode(201);

        String tokenUsuario = loginClient.realizarLogin(UsuarioModel.builder()
                        .email(usuarioComum.getEmail()).password(usuarioComum.getPassword()).build())
                .then().statusCode(200).extract().path("authorization");

        CarrinhoModel carrinho = CarrinhoDataFactory.criarCarrinho(produto);

        carrinhoClient.cadastrarCarrinho(carrinho, tokenUsuario)
                .then()
                .log().ifValidationFails()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"));
    }

    @Test
    @DisplayName("Cenário 35: Tentar cadastrar segundo carrinho para mesmo usuário (Negativo)")
    public void naoDeveCadastrarDoisCarrinhosParaMesmoUsuario() {
        ProdutoModel produto = ProdutoDataFactory.criarProdutoValido();
        String idProduto = produtoClient.cadastrarProduto(produto, tokenAdmin)
                .then().statusCode(201).extract().path("_id");
        produto.set_id(idProduto);

        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioNaoAdmin();
        usuarioClient.cadastrarUsuario(usuario).then().statusCode(201);
        String token = loginClient.realizarLogin(UsuarioModel.builder()
                        .email(usuario.getEmail()).password(usuario.getPassword()).build())
                .then().extract().path("authorization");

        CarrinhoModel carrinho = CarrinhoDataFactory.criarCarrinho(produto);
        carrinhoClient.cadastrarCarrinho(carrinho, token).then().statusCode(201);

        carrinhoClient.cadastrarCarrinho(carrinho, token)
                .then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("message", equalTo("Não é permitido ter mais de 1 carrinho"));
    }

    @Test
    @DisplayName("Cenário 37: Cadastrar carrinho com produto inexistente (Negativo)")
    public void naoDeveCadastrarCarrinhoComProdutoInexistente() {
        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioNaoAdmin();
        usuarioClient.cadastrarUsuario(usuario).then().statusCode(201);
        String token = loginClient.realizarLogin(UsuarioModel.builder()
                        .email(usuario.getEmail()).password(usuario.getPassword()).build())
                .then().extract().path("authorization");

        ProdutoModel produtoFalso = new ProdutoModel();
        produtoFalso.set_id("id_inexistente_123");
        CarrinhoModel carrinho = CarrinhoDataFactory.criarCarrinho(produtoFalso);

        carrinhoClient.cadastrarCarrinho(carrinho, token)
                .then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("message", equalTo("Produto não encontrado"));
    }
}