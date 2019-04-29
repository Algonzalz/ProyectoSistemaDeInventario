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
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
    }

    /**
     * METODO PENSADO PARA MODIFICAR EL STOCK DEL PRODUCTO LUEGO DE COMPRAR(EN
     * FACTURA_PRODUCTO o FACTURA)
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
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }

    }

    @Override
    public List<Producto> listarXNombreProducto(Producto p) {
        Producto p2 = null;
        List<Producto> arrP = new ArrayList<>();

        try {
            createConnection();
            pst = getCon().prepareStatement("SELECT codProducto, nbProducto, descripcionProducto, unidadProducto, "
                    + "precioProducto,stockActual_Producto, precioCompra_Producto, stockMinimo_Producto,"
                    + "(SELECT nbCategoria FROM categoria WHERE codCategoria=codCategoria) as nbCategoria"
                    + "FROM producto WHERE nbProducto LIKE CONCAT ('%',?,'%') ORDER BY codProducto DESC");
            pst.setString(1, p.getNbProducto());
            rs = pst.executeQuery();
            while (rs.next()) {
                p2 = new Producto();

                p2.setCodProducto(rs.getInt("codProducto"));
                p2.setNbProducto(rs.getString("nbProducto"));
                p2.setDescripcionProducto(rs.getString("descripcionProducto"));
                p2.setUnidadProducto(rs.getString("unidadProducto"));
                p2.setPrecioProducto(rs.getDouble("precioProducto"));
                p2.setStockActual_Produto(rs.getInt("stockActual_Producto"));
                p2.setPrecioCompra_Producto(rs.getDouble("precioCompra_Producto"));
                p2.setStockMinimo_Produto(rs.getInt("stockMinimo_Producto"));
                p2.setCodCategoria(rs.getInt("nbCategoria"));

                arrP.add(p2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return arrP;
    }

    @Override
    public List<Producto> listarXCodigoProducto(Producto p) {
        Producto p2 = null;
        List<Producto> arrP = new ArrayList<>();

        try {
            createConnection();
            pst = getCon().prepareStatement("SELECT codProducto, nbProducto, descripcionProducto, unidadProducto, "
                    + "precioProducto,stockActual_Producto, precioCompra_Producto, stockMinimo_Producto,"
                    + "(SELECT nbCategoria FROM categoria WHERE codCategoria=codCategoria) as nbCategoria"
                    + "FROM producto WHERE codProducto LIKE CONCAT ('%',?,'%') ORDER BY codProducto DESC");
            pst.setInt(1, p.getCodProducto());
            rs = pst.executeQuery();
            while (rs.next()) {
                p2 = new Producto();

                p2.setCodProducto(rs.getInt("codProducto"));
                p2.setNbProducto(rs.getString("nbProducto"));
                p2.setDescripcionProducto(rs.getString("descripcionProducto"));
                p2.setUnidadProducto(rs.getString("unidadProducto"));
                p2.setPrecioProducto(rs.getDouble("precioProducto"));
                p2.setStockActual_Produto(rs.getInt("stockActual_Producto"));
                p2.setPrecioCompra_Producto(rs.getDouble("precioCompra_Producto"));
                p2.setStockMinimo_Produto(rs.getInt("stockMinimo_Producto"));
                p2.setCodCategoria(rs.getInt("nbCategoria"));

                arrP.add(p2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return arrP;
    }

    @Override
    public List<String> llenarComboBox() {
        List<String> arrP = new ArrayList<>();

        try {
            createConnection();

            pst = getCon().prepareStatement("SELECT nbCategoria FROM categoria");
            rs = pst.executeQuery();

            while (rs.next()) {
                arrP.add(rs.getString("nbCategoria"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return arrP;
    }

    @Override
    public boolean verificarProducto(Producto p) {
        try {
            createConnection();

            pst = getCon().prepareStatement("SELECT * FROM producto");
            rs = pst.executeQuery();

            while (rs.next()) {
                if ((p.getCodProducto()) == (rs.getInt("codProducto"))) {
                    return true;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return false;
    }

    /*
    PRUEBAS PARA LOS METODOS
     */
//    public static void main(String[] args) {
//        Producto p=new Producto();
//        
//        
//    }
}
