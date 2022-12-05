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
        this.actualizarTablaEstadio();
        this.actualizarTablaPartido();
        this.actualizarComboTecnicoEquipo();
        this.actualizarComboJugadorEquipo();
        this.actualizarComboAficionadoEquipo();
        this.actualizarComboPartidoEstadio();
        this.actualizarComboPartidosJornada();
        this.actualizarComboArbitroPartido();
        this.actualizarComboEquipoPartido();
        this.actualizarComboEquipoManager();
        this.actualizarComboJugadorManager();
        this.actualizarTablaJugador();
        this.tablaPosiciones();
        this.actualizarTablaArbitro();
        this.actualizarTablaJornada();
        this.actualizarTablaManager();

        //REPORTES GENERALES DE LA LIGA
        this.txtJugadorMasJoven.setText(this.miLiga.jugadorMasJoven().getNombre());
        this.txtGoleadorLiga.setText(this.miLiga.jugadorMayorGoles().getNombre());
        this.txtEquipoMasCaro.setText(this.miLiga.equipoMayorNomina().getNombre());
        this.txtEquipoMayorCantidadAficionados.setText(this.miLiga.equipoMayorAficionados().getNombre());
        this.txtVallaMenosVencida.setText(this.miLiga.arqueroMenosGoles().getNombre());
        this.txtNombreEstadioMasgoles.setText(this.miLiga.nombreEstadioMasGoles());
        this.txtIDPartidoMasGoles.setText(this.miLiga.idPartidoMasGoles());
        
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
            try ( BufferedWriter save = new BufferedWriter(new FileWriter(file.getSelectedFile().toString() + "." + extension))) {
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
        this.txtMostrarTecnicoEquipo.setText("");
        this.actualizarTablaJugadoresEquipo("-1");
        this.actualizarTablaAficionadosEquipo("-1");
        this.actualizarTablaPartidosEquipo("-1");
        this.txtJugadorJovenEquipo.setText("");
        this.txtPromedioEdadJugadoresEquipo.setText("");
        this.txtCantidadPartidosGoleadaEquipo.setText("");
        this.txtJugadorMasGolesEquipo.setText("");
        this.txtNominaEquipo.setText("");
        this.txtArqueroEquipo.setText("");

        this.txtCedulaJugador.setText("");
        this.txtNombreJugador.setText("");
        this.txtApellidoJugador.setText("");
        this.txtEdadJugador.setText("");
        this.txtNacionalidadJugador.setText("");
        this.txtPosicionJugador.setText("");
        this.txtPosicionJugador.setText("");
        this.txtSalarioJugador.setText("");
        this.txtEquipoJugador.setText("");
        this.txtGolesJugador.setText("");

        this.txtCedulaManager.setText("");
        this.txtNombreManager.setText("");
        this.txtApellidoManager.setText("");
        this.txtEdadManager.setText("");
        this.txtAfiliacionManager.setText("");
        this.txtEquipoManager.setText("");

        this.txtIdentificadorEstadio.setText("");
        this.txtCiudadEstadio.setText("");
        this.txtNombreEstadio.setText("");
        this.txtCapacidadEstadio.setText("");
        this.actualizarTablaPartidoEstadio("-1");

        this.txtCedulaArbitro.setText("");
        this.txtNombreArbitro.setText("");
        this.txtApellidoArbitro.setText("");
        this.txtEdadArbitro.setText("");
        this.checkArbitroFIfa.setSelected(false);

        this.txtNumeroJornada.setText("");
        this.txtEsloganJornada.setText("");
        this.actualizarTablaPartidosJornada(-1);

        this.txtIdentificadorPartido.setText("");
        this.txtFechaPartido.setText("");
        this.txtMostrarArbitroPartido.setText("");
        this.txtMostrarJornadaPartido.setText("");
        this.txtMostrarEquipoLocal.setText("");
        this.txtMostrarEquipoVisitante.setText("");
        this.txtGolesEquipoLocal.setText("");
        this.txtGolesEquipoVisitante.setText("");

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
        btnAgregarRelacionJugadorEquipo = new javax.swing.JButton();
        btnEliminarRelacionJugadorEquipo = new javax.swing.JButton();
        btnAgregarRelacionAficionadoEquipo = new javax.swing.JButton();
        btnEliminarRelacionAficionadoEquipo = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtMostrarTecnicoEquipo = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblJugadorEquipo = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAficionadoEquipo = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        labelTituloListaPartidoEquipo = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblPartidosEquipo = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        lblJugadorMasJovenEquipo = new javax.swing.JLabel();
        lblPromEdadJugadoresEquipo = new javax.swing.JLabel();
        lblPartidosGoleadaEquipo = new javax.swing.JLabel();
        lblJugadorMasGolesEquipo = new javax.swing.JLabel();
        lblSumaTotalNominaEquipo = new javax.swing.JLabel();
        lblArqueroEquipo = new javax.swing.JLabel();
        txtJugadorJovenEquipo = new javax.swing.JTextField();
        txtPromedioEdadJugadoresEquipo = new javax.swing.JTextField();
        txtCantidadPartidosGoleadaEquipo = new javax.swing.JTextField();
        txtJugadorMasGolesEquipo = new javax.swing.JTextField();
        txtNominaEquipo = new javax.swing.JTextField();
        txtArqueroEquipo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblIdentificadorEstadio = new javax.swing.JLabel();
        lblCiudadEstadio = new javax.swing.JLabel();
        lblNombreEstadio = new javax.swing.JLabel();
        lblCapacidadEstadio = new javax.swing.JLabel();
        txtIdentificadorEstadio = new javax.swing.JTextField();
        txtCiudadEstadio = new javax.swing.JTextField();
        txtNombreEstadio = new javax.swing.JTextField();
        txtCapacidadEstadio = new javax.swing.JTextField();
        lblTituloListaEstadios = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblEstadio = new javax.swing.JTable();
        btnAgregarEstadio = new javax.swing.JButton();
        btnBuscarEstadio = new javax.swing.JButton();
        btnActualizarEstadio = new javax.swing.JButton();
        btnEliminarEstadio = new javax.swing.JButton();
        btnLimpiarEstadio = new javax.swing.JButton();
        lblRelacionPartidosEstadio = new javax.swing.JLabel();
        cbPartidoEstadio = new javax.swing.JComboBox<>();
        btnAgregarRelacionPartidoEstadio = new javax.swing.JButton();
        btnEliminarRelacionPartidoEstadio = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblPartidoEstadio = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        lblIdentificadorPartido = new javax.swing.JLabel();
        lblFechaPartido = new javax.swing.JLabel();
        txtIdentificadorPartido = new javax.swing.JTextField();
        txtFechaPartido = new javax.swing.JTextField();
        btnAgregarPartido = new javax.swing.JButton();
        btnBuscarPartido = new javax.swing.JButton();
        btnActualizarPartido = new javax.swing.JButton();
        btnEliminarPartido = new javax.swing.JButton();
        btnLimpiarPartido = new javax.swing.JButton();
        lblTituloListaPartido = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblPartido = new javax.swing.JTable();
        lblRelacionArbitroPartido = new javax.swing.JLabel();
        cbArbitroPartido = new javax.swing.JComboBox<>();
        btnAgregarRelacionArbitroPartido = new javax.swing.JButton();
        btnEliminarRelacionArbitroPartido = new javax.swing.JButton();
        txtMostrarArbitroPartido = new javax.swing.JTextField();
        lblMostraArbitroPartido = new javax.swing.JLabel();
        lblMostraJornadaPartido = new javax.swing.JLabel();
        txtMostrarJornadaPartido = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        lblEquipoLocalPartido = new javax.swing.JLabel();
        cbEquipoLocalPartido = new javax.swing.JComboBox<>();
        lblEquipoLocalSeleccionadoPartido = new javax.swing.JLabel();
        txtMostrarEquipoLocal = new javax.swing.JTextField();
        lblEquipoVisitantePartido = new javax.swing.JLabel();
        cbEquipoVisitantePartido = new javax.swing.JComboBox<>();
        lblEquipoVisitanteSeleccionadoPartido = new javax.swing.JLabel();
        txtMostrarEquipoVisitante = new javax.swing.JTextField();
        lblGolesLocalPartido = new javax.swing.JLabel();
        txtGolesEquipoLocal = new javax.swing.JTextField();
        btnAgregarEquipoLocal = new javax.swing.JButton();
        lblGolesVisitantePartido = new javax.swing.JLabel();
        txtGolesEquipoVisitante = new javax.swing.JTextField();
        lblJugadoresLocalPartido = new javax.swing.JLabel();
        cbJugadorLocalPartido = new javax.swing.JComboBox<>();
        spinnerGolesLocal = new javax.swing.JSpinner();
        lblGolesLocal = new javax.swing.JLabel();
        btnAgregarGolesLocal = new javax.swing.JButton();
        lblJugadoresVisitantePartido = new javax.swing.JLabel();
        cbJugadorVisitantePartido = new javax.swing.JComboBox<>();
        lblGolesVisitante = new javax.swing.JLabel();
        spinnerGolesVisitante = new javax.swing.JSpinner();
        btnAgregarGolesVisitante = new javax.swing.JButton();
        txtGolesLocal = new javax.swing.JTextField();
        txtGolesVisitante = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        NumeroJornada = new javax.swing.JLabel();
        EsloganJornada = new javax.swing.JLabel();
        txtNumeroJornada = new javax.swing.JTextField();
        txtEsloganJornada = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblJornada = new javax.swing.JTable();
        btnAgregarJornada = new javax.swing.JButton();
        btnActualizarJornada = new javax.swing.JButton();
        btnBuscarJornada = new javax.swing.JButton();
        btnEliminarJornada = new javax.swing.JButton();
        btnLimpiarJornada = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        cbPartidosJornada = new javax.swing.JComboBox<>();
        btnAgregarPartidoJornada = new javax.swing.JButton();
        btnEliminarPartidoJornada = new javax.swing.JButton();
        ListaJornadas = new javax.swing.JLabel();
        ListaPartidosJornada = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblPartidoJornada = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPosiciones = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        lblJugadorMasJoven = new javax.swing.JLabel();
        txtJugadorMasJoven = new javax.swing.JTextField();
        lblGoleadorLiga = new javax.swing.JLabel();
        txtGoleadorLiga = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtEquipoMasCaro = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtEquipoMayorCantidadAficionados = new javax.swing.JTextField();
        lblVallaMenosVendia = new javax.swing.JLabel();
        txtVallaMenosVencida = new javax.swing.JTextField();
        lblEstadioMasGoles = new javax.swing.JLabel();
        txtNombreEstadioMasgoles = new javax.swing.JTextField();
        lblIdPartidoMasGoles = new javax.swing.JLabel();
        txtIDPartidoMasGoles = new javax.swing.JTextField();
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
        labelTituloTablaTecnico = new javax.swing.JLabel();
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
        labelTituloListaAficionados = new javax.swing.JLabel();
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
        txtPosicionJugador = new javax.swing.JTextField();
        txtGolesJugador = new javax.swing.JTextField();
        btnAgregarJugador = new javax.swing.JButton();
        btnBuscarJugador = new javax.swing.JButton();
        btnActualizarJugador = new javax.swing.JButton();
        btnEliminarJugador = new javax.swing.JButton();
        btnCertificadoJugador = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblJugador = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        lblEquipoJugador = new javax.swing.JLabel();
        txtEquipoJugador = new javax.swing.JTextField();
        btnLimpiarJugador = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        lblCedulaManager = new javax.swing.JLabel();
        lblNombreManager = new javax.swing.JLabel();
        lblApellidoManager = new javax.swing.JLabel();
        lblEdadManager = new javax.swing.JLabel();
        lblAfiliacionManager = new javax.swing.JLabel();
        txtCedulaManager = new javax.swing.JTextField();
        txtApellidoManager = new javax.swing.JTextField();
        txtNombreManager = new javax.swing.JTextField();
        txtEdadManager = new javax.swing.JTextField();
        txtAfiliacionManager = new javax.swing.JTextField();
        btnAgregarManager = new javax.swing.JButton();
        btnBuscarManager = new javax.swing.JButton();
        btnActualizarManager = new javax.swing.JButton();
        btnEliminarManager = new javax.swing.JButton();
        btnLimpiarManager = new javax.swing.JButton();
        lblJugadoresManager = new javax.swing.JLabel();
        cbManagerJugadores = new javax.swing.JComboBox<>();
        lblEquipoManager = new javax.swing.JLabel();
        cbManagerEquipo = new javax.swing.JComboBox<>();
        btnAñadirJugadoresManager = new javax.swing.JButton();
        btnEliminarJugadorManager = new javax.swing.JButton();
        btnAgregarEquipoManager = new javax.swing.JButton();
        btnEliminarEquipoManager = new javax.swing.JButton();
        btnCertificadoManager = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblManagers = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblJugadorManager = new javax.swing.JTable();
        txtEquipoManager = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        cedulaArbitro = new javax.swing.JLabel();
        nombreArbitro = new javax.swing.JLabel();
        apellidoArbitro = new javax.swing.JLabel();
        edadArbitro = new javax.swing.JLabel();
        arbitroFIFA = new javax.swing.JLabel();
        txtCedulaArbitro = new javax.swing.JTextField();
        txtNombreArbitro = new javax.swing.JTextField();
        txtApellidoArbitro = new javax.swing.JTextField();
        txtEdadArbitro = new javax.swing.JTextField();
        checkArbitroFIfa = new javax.swing.JCheckBox();
        btnAgregarArbitro = new javax.swing.JButton();
        btnBuscarArbitro = new javax.swing.JButton();
        btnActualizarArbitro = new javax.swing.JButton();
        btnEliminarArbitro = new javax.swing.JButton();
        btnLimpiarArbitro = new javax.swing.JButton();
        btnCertificadoArbitro = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblArbitro = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liga");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
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

        btnAgregarRelacionJugadorEquipo.setText("Agregar");
        btnAgregarRelacionJugadorEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRelacionJugadorEquipoActionPerformed(evt);
            }
        });

        btnEliminarRelacionJugadorEquipo.setText("Eliminar");
        btnEliminarRelacionJugadorEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRelacionJugadorEquipoActionPerformed(evt);
            }
        });

        btnAgregarRelacionAficionadoEquipo.setText("Agregar");
        btnAgregarRelacionAficionadoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRelacionAficionadoEquipoActionPerformed(evt);
            }
        });

        btnEliminarRelacionAficionadoEquipo.setText("Eliminar");
        btnEliminarRelacionAficionadoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRelacionAficionadoEquipoActionPerformed(evt);
            }
        });

        jLabel28.setText("Técnico actual:");

        txtMostrarTecnicoEquipo.setEditable(false);

        tblJugadorEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblJugadorEquipo);

        tblAficionadoEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblAficionadoEquipo);

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
                                .addComponent(btnAgregarRelacionJugadorEquipo)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarRelacionJugadorEquipo))))
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
                                .addComponent(btnAgregarRelacionAficionadoEquipo)))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarRelacionAficionadoEquipo))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(243, Short.MAX_VALUE))
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
                    .addComponent(btnAgregarRelacionJugadorEquipo)
                    .addComponent(btnEliminarRelacionJugadorEquipo)
                    .addComponent(jLabel27)
                    .addComponent(cbAficionadoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarRelacionAficionadoEquipo)
                    .addComponent(btnEliminarRelacionAficionadoEquipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Planilla", jPanel14);

        labelTituloListaPartidoEquipo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTituloListaPartidoEquipo.setText("Lista de partidos");

        tblPartidosEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tblPartidosEquipo);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(labelTituloListaPartidoEquipo))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelTituloListaPartidoEquipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Partidos", jPanel15);

        lblJugadorMasJovenEquipo.setText("Jugador más joven: ");

        lblPromEdadJugadoresEquipo.setText("Promedio edad de jugadores: ");

        lblPartidosGoleadaEquipo.setText("Cantidad partidos ganados por goleada: ");

        lblJugadorMasGolesEquipo.setText("Jugador que ha anotado más goles:");

        lblSumaTotalNominaEquipo.setText("Suma total de la nómina:");

        lblArqueroEquipo.setText("Arquero:");

        txtJugadorJovenEquipo.setEditable(false);
        txtJugadorJovenEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJugadorJovenEquipoActionPerformed(evt);
            }
        });

        txtPromedioEdadJugadoresEquipo.setEditable(false);

        txtCantidadPartidosGoleadaEquipo.setEditable(false);

        txtJugadorMasGolesEquipo.setEditable(false);

        txtNominaEquipo.setEditable(false);

        txtArqueroEquipo.setEditable(false);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(lblJugadorMasGolesEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJugadorMasGolesEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(lblSumaTotalNominaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNominaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(lblArqueroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArqueroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJugadorMasJovenEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPromEdadJugadoresEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPartidosGoleadaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadPartidosGoleadaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJugadorJovenEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPromedioEdadJugadoresEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(492, 581, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugadorMasJovenEquipo)
                    .addComponent(txtJugadorJovenEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPromEdadJugadoresEquipo)
                    .addComponent(txtPromedioEdadJugadoresEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPartidosGoleadaEquipo)
                    .addComponent(txtCantidadPartidosGoleadaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugadorMasGolesEquipo)
                    .addComponent(txtJugadorMasGolesEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSumaTotalNominaEquipo)
                    .addComponent(txtNominaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArqueroEquipo)
                    .addComponent(txtArqueroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(333, Short.MAX_VALUE))
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

        lblIdentificadorEstadio.setText("Identificador:");

        lblCiudadEstadio.setText("Ciudad:");

        lblNombreEstadio.setText("Nombre:");

        lblCapacidadEstadio.setText("Capacidad:");

        lblTituloListaEstadios.setText("Lista de estadios");

        tblEstadio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(tblEstadio);

        btnAgregarEstadio.setText("Agregar");
        btnAgregarEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstadioActionPerformed(evt);
            }
        });

        btnBuscarEstadio.setText("Buscar");
        btnBuscarEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstadioActionPerformed(evt);
            }
        });

        btnActualizarEstadio.setText("Actualizar");
        btnActualizarEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEstadioActionPerformed(evt);
            }
        });

        btnEliminarEstadio.setText("Eliminar");
        btnEliminarEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEstadioActionPerformed(evt);
            }
        });

        btnLimpiarEstadio.setText("Limpiar");
        btnLimpiarEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEstadioActionPerformed(evt);
            }
        });

        lblRelacionPartidosEstadio.setText("Partidos: ");

        cbPartidoEstadio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPartidoEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPartidoEstadioActionPerformed(evt);
            }
        });

        btnAgregarRelacionPartidoEstadio.setText("Agregar");
        btnAgregarRelacionPartidoEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRelacionPartidoEstadioActionPerformed(evt);
            }
        });

        btnEliminarRelacionPartidoEstadio.setText("Eliminar");
        btnEliminarRelacionPartidoEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRelacionPartidoEstadioActionPerformed(evt);
            }
        });

        jLabel38.setText("Lista de partidos");

        tblPartidoEstadio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(tblPartidoEstadio);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblIdentificadorEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdentificadorEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCiudadEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCiudadEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCapacidadEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCapacidadEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnAgregarEstadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarEstadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizarEstadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarEstadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarEstadio)))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblRelacionPartidosEstadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPartidoEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarRelacionPartidoEstadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarRelacionPartidoEstadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel38)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblTituloListaEstadios)
                                .addGap(234, 234, 234))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloListaEstadios)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdentificadorEstadio)
                            .addComponent(txtIdentificadorEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCiudadEstadio)
                            .addComponent(txtCiudadEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreEstadio)
                            .addComponent(txtNombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCapacidadEstadio)
                            .addComponent(txtCapacidadEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarEstadio)
                            .addComponent(btnBuscarEstadio)
                            .addComponent(btnActualizarEstadio)
                            .addComponent(btnEliminarEstadio)
                            .addComponent(btnLimpiarEstadio)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRelacionPartidosEstadio)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbPartidoEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarRelacionPartidoEstadio)
                        .addComponent(btnEliminarRelacionPartidoEstadio))
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estadio", jPanel3);

        lblIdentificadorPartido.setText("Identificador:");

        lblFechaPartido.setText("Fecha:");

        btnAgregarPartido.setText("Agregar");
        btnAgregarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPartidoActionPerformed(evt);
            }
        });

        btnBuscarPartido.setText("Buscar");
        btnBuscarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPartidoActionPerformed(evt);
            }
        });

        btnActualizarPartido.setText("Actualizar");
        btnActualizarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPartidoActionPerformed(evt);
            }
        });

        btnEliminarPartido.setText("Eliminar");
        btnEliminarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPartidoActionPerformed(evt);
            }
        });

        btnLimpiarPartido.setText("Limpiar");
        btnLimpiarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPartidoActionPerformed(evt);
            }
        });

        lblTituloListaPartido.setText("Lista de partidos");

        tblPartido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane14.setViewportView(tblPartido);

        lblRelacionArbitroPartido.setText("Árbitro del partido:");

        cbArbitroPartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregarRelacionArbitroPartido.setText("Agregar");
        btnAgregarRelacionArbitroPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRelacionArbitroPartidoActionPerformed(evt);
            }
        });

        btnEliminarRelacionArbitroPartido.setText("Eliminar");
        btnEliminarRelacionArbitroPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRelacionArbitroPartidoActionPerformed(evt);
            }
        });

        txtMostrarArbitroPartido.setEditable(false);

        lblMostraArbitroPartido.setText("Arbitro");

        lblMostraJornadaPartido.setText("Jornada");

        txtMostrarJornadaPartido.setEditable(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(lblFechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(btnAgregarPartido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarPartido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnActualizarPartido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminarPartido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLimpiarPartido))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(lblRelacionArbitroPartido)
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMostrarJornadaPartido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                                .addComponent(cbArbitroPartido, 0, 141, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAgregarRelacionArbitroPartido)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEliminarRelacionArbitroPartido)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMostrarArbitroPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(lblMostraArbitroPartido)
                                        .addGap(75, 75, 75))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(lblMostraJornadaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)))))
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(lblIdentificadorPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdentificadorPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTituloListaPartido)
                        .addGap(207, 207, 207))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentificadorPartido)
                    .addComponent(txtIdentificadorPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloListaPartido))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaPartido)
                            .addComponent(txtFechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarPartido)
                            .addComponent(btnBuscarPartido)
                            .addComponent(btnActualizarPartido)
                            .addComponent(btnEliminarPartido)
                            .addComponent(btnLimpiarPartido))
                        .addGap(35, 35, 35)
                        .addComponent(lblMostraArbitroPartido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRelacionArbitroPartido)
                            .addComponent(cbArbitroPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarRelacionArbitroPartido)
                            .addComponent(btnEliminarRelacionArbitroPartido)
                            .addComponent(txtMostrarArbitroPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(lblMostraJornadaPartido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMostrarJornadaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Partido", jPanel10);

        lblEquipoLocalPartido.setText("Equipo local: ");

        cbEquipoLocalPartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEquipoLocalPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEquipoLocalPartidoActionPerformed(evt);
            }
        });

        lblEquipoLocalSeleccionadoPartido.setText("Equipo");

        txtMostrarEquipoLocal.setEditable(false);

        lblEquipoVisitantePartido.setText("Equipo visitante: ");

        cbEquipoVisitantePartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEquipoVisitanteSeleccionadoPartido.setText("Equipo");

        txtMostrarEquipoVisitante.setEditable(false);

        lblGolesLocalPartido.setText("Goles local: ");

        btnAgregarEquipoLocal.setText("Agregar");
        btnAgregarEquipoLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEquipoLocalActionPerformed(evt);
            }
        });

        lblGolesVisitantePartido.setText("Goles visitante: ");

        lblJugadoresLocalPartido.setText("Jugadores local: ");

        cbJugadorLocalPartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblGolesLocal.setText("Goles: ");

        btnAgregarGolesLocal.setText("Agregar");
        btnAgregarGolesLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarGolesLocalActionPerformed(evt);
            }
        });

        lblJugadoresVisitantePartido.setText("Jugadores visitante: ");

        cbJugadorVisitantePartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblGolesVisitante.setText("Goles: ");

        btnAgregarGolesVisitante.setText("Agregar");
        btnAgregarGolesVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarGolesVisitanteActionPerformed(evt);
            }
        });

        txtGolesLocal.setEditable(false);

        txtGolesVisitante.setEditable(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(lblEquipoLocalSeleccionadoPartido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEquipoVisitanteSeleccionadoPartido)
                .addGap(213, 213, 213))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(lblJugadoresLocalPartido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblGolesLocal))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(cbJugadorLocalPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(spinnerGolesLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAgregarGolesLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGolesLocal)))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEquipoLocalPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGolesLocalPartido))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAgregarEquipoLocal)
                                    .addComponent(cbEquipoLocalPartido, 0, 79, Short.MAX_VALUE)
                                    .addComponent(txtGolesEquipoLocal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMostrarEquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(259, 259, 259)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(lblGolesVisitantePartido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGolesEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(lblEquipoVisitantePartido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbEquipoVisitantePartido, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMostrarEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addComponent(lblJugadoresVisitantePartido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lblGolesVisitante))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(cbJugadorVisitantePartido, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerGolesVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarGolesVisitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGolesVisitante))))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipoLocalSeleccionadoPartido)
                    .addComponent(lblEquipoVisitanteSeleccionadoPartido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipoLocalPartido)
                    .addComponent(cbEquipoLocalPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMostrarEquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEquipoVisitantePartido)
                    .addComponent(cbEquipoVisitantePartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMostrarEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGolesLocalPartido)
                            .addComponent(txtGolesEquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(btnAgregarEquipoLocal)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGolesVisitantePartido)
                            .addComponent(txtGolesEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugadoresLocalPartido)
                    .addComponent(lblGolesLocal)
                    .addComponent(txtGolesLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJugadorLocalPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerGolesLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarGolesLocal))
                .addGap(79, 79, 79)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugadoresVisitantePartido)
                    .addComponent(lblGolesVisitante)
                    .addComponent(txtGolesVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJugadorVisitantePartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerGolesVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarGolesVisitante))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Goles", jPanel17);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Partido", jPanel4);

        NumeroJornada.setText("Número:");

        EsloganJornada.setText("Eslogan:");

        tblJornada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane12.setViewportView(tblJornada);

        btnAgregarJornada.setText("Agregar");
        btnAgregarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJornadaActionPerformed(evt);
            }
        });

        btnActualizarJornada.setText("Actualizar");
        btnActualizarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarJornadaActionPerformed(evt);
            }
        });

        btnBuscarJornada.setText("Buscar");
        btnBuscarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarJornadaActionPerformed(evt);
            }
        });

        btnEliminarJornada.setText("Eliminar");
        btnEliminarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarJornadaActionPerformed(evt);
            }
        });

        btnLimpiarJornada.setText("Limpiar");
        btnLimpiarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarJornadaActionPerformed(evt);
            }
        });

        jLabel42.setText("Partido:");

        cbPartidosJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPartidosJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPartidosJornadaActionPerformed(evt);
            }
        });

        btnAgregarPartidoJornada.setText("Agregar");
        btnAgregarPartidoJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPartidoJornadaActionPerformed(evt);
            }
        });

        btnEliminarPartidoJornada.setText("Eliminar");
        btnEliminarPartidoJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPartidoJornadaActionPerformed(evt);
            }
        });

        ListaJornadas.setText("Lista jornadas");

        ListaPartidosJornada.setText("Lista partidos por jornada");

        tblPartidoJornada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane13.setViewportView(tblPartidoJornada);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NumeroJornada, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(EsloganJornada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumeroJornada, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtEsloganJornada)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(cbPartidosJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnAgregarPartidoJornada)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarPartidoJornada))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnAgregarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarJornada)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizarJornada)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarJornada)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarJornada))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(ListaPartidosJornada)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(ListaJornadas)
                        .addGap(184, 184, 184))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumeroJornada)
                    .addComponent(txtNumeroJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListaJornadas))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EsloganJornada)
                            .addComponent(txtEsloganJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarJornada)
                            .addComponent(btnBuscarJornada)
                            .addComponent(btnActualizarJornada)
                            .addComponent(btnEliminarJornada)
                            .addComponent(btnLimpiarJornada))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(cbPartidosJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarPartidoJornada)
                            .addComponent(btnEliminarPartidoJornada))
                        .addGap(43, 43, 43)
                        .addComponent(ListaPartidosJornada)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(347, Short.MAX_VALUE)
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

        lblJugadorMasJoven.setText("Jugador más joven de la liga:");

        txtJugadorMasJoven.setEditable(false);

        lblGoleadorLiga.setText("Goleador de la liga:");

        txtGoleadorLiga.setEditable(false);

        jLabel44.setText("Equipo más caro de la liga:");

        txtEquipoMasCaro.setEditable(false);

        jLabel45.setText("Equipo con mayor cantidad de aficionados:");

        txtEquipoMayorCantidadAficionados.setEditable(false);

        lblVallaMenosVendia.setText("Valla menos vencida de la liga:");

        txtVallaMenosVencida.setEditable(false);

        lblEstadioMasGoles.setText("Nombre de estadio en el que se han hecho más goles:");

        txtNombreEstadioMasgoles.setEditable(false);

        lblIdPartidoMasGoles.setText("Identificador del partido en el que se hicieron más goles:");

        txtIDPartidoMasGoles.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIdPartidoMasGoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45)
                    .addComponent(lblJugadorMasJoven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGoleadorLiga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVallaMenosVendia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEstadioMasGoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtJugadorMasJoven)
                    .addComponent(txtGoleadorLiga)
                    .addComponent(txtEquipoMasCaro, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(txtEquipoMayorCantidadAficionados)
                    .addComponent(txtVallaMenosVencida)
                    .addComponent(txtNombreEstadioMasgoles)
                    .addComponent(txtIDPartidoMasGoles))
                .addContainerGap(568, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJugadorMasJoven)
                            .addComponent(txtJugadorMasJoven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGoleadorLiga)
                            .addComponent(txtGoleadorLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtEquipoMasCaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel45))
                    .addComponent(txtEquipoMayorCantidadAficionados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVallaMenosVendia)
                    .addComponent(txtVallaMenosVencida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadioMasGoles)
                    .addComponent(txtNombreEstadioMasgoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPartidoMasGoles)
                    .addComponent(txtIDPartidoMasGoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(307, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", jPanel7);

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

        labelTituloTablaTecnico.setText("Lista de técnicos");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelTituloTablaTecnico)
                .addGap(195, 195, 195))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelTituloTablaTecnico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
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

        labelTituloListaAficionados.setText("Lista de aficionados");

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
                                .addComponent(checkAbonoAficionado)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(btnAgregarAficionado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscarAficionado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnActualizarAficionado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEliminarAficionado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnLimpiarAficionado)))
                    .addComponent(btnCertificadoAficionado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTituloListaAficionados)
                .addGap(178, 178, 178))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTituloListaAficionados)
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Aficionado", jPanel9);

        jLabel29.setText("Cédula:");

        jLabel30.setText("Nombre:");

        jLabel31.setText("Apellido:");

        jLabel32.setText("Edad:");

        jLabel33.setText("Nacionalidad:");

        jLabel34.setText("Salario:");

        jLabel35.setText("Goles marcados:");

        jLabel36.setText("Posición:");

        txtGolesJugador.setEditable(false);

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

        lblEquipoJugador.setText("Equipo");

        txtEquipoJugador.setEditable(false);

        btnLimpiarJugador.setText("Limpiar");
        btnLimpiarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarJugadorActionPerformed(evt);
            }
        });

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
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEquipoJugador))
                        .addGap(28, 28, 28)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedulaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(txtNombreJugador)
                            .addComponent(txtApellidoJugador)
                            .addComponent(txtEdadJugador)
                            .addComponent(txtNacionalidadJugador)
                            .addComponent(txtSalarioJugador)
                            .addComponent(txtPosicionJugador)
                            .addComponent(txtGolesJugador)
                            .addComponent(txtEquipoJugador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(274, 274, 274))))
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
                        .addComponent(btnEliminarJugador)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiarJugador)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
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
                            .addComponent(txtPosicionJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtGolesJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEquipoJugador)
                            .addComponent(txtEquipoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarJugador)
                            .addComponent(btnBuscarJugador)
                            .addComponent(btnActualizarJugador)
                            .addComponent(btnEliminarJugador)
                            .addComponent(btnLimpiarJugador))
                        .addGap(18, 18, 18)
                        .addComponent(btnCertificadoJugador))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Jugador", Jpanel);

        lblCedulaManager.setText("Cédula: ");

        lblNombreManager.setText("Nombre: ");

        lblApellidoManager.setText("Apellido:");

        lblEdadManager.setText("Edad:");

        lblAfiliacionManager.setText("Años de afiliación:");

        btnAgregarManager.setText("Agregar");
        btnAgregarManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarManagerActionPerformed(evt);
            }
        });

        btnBuscarManager.setText("Buscar");
        btnBuscarManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarManagerActionPerformed(evt);
            }
        });

        btnActualizarManager.setText("Actualizar");
        btnActualizarManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarManagerActionPerformed(evt);
            }
        });

        btnEliminarManager.setText("Eliminar");
        btnEliminarManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarManagerActionPerformed(evt);
            }
        });

        btnLimpiarManager.setText("Limpiar");
        btnLimpiarManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarManagerActionPerformed(evt);
            }
        });

        lblJugadoresManager.setText("Jugadores:");

        cbManagerJugadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEquipoManager.setText("Equipo:");

        cbManagerEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAñadirJugadoresManager.setText("Agregar");
        btnAñadirJugadoresManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirJugadoresManagerActionPerformed(evt);
            }
        });

        btnEliminarJugadorManager.setText("Eliminar");
        btnEliminarJugadorManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarJugadorManagerActionPerformed(evt);
            }
        });

        btnAgregarEquipoManager.setText("Agregar");
        btnAgregarEquipoManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEquipoManagerActionPerformed(evt);
            }
        });

        btnEliminarEquipoManager.setText("Eliminar");
        btnEliminarEquipoManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEquipoManagerActionPerformed(evt);
            }
        });

        btnCertificadoManager.setText("Generar certificado");
        btnCertificadoManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoManagerActionPerformed(evt);
            }
        });

        jLabel40.setText("Lista managers");

        tblManagers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane15.setViewportView(tblManagers);

        jLabel41.setText("Lista jugadores");

        tblJugadorManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane16.setViewportView(tblJugadorManager);

        txtEquipoManager.setEditable(false);

        jLabel43.setText("Equipo");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addGap(202, 202, 202))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAfiliacionManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEdadManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblApellidoManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNombreManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCedulaManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCedulaManager)
                                    .addComponent(txtApellidoManager, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtNombreManager, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtEdadManager)
                                    .addComponent(txtAfiliacionManager)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(btnAgregarManager)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarManager)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizarManager)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarManager)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarManager))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblEquipoManager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblJugadoresManager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(cbManagerJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAñadirJugadoresManager)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminarJugadorManager))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(cbManagerEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addComponent(btnAgregarEquipoManager)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnEliminarEquipoManager))
                                            .addComponent(btnCertificadoManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(txtEquipoManager, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(jLabel43)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(173, 173, 173))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedulaManager)
                            .addComponent(txtCedulaManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreManager)
                            .addComponent(txtNombreManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellidoManager)
                            .addComponent(txtApellidoManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEdadManager)
                            .addComponent(txtEdadManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAfiliacionManager)
                            .addComponent(txtAfiliacionManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarManager)
                            .addComponent(btnBuscarManager)
                            .addComponent(btnActualizarManager)
                            .addComponent(btnEliminarManager)
                            .addComponent(btnLimpiarManager)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabel41)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJugadoresManager)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbManagerJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAñadirJugadoresManager)
                                .addComponent(btnEliminarJugadorManager)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEquipoManager)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbManagerEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgregarEquipoManager)
                                .addComponent(btnEliminarEquipoManager)
                                .addComponent(jLabel43)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCertificadoManager)
                            .addComponent(txtEquipoManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Manager", jPanel11);

        cedulaArbitro.setText("Cédula:");

        nombreArbitro.setText("Nombre:");

        apellidoArbitro.setText("Apellido:");

        edadArbitro.setText("Edad:");

        arbitroFIFA.setText("Árbitro FIFA:");

        txtCedulaArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaArbitroActionPerformed(evt);
            }
        });

        btnAgregarArbitro.setText("Agregar");
        btnAgregarArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArbitroActionPerformed(evt);
            }
        });

        btnBuscarArbitro.setText("Buscar");
        btnBuscarArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArbitroActionPerformed(evt);
            }
        });

        btnActualizarArbitro.setText("Actualizar");
        btnActualizarArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarArbitroActionPerformed(evt);
            }
        });

        btnEliminarArbitro.setText("Eliminar");
        btnEliminarArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArbitroActionPerformed(evt);
            }
        });

        btnLimpiarArbitro.setText("Limpiar");
        btnLimpiarArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarArbitroActionPerformed(evt);
            }
        });

        btnCertificadoArbitro.setText("Generar certificado");
        btnCertificadoArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoArbitroActionPerformed(evt);
            }
        });

        tblArbitro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(tblArbitro);

        jLabel39.setText("Lista árbitro");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnCertificadoArbitro)
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(btnAgregarArbitro)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarArbitro)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizarArbitro)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarArbitro)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarArbitro))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(arbitroFIFA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edadArbitro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(apellidoArbitro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombreArbitro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cedulaArbitro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(checkArbitroFIfa)
                                    .addComponent(txtCedulaArbitro, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtNombreArbitro)
                                    .addComponent(txtApellidoArbitro)
                                    .addComponent(txtEdadArbitro))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(144, 144, 144))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(246, 246, 246))))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cedulaArbitro)
                            .addComponent(txtCedulaArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel39)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreArbitro)
                            .addComponent(txtNombreArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoArbitro)
                            .addComponent(txtApellidoArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edadArbitro)
                            .addComponent(txtEdadArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(arbitroFIFA)
                            .addComponent(checkArbitroFIfa))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarArbitro)
                            .addComponent(btnBuscarArbitro)
                            .addComponent(btnActualizarArbitro)
                            .addComponent(btnEliminarArbitro)
                            .addComponent(btnLimpiarArbitro)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnCertificadoArbitro)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Árbitro", jPanel12);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1013, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addGap(414, 414, 414))
        );

        jTabbedPane1.addTab("Persona", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            this.actualizarComboTecnicoEquipo();
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
                //Eliminar al técnico de las relaciones:
                Tecnico tecnico = (Tecnico) buscarPersona;
                //Eliminar el tecnico de la relación con el equipo
                tecnico.getMiEquipo().setTecnico(null);
                this.actualizarComboTecnicoEquipo();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un técnico");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaTecnicos();
        this.limpiarCajas();
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
            this.actualizarComboAficionadoEquipo();
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
                Aficionado aficionado = (Aficionado) buscarPersona;
                //Eliminar el jugador de la relación con equipo
                aficionado.getMiEquipo().getMisAficionados().remove(aficionado);
                this.actualizarComboAficionadoEquipo();
                this.actualizarTablaAficionado();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un aficionado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.limpiarCajas();
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
                String contenido = tecnico.encabezadoCertificado() + tecnico.cuerpoCertificado() + tecnico.finalCertificado();
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
                String contenido = aficionado.encabezadoCertificado() + aficionado.cuerpoCertificado() + aficionado.finalCertificado();
                this.guardarArchivo(contenido, "doc");
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un aficionado");
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
            this.tablaPosiciones();
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

            //Sección planilla
            this.txtMostrarTecnicoEquipo.setText(this.personaAsignada(equipoEncontrado.getTecnico()));
            this.actualizarTablaJugadoresEquipo(identificador);
            this.actualizarTablaAficionadosEquipo(identificador);
            this.actualizarTablaPartidosEquipo(identificador);

            //Sección reportes
            if (equipoEncontrado.getMisJugadores().size() > 0) {
                this.txtJugadorJovenEquipo.setText(equipoEncontrado.jugadorMasJoven().getNombre());
                this.txtPromedioEdadJugadoresEquipo.setText("" + equipoEncontrado.promEdad());
                this.txtCantidadPartidosGoleadaEquipo.setText("" + equipoEncontrado.cantPartidosGoleada());
                this.txtJugadorMasGolesEquipo.setText(equipoEncontrado.jugadorMayorGoles().getNombre());
                this.txtNominaEquipo.setText("$" + equipoEncontrado.totalNomina());
                this.txtArqueroEquipo.setText(equipoEncontrado.getArquero().getNombre());
            } else {
                this.txtJugadorJovenEquipo.setText("");
                this.txtPromedioEdadJugadoresEquipo.setText("");
                this.txtCantidadPartidosGoleadaEquipo.setText("");
                this.txtJugadorMasGolesEquipo.setText("");
                this.txtNominaEquipo.setText("");
                this.txtArqueroEquipo.setText("");
            }

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
        } else {
            JOptionPane.showMessageDialog(this, "El identificador ingresado es erróneo");
        }
    }//GEN-LAST:event_btnActualizarEquipoActionPerformed

    private void btnEliminarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEquipoActionPerformed
        String identificador = JOptionPane.showInputDialog(this, "Ingrese el identificador del equipo que desea eliminar");
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            this.miLiga.eliminarEquipo(equipoEncontrado);
            JOptionPane.showMessageDialog(this, "El equipo " + equipoEncontrado.getNombre() + " se ha eliminado");
            this.actualizarTablaEquipo();
            this.tablaPosiciones();
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
    public void actualizarComboTecnicoEquipo() {
        this.cbTecnicoEquipo.removeAllItems();
        for (Persona actual : this.miLiga.getMisPersonas()) {
            if (actual instanceof Tecnico) {
                if (((Tecnico) actual).getMiEquipo() == null) {
                    this.cbTecnicoEquipo.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Disponible");
                } else {
                    this.cbTecnicoEquipo.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Asignado");
                }
            }
        }
    }

    public void actualizarComboJugadorEquipo() {
        this.cbJugadorEquipo.removeAllItems();
        for (Persona actual : this.miLiga.getMisPersonas()) {
            if (actual instanceof Jugador) {
                if (((Jugador) actual).getMiEquipo() == null) {
                    this.cbJugadorEquipo.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Disponible");
                } else {
                    this.cbJugadorEquipo.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Asignado");
                }
            }
        }
    }

    public void actualizarComboAficionadoEquipo() {
        this.cbAficionadoEquipo.removeAllItems();
        for (Persona actual : this.miLiga.getMisPersonas()) {
            if (actual instanceof Aficionado) {
                if (((Aficionado) actual).getMiEquipo() == null) {
                    this.cbAficionadoEquipo.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Disponible");
                } else {
                    this.cbAficionadoEquipo.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Asignado");
                }
            }
        }
    }

    public void actualizarTablaJugadoresEquipo(String identificador) {
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "Edad", "Nacionalidad", "Posición", "Goles", "Salario"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblJugadorEquipo.setModel(miModelo);
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            LinkedList<Jugador> lista = equipoEncontrado.getMisJugadores();
            for (Jugador actual : lista) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = actual.getCedula();
                fila[1] = actual.getNombre();
                fila[2] = actual.getApellido();
                fila[3] = "" + actual.getEdad();
                fila[4] = "" + actual.getNacionalidad();
                fila[5] = "" + actual.getPosicion();
                fila[6] = "" + actual.getGolesMarcados();
                fila[7] = "" + actual.getSalario();
                miModelo.addRow(fila);
            }
        } else {
            miModelo.setRowCount(0);
        }

    }

    public void actualizarTablaPartidosEquipo(String identificador) {
        String nombreColumnas[] = {"Identificador", "Fecha", "Goles local", "Goles visitante"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblPartidosEquipo.setModel(miModelo);
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            LinkedList<Partido> lista = equipoEncontrado.getMisPartidos();
            for (Partido actual : lista) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = actual.getId();
                fila[1] = actual.getFecha();
                fila[2] = "" + actual.getGolesLocal();
                fila[3] = "" + actual.getGolesVisitante();
                miModelo.addRow(fila);
            }
        } else {
            miModelo.setRowCount(0);
        }

    }

    public void actualizarTablaAficionadosEquipo(String identificador) {
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "Fidelidad", "Abono"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblAficionadoEquipo.setModel(miModelo);
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            LinkedList<Aficionado> lista = equipoEncontrado.getMisAficionados();
            for (Aficionado actual : lista) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = actual.getCedula();
                fila[1] = actual.getNombre();
                fila[2] = actual.getApellido();
                fila[3] = "" + actual.getEdad();
                fila[4] = "" + actual.getAniosFidelidad();
                fila[5] = "" + actual.isAbono();
                miModelo.addRow(fila);
            }
        } else {
            miModelo.setRowCount(0);
        }

    }

    private void btnAgregarRelacionTecnicoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRelacionTecnicoEquipoActionPerformed
        String identificador = this.txtIdentificadorEquipo.getText();
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            String seleccion = (String) this.cbTecnicoEquipo.getSelectedItem();
            String cedula = seleccion.split(" - ")[0];
            Tecnico tecnicoEncontrado = (Tecnico) this.miLiga.buscarPersona(cedula);
            if (equipoEncontrado.getTecnico() == null) {
                if (tecnicoEncontrado.getMiEquipo() == null) {
                    equipoEncontrado.setTecnico(tecnicoEncontrado);
                    tecnicoEncontrado.setMiEquipo(equipoEncontrado);
                    JOptionPane.showMessageDialog(this, "Se ha asociado correctamente el técnico " + tecnicoEncontrado.getNombre() + " con el equipo " + equipoEncontrado.getNombre());
                    this.txtMostrarTecnicoEquipo.setText(tecnicoEncontrado.getNombre());
                    this.actualizarComboTecnicoEquipo();
                } else {
                    JOptionPane.showMessageDialog(this, "El tecnico seleccionado se encuentra asociado a un equipo actualmente");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Antes de asociar un técnico, elimine el que está asociado actualmente al equipo");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El identificador de equipo ingresado es erróneo");
        }
    }//GEN-LAST:event_btnAgregarRelacionTecnicoEquipoActionPerformed

    private void btnEliminarRelacionTecnicoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRelacionTecnicoEquipoActionPerformed
        String identificador = this.txtIdentificadorEquipo.getText();
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            String seleccion = (String) this.cbTecnicoEquipo.getSelectedItem();
            String cedula = seleccion.split(" - ")[0];
            Tecnico tecnicoEncontrado = (Tecnico) this.miLiga.buscarPersona(cedula);
            if (tecnicoEncontrado.equals(equipoEncontrado.getTecnico())) {
                equipoEncontrado.setTecnico(null);
                tecnicoEncontrado.setMiEquipo(null);
                JOptionPane.showMessageDialog(this, "Se ha desasociado correctamente el técnico " + tecnicoEncontrado.getNombre() + " del equipo " + equipoEncontrado.getNombre());

                this.actualizarComboTecnicoEquipo();
                this.txtMostrarTecnicoEquipo.setText("No asignado");
            } else {
                JOptionPane.showMessageDialog(this, "Ese técnico no está asociado con el equipo seleccionado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "El identificador de equipo ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarRelacionTecnicoEquipoActionPerformed

    private void btnAgregarRelacionJugadorEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRelacionJugadorEquipoActionPerformed
        String identificador = this.txtIdentificadorEquipo.getText();
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            String seleccion = (String) this.cbJugadorEquipo.getSelectedItem();
            String cedula = seleccion.split(" - ")[0];
            Jugador jugadorEncontrado = (Jugador) this.miLiga.buscarPersona(cedula);
            if (jugadorEncontrado.getMiEquipo() == null) {
                equipoEncontrado.getMisJugadores().add(jugadorEncontrado);
                jugadorEncontrado.setMiEquipo(equipoEncontrado);
                JOptionPane.showMessageDialog(this, "Se ha asociado correctamente el jugador " + jugadorEncontrado.getNombre() + " con el equipo " + equipoEncontrado.getNombre());
                this.actualizarTablaJugadoresEquipo(identificador);
                this.actualizarComboJugadorEquipo();
            } else {
                JOptionPane.showMessageDialog(this, "El jugador seleccionado se encuentra asociado a un equipo actualmente");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El identificador de equipo ingresado es erróneo");
        }
    }//GEN-LAST:event_btnAgregarRelacionJugadorEquipoActionPerformed

    private void btnEliminarRelacionJugadorEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRelacionJugadorEquipoActionPerformed
        String identificador = this.txtIdentificadorEquipo.getText();
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            String seleccion = (String) this.cbJugadorEquipo.getSelectedItem();
            String cedula = seleccion.split(" - ")[0];
            Jugador jugadorEncontrado = (Jugador) this.miLiga.buscarPersona(cedula);

            if (this.buscarJugadorEquipo(jugadorEncontrado, equipoEncontrado)) {
                equipoEncontrado.getMisJugadores().remove(jugadorEncontrado);
                jugadorEncontrado.setMiEquipo(null);
                JOptionPane.showMessageDialog(this, "Se ha desasociado correctamente el jugador " + jugadorEncontrado.getNombre() + " del equipo " + equipoEncontrado.getNombre());
                this.actualizarTablaJugadoresEquipo(identificador);
                this.actualizarComboJugadorEquipo();
            } else {
                JOptionPane.showMessageDialog(this, "El jugador seleccionado no hace parte del equipo elegido");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El identificador de equipo ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarRelacionJugadorEquipoActionPerformed

    private void btnAgregarRelacionAficionadoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRelacionAficionadoEquipoActionPerformed
        String identificador = this.txtIdentificadorEquipo.getText();
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            String seleccion = (String) this.cbAficionadoEquipo.getSelectedItem();
            String cedula = seleccion.split(" - ")[0];
            Aficionado aficionadoEncontrado = (Aficionado) this.miLiga.buscarPersona(cedula);
            if (aficionadoEncontrado.getMiEquipo() == null) {
                equipoEncontrado.getMisAficionados().add(aficionadoEncontrado);
                aficionadoEncontrado.setMiEquipo(equipoEncontrado);
                JOptionPane.showMessageDialog(this, "Se ha asociado correctamente el aficionado " + aficionadoEncontrado.getNombre() + " con el equipo " + equipoEncontrado.getNombre());
                this.actualizarTablaAficionadosEquipo(identificador);
                this.actualizarComboAficionadoEquipo();
            } else {
                JOptionPane.showMessageDialog(this, "El aficionado seleccionado se encuentra asociado a un equipo actualmente");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El identificador de equipo ingresado es erróneo");
        }
    }//GEN-LAST:event_btnAgregarRelacionAficionadoEquipoActionPerformed

    private void btnEliminarRelacionAficionadoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRelacionAficionadoEquipoActionPerformed
        String identificador = this.txtIdentificadorEquipo.getText();
        Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificador);
        if (equipoEncontrado != null) {
            String seleccion = (String) this.cbAficionadoEquipo.getSelectedItem();
            String cedula = seleccion.split(" - ")[0];
            Aficionado aficionadoEncontrado = (Aficionado) this.miLiga.buscarPersona(cedula);

            if (this.buscarAficionadoEquipo(aficionadoEncontrado, equipoEncontrado)) {
                equipoEncontrado.getMisAficionados().remove(aficionadoEncontrado);
                aficionadoEncontrado.setMiEquipo(null);
                JOptionPane.showMessageDialog(this, "Se ha desasociado correctamente el aficionado " + aficionadoEncontrado.getNombre() + " del equipo " + equipoEncontrado.getNombre());
                this.actualizarTablaAficionadosEquipo(identificador);
                this.actualizarComboAficionadoEquipo();
            } else {
                JOptionPane.showMessageDialog(this, "El aficionado seleccionado no hace parte del equipo elegido");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El identificador de equipo ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarRelacionAficionadoEquipoActionPerformed

    //===================
    //===================
    //SECCIÓN PERSONA->JUGADOR
    private void btnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJugadorActionPerformed
        String cedula = this.txtCedulaJugador.getText();
        Persona persona = this.miLiga.buscarPersona(cedula);
        if (persona == null) {
            String nombre = this.txtNombreJugador.getText();
            String apellido = this.txtApellidoJugador.getText();
            int edad = Integer.parseInt(this.txtEdadJugador.getText());
            String nacionalidad = this.txtNacionalidadJugador.getText();
            int salario = Integer.parseInt(this.txtSalarioJugador.getText());
            String posicion = this.txtPosicionJugador.getText();
            Jugador jugador = new Jugador(cedula, nombre, apellido, edad, nacionalidad, posicion, 0, salario);
            this.miLiga.getMisPersonas().add(jugador);
            JOptionPane.showMessageDialog(this, "Se agregó el jugador " + nombre);
            this.actualizarComboJugadorEquipo();
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
                Jugador jugador = (Jugador) buscarPersona;
                String nombre = this.txtNombreJugador.getText();
                String apellido = this.txtApellidoJugador.getText();
                int edad = Integer.parseInt(this.txtEdadJugador.getText());
                String nacionalidad = this.txtNacionalidadJugador.getText();
                int salario = Integer.parseInt(this.txtSalarioJugador.getText());
                String posicion = this.txtPosicionJugador.getText();
                jugador.setNombre(nombre);
                jugador.setApellido(apellido);
                jugador.setEdad(edad);
                jugador.setNacionalidad(nacionalidad);
                jugador.setSalario(salario);
                jugador.setPosicion(posicion);
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
                Jugador jugador = (Jugador) buscarPersona;
                this.txtCedulaJugador.setText(jugador.getCedula());
                this.txtNombreJugador.setText(jugador.getNombre());
                this.txtApellidoJugador.setText(jugador.getApellido());
                this.txtEdadJugador.setText("" + jugador.getEdad());
                this.txtNacionalidadJugador.setText("" + jugador.getNacionalidad());
                this.txtSalarioJugador.setText("" + jugador.getSalario());
                this.txtGolesJugador.setText("" + jugador.getGolesMarcados());
                this.txtPosicionJugador.setText(jugador.getPosicion());
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
                Jugador jugador = (Jugador) buscarPersona;
                //Eliminar el jugador de la relación con equipo
                jugador.getMiEquipo().getMisJugadores().remove(jugador);
                this.actualizarComboJugadorEquipo();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un jugador");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaJugador();
        this.limpiarCajas();
    }//GEN-LAST:event_btnEliminarJugadorActionPerformed

    private void btnCertificadoJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoJugadorActionPerformed
        String cedula = this.txtCedulaJugador.getText();
        Persona buscarPersona = this.miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Jugador) {
                Jugador jugador = (Jugador) buscarPersona;
                String contenido = jugador.encabezadoCertificado() + jugador.cuerpoCertificado() + jugador.finalCertificado();
                this.guardarArchivo(contenido, "doc");
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un jugador");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnCertificadoJugadorActionPerformed
    //========================================================
    //========================================================
    //Sección estadios
    private void btnAgregarEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEstadioActionPerformed
        String identificador = this.txtIdentificadorEstadio.getText();
        Estadio estadioEncontrado = this.miLiga.buscarEstadio(identificador);
        if (estadioEncontrado == null) {
            String ciudad = this.txtCiudadEstadio.getText();
            String nombre = this.txtNombreEstadio.getText();
            int capacidad = Integer.parseInt(this.txtCapacidadEstadio.getText());
            Estadio estadioCrear = new Estadio(identificador, ciudad, nombre, capacidad);
            this.miLiga.getMisEstadios().add(estadioCrear);
            JOptionPane.showMessageDialog(this, "El estadio " + nombre + " ha sido creado");
            this.actualizarTablaEstadio();
        } else {
            JOptionPane.showMessageDialog(this, "Ya existe un estadio con esa ID");
        }
        this.limpiarCajas();
    }//GEN-LAST:event_btnAgregarEstadioActionPerformed

    private void btnBuscarEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstadioActionPerformed
        String identificador = JOptionPane.showInputDialog(this, "Ingrese el identificador del estadio");
        Estadio estadioEncontrado = this.miLiga.buscarEstadio(identificador);
        if (estadioEncontrado != null) {
            this.txtIdentificadorEstadio.setEditable(false);
            this.txtIdentificadorEstadio.setText(estadioEncontrado.getId());
            this.txtCiudadEstadio.setText(estadioEncontrado.getCiudad());
            this.txtNombreEstadio.setText(estadioEncontrado.getNombre());
            this.txtCapacidadEstadio.setText("" + estadioEncontrado.getCapacidad());
            this.actualizarTablaPartidoEstadio(identificador);
        } else {
            JOptionPane.showMessageDialog(this, "El identificador ingresado es erróneo");
        }
    }//GEN-LAST:event_btnBuscarEstadioActionPerformed

    private void btnActualizarEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEstadioActionPerformed
        String identificador = this.txtIdentificadorEstadio.getText();
        Estadio estadioEncontrado = this.miLiga.buscarEstadio(identificador);
        if (estadioEncontrado != null) {
            String ciudad = this.txtCiudadEstadio.getText();
            String nombre = this.txtNombreEstadio.getText();
            int capacidad = Integer.parseInt(this.txtCapacidadEstadio.getText());
            estadioEncontrado.setCiudad(ciudad);
            estadioEncontrado.setNombre(nombre);
            estadioEncontrado.setCapacidad(capacidad);
            JOptionPane.showMessageDialog(this, "El estadio " + nombre + " ha sido actualizado");
            this.actualizarTablaEstadio();
            this.txtIdentificadorEstadio.setEditable(true);
        } else {
            JOptionPane.showMessageDialog(this, "El identificador ingresado es erróneo");
        }
        this.limpiarCajas();
    }//GEN-LAST:event_btnActualizarEstadioActionPerformed

    private void btnEliminarEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEstadioActionPerformed
        String identificador = JOptionPane.showInputDialog(this, "Ingrese el identificador del estadio");
        Estadio estadioEncontrado = this.miLiga.buscarEstadio(identificador);
        if (estadioEncontrado != null) {
            this.miLiga.getMisEstadios().remove(estadioEncontrado);
            JOptionPane.showMessageDialog(this, "Se ha eliminado el estadio " + estadioEncontrado.getNombre());
            this.actualizarTablaEstadio();
            this.limpiarCajas();
        } else {
            JOptionPane.showMessageDialog(this, "El identificador ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarEstadioActionPerformed

    private void btnLimpiarEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEstadioActionPerformed
        this.limpiarCajas();
        this.txtIdentificadorEstadio.setEditable(true);
    }//GEN-LAST:event_btnLimpiarEstadioActionPerformed

    private void actualizarTablaEstadio() {
        String nombreColumnas[] = {"Id", "Ciudad", "Nombre", "Capacidad"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblEstadio.setModel(miModelo);
        LinkedList<Estadio> lista = this.miLiga.getMisEstadios();
        for (Estadio actual : lista) {
            String fila[] = new String[nombreColumnas.length];
            fila[0] = actual.getId();
            fila[1] = actual.getCiudad();
            fila[2] = actual.getNombre();
            fila[3] = "" + actual.getCapacidad();
            miModelo.addRow(fila);
        }
    }
    //RELACIONES ESTADIO

    public void actualizarComboPartidoEstadio() {
        this.cbPartidoEstadio.removeAllItems();
        for (Partido partido : this.miLiga.getMisPartidos()) {
            if (partido.getMiEstadio() == null) {
                this.cbPartidoEstadio.addItem(partido.getId() + " - " + partido.getFecha() + " - Disponible");
            } else {
                this.cbPartidoEstadio.addItem(partido.getId() + " - " + partido.getFecha() + " - Asignado");
            }

        }
    }

    public void actualizarTablaPartidoEstadio(String identificador) {
        String nombreColumnas[] = {"Id", "Fecha", "Goles local", "Goles visitante"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblPartidoEstadio.setModel(miModelo);
        Estadio estadioEncontrado = this.miLiga.buscarEstadio(identificador);
        if (estadioEncontrado != null) {
            LinkedList<Partido> lista = estadioEncontrado.getMisPartidos();
            for (Partido actual : lista) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = actual.getId();
                fila[1] = actual.getFecha();
                fila[2] = "" + actual.getGolesLocal();
                fila[3] = "" + actual.getGolesVisitante();
                miModelo.addRow(fila);
            }
        } else {
            miModelo.setRowCount(0);
        }

    }

    private void btnAgregarRelacionPartidoEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRelacionPartidoEstadioActionPerformed
        String identificador = this.txtIdentificadorEstadio.getText();
        Estadio estadioEncontrado = this.miLiga.buscarEstadio(identificador);
        if (estadioEncontrado != null) {

            int indice = this.cbPartidoEstadio.getSelectedIndex();
            Partido seleccionado = this.miLiga.getMisPartidos().get(indice);
            if (seleccionado.getMiEstadio() == null) {
                estadioEncontrado.getMisPartidos().add(seleccionado);
                seleccionado.setMiEstadio(estadioEncontrado);
                JOptionPane.showMessageDialog(this, "Se ha asociado el partido de ID " + seleccionado.getId() + " con el estadio " + estadioEncontrado.getNombre());
                this.actualizarTablaPartidoEstadio(identificador);
                this.actualizarComboPartidoEstadio();
            } else {
                JOptionPane.showMessageDialog(this, "El partido seleccionado ya está asignado");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El ID de estadio ingresado es erróneo");
        }
    }//GEN-LAST:event_btnAgregarRelacionPartidoEstadioActionPerformed

    private void btnEliminarRelacionPartidoEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRelacionPartidoEstadioActionPerformed
        String identificador = this.txtIdentificadorEstadio.getText();
        Estadio estadioEncontrado = this.miLiga.buscarEstadio(identificador);
        if (estadioEncontrado != null) {
            int indice = this.cbPartidoEstadio.getSelectedIndex();
            Partido seleccionado = this.miLiga.getMisPartidos().get(indice);
            if (this.buscarPartidoEstadio(seleccionado, estadioEncontrado)) {
                estadioEncontrado.getMisPartidos().remove(seleccionado);
                seleccionado.setMiEstadio(null);
                JOptionPane.showMessageDialog(this, "Se ha desasociado el partido de ID " + seleccionado.getId() + " del estadio " + estadioEncontrado.getNombre());
                this.actualizarTablaPartidoEstadio(identificador);
                this.actualizarComboPartidoEstadio();
            } else {
                JOptionPane.showMessageDialog(this, "El partido seleccionado, no está asociado con el estadio");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El ID de estadio ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarRelacionPartidoEstadioActionPerformed

    private void btnLimpiarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarJugadorActionPerformed
        this.txtCedulaJugador.setEditable(true);
        limpiarCajas();
    }//GEN-LAST:event_btnLimpiarJugadorActionPerformed

    //SECCION PERSONAS -> ARBITRO
    private void txtCedulaArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaArbitroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaArbitroActionPerformed

    private void btnAgregarArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArbitroActionPerformed
        String cedula = this.txtCedulaArbitro.getText();
        Persona persona = this.miLiga.buscarPersona(cedula);
        if (persona == null) {
            String nombre = this.txtNombreArbitro.getText();
            String apellido = this.txtApellidoArbitro.getText();
            int edad = Integer.parseInt(this.txtEdadArbitro.getText());
            boolean FIFA = this.checkArbitroFIfa.isSelected();
            Arbitro arbitro = new Arbitro(cedula, nombre, apellido, edad, FIFA);
            this.miLiga.getMisPersonas().add(arbitro);
            JOptionPane.showMessageDialog(this, "Se agregó el arbitro " + nombre);
            this.actualizarComboArbitroPartido();
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una persona con esa cédula");
        }

        this.limpiarCajas();
        this.actualizarTablaArbitro();
    }//GEN-LAST:event_btnAgregarArbitroActionPerformed

    private void btnBuscarArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArbitroActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cedula del arbitro que desea buscar");
        Persona buscarpersona = this.miLiga.buscarPersona(cedula);
        if (buscarpersona != null) {
            if (buscarpersona instanceof Arbitro) {
                this.txtCedulaArbitro.setEditable(false);
                Arbitro arbitro = (Arbitro) buscarpersona;
                this.txtCedulaArbitro.setText(arbitro.getCedula());
                this.txtNombreArbitro.setText(arbitro.getNombre());
                this.txtApellidoArbitro.setText(arbitro.getApellido());
                this.txtEdadArbitro.setText("" + arbitro.getEdad());
                this.checkArbitroFIfa.setSelected(arbitro.isFifa());
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un árbitro");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnBuscarArbitroActionPerformed

    private void btnActualizarArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarArbitroActionPerformed
        String cedula = this.txtCedulaArbitro.getText();
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Arbitro) {
                Arbitro arbitro = (Arbitro) buscarPersona;
                String nombre = this.txtNombreArbitro.getText();
                String apellido = this.txtApellidoArbitro.getText();
                int edad = Integer.parseInt(this.txtEdadArbitro.getText());
                boolean FIFA = this.checkArbitroFIfa.isSelected();
                arbitro.setNombre(nombre);
                arbitro.setApellido(apellido);
                arbitro.setEdad(edad);
                arbitro.setFifa(FIFA);
                JOptionPane.showMessageDialog(this, "Se actualizó el árbitro de cédula " + cedula);
                this.actualizarTablaArbitro();
                this.txtCedulaArbitro.setEditable(true);
                this.limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un árbitro");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnActualizarArbitroActionPerformed

    private void btnEliminarArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArbitroActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del árbitro que desea eliminar");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Arbitro) {
                this.miLiga.getMisPersonas().remove(buscarPersona);
                JOptionPane.showMessageDialog(this, "El árbitro de cédula " + cedula + " se eliminó");
                this.actualizarComboArbitroPartido();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un árbitro");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaArbitro();
        this.limpiarCajas();
    }//GEN-LAST:event_btnEliminarArbitroActionPerformed

    private void btnLimpiarArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarArbitroActionPerformed
        this.txtCedulaArbitro.setEditable(true);
        limpiarCajas();
    }//GEN-LAST:event_btnLimpiarArbitroActionPerformed

    private void btnCertificadoArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoArbitroActionPerformed
        String cedula = this.txtCedulaArbitro.getText();
        Persona buscarPersona = this.miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Arbitro) {
                Arbitro arbitro = (Arbitro) buscarPersona;
                String contenido = arbitro.encabezadoCertificado() + arbitro.cuerpoCertificado() + arbitro.finalCertificado();
                this.guardarArchivo(contenido, "doc");
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un árbitro");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnCertificadoArbitroActionPerformed
    public void actualizarComboPartidosJornada() {
        this.cbPartidosJornada.removeAllItems();
        for (Partido partido : this.miLiga.getMisPartidos()) {
            if (partido.getMiJornada() == null) {
                this.cbPartidosJornada.addItem(partido.getId() + " - " + partido.getFecha() + " - Disponible");
            } else {
                this.cbPartidosJornada.addItem(partido.getId() + " - " + partido.getFecha() + " - Asignado");
            }

        }
    }

    private void cbPartidosJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPartidosJornadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPartidosJornadaActionPerformed

    //SECCION JORNADA
    private void btnActualizarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarJornadaActionPerformed
        int id = Integer.parseInt(this.txtNumeroJornada.getText());
        Jornada buscarJornada = this.miLiga.buscarJornada(id);
        if (buscarJornada != null) {
            int numero = Integer.parseInt(this.txtNumeroJornada.getText());
            String eslogan = this.txtEsloganJornada.getText();
            buscarJornada.setNumero(numero);
            buscarJornada.setEslogan(eslogan);
            JOptionPane.showMessageDialog(this, "Se actualizó la jornada de número " + numero);
            this.txtNumeroJornada.setEditable(true);
            this.limpiarCajas();
        } else {
            JOptionPane.showMessageDialog(this, "El numero ingresado es incorrecto");
        }
        this.actualizarTablaJornada();
    }//GEN-LAST:event_btnActualizarJornadaActionPerformed


    private void btnLimpiarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarJornadaActionPerformed
        limpiarCajas();
        this.txtNumeroJornada.setEditable(true);
    }//GEN-LAST:event_btnLimpiarJornadaActionPerformed

    private void btnAgregarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJornadaActionPerformed
        int id = Integer.parseInt(this.txtNumeroJornada.getText());
        Jornada buscarJornada = this.miLiga.buscarJornada(id);
        if (buscarJornada == null) {
            int numero = Integer.parseInt(this.txtNumeroJornada.getText());
            String eslogan = this.txtEsloganJornada.getText();
            Jornada jornada = new Jornada(numero, eslogan);
            this.miLiga.getMisJornadas().add(jornada);
            JOptionPane.showMessageDialog(this, "Se ha creado la jornada número: " + numero);
        } else {
            JOptionPane.showMessageDialog(this, "Ya existe una jornada con este número");
        }
        limpiarCajas();
        actualizarTablaJornada();
    }//GEN-LAST:event_btnAgregarJornadaActionPerformed

    private void btnBuscarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarJornadaActionPerformed
        int identificador = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el número de la jornada "));
        Jornada jornadaEncontrada = this.miLiga.buscarJornada(identificador);
        if (jornadaEncontrada != null) {
            this.txtNumeroJornada.setEditable(false);
            this.txtNumeroJornada.setText("" + jornadaEncontrada.getNumero());
            this.txtEsloganJornada.setText(jornadaEncontrada.getEslogan());
            actualizarTablaPartidosJornada(identificador);
        } else {
            JOptionPane.showMessageDialog(this, "El número ingresado es erróneo");
        }
    }//GEN-LAST:event_btnBuscarJornadaActionPerformed

    private void btnEliminarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarJornadaActionPerformed
        int numero = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el número de la jornada que desea eliminar"));
        Jornada jornada = this.miLiga.buscarJornada(numero);
        if (jornada != null) {
            this.miLiga.getMisJornadas().remove(jornada);
            JOptionPane.showMessageDialog(this, "La jornada de número " + numero + " se eliminó");
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaJornada();
        this.limpiarCajas();
        this.txtNumeroJornada.setEditable(true);
    }//GEN-LAST:event_btnEliminarJornadaActionPerformed

    private void cbPartidoEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPartidoEstadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPartidoEstadioActionPerformed

    private void btnAgregarPartidoJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPartidoJornadaActionPerformed
        int identificador = Integer.parseInt(this.txtNumeroJornada.getText());
        Jornada actual = this.miLiga.buscarJornada(identificador);
        if (actual != null) {
            int indice = this.cbPartidosJornada.getSelectedIndex();
            Partido seleccionado = this.miLiga.getMisPartidos().get(indice);
            if (seleccionado.getMiJornada() == null) {
                actual.getMisPartidos().add(seleccionado);
                seleccionado.setMiJornada(actual);
                JOptionPane.showMessageDialog(this, "Se ha asociado el partido de ID " + seleccionado.getId() + " con la jornada " + actual.getNumero());
                this.actualizarTablaPartidosJornada(identificador);
                this.actualizarComboPartidosJornada();
            } else {
                JOptionPane.showMessageDialog(this, "El partido está asociado a una jornada");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El ID de estadio ingresado es erróneo");
        }

    }//GEN-LAST:event_btnAgregarPartidoJornadaActionPerformed

    private void btnEliminarPartidoJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPartidoJornadaActionPerformed
        int identificador = Integer.parseInt(this.txtNumeroJornada.getText());
        Jornada actual = this.miLiga.buscarJornada(identificador);
        if (actual != null) {
            int indice = this.cbPartidosJornada.getSelectedIndex();
            Partido seleccionado = this.miLiga.getMisPartidos().get(indice);
            if (this.buscarPartidoJornada(seleccionado, actual)) {
                actual.getMisPartidos().remove(seleccionado);
                seleccionado.setMiJornada(null);
                this.txtMostrarJornadaPartido.setText("No asignado");
                JOptionPane.showMessageDialog(this, "Se ha desasociado el partido de ID " + seleccionado.getId() + " con la jornada " + actual.getNumero());
                this.actualizarComboPartidosJornada();
                this.actualizarTablaPartidosJornada(identificador);
            } else {
                JOptionPane.showMessageDialog(this, "El partido seleccionado no está asociado con la jornada");
            }
        } else {
            JOptionPane.showMessageDialog(this, "El ID de estadio ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarPartidoJornadaActionPerformed
    //==========================================================================
    //==========================================================================
    //SECCIÓN PARTIDOS

    public void actualizarTablaPartido() {
        String nombreColumnas[] = {"Id", "Fecha", "Goles local", "Goles visitante"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblPartido.setModel(miModelo);
        LinkedList<Partido> lista = this.miLiga.getMisPartidos();
        for (Partido actual : lista) {
            String fila[] = new String[nombreColumnas.length];
            fila[0] = actual.getId();
            fila[1] = actual.getFecha();
            fila[2] = "" + actual.getGolesLocal();
            fila[3] = "" + actual.getGolesVisitante();
            miModelo.addRow(fila);
        }

    }

    public void actualizarComboArbitroPartido() {
        this.cbArbitroPartido.removeAllItems();
        for (Persona actual : this.miLiga.getMisPersonas()) {
            if (actual instanceof Arbitro) {
                if (((Arbitro) actual).getMiPartido() == null) {
                    this.cbArbitroPartido.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Disponible");
                } else {
                    this.cbArbitroPartido.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Asignado");
                }
            }
        }
    }


    private void btnAgregarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPartidoActionPerformed
        String identificador = this.txtIdentificadorPartido.getText();
        Partido partidoEncontrado = this.miLiga.buscarPartido(identificador);
        if (partidoEncontrado == null) {
            String fecha = this.txtFechaPartido.getText();
            Partido partidoNuevo = new Partido(identificador, fecha, 0, 0);
            this.miLiga.getMisPartidos().add(partidoNuevo);
            JOptionPane.showMessageDialog(this, "Se ha creado el partido de ID " + identificador);
            this.actualizarComboPartidoEstadio();
            this.actualizarComboPartidosJornada();
            this.actualizarTablaPartido();
            this.limpiarCajas();
        } else {
            JOptionPane.showMessageDialog(this, "Ya existe un partido con ese identificador");
        }
    }//GEN-LAST:event_btnAgregarPartidoActionPerformed

    private void btnBuscarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPartidoActionPerformed
        String identificador = JOptionPane.showInputDialog(this, "Ingrese el identificador del partido");
        Partido partidoEncontrado = this.miLiga.buscarPartido(identificador);
        if (partidoEncontrado != null) {
            this.txtIdentificadorPartido.setEditable(false);
            this.txtIdentificadorPartido.setText(identificador);
            this.txtFechaPartido.setText(partidoEncontrado.getFecha());
            this.txtMostrarArbitroPartido.setText(this.personaAsignada(partidoEncontrado.getMiArbitro()));
            this.txtMostrarJornadaPartido.setText(this.jornadaAsignada(partidoEncontrado.getMiJornada()));
            this.txtMostrarEquipoLocal.setText(this.equipoAsignado(partidoEncontrado.getMiEquipoLocal()));
            this.txtMostrarEquipoVisitante.setText(this.equipoAsignado(partidoEncontrado.getMiEquipoVisitante()));
        } else {
            JOptionPane.showMessageDialog(this, "El identificador ingresado es erróneo");
        }
    }//GEN-LAST:event_btnBuscarPartidoActionPerformed

    private void btnActualizarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPartidoActionPerformed
        String identificador = this.txtIdentificadorPartido.getText();
        Partido partidoEncontrado = this.miLiga.buscarPartido(identificador);
        if (partidoEncontrado != null) {
            String fecha = this.txtFechaPartido.getText();
            partidoEncontrado.setFecha(fecha);
            JOptionPane.showMessageDialog(this, "Se actualizó el partido con ID " + identificador);
            this.actualizarTablaPartido();
            this.limpiarCajas();
            this.txtIdentificadorPartido.setEditable(true);
        } else {
            JOptionPane.showMessageDialog(this, "El identificador ingresado es erróneo");
        }
    }//GEN-LAST:event_btnActualizarPartidoActionPerformed

    private void btnEliminarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPartidoActionPerformed
        String identificador = JOptionPane.showInputDialog(this, "Ingrese el identificador del partido que desea eliminar");
        Partido partidoEncontrado = this.miLiga.buscarPartido(identificador);
        if (partidoEncontrado != null) {
            this.miLiga.getMisPartidos().remove(partidoEncontrado);
            JOptionPane.showMessageDialog(this, "Se eliminó el partido con ID " + identificador);
            this.actualizarTablaPartido();
            this.limpiarCajas();
            this.actualizarComboPartidoEstadio();
            this.actualizarComboPartidosJornada();

            //Partido->Estadio
            if (partidoEncontrado.getMiEstadio() != null) {
                partidoEncontrado.getMiEstadio().getMisPartidos().remove(partidoEncontrado);
            }

            //Partido->Jornada
            if (partidoEncontrado.getMiJornada() != null) {
                partidoEncontrado.getMiJornada().getMisPartidos().remove(partidoEncontrado);
            }

            //Partido->Equipo local
            if (partidoEncontrado.getMiEquipoLocal() != null) {
                partidoEncontrado.getMiEquipoLocal().getMisPartidos().remove(partidoEncontrado);
            }

            //Partido->Equipo visitante
            if (partidoEncontrado.getMiEquipoVisitante() != null) {
                partidoEncontrado.getMiEquipoVisitante().getMisPartidos().remove(partidoEncontrado);
            }

            this.txtIdentificadorPartido.setEditable(true);
        } else {
            JOptionPane.showMessageDialog(this, "El identificador ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarPartidoActionPerformed

    private void btnLimpiarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPartidoActionPerformed
        this.limpiarCajas();
        this.txtIdentificadorPartido.setEditable(true);
    }//GEN-LAST:event_btnLimpiarPartidoActionPerformed

    private void btnAgregarRelacionArbitroPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRelacionArbitroPartidoActionPerformed
        String identificador = this.txtIdentificadorPartido.getText();
        Partido partidoEncontrado = this.miLiga.buscarPartido(identificador);
        if (partidoEncontrado != null) {
            String seleccion = (String) this.cbArbitroPartido.getSelectedItem();
            String cedula = seleccion.split(" - ")[0];
            Arbitro arbitroEncontrado = (Arbitro) this.miLiga.buscarPersona(cedula);
            if (partidoEncontrado.getMiArbitro() == null) {
                if (arbitroEncontrado.getMiPartido() == null) {
                    partidoEncontrado.setMiArbitro(arbitroEncontrado);
                    arbitroEncontrado.setMiPartido(partidoEncontrado);
                    JOptionPane.showMessageDialog(this, "Se ha asociado correctamente el árbitro " + arbitroEncontrado.getNombre() + " con el partido " + partidoEncontrado.getId());
                    this.txtMostrarArbitroPartido.setText(arbitroEncontrado.getNombre());
                    this.actualizarComboArbitroPartido();
                } else {
                    JOptionPane.showMessageDialog(this, "El árbitro seleccionado se encuentra asociado actualmente a un partido");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Antes de asociar un árbitro, elimine el que está asociado actualmente al partido");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El identificador de partido ingresado es erróneo");
        }
    }//GEN-LAST:event_btnAgregarRelacionArbitroPartidoActionPerformed

    private void btnEliminarRelacionArbitroPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRelacionArbitroPartidoActionPerformed
        String identificador = this.txtIdentificadorPartido.getText();
        Partido partidoEncontrado = this.miLiga.buscarPartido(identificador);
        if (partidoEncontrado != null) {
            String seleccion = (String) this.cbArbitroPartido.getSelectedItem();
            String cedula = seleccion.split(" - ")[0];
            Arbitro arbitroEncontrado = (Arbitro) this.miLiga.buscarPersona(cedula);
            if (arbitroEncontrado.equals(partidoEncontrado.getMiArbitro())) {
                partidoEncontrado.setMiArbitro(null);
                arbitroEncontrado.setMiPartido(null);
                JOptionPane.showMessageDialog(this, "Se ha desasociado correctamente el árbitro " + arbitroEncontrado.getNombre() + " del partido " + partidoEncontrado.getId());
                this.txtMostrarArbitroPartido.setText("No asignado");
                this.actualizarComboArbitroPartido();
            } else {
                JOptionPane.showMessageDialog(this, "Ese árbitro no está asociado con el partido seleccionado");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El identificador de partido ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarRelacionArbitroPartidoActionPerformed

    //=========================================================================
    //=========================================================================
    //=========================================================================
    //=========================================================================
    //Sección partido - goles
    public void actualizarComboEquipoPartido() {
        this.cbEquipoLocalPartido.removeAllItems();
        this.cbEquipoVisitantePartido.removeAllItems();
        for (Equipo actual : this.miLiga.getMisEquipos()) {
            this.cbEquipoLocalPartido.addItem(actual.getNombre());
            this.cbEquipoVisitantePartido.addItem(actual.getNombre());
        }
    }

    public void actualizarComboJugadorLocalPartido() {
        this.cbJugadorLocalPartido.removeAllItems();
        String nombreEquipo = this.txtMostrarEquipoLocal.getText();
        Equipo encontrado = this.miLiga.buscarEquipoNombre(nombreEquipo);
        if (encontrado.getMisJugadores().size() > 0) {
            for (Jugador actual : encontrado.getMisJugadores()) {
                this.cbJugadorLocalPartido.addItem(actual.getNombre());
            }
        } else {
            this.cbJugadorLocalPartido.addItem("No jugador");
        }
    }

    public void actualizarComboJugadorVisitantePartido() {
        this.cbJugadorVisitantePartido.removeAllItems();
        String nombreEquipo = this.txtMostrarEquipoVisitante.getText();
        Equipo encontrado = this.miLiga.buscarEquipoNombre(nombreEquipo);
        if (encontrado.getMisJugadores().size() > 0) {
            for (Jugador actual : encontrado.getMisJugadores()) {
                this.cbJugadorVisitantePartido.addItem(actual.getNombre());
            }
        } else {
            this.cbJugadorVisitantePartido.addItem("No jugador");
        }

    }


    private void btnAgregarEquipoLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEquipoLocalActionPerformed
        String identificador = this.txtIdentificadorPartido.getText();
        Partido encontrado = this.miLiga.buscarPartido(identificador);
        if (encontrado != null) {
            int indiceLocal = this.cbEquipoLocalPartido.getSelectedIndex();
            int indiceVisitante = this.cbEquipoVisitantePartido.getSelectedIndex();
            Equipo equipoLocal = this.miLiga.getMisEquipos().get(indiceLocal);
            Equipo equipoVisitante = this.miLiga.getMisEquipos().get(indiceVisitante);
            if (!equipoLocal.equals(equipoVisitante)) {
                int golesLocal = Integer.parseInt(this.txtGolesEquipoLocal.getText());
                int golesVisitante = Integer.parseInt(this.txtGolesEquipoVisitante.getText());
                //Asignarle los goles local y visitante al partido
                encontrado.setGolesLocal(golesLocal);
                encontrado.setGolesVisitante(golesVisitante);

                //Asignarle los equipos
                encontrado.setMiEquipoLocal(equipoLocal);
                encontrado.setMiEquipoVisitante(equipoVisitante);

                //Asignarle al equipo local y visitante el partido
                equipoLocal.getMisPartidos().add(encontrado);
                equipoVisitante.getMisPartidos().add(encontrado);

                //Agregar los goles al equipo local
                equipoLocal.setGolesFavor(equipoLocal.getGolesFavor() + golesLocal);
                equipoLocal.setGolesContra(equipoLocal.getGolesContra() + golesVisitante);

                //Agregar los goles al equipo visitante
                equipoVisitante.setGolesFavor(equipoVisitante.getGolesFavor() + golesVisitante);
                equipoVisitante.setGolesContra(equipoVisitante.getGolesContra() + golesLocal);

                //Sumar puntos
                if (golesLocal > golesVisitante) {
                    equipoLocal.setPuntos(equipoLocal.getPuntos() + 3);
                } else if (golesLocal < golesVisitante) {
                    equipoVisitante.setPuntos(equipoVisitante.getPuntos() + 3);
                } else {
                    equipoLocal.setPuntos(equipoLocal.getPuntos() + 1);
                    equipoVisitante.setPuntos(equipoVisitante.getPuntos() + 1);
                }

                this.txtGolesLocal.setText("" + golesLocal);
                this.txtGolesVisitante.setText("" + golesVisitante);

                JOptionPane.showMessageDialog(this, "Se agregaron los equipos correctamente");
                this.txtMostrarEquipoLocal.setText(equipoLocal.getNombre());
                this.txtMostrarEquipoVisitante.setText(equipoVisitante.getNombre());
                this.actualizarTablaEquipo();
                this.actualizarTablaPartido();
                this.tablaPosiciones();
                this.actualizarComboJugadorLocalPartido();
                this.actualizarComboJugadorVisitantePartido();
            } else {
                JOptionPane.showMessageDialog(this, "Ha seleccionado los mismos equipos");
            }

        } else {
            JOptionPane.showMessageDialog(this, "El identificador del partido es erróneo");
        }
    }//GEN-LAST:event_btnAgregarEquipoLocalActionPerformed

    private void btnAgregarGolesLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarGolesLocalActionPerformed
        String nombreEquipo = this.txtMostrarEquipoLocal.getText();
        Equipo encontrado = this.miLiga.buscarEquipoNombre(nombreEquipo);
        int golesLocal = Integer.parseInt(this.txtGolesLocal.getText());
        if (golesLocal > 0) {
            int indice = this.cbJugadorLocalPartido.getSelectedIndex();
            Jugador jugadorEquipo = encontrado.getMisJugadores().get(indice);
            int golesSeleccionados = (Integer) this.spinnerGolesLocal.getValue();
            if (golesSeleccionados <= golesLocal) {
                jugadorEquipo.setGolesMarcados(jugadorEquipo.getGolesMarcados() + golesSeleccionados);
                this.txtGolesLocal.setText("" + (golesLocal - golesSeleccionados));
                this.spinnerGolesLocal.setValue(0);
                this.actualizarTablaJugador();
                JOptionPane.showMessageDialog(this, "Se agregaron " + golesSeleccionados + " goles al jugador " + jugadorEquipo.getNombre());
            } else {
                JOptionPane.showMessageDialog(this, "Eligió más goles de los que debía");
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se pueden agregar más goles");
        }

    }//GEN-LAST:event_btnAgregarGolesLocalActionPerformed

    private void btnAgregarGolesVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarGolesVisitanteActionPerformed
        String nombreEquipo = this.txtMostrarEquipoVisitante.getText();
        Equipo encontrado = this.miLiga.buscarEquipoNombre(nombreEquipo);
        int golesVisitante = Integer.parseInt(this.txtGolesVisitante.getText());
        if (golesVisitante > 0) {
            int indice = this.cbJugadorVisitantePartido.getSelectedIndex();
            Jugador jugadorEquipo = encontrado.getMisJugadores().get(indice);
            int golesSeleccionados = (Integer) this.spinnerGolesVisitante.getValue();
            if (golesSeleccionados <= golesVisitante) {
                jugadorEquipo.setGolesMarcados(jugadorEquipo.getGolesMarcados() + golesSeleccionados);
                this.txtGolesVisitante.setText("" + (golesVisitante - golesSeleccionados));
                this.spinnerGolesVisitante.setValue(0);
                this.actualizarTablaJugador();
                JOptionPane.showMessageDialog(this, "Se agregaron " + golesSeleccionados + " goles al jugador " + jugadorEquipo.getNombre());
            } else {
                JOptionPane.showMessageDialog(this, "Eligió más goles de los que debía");
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se pueden agregar más goles");
        }
    }//GEN-LAST:event_btnAgregarGolesVisitanteActionPerformed

    //SECCION PERSONAS -> MANAGER
    private void btnAgregarManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarManagerActionPerformed
        String cedula = this.txtCedulaManager.getText();
        Persona persona = this.miLiga.buscarPersona(cedula);
        if (persona == null) {
            String nombre = this.txtNombreManager.getText();
            String apellido = this.txtApellidoManager.getText();
            int edad = Integer.parseInt(this.txtEdadManager.getText());
            int afiliacion = Integer.parseInt(this.txtAfiliacionManager.getText());
            Manager manager = new Manager(cedula, nombre, apellido, edad, afiliacion);
            this.miLiga.getMisPersonas().add(manager);
            JOptionPane.showMessageDialog(this, "Se agregó el manager " + nombre);
//            this.actualizarComboTecnicoEquipo();
            this.actualizarTablaManager();
            this.limpiarCajas();
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una persona con esa cédula");
        }
    }//GEN-LAST:event_btnAgregarManagerActionPerformed

    private void cbEquipoLocalPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEquipoLocalPartidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEquipoLocalPartidoActionPerformed

    private void btnBuscarManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarManagerActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Manager) {
                this.txtCedulaManager.setEditable(false);
                Manager manager = (Manager) buscarPersona;
                this.txtCedulaManager.setText(manager.getCedula());
                this.txtNombreManager.setText(manager.getNombre());
                this.txtApellidoManager.setText(manager.getApellido());
                this.txtEdadManager.setText("" + manager.getEdad());
                this.txtAfiliacionManager.setText("" + manager.getAniosAfiliacion());
                this.txtEquipoManager.setText(this.equipoAsignado(manager.getMiEquipo()));

            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un manager");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnBuscarManagerActionPerformed

    private void btnActualizarManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarManagerActionPerformed
        String cedula = this.txtCedulaManager.getText();
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Manager) {
                Manager manager = (Manager) buscarPersona;
                String nombre = this.txtNombreManager.getText();
                String apellido = this.txtApellidoManager.getText();
                int edad = Integer.parseInt(this.txtEdadManager.getText());
                int afiliacion = Integer.parseInt(this.txtAfiliacionManager.getText());
                manager.setNombre(nombre);
                manager.setApellido(apellido);
                manager.setEdad(edad);
                manager.setAniosAfiliacion(afiliacion);
                JOptionPane.showMessageDialog(this, "Se actualizó el manager de cédula " + cedula);
                this.txtCedulaManager.setEditable(true);
                this.limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un manager");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaManager();
    }//GEN-LAST:event_btnActualizarManagerActionPerformed

    private void btnEliminarManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarManagerActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del manager que desea eliminar");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Manager) {
                this.miLiga.getMisPersonas().remove(buscarPersona);
                JOptionPane.showMessageDialog(this, "El manager de cédula " + cedula + " se eliminó");
                Manager manager = (Manager) buscarPersona;
