package fabian.stomas.aplicacion2;
import java.util.ArrayList;

public class Canal {
    int Id;
    String Nombre;
    String Descripcion;
    int Tipo_canal;
    int admin;
    ArrayList<Usuario> usuariosCanal;

    public Canal(){

    }

    public Canal(int Id, String Nombre, String Descripcion, int Tipo_canal, int admin){
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Tipo_canal = Tipo_canal;
        this.admin = admin;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getTipo_canal() {
        return Tipo_canal;
    }

    public void setTipo_canal(int tipo_canal) {
        Tipo_canal = tipo_canal;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public ArrayList<Usuario> getUsuariosCanal() {
        return usuariosCanal;
    }

    public void setUsuariosCanal(ArrayList<Usuario> usuariosCanal) {
        this.usuariosCanal = usuariosCanal;
    }
}
