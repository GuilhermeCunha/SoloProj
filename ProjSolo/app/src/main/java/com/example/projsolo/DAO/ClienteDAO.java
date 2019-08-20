package com.example.projsolo.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.projsolo.Model.Cliente;
import com.example.projsolo.dbHelper.ConexaoSQLite;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static String TAG = "ClienteDAO";
    private final ConexaoSQLite conexaoSQLite;

    public boolean salvarCliente(Cliente c){
        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("nome", c.getNome());
            values.put("celular", c.getCelular());
            values.put("telefone", c.getTelefone());
            values.put("email", c.getEmail());

            db.insert("Cliente", null, values);
            return true;

        }catch (Exception e){
            Log.e(TAG, "Erro " + e.getMessage() + " ao tentar inserir cliente no BD");
            return false;
        }finally {
            if(db!=null){
                db.close();
            }
        }
    }


    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;
        String sql = "SELECT * FROM Carro;";
        try{
            db = conexaoSQLite.getReadableDatabase();
            cursor = db.rawQuery(sql, null);

            if(cursor.moveToFirst()){
                do{
                    Cliente cliente = new Cliente(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                    clientes.add(cliente);
                }while (cursor.moveToNext());
            }

        }catch (Exception e){
            Log.e(TAG, "Erro " + e.getMessage() + " ao tentar listar clientes do BD");
        }finally {
            if(db!= null)db.close();
        }
        return clientes;
    }

    public boolean editarCliente(Cliente c){
        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();
        String sql = "UPDATE TABLE Cliente SET" +
                "nome=" + c.getNome() +
                "celular=" + c.getCelular() +
                "telefone=" + c.getTelefone() +
                "email=" + c.getEmail() +
                "WHERE id=" + c.getId();
        try{
            db.execSQL(sql);
            return true;
        }catch (Exception e){
            Log.e(TAG, "Erro " + e.getMessage() + " ao tentar atualizar cliente no BD");
        }finally {
            if(db!= null)db.close();
        }
        return false;
    }

    public boolean apagarCliente(Cliente c){
        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();
        String sql = "DELETE FROM Cliente WHERE id=" + c.getId();
        try{
            db.execSQL(sql);
            return true;
        }catch (Exception e){
            Log.e(TAG, "Erro " + e.getMessage() + " ao tentar apagar cliente no BD");
        }finally {
            if(db!= null)db.close();
        }
        return false;
    }
/*

    public boolean dropTable(){
        try{
            SQLiteDatabase db = conexaoSQLite.getWritableDatabase();
            String sql = "DROP TABLE IF EXISTS Carro;";
            db.execSQL(sql);
            return true;
        }catch(Exception e){
            Log.e("dropTableDAO", "Erro ao apagar tabela");
            return false;
        }

    }
*/

    public ClienteDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }
}
