/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas2;

import ControladorCliente.DienteDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.EntidadDientes;
import javax.swing.JOptionPane;

/**
 *
 * @author moisesvelasco
 */
public class Dientes extends javax.swing.JInternalFrame {

    DienteDao dao = new DienteDao();
    EntidadDientes ep = new EntidadDientes();
    DefaultTableModel modelo = new DefaultTableModel();
    int id;
    public Dientes() {
        initComponents();
        listar();
    }
    
    void listar(){
        List<EntidadDientes> lista =dao.listar();
        modelo =(DefaultTableModel)tablaDiente.getModel();
        Object[]ob = new Object[3];
        for(int i = 0;i<lista.size();i++){
            ob[0]=lista.get(i).getIdDiente();
            ob[1]=lista.get(i).getNombreDiente();
            ob[2]=lista.get(i).getSimboloDiente();
            
            modelo.addRow(ob);
        }
        tablaDiente.setModel(modelo);
    }
    void Agregar(){
        String diente=txtDiente.getText();
        String simbolo=txtSimbolo.getText();
        
        if(txtDiente.getText().equals("") || txtSimbolo.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Por Favor Llena todos los Campos que se le pide");
            txtDiente.requestFocus();
           }
        else{   
           Object[] ob = new Object[2];
           ob[0]=diente;
           ob[1]=simbolo;
           dao.add(ob);            
        }
    }
    void ActualizarDiente(){
        try {
            String nombreDiente=txtDiente.getText();
            String simbolo=txtSimbolo.getText();
            int fila = tablaDiente.getSelectedRow();
        if(fila==-1){JOptionPane.showMessageDialog(this, "debe selecionar una fila");}
        else{
                      
        Object[] obj = new Object[3];        
        obj[0]=nombreDiente;
        obj[1]=simbolo;        
        obj[2]=id;
        dao.actualizar(obj);        
        }
            
        } catch (Exception e) {JOptionPane.showMessageDialog(this, "error");
        }
        
    }
    void eliminar(){
        int fila =tablaDiente.getSelectedRow(); 
        if(fila==-1){JOptionPane.showMessageDialog(this, "debe selecionar una fila");}
        else{
            int ids = Integer.parseInt(tablaDiente.getValueAt(fila,0).toString());            
           dao.eliminar(ids);
        }    
    }
    void nuevo(){
        txtDiente.setText("");
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
        txtDiente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSimbolo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDiente = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        setClosable(true);
        setResizable(true);
        setTitle("D I E N T E S.");

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));

        btnGuardar.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sinhala MN", 0, 24)); // NOI18N
        jLabel1.setText("Nombre Del Diente:");

        jLabel2.setFont(new java.awt.Font("Sinhala MN", 0, 24)); // NOI18N
        jLabel2.setText("Simbolo Del Diente:");

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
                        .addComponent(txtDiente, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tablaDiente.setFont(new java.awt.Font("PT Serif Caption", 0, 14)); // NOI18N
        tablaDiente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Del Diente", "Simbolo "
            }
        ));
        tablaDiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDiente);
        if (tablaDiente.getColumnModel().getColumnCount() > 0) {
            tablaDiente.getColumnModel().getColumn(0).setMaxWidth(40);
            tablaDiente.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void tablaDienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDienteMouseClicked
        // TODO add your handling code here:
        int fila = tablaDiente.getSelectedRow();
        if(fila==-1){
            //JOptionPane.showMessageDialog(this, "debe selecionar una fila");
        }
        else{
            //checar video su dni si es entero
            id = Integer.parseInt(tablaDiente.getValueAt(fila,0).toString());
            String nombreDiente= tablaDiente.getValueAt(fila,1).toString();
            String simbolo=tablaDiente.getValueAt(fila,2).toString();
            txtDiente.setText(nombreDiente);
            txtSimbolo.setText(simbolo);
        }
    }//GEN-LAST:event_tablaDienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDiente;
    private javax.swing.JTextField txtDiente;
    private javax.swing.JTextField txtSimbolo;
    // End of variables declaration//GEN-END:variables
}
