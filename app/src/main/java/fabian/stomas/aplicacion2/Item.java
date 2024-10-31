package fabian.stomas.aplicacion2;
public class Item {
    private String title;
    private String description;
    private String tipo;
    public Item(String title, String description, String tipo){
        this.title = title;
        this.description = description;
        this.tipo = tipo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
