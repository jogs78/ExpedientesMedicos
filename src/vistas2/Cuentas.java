/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas2;

import ControladorCliente.CitasDao;
import ControladorCliente.ClienteDao;
import ControladorCliente.datosMedicoDao;
import ControladorCliente.obcervacionesDao;
import EntidadRelacion.Ent_cita_blandos;
import EntidadRelacion.Ent_cita_cuidados;
import EntidadRelacion.Ent_cita_cuidadosF;
import EntidadRelacion.Ent_cita_habitos;
import EntidadRelacion.Ent_cita_habitosF;
import EntidadRelacion.Ent_cita_oclusion;
import EntidadRelacion.Ent_cita_rx;
import EntidadRelacion.Ent_dientes_padecimiento;
import EntidadRelacion.Ent_dientes_tratamiento;
import EntidadRelacion.EntidadObservaciones;
import EntidadRelacion.cita_alergia;
import EntidadRelacion.cita_antecedentes;
import EntidadRelacion.cita_anticonseptivos;
import EntidadRelacion.cita_duros;
import RelacionDao.dientes_padecimiento;
import RelacionDao.estadoCuentaListas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EntDuros;
import modelo.EntidadAntecedentes;
import modelo.EntidadAnticon;
import modelo.EntidadBlando;
import modelo.EntidadCita;
import modelo.EntidadCliente;
import modelo.EntidadCuidados;
import modelo.EntidadDatosMedico;
import modelo.EntidadDientes;
import modelo.EntidadHabitos;
import modelo.EntidadOclusion;
import modelo.EntidadPadecimiento;
import modelo.EntidadRx;
import modelo.EntidadTipoCons;
import modelo.EntidadTratamiento;



/**
 *
 * @author moisesvelasco
 */
public class Cuentas extends javax.swing.JFrame {

    /**
     * Creates new form Cuentas
     */
    //LLamamos a la clase que tiene las sentencias de listar
    CitasDao dao = new CitasDao();
    ClienteDao Cdao = new ClienteDao();
    estadoCuentaListas ecl = new estadoCuentaListas();
    datosMedicoDao dmD = new datosMedicoDao();
    
    DefaultTableModel modeloTraDiente = new DefaultTableModel();
    DefaultTableModel modeloPadDiente = new DefaultTableModel();
    DefaultTableModel modeloDatosMedico = new DefaultTableModel();
    DefaultTableModel modeloCitaAntece = new DefaultTableModel();
    DefaultTableModel modeloCitaHabitos = new DefaultTableModel();
    DefaultTableModel modeloCitaHabitosF = new DefaultTableModel();
    DefaultTableModel modeloCitaAlergia = new DefaultTableModel();    
    DefaultTableModel modeloCitaAnticon = new DefaultTableModel();
    DefaultTableModel modeloCitaDuros = new DefaultTableModel();
    DefaultTableModel modeloCitaRx = new DefaultTableModel();
    DefaultTableModel modeloCitaBlando = new DefaultTableModel();
    DefaultTableModel modeloCitaOclusion = new DefaultTableModel();
    DefaultTableModel modeloCitaCuidados = new DefaultTableModel();
    DefaultTableModel modeloCitaCuidadosF = new DefaultTableModel();
    int idCliente;
    int folio;
    public Cuentas() {
        initComponents();
         this.setLocationRelativeTo(null);         
        this.setExtendedState(MAXIMIZED_BOTH);        
        this.setLocationRelativeTo(null);
         jPanel2.setVisible(false);
         
                  
    }
    
    public int suma(){
        int contar=tratamiento_dientes.getRowCount();
        int suma=0;//variable que va almacenar la suma
        for(int i=0;i<contar;i++){
            suma = suma + Integer.parseInt(tratamiento_dientes.getValueAt(i, 2).toString());
        
        }
    return suma;
    }

