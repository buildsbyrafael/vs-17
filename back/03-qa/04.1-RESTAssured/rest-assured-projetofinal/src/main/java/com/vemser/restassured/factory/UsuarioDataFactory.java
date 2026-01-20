package com.vemser.restassured.factory;

import com.github.javafaker.Faker;
import com.vemser.restassured.model.UsuarioModel;

import java.util.Locale;

public class UsuarioDataFactory {

    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public static UsuarioModel criarUsuarioValido() {
        return UsuarioModel.builder()
                .nome(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .password("1234")
                .administrador("true")
                .build();
    }

    public static UsuarioModel criarUsuarioNaoAdmin() {
        return UsuarioModel.builder()
                .nome(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .password("1234")
                .administrador("false")
                .build();
    }

    public static UsuarioModel criarUsuarioSemSenha() {
        UsuarioModel usuario = criarUsuarioValido();
        usuario.setPassword(null);
        return usuario;
    }
}