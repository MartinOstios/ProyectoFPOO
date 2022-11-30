/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Jornada implements Serializable{
    private int numero;
    private String eslogan;
    private LinkedList<Partido> misPartidos;

    public Jornada(int numero, String eslogan) {
        this.numero = numero;
        this.eslogan = eslogan;
        this.misPartidos = new LinkedList<>();
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the eslogan
     */
    public String getEslogan() {
        return eslogan;
    }

    /**
     * @param eslogan the eslogan to set
     */
    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }

    /**
     * @return the misPartidos
     */
    public LinkedList<Partido> getMisPartidos() {
        return misPartidos;
    }

    /**
     * @param misPartidos the misPartidos to set
     */
    public void setMisPartidos(LinkedList<Partido> misPartidos) {
        this.misPartidos = misPartidos;
    }
    
    
}
