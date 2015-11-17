package com.petsaude.usuario.persistencia;

import android.database.Cursor;
import android.util.Log;

import com.petsaude.database.DAO;
import com.petsaude.database.PetSaudeSQLiteHelper;
import com.petsaude.usuario.dominio.Usuario;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class UsuarioDAO extends DAO {

    private static final UsuarioDAO instance = new UsuarioDAO();
    private UsuarioDAO(){
        super();
    }
    public static UsuarioDAO getInstance(){
        return instance;
    }
    private static final String URL="http://192.168.0.14:8080/PetSaudeWebservice/services/UsuarioService?wsdl";
    private static final String NAMESPACE="http://service.usuario.petsaude.com.br";
    private static final String LOGIN="login";

    public boolean existeUsuario(Usuario usuario){
        return false;
    }
    public boolean existeEmail(Usuario usuario){
        return false;
    }
    public void adicionarUsuario(Usuario usuario){

    }
    public void alterarEmail(String email){

    }
    public boolean deleteUsuario(Usuario usuario){
            return true;
    }
    public void alterarSenha(String senha){

    }

    public Usuario login(String login, String senha) throws Exception {
        Log.d("EMAIL ", login);
        Usuario usr = null; // Cria um objeto para receber as respostas...
        SoapObject buscarUsuario = new SoapObject(NAMESPACE, LOGIN);
        PropertyInfo emailPro=new PropertyInfo();
        PropertyInfo senhaPro=new PropertyInfo();
        emailPro.setValue(login);
        emailPro.setType(String.class);
        emailPro.setName("login");

        senhaPro.setValue(senha);
        senhaPro.setType(String.class);
        senhaPro.setName("senha");

        buscarUsuario.addProperty(emailPro);
        buscarUsuario.addProperty(senhaPro);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(buscarUsuario);

        envelope.implicitTypes = true;


        HttpTransportSE http = new HttpTransportSE(URL);
        http.debug = true;
        try {
            http.call(NAMESPACE+ LOGIN, envelope);
            SoapObject resposta = (SoapObject) envelope.getResponse();

            if(resposta!=null){
                usr = new Usuario(); // instancia o objeto que vai receber as informações


                // Coloca as informações da resposta dentro do objeto...
                usr.setNome(resposta.getProperty("nome").toString());
                usr.setEmail(resposta.getProperty("email").toString());
                usr.setSenha(resposta.getProperty("senha").toString());
                usr.setLogin(resposta.getProperty("login").toString());
                usr.setID(Integer.parseInt(resposta.getPropertyAsString("id")));
            }



        } catch (Exception e) {
           throw new Exception("erro ao conectar com o servidor");
        }
        return usr; // Se não der nenhum erro, retorna o objeto.
    }

}