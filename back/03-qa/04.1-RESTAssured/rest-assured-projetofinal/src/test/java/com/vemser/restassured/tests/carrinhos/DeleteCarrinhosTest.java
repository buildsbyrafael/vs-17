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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class DeleteCarrinhosTest {

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
    @DisplayName("Cenário 36: Cancelar carrinho existente com sucesso (Positivo)")
    public void deveCancelarCarrinhoComSucesso() {
        ProdutoModel produto = ProdutoDataFactory.criarProdutoValido();
        String idProduto = produtoClient.cadastrarProduto(produto, tokenAdmin)
                .then().statusCode(201).extract().path("_id");
        produto.set_id(idProduto);

        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioNaoAdmin();
        usuarioClient.cadastrarUsuario(usuario).then().statusCode(201);
        String tokenUsuario = loginClient.realizarLogin(UsuarioModel.builder()
                        .email(usuario.getEmail()).password(usuario.getPassword()).build())
                .then().statusCode(200).extract().path("authorization");

        CarrinhoModel carrinho = CarrinhoDataFactory.criarCarrinho(produto);
        carrinhoClient.cadastrarCarrinho(carrinho, tokenUsuario).then().statusCode(201);

        carrinhoClient.cancelarCompra(tokenUsuario)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("message", containsString("Registro excluído com sucesso"));
    }

    @Test
    @DisplayName("Cenário 38: Tentar cancelar sem possuir carrinho (Positivo/Idempotente)")
    public void deveTentarCancelarSemCarrinho() {
        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioNaoAdmin();
        usuarioClient.cadastrarUsuario(usuario).then().statusCode(201);
        String tokenUsuario = loginClient.realizarLogin(UsuarioModel.builder()
                        .email(usuario.getEmail()).password(usuario.getPassword()).build())
                .then().statusCode(200).extract().path("authorization");

        carrinhoClient.cancelarCompra(tokenUsuario)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("message", equalTo("Não foi encontrado carrinho para esse usuário"));
    }

    @Test
    @DisplayName("Cenário 39: Tentar cancelar sem Token de acesso (Negativo)")
    public void naoDeveCancelarSemToken() {
        carrinhoClient.cancelarCompra("Bearer token_invalido_123")
                .then()
                .log().ifValidationFails()
                .statusCode(401)
                .body("message", containsString("Token de acesso ausente"));
    }
}