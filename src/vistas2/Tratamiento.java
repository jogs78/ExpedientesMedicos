/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas2;

import ControladorCliente.TratamientoDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.EntidadTratamiento;

/**
 *
 * @author moisesvelasco
 */
public class Tratamiento extends javax.swing.JInternalFrame {

    TratamientoDao dao = new TratamientoDao();
    EntidadTratamiento et = new EntidadTratamiento();
    DefaultTableModel modelo = new DefaultTableModel();
    int id;
    public Tratamiento() {
        initComponents();
        listar();
    }
    void listar(){
        List<EntidadTratamiento> lista =dao.listar();
        modelo =(DefaultTableModel)tablaTratamiento.getModel();
        Object[]ob = new Object[4];
        for(int i = 0;i<lista.size();i++){
            ob[0]=lista.get(i).getIdTratamiento();
            ob[1]=lista.get(i).getNombreTratamiento();
            ob[2]=lista.get(i).getSimboloTratamiento();
            ob[3]=lista.get(i).getPrecioTratamiento();            
            modelo.addRow(ob);
        }
        tablaTratamiento.setModel(modelo);
    }
    void Agregar(){
        String nombrePadecimiento=txtTratamiento.getText();
        String simbolo=txtSimbolo.getText();
        //String precio=txtPrecio.getText();//ver si no necesita convertir datos. 
        int precio=Integer.parseInt(txtPrecio.getText());
        if(txtTratamiento.getText().equals("") || txtSimbolo.getText().equals("")|| txtPrecio.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Por Favor Llena todos los Campos que se le pide");
            txtTratamiento.requestFocus();
           }
        else{   
           Object[] ob = new Object[3];
           ob[0]=nombrePadecimiento;
           ob[1]=simbolo;
           ob[2]=precio;
           dao.add(ob);            
        }
    }
    void Actualizar(){
        int fila = tablaTratamiento.getSelectedRow();
        if(fila==-1){JOptionPane.showMessageDialog(this, "debe selecionar una fila");}
        else{
        String nombrePadecimiento=txtTratamiento.getText();
        String simbolo=txtSimbolo.getText(); 
        int precio=Integer.parseInt(txtPrecio.getText());
        Object[] obj = new Object[4];
        obj[0]=nombrePadecimiento;
        obj[1]=simbolo;
        obj[2]=precio;
        obj[3]=id;
        dao.actualizar(obj);
        }
    }
    void eliminar(){
        int fila =tablaTratamiento.getSelectedRow(); 
        if(fila==-1){JOptionPane.showMessageDialog(this, "debe selecionar una fila");}
        else{
            int ids = Integer.parseInt(tablaTratamiento.getValueAt(fila,0).toString());            
           dao.eliminar(ids);
        }    
    }
    void nuevo(){
        txtTratamiento.setText("");
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
        txtTratamiento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSimbolo = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTratamiento = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("T R A T A M I E N T O S.");

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));

        btnGuardar.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sinhala MN", 0, 24)); // NOI18N
        jLabel1.setText("Nombre Del Tratamiento");

        jLabel2.setFont(new java.awt.Font("Sinhala MN", 0, 24)); // NOI18N
        jLabel2.setText("Simbolo Del Tratamiento:");

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

        jLabel3.setFont(new java.awt.Font("Sinhala MN", 0, 24)); // NOI18N
        jLabel3.setText("PRECIO:  $");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        tablaTratamiento.setFont(new java.awt.Font("PT Serif Caption", 0, 14)); // NOI18N
        tablaTratamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Del Tratamiento", "Simbolo ", "Precio"
            }
        ));
        tablaTratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTratamientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTratamiento);
        if (tablaTratamiento.getColumnModel().getColumnCount() > 0) {
            tablaTratamiento.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaTratamiento.getColumnModel().getColumn(1).setMaxWidth(300);
            tablaTratamiento.getColumnModel().getColumn(2).setMaxWidth(70);
            tablaTratamiento.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        Agregar();
        limpiarTabla();
        nuevo();
        listar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //TODO add your handling code here:
        Actualizar();
        limpiarTabla();
        nuevo();
        listar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
        limpiarTabla();
        nuevo();
        listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaTratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTratamientoMouseClicked
        // TODO add your handling code here:
        int fila = tablaTratamiento.getSelectedRow();
        if(fila==-1){
            //JOptionPane.showMessageDialog(this, "debe selecionar una fila");
        }
        else{
            //checar video su dni si es entero
            id = Integer.parseInt(tablaTratamiento.getValueAt(fila,0).toString());
            String nombrePadecimiento= tablaTratamiento.getValueAt(fila,1).toString();
            String simbolo=tablaTratamiento.getValueAt(fila,2).toString();
            String precio=tablaTratamiento.getValueAt(fila,3).toString();
            txtTratamiento.setText(nombrePadecimiento);
            txtSimbolo.setText(simbolo);
        }
    }//GEN-LAST:event_tablaTratamientoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTratamiento;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSimbolo;
    private javax.swing.JTextField txtTratamiento;
    // End of variables declaration//GEN-END:variables
}
