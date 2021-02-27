
package RelacionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Conexion;

/**
 *
 * @author moisesvelasco
 */
public class cita_cuidado {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;
    public int add(Object[] o){
        int r=0;
        String sql="INSERT INTO cita_cuidados (folio,idCuidado) values (?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);            
            r=ps.executeUpdate();  
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "error al agregar examenteji"+e.getMessage()); }
        return r;
    }
    public int addF(Object[] o){
        int r=0;
        String sql="INSERT INTO cita_cuidadosF (folio,vecesCepilla,idCuidado) values (?,?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);              
            r=ps.executeUpdate();  
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "error al agregar examenteji"+e.getMessage()); }
        return r;
    }
    
}
