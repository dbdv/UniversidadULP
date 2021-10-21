/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp;

import java.sql.SQLException;
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

/**
 *
 * @author Usuario
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Conexion conexion = new Conexion(); //CREANDO LA CONEXION   

        // List<Alumno> alumnos = new ArrayList<>();
        AlumnoData ad = new AlumnoData(conexion);
        MateriaData md = new MateriaData(conexion);
        InscripcionData id = new InscripcionData(conexion);

        List<Alumno> alumnos = new ArrayList<>();
        //PROBANDO ALUMNOS
        //
        //
        Alumno a = new Alumno(5754, "Jorge Gomez", LocalDate.of(2000, Month.OCTOBER, 16), true);
        
        ad.guardarAlumno(a);
        
        ad.actualizarAlumno(a);
        System.out.println("buscar alumno:" + ad.buscarAlumno(74));
        
        
        alumnos = ad.obtenerAlumnos();
        System.out.println("lista:");
        for (Alumno al : alumnos) {
            System.out.println(al);
        }
        
        
        //PROBANDO MATERIAS
        //
        //
        Materia ingles = new Materia("Ingles", 2, true);
        md.guardarMateria(ingles);
        md.darDeBajaMateria(ingles.getId_materia());
        
        List<Materia> materias = new ArrayList<>();
        materias = md.obtenerMaterias();
        for (Materia m : materias) {
            System.out.println(m);

        }
        
        //PROBANDO INSCRIPCIONES
        //
        //
        Inscripcion i1 = new Inscripcion(67, 36, 10);
        id.guardarInscripcion(i1);
        //System.out.println(id.obtenerAlumnosPorMateria(36));
        //System.out.println(id.obtenerInscripcionesMateria(36));
        //System.out.println(id.obtenerMateriasCursadasPorAlumno(67));
        //System.out.println(id.obtenerMateriasNoCursadasPorAlumno(67));
        System.out.println(id.buscarInscripciones(67, 36));
        System.out.println(id.obtenerInscripciones());
        
        
        
    }
    
}
