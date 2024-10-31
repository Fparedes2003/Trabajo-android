package fabian.stomas.aplicacion2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseManager {
    private MyDatabaseHelper dbHelper;
    public DatabaseManager(Context context){
        dbHelper = new MyDatabaseHelper(context);
    }

    public void insertUsuario(Usuario usuario){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("apellido", usuario.getApellido());
        values.put("telefono", usuario.getTelefono());
        values.put("correo", usuario.getCorreo());
        values.put("password", usuario.getPassword());
        db.insert("usuario", null, values);
        db.close();
    }
    public ArrayList<Usuario> getAllUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM usuario", null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String apellido = cursor.getString(2);
                String telefono = cursor.getString(3);
                String correo = cursor.getString(4);
                String password = cursor.getString(5);
                Usuario usuario = new Usuario(id, nombre, apellido, telefono, correo, password);
                listaUsuarios.add(usuario);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaUsuarios;
    }
    public Usuario getUsuarioByPassEmail(String correo, String password){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE correo = ? AND password = ?", new String[]{correo, password});
        if(cursor != null && cursor.moveToFirst()){
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String apellido = cursor.getString(2);
            String telefono = cursor.getString(3);
            String email = cursor.getString(4);
            Usuario usuario = new Usuario(id, nombre, apellido, email, telefono);
            cursor.close();
            db.close();
            return usuario;
        }
        cursor.close();
        db.close();
        return null;
    }
    public ArrayList<Canal> getAllCanales(){
        ArrayList<Canal> listaCanales = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM canales", null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String descripcion = cursor.getString(2);
                int tipo_canal = cursor.getInt(3);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaCanales;
    }
    public ArrayList<String> getTableNames(SQLiteDatabase db) {
        ArrayList<String> tableNames = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        if (cursor.moveToFirst()) {
            do {
                tableNames.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return tableNames;
    }
    public ArrayList<String> getColumnNames(SQLiteDatabase db, String tableName) {
        ArrayList<String> columnNames = new ArrayList<>();
        Cursor cursor = db.rawQuery("PRAGMA table_info(" + tableName + ")", null);
        if (cursor.moveToFirst()) {
            do {
                columnNames.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return columnNames;
    }


    public void printDatabaseInfo() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<String> tableNames = getTableNames(db);
        for (String tableName : tableNames) {
            System.out.println("Table: " + tableName);
            ArrayList<String> columnNames = getColumnNames(db, tableName);
            for (String columnName : columnNames) {
                System.out.println("  Column: " + columnName);
            }
        }
        db.close();
    }




}
