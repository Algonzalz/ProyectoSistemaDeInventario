package sistemadeinventario.dao.impl;

import java.util.ArrayList;
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
            if (verificarProducto(p)) {
                pst = getCon().prepareStatement("UPDATE producto SET nbProducto = ?, unidadProducto = ?, precioProducto = ?, precioCompra_Producto = ?,"
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
            } else {
                JOptionPane.showMessageDialog(null, "El Prodcuto no existe en los registros, Verifique!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void eliminarProducto(Producto p) {
        try {
            createConnection();
            if (verificarProducto(p)) {
                pst = getCon().prepareStatement("DELETE FROM producto WHERE codProducto = ?");

                pst.setInt(1, p.getCodProducto());
                pst.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "El Prodcuto no existe en los registros, Verifique!!");
            }
        } catch (Exception e) {
        }
    }

    /**
     * METODO PENSADO PARA MODIFICAR EL STOCK DEL PRODUCTO LUEGO DE
     * COMPRAR(PENSADO EN FACTURA_PRODUCTO)
     */
    @Override
    public void modificarStockProducto(Producto p) {

        try {
            createConnection();
            pst = getCon().prepareStatement("UPDATE producto SET stockActual_Producto = ? WHERE codProducto = ? ");
            pst.setInt(1, p.getStockActual_Produto());
            pst.setInt(2, p.getCodProducto());

            pst.executeUpdate();
        } catch (Exception e) {
        }

    }

    @Override
    public List<Producto> listarXNombreProducto(Producto p) {
       Producto p2=null;
       List<Producto> arrP=new ArrayList<>();
       
        try {
            createConnection();
            pst=getCon().prepareStatement("SELECT codProdcuto, nbProducto, descripcionProducto, unidadProducto, "
                    + "precioProducto,stockActual_Producto, precioCompra_Producto, stockMinimo_Producto,"
                    + "(SELECT nbCategoria FROM codCategoria WHERE codCategoria=codCategoria) as Nombre_Categoria"
                    + "FROM producto WHERE nbProducto LIKE CONCAT ('%',?,'%') ORDER BY codProducto DESC");
            pst.setString(1, p.getNbProducto());
            rs=pst.executeQuery();
            while(rs.next()){
                p2=new Producto();
                
                p2.setCodProducto(rs.getInt("codProducto"));
                p2.setNbProducto(rs.getString("nbProducto"));
                p2.setDescripcionProducto(rs.getString("descripcionProducto"));
                p2.setUnidadProducto(rs.getString("unidadProducto"));
                p2.setPrecioProducto(rs.getDouble("precioProducto"));
                
            
            }
        } catch (Exception e) {
        }
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

    @Override
    public boolean verificarProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
