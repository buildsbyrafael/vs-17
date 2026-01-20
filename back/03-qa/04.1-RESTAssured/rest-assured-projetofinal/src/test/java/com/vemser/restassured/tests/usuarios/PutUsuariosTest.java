package com.vemser.restassured.tests.usuarios;

import com.vemser.restassured.client.UsuarioClient;
import com.vemser.restassured.factory.UsuarioDataFactory;
import com.vemser.restassured.model.UsuarioModel;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class PutUsuariosTest {

    private final UsuarioClient usuarioClient = new UsuarioClient();

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://host.docker.internal:3000";
    }

    @Test
    @DisplayName("Cenário 19: Editar usuário com sucesso (Positivo)")
    public void deveEditarUsuarioComSucesso() {
        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioValido();
        String idUsuario = usuarioClient.cadastrarUsuario(usuario)
                .then()
                .statusCode(201)
                .extract().path("_id");

        UsuarioModel usuarioEditado = UsuarioModel.builder()
                .nome("Vitor QATeste")
                .email("vitorqa" + System.nanoTime() + "@gmail.com")
                .password("teste")
                .administrador("false")
                .build();

        usuarioClient.editarUsuario(idUsuario, usuarioEditado)
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));
    }

    @Test
    @DisplayName("Cenário 20: Editar usuário com formato de e-mail inválido (Negativo)")
    public void naoDeveEditarUsuarioComEmailInvalido() {
        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioValido();
        String idUsuario = usuarioClient.cadastrarUsuario(usuario)
                .then()
                .statusCode(201)
                .extract().path("_id");

        UsuarioModel usuarioInvalido = UsuarioModel.builder()
                .nome("Vitor QATeste")
                .email("vitorqagmail.com")
                .password("teste")
                .administrador("false")
                .build();

        usuarioClient.editarUsuario(idUsuario, usuarioInvalido)
                .then()
                .statusCode(400)
                .body("email", equalTo("email deve ser um email válido"));
    }

    @Test
    @DisplayName("Cenário 21: Editar usuário com um e-mail já cadastrado (Negativo)")
    public void naoDeveEditarUsuarioComEmailDuplicado() {
        UsuarioModel usuarioExistente = UsuarioDataFactory.criarUsuarioValido();
        usuarioClient.cadastrarUsuario(usuarioExistente).then().statusCode(201);
        String emailOcupado = usuarioExistente.getEmail();

        UsuarioModel usuarioParaEditar = UsuarioDataFactory.criarUsuarioValido();
        String idUsuario = usuarioClient.cadastrarUsuario(usuarioParaEditar)
                .then()
                .statusCode(201)
                .extract().path("_id");

        UsuarioModel dadosEditados = UsuarioModel.builder()
                .nome("Vitor QATeste")
                .email(emailOcupado)
                .password("teste")
                .administrador("false")
                .build();

        usuarioClient.editarUsuario(idUsuario, dadosEditados)
                .then()
                .statusCode(400)
                .body("message", equalTo("Este email já está sendo usado"));
    }
}