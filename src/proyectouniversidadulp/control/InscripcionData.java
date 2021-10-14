package proyectouniversidadulp.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectouniversidadulp.modelo.Alumno;
import proyectouniversidadulp.modelo.Conexion;
import proyectouniversidadulp.modelo.Inscripcion;
import proyectouniversidadulp.modelo.Materia;

public class InscripcionData {

    private Connection con;
    private Conexion conexion;

    public InscripcionData(Conexion conexion) {
        try {
            this.conexion = conexion;
            this.con = conexion.getConexion();
            System.out.println("Conexion InscripcionData exitosa");
        } catch (SQLException sqlE) {
            System.out.println("Error de conexión en InscripcionData\n" + sqlE);
        }
    }

    public void guardarInscripcion(Inscripcion ins) {

        String query = "INSERT INTO inscripcion(idAlumno, idMateria, nota) VALUES(?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ins.getIdAlumno().getId_alumno());
            ps.setInt(2, ins.getIdMateria().getId_materia());
            ps.setDouble(3, ins.getNota());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ins.setIdIns(rs.getInt(1));

                System.out.println("Inscripcion con ID: " + ins.getIdIns() + " nota: " + ins.getNota() + " cargada correctamente.\n");
            }

            ps.close();

        } catch (SQLException sqlE) {
            System.out.println("Error al guardar inscripcion.\n" + sqlE);
        }
    }

    public List<Inscripcion> obtenerInscripcionesMateria(int id) {
        
        List<Inscripcion> lista = new ArrayList<>();
        String sql;
        Inscripcion ins;
        Alumno alumno;
        Materia materia;
        
        sql = "SELECT * FROM inscripcion,alumno,materia WHERE inscripcion.idAlumno=alumno.idAlumno and inscripcion.idMateria=materia.idMateria and materia.idMateria = ?";
        
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ins = new Inscripcion();
                ins.setIdIns(rs.getInt(1));

                alumno = buscarAlumno(rs.getInt(2));
                ins.setIdAlumno(alumno);
                materia = buscarMateria(rs.getInt(3));
                ins.setIdMateria(materia);
                ins.setNota(rs.getDouble(4));
                lista.add(ins);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener ");
        }

        return lista;
    }
    
    /*public List<Materia> cursadasPor(int id){
        
        List<Materia> materias = new ArrayList<>();
        Materia m = new Materia();
        
        String query = "SELECT * FROM inscripcion,alumno,materia WHERE inscripcion.idAlumno=alumno.idAlumno and inscripcion.idMateria=materia.idMateria and alumno.idAlumno = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                m.setId_materia(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setCuatrimestre(rs.getInt(3));
                m.setActivo(rs.getBoolean(4));
                
                materias.add(m);
            }
            
        }catch(SQLException sqlE){
            System.out.println("Error de busqueda\n" + sqlE);
        }
        
        return materias;
    }*/
    public List<Materia> obtenerMateriasCursadasPorAlumno(int id_alumno) {
        List<Materia> lista = new ArrayList<>();
        Materia materia;
        String sql = "SELECT materia.idMateria, nombre, cuatrimestre, activo FROM inscripcion, materia WHERE inscripcion.idMateria=materia.idMateria AND inscripcion.idAlumno= ?";
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id_alumno);
                
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    materia=new Materia();
                    materia.setId_materia(rs.getInt(1));
                    materia.setNombre(rs.getString(2));
                    materia.setCuatrimestre(rs.getInt(3));
                    materia.setActivo(rs.getBoolean(4));
                    lista.add(materia);                
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las materias cursadas por alumno");
        }
        
        return lista;
    }
    
    public List<Materia> obtenerMateriasNoCursadasPorAlumno(int id_alumno) {
        List<Materia> lista = new ArrayList<>();
        Materia materia;
        String sql = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT materia.idMateria FROM inscripcion, materia WHERE inscripcion.idMateria=materia.idMateria AND inscripcion.idAlumno= ?) ";
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id_alumno);
                
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    materia=new Materia();
                    materia.setId_materia(rs.getInt(1));
                    materia.setNombre(rs.getString(2));
                    materia.setCuatrimestre(rs.getInt(3));
                    materia.setActivo(rs.getBoolean(4));
                    lista.add(materia);                
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las materias cursadas por alumno");
        }
        
        return lista;
    }
    
     public List<Alumno> obtenerAlumnosPorMateria(int idMateria) throws SQLException {
        List<Alumno> lista = new ArrayList<>();        
        Alumno alumno;
        
        
        String sql = "SELECT alumno.idAlumno, legajo, nombre, fechaNac, activo FROM inscripcion, alumno WHERE inscripcion.idAlumno=alumno.idAlumno AND inscripcion.idMateria= ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                alumno=new Alumno();
                alumno.setId_alumno(rs.getInt(1));
                alumno.setLegajo(rs.getInt(2));
                alumno.setNombre(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4).toLocalDate());
                alumno.setActivo(rs.getBoolean(5));
                lista.add(alumno);                
            }
            ps.close();
        }
        
        
        return lista;
    }
    
    
    public Alumno buscarAlumno(int id) {
        AlumnoData ad = new AlumnoData(conexion);
        return ad.buscarAlumno(id);

    }
    //prueba 
     public Alumno buscar(int id) {
        AlumnoData ad = new AlumnoData(conexion);
        return ad.buscarAlumno(id);

    }


    public Materia buscarMateria(int id) {
        MateriaData md = new MateriaData(conexion);
        return md.buscarMateria(id);

    }

}
