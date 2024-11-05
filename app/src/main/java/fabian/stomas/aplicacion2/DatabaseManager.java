package fabian.stomas.aplicacion2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Sampler;
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
    public void updateEmailUsuario(String newEmail, String passwordActual, String emailActual){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Correo", newEmail);
        db.update("usuario", values, "Password = ? AND Correo = ?", new String[]{passwordActual, emailActual});
        db.close();
    }
    public void updatePassUsuario(String passwordActual, String newPassword){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Password", newPassword);
        db.update("usuario", values, "Password = ?", new String[]{passwordActual});
        db.close();
    }
    public int insertCanal(Canal canal){
        int id_canal = 0;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nombre", canal.getNombre());
        values.put("Descripcion", canal.getDescripcion());
        values.put("Tipo_canal", canal.getTipo_canal());
        values.put("Admin_ID", canal.getAdmin());
        db.insert("canales", null, values);
        dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT ID FROM canales ORDER BY ID DESC LIMIT 1", null);
        if(cursor.moveToFirst()){
            id_canal = cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return id_canal;
    }
    public void insertTipoCanal(Tipo_canal tipo_canal){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nombre", tipo_canal.getNombre());
        db.insert("tipo_canales", null, values);
        db.close();
    }
    public void insertUsuarios_canales(UsuariosCanales usuariosCanales){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_usuario", usuariosCanales.getId_usuario());
        values.put("id_canal", usuariosCanales.getId_canal());
        db.insert("usuarios_canales", null, values);
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
    public ArrayList<Canal> getAllCanalesDelUsuario(int usuario_id){
        ArrayList<Canal> listaCanalesDelUsuario = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT canales.Nombre, canales.Descripcion, tipo_canales.Nombre FROM canales " +
                "INNER JOIN usuarios_canales ON canales.ID = usuarios_canales.id_canal " +
                "INNER JOIN usuario ON usuario.ID = usuarios_canales.id_usuario " +
                "INNER JOIN tipo_canales ON tipo_canales.ID = canales.Tipo_canal WHERE usuarios_canales.id_usuario = ?", new String[]{String.valueOf(usuario_id)});
        if(cursor.moveToFirst()){
            do{
                String Nombre = cursor.getString(0);
                String Descripcion = cursor.getString(1);
                String Tipo_canal = cursor.getString(2);
                Canal canal = new Canal(Nombre, Descripcion, Tipo_canal);
                listaCanalesDelUsuario.add(canal);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaCanalesDelUsuario;
    }
    public ArrayList<Tipo_canal> getAllTipoCanales(){
        ArrayList<Tipo_canal> listaTipoCanales = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tipo_canales", null);
        if(cursor.moveToFirst()){
            do{
                int ID = cursor.getInt(0);
                String Nombre = cursor.getString(1);
                Tipo_canal tipo_canal = new Tipo_canal(ID, Nombre);
                listaTipoCanales.add(tipo_canal);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaTipoCanales;
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
            String passwordUsuario = cursor.getString(5);
            Usuario usuario = new Usuario(id, nombre, apellido, telefono, email, passwordUsuario);
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
                int Admin_ID = cursor.getInt(4);
                Canal canal = new Canal(id, nombre, descripcion, tipo_canal, Admin_ID);
                listaCanales.add(canal);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaCanales;
    }
    public ArrayList<UsuariosCanales> getAllUsuarios_canales(){
        ArrayList<UsuariosCanales> listaUsuarios_canales = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios_canales", null);
        if(cursor.moveToFirst()){
            do{
                int id_usuario = cursor.getInt(0);
                int id_canal = cursor.getInt(1);
                UsuariosCanales usuarioCanal = new UsuariosCanales(id_usuario, id_canal);
                listaUsuarios_canales.add(usuarioCanal);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaUsuarios_canales;
    }
}
