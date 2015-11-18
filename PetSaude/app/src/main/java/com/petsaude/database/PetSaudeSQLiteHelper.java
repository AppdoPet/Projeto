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
                    "email text not null," +
                    "CRMV integer);";

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
    private static final String RACA_ANIMAL = "raca";
    private static final String DATA_NASC_ANIMAL = "data_nasc";
    private static final String PESO_ANIMAL = "peso";
    private static final String ID_USUARIO_ANIMAL = "id_usuario_animal";
    private static final String ID_ANIMAL = "_id";
    private static final String TABLE_NAME_ANIMAL = "animal";

    private static final String TABLE_DATABASE_ANIMAL_CREATE =
            "create table animal (_id integer primary key autoincrement, " +
                    "nome text not null, "+
                    "raca text not null, "+
                    "data_nasc text not null," +
                    "peso integer," +
                    "id_usuario_animal int not null," +
                    "FOREIGN KEY(id_usuario_animal) REFERENCES usuario(_id));";

    public static String getTableDatabaseAnimalCreate() {
        return TABLE_DATABASE_ANIMAL_CREATE;
    }
    public static String getNomeAnimal(){
        return NOME_ANIMAL;
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
    public static String getIdUsuarioAnimal() {return ID_USUARIO_ANIMAL;}
    public static String getIdAnimal() {
        return ID_ANIMAL;
    }
    public static String getTableNameAnimal() {
        return TABLE_NAME_ANIMAL;
    }

/*
*
*Criação da tabela Clinica e seus atributos
*
*/
    private static final String TABLE_NAME_CLINICA = "clinica";
    public static String getTableNameClinica(){return TABLE_NAME_CLINICA ;}
    private static final String TABLE_DATABASE_CLINICA_CREATE =
            "create table clinica (_id integer primary key autoincrement, " +
                    "nome text not null, "+
                    "endereco text not null,"+
                    "latitude double not null, "+
                    "longitude double not null);";
    public static String getTableDatabaseClinicaCreate() {
        return TABLE_DATABASE_CLINICA_CREATE;
    }



    private static final String TABLE_DATABASE_VAGA_CREATE =
            "create table vaga (_id integer primary key autoincrement, " +
                    "id_clinica integer not null, "+
                    "id_usuario integer, "+
                    "id_animal integer, "+
                    "id_medico integer not null," +
                    "data String not null," +
                    "status String not null);";

    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        dataBase.execSQL(getTableDatabaseUsuarioCreate());
        dataBase.execSQL(getTableDatabaseAnimalCreate());
        dataBase.execSQL(getTableDatabaseClinicaCreate());
        dataBase.execSQL(TABLE_DATABASE_VAGA_CREATE);
        dataBase.execSQL("insert into usuario (login,nome,senha,email) values ('math','math','math','math@math.com')");

        dataBase.execSQL("insert into usuario (login,nome,senha,email,CRMV) values ('matheus','Dr Uehara','math','mattth@math.com',1234)");
        dataBase.execSQL("insert into usuario (login,nome,senha,email,CRMV) values ('mathieus','Dr matheus','math','maasdth@math.com',123456)");

        dataBase.execSQL("insert into vaga(id_clinica,id_medico,data,status) values (2,2,'16/10/2015 12:00 as 13:00','DISPONIVEL')");
        dataBase.execSQL("insert into vaga(id_clinica,id_medico,data,status) values (2,3,'16/10/2015 14:00 as 14:40','DISPONIVEL')");

        dataBase.execSQL("insert into clinica (nome,endereco,latitude,longitude) values " +
                "('Pet Dream Clinica veterinária','rua das ruas',-8.191706,-34.924004)," +
                "('Amigo Bixo','rua das ruas',-8.195558,-34.920701)," +
                "('Mundo Animal','rua das ruas',-8.2216625,-34.9334426)," +
                "('Mary Rações','rua das ruas',-8.2216625,-34.9334426)," +
                "('JJ Rações','rua das ruas',-8.2205582,-34.9337859)," +
                "('Bom pra cachorro','rua das ruas',-8.2176274,-34.9282069)," +
                "('Bicho Mania Pet Shop','rua das ruas',-8.2166717,-34.927649)," +
                "('CliniPet','rua das ruas',-8.2170752,-34.9256535)," +
                "('Star Dog','rua das ruas',-8.2049858,-34.9230318)," +
                "('Pet Ninas Clinica Veterinaria','rua das ruas',-8.2007208,-34.9230015)," +
                "('Cantinho do Pet','rua das ruas',-8.1982279,-34.9316196)," +
                "('Clinica Bixos','rua das ruas',-8.1918002,-34.9271892)," +
                "('Pet Shop Bixos','rua das ruas',-8.1881658,-34.9243367)," +
                "('Super Amigos Pet','rua das ruas',-8.1881658,-34.9243367)," +
                "('Mundo do criador','rua das ruas',-8.1861534,-34.9221821)," +
                "('Cão delivery Pet Shop','rua das ruas',-8.1861534,-34.9221821)," +
                "('Planet Dog','rua das ruas',-8.1851621,-34.9211807)," +
                "('Cão delivery Pet Shop','rua das ruas',-8.1793951,-34.9297079)," +
                "('Belos Cães','rua das ruas',-8.1667321,-34.9274042)," +
                "('Dog House Pet Shop','rua das ruas',-8.1667321,-34.9274042)," +
                "('Pet Show','rua das ruas',-8.1667321,-34.9274042)," +
                "('Cao Qri','rua das ruas',-8.1714273,-34.9258095)," +
                "('Fiel Companheiro','rua das ruas',-8.1650978,-34.9211747)");
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
