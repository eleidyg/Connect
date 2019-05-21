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
public class IdFactura {
    private String idFactura;

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public String toString() {
        return "ValorFactura{" + "idFactura=" + idFactura + '}';
    }
    
    
}
