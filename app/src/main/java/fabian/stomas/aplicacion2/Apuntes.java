package fabian.stomas.aplicacion2;

import java.util.Date;

public class Apuntes {
    int ID;
    String Titulo;
    String Contenido;
    Date Fecha_creacion;
    Date Fecha_modificacion;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public Date getFecha_creacion() {
        return Fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        Fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return Fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        Fecha_modificacion = fecha_modificacion;
    }
}
