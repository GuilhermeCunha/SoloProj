package com.example.projetosologsc.ui.Login;

import android.util.Log;

import com.example.projetosologsc.DB.WebServiceCommunication;
import com.example.projetosologsc.Model.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LoginAuth {
    public static boolean realizarLogin(String email, String senha){
        JSONObject json = new JSONObject();
        try{
            json.put("email", email);
            json.put("senha", senha);
        }catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            Log.e("Login",json.toString());
            //List<Usuario> usuarios = new ArrayList<>();
            //usuarios = WebServiceCommunication.listarUsuarios();
            Boolean resultado = WebServiceCommunication.login(email, senha);
            if(resultado){
                Log.e("Resultado","Sucesso");
            }else{
                Log.e("Resultado", "Erro");
            }
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }

    }
}
