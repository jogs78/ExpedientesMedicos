
package ControladorCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.CRUD;
import modelo.Conexion;
import modelo.EntidadCliente;

/**
 *
 * @author moisesvelasco
 */
public class ClienteDao implements CRUD {
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion(); 
    Connection con;

    @Override
    public List listar() {//esta primer consulta se utiliza en la ventana de inicio y clientes para listar todos los registros
        List<EntidadCliente> lista = new ArrayList<>();
        String sql="SELECT * FROM datosCliente";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadCliente ec = new EntidadCliente();
                 ec.setIdCliente(rs.getInt(1));
                 ec.setNombreCliente(rs.getString(2));
                 ec.setApellidoPat(rs.getString(3));
                 ec.setApellidoMat(rs.getString(4));
                 ec.setDomicilio(rs.getString(5));
                 ec.setContacto(rs.getString(6));
                 ec.setFechaRegistro(rs.getString(7));
                 ec.setFechaInicia(rs.getString(8));
                 ec.setFechaTermina(rs.getString(9));
                 ec.setEdad(rs.getInt(10));
                 ec.setSexo(rs.getString(11));
                 lista.add(ec);
            }
        }
        catch(Exception e){}
        return lista;
    }

    @Override
    public int add(Object[] o) {//se agrega en inicio
        int r=0;
        String sql="INSERT INTO datosCliente (nombreCliente,apellidoPat,apellidoMAt, domicilio, contacto, fechaRegistro, fechaInicia, fechaTermina,edad,sexo,saldo) values (?,?,?,?,?,?,?,?,?,?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            ps.setObject(9, o[8]);
            ps.setObject(10, o[9]);
            ps.setObject(11, o[10]);
            r=ps.executeUpdate(); 
        }
        catch(Exception e){}
        return r;
     
    }

    @Override
    public int actualizar(Object[] o) {//se actualiza en inicio
         int r=0;
        String sql="UPDATE datosCliente set nombreCliente=?,apellidoPat=?,apellidoMat=?,domicilio=? ,contacto=?,fechaRegistro=?,fechaInicia=?,fechaTermina=?,edad=?,sexo=? where idCliente=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            ps.setObject(9, o[8]);
            ps.setObject(10, o[9]);
            ps.setObject(11, o[10]);
            r=ps.executeUpdate();
            
        
        }
        catch(Exception e){}
        return r;
    
    }

    @Override
    public void eliminar(int id) {//se elimina en inicio o en clientes (ventanas)
        String sql="DELETE FROM datosCliente where idCliente=?";
         try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(Exception e){}    
    }
    public EntidadCliente obtenerNombre (int idCliente) {//esta consulta es para obtener nombre desde un id
        EntidadCliente ec = new EntidadCliente();//instanciamos clase
        String sql="SELECT * FROM datosCliente where idCliente=?";//consulta
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreCliente(rs.getString(2));
                ec.setApellidoPat(rs.getString(3));
                ec.setApellidoMat(rs.getString(4));
            }
        }
        catch(Exception e){}return ec;
    }
    
    //este select se usara en la vista clientes para buscar todos sus datos
    public EntidadCliente obtenerinfoContacto (String contacto) {
        EntidadCliente ec = new EntidadCliente();
        String sql="SELECT idCliente FROM datosCliente where contacto=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, contacto);
            rs=ps.executeQuery();
            while(rs.next()){
                
                ec.setIdCliente(rs.getInt(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public List listarUnCliente(int id) {
        List<EntidadCliente> lista = new ArrayList<>();
        String sql="SELECT * FROM datosCliente where idCliente=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadCliente ec = new EntidadCliente();
                 ec.setIdCliente(rs.getInt(1));
                 ec.setNombreCliente(rs.getString(2));
                 ec.setDomicilio(rs.getString(3));
                 ec.setContacto(rs.getString(4));
                 ec.setFechaRegistro(rs.getString(5));
                 ec.setFechaInicia(rs.getString(6));
                 ec.setFechaTermina(rs.getString(7));
                 ec.setEdad(rs.getInt(8));
                 ec.setSexo(rs.getString(9));
                 
                 lista.add(ec);
            }
        }
        catch(Exception e){}
        return lista;
    }
}
