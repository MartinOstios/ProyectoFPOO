/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaControladores;

import Modelos.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Vista extends javax.swing.JFrame {

    Liga miLiga;

    public Vista() {
        //this.miLiga = new Liga("01", "Colombia");
        this.cargarSesion();
        initComponents();
        setLocationRelativeTo(null);

        //Archivos binarios - Acción cuando se cierra la ventana -> Ejecutar método 'eventoCierre()'
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                eventoCierre();
            }
        });
        //Inicializar tablas

        this.actualizarTablaTecnicos();
        this.actualizarTablaAficionado();
        this.actualizarTablaEquipo();
        this.actualizarTablaJugador();
        this.tablaPosiciones();

        //TESTEO
        //OBJETOS PARA TESTEO
//        miLiga.crearEquipo("1" ,"Once Caldas", 1945, 5, 1, 12, 7, 18, 5);
//        miLiga.crearEquipo("2" ,"Nacional", 1965, 8, 3, 15, 13, 18, 5);
//        miLiga.crearEquipo("3" ,"Santa Fé", 1998, 10, 0, 12, 9, 18, 5);
//        miLiga.crearEquipo("4" ,"Millonarios", 1923, 12, 2, 12, 13, 18, 5);
//        miLiga.crearEquipo("5" ,"Patriotas", 1945, 1, 0, 12, 10, 18, 5);
//        miLiga.crearEquipo("6" ,"América de Cali", 1948, 0, 5, 16, 8, 18, 5);
//        System.out.println("====================================");
//        System.out.println("Tabla de posiciones organizada por puntos");
//        for (Equipo actual : miLiga.organizarPorPuntos()) {
//            System.out.println("Nombre: " + actual.getNombre() + " Puntos: " + actual.getPuntos() + " Diferencia goles: " + (actual.getGolesFavor() - actual.getGolesContra()));
//        }
//
//        System.out.println("====================================");
//        System.out.println("Tabla de posiciones organizada por puntos y goles");
//        for (Equipo actual : miLiga.tablaPosiciones()) {
//            System.out.println("Nombre: " + actual.getNombre() + " Puntos: " + actual.getPuntos() + " Diferencia goles: " + (actual.getGolesFavor() - actual.getGolesContra()));
//        }
//        System.out.println("====================================");
//        Jugador jugador1 = new Jugador("01", "Alfonso", "Perez", 35, "Colombia", "Defensa", 0, 4600000);
//        Jugador jugador2 = new Jugador("02", "Jose", "Perez", 21, "Colombia", "Atacante", 0, 5200000);
//        Jugador jugador3 = new Jugador("03", "Marco", "Perez", 20, "Colombia", "Arquero", 0, 3600000);
//        Jugador jugador4 = new Jugador("04", "Pepito", "Perez", 32, "Colombia", "Defensa", 0, 2200000);
//        Jugador jugador5 = new Jugador("05", "Paco", "Perez", 28, "Colombia", "Atacante", 0, 9400000);
//        Jugador jugador6 = new Jugador("06", "Daniel", "Perez", 29, "Colombia", "Arquero", 0, 5900000);
//        Jugador jugador7 = new Jugador("07", "Pedro", "Perez", 30, "Colombia", "Defensa", 0, 6800000);
//        Jugador jugador8 = new Jugador("08", "Roberto", "Perez", 26, "Colombia", "Atacante", 0, 2100000);
//        Jugador jugador9 = new Jugador("09", "Ricardo", "Perez", 27, "Colombia", "Arquero", 0, 6300000);
//        Jugador jugador10 = new Jugador("10", "James", "Perez", 27, "Colombia", "Defensa", 0, 2100000);
//        Jugador jugador11 = new Jugador("11", "Julian", "Perez", 39, "Colombia", "Atacante", 0, 9800000);
//        Jugador jugador12 = new Jugador("12", "Felipe", "Perez", 29, "Colombia", "Arquero", 0, 3200000);
//        Jugador jugador13 = new Jugador("13", "Carlos", "Perez", 24, "Colombia", "Defensa", 0, 4200000);
//        Jugador jugador14 = new Jugador("14", "Jacobo", "Perez", 23, "Colombia", "Atacante", 0, 8700000);
//        Jugador jugador15 = new Jugador("15", "Camilo", "Perez", 19, "Colombia", "Arquero", 0, 6300000);
//        Jugador jugador16 = new Jugador("16", "Miguel", "Perez", 20, "Colombia", "Defensa", 0, 5200000);
//        Jugador jugador17 = new Jugador("17", "Mario", "Perez", 18, "Colombia", "Atacante", 0, 2400000);
//        Jugador jugador18 = new Jugador("18", "Joel", "Perez", 21, "Colombia", "Arquero", 0, 6300000);
//
//        miLiga.getMisPersonas().add(jugador1);
//        miLiga.getMisPersonas().add(jugador2);
//        miLiga.getMisPersonas().add(jugador3);
//        miLiga.getMisPersonas().add(jugador4);
//        miLiga.getMisPersonas().add(jugador5);
//        miLiga.getMisPersonas().add(jugador6);
//        miLiga.getMisPersonas().add(jugador7);
//        miLiga.getMisPersonas().add(jugador8);
//        miLiga.getMisPersonas().add(jugador9);
//        miLiga.getMisPersonas().add(jugador10);
//        miLiga.getMisPersonas().add(jugador11);
//        miLiga.getMisPersonas().add(jugador12);
//        miLiga.getMisPersonas().add(jugador13);
//        miLiga.getMisPersonas().add(jugador14);
//        miLiga.getMisPersonas().add(jugador15);
//        miLiga.getMisPersonas().add(jugador16);
//        miLiga.getMisPersonas().add(jugador17);
//        miLiga.getMisPersonas().add(jugador18);
//
//        miLiga.getMisEquipos().get(0).agregarJugador(jugador1);
//        miLiga.getMisEquipos().get(0).agregarJugador(jugador2);
//        miLiga.getMisEquipos().get(0).agregarJugador(jugador3);
//        miLiga.getMisEquipos().get(1).agregarJugador(jugador4);
//        miLiga.getMisEquipos().get(1).agregarJugador(jugador5);
//        miLiga.getMisEquipos().get(1).agregarJugador(jugador6);
//        miLiga.getMisEquipos().get(2).agregarJugador(jugador7);
//        miLiga.getMisEquipos().get(2).agregarJugador(jugador8);
//        miLiga.getMisEquipos().get(2).agregarJugador(jugador9);
//        miLiga.getMisEquipos().get(3).agregarJugador(jugador10);
//        miLiga.getMisEquipos().get(3).agregarJugador(jugador11);
//        miLiga.getMisEquipos().get(3).agregarJugador(jugador12);
//        miLiga.getMisEquipos().get(4).agregarJugador(jugador13);
//        miLiga.getMisEquipos().get(4).agregarJugador(jugador14);
//        miLiga.getMisEquipos().get(4).agregarJugador(jugador15);
//        miLiga.getMisEquipos().get(5).agregarJugador(jugador16);
//        miLiga.getMisEquipos().get(5).agregarJugador(jugador17);
//        miLiga.getMisEquipos().get(5).agregarJugador(jugador18);
//
//        Tecnico tecnico1 = new Tecnico("101", "Guillermo", "Arias", 56, 15, 96000000);
//        Tecnico tecnico2 = new Tecnico("102", "Jorge", "Arias", 62, 10, 45000000);
//        Tecnico tecnico3 = new Tecnico("103", "Ruben", "Arias", 46, 11, 32000000);
//        Tecnico tecnico4 = new Tecnico("104", "Randy", "Arias", 40, 2, 11000000);
//        Tecnico tecnico5 = new Tecnico("105", "Rogelio", "Arias", 55, 20, 15000000);
//        Tecnico tecnico6 = new Tecnico("106", "Marcelo", "Arias", 59, 8, 32000000);
//
//        miLiga.getMisPersonas().add(tecnico1);
//        miLiga.getMisPersonas().add(tecnico2);
//        miLiga.getMisPersonas().add(tecnico3);
//        miLiga.getMisPersonas().add(tecnico4);
//        miLiga.getMisPersonas().add(tecnico5);
//        miLiga.getMisPersonas().add(tecnico6);
//
//        miLiga.getMisEquipos().get(0).agregarTecnico(tecnico1);
//        miLiga.getMisEquipos().get(1).agregarTecnico(tecnico2);
//        miLiga.getMisEquipos().get(2).agregarTecnico(tecnico3);
//        miLiga.getMisEquipos().get(3).agregarTecnico(tecnico4);
//        miLiga.getMisEquipos().get(4).agregarTecnico(tecnico5);
//        miLiga.getMisEquipos().get(5).agregarTecnico(tecnico6);
//
//        Aficionado aficionado1 = new Aficionado("1001", "Jose", "Castro", 26, 10, true);
//        Aficionado aficionado2 = new Aficionado("1002", "Marco", "Antonio", 28, 5, false);
//        Aficionado aficionado3 = new Aficionado("1003", "Daniel", "Arroyave", 15, 13, true);
//        Aficionado aficionado4 = new Aficionado("1004", "Aurelio", "Gonzales", 18, 2, false);
//        Aficionado aficionado5 = new Aficionado("1005", "Fidel", "Guerrero", 20, 5, true);
//        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado1);
//        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado2);
//        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado3);
//        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado4);
//        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado5);
//
//        miLiga.getMisPersonas().add(aficionado1);
//        miLiga.getMisPersonas().add(aficionado2);
//        miLiga.getMisPersonas().add(aficionado3);
//        miLiga.getMisPersonas().add(aficionado4);
//        miLiga.getMisPersonas().add(aficionado5);
//        System.out.println("b. Promedio de edad por cada uno de los equipos (Sólo jugadores)");
//        System.out.println("Equipo 1: " + miLiga.getMisEquipos().get(0).promEdad());
//        System.out.println("Equipo 2: " + miLiga.getMisEquipos().get(1).promEdad());
//        System.out.println("Equipo 3: " + miLiga.getMisEquipos().get(2).promEdad());
//        System.out.println("Equipo 4: " + miLiga.getMisEquipos().get(3).promEdad());
//        System.out.println("Equipo 5: " + miLiga.getMisEquipos().get(4).promEdad());
//        System.out.println("Equipo 6: " + miLiga.getMisEquipos().get(5).promEdad());
//
//        System.out.println("f. Equipo con nómina de jugadores y técnico más alta.");
//        System.out.println(miLiga.equipoMayorNomina().getNombre());
//
//        System.out.println("g. Equipo con mayor cantidad de aficionados");
//        System.out.println(miLiga.equipoMayorAficionados().getNombre());
//        System.out.println("i. Arquero que le han marcado menos goles");
//        System.out.println("Nombre: " + miLiga.arqueroMenosGoles().getNombre());
//
//        System.out.println("a. Jugador mas joven de la liga: ");
//        System.out.println(miLiga.jugadorMasJoven().getNombre());
//
//        System.out.println("c. Cantidad de partidos en el que un equipo gano por goleada: ");
//        System.out.println(miLiga.getMisEquipos().get(3).cantPartidosGoleada());
//
//        System.out.println("e. Jugador que ha marcado mas goles en la liga: ");
//        System.out.println(miLiga.jugadorMayorGoles().getNombre());
//
//        System.out.println("h. Identificador del partido el cual tuvo más goles");
//        System.out.println(miLiga.idPartidoMasGoles());
//
//        System.out.println("j. Nombre del estadio donde se marcaron más goles en toda la liga");
//        System.out.println(miLiga.nombreEstadioMasGoles());
    }

    //Archivos binarios - Guardar
    public void eventoCierre() {
        System.out.println("Guardando");
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("liga.obj"));
            salida.writeObject(this.miLiga);
            salida.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
        System.exit(0);
    }

    //Archivos binarios - Cargar
    public void cargarSesion() {
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("liga.obj"));
            this.miLiga = (Liga) entrada.readObject();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

    //Archivos planos - Guardar
    public void guardarArchivo(String contenido, String extension) {
        try {
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(this);
            //String ruta = "" + file.getCurrentDirectory();
            try (BufferedWriter save = new BufferedWriter(new FileWriter(file.getSelectedFile().toString() + "." + extension))) {
                save.write(contenido);
            }
            JOptionPane.showMessageDialog(null, "El archivo se ha guardado exitosamente",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void limpiarCajas() {
        this.txtCedulaTecnico.setText("");
        this.txtNombreTecnico.setText("");
        this.txtApellidoTecnico.setText("");
        this.txtEdadTecnico.setText("");
        this.txtExperienciaTecnico.setText("");
        this.txtSalarioTecnico.setText("");
        this.txtEquipoTecnico.setText("");

        this.txtCedulaAficionado.setText("");
        this.txtNombreAficionado.setText("");
        this.txtApellidoAficionado.setText("");
        this.txtEdadAficionado.setText("");
        this.txtFidelidadAficionado.setText("");
        this.checkAbonoAficionado.setSelected(false);
        this.txtEquipoAficionado.setText("");

        this.txtIdentificadorEquipo.setText("");
        this.txtNombreEquipo.setText("");
        this.txtFundacionEquipo.setText("");
        this.txtTitulosNacionalesEquipo.setText("");
        this.txtTitulosInternacionalesEquipo.setText("");
        this.txtPuntosEquipo.setText("");
        this.txtPartidosEquipo.setText("");
        this.txtGolesFavorEquipo.setText("");
        this.txtGolesContraEquipo.setText("");
        
        this.txtCedulaJugador.setText("");
        this.txtNombreJugador.setText("");
        this.txtApellidoJugador.setText("");
        this.txtEdadJugador.setText("");
        this.txtNacionalidadJugador.setText("");
        this.txtPosicionJugador.setText("");
        this.txtGolesMarcadosJugador.setText("");
        this.txtSalarioJugador.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCedulaTecnico = new javax.swing.JTextField();
        txtNombreTecnico = new javax.swing.JTextField();
        txtApellidoTecnico = new javax.swing.JTextField();
        txtEdadTecnico = new javax.swing.JTextField();
        txtExperienciaTecnico = new javax.swing.JTextField();
        txtSalarioTecnico = new javax.swing.JTextField();
        btnAgregarTecnico = new javax.swing.JButton();
        btnBuscarTecnico = new javax.swing.JButton();
        btnActualizarTecnico = new javax.swing.JButton();
        btnEliminarTecnico = new javax.swing.JButton();
        btnLimpiarTecnico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTecnico = new javax.swing.JTable();
        btnCertificadoTecnico = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtEquipoTecnico = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCedulaAficionado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreAficionado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellidoAficionado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEdadAficionado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFidelidadAficionado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnAgregarAficionado = new javax.swing.JButton();
        btnBuscarAficionado = new javax.swing.JButton();
        btnActualizarAficionado = new javax.swing.JButton();
        btnEliminarAficionado = new javax.swing.JButton();
        btnLimpiarAficionado = new javax.swing.JButton();
        checkAbonoAficionado = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAficionado = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtEquipoAficionado = new javax.swing.JTextField();
        btnCertificadoAficionado = new javax.swing.JButton();
        Jpanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtCedulaJugador = new javax.swing.JTextField();
        txtNombreJugador = new javax.swing.JTextField();
        txtApellidoJugador = new javax.swing.JTextField();
        txtEdadJugador = new javax.swing.JTextField();
        txtNacionalidadJugador = new javax.swing.JTextField();
        txtSalarioJugador = new javax.swing.JTextField();
        txtGolesMarcadosJugador = new javax.swing.JTextField();
        txtEquipoJugador = new javax.swing.JTextField();
        btnAgregarJugador = new javax.swing.JButton();
        btnBuscarJugador = new javax.swing.JButton();
        btnActualizarJugador = new javax.swing.JButton();
        btnEliminarJugador = new javax.swing.JButton();
        btnCertificadoJugador = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblJugador = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtIdentificadorEquipo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNombreEquipo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtFundacionEquipo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTitulosNacionalesEquipo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTitulosInternacionalesEquipo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtPuntosEquipo = new javax.swing.JTextField();
        txtPartidosEquipo = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblEquipo = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        txtGolesFavorEquipo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtGolesContraEquipo = new javax.swing.JTextField();
        btnAgregarEquipo = new javax.swing.JButton();
        btnBuscarEquipo = new javax.swing.JButton();
        btnActualizarEquipo = new javax.swing.JButton();
        btnEliminarEquipo = new javax.swing.JButton();
        btnLimpiarEquipo = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        cbTecnicoEquipo = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cbJugadorEquipo = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cbAficionadoEquipo = new javax.swing.JComboBox<>();
        btnAgregarRelacionTecnicoEquipo = new javax.swing.JButton();
        btnEliminarRelacionTecnicoEquipo = new javax.swing.JButton();
        btnAgregarRelacionJugadorTecnico = new javax.swing.JButton();
        btnEliminarRelacionJugadorTecnico = new javax.swing.JButton();
        btnAgregarRelacionAficionadoTecnico = new javax.swing.JButton();
        btnEliminarRelacionAficionadoTecnico = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtMostrarTecnicoEquipo = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblJugadorTecnico = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAficionadoTecnico = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPosiciones = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liga");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setText("Cédula :");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Edad:");

        jLabel5.setText("Años de experiencia: ");

        jLabel6.setText("Salario: ");

        btnAgregarTecnico.setText("Agregar");
        btnAgregarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTecnicoActionPerformed(evt);
            }
        });

        btnBuscarTecnico.setText("Buscar");
        btnBuscarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTecnicoActionPerformed(evt);
            }
        });

        btnActualizarTecnico.setText("Actualizar");
        btnActualizarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTecnicoActionPerformed(evt);
            }
        });

        btnEliminarTecnico.setText("Eliminar");
        btnEliminarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTecnicoActionPerformed(evt);
            }
        });

        btnLimpiarTecnico.setText("Limpiar");
        btnLimpiarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTecnicoActionPerformed(evt);
            }
        });

        tblTecnico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblTecnico);

        btnCertificadoTecnico.setText("Generar certificado");
        btnCertificadoTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoTecnicoActionPerformed(evt);
            }
        });

        jLabel15.setText("Equipo:");

        txtEquipoTecnico.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAgregarTecnico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarTecnico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizarTecnico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarTecnico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarTecnico))
                    .addComponent(btnCertificadoTecnico)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel15))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEquipoTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalarioTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExperienciaTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdadTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedulaTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCedulaTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidoTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtEdadTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtExperienciaTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtSalarioTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtEquipoTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarTecnico)
                            .addComponent(btnBuscarTecnico)
                            .addComponent(btnActualizarTecnico)
                            .addComponent(btnEliminarTecnico)
                            .addComponent(btnLimpiarTecnico))
                        .addGap(18, 18, 18)
                        .addComponent(btnCertificadoTecnico))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Técnico", jPanel8);

        jLabel7.setText("Cédula :");

        jLabel8.setText("Nombre: ");

        jLabel9.setText("Apellido:");

        jLabel10.setText("Edad:");

        jLabel11.setText("Años de fidelidad: ");

        jLabel12.setText("Abono:");

        btnAgregarAficionado.setText("Agregar");
        btnAgregarAficionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAficionadoActionPerformed(evt);
            }
        });

        btnBuscarAficionado.setText("Buscar");
        btnBuscarAficionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAficionadoActionPerformed(evt);
            }
        });

        btnActualizarAficionado.setText("Actualizar");
        btnActualizarAficionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAficionadoActionPerformed(evt);
            }
        });

        btnEliminarAficionado.setText("Eliminar");
        btnEliminarAficionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAficionadoActionPerformed(evt);
            }
        });

        btnLimpiarAficionado.setText("Limpiar");
        btnLimpiarAficionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAficionadoActionPerformed(evt);
            }
        });

        tblAficionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblAficionado);

        jLabel14.setText("Equipo:");

        txtEquipoAficionado.setEditable(false);

        btnCertificadoAficionado.setText("Generar certificado");
        btnCertificadoAficionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoAficionadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel14))
                            .addGap(23, 23, 23)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEquipoAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFidelidadAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEdadAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellidoAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCedulaAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkAbonoAficionado))
                            .addGap(195, 195, 195))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(btnAgregarAficionado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscarAficionado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnActualizarAficionado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEliminarAficionado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnLimpiarAficionado)
                            .addGap(18, 18, 18)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnCertificadoAficionado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtCedulaAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtNombreAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtApellidoAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtEdadAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtFidelidadAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(checkAbonoAficionado))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtEquipoAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarAficionado)
                            .addComponent(btnBuscarAficionado)
                            .addComponent(btnActualizarAficionado)
                            .addComponent(btnEliminarAficionado)
                            .addComponent(btnLimpiarAficionado))
                        .addGap(18, 18, 18)
                        .addComponent(btnCertificadoAficionado))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Aficionado", jPanel9);

        jLabel29.setText("Cédula:");

        jLabel30.setText("Nombre:");

        jLabel31.setText("Apellido:");

        jLabel32.setText("Edad:");

        jLabel33.setText("Nacionalidad:");

        jLabel34.setText("Salario:");

        jLabel35.setText("Equipo:");

        jLabel36.setText("Goles marcados:");

        txtNombreJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreJugadorActionPerformed(evt);
            }
        });

        txtApellidoJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoJugadorActionPerformed(evt);
            }
        });

        txtEdadJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadJugadorActionPerformed(evt);
            }
        });

        txtNacionalidadJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNacionalidadJugadorActionPerformed(evt);
            }
        });

        txtSalarioJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioJugadorActionPerformed(evt);
            }
        });

        txtGolesMarcadosJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGolesMarcadosJugadorActionPerformed(evt);
            }
        });

        txtEquipoJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipoJugadorActionPerformed(evt);
            }
        });

        btnAgregarJugador.setText("Agregar");
        btnAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJugadorActionPerformed(evt);
            }
        });

        btnBuscarJugador.setText("Buscar");
        btnBuscarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarJugadorActionPerformed(evt);
            }
        });

        btnActualizarJugador.setText("Actualizar");
        btnActualizarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarJugadorActionPerformed(evt);
            }
        });

        btnEliminarJugador.setText("Eliminar");
        btnEliminarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarJugadorActionPerformed(evt);
            }
        });

        btnCertificadoJugador.setText("Generar certificado");
        btnCertificadoJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoJugadorActionPerformed(evt);
            }
        });

        tblJugador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tblJugador);

        jLabel37.setText("Tabla jugadores");

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedulaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(txtNombreJugador)
                            .addComponent(txtApellidoJugador)
                            .addComponent(txtEdadJugador)
                            .addComponent(txtNacionalidadJugador)
                            .addComponent(txtSalarioJugador)
                            .addComponent(txtGolesMarcadosJugador)
                            .addComponent(txtEquipoJugador)))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpanelLayout.createSequentialGroup()
                                .addComponent(btnAgregarJugador)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarJugador)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizarJugador))
                            .addComponent(btnCertificadoJugador))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarJugador)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(274, 274, 274))))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtCedulaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtApellidoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtEdadJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txtNacionalidadJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtSalarioJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txtGolesMarcadosJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtEquipoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarJugador)
                            .addComponent(btnBuscarJugador)
                            .addComponent(btnActualizarJugador)
                            .addComponent(btnEliminarJugador))
                        .addGap(18, 18, 18)
                        .addComponent(btnCertificadoJugador)))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Jugador", Jpanel);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Manager", jPanel11);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Árbitro", jPanel12);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Persona", jPanel1);

        jLabel16.setText("Identificador:");

        jLabel17.setText("Nombre: ");

        jLabel18.setText("Año de fundación: ");

        jLabel19.setText("# títulos nacionales: ");

        jLabel20.setText("# títulos internacionales: ");

        jLabel21.setText("Puntos: ");

        jLabel22.setText("Partidos jugados:");

        txtPuntosEquipo.setEditable(false);

        txtPartidosEquipo.setEditable(false);

        tblEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblEquipo);

        jLabel23.setText("Goles a favor:");

        txtGolesFavorEquipo.setEditable(false);

        jLabel24.setText("Goles en contrar:");

        txtGolesContraEquipo.setEditable(false);

        btnAgregarEquipo.setText("Agregar");
        btnAgregarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEquipoActionPerformed(evt);
            }
        });

        btnBuscarEquipo.setText("Buscar");
        btnBuscarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEquipoActionPerformed(evt);
            }
        });

        btnActualizarEquipo.setText("Actualizar");
        btnActualizarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEquipoActionPerformed(evt);
            }
        });

        btnEliminarEquipo.setText("Eliminar");
        btnEliminarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEquipoActionPerformed(evt);
            }
        });

        btnLimpiarEquipo.setText("Limpiar");
        btnLimpiarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFundacionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitulosNacionalesEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentificadorEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGolesContraEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGolesFavorEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPartidosEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPuntosEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitulosInternacionalesEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnAgregarEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizarEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarEquipo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdentificadorEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtFundacionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTitulosNacionalesEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTitulosInternacionalesEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtPuntosEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtPartidosEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtGolesFavorEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtGolesContraEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarEquipo)
                            .addComponent(btnBuscarEquipo)
                            .addComponent(btnActualizarEquipo)
                            .addComponent(btnEliminarEquipo)
                            .addComponent(btnLimpiarEquipo)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Gestionar", jPanel13);

        jLabel25.setText("Técnico: ");

        cbTecnicoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel26.setText("Jugadores: ");

        cbJugadorEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setText("Aficionados:");

        cbAficionadoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregarRelacionTecnicoEquipo.setText("Agregar");
        btnAgregarRelacionTecnicoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRelacionTecnicoEquipoActionPerformed(evt);
            }
        });

        btnEliminarRelacionTecnicoEquipo.setText("Eliminar");
        btnEliminarRelacionTecnicoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRelacionTecnicoEquipoActionPerformed(evt);
            }
        });

        btnAgregarRelacionJugadorTecnico.setText("Agregar");
        btnAgregarRelacionJugadorTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRelacionJugadorTecnicoActionPerformed(evt);
            }
        });

        btnEliminarRelacionJugadorTecnico.setText("Eliminar");
        btnEliminarRelacionJugadorTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRelacionJugadorTecnicoActionPerformed(evt);
            }
        });

        btnAgregarRelacionAficionadoTecnico.setText("Agregar");
        btnAgregarRelacionAficionadoTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRelacionAficionadoTecnicoActionPerformed(evt);
            }
        });

        btnEliminarRelacionAficionadoTecnico.setText("Eliminar");
        btnEliminarRelacionAficionadoTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRelacionAficionadoTecnicoActionPerformed(evt);
            }
        });

        jLabel28.setText("Técnico actual:");

        tblJugadorTecnico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblJugadorTecnico);

        tblAficionadoTecnico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblAficionadoTecnico);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTecnicoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbJugadorEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(btnAgregarRelacionTecnicoEquipo)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarRelacionTecnicoEquipo))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(btnAgregarRelacionJugadorTecnico)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarRelacionJugadorTecnico))))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMostrarTecnicoEquipo))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(cbAficionadoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarRelacionAficionadoTecnico)))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarRelacionAficionadoTecnico))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTecnicoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarRelacionTecnicoEquipo)
                        .addComponent(btnEliminarRelacionTecnicoEquipo))
                    .addComponent(jLabel25)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(txtMostrarTecnicoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cbJugadorEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarRelacionJugadorTecnico)
                    .addComponent(btnEliminarRelacionJugadorTecnico)
                    .addComponent(jLabel27)
                    .addComponent(cbAficionadoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarRelacionAficionadoTecnico)
                    .addComponent(btnEliminarRelacionAficionadoTecnico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Planilla", jPanel14);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Partidos", jPanel15);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Reportes", jPanel16);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Equipo", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Estadio", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Partido", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Jornada", jPanel5);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Tabla de posiciones");

        tblPosiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPosiciones);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tabla de posiciones", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reportes", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //==========================================================================
    //SECCIÓN PERSONAS -> TÉCNICO

    private void btnAgregarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTecnicoActionPerformed
        String cedula = this.txtCedulaTecnico.getText();
        Persona persona = this.miLiga.buscarPersona(cedula);
        if (persona == null) {
            String nombre = this.txtNombreTecnico.getText();
            String apellido = this.txtApellidoTecnico.getText();
            int edad = Integer.parseInt(this.txtEdadTecnico.getText());
            int experiencia = Integer.parseInt(this.txtExperienciaTecnico.getText());
            int salario = Integer.parseInt(this.txtSalarioTecnico.getText());
            Tecnico nuevoTecnico = new Tecnico(cedula, nombre, apellido, edad, experiencia, salario);
            this.miLiga.getMisPersonas().add(nuevoTecnico);
            JOptionPane.showMessageDialog(this, "Se agregó el técnico " + nombre);
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una persona con esa cédula");
        }

        this.limpiarCajas();
        this.actualizarTablaTecnicos();
    }//GEN-LAST:event_btnAgregarTecnicoActionPerformed

    private void btnBuscarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTecnicoActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Tecnico) {
                this.txtCedulaTecnico.setEditable(false);
                Tecnico tecnico = (Tecnico) buscarPersona;
                this.txtCedulaTecnico.setText(tecnico.getCedula());
                this.txtNombreTecnico.setText(tecnico.getNombre());
                this.txtApellidoTecnico.setText(tecnico.getApellido());
                this.txtEdadTecnico.setText("" + tecnico.getEdad());
                this.txtExperienciaTecnico.setText("" + tecnico.getAniosExperiencia());
                this.txtSalarioTecnico.setText("" + tecnico.getSalario());
                this.txtEquipoTecnico.setText(this.equipoAsignado(tecnico.getMiEquipo()));

            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un técnico");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnBuscarTecnicoActionPerformed

    private void btnActualizarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTecnicoActionPerformed
        String cedula = this.txtCedulaTecnico.getText();
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Tecnico) {
                Tecnico tecnico = (Tecnico) buscarPersona;
                String nombre = this.txtNombreTecnico.getText();
                String apellido = this.txtApellidoTecnico.getText();
                int edad = Integer.parseInt(this.txtEdadTecnico.getText());
                int experiencia = Integer.parseInt(this.txtExperienciaTecnico.getText());
                int salario = Integer.parseInt(this.txtSalarioTecnico.getText());
                tecnico.setNombre(nombre);
                tecnico.setApellido(apellido);
                tecnico.setEdad(edad);
                tecnico.setAniosExperiencia(experiencia);
                tecnico.setSalario(salario);
                JOptionPane.showMessageDialog(this, "Se actualizó el técnico de cédula " + cedula);
                this.txtCedulaTecnico.setEditable(true);
                this.limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un técnico");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaTecnicos();
    }//GEN-LAST:event_btnActualizarTecnicoActionPerformed

    private void btnEliminarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTecnicoActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del técnico que desea eliminar");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Tecnico) {
                this.miLiga.getMisPersonas().remove(buscarPersona);
                JOptionPane.showMessageDialog(this, "El técnico de cédula " + cedula + " se eliminó");
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un técnico");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaTecnicos();
    }//GEN-LAST:event_btnEliminarTecnicoActionPerformed

    private void btnLimpiarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTecnicoActionPerformed
        this.txtCedulaTecnico.setEditable(true);
        this.limpiarCajas();

    }//GEN-LAST:event_btnLimpiarTecnicoActionPerformed

    public void actualizarTablaTecnicos() {
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "Experiencia", "Salario"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblTecnico.setModel(miModelo);
        LinkedList<Persona> lista = this.miLiga.getMisPersonas();
        for (Persona actual : lista) {
            if (actual instanceof Tecnico) {
                Tecnico tecnico = (Tecnico) actual;
                String fila[] = new String[nombreColumnas.length];
                fila[0] = tecnico.getCedula();
                fila[1] = tecnico.getNombre();
                fila[2] = tecnico.getApellido();
                fila[3] = "" + tecnico.getEdad();
                fila[4] = "" + tecnico.getAniosExperiencia();
                fila[5] = "$" + tecnico.getSalario();
                miModelo.addRow(fila);
            }
        }
    }

    //==========================================================================
    //==========================================================================
    //SECCIÓN PERSONAS -> AFICIONADO

    private void btnAgregarAficionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAficionadoActionPerformed
        String cedula = this.txtCedulaAficionado.getText();
        Persona persona = this.miLiga.buscarPersona(cedula);
        if (persona == null) {
            String nombre = this.txtNombreAficionado.getText();
            String apellido = this.txtApellidoAficionado.getText();
            int edad = Integer.parseInt(this.txtEdadAficionado.getText());
            int fidelidad = Integer.parseInt(this.txtFidelidadAficionado.getText());
            boolean abono = this.checkAbonoAficionado.isSelected();
            Aficionado nuevoAficionado = new Aficionado(cedula, nombre, apellido, edad, fidelidad, abono);
            this.miLiga.getMisPersonas().add(nuevoAficionado);
            JOptionPane.showMessageDialog(this, "Se agregó el aficionado " + nombre);
            this.actualizarTablaAficionado();
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una persona con esa cédula");
        }

        this.limpiarCajas();
    }//GEN-LAST:event_btnAgregarAficionadoActionPerformed

    private void btnBuscarAficionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAficionadoActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Aficionado) {
                this.txtCedulaAficionado.setEditable(false);
                Aficionado aficionado = (Aficionado) buscarPersona;
                this.txtCedulaAficionado.setText(aficionado.getCedula());
                this.txtNombreAficionado.setText(aficionado.getNombre());
                this.txtApellidoAficionado.setText(aficionado.getApellido());
                this.txtEdadAficionado.setText("" + aficionado.getEdad());
                this.txtFidelidadAficionado.setText("" + aficionado.getAniosFidelidad());
                this.checkAbonoAficionado.setSelected(aficionado.isAbono());
                this.txtEquipoAficionado.setText(this.equipoAsignado(aficionado.getMiEquipo()));
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un aficionado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnBuscarAficionadoActionPerformed

    private void btnActualizarAficionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAficionadoActionPerformed
        String cedula = this.txtCedulaAficionado.getText();
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Aficionado) {
                Aficionado aficionado = (Aficionado) buscarPersona;
                String nombre = this.txtNombreAficionado.getText();
                String apellido = this.txtApellidoAficionado.getText();
                int edad = Integer.parseInt(this.txtEdadAficionado.getText());
                int fidelidad = Integer.parseInt(this.txtFidelidadAficionado.getText());
                boolean abono = this.checkAbonoAficionado.isSelected();
                aficionado.setNombre(nombre);
                aficionado.setApellido(apellido);
                aficionado.setEdad(edad);
                aficionado.setAniosFidelidad(fidelidad);
                aficionado.setAbono(abono);
                JOptionPane.showMessageDialog(this, "Se actualizó el aficionado de cédula " + cedula);
                this.actualizarTablaAficionado();
                this.txtCedulaAficionado.setEditable(true);
                this.limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un aficionado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnActualizarAficionadoActionPerformed

    private void btnEliminarAficionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAficionadoActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del aficionado que desea eliminar");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Aficionado) {
                this.miLiga.getMisPersonas().remove(buscarPersona);
                JOptionPane.showMessageDialog(this, "El aficionado de cédula " + cedula + " se eliminó");
                this.actualizarTablaAficionado();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un aficionado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnEliminarAficionadoActionPerformed

    private void btnLimpiarAficionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAficionadoActionPerformed
        this.limpiarCajas();
        this.txtCedulaAficionado.setEditable(true);
    }//GEN-LAST:event_btnLimpiarAficionadoActionPerformed

    public void actualizarTablaAficionado() {
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "Fidelidad", "Abono"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblAficionado.setModel(miModelo);
        LinkedList<Persona> lista = this.miLiga.getMisPersonas();
        for (Persona actual : lista) {
            if (actual instanceof Aficionado) {
                Aficionado aficionado = (Aficionado) actual;
                String fila[] = new String[nombreColumnas.length];
                fila[0] = aficionado.getCedula();
                fila[1] = aficionado.getNombre();
                fila[2] = aficionado.getApellido();
                fila[3] = "" + aficionado.getEdad();
                fila[4] = "" + aficionado.getAniosFidelidad();
                fila[5] = "" + aficionado.isAbono();
                miModelo.addRow(fila);
            }
        }
    }

    //Certificado de técnico
    private void btnCertificadoTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoTecnicoActionPerformed
        String cedula = this.txtCedulaTecnico.getText();
        Persona buscarPersona = this.miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Tecnico) {
                Tecnico tecnico = (Tecnico) buscarPersona;
                String cuerpo = this.cuerpoCertificados(buscarPersona);
                String finalCertificado = this.finalCertificados();
                String propio = " y actúa en calidad de técnico del equipo " + this.equipoAsignado(tecnico.getMiEquipo());

                String contenido = cuerpo + propio + finalCertificado;
                this.guardarArchivo(contenido, "doc");
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un técnico");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnCertificadoTecnicoActionPerformed
    //Certificado de aficionado
    private void btnCertificadoAficionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoAficionadoActionPerformed
        String cedula = this.txtCedulaAficionado.getText();
        Persona buscarPersona = this.miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Aficionado) {
                Aficionado aficionado = (Aficionado) buscarPersona;
                String cuerpo = this.cuerpoCertificados(buscarPersona);
                String finalCertificado = this.finalCertificados();
                String propio = " y actúa en calidad de aficionado del equipo " + this.equipoAsignado(aficionado.getMiEquipo()) + " afirmando que lleva " + aficionado.getAniosFidelidad() + " años acompañándolos en las buenas y las malas campañas";

                String contenido = cuerpo + propio + finalCertificado;
                this.guardarArchivo(contenido, "doc");
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un técnico");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnCertificadoAficionadoActionPerformed

    //==========================================================================
    //SECCIÓN EQUIPO -> GESTIONAR
    private void btnAgregarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEquipoActionPerformed
        String identificador = this.txtIdentificadorEquipo.getText();
        Equipo buscarEquipo = this.miLiga.buscarEquipo(identificador);
        if (buscarEquipo == null) {
            String nombre = this.txtNombreEquipo.getText();
            int fundacion = Integer.parseInt(this.txtFundacionEquipo.getText());
            int titulosNacionales = Integer.parseInt(this.txtTitulosNacionalesEquipo.getText());
            int titulosInternacionales = Integer.parseInt(this.txtTitulosInternacionalesEquipo.getText());
            this.miLiga.crearEquipo(identificador, nombre, fundacion, titulosNacionales, titulosInternacionales, 0, 0, 0, 0);
            JOptionPane.showMessageDialog(this, "Se creó el equipo " + nombre);

            this.actualizarTablaEquipo();
            this.limpiarCajas();

        } else {
            JOptionPane.showMessageDialog(this, "Ya existe un equipo con ese identificador");
            this.limpiarCajas();
        }
    }//GEN-LAST:event_btnAgregarEquipoActionPerformed

    private void btnBuscarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEquipoActionPerformed
        String identificador = JOptionPane.showInputDialog(this, "Ingrese el identificador del equipo");
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            this.txtIdentificadorEquipo.setEditable(false);
            this.txtIdentificadorEquipo.setText(equipoEncontrado.getId());
            this.txtNombreEquipo.setText(equipoEncontrado.getNombre());
            this.txtFundacionEquipo.setText("" + equipoEncontrado.getAnioFundacion());
            this.txtTitulosNacionalesEquipo.setText("" + equipoEncontrado.getNumTitulosNacionales());
            this.txtTitulosInternacionalesEquipo.setText("" + equipoEncontrado.getNumTitulosInternacionales());
            this.txtPuntosEquipo.setText("" + equipoEncontrado.getPuntos());
            this.txtPartidosEquipo.setText("" + equipoEncontrado.getPartidosJugados());
            this.txtGolesFavorEquipo.setText("" + equipoEncontrado.getGolesFavor());
            this.txtGolesContraEquipo.setText("" + equipoEncontrado.getGolesContra());
        } else {
            JOptionPane.showMessageDialog(this, "El identificador ingresado es erróneo");
        }
    }//GEN-LAST:event_btnBuscarEquipoActionPerformed

    private void btnActualizarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEquipoActionPerformed
        String identificador = this.txtIdentificadorEquipo.getText();
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            String nombre = this.txtNombreEquipo.getText();
            int fundacion = Integer.parseInt(this.txtFundacionEquipo.getText());
            int titulosNacionales = Integer.parseInt(this.txtTitulosNacionalesEquipo.getText());
            int titulosInternacionales = Integer.parseInt(this.txtTitulosInternacionalesEquipo.getText());
            equipoEncontrado.setNombre(nombre);
            equipoEncontrado.setAnioFundacion(fundacion);
            equipoEncontrado.setNumTitulosNacionales(titulosNacionales);
            equipoEncontrado.setNumTitulosInternacionales(titulosInternacionales);
            JOptionPane.showMessageDialog(this, "Se actualizó el equipo con identificador " + identificador);
            this.actualizarTablaEquipo();
            this.txtIdentificadorEquipo.setEditable(true);
            this.limpiarCajas();
        }
    }//GEN-LAST:event_btnActualizarEquipoActionPerformed

    private void btnEliminarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEquipoActionPerformed
        String identificador = JOptionPane.showInputDialog(this, "Ingrese el identificador del equipo que desea eliminar");
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            this.miLiga.eliminarEquipo(equipoEncontrado);
            JOptionPane.showMessageDialog(this, "El equipo " + equipoEncontrado.getNombre() + " se ha eliminado");
            this.actualizarTablaEquipo();
        } else {
            JOptionPane.showMessageDialog(this, "El identificador ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarEquipoActionPerformed

    private void btnLimpiarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEquipoActionPerformed
        this.limpiarCajas();
        this.txtIdentificadorEquipo.setEditable(true);
    }//GEN-LAST:event_btnLimpiarEquipoActionPerformed

    public void actualizarTablaEquipo() {
        String nombreColumnas[] = {"Id", "Nombre", "Fundación", "Tít. Nac.", "Tít. Intl."};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblEquipo.setModel(miModelo);
        LinkedList<Equipo> lista = this.miLiga.getMisEquipos();
        for (Equipo actual : lista) {
            String fila[] = new String[nombreColumnas.length];
            fila[0] = actual.getId();
            fila[1] = actual.getNombre();
            fila[2] = "" + actual.getAnioFundacion();
            fila[3] = "" + actual.getNumTitulosNacionales();
            fila[4] = "" + actual.getNumTitulosInternacionales();
            miModelo.addRow(fila);
        }
    }

    //==========================================================================
    //SECCIÓN EQUIPO -> PLANILLA

    private void btnAgregarRelacionTecnicoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRelacionTecnicoEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarRelacionTecnicoEquipoActionPerformed

    private void btnEliminarRelacionTecnicoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRelacionTecnicoEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarRelacionTecnicoEquipoActionPerformed

    private void btnAgregarRelacionJugadorTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRelacionJugadorTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarRelacionJugadorTecnicoActionPerformed

    private void btnEliminarRelacionJugadorTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRelacionJugadorTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarRelacionJugadorTecnicoActionPerformed

    private void btnAgregarRelacionAficionadoTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRelacionAficionadoTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarRelacionAficionadoTecnicoActionPerformed

    private void btnEliminarRelacionAficionadoTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRelacionAficionadoTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarRelacionAficionadoTecnicoActionPerformed

    private void txtEquipoJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipoJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipoJugadorActionPerformed

    private void txtGolesMarcadosJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGolesMarcadosJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGolesMarcadosJugadorActionPerformed

    private void txtSalarioJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioJugadorActionPerformed

    private void txtNacionalidadJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNacionalidadJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNacionalidadJugadorActionPerformed

    private void txtEdadJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadJugadorActionPerformed

    private void txtApellidoJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoJugadorActionPerformed

    private void txtNombreJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreJugadorActionPerformed

    private void btnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJugadorActionPerformed
        String cedula = this.txtCedulaJugador.getText();
        Persona persona = this.miLiga.buscarPersona(cedula);
        if (persona == null) {
            String nombre = this.txtNombreJugador.getText();
            String apellido = this.txtApellidoJugador.getText();
            int edad = Integer.parseInt(this.txtEdadJugador.getText());
            String nacionalidad= this.txtNacionalidadJugador.getText();
            int salario = Integer.parseInt(this.txtSalarioJugador.getText());
            Jugador jugador= new Jugador(cedula, nombre, apellido, edad, nacionalidad, apellido, 0, salario);
            this.miLiga.getMisPersonas().add(jugador);
            JOptionPane.showMessageDialog(this, "Se agregó el jugador " + nombre);
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una persona con esa cédula");
        }

        this.limpiarCajas();
        this.actualizarTablaJugador();
    }//GEN-LAST:event_btnAgregarJugadorActionPerformed

    private void btnActualizarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarJugadorActionPerformed
        String cedula = this.txtCedulaJugador.getText();
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Jugador) {
                Jugador jugador= (Jugador) buscarPersona;
                String nombre = this.txtNombreJugador.getText();
                String apellido = this.txtApellidoJugador.getText();
                int edad = Integer.parseInt(this.txtEdadJugador.getText());
                String nacionalidad= this.txtNacionalidadJugador.getText();
                int salario = Integer.parseInt(this.txtSalarioJugador.getText());
                jugador.setNombre(nombre);
                jugador.setApellido(apellido);
                jugador.setEdad(edad);
                jugador.setNacionalidad(nacionalidad);
                jugador.setSalario(salario);
                JOptionPane.showMessageDialog(this, "Se actualizó el jugador de cédula " + cedula);
                this.txtCedulaJugador.setEditable(true);
                this.limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un jugador");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaJugador();
    }//GEN-LAST:event_btnActualizarJugadorActionPerformed

    private void btnBuscarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarJugadorActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Jugador) {
                this.txtCedulaJugador.setEditable(false);
                Jugador jugador= (Jugador) buscarPersona;
                this.txtCedulaJugador.setText(jugador.getCedula());
                this.txtNombreJugador.setText(jugador.getNombre());
                this.txtApellidoJugador.setText(jugador.getApellido());
                this.txtEdadJugador.setText("" + jugador.getEdad());
                this.txtNacionalidadJugador.setText("" + jugador.getNacionalidad());
                this.txtSalarioJugador.setText("" + jugador.getSalario());
                this.txtEquipoJugador.setText(this.equipoAsignado(jugador.getMiEquipo()));

            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un jugador");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnBuscarJugadorActionPerformed

    private void btnEliminarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarJugadorActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del jugador que desea eliminar");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Jugador) {
                this.miLiga.getMisPersonas().remove(buscarPersona);
                JOptionPane.showMessageDialog(this, "El jugador de cédula " + cedula + " se eliminó");
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un jugador");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaJugador();
    }//GEN-LAST:event_btnEliminarJugadorActionPerformed

    private void btnCertificadoJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoJugadorActionPerformed
       String cedula = this.txtCedulaJugador.getText();
        Persona buscarPersona = this.miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Jugador) {
                Jugador jugador= (Jugador) buscarPersona;
                String cuerpo = this.cuerpoCertificados(buscarPersona);
                String finalCertificado = this.finalCertificados();
                String propio = " y actúa en calidad de jugador del equipo " + this.equipoAsignado(jugador.getMiEquipo()) + " ocupando la posicón de " + jugador.getPosicion() + ".";

                String contenido = cuerpo + propio + finalCertificado;
                this.guardarArchivo(contenido, "doc");
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un técnico");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnCertificadoJugadorActionPerformed
    //TABLA JUGADORES
    
    public void actualizarTablaJugador() {
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "Edad", "Nacionalidad", "Posición", "Goles", "Salario"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblJugador.setModel(miModelo);
        LinkedList<Persona> lista = this.miLiga.getMisPersonas();
        for (Persona actual: lista) {
            if(actual instanceof Jugador){
                String fila[] = new String[nombreColumnas.length];
                fila[0] = actual.getCedula();
                fila[1] = actual.getNombre();
                fila[2] = actual.getApellido();
                fila[3] = "" + actual.getEdad();
                fila[4] = "" + ((Jugador) actual).getNacionalidad();
                fila[5] = "" + ((Jugador) actual).getPosicion();
                fila[6] = "" + ((Jugador) actual).getGolesMarcados();
                fila[7] = "" + ((Jugador) actual).getSalario();
            miModelo.addRow(fila);
            }
        }
    }
    
    
    //==========================================================================
    //SECCIÓN TABLA DE POSICIONES
    public void tablaPosiciones() {
        String nombreColumnas[] = {"Posición", "Equipo", "Puntos", "Diferencia de goles", "Partidos jugados"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblPosiciones.setModel(miModelo);
        LinkedList<Equipo> lista = this.miLiga.tablaPosiciones();
        int cont = 1;
        for (Equipo actual : lista) {
            String fila[] = new String[nombreColumnas.length];
            fila[0] = "" + cont++;
            fila[1] = actual.getNombre();
            fila[2] = "" + actual.getPuntos();
            fila[3] = "" + (actual.getGolesFavor() - actual.getGolesContra());
            fila[4] = "" + actual.getPartidosJugados();
            miModelo.addRow(fila);
        }
    }

    //==========================================================================
    //CERTIFICADOS
    public String cuerpoCertificados(Persona persona) {
        Calendar calendario = Calendar.getInstance();
        String dia = "" + calendario.get(Calendar.DATE);
        int mesNumero = calendario.get(Calendar.MONTH);
        String mes = this.obtenerMes(mesNumero);
        String anio = "" + calendario.get(Calendar.YEAR);
        String encabezado = "Colombia, " + dia + " de " + mes + " de " + anio;
        String introduccion = "\n\n\n\nLa Liga Nacional de Futbol certifica a quien le interese que ";
        String cuerpo = "la persona " + persona.getNombre() + " " + persona.getApellido() + " identificado/a con la cédula " + persona.getCedula() + " se encuentra afiliado a la Liga Nacional de Fútbol";
        String contenido = encabezado + introduccion + cuerpo;
        return contenido;
    }

    public String finalCertificados() {
        Calendar calendario = Calendar.getInstance();
        String dia = "" + calendario.get(Calendar.DATE);
        int mesNumero = calendario.get(Calendar.MONTH);
        String mes = this.obtenerMes(mesNumero);
        String anio = "" + calendario.get(Calendar.YEAR);
        String resultado = "\n\nDado en Colombia a los " + dia + " días del mes de " + mes + " de " + anio + "\n\nPresidencia de la confederación";
        return resultado;
    }

    public String obtenerMes(int numMes) {
        String resultado = "";
        switch (numMes) {
            case 0:
                resultado = "enero";
                break;
            case 1:
                resultado = "febrero";
                break;
            case 2:
                resultado = "marzo";
                break;
            case 3:
                resultado = "abril";
                break;
            case 4:
                resultado = "mayo";
                break;
            case 5:
                resultado = "junio";
                break;
            case 6:
                resultado = "julio";
                break;
            case 7:
                resultado = "agosto";
                break;
            case 8:
                resultado = "septiembre";
                break;
            case 9:
                resultado = "octubre";
                break;
            case 10:
                resultado = "noviembre";
                break;
            case 11:
                resultado = "diciembre";
                break;
            default:
                resultado = "";
        }
        return resultado;
    }

    public String equipoAsignado(Equipo miEquipo) {
        if (miEquipo != null) {
            return miEquipo.getNombre();
        } else {
            return "No asignado";
        }
    }

    //==========================================================================
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JButton btnActualizarAficionado;
    private javax.swing.JButton btnActualizarEquipo;
    private javax.swing.JButton btnActualizarJugador;
    private javax.swing.JButton btnActualizarTecnico;
    private javax.swing.JButton btnAgregarAficionado;
    private javax.swing.JButton btnAgregarEquipo;
    private javax.swing.JButton btnAgregarJugador;
    private javax.swing.JButton btnAgregarRelacionAficionadoTecnico;
    private javax.swing.JButton btnAgregarRelacionJugadorTecnico;
    private javax.swing.JButton btnAgregarRelacionTecnicoEquipo;
    private javax.swing.JButton btnAgregarTecnico;
    private javax.swing.JButton btnBuscarAficionado;
    private javax.swing.JButton btnBuscarEquipo;
    private javax.swing.JButton btnBuscarJugador;
    private javax.swing.JButton btnBuscarTecnico;
    private javax.swing.JButton btnCertificadoAficionado;
    private javax.swing.JButton btnCertificadoJugador;
    private javax.swing.JButton btnCertificadoTecnico;
    private javax.swing.JButton btnEliminarAficionado;
    private javax.swing.JButton btnEliminarEquipo;
    private javax.swing.JButton btnEliminarJugador;
    private javax.swing.JButton btnEliminarRelacionAficionadoTecnico;
    private javax.swing.JButton btnEliminarRelacionJugadorTecnico;
    private javax.swing.JButton btnEliminarRelacionTecnicoEquipo;
    private javax.swing.JButton btnEliminarTecnico;
    private javax.swing.JButton btnLimpiarAficionado;
    private javax.swing.JButton btnLimpiarEquipo;
    private javax.swing.JButton btnLimpiarTecnico;
    private javax.swing.JComboBox<String> cbAficionadoEquipo;
    private javax.swing.JComboBox<String> cbJugadorEquipo;
    private javax.swing.JComboBox<String> cbTecnicoEquipo;
    private javax.swing.JCheckBox checkAbonoAficionado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tblAficionado;
    private javax.swing.JTable tblAficionadoTecnico;
    private javax.swing.JTable tblEquipo;
    private javax.swing.JTable tblJugador;
    private javax.swing.JTable tblJugadorTecnico;
    private javax.swing.JTable tblPosiciones;
    private javax.swing.JTable tblTecnico;
    private javax.swing.JTextField txtApellidoAficionado;
    private javax.swing.JTextField txtApellidoJugador;
    private javax.swing.JTextField txtApellidoTecnico;
    private javax.swing.JTextField txtCedulaAficionado;
    private javax.swing.JTextField txtCedulaJugador;
    private javax.swing.JTextField txtCedulaTecnico;
    private javax.swing.JTextField txtEdadAficionado;
    private javax.swing.JTextField txtEdadJugador;
    private javax.swing.JTextField txtEdadTecnico;
    private javax.swing.JTextField txtEquipoAficionado;
    private javax.swing.JTextField txtEquipoJugador;
    private javax.swing.JTextField txtEquipoTecnico;
    private javax.swing.JTextField txtExperienciaTecnico;
    private javax.swing.JTextField txtFidelidadAficionado;
    private javax.swing.JTextField txtFundacionEquipo;
    private javax.swing.JTextField txtGolesContraEquipo;
    private javax.swing.JTextField txtGolesFavorEquipo;
    private javax.swing.JTextField txtGolesMarcadosJugador;
    private javax.swing.JTextField txtIdentificadorEquipo;
    private javax.swing.JTextField txtMostrarTecnicoEquipo;
    private javax.swing.JTextField txtNacionalidadJugador;
    private javax.swing.JTextField txtNombreAficionado;
    private javax.swing.JTextField txtNombreEquipo;
    private javax.swing.JTextField txtNombreJugador;
    private javax.swing.JTextField txtNombreTecnico;
    private javax.swing.JTextField txtPartidosEquipo;
    private javax.swing.JTextField txtPuntosEquipo;
    private javax.swing.JTextField txtSalarioJugador;
    private javax.swing.JTextField txtSalarioTecnico;
    private javax.swing.JTextField txtTitulosInternacionalesEquipo;
    private javax.swing.JTextField txtTitulosNacionalesEquipo;
    // End of variables declaration//GEN-END:variables
}
