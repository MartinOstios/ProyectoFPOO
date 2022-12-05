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
public class Jugador extends Persona implements Serializable{
    private String nacionalidad;
    private String posicion;
    private int golesMarcados;
    private int salario;
    private Equipo miEquipo;
    private Manager miManager;

    public Jugador(String cedula, String nombre, String apellido, int edad, String nacionalidad, String posicion, int golesMarcados, int salario) {
        super(cedula, nombre, apellido, edad);
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.golesMarcados = golesMarcados;
        this.salario = salario;
    }
    
    @Override
    public String cuerpoCertificado() {
        return " y actúa en calidad de jugador del equipo " + this.equipoAsignado() + " ocupando la posición de " + this.getPosicion() + ".";
    }
    
    public String equipoAsignado() {
        if (this.getMiEquipo() != null) {
            return this.getMiEquipo().getNombre();
        } else {
            return "No asignado";
        }
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the posicion
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the golesMarcados
     */
    public int getGolesMarcados() {
        return golesMarcados;
    }

    /**
     * @param golesMarcados the golesMarcados to set
     */
    public void setGolesMarcados(int golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    /**
     * @return the salario
     */
    public int getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(int salario) {
        this.salario = salario;
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
     * @return the miManager
     */
    public Manager getMiManager() {
        return miManager;
    }

    /**
     * @param miManager the miManager to set
     */
    public void setMiManager(Manager miManager) {
        this.miManager = miManager;
    }

    
    
    
    
}
