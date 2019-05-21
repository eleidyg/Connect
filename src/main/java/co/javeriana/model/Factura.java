/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.javeriana.model;

/**
 *
 * @author Cristian Castro
 */
public class Factura {
    
    private String idFactura;
    private double valorFactura;

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + ", valorFactura=" + valorFactura + '}';
    }
    
    
}
