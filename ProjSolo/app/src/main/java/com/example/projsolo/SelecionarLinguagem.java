package com.example.projsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class SelecionarLinguagem extends ListActivity implements Organization{
    ListView listViewLinguasDisponiveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        reconhecerElementos();
        reconhecerListeners();
    }

    @Override
    public void reconhecerElementos() {
        String[] linguas = getResources().getStringArray(R.array.listaDeLinguas);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,linguas));
        String lingua = getIntent().getStringExtra("LinguaSelecionada");
        if(lingua != null){
            int position = Arrays.asList(linguas).indexOf(lingua);
            getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(position, true);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String result= l.getItemAtPosition(position).toString();
        Intent i = new Intent();
        i.putExtra("MESSAGE", result);
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    public void reconhecerListeners() {

    }
}
