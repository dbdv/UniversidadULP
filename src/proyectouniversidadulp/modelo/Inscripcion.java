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
    private int idInsc;
    private int idAlumno;
    private int idMateria;
    private double nota;

    public Inscripcion() {
    }    

    public Inscripcion(int idInsc, int idAlumno, int idMateria, double nota) {
        this.idInsc = idInsc;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
    }

    public Inscripcion(int idAlumno, int idMateria, double nota) {
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
    }
    
   

    public int getIdIns() {
        return idInsc;
    }

    public void setIdIns(int idIns) {
        this.idInsc = idIns;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idIns=" + idInsc + ", idAlumno=" + idAlumno + ", idMateria=" + idMateria + ", nota=" + nota + '}';
    }

   

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    
    
    
}
