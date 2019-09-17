package com.example.projsolo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import org.w3c.dom.Text;

public class SettingsActivity extends AppCompatActivity implements Organization{

    ImageButton btnAlterarLinguagem;
    TextView txtLinguagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void reconhecerElementos() {
        this.btnAlterarLinguagem = (ImageButton) findViewById(R.id.btnAlterarLinguagem);
        this.txtLinguagem = (TextView) findViewById(R.id.txtLinguagem);
    }

    @Override
    public void reconhecerListeners() {
        this.btnAlterarLinguagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SelecionarLinguagem.class);
                startActivityForResult(intent, 1);// Activity é iniciada com requestCode 1
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Verfica se o requestCode é o mesmo que foi passado
        if(requestCode==1 && resultCode == RESULT_OK)
        {
            String message=data.getStringExtra("MESSAGE");
            txtLinguagem.setText(message);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}