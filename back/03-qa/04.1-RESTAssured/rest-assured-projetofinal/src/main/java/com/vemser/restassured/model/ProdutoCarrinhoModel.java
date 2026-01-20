package com.vemser.restassured.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCarrinhoModel {
    private String idProduto;
    private Integer quantidade;
}