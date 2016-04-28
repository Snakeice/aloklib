package com.github.snakeice.alokframework;

import com.github.snakeice.aloklib.annotations.EBean;

/**
 * For test
 * Created by Rodrigo on 09/04/2016.
 */
@EBean(type = EBean.Type.Normal)
public class MinhaClasseTeste {
    private String nome;
    private String endereco;

    public MinhaClasseTeste() {
    }

    public MinhaClasseTeste(String nome) {
        this.nome = nome;
    }

    public MinhaClasseTeste(String nome, String endereco) {
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
