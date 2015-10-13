package com.petsaude.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Uehara on 08/11/2014.
 */
public class PetSaudeSQLiteHelper extends SQLiteOpenHelper  {

    private static final String DATABASE_NAME = "petsaude";

    private static int DATABASE_VERSION = 1;

    private static final String TAG = "DBAdapter";

    public PetSaudeSQLiteHelper(Context context) {
        super(context, getDataBaseName(), null, getDATABASE_VERSION());
    }

    public static String getDataBaseName() {
        return DATABASE_NAME;
    }

    public static int getDATABASE_VERSION() {
        return DATABASE_VERSION;
    }

    public static void setDATABASE_VERSION(int DATABASE_VERSION) {
        PetSaudeSQLiteHelper.DATABASE_VERSION = DATABASE_VERSION;
    }

    public static String getTag() {
        return TAG;
    }

    /*
    criacao da tabela usuario e suas colunas
    */

    private static final String LOGIN_USUARIO = "login";
    private static final String NOME_USUARIO = "nome";
    private static final String SENHA_USUARIO = "senha";
    private static final String EMAIL_USUARIO = "email";
    private static final String ID_USUARIO = "_id";

    private static final String TABLE_NAME_USUARIO = "usuario";

    private static final String TABLE_DATABASE_USUARIO_CREATE =
            "create table usuario (_id integer primary key autoincrement, " +
                    "login text not null, "+
                    "nome text not null,"+
                    "senha text not null, "+
                    "email text not null);";

    public static String getTableDatabaseUsuarioCreate() {
        return TABLE_DATABASE_USUARIO_CREATE;
    }
    public static String getEmail(){
        return EMAIL_USUARIO;
    }
    public  static String getNomeUsuario(){
        return NOME_USUARIO;
    }
    public static String getLogin() {
        return LOGIN_USUARIO;
    }
    public static String getSenha() {
        return SENHA_USUARIO;
    }
    public static String getIdUsuario(){return ID_USUARIO;}

	public static String getTableNameUsuario() {
        return TABLE_NAME_USUARIO;
    }


    /*
    * Criação da tabela animal e suas colunas
    * */

    private static final String NOME_ANIMAL = "nome";
    private static final String GENERO_ANIMAL = "genero";
    private static final String RACA_ANIMAL = "raca";
    private static final String DATA_NASC_ANIMAL = "data_nasc";
    private static final String PESO_ANIMAL = "peso";
    private static final String SEXO_ANIMAL = "sexo";
    private static final String COR_ANIMAL = "cor";
    private static final String ID_USUARIO_ANIMAL = "id_usuario_animal";
    private static final String ID_ANIMAL = "_id";

    private static final String TABLE_NAME_ANIMAL = "animal";

    private static final String TABLE_DATABASE_ANIMAL_CREATE =
            "create table animal (_id integer primary key autoincrement, " +
                    "nome text not null, "+
                    "genero text not null,"+
                    "raca text not null, "+
                    "data_nasc text not null" +
                    "peso integer" +
                    "sexo text not null" +
                    "cor text" +
                    "id_usuario_animal int not null" +
                    "FOREIGN KEY(id_usuario_animal) REFERENCES usuario(_id));";

    public static String getTableDatabaseAnimalCreate() {
        return TABLE_DATABASE_ANIMAL_CREATE;
    }
    public static String getNomeAnimal(){
        return NOME_ANIMAL;
    }
    public  static String getGeneroAnimal(){
        return GENERO_ANIMAL;
    }
    public static String getRacaAnimal() {
        return RACA_ANIMAL;
    }
    public static String getDataNascAnimal() {
        return DATA_NASC_ANIMAL;
    }
    public static String getPesoAnimal(){
        return PESO_ANIMAL;
    }

    public static String getSexoAnimal() {
        return SEXO_ANIMAL;
    }

    public static String getCorAnimal() {
        return COR_ANIMAL;
    }

    public static String getIdUsuarioAnimal() {return ID_USUARIO_ANIMAL;}

    public static String getIdAnimal() {
        return ID_ANIMAL;
    }

    public static String getTableNameAnimal() {
        return TABLE_NAME_ANIMAL;
    }



    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        dataBase.execSQL(getTableDatabaseUsuarioCreate());
        dataBase.execSQL(getTableDatabaseAnimalCreate());
    }

    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int newVersion, int oldVersion) {
        Log.w(getTag(), "Atualizando o banco de dados da versao " + oldVersion
                + " para "
                + newVersion + ", que destruira todos os dados antigos");
        dataBase.execSQL("DROP TABLE IF EXISTS login");
        onCreate(dataBase);/// query para recriar o banco
        setDATABASE_VERSION(newVersion);
    }


}
