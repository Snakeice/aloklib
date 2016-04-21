package com.github.snakeice.alokframework;

import com.github.snakeice.aloklib.annotations.EBean;

/**
 * Created by Rodrigo on 09/04/2016.
 */
@EBean(type = EBean.Type.Normal)
public class MinhaClasse {
    private String nome;
    private String endereco;

    public MinhaClasse() {
    }

    public MinhaClasse(String nome) {
        this.nome = nome;
    }

    public MinhaClasse(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
