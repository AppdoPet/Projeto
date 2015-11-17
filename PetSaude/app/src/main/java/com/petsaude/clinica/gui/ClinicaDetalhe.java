package com.petsaude.clinica.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.petsaude.R;
import com.petsaude.usuario.dominio.Session;
import com.petsaude.usuario.gui.MenuActivity;
import com.petsaude.usuario.negocio.UsuarioService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClinicaDetalhe extends AppCompatActivity implements com.petsaude.util.calendario.CalendarView.OnDispatchDateSelectListener {

    private TextView mTextDate;
    private SimpleDateFormat mFormat;
    public static int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_clinica_detalhe);

        setTitle(Session.getClinicaSelecionada().getNome());

        mTextDate=(TextView)findViewById(R.id.display_date);

        mFormat = new SimpleDateFormat("EEEE d MMMM yyyy");

        ((com.petsaude.util.calendario.CalendarView) findViewById(R.id.calendar)).setOnDispatchDateSelectListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void onDispatchDateSelect(Date date) {
        mTextDate.setText(mFormat.format(date));
    }

}
