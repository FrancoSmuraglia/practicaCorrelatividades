package domain;

import domain.practicaCorrelatividades.Alumno;
import domain.practicaCorrelatividades.Inscripcion;
import domain.practicaCorrelatividades.Materia;
import org.junit.Assert;
import org.junit.Test;

public class TestCorrelatividades {

    @Test
    public void testUnaMateriaTrue(){
        Alumno franco = new Alumno("Franco", "Smuraglia", 2040803);
        Materia analisisMatematico1 = new Materia("Analisis Matematico I");
        Materia algebraYGeometriaAnalitica = new Materia("Algebra y Geometría Analítica");
        Materia analisisMatematico2 = new Materia("Analisis Matemático II");

        franco.aprobarMateria(analisisMatematico1);
        franco.aprobarMateria(algebraYGeometriaAnalitica);

        analisisMatematico2.agregarCorrelativa(analisisMatematico1);
        analisisMatematico2.agregarCorrelativa(algebraYGeometriaAnalitica);

        Inscripcion inscripcionFranco = franco.inscribirse(analisisMatematico2);
        Assert.assertTrue(inscripcionFranco.aprobada());
    }
    @Test
    public void testDosMateriasTrue(){
        Alumno franco = new Alumno("Franco", "Smuraglia", 2040803);
        Materia analisisMatematico1 = new Materia("Analisis Matematico I");
        Materia algebraYGeometriaAnalitica = new Materia("Algebra y Geometría Analítica");
        Materia analisisMatematico2 = new Materia("Analisis Matemático II");
        Materia fisica1 = new Materia("Física I");
        Materia fisica2 = new Materia("Física II");

        analisisMatematico2.agregarCorrelativa(analisisMatematico1);
        analisisMatematico2.agregarCorrelativa(algebraYGeometriaAnalitica);
        fisica2.agregarCorrelativa(fisica1);

        franco.aprobarMateria(analisisMatematico1);
        franco.aprobarMateria(algebraYGeometriaAnalitica);
        franco.aprobarMateria(fisica1);

        Inscripcion inscripcionFranco = franco.inscribirse(analisisMatematico2, fisica2);
        Assert.assertTrue(inscripcionFranco.aprobada());
    }
    @Test
    public void testDosMateriasUnaNoCumpleCorrelativas(){
        Alumno franco = new Alumno("Franco", "Smuraglia", 2040803);
        Materia analisisMatematico1 = new Materia("Analisis Matematico I");
        Materia algebraYGeometriaAnalitica = new Materia("Algebra y Geometría Analítica");
        Materia analisisMatematico2 = new Materia("Analisis Matemático II");
        Materia fisica1 = new Materia("Física I");
        Materia fisica2 = new Materia("Física II");

        analisisMatematico2.agregarCorrelativa(analisisMatematico1);
        analisisMatematico2.agregarCorrelativa(algebraYGeometriaAnalitica);
        fisica2.agregarCorrelativa(fisica1);

        franco.aprobarMateria(analisisMatematico1);
        franco.aprobarMateria(algebraYGeometriaAnalitica);

        Inscripcion inscripcionFranco = franco.inscribirse(analisisMatematico2, fisica2);
        Assert.assertFalse(inscripcionFranco.aprobada());
    }
}
