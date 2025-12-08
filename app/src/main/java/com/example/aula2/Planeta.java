package com.example.aula2;
//criar o planeta, fazendo a variavel nome e img ser carregada no objeto planeta ao invés de ter que carregaer uma a uma
public class Planeta {
    private String nome;
    private int img;

    public Planeta(String nome, int img) {
        this.nome = nome;
        this.img = img;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
