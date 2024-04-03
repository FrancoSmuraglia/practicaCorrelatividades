package domain.practicaCorrelatividades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, Materia ... materias) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
        Collections.addAll(this.materias, materias);
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public boolean aprobada(){
        List<Materia> correlativas = this.materias
                .stream()
                .flatMap(m-> m.getMateriasCorrelativas().stream())
                .collect(Collectors.toList());
        if (this.alumno.getMateriasAprobadas().containsAll(correlativas)){
            return true;
        }
        else {
            return false;
        }
    }
}
