/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaControladores;

import Modelos.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Vista extends javax.swing.JFrame {

    Liga miLiga;

    public Vista() {
        this.miLiga = new Liga("01", "Colombia");
        //TESTEO
        //OBJETOS PARA TESTEO
        miLiga.crearEquipo("Once Caldas", 1945, 5, 1, 12, 7, 18, 5);
        miLiga.crearEquipo("Nacional", 1965, 8, 3, 15, 13, 18, 5);
        miLiga.crearEquipo("Santa Fé", 1998, 10, 0, 12, 9, 18, 5);
        miLiga.crearEquipo("Millonarios", 1923, 12, 2, 12, 13, 18, 5);
        miLiga.crearEquipo("Patriotas", 1945, 1, 0, 12, 10, 18, 5);
        miLiga.crearEquipo("América de Cali", 1948, 0, 5, 16, 8, 18, 5);
        System.out.println("====================================");
        System.out.println("Tabla de posiciones organizada por puntos");
        for (Equipo actual : miLiga.organizarPorPuntos()) {
            System.out.println("Nombre: " + actual.getNombre() + " Puntos: " + actual.getPuntos() + " Diferencia goles: " + (actual.getGolesFavor() - actual.getGolesContra()));
        }

        System.out.println("====================================");
        System.out.println("Tabla de posiciones organizada por puntos y goles");
        for (Equipo actual : miLiga.tablaPosiciones()) {
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

        miLiga.getMisPersonas().add(jugador1);
        miLiga.getMisPersonas().add(jugador2);
        miLiga.getMisPersonas().add(jugador3);
        miLiga.getMisPersonas().add(jugador4);
        miLiga.getMisPersonas().add(jugador5);
        miLiga.getMisPersonas().add(jugador6);
        miLiga.getMisPersonas().add(jugador7);
        miLiga.getMisPersonas().add(jugador8);
        miLiga.getMisPersonas().add(jugador9);
        miLiga.getMisPersonas().add(jugador10);
        miLiga.getMisPersonas().add(jugador11);
        miLiga.getMisPersonas().add(jugador12);
        miLiga.getMisPersonas().add(jugador13);
        miLiga.getMisPersonas().add(jugador14);
        miLiga.getMisPersonas().add(jugador15);
        miLiga.getMisPersonas().add(jugador16);
        miLiga.getMisPersonas().add(jugador17);
        miLiga.getMisPersonas().add(jugador18);

        miLiga.getMisEquipos().get(0).agregarJugador(jugador1);
        miLiga.getMisEquipos().get(0).agregarJugador(jugador2);
        miLiga.getMisEquipos().get(0).agregarJugador(jugador3);
        miLiga.getMisEquipos().get(1).agregarJugador(jugador4);
        miLiga.getMisEquipos().get(1).agregarJugador(jugador5);
        miLiga.getMisEquipos().get(1).agregarJugador(jugador6);
        miLiga.getMisEquipos().get(2).agregarJugador(jugador7);
        miLiga.getMisEquipos().get(2).agregarJugador(jugador8);
        miLiga.getMisEquipos().get(2).agregarJugador(jugador9);
        miLiga.getMisEquipos().get(3).agregarJugador(jugador10);
        miLiga.getMisEquipos().get(3).agregarJugador(jugador11);
        miLiga.getMisEquipos().get(3).agregarJugador(jugador12);
        miLiga.getMisEquipos().get(4).agregarJugador(jugador13);
        miLiga.getMisEquipos().get(4).agregarJugador(jugador14);
        miLiga.getMisEquipos().get(4).agregarJugador(jugador15);
        miLiga.getMisEquipos().get(5).agregarJugador(jugador16);
        miLiga.getMisEquipos().get(5).agregarJugador(jugador17);
        miLiga.getMisEquipos().get(5).agregarJugador(jugador18);

        Tecnico tecnico1 = new Tecnico("101", "Guillermo", "Arias", 56, 15, 96000000);
        Tecnico tecnico2 = new Tecnico("102", "Jorge", "Arias", 62, 10, 45000000);
        Tecnico tecnico3 = new Tecnico("103", "Ruben", "Arias", 46, 11, 32000000);
        Tecnico tecnico4 = new Tecnico("104", "Randy", "Arias", 40, 2, 11000000);
        Tecnico tecnico5 = new Tecnico("105", "Rogelio", "Arias", 55, 20, 15000000);
        Tecnico tecnico6 = new Tecnico("106", "Marcelo", "Arias", 59, 8, 32000000);

        miLiga.getMisPersonas().add(tecnico1);
        miLiga.getMisPersonas().add(tecnico2);
        miLiga.getMisPersonas().add(tecnico3);
        miLiga.getMisPersonas().add(tecnico4);
        miLiga.getMisPersonas().add(tecnico5);
        miLiga.getMisPersonas().add(tecnico6);

        miLiga.getMisEquipos().get(0).agregarTecnico(tecnico1);
        miLiga.getMisEquipos().get(1).agregarTecnico(tecnico2);
        miLiga.getMisEquipos().get(2).agregarTecnico(tecnico3);
        miLiga.getMisEquipos().get(3).agregarTecnico(tecnico4);
        miLiga.getMisEquipos().get(4).agregarTecnico(tecnico5);
        miLiga.getMisEquipos().get(5).agregarTecnico(tecnico6);

        Aficionado aficionado1 = new Aficionado("1001", "Jose", "Castro", 26, 10, true);
        Aficionado aficionado2 = new Aficionado("1002", "Marco", "Antonio", 28, 5, false);
        Aficionado aficionado3 = new Aficionado("1003", "Daniel", "Arroyave", 15, 13, true);
        Aficionado aficionado4 = new Aficionado("1004", "Aurelio", "Gonzales", 18, 2, false);
        Aficionado aficionado5 = new Aficionado("1005", "Fidel", "Guerrero", 20, 5, true);
        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado1);
        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado2);
        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado3);
        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado4);
        miLiga.getMisEquipos().get(3).getMisAficionados().add(aficionado5);

        miLiga.getMisPersonas().add(aficionado1);
        miLiga.getMisPersonas().add(aficionado2);
        miLiga.getMisPersonas().add(aficionado3);
        miLiga.getMisPersonas().add(aficionado4);
        miLiga.getMisPersonas().add(aficionado5);

        System.out.println("b. Promedio de edad por cada uno de los equipos (Sólo jugadores)");
        System.out.println("Equipo 1: " + miLiga.getMisEquipos().get(0).promEdad());
        System.out.println("Equipo 2: " + miLiga.getMisEquipos().get(1).promEdad());
        System.out.println("Equipo 3: " + miLiga.getMisEquipos().get(2).promEdad());
        System.out.println("Equipo 4: " + miLiga.getMisEquipos().get(3).promEdad());
        System.out.println("Equipo 5: " + miLiga.getMisEquipos().get(4).promEdad());
        System.out.println("Equipo 6: " + miLiga.getMisEquipos().get(5).promEdad());

        System.out.println("f. Equipo con nómina de jugadores y técnico más alta.");
        System.out.println(miLiga.equipoMayorNomina().getNombre());

        System.out.println("g. Equipo con mayor cantidad de aficionados");
        System.out.println(miLiga.equipoMayorAficionados().getNombre());
        System.out.println("i. Arquero que le han marcado menos goles");
        System.out.println("Nombre: " + miLiga.arqueroMenosGoles().getNombre());

        System.out.println("a. Jugador mas joven de la liga: ");
        System.out.println(miLiga.jugadorMasJoven().getNombre());

        System.out.println("c. Cantidad de partidos en el que un equipo gano por goleada: ");
        System.out.println(miLiga.getMisEquipos().get(3).cantPartidosGoleada());

        System.out.println("e. Jugador que ha marcado mas goles en la liga: ");
        System.out.println(miLiga.jugadorMayorGoles().getNombre());
        
        System.out.println("h. Identificador del partido el cual tuvo más goles");
        System.out.println(miLiga.idPartidoMasGoles());
        
        System.out.println("j. Nombre del estadio donde se marcaron más goles en toda la liga");
        System.out.println(miLiga.nombreEstadioMasGoles());

        initComponents();
        setLocationRelativeTo(null);

    }

    public void limpiarCajas() {
        this.txtCedulaTecnico.setText("");
        this.txtNombreTecnico.setText("");
        this.txtApellidoTecnico.setText("");
        this.txtEdadTecnico.setText("");
        this.txtExperienciaTecnico.setText("");
        this.txtSalarioTecnico.setText("");

        this.txtCedulaAficionado.setText("");
        this.txtNombreAficionado.setText("");
        this.txtApellidoAficionado.setText("");
        this.txtEdadAficionado.setText("");
        this.txtFidelidadAficionado.setText("");
        this.checkAbonoAficionado.setSelected(false);

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
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalarioTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExperienciaTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdadTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedulaTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAgregarTecnico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarTecnico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizarTecnico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarTecnico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarTecnico)))
                .addContainerGap(387, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarTecnico)
                    .addComponent(btnBuscarTecnico)
                    .addComponent(btnActualizarTecnico)
                    .addComponent(btnEliminarTecnico)
                    .addComponent(btnLimpiarTecnico))
                .addContainerGap(147, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFidelidadAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdadAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedulaAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkAbonoAficionado)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnAgregarAficionado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarAficionado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizarAficionado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarAficionado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarAficionado)))
                .addContainerGap(387, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(45, 45, 45)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarAficionado)
                    .addComponent(btnBuscarAficionado)
                    .addComponent(btnActualizarAficionado)
                    .addComponent(btnEliminarAficionado)
                    .addComponent(btnLimpiarAficionado))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Aficionado", jPanel9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Jugador", jPanel10);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Manager", jPanel11);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Equipo", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Estadio", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Partido", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
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
                .addContainerGap(106, Short.MAX_VALUE)
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
            .addGap(0, 811, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
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

    }//GEN-LAST:event_btnAgregarTecnicoActionPerformed

    private void btnBuscarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTecnicoActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula");
        Persona buscarPersona = miLiga.buscarPersona(cedula);
        if (buscarPersona != null) {
            if (buscarPersona instanceof Tecnico) {
                Tecnico tecnico = (Tecnico) buscarPersona;
                this.txtCedulaTecnico.setText(tecnico.getCedula());
                this.txtNombreTecnico.setText(tecnico.getNombre());
                this.txtApellidoTecnico.setText(tecnico.getApellido());
                this.txtEdadTecnico.setText("" + tecnico.getEdad());
                this.txtExperienciaTecnico.setText("" + tecnico.getAniosExperiencia());
                this.txtSalarioTecnico.setText("" + tecnico.getSalario());
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
                this.limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un técnico");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
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
    }//GEN-LAST:event_btnEliminarTecnicoActionPerformed

    private void btnLimpiarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTecnicoActionPerformed
        this.limpiarCajas();
        
        
        this.tablaPosiciones();
    }//GEN-LAST:event_btnLimpiarTecnicoActionPerformed

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
                Aficionado aficionado = (Aficionado) buscarPersona;
                this.txtCedulaAficionado.setText(aficionado.getCedula());
                this.txtNombreAficionado.setText(aficionado.getNombre());
                this.txtApellidoAficionado.setText(aficionado.getApellido());
                this.txtEdadAficionado.setText("" + aficionado.getEdad());
                this.txtFidelidadAficionado.setText("" + aficionado.getAniosFidelidad());
                this.checkAbonoAficionado.setSelected(aficionado.isAbono());
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
            } else {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es de un aficionado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cédula ingresada es incorrecta");
        }
    }//GEN-LAST:event_btnEliminarAficionadoActionPerformed

    private void btnLimpiarAficionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAficionadoActionPerformed
        this.limpiarCajas();
    }//GEN-LAST:event_btnLimpiarAficionadoActionPerformed

    //==========================================================================
    //==========================================================================
    //SECCIÓN PERSONAS -> MANAGER
    //==========================================================================
    //==========================================================================
    //SECCIÓN PERSONAS -> ÁRBITRO
    //==========================================================================
    
    
    
    
    //==========================================================================
    //SECCIÓN TABLA DE POSICIONES
    public void tablaPosiciones(){
        String nombreColumnas[] = {"Posición", "Equipo", "Puntos", "Diferencia de goles", "Partidos jugados"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tblPosiciones.setModel(miModelo);
        LinkedList<Equipo> lista = this.miLiga.tablaPosiciones();
        int cont = 1;
        for (Equipo actual : lista) {
            String fila[] = new String[nombreColumnas.length];
            fila[0] = ""+cont++; 
            fila[1] = actual.getNombre();
            fila[2] = ""+actual.getPuntos();
            fila[3] = ""+(actual.getGolesFavor() - actual.getGolesContra());
            fila[4] = ""+actual.getPartidosJugados();
            miModelo.addRow(fila);
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
    private javax.swing.JButton btnActualizarAficionado;
    private javax.swing.JButton btnActualizarTecnico;
    private javax.swing.JButton btnAgregarAficionado;
    private javax.swing.JButton btnAgregarTecnico;
    private javax.swing.JButton btnBuscarAficionado;
    private javax.swing.JButton btnBuscarTecnico;
    private javax.swing.JButton btnEliminarAficionado;
    private javax.swing.JButton btnEliminarTecnico;
    private javax.swing.JButton btnLimpiarAficionado;
    private javax.swing.JButton btnLimpiarTecnico;
    private javax.swing.JCheckBox checkAbonoAficionado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblPosiciones;
    private javax.swing.JTextField txtApellidoAficionado;
    private javax.swing.JTextField txtApellidoTecnico;
    private javax.swing.JTextField txtCedulaAficionado;
    private javax.swing.JTextField txtCedulaTecnico;
    private javax.swing.JTextField txtEdadAficionado;
    private javax.swing.JTextField txtEdadTecnico;
    private javax.swing.JTextField txtExperienciaTecnico;
    private javax.swing.JTextField txtFidelidadAficionado;
    private javax.swing.JTextField txtNombreAficionado;
    private javax.swing.JTextField txtNombreTecnico;
    private javax.swing.JTextField txtSalarioTecnico;
    // End of variables declaration//GEN-END:variables
}
