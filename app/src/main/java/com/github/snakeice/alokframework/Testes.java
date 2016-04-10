package com.github.snakeice.alokframework;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.snakeice.aloklib.classtools.ClassFactory;

public class Testes extends AppCompatActivity {
    minhaClasse pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testes);
        pessoa = ClassFactory.getInstance(minhaClasse.class,"Rodrigo", "Rua Presidente Castelo Branco");
        new AlertDialog.Builder(this).setTitle(pessoa.getNome()).setMessage(pessoa.getEndereco()).show();
        System.out.println(pessoa.getNome());
    }
}
