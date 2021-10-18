/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import proyectouniversidadulp.control.AlumnoData;
import proyectouniversidadulp.control.InscripcionData;
import proyectouniversidadulp.control.MateriaData;
import proyectouniversidadulp.modelo.Alumno;
import proyectouniversidadulp.modelo.Conexion;
import proyectouniversidadulp.modelo.Inscripcion;
import proyectouniversidadulp.modelo.Materia;

public class TestBel {

    public static void main(String[] args) throws ClassNotFoundException {
        
        Conexion conexion = new Conexion();  

        AlumnoData ad = new AlumnoData(conexion);
        MateriaData md = new MateriaData(conexion);
        InscripcionData id = new InscripcionData(conexion);
        
        Alumno a1 =new Alumno(123, "Rocio Dominguez", LocalDate.of(1990, Month.MARCH, 19), true);
        Alumno a2 =new Alumno(123, "Maria Dominguez", LocalDate.of(1991, Month.MARCH, 26), true);
        Materia m1= new Materia("Matematica I", 1, true);
        
        Inscripcion ins1= new Inscripcion(97,49, 9);
       // Inscripcion ins2= new Inscripcion(a2.getIdAlumno(), m1.getId_materia(),8);
        
        
        ad.guardarAlumno(a1);
        md.guardarMateria(m1);
        
        id.guardarInscripcion(ins1);
        id.borrarInscripcion(97,49 );
         id.guardarInscripcion(ins1);
       // id.guardarInscripcion(ins2);
}
}
