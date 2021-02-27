/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author moisesvelasco
 */
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class inventarioDao implements CRUD {
    PreparedStatement ps;
    ResultSet rs;
    
    //EntidadInventario ea = new EntidadInventario();
    Conexion cn = new Conexion(); 
    Connection con;
   
    @Override
    public List listar() {
        List<EntidadInventario> lista = new ArrayList<>();
        String sql="SELECT * FROM productos";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadInventario ea = new EntidadInventario();
                 ea.setidProducto(rs.getInt(1));
                 ea.setNombreProducto(rs.getString(2));
                 ea.setCodigo(rs.getString(3));
                 ea.setExistencia(rs.getInt(4));
                 ea.setFechaCaducidad(rs.getString(5));
                 lista.add(ea);
            }
        }
        catch(Exception e){}
        return lista;
    
    }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO productos (nombreProductos, codigo, existencia, fechaCaducidad) values (?,?,?,?) ";
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
    public int actualizar(Object[] o) {
        int r=0;
        String sql="UPDATE productos set nombreProductos=?,codigo=? ,existencia=?,fechaCaducidad=? where idProducto=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r=ps.executeUpdate();
            
        
        }
        catch(Exception e){}
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM Productos where idProducto=?";
         try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        
        }
        catch(Exception e){}
    
    }

    
}
