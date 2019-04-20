package sistemadeinventario.modelo;

public class Usuario {

    private int codUsuario;
    private String cedUusario;
    private String loginUsuario;
    private String passUsuario;
    private String estadoUsuario;
    private String accesoUsuario;

    public Usuario() {
    }

    public Usuario(int codUsuario, String cedUusario, String loginUsuario, String passUsuario, String estadoUsuario, String accesoUsuario) {
        this.codUsuario = codUsuario;
        this.cedUusario = cedUusario;
        this.loginUsuario = loginUsuario;
        this.passUsuario = passUsuario;
        this.estadoUsuario = estadoUsuario;
        this.accesoUsuario = accesoUsuario;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCedUusario() {
        return cedUusario;
    }

    public void setCedUusario(String cedUusario) {
        this.cedUusario = cedUusario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getAccesoUsuario() {
        return accesoUsuario;
    }

    public void setAccesoUsuario(String accesoUsuario) {
        this.accesoUsuario = accesoUsuario;
    }

}
