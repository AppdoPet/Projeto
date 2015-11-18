package com.petsaude.medico.persistencia;

import com.petsaude.database.DAO;
import com.petsaude.database.PetSaudeSQLiteHelper;
import android.database.Cursor;

import com.petsaude.clinica.dominio.Clinica;
import com.petsaude.database.DAO;
import com.petsaude.database.PetSaudeSQLiteHelper;
import com.petsaude.medico.dominio.Medico;
import com.petsaude.usuario.dominio.Session;
import com.petsaude.vaga.dominio.Vaga;


import java.util.ArrayList;

/**
 * Created by Matheus Uehara on 17/11/2015.
 */
public class MedicoDAO extends DAO {


    private static final MedicoDAO instance = new MedicoDAO();

    private MedicoDAO() {
        super();
    }

    public static MedicoDAO getInstance() {
        return instance;
    }

    private static PetSaudeSQLiteHelper database = getDataBaseHelper();

    public Medico getMedico(int id){
        open();
        String idSQL = Integer.toString(id);
        Cursor mCursor = getDatabase().rawQuery("SELECT * FROM usuario WHERE _id=? and CRMV!='' ", new String[]{(idSQL)});
        mCursor.moveToFirst();
        Medico medico= new Medico();
        medico.setId(mCursor.getInt(0));
        medico.setNome(mCursor.getString(1));
        close();
        return medico;
    }

}