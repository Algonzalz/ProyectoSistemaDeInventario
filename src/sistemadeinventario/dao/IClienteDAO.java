package sistemadeinventario.dao;

import sistemadeinventario.modelo.Cliente;

public interface IClienteDAO extends ICrud<Cliente> {

    int primerCliente();

    void insertarPrimerCliente();
}
