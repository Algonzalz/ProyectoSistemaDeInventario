package sistemadeinventario.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistemadeinventario.dao.Conexion;
import sistemadeinventario.dao.IClienteDAO;
import sistemadeinventario.modelo.Cliente;

public class ClienteDaoImpl extends Conexion implements IClienteDAO {

    @Override
    public void insertar(Cliente c) {
        try {
            createConnection();

            pst = getCon().prepareStatement("INSERT INTO persona(nbPersona,apPersona,dirPersona,numCel_Persona)"
                    + "VALUES(?,?,?,?)");

            pst2 = getCon().prepareStatement("INSERT INTO cliente(codCliente,cedCliente,correoCliente)"
                    + "VALUES ((SELECT codPersona FROM persona ORDER BY codPersona DESC LIMIT 1),?,?)");

            pst.setString(1, c.getNbPersona());
            pst.setString(2, c.getApPersona());
            pst.setString(3, c.getDirPersona());
            pst.setString(4, c.getNumCel_Persona());

            pst2.setString(1, "V-" + c.getCedCliente());
            pst2.setString(2, c.getCorreoCliente());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void modificar(Cliente c) {
        try {
            createConnection();
            if (verificar(c)) {
                pst = getCon().prepareStatement("UPDATE persona SET nbPersona = ?, apPersona=?, dirPersona=?, numCel_Persona=? WHERE codPersona=?");

                pst2 = getCon().prepareStatement("UPDATE Cliente SET cedCliente = ?, correoCliente=? WHERE codCliente=?");

                pst.setString(1, c.getNbPersona());
                pst.setString(2, c.getApPersona());
                pst.setString(3, c.getDirPersona());
                pst.setString(4, c.getNumCel_Persona());
                pst.setInt(5, c.getCodPersona());

                pst2.setString(1, "V-" + c.getCedCliente());    //modificar el V- colocarlo dinamico en un jcombobox en la vista (ejemplo banesco)
                pst2.setString(2, c.getCorreoCliente());
                pst2.setInt(3, c.getCodPersona());
                pst.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "El Cliente no existe en los registros, Verifique!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }

    }

    @Override
    public void eliminar(Cliente c) {
        try {
            createConnection();
            if (verificar(c)) {

                pst = getCon().prepareStatement("DELETE FROM persona WHERE codPersona=?");
                pst2 = getCon().prepareStatement("DELETE FROM cliente WHERE codCliente=?");

                pst.setInt(1, c.getCodPersona());

                pst2.setInt(1, c.getCodCliente());

                pst.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "El Cliente no existe en los registros, Verifique!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> arrC = new ArrayList<>();
        createConnection();
        try {
            pst = getCon().prepareStatement("SELECT * FROM cliente c INNER JOIN persona p ON c.codCliente=p.codPersona ORDER BY codPersona DESC");
            rs = pst.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNbPersona(rs.getString("nbPersona"));
                c.setApPersona(rs.getString("apPersona"));
                c.setDirPersona(rs.getString("dirPersona"));
                c.setNumCel_Persona(rs.getString("numCel_Persona"));

                c.setCodCliente(rs.getInt("codCliente"));
                c.setCedCliente(rs.getString("cedCliente"));
                c.setCorreoCliente(rs.getString("correoCliente"));

                arrC.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LOS CLIENTES");
        } finally {
            closeConnection();
        }

        return arrC;
    }

    @Override
    public List<Cliente> consultar(Cliente c) {
        Cliente c2 = null;
        List<Cliente> arrC = new ArrayList<>();
        createConnection();
        try {

            pst = getCon().prepareStatement("SELECT c.codCliente, p.nbPersona, p.apPersona, c.cedCliente, p.dirPersona, p.numCel_Persona, c.correoCliente\n"
                    + "FROM persona p INNER JOIN  cliente c ON p.codPersona=c.codCliente \n"
                    + "WHERE c.cedCliente LIKE CONCAT('%',?,'%') ORDER BY codPersona DESC ");

            pst.setString(1, c.getCedCliente());

            rs = pst.executeQuery();

            while (rs.next()) {
                c2 = new Cliente();
                c2.setNbPersona(rs.getString("nbPersona"));
                c2.setApPersona(rs.getString("apPersona"));
                c2.setDirPersona(rs.getString("dirPersona"));
                c2.setNumCel_Persona(rs.getString("numCel_Persona"));

                c2.setCodCliente(rs.getInt("codCliente"));
                c2.setCedCliente(rs.getString("cedCliente"));
                c2.setCorreoCliente(rs.getString("correoCliente"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "\nNo se pudo consultar el cliente");
        } finally {
            closeConnection();
        }

        return arrC;
    }

    ////////////////////////////////////////////////////////////////////////////
    //////////////////// METODOS DE APLCIACION DE LA CLASE//////////////////////
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public int primerCliente() {

        try {
            createConnection();
            int cantidad = 0;
            pst = getCon().prepareStatement("SELECT COUNT(codCliente) as cantidad FROM cliente ");
            rs = pst.executeQuery();

            while (rs.next()) {

                cantidad = rs.getInt("cantidad");
            }
            return cantidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        } finally {
            closeConnection();
        }
    }

    @Override
    public void insertarPrimerCliente() {
        try {
            createConnection();
            pst = getCon().prepareStatement("INSERT INTO persona(nbPersona,apPersona,dirPersona,numCel_Persona)"
                    + "VALUES('Cliente General','0','0','0')");

            pst2 = getCon().prepareStatement("INSERT INTO cliente(codCliente,cedCliente)"
                    + "VALUES ((SELECT codPersona FROM persona ORDER BY codPersona DESC LIMIT 1),'0')");

            pst.executeUpdate();
            pst2.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
    }

    /**
     * METODO PARA VERIFICAR SI EXISTE EL CLIENTE EN LA BASE DE DATOS SE USA EN
     * EL MODIFICAR Y ELIMINAR
     */
    @Override
    public boolean verificar(Cliente c) {
        try {
            createConnection();
            pst = getCon().prepareStatement("SELECT * FROM persona p INNER JOIN cliente c ON p.codPersona = c.codCliente ");
            rs = pst.executeQuery();

            while (rs.next()) {
                if ((c.getCodCliente()) == (rs.getInt("codCliente"))) {
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
    
}
