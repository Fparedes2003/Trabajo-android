package fabian.stomas.aplicacion2;

public class UsuariosCanales {
    int id_usuario;
    int id_canal;

    public UsuariosCanales(){

    }

    public UsuariosCanales(int id_usuario, int id_canal){
        this.id_usuario = id_usuario;
        this.id_canal = id_canal;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_canal() {
        return id_canal;
    }

    public void setId_canal(int id_canal) {
        this.id_canal = id_canal;
    }
}
