
package ControladorCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.CRUD;
import modelo.Conexion;
import modelo.EntidadDientes;

/**
 *
 * @author moisesvelasco
 */
public class DienteDao implements CRUD{
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;

    @Override
    public List listar() {
        List<EntidadDientes> lista = new ArrayList<>();
        String sql="SELECT * FROM dientes";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadDientes ep = new EntidadDientes();
                 ep.setIdDiente(rs.getInt(1));                
                 ep.setNombreDiente(rs.getString(2));
                 ep.setSimboloDiente(rs.getString(3));
                 lista.add(ep);
                 
            }
        }
        catch(Exception e){}
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO dientes (nombreDiente,simboloDiente) values (?,?) ";
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
        try{
            con=cn.Conectar();
            String sql="UPDATE dientes set simboloDiente=?  where idDiente=?";
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);                        
            r=ps.executeUpdate(); 
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "debe selecionar una fila");}
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM dientes where idDiente=?";
         try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            }
        catch(Exception e){}
    }
    public EntidadDientes obtenerIdAntece (int id) {
         EntidadDientes ec = new EntidadDientes();
        String sql="SELECT nombreDiente  FROM dientes where idDiente=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreDiente(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
   
}
