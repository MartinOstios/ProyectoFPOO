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
        liga.crearEquipo("Once Caldas",     1945, 5, 1, 12, 11, 18, 5); // Dif 6 --
        liga.crearEquipo("Nacional",        1965, 8, 3, 15, 13, 18, 5); // Dif 5
        liga.crearEquipo("Santa Fé",        1998, 10, 0, 12, 9, 18, 5);// Dif 8
        liga.crearEquipo("Millonarios",     1923, 12, 2, 12, 13, 18, 5); //Dif 13 --
        liga.crearEquipo("Patriotas",       1945, 1, 0, 12, 10, 18, 5); //Dif -1
        liga.crearEquipo("América de Cali", 1948, 0, 5, 16, 8, 18, 5); //Dif 2 --
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
        
        
    }

}
