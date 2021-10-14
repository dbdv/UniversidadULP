/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp.modelo;

/**
 *
 * @author Usuario
 */
public class Inscripcion {
    private int idIns;
    private Alumno idAlumno;
    private Materia idMateria;
    private double nota;

    public Inscripcion() {
    }    
    
    public Inscripcion(Alumno id_alumno, Materia id_materia, double nota) {
        this.idAlumno = id_alumno;
        this.idMateria = id_materia;       
        this.nota = nota;
    }

    public Inscripcion(int id_inscripcion, Alumno id_alumno, Materia id_materia, double nota) {
        this.idIns = id_inscripcion;
        this.idAlumno = id_alumno;
        this.idMateria = id_materia;
        this.nota = nota;
    }

    public int getIdIns() {
        return idIns;
    }

    public void setIdIns(int idIns) {
        this.idIns = idIns;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    
    
    
}
