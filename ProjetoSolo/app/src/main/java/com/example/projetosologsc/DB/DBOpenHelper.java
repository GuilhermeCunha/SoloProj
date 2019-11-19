package com.example.projetosologsc.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SoloProjDB";
    public static final int DATABASE_VERSION = 1;



    private static final String SQL_CREATE_ANUNCIOS = "" +
            "CREATE TABLE IF NOT EXISTS Anuncios (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT," +
            "mensagem TEXT," +
            "preco REAL);";


    private static final String SQL_DELETE_ANUNCIOS =
            "DROP TABLE IF EXISTS Anuncios";



    public DBOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ANUNCIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ANUNCIOS);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
