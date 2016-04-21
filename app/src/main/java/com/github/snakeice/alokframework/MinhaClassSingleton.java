package com.github.snakeice.alokframework;

import com.github.snakeice.aloklib.annotations.EBean;

/**
 * Created by Rodrigo on 17/04/2016.
 */
@EBean(type = EBean.Type.Singleton)
public class MinhaClassSingleton {
    private String nome;
    private String endereco;

    public MinhaClassSingleton() {
    }

    public MinhaClassSingleton(String nome) {
        this.nome = nome;
    }

    public MinhaClassSingleton(String nome, String endereco) {
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
