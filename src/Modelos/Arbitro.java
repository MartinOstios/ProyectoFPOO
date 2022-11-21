/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Usuario
 */
public class Arbitro extends Persona{
    private boolean fifa;

    public Arbitro(String cedula, String nombre, String apellido, int edad, boolean fifa) {
        super(cedula, nombre, apellido, edad);
        this.fifa = fifa;
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
    
    
    
    
}
