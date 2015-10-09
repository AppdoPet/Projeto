package com.petsaude.usuario.dominio;


/**
 * Created by Uehara on 07/10/2015.
 */

public class Usuario {
    private int id;
    private String login;
    private String email;
    private String nome;
    private String senha;

    public Usuario(){}

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID(){
        return this.id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
}