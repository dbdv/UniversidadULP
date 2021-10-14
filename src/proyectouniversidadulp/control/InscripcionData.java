package proyectouniversidadulp.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import proyectouniversidadulp.modelo.Conexion;
import proyectouniversidadulp.modelo.Inscripcion;

public class InscripcionData {
    
    private Connection con;

    public InscripcionData(Conexion conexion) {
        try{
            this.con = conexion.getConexion();
            System.out.println("Conexion InscripcionData exitosa");
        }catch(SQLException sqlE){
            System.out.println("Error de conexión en InscripcionData\n" + sqlE);
        }
    }
    
    public void guardarInscripcion(Inscripcion ins){
        
        String query = "INSERT INTO inscripcion(idAlumno, idMateria, nota) VALUES(?,?,?)";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, ins.getId_alumno().getId_alumno());
            ps.setInt(2, ins.getId_materia().getId_materia());
            ps.setDouble(3, ins.getNota());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                ins.setId_inscripcion(rs.getInt(1));
                
                System.out.println("Inscripcion con ID: " + ins.getId_inscripcion() + " nota: " + ins.getNota() + " cargada correctamente.\n");
            }
            
            ps.close();
            
        }catch(SQLException sqlE){
            System.out.println("Error al guardar inscripcion.\n" + sqlE);
        }
    }
    
    
}
