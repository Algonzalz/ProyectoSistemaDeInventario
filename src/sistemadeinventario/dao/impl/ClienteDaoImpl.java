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
            pst.setInt(4, c.getNumCel_Persona());

            pst2.setString(1, "V-" + c.getCedCliente());
            pst2.setString(2, c.getCorreoCliente());
            int N = pst.executeUpdate();
            if (N != 0) {
                int N2 = pst2.executeUpdate();
                if (N2 != 0) {
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO INGRESAR EL CLIENTE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "SNO SE PUDO INGRESAR EL CLIENTE");
            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
        closeConnection();
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
                    JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL CLIENTE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL CLIENTE");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
        closeConnection();
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
            
            int N = pst.executeUpdate();
            if(N!=0){
                int N2 = pst2.executeUpdate();
                
                if(N2!=0){
                
                }else{ JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL CLIENTE");}
            
            }else { JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL CLIENTE");}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
        closeConnection();
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> arrA = new ArrayList<>();
        createConnection();
        try {
            pst = getCon().prepareStatement("SELECT * FROM cliente c INNER JOIN persona p ON c.codCliente=p.codPersona");
            rs = pst.executeQuery();
 

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNbPersona(rs.getString("nbPersona"));
                c.setApPersona(rs.getString("apPersona"));
                c.setDirPersona(rs.getString("dirPersona"));
                c.setNumCel_Persona(rs.getInt("numCel_Persona"));
                
                c.setCodCliente(rs.getInt("codCliente"));
                c.setCedCliente(rs.getString("cedCliente"));
                c.setCorreoCliente(rs.getString("correoCliente"));
                
                arrA.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LOS CLIENTES");
        } finally {
            closeConnection();
        }

        return arrA;
    }

    @Override
    public Cliente consultar(Cliente c) {
       Cliente c2 = null;

        createConnection();
        try {

            pst = getCon().prepareStatement("SELECT p.codPersona, p.nbPersona, p.apPersona, c.cedCliente, p.dirPersona, p.numCel_Persona, c.correoCliente\n" 
                                            + "FROM persona p INNER JOIN  cliente c ON p.codPersona=c.codCliente \n" 
                                            + "WHERE (nbPersona LIKE '%?%' OR cedCliente LIKE '%?%' )");
//            pst.setInt(1, );
//            pst.setString(2, a.getCedula());
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//                a2 = new Alumno();
//                a2.setId(rs.getInt("id"));
//                a2.setNombre(rs.getString("nombre"));
//                a2.setApellido(rs.getString("apellido"));
//                a2.setCedula(rs.getString("cedula"));
//                a2.setSemestre(rs.getInt("semestre"));
//                
//                
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
        closeConnection();
        }

       return c2;
  }

}
