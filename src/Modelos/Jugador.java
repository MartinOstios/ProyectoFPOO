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
public class Jugador extends Persona{
    private String nacionalidad;
    private String posicion;
    private int golesMarcados;
    private int salario;

    public Jugador(String cedula, String nombre, String apellido, int edad, String nacionalidad, String posicion, int golesMarcados, int salario) {
        super(cedula, nombre, apellido, edad);
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.golesMarcados = golesMarcados;
        this.salario = salario;
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
    
    
    
}
