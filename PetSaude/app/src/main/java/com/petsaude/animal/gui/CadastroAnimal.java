package com.petsaude.animal.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.petsaude.R;
import com.petsaude.animal.dominio.Animal;
import com.petsaude.animal.negocio.AnimalService;
import com.petsaude.usuario.dominio.Session;

public class CadastroAnimal extends AppCompatActivity {

    final AnimalService negocio = new AnimalService(CadastroAnimal.this);


    public void limpaDados(EditText nome,EditText dataNasc,Spinner cor,Spinner genero,Spinner raca, EditText peso, Spinner sexo){
        nome.setText("");
        dataNasc.setText("");
        cor.setSelection(0);
        genero.setSelection(0);
        raca.setSelection(0);
        peso.setText("");
        sexo.setSelection(0);
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_animal);

        final EditText nome = (EditText) findViewById(R.id.editTextNome);
        final EditText dataNasc = (EditText) findViewById(R.id.editTextDataNasc);
        final Spinner cor = (Spinner) findViewById(R.id.spinnerCor);
        final Spinner genero = (Spinner) findViewById(R.id.spinnerGenero);
        final Spinner raca = (Spinner) findViewById(R.id.spinnerRaca);
        final EditText peso = (EditText) findViewById(R.id.editTextPeso);
        final Spinner sexo = (Spinner) findViewById(R.id.spinnerSexo);

        final Button salvar = (Button) findViewById(R.id.buttonSalvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal animal = new Animal();
                animal.setNome(nome.getText().toString());
                animal.setDataNasc(dataNasc.getText().toString());
                animal.setCor(cor.getSelectedItem().toString());
                animal.setGenero(genero.getSelectedItem().toString());
                animal.setRaca(raca.getSelectedItem().toString());
                animal.setPeso(Integer.valueOf(peso.getText().toString()));
                animal.setSexo(sexo.getSelectedItem().toString());
                animal.setUsuario(Session.getUsuarioLogado().getID());

                try {
                    negocio.adicionar(animal);
                    Toast.makeText(CadastroAnimal.this, "Animal cadastrado com sucesso.", Toast.LENGTH_SHORT).show();
                    limpaDados(nome, dataNasc, cor, genero, raca, peso, sexo);
                    Intent i = new Intent();
                    i.setClass(CadastroAnimal.this, ClinicaMap.class);
                    startActivity(i);

                } catch (Exception e) {
                    Toast.makeText(CadastroAnimal.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void createSpinnerGenero() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerGenero);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genero_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void createSpinnerRaca() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerRaca);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.raca_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void createSpinnerSexo() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerSexo);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sexo_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void createSpinnerCor() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerCor);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cor_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


}
