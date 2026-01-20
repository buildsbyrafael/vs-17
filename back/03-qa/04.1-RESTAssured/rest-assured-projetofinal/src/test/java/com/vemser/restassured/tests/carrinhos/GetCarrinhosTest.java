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

import static org.hamcrest.Matchers.*;

public class GetCarrinhosTest {

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
    @DisplayName("Cenário 43: Listar todos os carrinhos (Positivo)")
    public void deveListarTodosCarrinhos() {
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

        carrinhoClient.listarCarrinhos()
                .then()
                .statusCode(200)
                .body("quantidade", greaterThan(0))
                .body("carrinhos[0].produtos[0].idProduto", notNullValue())
                .body("carrinhos[0].produtos[0].quantidade", notNullValue())
                .body("carrinhos[0].produtos[0].precoUnitario", notNullValue())
                .body("carrinhos[0].precoTotal", notNullValue())
                .body("carrinhos[0].quantidadeTotal", notNullValue())
                .body("carrinhos[0].idUsuario", notNullValue())
                .body("carrinhos[0]._id", notNullValue());
    }

    @Test
    @DisplayName("Cenário 44: Buscar carrinho por id inexistente (Negativo/Vazio)")
    public void deveBuscarCarrinhoPorIdInexistenteNaListagem() {
        carrinhoClient.buscarCarrinhos("_id", "id_que_nao_existe_123")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(0))
                .body("carrinhos", hasSize(0));
    }

    @Test
    @DisplayName("Cenário 45: Buscar produto por Preço Total inexistente (Negativo/Vazio)")
    public void deveBuscarCarrinhoPorPrecoTotalInexistente() {
        carrinhoClient.buscarCarrinhos("precoTotal", 99999999)
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(0));
    }

    @Test
    @DisplayName("Cenário 46: Buscar carrinho por ID existente (Positivo)")
    public void deveBuscarCarrinhoPorIdExistente() {
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
        String idCarrinho = carrinhoClient.cadastrarCarrinho(carrinho, token)
                .then().statusCode(201).extract().path("_id");

        carrinhoClient.buscarCarrinhoPorId(idCarrinho)
                .then()
                .statusCode(200)
                .body("produtos[0].idProduto", equalTo(idProduto))
                .body("_id", equalTo(idCarrinho));
    }

    @Test
    @DisplayName("Cenário 47: Buscar carrinho por ID inexistente (Negativo)")
    public void deveBuscarCarrinhoPorIdInexistente() {
        carrinhoClient.buscarCarrinhoPorId("0000000000000000")
                .then()
                .statusCode(400)
                .body("message", equalTo("Carrinho não encontrado"));
    }

    @Test
    @DisplayName("Cenário 48: Buscar carrinho após exclusão (Negativo)")
    public void naoDeveBuscarCarrinhoAposExclusao() {
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
        String idCarrinho = carrinhoClient.cadastrarCarrinho(carrinho, token)
                .then().statusCode(201).extract().path("_id");

        carrinhoClient.cancelarCompra(token).then().statusCode(200);

        carrinhoClient.buscarCarrinhoPorId(idCarrinho)
                .then()
                .statusCode(400)
                .body("message", equalTo("Carrinho não encontrado"));
    }
}