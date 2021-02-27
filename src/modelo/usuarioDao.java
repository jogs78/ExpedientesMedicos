/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author moisesvelasco
 */
public class usuarioDao {
    PreparedStatement ps;
    ResultSet rs;
    
    
    Conexion con = new Conexion(); 
    Connection acceso;
    
    public entidadUsuario validarUsuario(String user, String contraseña ){
       entidadUsuario eu = new entidadUsuario();
       String sql="SELECT *FROM usuarios WHERE user=? and contraseña=? ";
       try{
           acceso = con.Conectar();
           ps=acceso.prepareStatement(sql);
           ps.setString(1, user);
           ps.setString(2, contraseña);
           rs=ps.executeQuery();
           
           while(rs.next()){
               eu.setId(rs.getInt(1));
               eu.setNombre(rs.getString(2));
               eu.setApellido(rs.getString(3));
               eu.setTelefono(rs.getString(4));
               eu.setUser(rs.getString(5));
               eu.setContraseña(rs.getString(6));
               
           
           }
   }catch(Exception e){
    
       JOptionPane.showMessageDialog(null, "Error de conexion");
       
   }

       return eu;
   
   }
    
    
}
