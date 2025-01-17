package com.petsaude.animal.gui;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.petsaude.R;
import com.petsaude.animal.dominio.Animal;
import com.petsaude.usuario.gui.PerfilAct;

public class PerfilAnimalAct extends AppCompatActivity {

    private static Animal petSelecionado;
    public static void setAnimalSeleciona(Animal pet){
        petSelecionado = pet;
    }

    public void onBackPressed(){
        Intent intent = new Intent(PerfilAnimalAct.this,PerfilAct.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_animal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        setTitle(petSelecionado.getNome());

        final Button atualizarAnimal = (Button) findViewById(R.id.atualizar_animal);
        final TextView nome = (TextView) findViewById(R.id.nome_animal);
        final TextView raca = (TextView) findViewById(R.id.raca);
        final TextView dataNascimento = (TextView) findViewById(R.id.data_nasc);
        final TextView peso = (TextView) findViewById(R.id.peso);

        if (petSelecionado.getNome().isEmpty()){
            nome.append("-");
        }else{
            nome.append(petSelecionado.getNome());
        }

        if (petSelecionado.getRaca().isEmpty()){
            raca.append("-");
        }else{
            raca.append(petSelecionado.getRaca());
        }
        
        if (petSelecionado.getDataNasc().isEmpty()){
            dataNascimento.append("-");
        }else{
            dataNascimento.append(petSelecionado.getDataNasc());
        }

        if ((""+petSelecionado.getPeso()).isEmpty()){
            peso.append("-");
        }else{
            peso.append(""+petSelecionado.getPeso());
        }


        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        atualizarAnimal.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //implementar classe onde vai ser possivel atualizar os dados do animal
            }
        }));
    }
}
