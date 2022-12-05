package Modelos;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Una liga nacional de futbol.
 *
 * @author Camilo Andrés Molano y Martin Ostios
 * @version 1.0
 */
public class Liga implements Serializable {

    private String id;
    private String pais;
    private LinkedList<Estadio> misEstadios;
    private LinkedList<Equipo> misEquipos;
    private LinkedList<Persona> misPersonas;
    private LinkedList<Partido> misPartidos;
    private LinkedList<Jornada> misJornadas;

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
        this.misPartidos = new LinkedList<>();
        this.misJornadas = new LinkedList<>();
    }

    //====BUSCAR OBJETOS=====
    public Persona buscarPersona(String cedula) {
        Persona resultado = null;
        for (Persona actual : this.getMisPersonas()) {
            if (actual.getCedula().equals(cedula)) {
                resultado = actual;
            }
        }
        return resultado;
    }

    public Estadio buscarEstadio(String id) {
        Estadio resultado = null;
        for (Estadio actual : this.getMisEstadios()) {
            if (actual.getId().equals(id)) {
                resultado = actual;
            }
        }
        return resultado;
    }

    public Equipo buscarEquipo(String id) {
        Equipo resultado = null;
        for (Equipo actual : this.getMisEquipos()) {
            if (actual.getId().equals(id)) {
                resultado = actual;
            }
        }
        return resultado;
    }
    
    public Equipo buscarEquipoNombre(String nombre) {
        Equipo resultado = null;
        for (Equipo actual : this.getMisEquipos()) {
            if (actual.getNombre().equals(nombre)) {
                resultado = actual;
            }
        }
        return resultado;
    }
    
    public Partido buscarPartido(String id) {
        Partido resultado = null;
        for (Partido actual : this.getMisPartidos()) {
            if (actual.getId().equals(id)) {
                resultado = actual;
            }
        }
        return resultado;
    }
    
    public Jornada buscarJornada(int numero) {
        Jornada resultado = null;
        for (Jornada actual : this.getMisJornadas()) {
            if (actual.getNumero()==numero) {
                resultado = actual;
            }
        }
        return resultado;
    }
    
    

    //=======================
    //===Relaciones===
    //Relación de composición entre Liga y Equipos
    public void crearEquipo(String id, String nombre, int anioFundacion, int numTitulosNacionales, int numTitulosInternacionales, int puntos, int golesContra, int golesFavor, int partidosJugados) {
        Equipo nuevoEquipo = new Equipo(id, nombre, anioFundacion, numTitulosNacionales, numTitulosInternacionales, puntos, golesContra, golesFavor, partidosJugados);
        this.getMisEquipos().add(nuevoEquipo);
    }
    
    public void eliminarEquipo(Equipo equipoEliminar){
        this.getMisEquipos().remove(equipoEliminar);
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
        int min = Integer.MAX_VALUE;
        for (Persona actual : this.getMisPersonas()) {
            if (actual instanceof Jugador) {
                if (actual.getEdad() < min) {
                    min = actual.getEdad();
                    resultado = (Jugador) actual;
                }
            }
        }
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
    public LinkedList<Equipo> organizarPorPuntos() {
        LinkedList<Equipo> resultado = new LinkedList<>();
        LinkedList<Equipo> aux = new LinkedList<>();
        //Pasa los datos de la lista de equipos a una lista auxiliar (Para no afectar la lista original)
        //No se utiliza
        //aux = this.getMisEquipos()
        //porque todo lo que se haga en el auxiliar, también afecta la lista orginal
        //Por eso se crea una lista nueva y se llena desde cero
        for (Equipo actual : this.getMisEquipos()) {
            aux.add(actual);
        }
        Equipo equipoMayor = null;
        int tam = aux.size();
        for (int i = 0; i < tam; i++) {
            int mayor = Integer.MIN_VALUE;
            //Busca el equipo con mayor puntos (En la lissta auxiliar)
            for (Equipo actual : aux) {
                if (actual.getPuntos() > mayor) {
                    mayor = actual.getPuntos();
                    equipoMayor = actual;
                }
            }
            //Lo agrega a la lista del Resultado
            resultado.add(equipoMayor);
            //Lo quita de la lista de equipos auxiliar
            aux.remove(equipoMayor);
        }

        return resultado;
    }

    public LinkedList<Equipo> tablaPosiciones() {
        //Obtiene la lista ordenada por puntos
        LinkedList<Equipo> resultado = this.organizarPorPuntos();
        Equipo aux = null;
        for (int i = 0; i < resultado.size() - 1; i++) {
            for (int j = i + 1; j <= resultado.size() - 1; j++) {
                if (resultado.get(i).getPuntos() == resultado.get(j).getPuntos()) {
                    int difGolesActual = resultado.get(i).getGolesFavor() - resultado.get(i).getGolesContra(); //(i)
                    int difGolesSiguiente = resultado.get(j).getGolesFavor() - resultado.get(j).getGolesContra(); //(j)
                    if (difGolesActual < difGolesSiguiente) {
                        aux = resultado.get(i);
                        resultado.set(i, resultado.get(j));
                        resultado.set(j, aux);
                    }
                }
            }
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
        int mayor = Integer.MIN_VALUE;
        for (Persona actual : this.getMisPersonas()) {
            if (actual instanceof Jugador) {
                if (((Jugador) actual).getGolesMarcados() > mayor) {
                    mayor = ((Jugador) actual).getGolesMarcados();
                    resultado = (Jugador) actual;
                }
            }
        }
        return resultado;
    }

    /**
     * Equipo con nómina de jugadores y técnico más alta.
     *
     * @return objeto de tipo Equipo
     */
    public Equipo equipoMayorNomina() {
        Equipo resultado = null;
        double mayor = Double.MIN_VALUE;
        for (Equipo actual : this.getMisEquipos()) {
            double nomina = actual.totalNomina();
            if (nomina > mayor) {
                mayor = nomina;
                resultado = actual;
            }
        }
        return resultado;
    }

    /**
     * Equipo con mayor cantidad de aficionados
     *
     * @return objeto de tipo Equipo
     */
    public Equipo equipoMayorAficionados() {
        Equipo resultado = null;
        int mayor = Integer.MIN_VALUE;
        for (Equipo actual : this.getMisEquipos()) {
            if (actual.getMisAficionados().size() > mayor) {
                mayor = actual.getMisAficionados().size();
                resultado = actual;
            }
        }
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
        Equipo menorGoles = null;
        int menor = Integer.MAX_VALUE;
        for (Equipo actual : this.getMisEquipos()) {
            if (actual.getGolesContra() < menor) {
                menor = actual.getGolesContra();
                menorGoles = actual;
            }

        }
        resultado = menorGoles.getArquero();
        return resultado;
    }

    /**
     * Nombre del estadio donde se marcaron más goles en toda la liga
     *
     * @return nombre del estadio
     */
    public String nombreEstadioMasGoles() {
        String resultado = "";
        int mayor = Integer.MIN_VALUE;
        for (Estadio actual : this.misEstadios) {
            int aux = actual.totalGoles();
            if (aux > mayor) {
                mayor = aux;
                resultado = actual.getNombre();
            }
        }
        return resultado;
    }

    /**
     * Identificador del partido el cual tuvo más goles
     *
     * @return id del partido
     */
    public String idPartidoMasGoles() {
        String resultado = "";
        for (Estadio actual : this.misEstadios) {
            Partido aux = actual.partidoMasGoles();
            resultado = aux.getId();
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
     * @return the misJornadas
     */
    public LinkedList<Jornada> getMisJornadas() {
        return misJornadas;
    }

    /**
     * @param misJornadas the misJornadas to set
     */
    public void setMisJornadas(LinkedList<Jornada> misJornadas) {
        this.misJornadas = misJornadas;
    }

}
