package com.vemser.restassured.tests.usuarios;

import com.vemser.restassured.client.UsuarioClient;
import com.vemser.restassured.factory.UsuarioDataFactory;
import com.vemser.restassured.model.UsuarioModel;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostUsuariosTest {

    private final UsuarioClient usuarioClient = new UsuarioClient();

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://host.docker.internal:3000";
    }

    @Test
    @DisplayName("Cenário 04: Cadastrar novo usuário administrador (Positivo)")
    public void deveCadastrarUsuarioComSucesso() {
        UsuarioModel usuarioValido = UsuarioDataFactory.criarUsuarioValido();

        usuarioClient.cadastrarUsuario(usuarioValido)
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"));
    }

    @Test
    @DisplayName("Cenário 05: Cadastro com email duplicado (Negativo)")
    public void naoDeveCadastrarUsuarioComEmailDuplicado() {
        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioValido();
        usuarioClient.cadastrarUsuario(usuario)
                .then().statusCode(201);

        usuarioClient.cadastrarUsuario(usuario)
                .then()
                .statusCode(400)
                .body("message", equalTo("Este email já está sendo usado"));
    }

    @Test
    @DisplayName("Cenário 06: Cadastro com campo obrigatório vazio (Negativo)")
    public void naoDeveCadastrarSemSenha() {
        UsuarioModel usuarioSemSenha = UsuarioDataFactory.criarUsuarioSemSenha();

        usuarioClient.cadastrarUsuario(usuarioSemSenha)
                .then()
                .statusCode(400)
                .body("password", equalTo("password é obrigatório"));
    }
}