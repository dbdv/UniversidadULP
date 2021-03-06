/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp.vistas;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectouniversidadulp.control.AlumnoData;
import proyectouniversidadulp.control.MateriaData;
import proyectouniversidadulp.control.InscripcionData;
import proyectouniversidadulp.modelo.Alumno;
import proyectouniversidadulp.modelo.Conexion;
import proyectouniversidadulp.modelo.Materia;

/**
 *
 * @author daniel
 */
public class VistaBajaInscripcion extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaBajaInscripcion
     */
    
    Conexion conexion;
    AlumnoData ad;
    InscripcionData id;
    MateriaData md;
    
    public VistaBajaInscripcion() {
        initComponents();
        try {
            initComponents();
            conexion = new Conexion();
            id = new InscripcionData(conexion);
            ad = new AlumnoData(conexion);
            md = new MateriaData(conexion);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaAltaInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtIdAlumno = new javax.swing.JTextField();
        jtNombreAlumno = new javax.swing.JTextField();
        jtLegajo = new javax.swing.JTextField();
        jtFecha = new javax.swing.JTextField();
        jtNombreMateria = new javax.swing.JTextField();
        jtCuatrimestre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbIdMaterias = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jbBaja = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("ID Alumno:");

        jtNombreAlumno.setEditable(false);

        jtLegajo.setEditable(false);

        jtFecha.setEditable(false);

        jtNombreMateria.setEditable(false);

        jtCuatrimestre.setEditable(false);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Legajo:");

        jLabel4.setText("Fecha de nacimiento:");

        jLabel5.setText("Materias en las que est?? inscripto:");

        jLabel6.setText("Nombre:");

        jLabel7.setText("Cuatrimestre:");

        jcbIdMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIdMateriasActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbBaja.setText("Dar de baja");
        jbBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajaActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jbBaja)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jbLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtNombreAlumno)
                            .addComponent(jtIdAlumno)
                            .addComponent(jtLegajo)
                            .addComponent(jtFecha)
                            .addComponent(jtNombreMateria)
                            .addComponent(jtCuatrimestre)
                            .addComponent(jcbIdMaterias, 0, 160, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addComponent(jbBuscar)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbIdMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBaja)
                    .addComponent(jbLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        
        Alumno alumno = ad.buscarAlumno(Integer.parseInt(jtIdAlumno.getText()));
        List<Materia> materias = id.obtenerMateriasCursadasPorAlumno(alumno.getIdAlumno());
        
        jtNombreAlumno.setText(alumno.getNombre());
        jtLegajo.setText(""+alumno.getLegajo());
        jtFecha.setText(alumno.getFechaNac().toString());
        
        for(Materia m : materias){
            jcbIdMaterias.addItem(m.getId_materia());
        }
        
        Materia materia = md.buscarMateria((int)jcbIdMaterias.getSelectedItem());
        
        jtNombreMateria.setText(materia.getNombre());
        jtCuatrimestre.setText(""+materia.getCuatrimestre());
        
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jcbIdMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIdMateriasActionPerformed
        // TODO add your handling code here:
        int idMateria = (int)jcbIdMaterias.getSelectedItem();
        Materia materia = md.buscarMateria(idMateria);
        
        jtNombreMateria.setText(materia.getNombre());
        jtCuatrimestre.setText(""+materia.getCuatrimestre());
    }//GEN-LAST:event_jcbIdMateriasActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        // TODO add your handling code here:
        jtCuatrimestre.setText("");
        jtFecha.setText("");
        jtIdAlumno.setText("");
        jtLegajo.setText("");
        jtNombreAlumno.setText("");
        jtNombreMateria.setText("");
        jcbIdMaterias.removeAllItems();
                
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaActionPerformed
        // TODO add your handling code here:
        id.borrarInscripcion(Integer.parseInt(jtIdAlumno.getText()), (int)jcbIdMaterias.getSelectedItem());
        JOptionPane.showMessageDialog(this, "Inscripci??n dada de baja exitosamente");
    }//GEN-LAST:event_jbBajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbBaja;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JComboBox<Integer> jcbIdMaterias;
    private javax.swing.JTextField jtCuatrimestre;
    private javax.swing.JTextField jtFecha;
    private javax.swing.JTextField jtIdAlumno;
    private javax.swing.JTextField jtLegajo;
    private javax.swing.JTextField jtNombreAlumno;
    private javax.swing.JTextField jtNombreMateria;
    // End of variables declaration//GEN-END:variables
}
