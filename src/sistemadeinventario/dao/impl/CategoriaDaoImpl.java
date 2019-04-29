package sistemadeinventario.dao.impl;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import sistemadeinventario.dao.Conexion;
import sistemadeinventario.dao.ICategoriaDAO;
import sistemadeinventario.modelo.Categoria;

public class CategoriaDaoImpl extends Conexion implements ICategoriaDAO {

    @Override
    public void insertar(Categoria ca) {
        try {
            createConnection();
//            if((verificar(ca)==false)){
            pst = getCon().prepareStatement("INSERT INTO categoria(nbCategoria, descripcionCategoria)"
                    + "VALUES(?,?)");

            pst.setString(1, ca.getNbCategoria());
            pst.setString(2, ca.getDescripcionCategoria());
            pst.executeUpdate();
//            } else {
//                JOptionPane.showMessageDialog(null, "La Categoria ya existe en los registros, Verificque!!");
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void modificar(Categoria ca) {
        try {
            createConnection();
//            if(verificar(ca)){
            pst = getCon().prepareStatement("UPDATE categoria SET nbCategoria = ?, descripcionCategoria = ? WHERE codCategoria = ?");

            pst.setString(1, ca.getNbCategoria());
            pst.setString(2, ca.getDescripcionCategoria());
            pst.setInt(3, ca.getCodCategoria());

            pst.executeUpdate();
//            } else {
//                JOptionPane.showMessageDialog(null, "La Categoria no existe en los registros, Verifique!!");
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void eliminar(Categoria ca) {
       if(verificar(ca)){
       
       } else {
                JOptionPane.showMessageDialog(null, "La Categoria no existe en los registros, Verificque!!");
            }
    }

    @Override
    public List<Categoria> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> consultar(Categoria t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificar(Categoria t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    METODO PARA IR PROBADON... 
    PROBADOS ACTUALMENTE -->()
    */
    public static void main(String[] args) {
        Categoria ca=new Categoria();
        CategoriaDaoImpl cadaoimp=new  CategoriaDaoImpl();
        
        ca.setNbCategoria("Cauchos");
        ca.setDescripcionCategoria("Ninguno");
        ca.setCodCategoria(1);
//        
//        cadaoimp.insertar(ca);
cadaoimp.modificar(ca);
        
        JOptionPane.showMessageDialog(null, "DATOS:"
                + "\nCOD: "+ca.getCodCategoria()
                + "\nNombre: "+ca.getNbCategoria()
                + "\nDescripcion: "+ca.getDescripcionCategoria());
        
    }
}
