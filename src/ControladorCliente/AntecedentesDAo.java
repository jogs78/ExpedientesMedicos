/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.CRUD;
import modelo.Conexion;
import modelo.EntidadAntecedentes;

/**
 *
 * @author moisesvelasco
 */
public class AntecedentesDAo implements CRUD {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;

    @Override
    public List listar() {
        List<EntidadAntecedentes> lista = new ArrayList<>();
        String sql="SELECT * FROM antecedentes";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadAntecedentes ep = new EntidadAntecedentes();
                 ep.setId(rs.getInt(1));                
                 ep.setNombreAntecedente(rs.getString(2));                 
                 lista.add(ep);
                 
            }
        }
        catch(Exception e){}
        return lista;
       }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO antecedentes (nombreAntecedente) values (?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
                        
            r=ps.executeUpdate();  
        }
        catch(Exception e){}
        return r; 
      }

    @Override
    public int actualizar(Object[] o) {
         int r=0;    
          String sql="UPDATE antecedentes set nombreAntecedente=? where idAntecedente=?";
        try{
            
            con=cn.Conectar();
           
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            r=ps.executeUpdate(); 
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "error actualizar Dao");}
        return r;
      }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
