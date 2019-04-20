package sistemadeinventario.modelo;

public class Cliente {

    private int codCliente;
    private String cedCliente;
    private String correoCliente;

    public Cliente() {
    }

    public Cliente(int codCliente, String cedCliente, String correoCliente) {
        this.codCliente = codCliente;
        this.cedCliente = cedCliente;
        this.correoCliente = correoCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCedCliente() {
        return cedCliente;
    }

    public void setCedCliente(String cedCliente) {
        this.cedCliente = cedCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

}
