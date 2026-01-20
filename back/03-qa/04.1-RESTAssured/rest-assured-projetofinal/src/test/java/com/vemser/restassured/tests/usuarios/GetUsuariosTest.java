package com.vemser.restassured.tests.usuarios;

import com.vemser.restassured.client.UsuarioClient;
import com.vemser.restassured.factory.UsuarioDataFactory;
import com.vemser.restassured.model.UsuarioModel;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class GetUsuariosTest {

    private final UsuarioClient usuarioClient = new UsuarioClient();

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://host.docker.internal:3000";
    }

    @Test
    @DisplayName("Cenário 22: Listar todos os usuários (Positivo)")
    public void deveListarTodosUsuarios() {
        usuarioClient.listarUsuarios()
                .then()
                .statusCode(200)
                .body("quantidade", greaterThan(0));
    }

    @Test
    @DisplayName("Cenário 23: Buscar usuário por Nome inexistente (Negativo/Vazio)")
    public void deveBuscarUsuarioPorNomeInexistente() {
        usuarioClient.buscarUsuarios("nome", "NomeQueNaoExiste123")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(0))
                .body("usuarios", hasSize(0));
    }

    @Test
    @DisplayName("Cenário 24: Buscar usuário por ID inexistente na Listagem (Negativo/Vazio)")
    public void deveBuscarUsuarioPorIdInexistenteNaListagem() {
        usuarioClient.buscarUsuarios("_id", "id_falso_123")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(0));
    }

    @Test
    @DisplayName("Cenário 25: Buscar usuário por ID existente (Positivo)")
    public void deveBuscarUsuarioPorIdComSucesso() {
        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioValido();
        String idUsuario = usuarioClient.cadastrarUsuario(usuario)
                .then()
                .statusCode(201)
                .extract().path("_id");

        usuarioClient.buscarUsuarioPorId(idUsuario)
                .then()
                .statusCode(200)
                .body("nome", equalTo(usuario.getNome()))
                .body("email", equalTo(usuario.getEmail()));
    }

    @Test
    @DisplayName("Cenário 26: Buscar usuário por ID inexistente (Negativo)")
    public void deveBuscarUsuarioPorIdInexistente() {
        usuarioClient.buscarUsuarioPorId("0000000000000000")
                .then()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"));
    }

    @Test
    @DisplayName("Cenário 27: Buscar usuário após exclusão (Negativo)")
    public void naoDeveBuscarUsuarioAposExclusao() {
        UsuarioModel usuario = UsuarioDataFactory.criarUsuarioValido();
        String idUsuario = usuarioClient.cadastrarUsuario(usuario)
                .then()
                .statusCode(201)
                .extract().path("_id");

        usuarioClient.excluirUsuario(idUsuario).then().statusCode(200);

        usuarioClient.buscarUsuarioPorId(idUsuario)
                .then()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"));
    }
}