package com.petsaude.animal.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import com.petsaude.R;

public class ClinicaMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinica_map);

        Button botao = (Button) findViewById(R.id.buttonCadastro);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(ClinicaMap.this,CadastroAnimal.class);
                startActivity(i);
            }
        });
    }


}
