/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp.modelo;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Alumno {
    private String nombre;
    private int legajo;
    private int idAlumno;
    private LocalDate fechaNac;
    private boolean activo;

    public Alumno(int legajo, String nombre, LocalDate fechaNac, boolean activo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public Alumno(int legajo, String nombre, int idAlumno, LocalDate fechaNac, boolean activo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.idAlumno= idAlumno;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    

    
    public Alumno() {
    }
        

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

 
   
    
    
    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", legajo=" + legajo + ", id_alumno=" + idAlumno + ", fechaNac=" + fechaNac + ", activo=" + activo + '}';
    }
    
    
}
