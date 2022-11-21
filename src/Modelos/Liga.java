package Modelos;

import java.util.LinkedList;

/**
 * Una liga nacional de futbol.
 *
 * @author Camilo Andrés Molano y Martin Ostios
 * @version 1.0
 */
public class Liga {

    private String id;
    private String pais;
    private LinkedList<Estadio> misEstadios;
    private LinkedList<Equipo> misEquipos;
    private LinkedList<Persona> misPersonas;

    /**
     * Constructor de objetos Liga, con valores dados por el usuario
     *
     * @param id identificador de la liga
     * @param pais pais en donde se disputa la liga
     */
    public Liga(String id, String pais) {
        this.id = id;
        this.pais = pais;
        this.misEstadios = new LinkedList<>();
        this.misEquipos = new LinkedList<>();
        this.misPersonas = new LinkedList<>();
    }

    //===Relaciones===
    //Relación de composición entre Liga y Equipos
    public void crearEquipo(String nombre, int anioFundacion, int numTitulosNacionales, int numTitulosInternacionales, int puntos, int golesContra, int golesFavor, int partidosJugados) {
        Equipo nuevoEquipo = new Equipo(nombre, anioFundacion, numTitulosNacionales, numTitulosInternacionales, puntos, golesContra, golesFavor, partidosJugados);
        this.getMisEquipos().add(nuevoEquipo);
    }

    //================
    //===Metodos===
    /**
     * Jugador mas joven de la liga
     *
     * @return objeto de tipo Jugador
     */
    public Jugador jugadorMasJoven() {
        Jugador resultado = null;

        return resultado;
    }

    /**
     * Tabla de posiciones de la liga, ordenar los equipos de mayor a menor
     * teniendo en cuenta la cantidad de puntos, en caso que existan equipos con
     * la misma cantidad de puntos el factor de desempate corresponde a la
     * diferencia de goles (goles a favor – goles en contra)
     *
     * @return lista con la tabla de posiciones
     */
    public LinkedList<Equipo> tablaPosiciones() {
        LinkedList<Equipo> resultado = new LinkedList<>();
        Equipo equipoMayor = null;
        int tam = this.getMisEquipos().size();
        for (int i = 0; i < tam; i++) {
            int mayor = Integer.MIN_VALUE;
            for (Equipo actual : this.getMisEquipos()) {
                if (actual.getPuntos() > mayor) {
                    mayor = actual.getPuntos();
                    equipoMayor = actual;
                }
            }
            resultado.add(equipoMayor);
            this.getMisEquipos().remove(equipoMayor);
        }
        return resultado;
    }

    /**
     * Jugador que ha marcado más goles en la liga.
     *
     * @return objeto tipo Jugador
     */
    public Jugador jugadorMayorGoles() {
        Jugador resultado = null;

        return resultado;
    }

    /**
     * Equipo con nómina de jugadores y técnico más alta.
     *
     * @return objeto de tipo Equipo
     */
    public Equipo equipoMayorNomina() {
        Equipo resultado = null;

        return resultado;
    }

    /**
     * Equipo con mayor cantidad de aficionados
     *
     * @return objeto de tipo Equipo
     */
    public Equipo equipoMayorAficionados() {
        Equipo resultado = null;

        return resultado;
    }

    /**
     * Arquero que le han marcado menos goles, esta información se puede obtener
     * de los goles en contra.
     *
     * @return objeto de tipo Jugador
     */
    public Jugador arqueroMenosGoles() {
        Jugador resultado = null;

        return resultado;
    }

    /**
     * Nombre del estadio donde se marcaron más goles en toda la liga
     *
     * @return nombre del estadio
     */
    public String nombreEstadioMasGoles() {
        String resultado = "";

        return resultado;
    }

    /**
     * Identificador del partido el cual tuvo más goles
     *
     * @return id del partido
     */
    public String idPartidoMasGoles() {
        String resultado = "";

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
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the misEstadios
     */
    public LinkedList<Estadio> getMisEstadios() {
        return misEstadios;
    }

    /**
     * @param misEstadios the misEstadios to set
     */
    public void setMisEstadios(LinkedList<Estadio> misEstadios) {
        this.misEstadios = misEstadios;
    }

    /**
     * @return the misEquipos
     */
    public LinkedList<Equipo> getMisEquipos() {
        return misEquipos;
    }

    /**
     * @param misEquipos the misEquipos to set
     */
    public void setMisEquipos(LinkedList<Equipo> misEquipos) {
        this.misEquipos = misEquipos;
    }

    /**
     * @return the misPersonas
     */
    public LinkedList<Persona> getMisPersonas() {
        return misPersonas;
    }

    /**
     * @param misPersonas the misPersonas to set
     */
    public void setMisPersonas(LinkedList<Persona> misPersonas) {
        this.misPersonas = misPersonas;
    }

}
