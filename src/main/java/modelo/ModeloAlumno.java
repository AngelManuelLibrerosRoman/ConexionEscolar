package modelo;

public class ModeloAlumno {
    private int numControl;
    private String nombre;

    private int especialidad;
    public ModeloAlumno(){

    }


    public ModeloAlumno(int numControl, String nombre, int especialidad) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getNumControl() {
        return numControl;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "ModeloAlumno{" +
                "numControl=" + numControl +
                ", nombre='" + nombre + '\'' +
                ", especialidad=" + especialidad +
                '}';
    }
}
