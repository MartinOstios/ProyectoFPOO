/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public abstract class Persona implements Serializable {

    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String cedula, String nombre, String apellido, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    //===========CERTIFICADOS============
    public String encabezadoCertificado() {
        Calendar calendario = Calendar.getInstance();
        String dia = "" + calendario.get(Calendar.DATE);
        int mesNumero = calendario.get(Calendar.MONTH);
        String mes = this.obtenerMes(mesNumero);
        String anio = "" + calendario.get(Calendar.YEAR);
        String encabezado = "Colombia, " + dia + " de " + mes + " de " + anio;
        String introduccion = "\n\n\n\nLa Liga Nacional de Futbol certifica a quien le interese que ";
        String cuerpo = "la persona " + this.getNombre() + " " + this.getApellido() + " identificado/a con la cédula " + this.getCedula() + " se encuentra afiliado a la Liga Nacional de Fútbol";
        String contenido = encabezado + introduccion + cuerpo;
        return contenido;
    }

    public abstract String cuerpoCertificado();

    public String finalCertificado() {
        Calendar calendario = Calendar.getInstance();
        String dia = "" + calendario.get(Calendar.DATE);
        int mesNumero = calendario.get(Calendar.MONTH);
        String mes = this.obtenerMes(mesNumero);
        String anio = "" + calendario.get(Calendar.YEAR);
        String resultado = "\n\nDado en Colombia a los " + dia + " días del mes de " + mes + " de " + anio + "\n\nPresidencia de la confederación";
        return resultado;
    }

    public String obtenerMes(int numMes) {
        String resultado = "";
        switch (numMes) {
            case 0:
                resultado = "enero";
                break;
            case 1:
                resultado = "febrero";
                break;
            case 2:
                resultado = "marzo";
                break;
            case 3:
                resultado = "abril";
                break;
            case 4:
                resultado = "mayo";
                break;
            case 5:
                resultado = "junio";
                break;
            case 6:
                resultado = "julio";
                break;
            case 7:
                resultado = "agosto";
                break;
            case 8:
                resultado = "septiembre";
                break;
            case 9:
                resultado = "octubre";
                break;
            case 10:
                resultado = "noviembre";
                break;
            case 11:
                resultado = "diciembre";
                break;
            default:
                resultado = "";
        }
        return resultado;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

}
