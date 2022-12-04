package Modelos;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Un equipo de fútbol.
 * @author Camilo Andrés Molano y Martin Ostios
 * @version 1.0
 */
public class Equipo implements Serializable{
    private String id;
    private String nombre;
    private int anioFundacion;
    private int numTitulosNacionales;
    private int numTitulosInternacionales;
    private int puntos;
    private int golesContra;
    private int golesFavor;
    private int partidosJugados;
    private LinkedList<Partido> misPartidos;
    private LinkedList<Aficionado> misAficionados;
    private LinkedList<Jugador> misJugadores;
    private Tecnico tecnico;
    
    /**
     * Constructor de objetos Equipo, con valores dados por el usuario
     * @param nombre nombre del equipo
     * @param anioFundacion año de fundación del equipo
     * @param numTitulosNacionales número de títulos nacionales obtenidos por el equipo
     * @param numTitulosInternacionales número de títulos internacionales obtenidos por el equipo
     * @param puntos cantidad de puntos del equipo
     * @param golesContra goles en contra hechos en la liga
     * @param golesFavor goles a favor hechos en la liga
     * @param partidosJugados  partidos jugados en la liga
     */
    public Equipo(String id, String nombre, int anioFundacion, int numTitulosNacionales, int numTitulosInternacionales, int puntos, int golesContra, int golesFavor, int partidosJugados) {
        this.id = id;
        this.nombre = nombre;
        this.anioFundacion = anioFundacion;
        this.numTitulosNacionales = numTitulosNacionales;
        this.numTitulosInternacionales = numTitulosInternacionales;
        this.puntos = puntos;
        this.golesContra = golesContra;
        this.golesFavor = golesFavor;
        this.partidosJugados = partidosJugados;
        this.misPartidos = new LinkedList<>();
        this.misAficionados = new LinkedList<>();
        this.misJugadores = new LinkedList<>();
    }

    
    
    
    //===Relaciones===
    //Agregación entre Equipo y Técnico
    public void agregarTecnico(Tecnico tecnico){
        this.setTecnico(tecnico);
    }
    
    //Agregación entre Equipo y Jugadores
    public void agregarJugador(Jugador jugador){
        this.getMisJugadores().add(jugador);
    }
    //================
    
    //===Métodos===
    
    /**
     * Revisa en la lista de jugadores cuál es el que tiene menos edad
     * @return objeto tipo Jugador
     */
    public Jugador jugadorMasJoven(){
        Jugador resultado = null;
        int menor = Integer.MAX_VALUE;
        for (Jugador actual : this.misJugadores) {
            if(actual.getEdad()<menor){
                menor = actual.getEdad();
                resultado = actual;
            }
        }
        return resultado;
    }
    
    /**
     * Calcula el promedio de edad de las personas que hacen parte del equipo. (¿?)
     * @return promedio de edad
     */
    public double promEdad(){
        double resultado = 0.0;
        double cont = 0;
        double suma = 0;
        for (Jugador actual : this.getMisJugadores()) {
            suma += actual.getEdad();
            cont++;
        }
        resultado = suma / cont;
        return resultado;
    }
    
    /**
     * Revisa en los partidos jugados, en cuáles se anotó más de 4 goles que el oponente.
     * @return suma de los partidos
     */
    public int cantPartidosGoleada(){
        int resultado = 0;
        int golesloc= 0;
        int golesvis= 0;
        for(Partido actual:this.getMisPartidos()){
            golesloc=actual.getGolesLocal();
            golesvis=actual.getGolesVisitante();
            if(golesloc-golesvis>=4){
                resultado+=1;
            }
        }
        return resultado;
    }
    
    /**
     * Busca el jugador con mayor cantidad de goles anotados en el equipo
     * @return objeto tipo Jugador
     */
    public Jugador jugadorMayorGoles(){
        Jugador resultado = null;
        int mayor = Integer.MIN_VALUE;
        for (Jugador actual : this.getMisJugadores()) {
            if(actual.getGolesMarcados()>mayor){
                mayor = actual.getGolesMarcados();
                resultado = actual;
            }
        }
        return resultado;
    }
    
    /**
     * Revisa cuál es el salario del técnico y de los jugadores
     * @return suma del salario
     */
    public int totalNomina(){
        int resultado = 0;
        for (Jugador actual : this.getMisJugadores()) {
            resultado += actual.getSalario();
        }
        return resultado + this.getTecnico().getSalario();
    }
    
    public Jugador getArquero(){
        Jugador resultado = new Jugador("-1", "-1", "-1", -1, "-1", "-1", -1, -1);
        for (Jugador actual : this.getMisJugadores()) {
            if(actual.getPosicion().equals("Arquero")){
                resultado = actual;
            }
        }
        return resultado;
    }
    
    //=============

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
     * @return the anioFundacion
     */
    public int getAnioFundacion() {
        return anioFundacion;
    }

    /**
     * @param anioFundacion the anioFundacion to set
     */
    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    /**
     * @return the numTitulosNacionales
     */
    public int getNumTitulosNacionales() {
        return numTitulosNacionales;
    }

    /**
     * @param numTitulosNacionales the numTitulosNacionales to set
     */
    public void setNumTitulosNacionales(int numTitulosNacionales) {
        this.numTitulosNacionales = numTitulosNacionales;
    }

    /**
     * @return the golesContra
     */
    public int getGolesContra() {
        return golesContra;
    }

    /**
     * @param golesContra the golesContra to set
     */
    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    /**
     * @return the partidosJugados
     */
    public int getPartidosJugados() {
        return partidosJugados;
    }

    /**
     * @param partidosJugados the partidosJugados to set
     */
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
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
     * @return the misAficionados
     */
    public LinkedList<Aficionado> getMisAficionados() {
        return misAficionados;
    }

    /**
     * @param misAficionados the misAficionados to set
     */
    public void setMisAficionados(LinkedList<Aficionado> misAficionados) {
        this.misAficionados = misAficionados;
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

    /**
     * @return the tecnico
     */
    public Tecnico getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * @return the numTitulosInternacionales
     */
    public int getNumTitulosInternacionales() {
        return numTitulosInternacionales;
    }

    /**
     * @param numTitulosInternacionales the numTitulosInternacionales to set
     */
    public void setNumTitulosInternacionales(int numTitulosInternacionales) {
        this.numTitulosInternacionales = numTitulosInternacionales;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the golesFavor
     */
    public int getGolesFavor() {
        return golesFavor;
    }

    /**
     * @param golesFavor the golesFavor to set
     */
    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
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
}
