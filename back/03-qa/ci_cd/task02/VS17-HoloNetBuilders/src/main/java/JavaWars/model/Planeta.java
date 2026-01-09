package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Planeta {
    private String nome;
    private String descricao;
    private List<Missao> listaMissoes;
    private Scanner sc;

    public Planeta(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.listaMissoes = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Missao> getListaMissoes() {
        return listaMissoes;
    }

    public void setListaMissoes(List<Missao> listaMissoes) {
        this.listaMissoes = listaMissoes;
    }

    public void adicionarMissao(Missao missao){
        listaMissoes.add(missao);
    }

}
