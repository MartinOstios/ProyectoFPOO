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
public class Partido {
    private String id;
    private String fecha;
    private int golesLocal;
    private int golesVisitante;
    private Arbitro miArbitro;
    
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
    
    
    
    
}
