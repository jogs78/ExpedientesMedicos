/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas2;
import ControladorCliente.Anticonsep;
import ControladorCliente.CitasDao;
import ControladorCliente.ClienteDao;
import ControladorCliente.consultaCombo;
import EntidadRelacion.cita_antecedentes;
import EntidadRelacion.cita_habitosDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import RelacionDao.cita_antedentesDao;
import RelacionDao.cita_blandosDao;
import RelacionDao.cita_cuidado;
import RelacionDao.cita_duros;
import RelacionDao.cita_oclusion;
import RelacionDao.cita_rx;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import modelo.EntidadAntecedentes;
import modelo.EntidadAnticon;

import modelo.EntidadCita;
import modelo.EntidadCliente;

/**
 *
 * @author moisesvelasco
 */
public class informacionCita extends javax.swing.JInternalFrame {

    int idClien;
    String NPaciente;
    
    CitasDao dao = new CitasDao();
    ClienteDao Cdao = new ClienteDao();
    cita_antecedentes cta=new cita_antecedentes();
    
    cita_antedentesDao ctaD=new cita_antedentesDao();
    Anticonsep antcp = new Anticonsep();
    
    DefaultComboBoxModel modeloBox = new DefaultComboBoxModel();
    consultaCombo consultaBox = new consultaCombo();
    DefaultComboBoxModel modeloBox1 = new DefaultComboBoxModel();
    consultaCombo consultaBox1 = new consultaCombo(); 
    DefaultComboBoxModel modeloBox2 = new DefaultComboBoxModel();
    consultaCombo consultaBox2 = new consultaCombo();

    public informacionCita() {
        initComponents();
        this.anticon.setModel(listartipo());
        this.antece.setModel(listarAnte());
        this.antece2.setModel(listarAnte2());
        mesesEmb.setVisible(false);
        anticon.setVisible(false);
        antece.setVisible(false);
        antece2.setVisible(false);
        jPanel18.setVisible(false);
    }
    
     public DefaultComboBoxModel listartipo(){        
        ResultSet rs=consultaBox.consulta("SELECT tipoAnt FROM anticonseptivos");
        try{
            while(rs.next()){
                modeloBox.addElement(rs.getString("tipoAnt"));
            }rs.close();
        
        }catch(Exception e){JOptionPane.showMessageDialog(this, "error en lsitar combobox"+e.getMessage()); }
        return modeloBox;
    
    }
    public DefaultComboBoxModel listarAnte(){   
        modeloBox1.addElement("otro");
        ResultSet rs=consultaBox1.consulta("SELECT nombreAntecedente FROM antecedentes");
        try{
            while(rs.next()){
                modeloBox1.addElement(rs.getString("nombreAntecedente"));
            }rs.close();
        
        }catch(Exception e){JOptionPane.showMessageDialog(this, "error en lsitar combobox"+e.getMessage()); }
        return modeloBox1;    
    }
    public DefaultComboBoxModel listarAnte2(){
        modeloBox2.addElement("otro");
        ResultSet rs=consultaBox2.consulta("SELECT nombreAntecedente FROM antecedentes");
        try{
            while(rs.next()){
                modeloBox2.addElement(rs.getString("nombreAntecedente"));
            }rs.close();
        
        }catch(Exception e){JOptionPane.showMessageDialog(this, "error en lsitar combobox"+e.getMessage()); }
        return modeloBox2;
    
    }
        
