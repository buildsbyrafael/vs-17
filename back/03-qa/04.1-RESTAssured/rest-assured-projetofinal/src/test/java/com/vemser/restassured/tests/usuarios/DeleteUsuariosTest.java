package com.vemser.restassured.tests.usuarios;

import com.vemser.restassured.client.UsuarioClient;
import com.vemser.restassured.factory.UsuarioDataFactory;
import com.vemser.restassured.model.UsuarioModel;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUsuariosTest {

    private final UsuarioClient usuarioClient = new UsuarioClient();

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://host.docker.internal:3000";
    }

    @Test
    @DisplayName("Cenário 16: Excluir usuário com sucesso (Positivo)")
    public void deveExcluirUsuarioComSucesso() {
        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioValido();
        String idUsuario = usuarioClient.cadastrarUsuario(usuario)
                .then()
                .statusCode(201)
                .extract().path("_id");

        usuarioClient.excluirUsuario(idUsuario)
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));
    }

    @Test
    @DisplayName("Cenário 17: Excluir usuário que não existe (Negativo)")
    public void deveTentarExcluirUsuarioInexistente() {
        String idInexistente = "0000000000000000";

        usuarioClient.excluirUsuario(idInexistente)
                .then()
                .statusCode(200)
                .body("message", equalTo("Nenhum registro excluído"));
    }

    @Test
    @DisplayName("Cenário 18: Excluir usuário sem Token de Acesso (Negativo)")
    public void naoDeveExcluirUsuarioSemToken() {
        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioValido();
        String idUsuario = usuarioClient.cadastrarUsuario(usuario)
                .then()
                .statusCode(201)
                .extract().path("_id");

        usuarioClient.excluirUsuarioComToken(idUsuario, "Bearer token_invalido")
                .then()
                .statusCode(401)
                .body("message", containsString("Token de acesso ausente"));
    }
}