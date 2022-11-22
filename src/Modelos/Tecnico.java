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
public class Tecnico extends Persona{
    private int aniosExperiencia;
    private int salario;

    public Tecnico(String cedula, String nombre, String apellido, int edad, int aniosExperiencia, int salario) {
        super(cedula, nombre, apellido, edad);
        this.aniosExperiencia = aniosExperiencia;
        this.salario = salario;
    }

    /**
     * @return the aniosExperiencia
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * @param aniosExperiencia the aniosExperiencia to set
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
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