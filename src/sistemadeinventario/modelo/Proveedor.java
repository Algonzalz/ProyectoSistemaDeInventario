package sistemadeinventario.modelo;

public class Proveedor extends Persona {

    private int codProveedor;
    private String cedProveedor;
    private String correoProveedor;

    public Proveedor() {
    }

    public Proveedor(int codProveedor, String cedProveedor, String correoProveedor) {
        this.codProveedor = codProveedor;
        this.cedProveedor = cedProveedor;
        this.correoProveedor = correoProveedor;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getCedProveedor() {
        return cedProveedor;
    }

    public void setCedProveedor(String cedProveedor) {
        this.cedProveedor = cedProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

}
