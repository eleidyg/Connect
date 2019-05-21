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
public class Solicitud {
    private String url;
    private String idFactura;
    private String method;
    private String nameProperty;
    private String atributteProperty;
    private String body;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNameProperty() {
        return nameProperty;
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty = nameProperty;
    }

    public String getAtributteProperty() {
        return atributteProperty;
    }

    public void setAtributteProperty(String atributteProperty) {
        this.atributteProperty = atributteProperty;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "url=" + url + ", idFactura=" + idFactura + ", method=" + method + ", nameProperty=" + nameProperty + ", atributteProperty=" + atributteProperty + ", body=" + body + '}';
    }

}
