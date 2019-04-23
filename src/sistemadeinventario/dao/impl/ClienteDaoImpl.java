package sistemadeinventario.dao.impl;

import java.sql.SQLException;
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
            pst.setInt(4, c.getNumCel_Persona());

            pst2.setString(1, "V-" + c.getCedCliente());
            pst2.setString(2, c.getCorreoCliente());
            int N = pst.executeUpdate();
            if (N != 0) {
                int N2 = pst2.executeUpdate();
                if (N2 != 0) {
                } else {
                    JOptionPane.showMessageDialog(null, "SENTENCIAS SQL NO EJECUTADAS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "SENTENCIAS SQL NO EJECUTADAS");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Cliente c) {
        try {
            createConnection();
            pst = getCon().prepareStatement("UPDATE persona SET nbPersona = ?, apPersona=?, dirPersona=?, numCel_Persona=? WHERE codPersona=?");

            pst2 = getCon().prepareStatement("UPDATE Cliente SET cedCliente = ?, correoCliente=? WHERE codCliente=?");

            pst.setString(1, c.getNbPersona());
            pst.setString(2, c.getApPersona());
            pst.setString(3, c.getDirPersona());
            pst.setInt(4, c.getNumCel_Persona());
            pst.setInt(5, c.getCodPersona());

            pst2.setString(1, "V-" + c.getCedCliente());
            pst2.setString(2, c.getCorreoCliente());
            pst.setInt(3, c.getCodPersona());
            int N = pst.executeUpdate();
            if (N != 0) {
                int N2 = pst2.executeUpdate();
                if (N2 != 0) {
                } else {
                    JOptionPane.showMessageDialog(null, "SENTENCIAS SQL NO EJECUTADAS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "SENTENCIAS SQL NO EJECUTADAS");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void eliminar(Cliente c) {
        try {
            createConnection();

            pst = getCon().prepareStatement("DELETE FROM persona WHERE codPersona=?");
            pst2 = getCon().prepareStatement("DELETE FROM cliente WHERE codCliente=?");
            
            pst.setInt(1, c.getCodPersona());
            
            pst2.setInt(1, c.getCodCliente());
            
        } catch (Exception e) {
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente consultar(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