    void listarInformacionCita(){
        
        //JOptionPane.showMessageDialog(this, "folio: ");
       try{ 
           
        //EntidadCita cita = dao.obtenerDatos(idCliente);
        int folio=Integer.parseInt(lbFolio.getText().toString());//obtenemos el folio para obtener los registros en tabla
        EntidadDatosMedico edm;
        EntidadDientes idD;
        EntidadTratamiento et;
        EntidadPadecimiento ep;
        
        EntidadAntecedentes ea;
        EntidadHabitos eh;
        EntDuros ed;
        
        EntidadAnticon eanti;
        EntidadRx er;
        EntidadBlando eb;
        EntidadOclusion eo;
        EntidadCuidados ec;
        
        String nd,nt,np,na,nh,nant,ndu,nr,nb,no,nc;//nd=nombreDiente, nt= nombreTratamiento,na=nomAntecedente y np=nombrePadecimiento
        int a,b,c,d,e,f,g,h,z,y,x;
        List<Ent_dientes_tratamiento> lista =ecl.listarDites_Tratamiento(folio);
        modeloTraDiente =(DefaultTableModel)tratamiento_dientes.getModel(); 
        Object[]ob = new Object[3];
        Object[]ob1 = new Object[3];
        Object[]ob2 = new Object[3];
        Object[]ob3 = new Object[3];
        Object[]ob4 = new Object[3];
        Object[]ob5 = new Object[3];      
        Object[]ob6 = new Object[3];      
        Object[]ob7 = new Object[3];
        Object[]ob8 = new Object[3];
        Object[]ob9 = new Object[3];
        
        Object[]ob10 = new Object[3];
        Object[]ob11 = new Object[3];
        Object[]ob12 = new Object[3];
        Object[]ob13 = new Object[7];
        //obtenemos los id de cada diente que se le agrego al paciente y mandamos a llamar nombre de esos dientes 
        //centencias en la clase: estadoCuentasListas
        
        for(int i = 0;i<lista.size();i++){
            
            a=lista.get(i).getIdDiente();
            idD=ecl.obtenerNomDiente(a);
            nd=idD.getNombreDiente();
            
            b=lista.get(i).getIdTratamiento();
            et=ecl.obtenerNomTratamiento(b);            
            nt=et.getNombreTratamiento();
            
            
            ob[0]=nd;
            ob[1]=nt; 
            ob[2]=et.getPrecioTratamiento();
           
            modeloTraDiente.addRow(ob);
        }
          
        tratamiento_dientes.setModel(modeloTraDiente);
        
        List<Ent_dientes_padecimiento> lista1 = ecl.listarDites_padecimiento(folio);
        modeloPadDiente =(DefaultTableModel)diente_padecimiento.getModel();
        for(int i = 0;i<lista1.size();i++){
            
            a=lista1.get(i).getIdDiente();
            idD=ecl.obtenerNomDiente(a);
            nd=idD.getNombreDiente();
            
            c=lista1.get(i).getIdPadecimiento();
            ep=ecl.obtenerNomPademiento(c);
            np=ep.getNombrePadecimiento();
            
            ob1[0]=nd;
            ob1[1]=np;
            ob1[2]=lista1.get(i).getColor();
            modeloPadDiente.addRow(ob1);
        }
        
        List<cita_antecedentes> lista2 = ecl.listarCita_Antecedentes(folio);
        modeloCitaAntece =(DefaultTableModel)cita_antecedentes.getModel();
        for(int k = 0;k<lista2.size();k++){
            
            d=lista2.get(k).getIdAntecedente();
            ea=ecl.obtenerNomAntecedente(d);
            na=ea.getNombreAntecedente();
            ob2[0]=na;
            modeloCitaAntece.addRow(ob2);
        }
        
       List<Ent_cita_habitos> lista3 = ecl.listarCita_Habitos(folio);
         modeloCitaHabitos =(DefaultTableModel)cita_habitos.getModel();
        for(int l = 0;l<lista3.size();l++){
            e=lista3.get(l).getIdHabito();
            eh=ecl.obtenerNomHabitos(e);
            nh=eh.getNombreHabito();
            ob3[0]=nh;
            modeloCitaHabitos.addRow(ob3);
        }
        
        List<Ent_cita_habitosF> lista4 = ecl.listarCita_HabitosF(folio);
         modeloCitaHabitosF =(DefaultTableModel)cita_habitosF.getModel();
        for(int l = 0;l<lista4.size();l++){
            e=lista4.get(l).getIdHabito();
            eh=ecl.obtenerNomHabitos(e);
            nh=eh.getNombreHabito();
            ob4[0]=nh;
            ob4[1]=lista4.get(l).getFrecuencia();
            modeloCitaHabitosF.addRow(ob4);
        }
        List<cita_alergia> lista5 = ecl.listarCita_alergia(folio);
         modeloCitaAlergia =(DefaultTableModel)cita_alergia.getModel();
        for(int l = 0;l<lista5.size();l++){
            ob5[0]=lista5.get(l).getAlergia();
            modeloCitaAlergia.addRow(ob5);
        }
        
        List<cita_anticonseptivos> lista6 = ecl.listarCita_anticonsep(folio);
         modeloCitaAnticon =(DefaultTableModel)cita_anticonseptivos.getModel();
        for(int l = 0;l<lista6.size();l++){
            f=lista6.get(l).getIdAnticonseptivo();
            eanti=ecl.obtenerNomAnticonsep(f);
            nant=eanti.getNombreAnt();
            ob6[0]=nant;
            modeloCitaAnticon.addRow(ob6);
        }
        List<cita_duros> lista7 = ecl.listarCita_duros(folio);
         modeloCitaDuros =(DefaultTableModel)cita_duros.getModel();
        for(int l = 0;l<lista7.size();l++){
            
            g=lista7.get(l).getIdDuro();
            ed=ecl.obtenerNomDuro(g);
            ndu=ed.getNombreDuro();
            ob7[0]=ndu;
            modeloCitaDuros.addRow(ob7);
        }
        List<Ent_cita_rx> lista8 = ecl.listarCita_Rx(folio);
         modeloCitaRx =(DefaultTableModel)cita_rx.getModel();
        for(int l = 0;l<lista8.size();l++){
          
           h=lista8.get(l).getIdRx();
           er=ecl.obtenerNomRx(h);
           nr=er.getNombreRx();
           ob8[0]=nr;
            modeloCitaRx.addRow(ob8);
        }
        List<Ent_cita_blandos> lista9 = ecl.listarCita_Blandos(folio);
         modeloCitaBlando=(DefaultTableModel)cita_blandos.getModel();
        for(int l = 0;l<lista9.size();l++){
         
           z=lista9.get(l).getIdBlando();
           eb=ecl.obtenerNomblando(z);
           nb=eb.getNombreBlando();
           ob9[0]=nb;
            modeloCitaBlando.addRow(ob9);
        }
         List<Ent_cita_oclusion> lista10 = ecl.listarCita_oclusion(folio);
         modeloCitaOclusion=(DefaultTableModel)cita_oclusion.getModel();
        for(int l = 0;l<lista10.size();l++){
         
           y=lista10.get(l).getIdOclusion();
           eo=ecl.obtenerNomOclusion(y);
           no=eo.getNombreOclusion();
           ob10[0]=no;
            modeloCitaOclusion.addRow(ob10);
        }
        List<Ent_cita_cuidados> lista11 = ecl.listarCita_cuidados(folio);
         modeloCitaCuidados=(DefaultTableModel)cita_cuidados.getModel();
        for(int l = 0;l<lista11.size();l++){
         
           x=lista11.get(l).getIdCuidado();
           ec=ecl.obtenerNomCuidado(x);
           nc=ec.getNombreCuidado();
           ob11[0]=nc;
            modeloCitaCuidados.addRow(ob11);
        }
        List<Ent_cita_cuidadosF> lista12 = ecl.listarCita_cuidadosF(folio);
         modeloCitaCuidadosF=(DefaultTableModel)cita_cuidadosF.getModel();
        for(int l = 0;l<lista12.size();l++){
         
           x=lista12.get(l).getIdCuidado();
           ec=ecl.obtenerNomCuidado(x);
           nc=ec.getNombreCuidado();
           ob12[0]=lista12.get(l).getVecesCepilla();
           ob12[1]=nc;
            modeloCitaCuidadosF.addRow(ob12);
        }
        
        List<EntidadDatosMedico> lista13 = dmD.listarDatosMedico(idCliente);
         modeloDatosMedico=(DefaultTableModel)tablaMedico.getModel();
        for(int l = 0;l<lista13.size();l++){
            ob13[0]=lista13.get(l).getIdCliente();
            ob13[1]=lista13.get(l).getTipoTratamiento();
            ob13[2]=lista13.get(l).getNombreMedico();
            ob13[3]=lista13.get(l).getContacto();
            ob13[4]=lista13.get(l).getTomaMedicamento();
            ob13[5]=lista13.get(l).getHospitalizado();
            
            modeloDatosMedico.addRow(ob13);
        }
        }
       
        catch(Exception e){ JOptionPane.showMessageDialog(this, "error en lista:  "+e.getMessage()); }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tratamiento_dientes = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        diente_padecimiento = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObcervaciones = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        cita_habitos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        cita_rx = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        cita_duros = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        cita_blandos = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        cita_oclusion = new javax.swing.JTable();
        lbIdCliente = new javax.swing.JLabel();
        lbFechaCita = new javax.swing.JLabel();
        lbTipoConsulta = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbFolio = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbPaciente = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        cita_antecedentes = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        cita_habitosF = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        cita_alergia = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        cita_anticonseptivos = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        cita_cuidados = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        cita_cuidadosF = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        tablaMedico = new javax.swing.JTable();
        observacionAnterior = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jDesktopPane1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("ESTADO DE CUENTA");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(10, 10, 175, 22);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel2.setText("COSTO TOTAL DEL TRATAMIENTO  $");

        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });

        tratamiento_dientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N O M B R E  D E L  D I E N T E", "T R A T A M I E N T O.", "PRECIO"
            }
        ));
        jScrollPane3.setViewportView(tratamiento_dientes);
        if (tratamiento_dientes.getColumnModel().getColumnCount() > 0) {
            tratamiento_dientes.getColumnModel().getColumn(2).setMaxWidth(90);
        }

        diente_padecimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "D I E N T E", "P A D E C I M I E N T O.", "COLOR."
            }
        ));
        jScrollPane1.setViewportView(diente_padecimiento);
        if (diente_padecimiento.getColumnModel().getColumnCount() > 0) {
            diente_padecimiento.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSaldo))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jDesktopPane1.add(jPanel1);
        jPanel1.setBounds(30, 120, 468, 400);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Observaciones");

        txtObcervaciones.setColumns(20);
        txtObcervaciones.setRows(5);
        jScrollPane2.setViewportView(txtObcervaciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jDesktopPane1.add(jPanel2);
        jPanel2.setBounds(990, 380, 260, 170);

        cita_habitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "H A B I T O S."
            }
        ));
        cita_habitos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(cita_habitos);
        if (cita_habitos.getColumnModel().getColumnCount() > 0) {
            cita_habitos.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        jDesktopPane1.add(jScrollPane4);
        jScrollPane4.setBounds(700, 120, 190, 120);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "EXAMEN DE TEJIDOS"));

        cita_rx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "R X"
            }
        ));
        cita_rx.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(cita_rx);
        if (cita_rx.getColumnModel().getColumnCount() > 0) {
            cita_rx.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        cita_duros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "D U R O S."
            }
        ));
        cita_duros.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(cita_duros);
        if (cita_duros.getColumnModel().getColumnCount() > 0) {
            cita_duros.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        cita_blandos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "B L A N D O S."
            }
        ));
        cita_blandos.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(cita_blandos);
        if (cita_blandos.getColumnModel().getColumnCount() > 0) {
            cita_blandos.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        cita_oclusion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "O C L U S I O N."
            }
        ));
        cita_oclusion.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(cita_oclusion);
        if (cita_oclusion.getColumnModel().getColumnCount() > 0) {
            cita_oclusion.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jDesktopPane1.add(jPanel3);
        jPanel3.setBounds(510, 420, 450, 170);

        lbIdCliente.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        lbIdCliente.setText("ID CLIENTE: ");
        jDesktopPane1.add(lbIdCliente);
        lbIdCliente.setBounds(520, 90, 160, 17);

        lbFechaCita.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        lbFechaCita.setText("FECHA CITA :");
        jDesktopPane1.add(lbFechaCita);
        lbFechaCita.setBounds(520, 50, 220, 17);

        lbTipoConsulta.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        lbTipoConsulta.setText("TIPO DE CONSULTA: ");
        jDesktopPane1.add(lbTipoConsulta);
        lbTipoConsulta.setBounds(690, 80, 280, 30);

        jButton1.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        jButton1.setText("T E R M I NAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton1);
        jButton1.setBounds(1060, 10, 180, 52);

        lbFolio.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lbFolio.setText("000000000");
        jDesktopPane1.add(lbFolio);
        lbFolio.setBounds(310, 20, 108, 22);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel9.setText("FOLIO:");
        jDesktopPane1.add(jLabel9);
        jLabel9.setBounds(240, 20, 60, 22);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel10.setText("PACIENTE:");
        jDesktopPane1.add(jLabel10);
        jLabel10.setBounds(440, 20, 95, 22);

        lbPaciente.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jDesktopPane1.add(lbPaciente);
        lbPaciente.setBounds(540, 20, 380, 20);

        jRadioButton1.setText("Agregar Observaciones");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jDesktopPane1.add(jRadioButton1);
        jRadioButton1.setBounds(1050, 70, 180, 23);

        jButton2.setText("ver Historial");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton2);
        jButton2.setBounds(10, 50, 120, 29);

        cita_antecedentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "A N T E C E D E N T E S."
            }
        ));
        cita_antecedentes.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(cita_antecedentes);
        if (cita_antecedentes.getColumnModel().getColumnCount() > 0) {
            cita_antecedentes.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        jDesktopPane1.add(jScrollPane6);
        jScrollPane6.setBounds(510, 120, 190, 240);

        cita_habitosF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "H A B I T O S.", "Frecuencia"
            }
        ));
        cita_habitosF.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(cita_habitosF);
        if (cita_habitosF.getColumnModel().getColumnCount() > 0) {
            cita_habitosF.getColumnModel().getColumn(0).setMaxWidth(400);
            cita_habitosF.getColumnModel().getColumn(1).setMaxWidth(300);
        }

        jDesktopPane1.add(jScrollPane7);
        jScrollPane7.setBounds(890, 120, 260, 120);

        cita_alergia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "A L E R G I A."
            }
        ));
        cita_alergia.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(cita_alergia);
        if (cita_alergia.getColumnModel().getColumnCount() > 0) {
            cita_alergia.getColumnModel().getColumn(0).setMaxWidth(300);
        }

        jDesktopPane1.add(jScrollPane8);
        jScrollPane8.setBounds(960, 240, 190, 60);

        cita_anticonseptivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "A N T I C O N S E P T I V O S."
            }
        ));
        cita_anticonseptivos.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(cita_anticonseptivos);
        if (cita_anticonseptivos.getColumnModel().getColumnCount() > 0) {
            cita_anticonseptivos.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        jDesktopPane1.add(jScrollPane9);
        jScrollPane9.setBounds(960, 300, 190, 60);

        cita_cuidados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C U I D A D O S."
            }
        ));
        cita_cuidados.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(cita_cuidados);
        if (cita_cuidados.getColumnModel().getColumnCount() > 0) {
            cita_cuidados.getColumnModel().getColumn(0).setMaxWidth(300);
        }

        jDesktopPane1.add(jScrollPane14);
        jScrollPane14.setBounds(700, 240, 260, 120);

        cita_cuidadosF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VECES QUE SE CEPILLA", "TIPO DE CEPILLO"
            }
        ));
        cita_cuidadosF.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(cita_cuidadosF);

        jDesktopPane1.add(jScrollPane15);
        jScrollPane15.setBounds(700, 360, 260, 50);

        tablaMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID CLIENTE", "TRATAMIENTO", "NOMBRE DEL MEDICO", "C O N T A C T O.", "¿TOMA MEDICAMIENTO?", "¿ESTUVO HOSPITALIZADO?"
            }
        ));
        tablaMedico.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(tablaMedico);
        if (tablaMedico.getColumnModel().getColumnCount() > 0) {
            tablaMedico.getColumnModel().getColumn(0).setMaxWidth(60);
            tablaMedico.getColumnModel().getColumn(1).setMaxWidth(140);
            tablaMedico.getColumnModel().getColumn(2).setMaxWidth(400);
            tablaMedico.getColumnModel().getColumn(3).setMaxWidth(140);
            tablaMedico.getColumnModel().getColumn(4).setMaxWidth(240);
            tablaMedico.getColumnModel().getColumn(5).setMaxWidth(240);
        }

        jDesktopPane1.add(jScrollPane16);
        jScrollPane16.setBounds(10, 600, 910, 70);

        observacionAnterior.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        observacionAnterior.setForeground(new java.awt.Color(255, 255, 255));
        observacionAnterior.setText("VER OBSERVACION ");
        observacionAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                observacionAnteriorMouseClicked(evt);
            }
        });
        jDesktopPane1.add(observacionAnterior);
        observacionAnterior.setBounds(1050, 90, 190, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
        if(jRadioButton1.isSelected()==true){jPanel2.setVisible(true);observacionAnterior.setVisible(true);}
        else{jPanel2.setVisible(false);observacionAnterior.setVisible(false);}
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        int tps;
        try {         
            EntidadTipoCons etp;
            EntidadCita cita = dao.obtenerDatos(idCliente);            
            EntidadCliente cli= Cdao.obtenerNombre(idCliente);
            
            EntidadCita cit=dao.obtenerDatosCita(folio);            
            tps=cit.getTipoConsulta();
            etp=dao.obtenerNomTipoCons(tps);
            String tpcs=etp.getNombreConsulta();
           
            lbFolio.setText(""+folio); 
            lbPaciente.setText(cli.getNombreCliente()+" "+cli.getApellidoPat()+" "+cli.getApellidoMat());
            lbIdCliente.setText("ID CLIENTE: "+idCliente);
            lbFechaCita.setText("FECHA DE CITA: "+cit.getFechaCita());
            lbTipoConsulta.setText("TIPO CONSULTA: "+tpcs);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Erro Activated winds");
        }
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        listarInformacionCita();
        txtSaldo.setText(Integer.toString(suma()));
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //boton final
        if(jRadioButton1.isSelected()==true){
            if(txtObcervaciones.getText().equals("")){
                JOptionPane.showMessageDialog(this,"CHECAR OBCERVACIONES");}
        else{
                
              String obcer=txtObcervaciones.getText();
              EntidadCita cita = dao.obtenerDatos(idCliente);
              int folio=cita.getFolio();
              obcervacionesDao od = new obcervacionesDao();
              Object[] ob = new Object[4];
              ob[0]=folio;
              ob[1]=obcer;
              od.add(ob);    
              int folioSaldo=Integer.parseInt(lbFolio.getText().toString());
              Object[]obj = new Object[3];
              obj[0]=txtSaldo.getText();
              obj[1]=folioSaldo;
              dao.actualizarSaldo(obj);
              JOptionPane.showMessageDialog(this,"EL SALDO TOTAL FUE: "+txtSaldo.getText());
              dispose();
              
            }}
        else{ 
              int folioSaldo=Integer.parseInt(lbFolio.getText().toString());
              Object[]obj = new Object[3];
              obj[0]=txtSaldo.getText();
              obj[1]=folioSaldo;
              dao.actualizarSaldo(obj);
              JOptionPane.showMessageDialog(this,"EL SALDO TOTAL FUE: "+txtSaldo.getText());              
              dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void observacionAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_observacionAnteriorMouseClicked
        if(observacionAnterior.isSelected()==true){
        jPanel2.setVisible(true);
        int folioOb=Integer.parseInt(lbFolio.getText().toString());
        EntidadObservaciones eo;
        obcervacionesDao od = new obcervacionesDao();
        eo=od.observaciones(folioOb);
        String observacion=eo.getObcervaciones();
        txtObcervaciones.setText(observacion);
        }
        else{jPanel2.setVisible(false);txtObcervaciones.setText("");}
        
        
    }//GEN-LAST:event_observacionAnteriorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cita_alergia;
    private javax.swing.JTable cita_antecedentes;
    private javax.swing.JTable cita_anticonseptivos;
    private javax.swing.JTable cita_blandos;
    private javax.swing.JTable cita_cuidados;
    private javax.swing.JTable cita_cuidadosF;
    private javax.swing.JTable cita_duros;
    private javax.swing.JTable cita_habitos;
    private javax.swing.JTable cita_habitosF;
    private javax.swing.JTable cita_oclusion;
    private javax.swing.JTable cita_rx;
    private javax.swing.JTable diente_padecimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbFechaCita;
    private javax.swing.JLabel lbFolio;
    private javax.swing.JLabel lbIdCliente;
    private javax.swing.JLabel lbPaciente;
    private javax.swing.JLabel lbTipoConsulta;
    private javax.swing.JRadioButton observacionAnterior;
    private javax.swing.JTable tablaMedico;
    private javax.swing.JTable tratamiento_dientes;
    private javax.swing.JTextArea txtObcervaciones;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
