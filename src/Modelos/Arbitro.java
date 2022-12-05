/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Arbitro extends Persona implements Serializable{
    private boolean fifa;
    private Partido miPartido;

    public Arbitro(String cedula, String nombre, String apellido, int edad, boolean fifa) {
        super(cedula, nombre, apellido, edad);
        this.fifa = fifa;
    }
    
    @Override
    public String cuerpoCertificado() {
        return " y actúa en calidad de árbitro.";
    }
    
    /**
     * @return the fifa
     */
    public boolean isFifa() {
        return fifa;
    }

    /**
     * @param fifa the fifa to set
     */
    public void setFifa(boolean fifa) {
        this.fifa = fifa;
    }

    /**
     * @return the miPartido
     */
    public Partido getMiPartido() {
        return miPartido;
    }

    /**
     * @param miPartido the miPartido to set
     */
    public void setMiPartido(Partido miPartido) {
        this.miPartido = miPartido;
    }
    
    
    
}
