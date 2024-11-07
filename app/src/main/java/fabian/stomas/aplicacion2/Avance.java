package fabian.stomas.aplicacion2;

import java.sql.Timestamp;
import java.util.Date;

public class Avance {
    int ID;
    String Descripcion;
    Date Fecha_avance;
    int id_usuario;
    int id_canal;

    public Avance(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFecha_avance() {
        return Fecha_avance;
    }

    public void setFecha_avance(Date fecha_avance) {
        Fecha_avance = fecha_avance;
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
