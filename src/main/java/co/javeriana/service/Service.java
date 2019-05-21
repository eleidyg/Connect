/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.javeriana.service;

import co.javeriana.model.Factura;
import co.javeriana.model.IdFactura;
import co.javeriana.model.Solicitud;
import java.io.BufferedInputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Cristian Castro
 */
@Path("/service")
public class Service {

    @POST
    @Path("/getValorFactura")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getValorFactura(Solicitud sol) {
        String output = null;
        try {
            URL url = new URL(sol.getUrl() + sol.getIdFactura());//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(sol.getMethod().toUpperCase());
            conn.setRequestProperty(sol.getNameProperty(), sol.getAtributteProperty());

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            output = br.readLine();
            System.out.println("OUTPUT: " + output);
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        System.out.println("Output: " + output);
        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/payFactura")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response payFactura(Solicitud s) {
        String output = null;
        try {

            URL url = new URL(s.getUrl() + s.getIdFactura());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(s.getMethod().toUpperCase());
            conn.setRequestProperty(s.getNameProperty(), s.getAtributteProperty());
           // conn.setRequestProperty("Content-Type", "application/json");
            OutputStream os = conn.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(s.getBody());
            osw.flush();
            osw.close();
            os.close();  //don't forget to close the OutputStream
            conn.connect();

//read the inputstream and print it
            String result;
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result2 = bis.read();
            while (result2 != -1) {
                buf.write((byte) result2);
                result2 = bis.read();
            }
            result = buf.toString();
            output = buf.toString();
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }

        System.out.println("Output: " + output);
        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/conciliateFactura")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response conciliateFactura(Solicitud s) {
        String output = null;
        try {

            URL url = new URL(s.getUrl() + s.getIdFactura());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(s.getMethod().toUpperCase());
            conn.setRequestProperty(s.getNameProperty(), s.getAtributteProperty());
           // conn.setRequestProperty("Content-Type", "application/json");
            OutputStream os = conn.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(s.getBody());
            osw.flush();
            osw.close();
            os.close();  //don't forget to close the OutputStream
            conn.connect();

//read the inputstream and print it
            String result;
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result2 = bis.read();
            while (result2 != -1) {
                buf.write((byte) result2);
                result2 = bis.read();
            }
            result = buf.toString();
            output = buf.toString();
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }

        System.out.println("Output: " + output);
        return Response.status(200).entity(output).build();
    }
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Factura testFactura() {
        Factura fac = new Factura();
        fac.setIdFactura("123456");
        fac.setValorFactura(123456);
        return fac;
    }

}
