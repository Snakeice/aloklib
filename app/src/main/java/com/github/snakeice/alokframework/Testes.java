package com.github.snakeice.alokframework;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.snakeice.aloklib.core.ContextRepository;

public class Testes extends AppCompatActivity {
    MinhaClasseTeste pessoa;
    MinhaClassSingleton pessoaSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testes);
        ContextRepository.register(MinhaClasseTeste.class);
        ContextRepository.register(MinhaClassSingleton.class);
        pessoa = ContextRepository.getInstance(MinhaClasseTeste.class, "Rodrigo", "Rua Presidente Castelo Branco");
        ContextRepository.getInstance(MinhaClassSingleton.class, "Singleton", " Teste ");
        pessoaSingleton = ContextRepository.getInstance(MinhaClassSingleton.class);
        new AlertDialog.Builder(this).setTitle(pessoa.getNome()).setMessage(pessoa.getEndereco()).show();
        new AlertDialog.Builder(this).setTitle(pessoaSingleton.getNome()).setMessage(pessoaSingleton.getEndereco()).show();
        System.out.println(pessoa.getNome());
    }
}
