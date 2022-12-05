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
public class Partido implements Serializable{
    private String id;
    private String fecha;
    private int golesLocal;
    private int golesVisitante;
    private Arbitro miArbitro;
    private Equipo miEquipoLocal;
    private Equipo miEquipoVisitante;
    private Jornada miJornada;
    private Estadio miEstadio;
    
    public Partido(String id, String fecha, int golesLocal, int golesVisitante) {
        this.id = id;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the golesLocal
     */
    public int getGolesLocal() {
        return golesLocal;
    }

    /**
     * @param golesLocal the golesLocal to set
     */
    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    /**
     * @return the golesVisitante
     */
    public int getGolesVisitante() {
        return golesVisitante;
    }

    /**
     * @param golesVisitante the golesVisitante to set
     */
    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    /**
     * @return the miArbitro
     */
    public Arbitro getMiArbitro() {
        return miArbitro;
    }

    /**
     * @param miArbitro the miArbitro to set
     */
    public void setMiArbitro(Arbitro miArbitro) {
        this.miArbitro = miArbitro;
    }

    /**
     * @return the miEquipoLocal
     */
    public Equipo getMiEquipoLocal() {
        return miEquipoLocal;
    }

    /**
     * @param miEquipoLocal the miEquipoLocal to set
     */
    public void setMiEquipoLocal(Equipo miEquipoLocal) {
        this.miEquipoLocal = miEquipoLocal;
    }

    /**
     * @return the miEquipoVisitante
     */
    public Equipo getMiEquipoVisitante() {
        return miEquipoVisitante;
    }

    /**
     * @param miEquipoVisitante the miEquipoVisitante to set
     */
    public void setMiEquipoVisitante(Equipo miEquipoVisitante) {
        this.miEquipoVisitante = miEquipoVisitante;
    }

    /**
     * @return the miJornada
     */
    public Jornada getMiJornada() {
        return miJornada;
    }

    /**
     * @param miJornada the miJornada to set
     */
    public void setMiJornada(Jornada miJornada) {
        this.miJornada = miJornada;
    }

    /**
     * @return the miEstadio
     */
    public Estadio getMiEstadio() {
        return miEstadio;
    }

    /**
     * @param miEstadio the miEstadio to set
     */
    public void setMiEstadio(Estadio miEstadio) {
        this.miEstadio = miEstadio;
    }
}
