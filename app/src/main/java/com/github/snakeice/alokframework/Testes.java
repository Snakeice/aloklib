package com.github.snakeice.alokframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.snakeice.aloklib.classtools.ClassFactory;

public class Testes extends AppCompatActivity {
    minhaClasse pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testes);
        pessoa = ClassFactory.getInstance(minhaClasse.class,"Rodrigo");
        System.out.println(pessoa.getNome());
    }
}
