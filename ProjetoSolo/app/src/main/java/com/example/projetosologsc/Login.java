package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetosologsc.API.RetrofitClientInstance;
import com.example.projetosologsc.FuncoesEstaticas.FuncoesEstaticas;
import com.example.projetosologsc.Interfaces.NodeServer;
import com.example.projetosologsc.Interfaces.Organization;
import com.example.projetosologsc.Model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity  implements Organization {
    Button btnLogar;
    Button btnRegistrar;
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
        this.btnRegistrar = (Button) findViewById(R.id.btnLoginRegistrar);
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

                if(!FuncoesEstaticas.isConnected(getApplicationContext())){
                    Toast toast = Toast.makeText(getApplicationContext(), "Sem conexão", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

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
                            Toast toast = Toast.makeText(getApplicationContext(), "Seja bem vindo " + response.body().getNome(), Toast.LENGTH_SHORT);
                            toast.show();
                            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(getString(R.string.pref_email), response.body().getEmail());
                            editor.putString(getString(R.string.pref_email), response.body().getEmail());
                            editor.putString(getString(R.string.pref_nome), response.body().getNome());
                            editor.putString(getString(R.string.pref_cpf), response.body().getCPF());
                            editor.putString(getString(R.string.pref_celular), response.body().getCelular());
                            editor.apply();

                            Intent i = new Intent(getApplicationContext(), Menu.class);
                            startActivity(i);
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

        this.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivityForResult(i, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String nome = data.getStringExtra("nome");
                String email = data.getStringExtra("email");
                edtEmail.setText(email);
                Toast toast = Toast.makeText(getApplicationContext(), "Seja bem vindo " + nome + ", basta realizar o login", Toast.LENGTH_LONG);
                toast.show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult
}
