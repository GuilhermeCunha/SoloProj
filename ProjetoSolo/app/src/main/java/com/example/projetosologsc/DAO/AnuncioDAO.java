package com.example.projetosologsc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.projetosologsc.DB.DBOpenHelper;
import com.example.projetosologsc.Model.Anuncio;

import java.util.ArrayList;
import java.util.List;

public class AnuncioDAO {

    public static boolean inserirAnuncio (Anuncio anuncio, Context context){
        long resultado = 0;

        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        try{
            ContentValues valores = new ContentValues();
            valores.put("nome", anuncio.getNome());
            valores.put("preco", anuncio.getPreco());
            valores.put("mensagem", anuncio.getMensagem());

            resultado = db.insert("Anuncios", null, valores);
        }catch (Exception e){
            Log.e("ERROINSERIR", e.getMessage());
            resultado = -1;
        }finally {
            db.close();
        }



        return resultado != -1;
    }

    public static List<Anuncio> listarAnuncios(Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        Cursor cursor;
        String TABELA = "Anuncios";
        String[] campos =  {"ID", "nome", "mensagem", "preco"};

        cursor = db.query(TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
            List<Anuncio> anuncios = new ArrayList<>();
            while (!cursor.isAfterLast()){

                int ID = cursor.getInt(0);
                String nome = cursor.getString(1);
                String mensagem = cursor.getString(2);
                Double preco = cursor.getDouble(3);
                Anuncio anuncio = new Anuncio(ID, nome, mensagem, preco);
                anuncios.add(anuncio);

                cursor.moveToNext();
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            Log.i("LISTARANUNCIOS", "Tamanho: " + anuncios.size());
            return anuncios;
        }
        return null;
    }

    public boolean alterarAnuncio(Anuncio anuncio, Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        String where;
        try{
            where = "ID" + "=" + anuncio.getID();
            valores.put("nome", anuncio.getNome());
            valores.put("mensagem", anuncio.getMensagem());
            valores.put("preco", anuncio.getPreco());

            db.update("Anuncios", valores, where,null);
            db.close();
            return true;
        }catch (SQLException e){
            Log.e("Erro", e.toString());
            return false;
        }

    }

    public static boolean deletarAnuncio(int ID, Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        try{
            String where = "ID" + "=" + ID;

            db.delete("Anuncios", where,null);
            db.close();
            return true;
        }catch (SQLException e){
            Log.e("Erro", e.toString());
            return false;
        }

    }
}
