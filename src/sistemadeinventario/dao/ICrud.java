package sistemadeinventario.dao;

import java.util.List;

public interface ICrud<T> {

    void insertar(T t);

    void modificar(T t);

    void eliminar(T t);

    List<T> listarTodos();

    T consultar(T t);

}
