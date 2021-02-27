
package ControladorCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.CRUD;
import modelo.Conexion;
import modelo.EntidadPadecimiento;

/**
 *
 * @author moisesvelasco
 */
public class PadecimientoDao implements CRUD {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;
    

    @Override
    public List listar() {
        List<EntidadPadecimiento> lista = new ArrayList<>();
        String sql="SELECT * FROM padecimiento";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadPadecimiento ep = new EntidadPadecimiento();
                 ep.setIdPadecimiento(rs.getInt(1));                
                 ep.setNombrePadecimiento(rs.getString(2));
                 ep.setSimbolo(rs.getString(3));
                 lista.add(ep);
                 
            }
        }
        catch(Exception e){}
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO padecimiento (nombrePadecimiento,simbolo) values (?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            r=ps.executeUpdate();
  
        }
        catch(Exception e){}
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r=0;
        String sql="UPDATE padecimiento set nombrePadecimiento=?,simbolo=?  where idPadecimiento=?";
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
    public void eliminar(int id) {
        String sql="DELETE FROM padecimiento where idPadecimiento=?";
         try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            }
        catch(Exception e){}
    }
    
    
}
