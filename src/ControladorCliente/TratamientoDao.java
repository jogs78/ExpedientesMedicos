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
import modelo.CRUD;
import modelo.Conexion;
import modelo.EntidadTratamiento;

/**
 *
 * @author moisesvelasco
 */
public class TratamientoDao implements CRUD {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;
    

    @Override
    public List listar() {
         List<EntidadTratamiento> lista = new ArrayList<>();
        String sql="SELECT * FROM tratamiento";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadTratamiento ep = new EntidadTratamiento();
                 ep.setIdTratamiento(rs.getInt(1));                
                 ep.setNombreTratamiento(rs.getString(2));
                 ep.setSimboloTratamiento(rs.getString(3));
                 ep.setPrecioTratamiento(rs.getInt(4));
                 lista.add(ep);
                 
            }
        }
        catch(Exception e){}
        return lista;
     }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO tratamiento (nombreTratamiento,simboloTratamiento,precioTratamiento) values (?,?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r=ps.executeUpdate();  
        }
        catch(Exception e){}
        return r; 
    }
    @Override
    public int actualizar(Object[] o) {
        int r=0;
        String sql="UPDATE tratamiento set nombreTratamiento=?,simboloTratamiento=?,precioTratamiento=?  where idTratamiento=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]); 
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r=ps.executeUpdate(); 
        }
        catch(Exception e){}
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM tratamiento where idTratamiento=?";
         try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            }
        catch(Exception e){}
    }
    
}
