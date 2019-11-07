package com.example.projetosologsc.DB;

import android.util.Log;

import com.example.projetosologsc.API.HttpUtility;
import com.example.projetosologsc.Model.Usuario;
import com.example.projetosologsc.Model.Usuarios;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class WebServiceCommunication {

    public boolean login(String email, String senha){
        String url= "https://soloprojnode.herokuapp.com/login";

        // send params with Hash Map
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email",email);
        params.put("senha", senha);

        //server url
        Boolean sucesso;
        // static class "HttpUtility" with static method "newRequest(url,method,callback)"
        HttpUtility.newRequest(url,HttpUtility.METHOD_POST,params, new HttpUtility.Callback() {
            Boolean resultado;
            @Override
            public void OnSuccess(String response) {
                // on success
                System.out.println("Server OnSuccess response="+response);
                resultado = true;
            }
            @Override
            public void OnError(int status_code, String message) {
                // on error
                System.out.println("Server OnError status_code="+status_code+" message="+message);
                resultado = false;
            }
        });
        return true;
    }

    public List<Usuario> listarUsuarios(){
        String url= "https://soloprojnode.herokuapp.com/listar-usuarios";
        String retorno = "";
        try {
            URL apiEnd = new URL(url);
            int codigoResposta;
            HttpURLConnection conexao;
            InputStream is;

            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            if(codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST){
                is = conexao.getInputStream();
            }else{
                is = conexao.getErrorStream();
            }

            retorno = converterInputStreamToString(is);
            is.close();
            conexao.disconnect();

        } catch (IOException e) {
            Log.e("ERRO", "ERRO EXCEÇÃO");
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Usuarios usuarios = gson.fromJson(retorno, Usuarios.class);

        return usuarios.usuarios;
    }
    private String converterInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while((linha = br.readLine())!=null){
                buffer.append(linha);
            }

            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
