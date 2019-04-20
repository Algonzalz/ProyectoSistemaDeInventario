package sistemadeinventario.modelo;

public class Factura_Producto {

    private int codFactura_Producto;
    private int codFactura_FK;
    private int codProducto_FK;

    public Factura_Producto() {
    }

    public Factura_Producto(int codFactura_Producto, int codFactura_FK, int codProducto_FK) {
        this.codFactura_Producto = codFactura_Producto;
        this.codFactura_FK = codFactura_FK;
        this.codProducto_FK = codProducto_FK;
    }

    public int getCodFactura_Producto() {
        return codFactura_Producto;
    }

    public void setCodFactura_Producto(int codFactura_Producto) {
        this.codFactura_Producto = codFactura_Producto;
    }

    public int getCodFactura_FK() {
        return codFactura_FK;
    }

    public void setCodFactura_FK(int codFactura_FK) {
        this.codFactura_FK = codFactura_FK;
    }

    public int getCodProducto_FK() {
        return codProducto_FK;
    }

    public void setCodProducto_FK(int codProducto_FK) {
        this.codProducto_FK = codProducto_FK;
    }

}
