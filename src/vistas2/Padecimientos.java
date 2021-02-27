/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas2;

import ControladorCliente.PadecimientoDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EntidadPadecimiento;

/**
 *
 * @author moisesvelasco
 */
public class Padecimientos extends javax.swing.JInternalFrame {

    PadecimientoDao dao = new PadecimientoDao();
    EntidadPadecimiento ep = new EntidadPadecimiento();
    DefaultTableModel modelo = new DefaultTableModel();
    int id;
    public Padecimientos() {
        initComponents();
        listar();
    }
    
    void listar(){
        List<EntidadPadecimiento> lista =dao.listar();
        modelo =(DefaultTableModel)tablaPadecimiento.getModel();
        Object[]ob = new Object[3];
        for(int i = 0;i<lista.size();i++){
            ob[0]=lista.get(i).getIdPadecimiento();
            ob[1]=lista.get(i).getNombrePadecimiento();
            ob[2]=lista.get(i).getSimbolo();
            
            modelo.addRow(ob);
        }
        tablaPadecimiento.setModel(modelo);
    }
    void Agregar(){
        String nombrePadecimiento=txtNombrePadecimiento.getText();
        String simbolo=txtSimbolo.getText();
        
        if(txtNombrePadecimiento.getText().equals("") || txtSimbolo.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Por Favor Llena todos los Campos que se le pide");
            txtNombrePadecimiento.requestFocus();
           }
        else{   
           Object[] ob = new Object[3];
           ob[0]=nombrePadecimiento;
           ob[1]=simbolo;
           dao.add(ob);            
        }
    }
    void Actualizar(){
        int fila = tablaPadecimiento.getSelectedRow();
        if(fila==-1){JOptionPane.showMessageDialog(this, "debe selecionar una fila");}
        else{
        String nombrePadecimiento=txtNombrePadecimiento.getText();
        String simbolo=txtSimbolo.getText();              
        Object[] obj = new Object[3];
        obj[0]=nombrePadecimiento;
        obj[1]=simbolo;        
        obj[2]=id;
        dao.actualizar(obj);
        }
    }
    void eliminar(){
        int fila =tablaPadecimiento.getSelectedRow(); 
        if(fila==-1){JOptionPane.showMessageDialog(this, "debe selecionar una fila");}
        else{
            int ids = Integer.parseInt(tablaPadecimiento.getValueAt(fila,0).toString());            
           dao.eliminar(ids);
        }    
    }
    void nuevo(){
        txtNombrePadecimiento.setText("");
        txtSimbolo.setText("");               
    }
    void limpiarTabla(){
        for(int i = 0;i<modelo.getRowCount();i++ ){
        modelo.removeRow(i);
        i=i-1;
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

        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombrePadecimiento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSimbolo = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPadecimiento = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("P A D E C I M I E N T O S");

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));

        btnGuardar.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sinhala MN", 0, 24)); // NOI18N
        jLabel1.setText("Nombre Del Padecimiento:");

        jLabel2.setFont(new java.awt.Font("Sinhala MN", 0, 24)); // NOI18N
        jLabel2.setText("Simbolo Del Padecimiento:");

        btnActualizar.setBackground(new java.awt.Color(153, 204, 255));
        btnActualizar.setFont(new java.awt.Font("Luminari", 0, 15)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Luminari", 0, 15)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombrePadecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrePadecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaPadecimiento.setFont(new java.awt.Font("PT Serif Caption", 0, 14)); // NOI18N
        tablaPadecimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Del Padecimiento", "Simbolo "
            }
        ));
        tablaPadecimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPadecimientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPadecimiento);
        if (tablaPadecimiento.getColumnModel().getColumnCount() > 0) {
            tablaPadecimiento.getColumnModel().getColumn(0).setMaxWidth(40);
            tablaPadecimiento.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        Agregar();
        limpiarTabla();
        listar();
        nuevo();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        Actualizar();
        limpiarTabla();
        listar();
        nuevo();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
       eliminar();
       limpiarTabla();
       listar();
       nuevo();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaPadecimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPadecimientoMouseClicked
        // TODO add your handling code here:
        int fila = tablaPadecimiento.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(this, "debe selecionar una fila");
        }
        else{
            //checar video su dni si es entero
              id = Integer.parseInt(tablaPadecimiento.getValueAt(fila,0).toString());
             String nombrePadecimiento= tablaPadecimiento.getValueAt(fila,1).toString();
             String simbolo=tablaPadecimiento.getValueAt(fila,2).toString();
             txtNombrePadecimiento.setText(nombrePadecimiento);
             txtSimbolo.setText(simbolo);
         }        
    }//GEN-LAST:event_tablaPadecimientoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPadecimiento;
    private javax.swing.JTextField txtNombrePadecimiento;
    private javax.swing.JTextField txtSimbolo;
    // End of variables declaration//GEN-END:variables
}
