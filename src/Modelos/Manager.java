/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Manager extends Persona{
    private int aniosAfiliacion;
    private Equipo miEquipo;
    private LinkedList<Jugador> misJugadores;
        
    public Manager(String cedula, String nombre, String apellido, int edad, int aniosAfiliacion) {
        super(cedula, nombre, apellido, edad);
        this.aniosAfiliacion = aniosAfiliacion;
        this.misJugadores = new LinkedList<>();
    }

    /**
     * @return the aniosAfiliacion
     */
    public int getAniosAfiliacion() {
        return aniosAfiliacion;
    }

    /**
     * @param aniosAfiliacion the aniosAfiliacion to set
     */
    public void setAniosAfiliacion(int aniosAfiliacion) {
        this.aniosAfiliacion = aniosAfiliacion;
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

    /**
     * @return the misJugadores
     */
    public LinkedList<Jugador> getMisJugadores() {
        return misJugadores;
    }

    /**
     * @param misJugadores the misJugadores to set
     */
    public void setMisJugadores(LinkedList<Jugador> misJugadores) {
        this.misJugadores = misJugadores;
    }
    
    
    
    
    
    
}
