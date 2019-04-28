package sistemadeinventario.modelo;

public class Producto {

    private int codProducto;
    private String nbProducto;
    private String unidadProducto;
    private double precioProducto;
    private double precioCompra_Producto;
    private String descripcionProducto;
    private int stockActual_Produto;
    private int stockMinimo_Produto;

    private int codCategoria;

    public Producto() {
    }

    public Producto(int codProducto, String nbProducto, String unidadProducto, double precioProducto, double precioCompra_Producto, String descripcionProducto, int stockActual_Produto, int stockMinimo_Produto, int codCategoria) {
        this.codProducto = codProducto;
        this.nbProducto = nbProducto;
        this.unidadProducto = unidadProducto;
        this.precioProducto = precioProducto;
        this.precioCompra_Producto = precioCompra_Producto;
        this.descripcionProducto = descripcionProducto;
        this.stockActual_Produto = stockActual_Produto;
        this.stockMinimo_Produto = stockMinimo_Produto;
        this.codCategoria = codCategoria;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNbProducto() {
        return nbProducto;
    }

    public void setNbProducto(String nbProducto) {
        this.nbProducto = nbProducto;
    }

    public String getUnidadProducto() {
        return unidadProducto;
    }

    public void setUnidadProducto(String unidadProducto) {
        this.unidadProducto = unidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getPrecioCompra_Producto() {
        return precioCompra_Producto;
    }

    public void setPrecioCompra_Producto(double precioCompra_Producto) {
        this.precioCompra_Producto = precioCompra_Producto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getStockActual_Produto() {
        return stockActual_Produto;
    }

    public void setStockActual_Produto(int stockActual_Produto) {
        this.stockActual_Produto = stockActual_Produto;
    }

    public int getStockMinimo_Produto() {
        return stockMinimo_Produto;
    }

    public void setStockMinimo_Produto(int stockMinimo_Produto) {
        this.stockMinimo_Produto = stockMinimo_Produto;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

}
