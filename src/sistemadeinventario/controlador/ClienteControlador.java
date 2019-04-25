package sistemadeinventario.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistemadeinventario.dao.impl.ClienteDaoImpl;
import sistemadeinventario.modelo.Cliente;

public class ClienteControlador {

    private Cliente c = new Cliente();
    private ClienteDaoImpl clidao = new ClienteDaoImpl();
    private String mensaje = "";

    public String ingresarCliente(String nombre, String apellido, String direccion, String numero, String cedula, String correo) {

        try {
            c.setNbPersona(nombre);
            c.setApPersona(apellido);
            c.setDirPersona(direccion);
            c.setNumCel_Persona(numero);
            c.setCedCliente(cedula);
            c.setCorreoCliente(correo);
            clidao.insertar(c);
            mensaje = "Cliente Guardado Correctamente";
        } catch (Exception e) {
            mensaje = "Error! No se Pudo Agregar el Cliente";
        }
        return mensaje;
    }

    public String editarCliente(int codigo, String nombre, String apellido, String direccion, String numero, String cedula, String correo) {
        try {
            c.setCodPersona(codigo);
            c.setNbPersona(nombre);
            c.setApPersona(apellido);
            c.setDirPersona(direccion);
            c.setNumCel_Persona(numero);
            c.setCedCliente(cedula);
            c.setCorreoCliente(correo);
            clidao.modificar(c);
            mensaje = "Cliente editado Exitosamente!";
        } catch (Exception e) {
            mensaje = "Erro!, No se pudo Modificar el Cliente";
        }
        return mensaje;
    }

    public String eliminarCliente(int codigo) {
        try {
            c.setCodPersona(codigo);
            clidao.eliminar(c);
            mensaje = "Eliminado Exitosamente!";
        } catch (Exception e) {
            mensaje = "Error!, No se pudo Eliminar el Cliente";
        }
        return mensaje;
    }

    public void ListarAlumnos(JTable tabla) {
        DefaultTableModel model;
        String[] titulo = {"CODIGO", "NOMBRE", "APELLIDO", "CEDULA", "DIRECCION", "NUMERO DE TELEFONO", "CORREO"};
        model = new DefaultTableModel(null, titulo);

        List<Cliente> datosc = clidao.listarTodos();
        String[] encabezado = new String[7];
        for (Cliente cliente : datosc) {
            encabezado[0] = String.valueOf(cliente.getCodPersona());
            encabezado[1] = cliente.getNbPersona();
            encabezado[2] = cliente.getApPersona();
            encabezado[3] = cliente.getCedCliente();
            encabezado[4] = cliente.getDirPersona();
            encabezado[5] = cliente.getNumCel_Persona();
            encabezado[6] = cliente.getCorreoCliente();
            model.addRow(encabezado);
        }
        tabla.setModel(model);
    }

    public DefaultTableModel consultar(String buscar) {
        c.setCedCliente(buscar);
        DefaultTableModel model;
        String[] titulo = {"CODIGO", "NOMBRE", "APELLIDO", "CEDULA", "DIRECCION", "NUMERO DE TELEFONO", "CORREO"};
        model = new DefaultTableModel(null, titulo);

        List<Cliente> datosc = clidao.consultar(c);
        String[] encabezado = new String[7];
        for (Cliente cliente : datosc) {
            encabezado[0] = String.valueOf(cliente.getCodPersona());
            encabezado[1] = cliente.getNbPersona();
            encabezado[2] = cliente.getApPersona();
            encabezado[3] = cliente.getCedCliente();
            encabezado[4] = cliente.getDirPersona();
            encabezado[5] = cliente.getNumCel_Persona();
            encabezado[6] = cliente.getCorreoCliente();
            model.addRow(encabezado);
        }
        return model;

    }

    public int primerCliente(){
    
        return clidao.primerCliente();
    }
    
    public void insertarCliente(){
        
        clidao.insertarPrimerCliente();
    }
}
