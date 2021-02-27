
package ControladorCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.EntidadAnticon;

/**
 *
 * @author moisesvelasco
 */
public class Anticonsep {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;
    
    public EntidadAnticon obtenerIdAnti (String nom) {
        EntidadAnticon ec = new EntidadAnticon();
        String sql="SELECT * FROM Anticonseptivos where tipoAnt=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, nom);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setIdAnticonsep(rs.getInt(1));
            }
        }
        catch(Exception e){}
        return ec;
    }
    public int addAnti(Object[] o) {
        int r=0;
        String sql="INSERT INTO cita_anticonseptivos (folio,idAnticonseptivo) values (?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);                      
            r=ps.executeUpdate();  
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "error al agregar anticon"+e.getMessage()); }
        return r;
    }
    
    
}
