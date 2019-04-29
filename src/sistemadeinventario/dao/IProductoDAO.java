package sistemadeinventario.dao;

import java.util.List;
import sistemadeinventario.modelo.Producto;

public interface IProductoDAO{
   
    void ingresarProducto(Producto p, String categoria);
    
    void modificarProducto(Producto p, String Categoria);
    
    void eliminarProducto(Producto p);
    
    void modificarStockProducto(Producto p); //UTILIZADA EN LA CLASE FACTURA_DETALLE 25/4/2019 !!!!(Borrar cuando termine)
    
    List<Producto> listarXNombreProducto(Producto p);
    List<Producto> listarXCodigoProducto(Producto p);// SE CREA UN METODO EN EL FORMULARIO PRODUCTO PARA 25/4/2019 !!!! (Borrar cuando termine)
    
    
    List<String> llenarComboBox();  //LLENAR EL COMBOBOX DE CATEGORIAS
    
    boolean verificarProducto(Producto p);
    
    
    
    
}
