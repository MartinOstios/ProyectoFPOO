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
public class Aficionado extends Persona implements Serializable{
    private int aniosFidelidad;
    private boolean abono;
    private Equipo miEquipo;

    public Aficionado(String cedula, String nombre, String apellido, int edad, int aniosFidelidad, boolean abono) {
        super(cedula, nombre, apellido, edad);
        this.aniosFidelidad = aniosFidelidad;
        this.abono = abono;
    }
    
    @Override
    public String cuerpoCertificado() {
        return " y actúa en calidad de aficionado del equipo " + this.equipoAsignado() + " afirmando que lleva " + this.getAniosFidelidad() + " años acompañándolos en las buenas y las malas campañas";
    }
    
    public String equipoAsignado() {
        if (this.getMiEquipo() != null) {
            return this.getMiEquipo().getNombre();
        } else {
            return "No asignado";
        }
    }

    /**
     * @return the aniosFidelidad
     */
    public int getAniosFidelidad() {
        return aniosFidelidad;
    }

    /**
     * @param aniosFidelidad the aniosFidelidad to set
     */
    public void setAniosFidelidad(int aniosFidelidad) {
        this.aniosFidelidad = aniosFidelidad;
    }

    /**
     * @return the abono
     */
    public boolean isAbono() {
        return abono;
    }

    /**
     * @param abono the abono to set
     */
    public void setAbono(boolean abono) {
        this.abono = abono;
    }

    /**
     * @return the miEquipo
     */
    public Equipo getMiEquipo() {
        return miEquipo;
    }

    /**
     * @param miEquipo the miEquipo to set
     */
    public void setMiEquipo(Equipo miEquipo) {
        this.miEquipo = miEquipo;
    }

    
    
    
    
    
}
