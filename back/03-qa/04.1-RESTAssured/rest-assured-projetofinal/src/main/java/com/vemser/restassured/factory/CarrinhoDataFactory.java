package com.vemser.restassured.factory;

import com.vemser.restassured.model.CarrinhoModel;
import com.vemser.restassured.model.ProdutoCarrinhoModel;
import com.vemser.restassured.model.ProdutoModel;

import java.util.List;

public class CarrinhoDataFactory {

    public static CarrinhoModel criarCarrinho(ProdutoModel produto) {
        return CarrinhoModel.builder()
                .produtos(List.of(
                        ProdutoCarrinhoModel.builder()
                                .idProduto(produto.get_id())
                                .quantidade(1)
                                .build()
                ))
                .build();
    }
}