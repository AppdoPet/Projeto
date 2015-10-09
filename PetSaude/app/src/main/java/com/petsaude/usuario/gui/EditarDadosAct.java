package com.petsaude.usuario.gui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.petsaude.R;
import com.petsaude.usuario.dominio.Session;
import com.petsaude.usuario.negocio.UsuarioService;

/**
 * Created by Uehara on 20/10/2014.
 */
public class EditarDadosAct extends Activity {

    final UsuarioService negocio = new UsuarioService(EditarDadosAct.this);

    public void onBackPressed(){
        Intent intent = new Intent();
        intent.setClass(EditarDadosAct.this, MenuActivity.class);
        startActivity(intent);
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_editar_dados);

        final Button editarEmail  = (Button) findViewById(R.id.editarEmail);
        final Button editarSenha  = (Button) findViewById(R.id.editarSenha);
        final Button excluirUsuario  = (Button) findViewById(R.id.excluirUsuario);


        editarEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(EditarDadosAct.this,EditarEmailAct.class);
                startActivity(i);
            }
        });

        editarSenha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(EditarDadosAct.this, EditarSenhaAct.class);
                startActivity(i);
            }
            });

        excluirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EditarDadosAct.this);
                alertDialogBuilder.setTitle("Excluir usuário");
                alertDialogBuilder.setMessage("Deseja excluir sua conta?");
                alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            negocio.deleteUsuario(Session.usuarioLogado);
                            Toast.makeText(EditarDadosAct.this,"Usuario excluido com sucesso.",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent();
                            i.setClass(EditarDadosAct.this,LoginAct.class);
                            startActivity(i);
                            dialog.dismiss();
                        }catch(Exception e){
                            Toast.makeText(EditarDadosAct.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });
                alertDialogBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialogBuilder.show();

            }
        });
  }
}