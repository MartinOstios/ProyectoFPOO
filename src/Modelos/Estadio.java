package Modelos;

import java.util.LinkedList;

/**
 * Un estadio en el cual se juegan varios partidos.
 * @author Camilo Andrés Molano y Martin Ostios
 * @version 1.0
 */
public class Estadio {
    private String id;
    private String ciudad;
    private String nombre;
    private int capacidad;
    private LinkedList<Partido> misPartidos;
    private Equipo miEquipoLocal;
    private Equipo miEquipoVisitante;
    private Jornada miJornada;
    
    /**
     * Constructor de objetos Estadio, con valores dados por el usuario
     * @param id identificador del estadio
     * @param ciudad ciudad en la que se encuentra ubicado el estadio
     * @param nombre nomre del estadio
     * @param capacidad cantidad de personas que caben en el estadio
     */
    public Estadio(String id, String ciudad, String nombre, int capacidad) {
        this.id = id;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.misPartidos = new LinkedList<>();
    }
    //===MÉTODOS===
    
    /**
     * Revisa todos los partidos jugados en el estadio y suma todos
     * los goles hechos.
     * @return suma de todos los goles
     */
    public int totalGoles(){
        int resultado = 0;
        for(Partido actual: this.misPartidos){
            resultado+= actual.getGolesLocal()+ actual.getGolesVisitante();
        }
        return resultado;
    }
    
    /**
     * Busca el partido en el que se hicieron más goles
     * @return objeto de tipo Partido
     */
    public Partido partidoMasGoles(){
        Partido resultado = null;
        int mayor= Integer.MIN_VALUE;
        for(Partido actual: this.misPartidos){
            int aux= actual.getGolesLocal()+ actual.getGolesVisitante();
            if(aux>mayor){
                mayor=aux;
                resultado=actual;
            }
        }
        return resultado;
    }
    //=============
    
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
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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
    
    
    
    
}