//                //Eliminar el jugador de la relación con Manager
//                jugador.getMi().getMisJugadores().remove(jugador);
//                this.actualizarComboJugadorEquipo();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un manager");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
        this.actualizarTablaManager();
        this.limpiarCajas();
    }//GEN-LAST:event_btnEliminarManagerActionPerformed

    private void btnLimpiarManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarManagerActionPerformed
        limpiarCajas();
        this.txtCedulaManager.setEditable(true);
        this.actualizarTablaJugadoresManager("-1");
    }//GEN-LAST:event_btnLimpiarManagerActionPerformed


    private void btnAñadirJugadoresManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirJugadoresManagerActionPerformed
        String cedula = this.txtCedulaManager.getText();
        Persona managerEncontrado = this.miLiga.buscarPersona(cedula);
        if (managerEncontrado != null) {
            if (managerEncontrado instanceof Manager) {
                String seleccion = (String) this.cbManagerJugadores.getSelectedItem();
                String cedulaJugador = seleccion.split(" - ")[0];
                Jugador jugadorEncontrado = (Jugador) this.miLiga.buscarPersona(cedulaJugador);
                if (jugadorEncontrado.getMiManager() == null) {
                    ((Manager) managerEncontrado).getMisJugadores().add(jugadorEncontrado);
                    jugadorEncontrado.setMiManager((Manager) managerEncontrado);
                    JOptionPane.showMessageDialog(this, "Se ha asociado correctamente el jugador " + jugadorEncontrado.getNombre() + " con el manager " + managerEncontrado.getNombre());
                    this.actualizarTablaJugadoresManager(cedula);
                    this.actualizarComboJugadorManager();
                } else {
                    JOptionPane.showMessageDialog(this, "El jugador seleccionado se encuentra asociado a otro manager");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula del manager ingresado es erróneo");
        }
    }//GEN-LAST:event_btnAñadirJugadoresManagerActionPerformed


    private void btnEliminarJugadorManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarJugadorManagerActionPerformed
        String cedula = this.txtCedulaManager.getText();
        Persona managerEncontrado = this.miLiga.buscarPersona(cedula);
        if (managerEncontrado != null) {
            if (managerEncontrado instanceof Manager) {
                String seleccion = (String) this.cbManagerJugadores.getSelectedItem();
                String cedulaJugador = seleccion.split(" - ")[0];
                Jugador jugadorEncontrado = (Jugador) this.miLiga.buscarPersona(cedulaJugador);
                if (buscarJugadorManager(jugadorEncontrado, (Manager) managerEncontrado)) {
                    
                        ((Manager) managerEncontrado).getMisJugadores().remove(jugadorEncontrado);
                        JOptionPane.showMessageDialog(this, "Se ha desasociado correctamente el jugador " + jugadorEncontrado.getNombre() + " del manager " + managerEncontrado.getNombre());
                        this.actualizarTablaJugadoresManager(cedula);
                        jugadorEncontrado.setMiManager(null);
                        this.actualizarComboJugadorManager();
                   
                } else {
                    JOptionPane.showMessageDialog(this, "El jugador que esta intentando desasociar no lo gestiona el manager elegido");
                }
            } 

        }else {
                JOptionPane.showMessageDialog(this, "La cédula del manager ingresado es erróneo");
            }

    }//GEN-LAST:event_btnEliminarJugadorManagerActionPerformed

    public void actualizarTablaJugadoresManager(String cedula) {
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "Salario"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblJugadorManager.setModel(miModelo);
        Persona personaEncontrada = this.miLiga.buscarPersona(cedula);
        if (personaEncontrada != null) {
            if (personaEncontrada instanceof Manager) {
                for (Persona actual : ((Manager) personaEncontrada).getMisJugadores()) {
                    if (actual instanceof Jugador) {
                        String fila[] = new String[nombreColumnas.length];
                        fila[0] = actual.getCedula();
                        fila[1] = actual.getNombre();
                        fila[2] = actual.getApellido();
                        fila[3] = "" + actual.getEdad();
                        fila[4] = "" + ((Jugador) actual).getSalario();
                        miModelo.addRow(fila);
                    }
                }
            }
        } else {
            miModelo.setRowCount(0);
        }

    }
    private void btnAgregarEquipoManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEquipoManagerActionPerformed
        String cedula = this.txtCedulaManager.getText();
        Persona managerEncontrado = this.miLiga.buscarPersona(cedula);
        if (managerEncontrado != null) {
            if (managerEncontrado instanceof Manager) {
                String seleccion = (String) this.cbManagerEquipo.getSelectedItem();
                String identificadorEquipo = seleccion.split(" - ")[0];
                Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificadorEquipo);
                if (((Manager) managerEncontrado).getMiEquipo() == null) {
                    if (equipoEncontrado.getMiManager() == null) {
                        ((Manager) managerEncontrado).setMiEquipo(equipoEncontrado);
                        equipoEncontrado.setMiManager((Manager) managerEncontrado);
                        JOptionPane.showMessageDialog(this, "Se ha asociado correctamente el equipo " + equipoEncontrado.getNombre() + " con el manager " + managerEncontrado.getNombre());
                        this.actualizarTablaJugadoresManager(cedula);
                        this.actualizarComboEquipoManager();
                        this.txtEquipoManager.setText(equipoEncontrado.getNombre());
                    } else {
                        JOptionPane.showMessageDialog(this, "El equipo seleccionado se encuentra asociado a otro manager");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El manager seleccionado está asociado actualmente a un equipo");
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "El identificador del manager ingresado es erróneo");
        }
    }//GEN-LAST:event_btnAgregarEquipoManagerActionPerformed

    private void btnEliminarEquipoManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEquipoManagerActionPerformed
        String cedula = this.txtCedulaManager.getText();
        Persona managerEncontrado = this.miLiga.buscarPersona(cedula);
        if (managerEncontrado != null) {
            if (managerEncontrado instanceof Manager) {
                String seleccion = (String) this.cbManagerEquipo.getSelectedItem();
                String identificadorEquipo = seleccion.split(" - ")[0];
                Equipo equipoEncontrado = this.miLiga.buscarEquipo(identificadorEquipo);
                if (equipoEncontrado.getMiManager().equals(managerEncontrado)) {
                    ((Manager) managerEncontrado).setMiEquipo(null);
                    equipoEncontrado.setMiManager(null);
                    JOptionPane.showMessageDialog(this, "Se ha desasociado correctamente el equipo " + equipoEncontrado.getNombre() + " con el manager " + managerEncontrado.getNombre());
                    this.actualizarTablaJugadoresManager(cedula);
                    this.actualizarComboEquipoManager();
                    this.txtEquipoManager.setText("No asignado");
                } else {
                    JOptionPane.showMessageDialog(this, "El equipo que seleccionó, no lo gestiona el manager indicado");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "El identificador del partido ingresado es erróneo");
        }
    }//GEN-LAST:event_btnEliminarEquipoManagerActionPerformed

    private void btnCertificadoManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoManagerActionPerformed
        String cedula = this.txtCedulaManager.getText();
        Persona buscarPersona = this.miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Manager) {
                Manager manager = (Manager) buscarPersona;
                String contenido = manager.encabezadoCertificado() + manager.cuerpoCertificado() + manager.finalCertificado();
                this.guardarArchivo(contenido, "doc");
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un manager");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnCertificadoManagerActionPerformed

    private void txtJugadorJovenEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJugadorJovenEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJugadorJovenEquipoActionPerformed

    public void actualizarComboJugadorManager() {
        this.cbManagerJugadores.removeAllItems();
        for (Persona actual : this.miLiga.getMisPersonas()) {
            if (actual instanceof Jugador) {
                if (((Jugador) actual).getMiManager() == null) {
                    this.cbManagerJugadores.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Disponible");
                } else {
                    this.cbManagerJugadores.addItem(actual.getCedula() + " - " + actual.getNombre() + " - Asignado");
                }
            }
        }
    }

    public void actualizarComboEquipoManager() {
        this.cbManagerEquipo.removeAllItems();
        for (Equipo actual : this.miLiga.getMisEquipos()) {
            if (actual.getMiManager() == null) {
                this.cbManagerEquipo.addItem(actual.getId() + " - " + actual.getNombre() + "- Disponible");
            } else {
                this.cbManagerEquipo.addItem(actual.getId() + " - " + actual.getNombre() + " - Asignado");
            }
        }
    }
    //TABLA MANAGER

    public void actualizarTablaManager() {
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "Afiliación"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblManagers.setModel(miModelo);
        LinkedList<Persona> lista = this.miLiga.getMisPersonas();
        for (Persona actual : lista) {
            if (actual instanceof Manager) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = "" + actual.getCedula();
                fila[1] = actual.getNombre();
                fila[2] = actual.getApellido();
                fila[3] = "" + actual.getEdad();
                fila[4] = "" + ((Manager) actual).getAniosAfiliacion();
                miModelo.addRow(fila);
            }
        }
    }

    //TABLA PARTIDOS JORNADA
    public void actualizarTablaPartidosJornada(int identificador) {
        String nombreColumnas[] = {"Identificador", "Fecha", "Goles local", "Goles visitante"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblPartidoJornada.setModel(miModelo);
        Jornada jornadaEncontrada = this.miLiga.buscarJornada(identificador);
        if (jornadaEncontrada != null) {
            LinkedList<Partido> lista = jornadaEncontrada.getMisPartidos();
            for (Partido actual : lista) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = actual.getId();
                fila[1] = actual.getFecha();
                fila[2] = "" + actual.getGolesLocal();
                fila[3] = "" + actual.getGolesVisitante();
                miModelo.addRow(fila);
            }
        } else {
            miModelo.setRowCount(0);
        }

    }

    //TABLA JORNADA
    public void actualizarTablaJornada() {
        String nombreColumnas[] = {"Número", "Eslogan"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblJornada.setModel(miModelo);
        LinkedList<Jornada> lista = this.miLiga.getMisJornadas();
        for (Jornada actual : lista) {
            String fila[] = new String[nombreColumnas.length];
            fila[0] = "" + actual.getNumero();
            fila[1] = actual.getEslogan();
            miModelo.addRow(fila);
        }
    }

    //TABLA ARBITROS    
    public void actualizarTablaArbitro() {
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "Edad", "Arb. FIFA"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblArbitro.setModel(miModelo);
        LinkedList<Persona> lista = this.miLiga.getMisPersonas();
        for (Persona actual : lista) {
            if (actual instanceof Arbitro) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = actual.getCedula();
                fila[1] = actual.getNombre();
                fila[2] = actual.getApellido();
                fila[3] = "" + actual.getEdad();
                fila[4] = "" + ((Arbitro) actual).isFifa();
                miModelo.addRow(fila);
            }
        }
    }

    //TABLA JUGADORES
    public void actualizarTablaJugador() {
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "Edad", "Nacionalidad", "Posición", "Goles", "Salario"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblJugador.setModel(miModelo);
        LinkedList<Persona> lista = this.miLiga.getMisPersonas();
        for (Persona actual : lista) {
            if (actual instanceof Jugador) {
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

    public String personaAsignada(Persona persona) {
        if (persona != null) {
            return persona.getNombre();
        } else {
            return "No asignado";
        }
    }

    public String jornadaAsignada(Jornada jornada) {
        if (jornada != null) {
            return "" + jornada.getNumero();
        } else {
            return "No asignado";
        }
    }

    public boolean buscarJugadorEquipo(Jugador jugador, Equipo equipo) {
        for (Jugador actual : equipo.getMisJugadores()) {
            if (actual.equals(jugador)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarAficionadoEquipo(Aficionado aficionado, Equipo equipo) {
        for (Aficionado actual : equipo.getMisAficionados()) {
            if (actual.equals(aficionado)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarPartidoEstadio(Partido partido, Estadio estadio) {
        for (Partido actual : estadio.getMisPartidos()) {
            if (actual.equals(partido)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarPartidoJornada(Partido partido, Jornada jornada) {
        for (Partido actual : jornada.getMisPartidos()) {
            if (actual.equals(partido)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarEquipoManager(Equipo equipo, Manager manager) {
        return true;
    }

    public boolean buscarJugadorManager(Jugador jugador, Manager manager) {
        for (Jugador actual: manager.getMisJugadores()) {
            if (actual.equals(jugador)) {
                    return true;
            }    
        }
        return false;

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
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel EsloganJornada;
    private javax.swing.JPanel Jpanel;
    private javax.swing.JLabel ListaJornadas;
    private javax.swing.JLabel ListaPartidosJornada;
    private javax.swing.JLabel NumeroJornada;
    private javax.swing.JLabel apellidoArbitro;
    private javax.swing.JLabel arbitroFIFA;
    private javax.swing.JButton btnActualizarAficionado;
    private javax.swing.JButton btnActualizarArbitro;
    private javax.swing.JButton btnActualizarEquipo;
    private javax.swing.JButton btnActualizarEstadio;
    private javax.swing.JButton btnActualizarJornada;
    private javax.swing.JButton btnActualizarJugador;
    private javax.swing.JButton btnActualizarManager;
    private javax.swing.JButton btnActualizarPartido;
    private javax.swing.JButton btnActualizarTecnico;
    private javax.swing.JButton btnAgregarAficionado;
    private javax.swing.JButton btnAgregarArbitro;
    private javax.swing.JButton btnAgregarEquipo;
    private javax.swing.JButton btnAgregarEquipoLocal;
    private javax.swing.JButton btnAgregarEquipoManager;
    private javax.swing.JButton btnAgregarEstadio;
    private javax.swing.JButton btnAgregarGolesLocal;
    private javax.swing.JButton btnAgregarGolesVisitante;
    private javax.swing.JButton btnAgregarJornada;
    private javax.swing.JButton btnAgregarJugador;
    private javax.swing.JButton btnAgregarManager;
    private javax.swing.JButton btnAgregarPartido;
    private javax.swing.JButton btnAgregarPartidoJornada;
    private javax.swing.JButton btnAgregarRelacionAficionadoEquipo;
    private javax.swing.JButton btnAgregarRelacionArbitroPartido;
    private javax.swing.JButton btnAgregarRelacionJugadorEquipo;
    private javax.swing.JButton btnAgregarRelacionPartidoEstadio;
    private javax.swing.JButton btnAgregarRelacionTecnicoEquipo;
    private javax.swing.JButton btnAgregarTecnico;
    private javax.swing.JButton btnAñadirJugadoresManager;
    private javax.swing.JButton btnBuscarAficionado;
    private javax.swing.JButton btnBuscarArbitro;
    private javax.swing.JButton btnBuscarEquipo;
    private javax.swing.JButton btnBuscarEstadio;
    private javax.swing.JButton btnBuscarJornada;
    private javax.swing.JButton btnBuscarJugador;
    private javax.swing.JButton btnBuscarManager;
    private javax.swing.JButton btnBuscarPartido;
    private javax.swing.JButton btnBuscarTecnico;
    private javax.swing.JButton btnCertificadoAficionado;
    private javax.swing.JButton btnCertificadoArbitro;
    private javax.swing.JButton btnCertificadoJugador;
    private javax.swing.JButton btnCertificadoManager;
    private javax.swing.JButton btnCertificadoTecnico;
    private javax.swing.JButton btnEliminarAficionado;
    private javax.swing.JButton btnEliminarArbitro;
    private javax.swing.JButton btnEliminarEquipo;
    private javax.swing.JButton btnEliminarEquipoManager;
    private javax.swing.JButton btnEliminarEstadio;
    private javax.swing.JButton btnEliminarJornada;
    private javax.swing.JButton btnEliminarJugador;
    private javax.swing.JButton btnEliminarJugadorManager;
    private javax.swing.JButton btnEliminarManager;
    private javax.swing.JButton btnEliminarPartido;
    private javax.swing.JButton btnEliminarPartidoJornada;
    private javax.swing.JButton btnEliminarRelacionAficionadoEquipo;
    private javax.swing.JButton btnEliminarRelacionArbitroPartido;
    private javax.swing.JButton btnEliminarRelacionJugadorEquipo;
    private javax.swing.JButton btnEliminarRelacionPartidoEstadio;
    private javax.swing.JButton btnEliminarRelacionTecnicoEquipo;
    private javax.swing.JButton btnEliminarTecnico;
    private javax.swing.JButton btnLimpiarAficionado;
    private javax.swing.JButton btnLimpiarArbitro;
    private javax.swing.JButton btnLimpiarEquipo;
    private javax.swing.JButton btnLimpiarEstadio;
    private javax.swing.JButton btnLimpiarJornada;
    private javax.swing.JButton btnLimpiarJugador;
    private javax.swing.JButton btnLimpiarManager;
    private javax.swing.JButton btnLimpiarPartido;
    private javax.swing.JButton btnLimpiarTecnico;
    private javax.swing.JComboBox<String> cbAficionadoEquipo;
    private javax.swing.JComboBox<String> cbArbitroPartido;
    private javax.swing.JComboBox<String> cbEquipoLocalPartido;
    private javax.swing.JComboBox<String> cbEquipoVisitantePartido;
    private javax.swing.JComboBox<String> cbJugadorEquipo;
    private javax.swing.JComboBox<String> cbJugadorLocalPartido;
    private javax.swing.JComboBox<String> cbJugadorVisitantePartido;
    private javax.swing.JComboBox<String> cbManagerEquipo;
    private javax.swing.JComboBox<String> cbManagerJugadores;
    private javax.swing.JComboBox<String> cbPartidoEstadio;
    private javax.swing.JComboBox<String> cbPartidosJornada;
    private javax.swing.JComboBox<String> cbTecnicoEquipo;
    private javax.swing.JLabel cedulaArbitro;
    private javax.swing.JCheckBox checkAbonoAficionado;
    private javax.swing.JCheckBox checkArbitroFIfa;
    private javax.swing.JLabel edadArbitro;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel labelTituloListaAficionados;
    private javax.swing.JLabel labelTituloListaPartidoEquipo;
    private javax.swing.JLabel labelTituloTablaTecnico;
    private javax.swing.JLabel lblAfiliacionManager;
    private javax.swing.JLabel lblApellidoManager;
    private javax.swing.JLabel lblArqueroEquipo;
    private javax.swing.JLabel lblCapacidadEstadio;
    private javax.swing.JLabel lblCedulaManager;
    private javax.swing.JLabel lblCiudadEstadio;
    private javax.swing.JLabel lblEdadManager;
    private javax.swing.JLabel lblEquipoJugador;
    private javax.swing.JLabel lblEquipoLocalPartido;
    private javax.swing.JLabel lblEquipoLocalSeleccionadoPartido;
    private javax.swing.JLabel lblEquipoManager;
    private javax.swing.JLabel lblEquipoVisitantePartido;
    private javax.swing.JLabel lblEquipoVisitanteSeleccionadoPartido;
    private javax.swing.JLabel lblEstadioMasGoles;
    private javax.swing.JLabel lblFechaPartido;
    private javax.swing.JLabel lblGoleadorLiga;
    private javax.swing.JLabel lblGolesLocal;
    private javax.swing.JLabel lblGolesLocalPartido;
    private javax.swing.JLabel lblGolesVisitante;
    private javax.swing.JLabel lblGolesVisitantePartido;
    private javax.swing.JLabel lblIdPartidoMasGoles;
    private javax.swing.JLabel lblIdentificadorEstadio;
    private javax.swing.JLabel lblIdentificadorPartido;
    private javax.swing.JLabel lblJugadorMasGolesEquipo;
    private javax.swing.JLabel lblJugadorMasJoven;
    private javax.swing.JLabel lblJugadorMasJovenEquipo;
    private javax.swing.JLabel lblJugadoresLocalPartido;
    private javax.swing.JLabel lblJugadoresManager;
    private javax.swing.JLabel lblJugadoresVisitantePartido;
    private javax.swing.JLabel lblMostraArbitroPartido;
    private javax.swing.JLabel lblMostraJornadaPartido;
    private javax.swing.JLabel lblNombreEstadio;
    private javax.swing.JLabel lblNombreManager;
    private javax.swing.JLabel lblPartidosGoleadaEquipo;
    private javax.swing.JLabel lblPromEdadJugadoresEquipo;
    private javax.swing.JLabel lblRelacionArbitroPartido;
    private javax.swing.JLabel lblRelacionPartidosEstadio;
    private javax.swing.JLabel lblSumaTotalNominaEquipo;
    private javax.swing.JLabel lblTituloListaEstadios;
    private javax.swing.JLabel lblTituloListaPartido;
    private javax.swing.JLabel lblVallaMenosVendia;
    private javax.swing.JLabel nombreArbitro;
    private javax.swing.JSpinner spinnerGolesLocal;
    private javax.swing.JSpinner spinnerGolesVisitante;
    private javax.swing.JTable tblAficionado;
    private javax.swing.JTable tblAficionadoEquipo;
    private javax.swing.JTable tblArbitro;
    private javax.swing.JTable tblEquipo;
    private javax.swing.JTable tblEstadio;
    private javax.swing.JTable tblJornada;
    private javax.swing.JTable tblJugador;
    private javax.swing.JTable tblJugadorEquipo;
    private javax.swing.JTable tblJugadorManager;
    private javax.swing.JTable tblManagers;
    private javax.swing.JTable tblPartido;
    private javax.swing.JTable tblPartidoEstadio;
    private javax.swing.JTable tblPartidoJornada;
    private javax.swing.JTable tblPartidosEquipo;
    private javax.swing.JTable tblPosiciones;
    private javax.swing.JTable tblTecnico;
    private javax.swing.JTextField txtAfiliacionManager;
    private javax.swing.JTextField txtApellidoAficionado;
    private javax.swing.JTextField txtApellidoArbitro;
    private javax.swing.JTextField txtApellidoJugador;
    private javax.swing.JTextField txtApellidoManager;
    private javax.swing.JTextField txtApellidoTecnico;
    private javax.swing.JTextField txtArqueroEquipo;
    private javax.swing.JTextField txtCantidadPartidosGoleadaEquipo;
    private javax.swing.JTextField txtCapacidadEstadio;
    private javax.swing.JTextField txtCedulaAficionado;
    private javax.swing.JTextField txtCedulaArbitro;
    private javax.swing.JTextField txtCedulaJugador;
    private javax.swing.JTextField txtCedulaManager;
    private javax.swing.JTextField txtCedulaTecnico;
    private javax.swing.JTextField txtCiudadEstadio;
    private javax.swing.JTextField txtEdadAficionado;
    private javax.swing.JTextField txtEdadArbitro;
    private javax.swing.JTextField txtEdadJugador;
    private javax.swing.JTextField txtEdadManager;
    private javax.swing.JTextField txtEdadTecnico;
    private javax.swing.JTextField txtEquipoAficionado;
    private javax.swing.JTextField txtEquipoJugador;
    private javax.swing.JTextField txtEquipoManager;
    private javax.swing.JTextField txtEquipoMasCaro;
    private javax.swing.JTextField txtEquipoMayorCantidadAficionados;
    private javax.swing.JTextField txtEquipoTecnico;
    private javax.swing.JTextField txtEsloganJornada;
    private javax.swing.JTextField txtExperienciaTecnico;
    private javax.swing.JTextField txtFechaPartido;
    private javax.swing.JTextField txtFidelidadAficionado;
    private javax.swing.JTextField txtFundacionEquipo;
    private javax.swing.JTextField txtGoleadorLiga;
    private javax.swing.JTextField txtGolesContraEquipo;
    private javax.swing.JTextField txtGolesEquipoLocal;
    private javax.swing.JTextField txtGolesEquipoVisitante;
    private javax.swing.JTextField txtGolesFavorEquipo;
    private javax.swing.JTextField txtGolesJugador;
    private javax.swing.JTextField txtGolesLocal;
    private javax.swing.JTextField txtGolesVisitante;
    private javax.swing.JTextField txtIDPartidoMasGoles;
    private javax.swing.JTextField txtIdentificadorEquipo;
    private javax.swing.JTextField txtIdentificadorEstadio;
    private javax.swing.JTextField txtIdentificadorPartido;
    private javax.swing.JTextField txtJugadorJovenEquipo;
    private javax.swing.JTextField txtJugadorMasGolesEquipo;
    private javax.swing.JTextField txtJugadorMasJoven;
    private javax.swing.JTextField txtMostrarArbitroPartido;
    private javax.swing.JTextField txtMostrarEquipoLocal;
    private javax.swing.JTextField txtMostrarEquipoVisitante;
    private javax.swing.JTextField txtMostrarJornadaPartido;
    private javax.swing.JTextField txtMostrarTecnicoEquipo;
    private javax.swing.JTextField txtNacionalidadJugador;
    private javax.swing.JTextField txtNombreAficionado;
    private javax.swing.JTextField txtNombreArbitro;
    private javax.swing.JTextField txtNombreEquipo;
    private javax.swing.JTextField txtNombreEstadio;
    private javax.swing.JTextField txtNombreEstadioMasgoles;
    private javax.swing.JTextField txtNombreJugador;
    private javax.swing.JTextField txtNombreManager;
    private javax.swing.JTextField txtNombreTecnico;
    private javax.swing.JTextField txtNominaEquipo;
    private javax.swing.JTextField txtNumeroJornada;
    private javax.swing.JTextField txtPartidosEquipo;
    private javax.swing.JTextField txtPosicionJugador;
    private javax.swing.JTextField txtPromedioEdadJugadoresEquipo;
    private javax.swing.JTextField txtPuntosEquipo;
    private javax.swing.JTextField txtSalarioJugador;
    private javax.swing.JTextField txtSalarioTecnico;
    private javax.swing.JTextField txtTitulosInternacionalesEquipo;
    private javax.swing.JTextField txtTitulosNacionalesEquipo;
    private javax.swing.JTextField txtVallaMenosVencida;
    // End of variables declaration//GEN-END:variables
}
