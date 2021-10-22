/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp.vistas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import proyectouniversidadulp.control.AlumnoData;
import proyectouniversidadulp.control.InscripcionData;
import proyectouniversidadulp.control.MateriaData;
import proyectouniversidadulp.modelo.Alumno;
import proyectouniversidadulp.modelo.Conexion;
import proyectouniversidadulp.modelo.Inscripcion;
import proyectouniversidadulp.modelo.Materia;

/**
 *
 * @author belen
 */
public class VistaAlumnosPorMateria extends javax.swing.JInternalFrame {
  private DefaultTableModel modelo; //modelo de tabla (cant de filas )
  private ArrayList<Inscripcion> listaInscripcion ;
   private ArrayList<Materia> listaMateria ;
   private InscripcionData inscripcionData; 
   private MateriaData materiaData;
   private AlumnoData alumnoData;
   private ArrayList<Alumno> listaAlumno;
   private Conexion conexion;
   
   
    /**
     * Creates new form VistaAlumnosPorMateria
     */
    public VistaAlumnosPorMateria() {
      try {
          initComponents();
          conexion= new Conexion("jdbc:mysql://localhost/universidad", "root", "");
          modelo = new DefaultTableModel();
          
          inscripcionData = new InscripcionData(conexion);
          listaInscripcion = (ArrayList)inscripcionData.obtenerInscripciones();
          
          materiaData = new MateriaData(conexion);
          listaMateria = (ArrayList)materiaData.obtenerMaterias();
          
          alumnoData = new AlumnoData(conexion);
          listaAlumno = (ArrayList)alumnoData.obtenerAlumnos();
          
          cargarMaterias();
          cabeceraTabla();
          cargarDatos();
          
          
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(VistaAlumnosPorMateria.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        CBMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAlumnos = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Listado de alumnos por materia");

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel2.setText("Materia: ");

        CBMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMateriaActionPerformed(evt);
            }
        });

        jTAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CBMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMateriaActionPerformed
        // TODO add your handling code here:
        cargarDatos();
    }//GEN-LAST:event_CBMateriaActionPerformed
 public void cargarMaterias(){
     for(Materia item:listaMateria){
         CBMateria.addItem(item);
     }
 }
 public void cabeceraTabla(){
     ArrayList <Object> col = new ArrayList<>();
     col.add("id");
     col.add("Nombre");
     col.add("Nota");
     for (Object it: col){
         modelo.addColumn(it);
     }
     jTAlumnos.setModel(modelo);
 }
 public void borrarFilasTabla(){
     int a = modelo.getRowCount()-1;
     for(int i=a; i>=0;i--){
         modelo.removeRow(i);
     }
 }
 public void cargarDatos(){
     borrarFilasTabla();
     
     Materia m=(Materia) CBMateria.getSelectedItem();
   
      
     for(Inscripcion i : listaInscripcion){
         
         if(i.getIdMateria()== m.getId_materia()){

             Alumno a = alumnoData.buscarAlumno(i.getIdAlumno());      
             modelo.addRow(new Object[] {i.getIdAlumno(),a.getNombre(),i.getNota()});
         }
     }
     
 }       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> CBMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAlumnos;
    // End of variables declaration//GEN-END:variables
}
