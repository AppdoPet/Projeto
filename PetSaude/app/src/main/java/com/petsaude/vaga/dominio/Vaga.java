package com.petsaude.vaga.dominio;

import com.petsaude.medico.dominio.Medico;
import java.util.Date;
/**
 * Created by Matheus Uehara on 17/11/2015.
 */
public class Vaga {

    private int id;
    private String data;
    private Medico medico;
    private int idClinica;
    private int idAnimal;
    private int idCliente;

    //private enum status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
