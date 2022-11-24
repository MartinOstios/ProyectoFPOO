/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.*;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //OBJETOS PARA TESTEO

        Liga liga = new Liga("01", "Colombia");
        liga.crearEquipo("Once Caldas",         1945, 5, 1, 12, 7, 18, 5);
        liga.crearEquipo("Nacional",            1965, 8, 3, 15, 13, 18, 5);
        liga.crearEquipo("Santa Fé",            1998, 10, 0, 12, 9, 18, 5);
        liga.crearEquipo("Millonarios",         1923, 12, 2, 12, 13, 18, 5);
        liga.crearEquipo("Patriotas",           1945, 1, 0, 12, 10, 18, 5);
        liga.crearEquipo("América de Cali",     1948, 0, 5, 16, 8, 18, 5);
        System.out.println("====================================");
        System.out.println("Tabla de posiciones organizada por puntos");
        for (Equipo actual : liga.organizarPorPuntos()) {
            System.out.println("Nombre: " + actual.getNombre() + " Puntos: " + actual.getPuntos() + " Diferencia goles: " + (actual.getGolesFavor() - actual.getGolesContra()));
        }

        System.out.println("====================================");
        System.out.println("Tabla de posiciones organizada por puntos y goles");
        for (Equipo actual : liga.tablaPosiciones()) {
            System.out.println("Nombre: " + actual.getNombre() + " Puntos: " + actual.getPuntos() + " Diferencia goles: " + (actual.getGolesFavor() - actual.getGolesContra()));
        }
        System.out.println("====================================");
        Jugador jugador1 = new Jugador("01", "Alfonso", "Perez", 35, "Colombia", "Defensa", 0, 4600000);
        Jugador jugador2 = new Jugador("02", "Jose", "Perez", 21, "Colombia", "Atacante", 0, 5200000);
        Jugador jugador3 = new Jugador("03", "Marco", "Perez", 20, "Colombia", "Arquero", 0, 3600000);
        Jugador jugador4 = new Jugador("04", "Pepito", "Perez", 32, "Colombia", "Defensa", 0, 2200000);
        Jugador jugador5 = new Jugador("05", "Paco", "Perez", 28, "Colombia", "Atacante", 0, 9400000);
        Jugador jugador6 = new Jugador("06", "Daniel", "Perez", 29, "Colombia", "Arquero", 0, 5900000);
        Jugador jugador7 = new Jugador("07", "Pedro", "Perez", 30, "Colombia", "Defensa", 0, 6800000);
        Jugador jugador8 = new Jugador("08", "Roberto", "Perez", 26, "Colombia", "Atacante", 0, 2100000);
        Jugador jugador9 = new Jugador("09", "Ricardo", "Perez", 27, "Colombia", "Arquero", 0, 6300000);
        Jugador jugador10 = new Jugador("10", "James", "Perez", 27, "Colombia", "Defensa", 0, 2100000);
        Jugador jugador11 = new Jugador("11", "Julian", "Perez", 39, "Colombia", "Atacante", 0, 9800000);
        Jugador jugador12 = new Jugador("12", "Felipe", "Perez", 29, "Colombia", "Arquero", 0, 3200000);
        Jugador jugador13 = new Jugador("13", "Carlos", "Perez", 24, "Colombia", "Defensa", 0, 4200000);
        Jugador jugador14 = new Jugador("14", "Jacobo", "Perez", 23, "Colombia", "Atacante", 0, 8700000);
        Jugador jugador15 = new Jugador("15", "Camilo", "Perez", 19, "Colombia", "Arquero", 0, 6300000);
        Jugador jugador16 = new Jugador("16", "Miguel", "Perez", 20, "Colombia", "Defensa", 0, 5200000);
        Jugador jugador17 = new Jugador("17", "Mario", "Perez", 18, "Colombia", "Atacante", 0, 2400000);
        Jugador jugador18 = new Jugador("18", "Joel", "Perez", 21, "Colombia", "Arquero", 0, 6300000);
        
        liga.getMisPersonas().add(jugador1);
        liga.getMisPersonas().add(jugador2);
        liga.getMisPersonas().add(jugador3);
        liga.getMisPersonas().add(jugador4);
        liga.getMisPersonas().add(jugador5);
        liga.getMisPersonas().add(jugador6);
        liga.getMisPersonas().add(jugador7);
        liga.getMisPersonas().add(jugador8);
        liga.getMisPersonas().add(jugador9);
        liga.getMisPersonas().add(jugador10);
        liga.getMisPersonas().add(jugador11);
        liga.getMisPersonas().add(jugador12);
        liga.getMisPersonas().add(jugador13);
        liga.getMisPersonas().add(jugador14);
        liga.getMisPersonas().add(jugador15);
        liga.getMisPersonas().add(jugador16);
        liga.getMisPersonas().add(jugador17);
        liga.getMisPersonas().add(jugador18);

        liga.getMisEquipos().get(0).agregarJugador(jugador1);
        liga.getMisEquipos().get(0).agregarJugador(jugador2);
        liga.getMisEquipos().get(0).agregarJugador(jugador3);
        liga.getMisEquipos().get(1).agregarJugador(jugador4);
        liga.getMisEquipos().get(1).agregarJugador(jugador5);
        liga.getMisEquipos().get(1).agregarJugador(jugador6);
        liga.getMisEquipos().get(2).agregarJugador(jugador7);
        liga.getMisEquipos().get(2).agregarJugador(jugador8);
        liga.getMisEquipos().get(2).agregarJugador(jugador9);
        liga.getMisEquipos().get(3).agregarJugador(jugador10);
        liga.getMisEquipos().get(3).agregarJugador(jugador11);
        liga.getMisEquipos().get(3).agregarJugador(jugador12);
        liga.getMisEquipos().get(4).agregarJugador(jugador13);
        liga.getMisEquipos().get(4).agregarJugador(jugador14);
        liga.getMisEquipos().get(4).agregarJugador(jugador15);
        liga.getMisEquipos().get(5).agregarJugador(jugador16);
        liga.getMisEquipos().get(5).agregarJugador(jugador17);
        liga.getMisEquipos().get(5).agregarJugador(jugador18);

        Tecnico tecnico1 = new Tecnico("101", "Guillermo", "Arias", 56, 15, 96000000);
        Tecnico tecnico2 = new Tecnico("102", "Jorge", "Arias", 62, 10, 45000000);
        Tecnico tecnico3 = new Tecnico("103", "Ruben", "Arias", 46, 11, 32000000);
        Tecnico tecnico4 = new Tecnico("104", "Randy", "Arias", 40, 2, 11000000);
        Tecnico tecnico5 = new Tecnico("105", "Rogelio", "Arias", 55, 20, 15000000);
        Tecnico tecnico6 = new Tecnico("106", "Marcelo", "Arias", 59, 8, 32000000);

        liga.getMisEquipos().get(0).agregarTecnico(tecnico1);
        liga.getMisEquipos().get(1).agregarTecnico(tecnico2);
        liga.getMisEquipos().get(2).agregarTecnico(tecnico3);
        liga.getMisEquipos().get(3).agregarTecnico(tecnico4);
        liga.getMisEquipos().get(4).agregarTecnico(tecnico5);
        liga.getMisEquipos().get(5).agregarTecnico(tecnico6);
        
        Aficionado aficionado1 = new Aficionado("1001", "Jose", "Castro", 26, 10, true);
        liga.getMisEquipos().get(3).getMisAficionados().add(aficionado1);
        
        System.out.println("b. Promedio de edad por cada uno de los equipos (Sólo jugadores)");
        System.out.println("Equipo 1: " + liga.getMisEquipos().get(0).promEdad());
        System.out.println("Equipo 2: " + liga.getMisEquipos().get(1).promEdad());
        System.out.println("Equipo 3: " + liga.getMisEquipos().get(2).promEdad());
        System.out.println("Equipo 4: " + liga.getMisEquipos().get(3).promEdad());
        System.out.println("Equipo 5: " + liga.getMisEquipos().get(4).promEdad());
        System.out.println("Equipo 6: " + liga.getMisEquipos().get(5).promEdad());

        System.out.println("f. Equipo con nómina de jugadores y técnico más alta.");
        System.out.println(liga.equipoMayorNomina().getNombre());

        System.out.println("g. Equipo con mayor cantidad de aficionados");
        System.out.println(liga.equipoMayorAficionados().getNombre());
        System.out.println("i. Arquero que le han marcado menos goles");
        System.out.println("Nombre: "+liga.arqueroMenosGoles().getNombre());
        
        System.out.println("a. Jugador mas joven de la liga: ");
        System.out.println(liga.jugadorMasJoven().getNombre());
        
        System.out.println("c. Cantidad de partidos en el que un equipo gano por goleada: ");
        System.out.println(liga.getMisEquipos().get(3).cantPartidosGoleada());
        
        System.out.println("e. Jugador que ha marcado mas goles en la liga: ");
        System.out.println(liga.jugadorMayorGoles().getNombre());
        
        
        
        
    }

}
