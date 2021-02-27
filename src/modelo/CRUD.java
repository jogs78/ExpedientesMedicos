
package modelo;

import java.util.List;

/**
 *
 * @author moisesvelasco
 */
public interface CRUD {
    
    public List listar ();
    public int add(Object[] o);
    public int  actualizar(Object[] o);
    public void eliminar(int id);
    
}
