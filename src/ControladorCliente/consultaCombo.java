/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Conexion;

/**
 *
 * @author moisesvelasco
 */
public class consultaCombo {
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion(); 
    Connection con;
    
    public ResultSet consulta(String sql){
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        
        
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "error en consulta de combo"+e.getMessage()); }
    
    return rs;
    }
    
}
