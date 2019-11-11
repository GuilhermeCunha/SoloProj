package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projetosologsc.API.RetrofitClientInstance;
import com.example.projetosologsc.Interfaces.NodeServer;
import com.example.projetosologsc.Interfaces.Organization;
import com.example.projetosologsc.Model.Usuario;
import com.example.projetosologsc.ui.Login.LoginAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity  implements Organization {
    Button btnLogar;
    EditText edtEmail;
    EditText edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here

        }

        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.btnLogar = (Button) findViewById(R.id.btnLogar);
        this.edtEmail = (EditText) findViewById(R.id.edtEmailLogin);
        this.edtPassword = (EditText) findViewById(R.id.edtPasswordLogin);

    }

    /*
    public String urlBuilder(String email, String password){
        Uri.Builder builder = new Uri.Builder();

        builder.scheme("http")
                .authority("localhost:4444/")
                .appendQueryParameter("email", email)
                .appendPath("login")
                .appendPath("verify")
                .appendQueryParameter("password", password);
        return builder.build().toString();
    }*/
    @Override
    public void reconhecerListeners() {
        this.btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = edtEmail.getText().toString();
                String strPassword = edtPassword.getText().toString();
                //LoginAuth.login(strEmail, strPassword);

                NodeServer service = RetrofitClientInstance.getRetrofitInstance().create(NodeServer.class);
                Call<Usuario> call = service.login(strEmail, strPassword);
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.isSuccessful()){
                            Log.e("ONRESPONSE","LOGADO COM SUCESSO");
                        }else{
                            Log.e("ONRESPONSE","CREDENCIAIS INVÁLIDAS");
                        }

                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Log.e("OSFAILURE", "NÃO OK");
                    }
                });
            }
        });
    }
}
