package com.example.projetosologsc;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;

import com.example.projetosologsc.DB.WebServiceCommunication;
import com.example.projetosologsc.Interfaces.Organization;
import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.core.auth.providers.custom.CustomCredential;

public class Login extends AppCompatActivity  implements Organization {
    Button btnLogar;
    EditText edtEmail;
    EditText edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        this.btnLogar = (Button) findViewById(R.id.btnLogar);
        this.edtEmail = (EditText) findViewById(R.id.edtEmailLogin);
        this.edtPassword = (EditText) findViewById(R.id.edtPasswordLogin);

    }

    public String urlBuilder(String email, String password){
        Uri.Builder builder = new Uri.Builder();
        /*
        builder.scheme("https")
                .authority("www.myawesomesite.com")
                .appendPath("turtles")
                .appendPath("types")
                .appendQueryParameter("type", "1")
                .appendQueryParameter("sort", "relevance")
                .fragment("section-name");

         */
        builder.scheme("http")
                .authority("localhost:4444/")
                .appendQueryParameter("email", email)
                .appendPath("login")
                .appendPath("verify")
                .appendQueryParameter("password", password);
        return builder.build().toString();
    }
    @Override
    public void reconhecerListeners() {
        this.btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = edtEmail.getText().toString();
                String strPassword = edtPassword.getText().toString();
                Log.e("LOGIN", urlBuilder(strEmail, strPassword));
                //WebServiceCommunication.getJSONFromAPI();

            }
        });
    }
}
