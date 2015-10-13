package com.petsaude.animal.persistencia;

import android.content.ContentValues;
import android.database.Cursor;
import com.petsaude.database.PetSaudeSQLiteHelper;
import com.petsaude.database.DAO;
import com.petsaude.animal.dominio.Animal;


/**
 * Created by alessondelmiro on 11/10/15.
 */
public class AnimalDAO extends DAO{

    private static final AnimalDAO instance = new AnimalDAO();

    private AnimalDAO() {
        super();
    }

    public static AnimalDAO getInstance(){
        return instance;
    }

    private static PetSaudeSQLiteHelper database = getDataBaseHelper();

    /**metodo que adiciona o animal no banco de dados
     * @param animal
     */
    public void adicionarAnimal(Animal animal) {
        open();
        ContentValues initialValues = new ContentValues();
        initialValues.put(database.getNomeAnimal(), animal.getNome());
        initialValues.put(database.getGeneroAnimal(), animal.getGenero());
        initialValues.put(database.getRacaAnimal(), animal.getRaca());
        initialValues.put(database.getDataNascAnimal(), animal.getDataNasc());
        initialValues.put(database.getPesoAnimal(), animal.getPeso());
        initialValues.put(database.getSexoAnimal(), animal.getSexo());
        initialValues.put(database.getCorAnimal(), animal.getCor());
        initialValues.put(database.getIdUsuarioAnimal(), animal.getUsuario());
        getDatabase().insert(database.getTableNameAnimal(), null, initialValues);
        close();
    }


    /**metodo que confere se o animal que está sendo cadastrado já existe
     * @param animal
     * @return  condition
     */
    public boolean existeAnimal(Animal animal){
        boolean condition = false;
        open();
        Cursor mCursor = getDatabase().rawQuery("SELECT * FROM " + database.getTableNameAnimal() + " WHERE nome=? and id_usuario_animal=?", new String[]{animal.getNome(), String.valueOf(animal.getUsuario())});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                condition = true;
            }
        }
        close();
        return condition;
    }



}
