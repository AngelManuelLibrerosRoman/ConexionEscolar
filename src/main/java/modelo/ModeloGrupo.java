package modelo;

public class ModeloGrupo {
    private String clave;
    private int materia;
    private String catedratico;
    private int hora;
    private int salon;
    public ModeloGrupo() {
    }
    public ModeloGrupo(String clave, int hora, int salon, int materia, String catedratico){
        this.clave = clave;
        this.hora = hora;
        this.salon = salon;
        this.materia = materia;
        this.catedratico = catedratico;
    }

    public String getClave() {
        return clave;
    }

    public int getMateria() {
        return materia;
    }

    public String getCatedratico() {
        return catedratico;
    }

    public int getHora() {
        return hora;
    }

    public int getSalon() {
        return salon;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    public void setCatedratico(String catedratico) {
        this.catedratico = catedratico;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setSalon(int salon) {
        this.salon = salon;
    }

    @Override
    public String toString() {
        return "ModeloGrupo{" +
                "clave='" + clave + '\'' +
                ", materia=" + materia +
                ", catedratico=" + catedratico +
                ", hora=" + hora +
                ", salon=" + salon +
                '}';
    }
}