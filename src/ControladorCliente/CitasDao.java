
package ControladorCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.CRUD;
import modelo.Conexion;
import modelo.EntidadCita;
import modelo.EntidadTipoCons;

/**
 *
 * @author moisesvelasco
 */
public class CitasDao implements CRUD {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;
   // EntidadCita ecc = new EntidadCita();
    @Override
    public List listar() {
        List<EntidadCita> lista = new ArrayList<>();
        String sql="SELECT * FROM citas";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadCita ep = new EntidadCita();
                 ep.setFolio(rs.getInt(1));                
                 ep.setIdCliente(rs.getInt(2));
                 ep.setFechaCita(rs.getString(3));
                 ep.setSaldo(rs.getInt(4));
                 lista.add(ep);
                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    //consulta que busca todas las citas por id del Cliente
    public List listarCitas(int idC) {
        List<EntidadCita> lista = new ArrayList<>();
        String sql="SELECT * FROM citas where idCliente=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idC);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadCita ep = new EntidadCita();
                 ep.setFolio(rs.getInt(1));                
                 ep.setIdCliente(rs.getInt(2));
                 ep.setFechaCita(rs.getString(3));
                 ep.setTipoConsulta(rs.getInt(4));
                 ep.setSaldo(rs.getInt(5));
                 lista.add(ep);
                 
            }
        }
        catch(Exception e){}
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO citas (idCliente,fechaCita,idTipoConsulta,saldo) values (?,?,?,?) ";
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
        try{
            con=cn.Conectar();
            String sql="UPDATE citas set idCliente=?,fechaCita=?,saldo=?  where folio=?";
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]); 
            ps.setObject(3, o[2]);           
            r=ps.executeUpdate(); 
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "debe selecionar una fila");}
        return r;
    }
    public int actualizarSaldo(Object[] o) {
        int r=0;        
        try{
            con=cn.Conectar();
            String sql="UPDATE citas set saldo=?  where folio=?";
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            
            r=ps.executeUpdate(); 
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "erro en consulta actualizar saldo");}
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM citas where folio=?";
         try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            }
        catch(Exception e){}
    }
    //esta consulta nos servira en cuentas
    public EntidadCita obtenerDatos (int folio) {
        EntidadCita ec = new EntidadCita();
        String sql="SELECT * FROM citas where idCliente=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setFolio(rs.getInt(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadTipoCons obteneridTipoCons (String nom) {
        EntidadTipoCons ec = new EntidadTipoCons();
        String sql="SELECT * FROM tipoConsulta where nombreConsulta=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, nom);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setIdTipoConsulta(rs.getInt(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadTipoCons obtenerNomTipoCons (int id) {
        EntidadTipoCons ec = new EntidadTipoCons();
        String sql="SELECT nombreConsulta FROM tipoConsulta where idTipoConsulta=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreConsulta(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
    
    public EntidadCita obtenerDatosCita (int folio) {
        EntidadCita ec = new EntidadCita();
        String sql="SELECT * FROM citas where folio=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
               ec.setFolio(rs.getInt(1));
               ec.setIdCliente(rs.getInt(2));
               ec.setFechaCita(rs.getString(3));
               ec.setTipoConsulta(rs.getInt(4));
            }
        }
        catch(Exception e){}return ec;
    }
   
}
