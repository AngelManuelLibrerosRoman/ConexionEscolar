package modelo;

public class ModeloCatedratico {

    private String RFC;
    private String nombre;

    public ModeloCatedratico() {
    }

    public ModeloCatedratico(String RFC, String nombre) {
        this.RFC = RFC;
        this.nombre = nombre;
    }

    public String getRFC() {
        return RFC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ModeloCatedratico{" +
                "RFC='" + RFC + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