    void agregarAlergias(){
            EntidadCita cita = dao.obtenerDatos(idClien);
           // int asd=cita.getFolio();
           int asd=Integer.parseInt(lbFolio.getText().toString());
            String alergia=txtAlergias.getText(); 
            //alergia si
            if(alergsi.isSelected()==true){
                if(txtAlergias.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Por favor indique la alergia");}
                else{
                    
                    Object[] ob = new Object[3];
                    ob[0]=asd;     
                    ob[1]=alergia;
                    ctaD.addAlergia(ob);
                }
                                        
            }
            
            
    }
    void agregar(){
        try{  
            int eee;
            int emba;
            EntidadCita cita = dao.obtenerDatos(idClien);
            int asd=cita.getFolio(); 
            
            String a =anticon.getSelectedItem().toString();            
            EntidadAnticon eaa=antcp.obtenerIdAnti(a);
                       
            //aqui estan los check 
             if(chAparato.isSelected()==true){         
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=1;
            ctaD.add(ob);           
            }
            if(jCheckBox6.isSelected()==true){ 
               
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=2;
            ctaD.add(ob);           
            }            
            if(jCheckBox7.isSelected()==true){  
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=3;
            ctaD.add(ob); 
            }
            //sdfghjklñkjhgfdsdfghjkl 
            if(jCheckBox8.isSelected()==true){      
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=4;
            ctaD.add(ob);           
            }
            if(jCheckBox9.isSelected()==true){      
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=5;
            ctaD.add(ob);           
            }
            
            if(jCheckBox10.isSelected()==true){                 
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=26;
            ctaD.add(ob);           
            }
            if(jCheckBox11.isSelected()==true){     
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=6;
            ctaD.add(ob);           
            }
            if(jCheckBox12.isSelected()==true){  
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=7;
            ctaD.add(ob);           
            }
            else if(jCheckBox13.isSelected()==true){    
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=8;
            ctaD.add(ob);           
            }
            else if(jCheckBox14.isSelected()==true){     
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=9;
            ctaD.add(ob);           
            }
             if(jCheckBox15.isSelected()==true){   
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=10;
            ctaD.add(ob);           
            }
           //Embarazo
           if(embSi.isSelected()==true){
               String ab =mesesEmb.getSelectedItem().toString();              
               EntidadAntecedentes ant = ctaD.obtenerIdAntece(ab);
               emba=ant.getId();
                Object[] ob = new Object[3];
                ob[0]=asd;     
                ob[1]=emba;
                ctaD.add(ob);
               
               
               
           }
            if(embaNo.isSelected()==true){
               String ess="Sin Embarazo";
               EntidadAntecedentes ant = ctaD.obtenerIdAntece(ess);
               emba=ant.getId();
                Object[] ob = new Object[3];
                ob[0]=asd;     
                ob[1]=emba;
                ctaD.add(ob);
              
           }
           //otros
           if(otro1.isSelected()==true){              
               String ab =antece.getSelectedItem().toString();              
               EntidadAntecedentes ant = ctaD.obtenerIdAntece(ab);
               int anticon=ant.getId();
                Object[] ob = new Object[3];
                ob[0]=asd;     
                ob[1]=anticon;
                ctaD.add(ob);
                     
           }
           if(otro2.isSelected()==true){
               String ab =antece2.getSelectedItem().toString();              
               EntidadAntecedentes ant = ctaD.obtenerIdAntece(ab);
               int anticon=ant.getId();
                Object[] ob = new Object[3];
                ob[0]=asd;     
                ob[1]=anticon;
                ctaD.add(ob);
                      
           }
           if(jCheckBox16.isSelected()==true){
              
                Object[] ob = new Object[3];
                ob[0]=asd;     
                ob[1]=11;
            ctaD.add(ob);                
           }
           if(jCheckBox17.isSelected()==true){
               
                Object[] ob = new Object[3];
                ob[0]=asd;     
                ob[1]=12;
                ctaD.add(ob);                
           }
           if(jCheckBox18.isSelected()==true){
               
                Object[] ob = new Object[3];
                ob[0]=asd;     
                ob[1]=13;
               ctaD.add(ob);                
           }
           
           if(jRadioButton25.isSelected()==true){
              
                Object[] ob = new Object[3];
                ob[0]=asd;     
                ob[1]=14; 
            ctaD.add(ob);                
           }
           if(jRadioButton26.isSelected()==true){
            
                Object[] ob = new Object[3];
                ob[0]=asd;     
                ob[1]=15;
            ctaD.add(ob);                
           }
       if(jRadioButton7.isSelected()==true){
            eee=eaa.getIdAnticonsep();
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=eee;           
            antcp.addAnti(ob);               
           }

        }catch(Exception e){ JOptionPane.showMessageDialog(this, "error en agregar antecedentes o anticonseptivos"+e.getMessage());}
        
    }
    
    void agregarExamenTejidos(){
        try {
            
        } catch (Exception e) {
        }
        EntidadCita cita = dao.obtenerDatos(idClien);
            int asd=cita.getFolio();
            Object[] ob = new Object[4];
        if(esmalte.isSelected()==true){
            
            ob[0]=asd;     
            ob[1]=1;
            
        }
        if(dentina.isSelected()==true){       
            ob[0]=asd;     
            ob[1]=2;
            
        }
        if(raiz.isSelected()==true){}
        if(huesos.isSelected()==true){}
    }
    
    void agregarCuidado(){
        try {
            EntidadCita cita = dao.obtenerDatos(idClien);
        int asd=cita.getFolio();       
        int veces = Integer.parseInt(vecesCepilla.getSelectedItem().toString());
        
        cita_cuidado cc = new cita_cuidado();
        
        if(jRadioButton11.isSelected()==true){
            Object[] ob = new Object[4];
            ob[0]=asd;     
            ob[1]=1;
            cc.add(ob);
               
        }
        if(jRadioButton13.isSelected()==true){
            Object[] ob = new Object[4];
            ob[0]=asd;     
            ob[1]=2;
            cc.add(ob);
            
        }
        if(jRadioButton15.isSelected()==true){
            Object[] ob = new Object[4];
            ob[0]=asd;     
            ob[1]=3;
            cc.add(ob);
            
        }
        if(jRadioButton17.isSelected()==true){
            Object[] ob = new Object[4];
            ob[0]=asd;     
            ob[1]=4;
            cc.add(ob);
        }
        if(jRadioButton19.isSelected()==true){
            Object[] ob = new Object[4];
            ob[0]=asd;     
            ob[1]=5;
            cc.add(ob);
            
        }
        if(jRadioButton12.isSelected()==true&&jRadioButton14.isSelected()==true&&jRadioButton16.isSelected()==true&&jRadioButton18.isSelected()==true)
        {
        Object[] ob = new Object[4];
            ob[0]=asd;     
            ob[1]=12;
            cc.add(ob);
        
        }
        if(jRadioButton1.isSelected()==true){
                Object[] ob = new Object[4];
                ob[0]=asd;
                ob[1]=veces;
                ob[2]=6;                   
                cc.addF(ob);
            }
            if(jRadioButton2.isSelected()==true){
                Object[] ob = new Object[4];
                ob[0]=asd;
                ob[1]=veces;
                ob[2]=7;
                cc.addF(ob);
            }
            if(jRadioButton3.isSelected()==true){
                Object[] ob = new Object[4];
                ob[0]=asd;
                ob[1]=veces;
                ob[2]=8;
                cc.addF(ob);
            }
            if(jRadioButton4.isSelected()==true){
                Object[] ob = new Object[4];
                ob[0]=asd;
                ob[1]=veces;
                ob[2]=9;
                cc.addF(ob);         
            } 
            
        } catch (Exception e) {JOptionPane.showMessageDialog(this, "error en agregar cuidado"+e.getMessage());
        }
    }
    
    void agregarHabitos(){
        EntidadCita cita = dao.obtenerDatos(idClien);
        int asd=cita.getFolio();
        int a =alimentacion.getSelectedIndex();//devulve 0 y 1
        cita_habitosDao ch = new cita_habitosDao();
        String frec = txtFrec.getText();
        
        if(jCheckBox19.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=1;
            ch.addH(ob);            
        }
        if(jCheckBox20.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=2;
            ch.addH(ob);            
        }
        if(jCheckBox21.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=6;
            ch.addH(ob);            
        }
        if(jCheckBox22.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=7;
            ch.addH(ob);            
        }
        if(jCheckBox23.isSelected()==true){
             if(txtFrec.getText().equals("")){JOptionPane.showMessageDialog(this, "Indique Frecuencia");}
             else{Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=3;
            ob[2]=frec;
            ch.addF(ob);}          
        }
        if(jCheckBox24.isSelected()==true){
            if(txtFrec.getText().equals("")){JOptionPane.showMessageDialog(this, "Indique Frecuencia");}
            else{
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=4;
            ob[2]=frec;
            ch.addF(ob);
            }
                        
        }
        if(jCheckBox25.isSelected()==true){
             if(txtFrec.getText().equals("")){JOptionPane.showMessageDialog(this, "Indique Frecuencia");}
             else{
            Object[] ob = new Object[3];
            ob[0]=asd;     
            ob[1]=5;
            ob[2]=frec;
            ch.addF(ob);}            
        }
        if(a==0){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=8;
            ch.addH(ob); 
        }
        if(a==1){Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=9;
            ch.addH(ob); }
        
    
    }
    
    void agregarblando(){
        EntidadCita cita = dao.obtenerDatos(idClien);
        int asd=cita.getFolio();
        cita_blandosDao cb = new cita_blandosDao();
        if(jCheckBox37.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=1;
            cb.add(ob);            
        }
        if(jCheckBox63.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=2;
            cb.add(ob);            
        }
        if(jCheckBox38.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=3;
            cb.add(ob);            
        }
        if(jCheckBox62.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=6;
            cb.add(ob);            
        }
        if(jCheckBox39.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=4;
            cb.add(ob);            
        }
        if(jCheckBox40.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=5;
            cb.add(ob);            
        }
        
    }
    
    void agregarOclusion(){
        EntidadCita cita = dao.obtenerDatos(idClien);
        int asd=cita.getFolio();
         cita_oclusion co = new cita_oclusion();
         int abs = sobreM.getSelectedIndex();
         
         
         if(jCheckBox66.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=3;
            co.add(ob);         
        }
         if(jCheckBox68.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=4;
            co.add(ob);         
        }
         if(jCheckBox67.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=5;
            co.add(ob);         
        }
        if (abs==1){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=1;
            co.add(ob);
        } 
        if (abs==2){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=2;
            co.add(ob);
        }      
    }
    
    void agregarRx(){
        EntidadCita cita = dao.obtenerDatos(idClien);
        int asd=cita.getFolio();
        cita_rx cr = new cita_rx();
        if(raiz.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=1;
            cr.add(ob);         
        }
        if(huesos.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=2;
            cr.add(ob);         
        }
    
    }
    void agregarDuros(){
        EntidadCita cita = dao.obtenerDatos(idClien);
        int asd=cita.getFolio();
        cita_duros cd = new cita_duros();
        if(esmalte.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=1;
            cd.add(ob);         
        }
        if(dentina.isSelected()==true){
            Object[] ob = new Object[2];
            ob[0]=asd;     
            ob[1]=2;
            cd.add(ob);         
        }
        
    
    }

     void centrarVentanas(JInternalFrame frame){
         
        escrit.add(frame);
        Dimension dimension=escrit.getSize();
        Dimension Dframe = frame.getSize();
        frame.setLocation((dimension.width -Dframe.height)/2,(dimension.height -Dframe.height)/2);
        frame.show();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tipoCepillo = new javax.swing.ButtonGroup();
        higiene = new javax.swing.ButtonGroup();
        embarazo = new javax.swing.ButtonGroup();
        alergias = new javax.swing.ButtonGroup();
        anticonsep = new javax.swing.ButtonGroup();
        rechina = new javax.swing.ButtonGroup();
        tratEncias = new javax.swing.ButtonGroup();
        orientaBuc = new javax.swing.ButtonGroup();
        cirugia = new javax.swing.ButtonGroup();
        emorragias = new javax.swing.ButtonGroup();
        escrit = new javax.swing.JDesktopPane();
        lbFolio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbPaciente = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        chAparato = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        embSi = new javax.swing.JRadioButton();
        embaNo = new javax.swing.JRadioButton();
        mesesEmb = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        antece = new javax.swing.JComboBox<>();
        antece2 = new javax.swing.JComboBox<>();
        anticon = new javax.swing.JComboBox<>();
        otro1 = new javax.swing.JCheckBox();
        otro2 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        txtAlergias = new javax.swing.JTextField();
        alergsi = new javax.swing.JRadioButton();
        alergno = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bajoTrata = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton25 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        esmalte = new javax.swing.JCheckBox();
        dentina = new javax.swing.JCheckBox();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        raiz = new javax.swing.JCheckBox();
        huesos = new javax.swing.JCheckBox();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jCheckBox37 = new javax.swing.JCheckBox();
        jCheckBox38 = new javax.swing.JCheckBox();
        jCheckBox39 = new javax.swing.JCheckBox();
        jCheckBox40 = new javax.swing.JCheckBox();
        jCheckBox62 = new javax.swing.JCheckBox();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jCheckBox63 = new javax.swing.JCheckBox();
        jCheckBox66 = new javax.swing.JCheckBox();
        jCheckBox67 = new javax.swing.JCheckBox();
        jCheckBox68 = new javax.swing.JCheckBox();
        sobreM = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        txtFrec = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        alimentacion = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jLabel49 = new javax.swing.JLabel();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jLabel50 = new javax.swing.JLabel();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jLabel51 = new javax.swing.JLabel();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jLabel52 = new javax.swing.JLabel();
        vecesCepilla = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        guardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("I N F OR M A C I O N    DE   CITA.");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        escrit.setLayout(null);

        lbFolio.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lbFolio.setText("000000000");
        escrit.add(lbFolio);
        lbFolio.setBounds(80, 10, 108, 22);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("FOLIO:");
        escrit.add(jLabel2);
        jLabel2.setBounds(10, 10, 60, 22);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setText("PACIENTE:");
        escrit.add(jLabel4);
        jLabel4.setBounds(220, 10, 95, 22);

        lbPaciente.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        escrit.add(lbPaciente);
        lbPaciente.setBounds(320, 10, 480, 20);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Antecedentes Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 18))); // NOI18N

        chAparato.setText("Aparato Respiratorio");

        jCheckBox6.setText("Aparato Cardiovascular");

        jCheckBox7.setText("Aparato Digestivo");

        jCheckBox8.setText("Sistema Nervioso");

        jCheckBox9.setText("Problemas de Goagulación");

        jCheckBox10.setText("Desmayos");

        jCheckBox11.setText("Vertigos y Mareos");

        jCheckBox12.setText("Diabetes");

        jCheckBox13.setText("Tiroides");

        jCheckBox14.setText("Fiebre Reumatica");

        jCheckBox15.setText("Hipertención");

        jLabel14.setText("¿Esta Embarazada?");

        embarazo.add(embSi);
        embSi.setText("SI");
        embSi.setToolTipText("");
        embSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                embSiMouseClicked(evt);
            }
        });
        embSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                embSiActionPerformed(evt);
            }
        });

        embarazo.add(embaNo);
        embaNo.setText("NO");
        embaNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                embaNoMouseClicked(evt);
            }
        });

        mesesEmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-1 mes de Embarazo", "1 mes de Embarazo", "2 meses de Embarazo", "3 meses de Embarazo", "4 meses de Embarazo", "5 meses de Embarazo", "6 meses de Embarazo", "7 meses de Embarazo", "8 meses de Embarazo", "9 meses de Embarazo" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(embSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(embaNo)
                        .addGap(18, 18, 18)
                        .addComponent(mesesEmb, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(embSi)
                    .addComponent(embaNo)
                    .addComponent(mesesEmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel16.setText("¿Usa Anticonseptivos?");

        anticonsep.add(jRadioButton7);
        jRadioButton7.setText("SI");
        jRadioButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton7MouseClicked(evt);
            }
        });
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        anticonsep.add(jRadioButton8);
        jRadioButton8.setText("NO");
        jRadioButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jRadioButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCheckBox16.setText("FUMADOR");

        jCheckBox17.setText("BEBEDOR");

        jCheckBox18.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jCheckBox18.setText("CONSUME DROGAS");

        jButton1.setText("Agregar otro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        otro1.setText("otro");
        otro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                otro1MouseClicked(evt);
            }
        });

        otro2.setText("otro");
        otro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                otro2MouseClicked(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setText("Alergias:");

        jLabel41.setText("Especifique:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        alergias.add(alergsi);
        alergsi.setText("Si");
        alergsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alergsiMouseClicked(evt);
            }
        });
        alergsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alergsiActionPerformed(evt);
            }
        });

        alergias.add(alergno);
        alergno.setText("No");
        alergno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alergnoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(alergsi)
                        .addGap(18, 18, 18)
                        .addComponent(alergno)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alergsi)
                    .addComponent(alergno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel3.setText("¿ESTA BAJO TRATAMIENTO?");

        buttonGroup1.add(bajoTrata);
        bajoTrata.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        bajoTrata.setText("SI");
        bajoTrata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bajoTrataMouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("NO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bajoTrata)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton5)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bajoTrata)
                    .addComponent(jRadioButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("Higiene Bucal:");

        higiene.add(jRadioButton25);
        jRadioButton25.setText("Buena");

        higiene.add(jRadioButton26);
        jRadioButton26.setText("Mala");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(37, 37, 37))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton25)
                    .addComponent(jRadioButton26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chAparato)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox8)
                            .addComponent(jCheckBox9)
                            .addComponent(jCheckBox11))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox13)
                                    .addComponent(jCheckBox10)
                                    .addComponent(jCheckBox15)
                                    .addComponent(jCheckBox14)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(antece, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(antece2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jCheckBox12)
                                .addGap(171, 171, 171))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)))
                        .addComponent(otro1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(otro2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112))
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jCheckBox16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(anticon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox8)
                            .addComponent(jCheckBox10))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(antece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addComponent(jCheckBox12))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(chAparato)
                                            .addComponent(jCheckBox13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox6)
                                            .addComponent(jCheckBox14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox7)
                                            .addComponent(jCheckBox15)))
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(anticon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(antece2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(otro1)
                                    .addComponent(otro2)
                                    .addComponent(jButton1)
                                    .addComponent(jCheckBox16)
                                    .addComponent(jCheckBox17)
                                    .addComponent(jCheckBox18)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        escrit.add(jPanel6);
        jPanel6.setBounds(10, 40, 1060, 260);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Examen de Tejidos"));

        jLabel27.setText("DUROS");

        esmalte.setText("Esmalte");

        dentina.setText("Dentina");

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel40.setText("RX");

        jLabel42.setText("Caries Interproximal");

        jLabel43.setText("Supernumerarios");

        raiz.setText("Raiz");

        huesos.setText("Huesos");

        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));

        jLabel44.setText("BLANDOS");

        jCheckBox37.setText("Encia");

        jCheckBox38.setText("Lengua");

        jCheckBox39.setText("Pulpa(Alteraciones)");

        jCheckBox40.setText("Velo del Paladar");

        jCheckBox62.setText("Carrillos");

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel45.setText("OCLUSION");

        jLabel46.setText("Sobre mordida:");

        jCheckBox63.setText("Intersecion Epitelial");

        jCheckBox66.setText("Mordida Abierta");

        jCheckBox67.setText("Anoclusion");

        jCheckBox68.setText("Desgaste Bruxismo");

        sobreM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\"NINGUNO\"", "HORIZONTAL", "VERTICAL" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(esmalte)
                                .addGap(29, 29, 29)
                                .addComponent(dentina))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel27))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel43))
                                    .addComponent(jLabel42)))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox68)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addComponent(jCheckBox67)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox66))
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel40))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(raiz)
                                        .addGap(18, 18, 18)
                                        .addComponent(huesos))
                                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel45))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel46)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sobreM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox37)
                            .addComponent(jCheckBox63)
                            .addComponent(jCheckBox38))
                        .addContainerGap())
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox62)
                            .addComponent(jCheckBox39)
                            .addComponent(jCheckBox40))
                        .addContainerGap())))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(esmalte)
                                .addComponent(dentina))
                            .addComponent(jCheckBox37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(raiz)
                                    .addComponent(huesos)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jCheckBox63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox39)))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel46)
                                    .addComponent(sobreM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox66)
                                    .addComponent(jCheckBox67))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox68)
                                .addContainerGap(13, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox40)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        escrit.add(jPanel16);
        jPanel16.setBounds(10, 300, 465, 340);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Habitos"));

        jCheckBox19.setText("Bricomania");

        jCheckBox20.setText("Contracciones Muscular");

        jCheckBox21.setText("Habitos de mordida");

        jCheckBox22.setText("Respiracion Bucal");

        jLabel18.setText("Chupadores de:");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jCheckBox23.setText("Labios");

        jCheckBox24.setText("Dedos");

        jCheckBox25.setText("Lengua");
        jCheckBox25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox25ActionPerformed(evt);
            }
        });

        jLabel19.setText("FRECUENCIA:");

        jLabel20.setText("ALIMENTACION:");

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        alimentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buena", "Mala" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox19)
                            .addComponent(jCheckBox21)
                            .addComponent(jCheckBox20)
                            .addComponent(jCheckBox22)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFrec, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jCheckBox23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox25))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel18)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(4, 4, 4)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox23)
                    .addComponent(jCheckBox24)
                    .addComponent(jCheckBox25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtFrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(alimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        escrit.add(jPanel11);
        jPanel11.setBounds(510, 300, 277, 329);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Cuidados"));

        jLabel47.setText("¿RECHINA O APRIETA LOS DIENTES DURANTE EL DIA O LA NOCHE?");

        rechina.add(jRadioButton11);
        jRadioButton11.setText("Si");

        rechina.add(jRadioButton12);
        jRadioButton12.setText("No");

        jLabel48.setText("¿SE HIZO TRATAMIENTO DE ENCIAS?");

        tratEncias.add(jRadioButton13);
        jRadioButton13.setText("Si");

        tratEncias.add(jRadioButton14);
        jRadioButton14.setText("No");

        jLabel49.setText("¿TUVO ORIENTACION DE HIGIENE BUCAL?");

        orientaBuc.add(jRadioButton15);
        jRadioButton15.setText("Si");

        orientaBuc.add(jRadioButton16);
        jRadioButton16.setText("No");

        jLabel50.setText("¿SE HA HECHO CIRUGIA DE ENCIAS?");

        cirugia.add(jRadioButton17);
        jRadioButton17.setText("Si");

        cirugia.add(jRadioButton18);
        jRadioButton18.setText("No");

        jLabel51.setText("¿HA TENIDO HEMORRAGIAS EN LA BOCA?");

        emorragias.add(jRadioButton19);
        jRadioButton19.setText("Si");

        emorragias.add(jRadioButton20);
        jRadioButton20.setText("No");

        jLabel52.setText("¿CUANTAS VECES CEPILLA SUS DIENTES AL DIA?");

        vecesCepilla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6" }));

        jLabel1.setText("¿QUE TIPO DE CEPILLO DENTAL USAS?");

        tipoCepillo.add(jRadioButton1);
        jRadioButton1.setText("Duro");

        tipoCepillo.add(jRadioButton2);
        jRadioButton2.setText("Medio");

        tipoCepillo.add(jRadioButton3);
        jRadioButton3.setText("Suave");

        tipoCepillo.add(jRadioButton4);
        jRadioButton4.setText("Ultrasuave");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel47))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton14))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton16))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton20))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(52, 52, 52)
                        .addComponent(jRadioButton17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton18))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(18, 18, 18)
                        .addComponent(vecesCepilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jRadioButton11)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton12))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12))
                .addGap(3, 3, 3)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(jRadioButton19)
                            .addComponent(jRadioButton20)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton15)
                            .addComponent(jRadioButton16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton17)
                            .addComponent(jRadioButton18))))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(vecesCepilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        escrit.add(jPanel17);
        jPanel17.setBounds(790, 300, 448, 330);

        guardar.setBackground(new java.awt.Color(255, 255, 255));
        guardar.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        guardar.setText("GUARDAR  ");
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        escrit.add(guardar);
        guardar.setBounds(1090, 20, 170, 52);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/chid.jpg"))); // NOI18N
        escrit.add(jLabel5);
        jLabel5.setBounds(1090, 100, 170, 190);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(escrit, javax.swing.GroupLayout.PREFERRED_SIZE, 1283, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escrit, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox25ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
       /* agregar();
        agregarCuidado();
        agregarHabitos();
        agregarblando();
        agregarRx();
        agregarDuros();
        agregarAlergias();
        agregarOclusion();*/

       int folioIf=Integer.parseInt(lbFolio.getText().toString());
        DietesPadTra dpt = new DietesPadTra();//instaciamos clase
        dpt.idClienDP=idClien;//Mandamos el id del cliente al objeto
        dpt.folio=folioIf;
        dispose();
        Inicio.escritorio.add(dpt);
        dpt.setVisible(true);

    }//GEN-LAST:event_guardarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        try {
            
            EntidadCita cita = dao.obtenerDatos(idClien);
            EntidadCliente cli= Cdao.obtenerNombre(idClien);
            
            lbFolio.setText(""+cita.getFolio()); 
            lbPaciente.setText(cli.getNombreCliente()+" "+cli.getApellidoPat()+" "+cli.getApellidoMat());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Erro Activated winds");
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void bajoTrataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bajoTrataMouseClicked
        DatosMedico dm = new DatosMedico();
        
        dm.idClienteDm=idClien;
        centrarVentanas(dm);
    }//GEN-LAST:event_bajoTrataMouseClicked

    private void alergnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alergnoMouseClicked
        // TODO add your handling code here:
        jPanel18.setVisible(false);
    }//GEN-LAST:event_alergnoMouseClicked

    private void alergsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alergsiActionPerformed
        // TODO add your handling code here:
        jPanel18.setVisible(true);
    }//GEN-LAST:event_alergsiActionPerformed

    private void alergsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alergsiMouseClicked
        // TODO add your handling code here:
        jPanel18.setVisible(true);
    }//GEN-LAST:event_alergsiMouseClicked

    private void otro2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_otro2MouseClicked
        // TODO add your handling code here:
        if(otro2.isSelected()==true){antece2.setVisible(true);listarAnte2();}
        else{antece2.setVisible(false);}
    }//GEN-LAST:event_otro2MouseClicked

    private void otro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_otro1MouseClicked
        // TODO add your handling code here:
        if(otro1.isSelected()==true){antece.setVisible(true);listarAnte();}
        else{antece.setVisible(false);}
    }//GEN-LAST:event_otro1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AgregAntecedentes ag = new AgregAntecedentes();
        escrit.add(ag);
        ag.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton8MouseClicked
        // TODO add your handling code here:
        anticon.setVisible(false);
    }//GEN-LAST:event_jRadioButton8MouseClicked

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton7MouseClicked
        // TODO add your handling code here:
        if (jRadioButton7.isSelected()) {
            anticon.setVisible(true);
        }
    }//GEN-LAST:event_jRadioButton7MouseClicked

    private void embaNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_embaNoMouseClicked
        // TODO add your handling code here:
        mesesEmb.setVisible(false);
    }//GEN-LAST:event_embaNoMouseClicked

    private void embSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_embSiActionPerformed
        // TODO add your handling code here:
        if (embSi.isSelected()) {
            mesesEmb.setVisible(true);
        }
    }//GEN-LAST:event_embSiActionPerformed

    private void embSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_embSiMouseClicked
        // TODO add your handling code here:
        mesesEmb.setVisible(true);
    }//GEN-LAST:event_embSiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup alergias;
    private javax.swing.JRadioButton alergno;
    private javax.swing.JRadioButton alergsi;
    private javax.swing.JComboBox<String> alimentacion;
    private javax.swing.JComboBox<String> antece;
    private javax.swing.JComboBox<String> antece2;
    private javax.swing.JComboBox<String> anticon;
    private javax.swing.ButtonGroup anticonsep;
    private javax.swing.JRadioButton bajoTrata;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chAparato;
    private javax.swing.ButtonGroup cirugia;
    private javax.swing.JCheckBox dentina;
    private javax.swing.JRadioButton embSi;
    private javax.swing.JRadioButton embaNo;
    private javax.swing.ButtonGroup embarazo;
    private javax.swing.ButtonGroup emorragias;
    private javax.swing.JDesktopPane escrit;
    private javax.swing.JCheckBox esmalte;
    private javax.swing.JButton guardar;
    private javax.swing.ButtonGroup higiene;
    private javax.swing.JCheckBox huesos;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox62;
    private javax.swing.JCheckBox jCheckBox63;
    private javax.swing.JCheckBox jCheckBox66;
    private javax.swing.JCheckBox jCheckBox67;
    private javax.swing.JCheckBox jCheckBox68;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lbFolio;
    private javax.swing.JLabel lbPaciente;
    private javax.swing.JComboBox<String> mesesEmb;
    private javax.swing.ButtonGroup orientaBuc;
    private javax.swing.JCheckBox otro1;
    private javax.swing.JCheckBox otro2;
    private javax.swing.JCheckBox raiz;
    private javax.swing.ButtonGroup rechina;
    private javax.swing.JComboBox<String> sobreM;
    private javax.swing.ButtonGroup tipoCepillo;
    private javax.swing.ButtonGroup tratEncias;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtFrec;
    private javax.swing.JComboBox<String> vecesCepilla;
    // End of variables declaration//GEN-END:variables
}
