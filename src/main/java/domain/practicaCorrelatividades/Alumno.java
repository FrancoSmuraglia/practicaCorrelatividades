package domain.practicaCorrelatividades;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private Integer nroLegajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, Integer nroLegajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroLegajo = nroLegajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void aprobarMateria(Materia materia){
        this.materiasAprobadas.add(materia);
    }

    public Inscripcion inscribirse(Materia ... materias){
        Inscripcion inscripcion;
        inscripcion = new Inscripcion(this, materias);
        return inscripcion;
    }
}
