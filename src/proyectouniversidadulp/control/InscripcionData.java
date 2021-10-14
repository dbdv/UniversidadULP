package proyectouniversidadulp.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import proyectouniversidadulp.modelo.Alumno;
import proyectouniversidadulp.modelo.Conexion;
import proyectouniversidadulp.modelo.Inscripcion;
import proyectouniversidadulp.modelo.Materia;

public class InscripcionData {

    private Connection con;
    private Conexion conexion;

    public InscripcionData(Conexion conexion) {
        try {
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

            ps.setInt(1, ins.getId_alumno().getId_alumno());
            ps.setInt(2, ins.getId_materia().getId_materia());
            ps.setDouble(3, ins.getNota());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ins.setId_inscripcion(rs.getInt(1));

                System.out.println("Inscripcion con ID: " + ins.getId_inscripcion() + " nota: " + ins.getNota() + " cargada correctamente.\n");
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
                ins.setId_inscripcion(rs.getInt(1));

                alumno = buscarAlumno(rs.getInt(2));
                ins.setId_alumno(alumno);
                materia = buscarMateria(rs.getInt(3));
                ins.setId_materia(materia);
                ins.setNota(rs.getDouble(4));
                lista.add(ins);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener ");
        }

        return lista;
    }

    public Alumno buscarAlumno(int id) {
        AlumnoData ad = new AlumnoData(conexion);
        return ad.buscarAlumno(id);

    }

    public Materia buscarMateria(int id) {
        MateriaData md = new MateriaData(conexion);
        return md.buscarMateria(id);

    }

}
