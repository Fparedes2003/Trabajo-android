package fabian.stomas.aplicacion2;
import java.util.ArrayList;

public class Usuario {
    int ID;
    String Nombre;
    String Apellido;
    String Telefono;
    String Correo;
    String Password;
    ArrayList<Integer> amigos;
    ArrayList<Integer> canales;

    public Usuario(){

    }
    public Usuario(int ID, String Nombre, String Apellido, String Telefono){
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
    }
    public Usuario(int ID, String Nombre, String Apellido, String Correo, String Telefono){
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }
    public Usuario(String Nombre, String Apellido, String Correo, String Telefono){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }

    public Usuario(int ID, String Nombre, String Apellido, String Telefono, String Correo, String Pass) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Password = Pass;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public ArrayList<Integer> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Integer> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Integer> getCanales() {
        return canales;
    }

    public void setCanales(ArrayList<Integer> canales) {
        this.canales = canales;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Correo='" + Correo + '\'' +
                ", Password='" + Password + '\'' +
                ", amigos=" + amigos +
                ", canales=" + canales +
                '}';
    }
}
