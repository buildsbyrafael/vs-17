package com.vemser.restassured.factory;

import com.github.javafaker.Faker;
import com.vemser.restassured.model.ProdutoModel;
import java.util.Locale;

public class ProdutoDataFactory {

    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public static ProdutoModel criarProdutoValido() {
        return ProdutoModel.builder()
                .nome(faker.commerce().productName() + " " + System.nanoTime()) // Garante nome único
                .preco(faker.number().numberBetween(10, 1000))
                .descricao(faker.commerce().material())
                .quantidade(faker.number().numberBetween(1, 100))
                .build();
    }

    public static ProdutoModel criarProdutoComNome(String nome) {
        return ProdutoModel.builder()
                .nome(nome)
                .preco(150)
                .descricao("Produto de Teste")
                .quantidade(10)
                .build();
    }
}