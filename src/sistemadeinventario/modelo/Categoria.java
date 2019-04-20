package sistemadeinventario.modelo;

public class Categoria {

    private int codCategoria;
    private String nbCategoria;
    private String descripcionCategoria;

    public Categoria() {
    }

    public Categoria(int codCategoria, String nbCategoria, String descripcionCategoria) {
        this.codCategoria = codCategoria;
        this.nbCategoria = nbCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNbCategoria() {
        return nbCategoria;
    }

    public void setNbCategoria(String nbCategoria) {
        this.nbCategoria = nbCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

}
