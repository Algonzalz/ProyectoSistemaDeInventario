package sistemadeinventario.modelo;

import java.util.Date;

public class Factura {

    private int codFactura;
    private Date fechaFactura;
    private double subtotalFactura;
    private double ivaFactura;
    private double totalFactura;
    private String tipoFactura;

    private int codCliente_FK;
    private String codUsuario_FK;

    public Factura() {
    }

    public Factura(int codFactura, Date fechaFactura, double subtotalFactura, double ivaFactura, double totalFactura, String tipoFactura, int codCliente_FK, String codUsuario_FK) {
        this.codFactura = codFactura;
        this.fechaFactura = fechaFactura;
        this.subtotalFactura = subtotalFactura;
        this.ivaFactura = ivaFactura;
        this.totalFactura = totalFactura;
        this.tipoFactura = tipoFactura;
        this.codCliente_FK = codCliente_FK;
        this.codUsuario_FK = codUsuario_FK;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getSubtotalFactura() {
        return subtotalFactura;
    }
 
    public void setSubtotalFactura(double subtotalFactura) {
        this.subtotalFactura = subtotalFactura;
    }

    public double getIvaFactura() {
        return ivaFactura;
    }

    public void setIvaFactura(double ivaFactura) {
        this.ivaFactura = ivaFactura;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public int getCodCliente_FK() {
        return codCliente_FK;
    }

    public void setCodCliente_FK(int codCliente_FK) {
        this.codCliente_FK = codCliente_FK;
    }

    public String getCodUsuario_FK() {
        return codUsuario_FK;
    }

    public void setCodUsuario_FK(String codUsuario_FK) {
        this.codUsuario_FK = codUsuario_FK;
    }

}
