package sistemadeinventario.modelo;

public class Persona {

    private int codPersona;
    private String nbPersona;
    private String apPersona;
    private String dirPersona;
    private int numCel_Persona;

    public Persona() {
    }

    public Persona(int codPersona, String nbPersona, String apPersona, String dirPersona, int numCel_Persona) {
        this.codPersona = codPersona;
        this.nbPersona = nbPersona;
        this.apPersona = apPersona;
        this.dirPersona = dirPersona;
        this.numCel_Persona = numCel_Persona;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public String getNbPersona() {
        return nbPersona;
    }

    public void setNbPersona(String nbPersona) {
        this.nbPersona = nbPersona;
    }

    public String getApPersona() {
        return apPersona;
    }

    public void setApPersona(String apPersona) {
        this.apPersona = apPersona;
    }

    public String getDirPersona() {
        return dirPersona;
    }

    public void setDirPersona(String dirPersona) {
        this.dirPersona = dirPersona;
    }

    public int getNumCel_Persona() {
        return numCel_Persona;
    }

    public void setNumCel_Persona(int numCel_Persona) {
        this.numCel_Persona = numCel_Persona;
    }

}
