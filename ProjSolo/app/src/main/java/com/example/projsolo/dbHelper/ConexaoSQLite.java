package com.example.projsolo.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ConexaoSQLite extends SQLiteOpenHelper {
    private static ConexaoSQLite INSTANCIA_CONEXAO;
    private static  final int VERSAO_DB =1;
    private static final String NOME_DB = "Clientes";

    public ConexaoSQLite(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    public static ConexaoSQLite getInstancia(Context context){
        if(INSTANCIA_CONEXAO == null){
            INSTANCIA_CONEXAO = new ConexaoSQLite(context);
        }
        return INSTANCIA_CONEXAO;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabela(db);
    }

    public void criarTabela(SQLiteDatabase db){
        Log.e("criarTabela", "Criando/Reconhecendo Tabela");

        String sql = "CREATE TABLE IF NOT EXISTS Cliente(" +
                "id integer primary key autoincrement, " +
                "nome text," +
                "celular text," +
                "telefone text," +
                "email text)";
        try{
            db.execSQL(sql);
        }catch (Exception e){
            Log.e("DB_ERROR", "Erro ao criar tabela Cliente");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
