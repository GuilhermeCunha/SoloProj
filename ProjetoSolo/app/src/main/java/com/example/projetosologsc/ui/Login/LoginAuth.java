package com.example.projetosologsc.ui.Login;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class LoginAuth {

    public static boolean realizarLogin(String login, String senha){
        JSONObject json = new JSONObject();
        try {
            json.put("login", login);
            json.put("senha", senha);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sendPost(json);
        return true;
    }

    private static boolean sendPost( JSONObject postParams) {
        try {
            String url = "http://localhost:3000/login";
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));
            conn.setDoOutput(true);

            PrintStream printStream = new PrintStream(conn.getOutputStream());
            printStream.println(postParams); //seta o que voce vai enviar

            conn.connect(); //envia para o servidor

            String jsonDeResposta = new Scanner(conn.getInputStream()).next(); //pega resposta
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
