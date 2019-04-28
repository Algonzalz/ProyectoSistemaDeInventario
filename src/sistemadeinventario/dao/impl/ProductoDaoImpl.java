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
                    + ", precioProducto, precioCompra_Producto, descripcionProducto, StockActual_Producto, stockMinimo_Producto, codCategoria)"
                    + "VALUES(?,?,?,?,?,?,?,?,(SELECT codCategoria FROM categoria WHERE nbCategoria LIKE CONCAT('%',?,'%')))");

            pst.setInt(1, p.getCodProducto());
            pst.setString(2, p.getNbProducto());
            pst.setString(3, p.getUnidadProducto());
            pst.setDouble(4, p.getPrecioProducto());
            pst.setDouble(5, p.getPrecioCompra_Producto());
            pst.setString(6, p.getDescripcionProducto());
            pst.setInt(7, p.getStockActual_Produto());
            pst.setInt(8, p.getStockMinimo_Produto());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void modificarProducto(Producto p, String Categoria) {

        try {
            createConnection();

            pst = getCon().prepareStatement("UPDATE INTO producto SET nbProducto = ?, unidadProducto = ?, precioProducto = ?, precioCompra_Producto = ?,"
                    + "descripcionProducto = ?, stockActual_Producto = ?, stockMinimo_Producto = ?,"
                    + " codCategoria = (SELECT codCategoria FROM categoria LIKE CONCAT ('%',?,'%') LIMIT 1 ) WHERE codProducto = ? ");

            pst.setString(1, p.getNbProducto());
            pst.setString(2, p.getUnidadProducto());
            pst.setDouble(3, p.getPrecioProducto());
            pst.setDouble(4, p.getPrecioCompra_Producto());
            pst.setString(5, p.getDescripcionProducto());
            pst.setInt(6, p.getStockActual_Produto());
            pst.setInt(7, p.getStockMinimo_Produto());

            pst.setInt(1, p.getCodProducto());
            
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
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
