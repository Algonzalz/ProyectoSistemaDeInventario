package sistemadeinventario.dao.impl;

import java.util.List;
import javax.swing.JOptionPane;
import sistemadeinventario.dao.Conexion;
import sistemadeinventario.dao.IProductoDAO;
import sistemadeinventario.modelo.Producto;

public class ProductoDaoImpl extends Conexion implements IProductoDAO {

    @Override
    public void ingresarProducto(Producto p, String categoria) {

        try {
            createConnection();
            pst = getCon().prepareStatement("INSERT INTO producto(codProducto, nbProducto, unidadProducto"
                    + ", precioProducto, precioCompra_Prodcuto, descripcionProducto, StockActual_Producto, stockMinimo_Producto, codCategoria)"
                    + "VALUES(?,?,?,?,?,?,?,?,(SELECT codCategoria FROM categoria WHERE nbCategoria LIKE CONCAT('%',?,'%')))");

//            pst.setString(1, c.getNbPersona());
//            pst.setString(2, c.getApPersona());
//            pst.setString(3, c.getDirPersona());
//            pst.setString(4, c.getNumCel_Persona());
//
//            pst2.setString(1, "V-" + c.getCedCliente());
//            pst2.setString(2, c.getCorreoCliente());
            int N = pst.executeUpdate();
            if (N != 0) {
                int N2 = pst2.executeUpdate();
                if (N2 != 0) {
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO INGRESAR EL CLIENTE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO INGRESAR EL CLIENTE");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void modificarProducto(Producto p, String Categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarStockProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarXNombreProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarXCodigoProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int productoIgual(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> llenarComboBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
