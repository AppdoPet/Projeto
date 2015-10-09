package com.petsaude.usuario.dominio;

import android.content.Context;
import com.petsaude.usuario.dominio.Usuario;



/**
 * Created by Raissa on 17/11/2014.
 */

public class Session {

    public static Usuario usuarioLogado;

    private static Context contexto = null;

    public static void setUsuarioLogado(Usuario usuario){
        usuarioLogado = usuario;
    }

    public static Usuario getUsuarioLogado(){
        return usuarioLogado;
    }

    public static void setContexto(Context context){contexto = context;}

    public static Context getContexto(){return contexto;}
}
