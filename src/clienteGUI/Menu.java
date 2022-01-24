/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteGUI;

import clienteBL.ValidarHora;
import clienteBL.EmpleadosBL;
import clienteBL.FlotaBL;
import clienteBL.RutaBL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import clienteBL.VerificarDatos;
import clienteDAL.conexionBD;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import javax.swing.UIManager;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Yisus
 */
public class Menu extends javax.swing.JFrame {

   
    private DefaultTableModel modeloEM;
    private DefaultTableModel modeloFL;
    private DefaultTableModel modeloRU;
    int xx;
    int yy;
    boolean a = true;
    int contem = 0;
    int contruta = 0;
    boolean b = false;
    boolean b11 = false; //verificar datos repetidos de la lista empleado
    boolean b22 = false; //verificar datos repetidos de la lista ruta
    boolean b33 = false; //verificar datos repetios de  la lista flota
    boolean c = false;
    boolean b1 = false;
    boolean b2 = false;
    boolean x = false;
    boolean x1 = false;
    boolean x2 = false;
    boolean x4 = false; //bandera para no repetir la lectura del txt de ruta 
    boolean x5 = false; //bandera para no repetir la lectura del txt empleado
    boolean x6 = false; //bamdera para no repetir la lectura del txt flota


    public Menu() {
        initComponents();
        modeloEM = (DefaultTableModel) jTableEM.getModel();
        modeloFL = (DefaultTableModel) jTableFL.getModel();
        modeloRU = (DefaultTableModel) jTableRu.getModel();

        jTableEM.getTableHeader().setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        jTableFL.getTableHeader().setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        jTableRu.getTableHeader().setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));

    }

    public Menu(JButton Button_guardar, JPanel barra, JPanel buttonAdd, JPanel buttonClose, JPanel buttonMini, JPanel buttonShow, JTextField ciudadDestino, JTextField ciudadOrigen, JComboBox<String> comboConductor, JComboBox<String> comboRuta, JFormattedTextField horadestino, JFormattedTextField horaorigen, JButton jButton1, JButton jButton2, JLabel jLabel1, JLabel jLabel10, JLabel jLabel11, JLabel jLabel12, JLabel jLabel13, JLabel jLabel14, JLabel jLabel15, JLabel jLabel16, JLabel jLabel17, JLabel jLabel18, JLabel jLabel19, JLabel jLabel2, JLabel jLabel3, JLabel jLabel4, JLabel jLabel5, JLabel jLabel6, JLabel jLabel7, JLabel jLabel8, JLabel jLabel9, JPanel jPanel3, JLabel labelingresarBu, JLabel labelingresarEm, JLabel labelingresarRU, JPanel menuShow, JPanel menutodo, JLabel mostrarBu, JLabel mostrarEm1, JLabel mostrarRu, JPanel panelEm, JPanel panelFlo, JPanel panelRu, JTextField txt_cargo, JTextField txt_id, JTextField txtcantidadPasajeros, JTextField txtgalones, JTextField txtnombre, JTextField txtplaca) throws HeadlessException {
        this.Button_guardar = Button_guardar;
        this.barra = barra;
        this.buttonAdd = buttonAdd;
        this.buttonClose = buttonClose;
        this.buttonMini = buttonMini;
        this.buttonShow = buttonShow;
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.comboConductor = comboConductor;
        this.comboRuta = comboRuta;
        //this.horadestino = horadestino;
        //this.horaorigen = horaorigen;
        this.jButton1 = jButton1;

        this.jLabel1 = jLabel1;
        this.jLabel10 = jLabel10;
        //this.jLabel11 = jLabel11;
        this.jLabel12 = jLabel12;
        this.jLabel13 = jLabel13;
        this.jLabel14 = jLabel14;
        this.jLabel15 = jLabel15;
        this.jLabel16 = jLabel16;
        this.jLabel17 = jLabel17;
        this.jLabel18 = jLabel18;
        this.jLabel19 = jLabel19;
        this.jLabel2 = jLabel2;
        this.jLabel3 = jLabel3;
        this.jLabel4 = jLabel4;
        this.jLabel5 = jLabel5;
        this.jLabel6 = jLabel6;
        this.jLabel7 = jLabel7;
        this.jLabel8 = jLabel8;
        this.jLabel9 = jLabel9;
        this.jPanel3 = jPanel3;
        this.labelingresarBu = labelingresarBu;
        this.labelingresarEm = labelingresarEm;
        this.labelingresarRU = labelingresarRU;
        this.menuShow = menuShow;
        this.menutodo = menutodo;
        this.mostrarBu = mostrarBu;
        this.mostrarEm1 = mostrarEm1;
        this.mostrarRu = mostrarRu;
        this.panelEm = panelEm;
        this.panelFlo = panelFlo;
        this.panelRu = panelRu;
        this.txt_cargo = txt_cargo;
        this.txt_id = txt_id;
        this.txtcantidadPasajeros = txtcantidadPasajeros;
        this.txtgalones = txtgalones;
        this.txtnombre = txtnombre;
        this.txtplaca = txtplaca;
    }

    //pasamos datos a la funcion, luego lo implementamos en una clase
    public void verificaRu(String ciudad1, String ciudad2, String hora1, String hora2) {

        int hora11, hora22;
        hora11 = Integer.parseInt(hora1);
        hora22 = Integer.parseInt(hora2);

        if (ciudad1.equals("") || ciudad2.equals("")) {
            x1 = true;

        }

        if (ExcepcionesStr(ciudad1) == true || ExcepcionesStr(ciudad2) == true) {
            JOptionPane.showConfirmDialog(null, "Formato incorrecto");
        }

    }

    public void menuHide(JPanel menushow, boolean dashboard) {
        if (dashboard == true) {
            menushow.setPreferredSize(new Dimension(50, menushow.getHeight()));
        } else {

            menushow.setPreferredSize(new Dimension(250, menushow.getHeight()));
            //buttonAdd.setBackground(Color.BLACK);

        }

    }

    

   

    public boolean ExcepcionesIndex(int num1, int num2) {
        boolean d = false;

        try {
            if (num1 > num2);
        } catch (Exception e) {
            System.out.println("funciona la excepcion");
            d = true;
        }
        return d;

    }

    public boolean ExcepcionesIn(String dato) {
        boolean d = false;
        try {
            int aux = Integer.parseInt(dato);
        } catch (Exception e) {
            d = true;
        }

        return d;
    }

    public boolean ExcepcionesStr(String dato) {
        boolean d = false;

        for (int i = 0; i < dato.length(); i++) {
            char caracter = dato.toUpperCase().charAt(i);
            int valorASCII = (int) caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
                d = true;
            }
        }

        return d;

    }

    void verificarEm(String dato, String name, String cargo1) {
        b = false;
        c = false;

//        for (int i = 0; i < listaEmpleado.size(); i++) {
//            if (listaEmpleado.get(i).getIdentificacion().equalsIgnoreCase(dato)) {
//                b = true;
//
//            }
//
//        }
        if (dato.equals("") || name.equals("") || cargo1.equals("")) {
            c = true;

        }

        if (ExcepcionesIn(dato) == true) {
            JOptionPane.showConfirmDialog(null, "Ingrese un numero entero");
            txt_id.setText("");

        }

        if (ExcepcionesStr(name) == true) {
            JOptionPane.showConfirmDialog(null, "nombre invalido");

        }

        if (ExcepcionesStr(cargo1) == true) {
            JOptionPane.showConfirmDialog(null, "cargo invalido");

        }

    }

    void mostrarcomboconductor() {

        String nombre = "";
        String cargo = "";
        EmpleadosBL objempleado = new EmpleadosBL();
        comboConductor.removeAllItems();

        try {

            conexionBD objConexion = new conexionBD();

            ResultSet resultado = objempleado.mostrarDatoEmpleado();
            while (resultado.next()) {

                nombre = resultado.getString("nombreEM");
                cargo = resultado.getString("cargoEM");

                if (cargo.equals("conductor")) {

                    comboConductor.addItem(nombre);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void editarempleado() {

        int fila = jTableEM.getSelectedRow();
        EmpleadosBL obtempleado = new EmpleadosBL();

        System.out.println("fila: " + jTableEM.getValueAt(fila, 1));
        conexionBD objConexion = new conexionBD();

        String id = String.valueOf(jTableEM.getValueAt(fila, 1));

        String nombre = String.valueOf(jTableEM.getValueAt(fila, 0));
        String cargo = String.valueOf(jTableEM.getValueAt(fila, 2));
        obtempleado.editarDatoEmpleado(nombre, id, cargo);

    }
    
    void editarFlota(){
        
        int fila = jTableFL.getSelectedRow();
        FlotaBL objFlota = new FlotaBL();

        System.out.println("fila: " + jTableFL.getValueAt(fila, 1));
        conexionBD objConexion = new conexionBD();

        String placa = String.valueOf(jTableFL.getValueAt(fila, 0));

        String pasajero  = String.valueOf(jTableFL.getValueAt(fila, 1));
        String galones = String.valueOf(jTableFL.getValueAt(fila, 2));
        String ruta = String.valueOf(jTableFL.getValueAt(fila, 3));
        String conductor = String.valueOf(jTableFL.getValueAt(fila, 4));
        objFlota.editarDatoFlota(placa, pasajero, galones, conductor, ruta);

    
    }

    void  editarRuta(){
        
        int fila = jTableRu.getSelectedRow();
        RutaBL objRuta = new RutaBL();

        System.out.println("fila: " + jTableRu.getValueAt(fila, 0));
        conexionBD objConexion = new conexionBD();

        
         String id = String.valueOf(jTableRu.getValueAt(fila, 0));
        String ciudad1 = String.valueOf(jTableRu.getValueAt(fila, 1));

        String ciudad2  = String.valueOf(jTableRu.getValueAt(fila, 2));
        String hora1 = String.valueOf(jTableRu.getValueAt(fila, 3));
        String hora2 = String.valueOf(jTableRu.getValueAt(fila, 4));
       
        objRuta.editarDatoRuta(ciudad1, ciudad2, hora1, hora2, id);

    
    }
    
    
    void mostrarcomboruta() {

        String ruta = "";

        RutaBL obtrutas = new RutaBL();

        comboRuta.removeAllItems();

        try {

            conexionBD objConexion = new conexionBD();

            ResultSet resultado = obtrutas.mostrarDatoRuta();
            while (resultado.next()) {

                ruta = resultado.getString("ciudadorigenRUT") + "-" + resultado.getString("ciudaddestinoRUT");

                comboRuta.addItem(ruta);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void eliminarempleado() {

        int fila = jTableEM.getSelectedRow();
        EmpleadosBL objempleado = new EmpleadosBL();
        System.out.println("fila: " + jTableEM.getValueAt(fila, 1));
        conexionBD objConexion = new conexionBD();

        String id = String.valueOf(jTableEM.getValueAt(fila, 1));
        modeloEM.removeRow(fila);

        objempleado.eliminarDatoEmpleado(id);

    }
    
    void eliminarFlota(){
        
        int fila = jTableFL.getSelectedRow();
        FlotaBL objFlota = new FlotaBL();
        System.out.println("fila: " + jTableFL.getValueAt(fila, 0));
        conexionBD objConexion = new conexionBD();

        String placa = String.valueOf(jTableFL.getValueAt(fila, 0));
        modeloFL.removeRow(fila);

        objFlota.eliminarDatoFloata(placa);
    }
    

    void eliminarRuta(){
        
        int fila = jTableRu.getSelectedRow();
        RutaBL objRuta = new RutaBL();
        System.out.println("fila: " + jTableRu.getValueAt(fila, 0));
        conexionBD objConexion = new conexionBD();

        String id = String.valueOf(jTableRu.getValueAt(fila, 0));
        modeloRU.removeRow(fila);

        objRuta.eliminarDatoRuta(id);
    
    }
  
   

    public void ingresarEmpleado() {

        String id;
        String nombre;
        String cargo;

        id = txt_id.getText();
        nombre = txtnombre.getText();
        cargo = txt_cargo.getText();

        verificarEm(id, nombre, cargo);

        if (c == true) {
            JOptionPane.showConfirmDialog(null, "datos incompletos");

        }

        if (b == false && c == false) {

            int id1 = Integer.parseInt(id);
            EmpleadosBL em = new EmpleadosBL(id1, nombre, cargo);

            em.ingresarEmpleadoBL(em);

            mostrarempleado();
            txt_id.setText("");
            txtnombre.setText("");
            txt_cargo.setText("");

        }

    }

    int Obtenerfilatabla() {
        int fila = jTableEM.getSelectedRow();
        jTableEM.remove(fila);
        return fila;

    }

    public void ingresarRuta() {

        String hora1, hora2, min1, min2;
        hora1 = combohora1.getSelectedItem().toString();
        min1 = combominute1.getSelectedItem().toString();
        hora2 = combohora2.getSelectedItem().toString();
        min2 = combominute2.getSelectedItem().toString();
        String horasalida = hora1 + ":" + min1;
        String horallegada = hora2 + ":" + min2;

        verificaRu(ciudadOrigen.getText().toString(), ciudadDestino.getText().toString(), hora1, hora2);

        if (x1 == true) {
            JOptionPane.showConfirmDialog(null, "Datos incompletos");

        }

        if (x2 == true) {
            JOptionPane.showConfirmDialog(null, "Datos iguales");
            ciudadOrigen.setText("");
            ciudadDestino.setText("");

        }

        if (x == false && x1 == false && x2 == false) {

            RutaBL ru = new RutaBL(ciudadOrigen.getText(), horasalida, ciudadDestino.getText(), horallegada);

            ru.ingresarRutaBL(ru);

            ciudadOrigen.setText("");
            ciudadDestino.setText("");

        }

    }

    

    public void mostrarempleado() {
        int cont = 0;
        modeloEM.setRowCount(0);
        try {
            EmpleadosBL objEmpleado = new EmpleadosBL();
            conexionBD objConexion = new conexionBD();
            ResultSet resultado = objEmpleado.mostrarDatoEmpleado();

            while (resultado.next()) {

                Object[] objCliente = {resultado.getString("nombreEM"), resultado.getString("identificacionEM"), resultado.getString("cargoEM")};
                modeloEM.addRow(objCliente);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    public void mostrarflota(){
         int cont = 0;
        modeloFL.setRowCount(0);
        try {
            FlotaBL objFlota= new FlotaBL();
            conexionBD objConexion = new conexionBD();
            ResultSet resultado = objFlota.mostrarDatoFlota();

            while (resultado.next()) {

                Object[] objCliente = {resultado.getString("placaBUS"), resultado.getString("pasajeroBUS"), resultado.getString("galonBUS"),resultado.getString("rutaBUS"),resultado.getString("conductorBUS")};
                modeloFL.addRow(objCliente);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    
    public void  mostrarRuta(){
        
          
        modeloRU.setRowCount(0);
        try {
            RutaBL objRuta= new RutaBL();
            conexionBD objConexion = new conexionBD();
            ResultSet resultado = objRuta.mostrarDatoRuta();

            while (resultado.next()) {

                Object[] objCliente = {resultado.getString("idRUT"), resultado.getString("ciudadorigenRUT"), resultado.getString("horasalidadRUT"),resultado.getString("ciudaddestinoRUT"),resultado.getString("horallegadaRUT")};
                modeloRU.addRow(objCliente);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
    
    
    }
    
    public void ingresarFlota() {

        String cantidadpasa = txtcantidadPasajeros.getText();
        String cantidadGalones = txtgalones.getText();
        String comboru = comboRuta.getSelectedItem().toString();
        String comboconduc = comboConductor.getSelectedItem().toString();

        FlotaBL flo = new FlotaBL(txtplaca.getText(), cantidadpasa, cantidadGalones, comboru, comboconduc);
        flo.ingresarFlotaBL(flo);

        txtcantidadPasajeros.setText("");
        txtplaca.setText("");
        txtgalones.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra = new javax.swing.JPanel();
        buttonClose = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonMini = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        menuShow = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        buttonAdd = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        buttonShow = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        labelingresarBu = new javax.swing.JLabel();
        mostrarBu = new javax.swing.JLabel();
        labelingresarEm = new javax.swing.JLabel();
        labelingresarRU = new javax.swing.JLabel();
        mostrarEm1 = new javax.swing.JLabel();
        mostrarRu = new javax.swing.JLabel();
        menutodo = new javax.swing.JPanel();
        panelEm = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JTextField();
        Button_guardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        panelMostrarEM = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEM = new javax.swing.JTable();
        panelmostrarFL = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFL = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        panelMostrarRU = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRu = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        panelFlo = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtplaca = new javax.swing.JTextField();
        txtcantidadPasajeros = new javax.swing.JTextField();
        txtgalones = new javax.swing.JTextField();
        comboConductor = new javax.swing.JComboBox<>();
        comboRuta = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jButton13 = new javax.swing.JButton();
        panelRu = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ciudadOrigen = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ciudadDestino = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        combominute1 = new javax.swing.JComboBox<>();
        combohora1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        combohora2 = new javax.swing.JComboBox<>();
        combominute2 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        barra.setBackground(new java.awt.Color(119, 141, 169));
        barra.setPreferredSize(new java.awt.Dimension(960, 50));
        barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMouseDragged(evt);
            }
        });
        barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMousePressed(evt);
            }
        });

        buttonClose.setBackground(new java.awt.Color(119, 141, 169));
        buttonClose.setPreferredSize(new java.awt.Dimension(50, 50));
        buttonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCloseMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_delete_30px.png"))); // NOI18N

        javax.swing.GroupLayout buttonCloseLayout = new javax.swing.GroupLayout(buttonClose);
        buttonClose.setLayout(buttonCloseLayout);
        buttonCloseLayout.setHorizontalGroup(
            buttonCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonCloseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        buttonCloseLayout.setVerticalGroup(
            buttonCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonCloseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonMini.setBackground(new java.awt.Color(119, 141, 169));
        buttonMini.setPreferredSize(new java.awt.Dimension(50, 50));
        buttonMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMiniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMiniMouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_horizontal_line_30px.png"))); // NOI18N

        javax.swing.GroupLayout buttonMiniLayout = new javax.swing.GroupLayout(buttonMini);
        buttonMini.setLayout(buttonMiniLayout);
        buttonMiniLayout.setHorizontalGroup(
            buttonMiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonMiniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        buttonMiniLayout.setVerticalGroup(
            buttonMiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonMiniLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout barraLayout = new javax.swing.GroupLayout(barra);
        barra.setLayout(barraLayout);
        barraLayout.setHorizontalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraLayout.createSequentialGroup()
                .addGap(0, 920, Short.MAX_VALUE)
                .addComponent(buttonMini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barraLayout.setVerticalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMini, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(barra, java.awt.BorderLayout.PAGE_START);

        menuShow.setBackground(new java.awt.Color(53, 58, 71));
        menuShow.setPreferredSize(new java.awt.Dimension(250, 522));
        menuShow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(53, 58, 71));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 522));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonAdd.setBackground(new java.awt.Color(53, 58, 71));
        buttonAdd.setPreferredSize(new java.awt.Dimension(50, 50));
        buttonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAddMouseExited(evt);
            }
        });
        buttonAdd.setLayout(new java.awt.GridBagLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_add_user_group_man_man_30px.png"))); // NOI18N
        buttonAdd.add(jLabel4, new java.awt.GridBagConstraints());

        jPanel3.add(buttonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        buttonShow.setBackground(new java.awt.Color(53, 58, 71));

        jLabel6.setBackground(new java.awt.Color(53, 58, 71));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_show_property_30px_1.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonShowLayout = new javax.swing.GroupLayout(buttonShow);
        buttonShow.setLayout(buttonShowLayout);
        buttonShowLayout.setHorizontalGroup(
            buttonShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonShowLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        buttonShowLayout.setVerticalGroup(
            buttonShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonShowLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(buttonShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, 50));

        menuShow.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        labelingresarBu.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        labelingresarBu.setForeground(new java.awt.Color(255, 255, 255));
        labelingresarBu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelingresarBu.setText("Ingresar Flota");
        labelingresarBu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        labelingresarBu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelingresarBu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelingresarBuMouseClicked(evt);
            }
        });
        menuShow.add(labelingresarBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 180, 30));

        mostrarBu.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        mostrarBu.setForeground(new java.awt.Color(255, 255, 255));
        mostrarBu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarBu.setText("Mostrar Buses");
        mostrarBu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        mostrarBu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarBu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarBuMouseClicked(evt);
            }
        });
        menuShow.add(mostrarBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 180, 30));

        labelingresarEm.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        labelingresarEm.setForeground(new java.awt.Color(255, 255, 255));
        labelingresarEm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelingresarEm.setText("Ingresar Empleados");
        labelingresarEm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        labelingresarEm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelingresarEm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelingresarEmMouseClicked(evt);
            }
        });
        menuShow.add(labelingresarEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 180, 30));

        labelingresarRU.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        labelingresarRU.setForeground(new java.awt.Color(255, 255, 255));
        labelingresarRU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelingresarRU.setText("Ingresar Rutas");
        labelingresarRU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        labelingresarRU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelingresarRU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelingresarRUMouseClicked(evt);
            }
        });
        menuShow.add(labelingresarRU, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 180, 30));

        mostrarEm1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        mostrarEm1.setForeground(new java.awt.Color(255, 255, 255));
        mostrarEm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarEm1.setText("Mostrar Empleados");
        mostrarEm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        mostrarEm1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarEm1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarEm1MouseClicked(evt);
            }
        });
        menuShow.add(mostrarEm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 180, 30));

        mostrarRu.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        mostrarRu.setForeground(new java.awt.Color(255, 255, 255));
        mostrarRu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarRu.setText("Mostrar Rutas");
        mostrarRu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        mostrarRu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarRu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarRuMouseClicked(evt);
            }
        });
        menuShow.add(mostrarRu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 180, 30));

        getContentPane().add(menuShow, java.awt.BorderLayout.LINE_START);

        menutodo.setBackground(new java.awt.Color(30, 33, 40));
        menutodo.setLayout(new java.awt.CardLayout());

        panelEm.setBackground(new java.awt.Color(224, 225, 221));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Empleados");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("identificacion: ");

        txtnombre.setBackground(new java.awt.Color(224, 225, 221));
        txtnombre.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        txtnombre.setBorder(null);
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("nombre:");

        txt_id.setBackground(new java.awt.Color(224, 225, 221));
        txt_id.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        txt_id.setBorder(null);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Cargo:");

        txt_cargo.setBackground(new java.awt.Color(224, 225, 221));
        txt_cargo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        txt_cargo.setBorder(null);
        txt_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cargoActionPerformed(evt);
            }
        });

        Button_guardar.setBackground(new java.awt.Color(224, 225, 221));
        Button_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.1.png"))); // NOI18N
        Button_guardar.setBorder(null);
        Button_guardar.setContentAreaFilled(false);
        Button_guardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.2.png"))); // NOI18N
        Button_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEmLayout = new javax.swing.GroupLayout(panelEm);
        panelEm.setLayout(panelEmLayout);
        panelEmLayout.setHorizontalGroup(
            panelEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
            .addGroup(panelEmLayout.createSequentialGroup()
                .addGroup(panelEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmLayout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(panelEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEmLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(Button_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        panelEmLayout.setVerticalGroup(
            panelEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );

        menutodo.add(panelEm, "card2");

        panelMostrarEM.setBackground(new java.awt.Color(224, 225, 221));
        panelMostrarEM.setForeground(new java.awt.Color(0, 0, 0));
        panelMostrarEM.setAlignmentX(0.0F);
        panelMostrarEM.setAlignmentY(0.0F);

        jButton3.setBackground(new java.awt.Color(224, 225, 221));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/leertxtem1.1.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/leertxtem1.2.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(224, 225, 221));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarem1.1.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarem1.2.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(224, 225, 221));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/elimarem1.1.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarem1.2.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTableEM.setBackground(new java.awt.Color(224, 225, 221));
        jTableEM.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jTableEM.setForeground(new java.awt.Color(0, 0, 0));
        jTableEM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Identificacion", "Cargo"
            }
        ));
        jTableEM.setToolTipText("");
        jTableEM.setAutoscrolls(false);
        jTableEM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableEM.setFocusable(false);
        jTableEM.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableEM.setMaximumSize(new java.awt.Dimension(2147483647, 80));
        jTableEM.setOpaque(true);
        jTableEM.setRowHeight(40);
        jTableEM.setSelectionBackground(new java.awt.Color(129, 128, 138));
        jTableEM.setShowVerticalLines(false);
        jTableEM.getTableHeader().setReorderingAllowed(false);
        jTableEM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEM);

        javax.swing.GroupLayout panelMostrarEMLayout = new javax.swing.GroupLayout(panelMostrarEM);
        panelMostrarEM.setLayout(panelMostrarEMLayout);
        panelMostrarEMLayout.setHorizontalGroup(
            panelMostrarEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarEMLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(panelMostrarEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMostrarEMLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
        );
        panelMostrarEMLayout.setVerticalGroup(
            panelMostrarEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarEMLayout.createSequentialGroup()
                .addGroup(panelMostrarEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMostrarEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMostrarEMLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarEMLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMostrarEMLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        menutodo.add(panelMostrarEM, "card5");

        panelmostrarFL.setBackground(new java.awt.Color(224, 225, 221));

        jTableFL.setBackground(new java.awt.Color(224, 225, 221));
        jTableFL.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jTableFL.setForeground(new java.awt.Color(0, 0, 0));
        jTableFL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Pasajeros", "Galones", "Ruta", "Conductor"
            }
        ));
        jTableFL.setRowHeight(35);
        jTableFL.setSelectionBackground(new java.awt.Color(129, 128, 138));
        jTableFL.setShowHorizontalLines(false);
        jTableFL.setShowVerticalLines(false);
        jTableFL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFL);

        jButton7.setBackground(new java.awt.Color(224, 225, 221));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/leertxtem1.1.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/leertxtem1.2.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(224, 225, 221));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarem1.1.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setContentAreaFilled(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarem1.2.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(224, 225, 221));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/elimarem1.1.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setContentAreaFilled(false);
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarem1.2.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelmostrarFLLayout = new javax.swing.GroupLayout(panelmostrarFL);
        panelmostrarFL.setLayout(panelmostrarFLLayout);
        panelmostrarFLLayout.setHorizontalGroup(
            panelmostrarFLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmostrarFLLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelmostrarFLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelmostrarFLLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panelmostrarFLLayout.setVerticalGroup(
            panelmostrarFLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelmostrarFLLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(panelmostrarFLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        menutodo.add(panelmostrarFL, "card7");

        panelMostrarRU.setBackground(new java.awt.Color(224, 225, 221));

        jTableRu.setBackground(new java.awt.Color(224, 225, 221));
        jTableRu.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jTableRu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Ruta", "Ciudad Origen", "Ciudad Destino", "Hora Salida", "Hora Llegada"
            }
        ));
        jTableRu.setRowHeight(35);
        jTableRu.setSelectionBackground(new java.awt.Color(129, 128, 138));
        jTableRu.setShowVerticalLines(false);
        jTableRu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableRu);

        jButton6.setBackground(new java.awt.Color(224, 225, 221));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/leertxtem1.1.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/leertxtem1.2.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(224, 225, 221));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarem1.1.png"))); // NOI18N
        jButton10.setBorder(null);
        jButton10.setContentAreaFilled(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarem1.2.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(224, 225, 221));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/elimarem1.1.png"))); // NOI18N
        jButton11.setBorder(null);
        jButton11.setContentAreaFilled(false);
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarem1.2.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMostrarRULayout = new javax.swing.GroupLayout(panelMostrarRU);
        panelMostrarRU.setLayout(panelMostrarRULayout);
        panelMostrarRULayout.setHorizontalGroup(
            panelMostrarRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarRULayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panelMostrarRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMostrarRULayout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        panelMostrarRULayout.setVerticalGroup(
            panelMostrarRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMostrarRULayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(panelMostrarRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        menutodo.add(panelMostrarRU, "card6");

        panelFlo.setBackground(new java.awt.Color(224, 225, 221));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Ingresar Buses");

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Placa:");

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Cantidad de pasajeros:");

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Galones:");

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Conductor:");

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Ruta:");

        txtplaca.setBackground(new java.awt.Color(224, 225, 221));
        txtplaca.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        txtplaca.setBorder(null);

        txtcantidadPasajeros.setBackground(new java.awt.Color(224, 225, 221));
        txtcantidadPasajeros.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        txtcantidadPasajeros.setBorder(null);

        txtgalones.setBackground(new java.awt.Color(224, 225, 221));
        txtgalones.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        txtgalones.setBorder(null);

        comboConductor.setBackground(new java.awt.Color(224, 225, 221));
        comboConductor.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        comboConductor.setBorder(null);
        comboConductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboConductorMouseClicked(evt);
            }
        });
        comboConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboConductorActionPerformed(evt);
            }
        });

        comboRuta.setBackground(new java.awt.Color(224, 225, 221));
        comboRuta.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        comboRuta.setBorder(null);
        comboRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboRutaMouseClicked(evt);
            }
        });
        comboRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRutaActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));

        jButton13.setBackground(new java.awt.Color(224, 225, 221));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.1.png"))); // NOI18N
        jButton13.setBorder(null);
        jButton13.setContentAreaFilled(false);
        jButton13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.2.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFloLayout = new javax.swing.GroupLayout(panelFlo);
        panelFlo.setLayout(panelFloLayout);
        panelFloLayout.setHorizontalGroup(
            panelFloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFloLayout.createSequentialGroup()
                .addGroup(panelFloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFloLayout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFloLayout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addGroup(panelFloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtcantidadPasajeros)
                            .addComponent(jLabel17)
                            .addComponent(txtgalones, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtplaca)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5)
                            .addComponent(comboConductor, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );
        panelFloLayout.setVerticalGroup(
            panelFloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFloLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcantidadPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtgalones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        menutodo.add(panelFlo, "card4");

        panelRu.setBackground(new java.awt.Color(224, 225, 221));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ruta");

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Ciudad Origen:");

        ciudadOrigen.setBackground(new java.awt.Color(224, 225, 221));
        ciudadOrigen.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        ciudadOrigen.setForeground(new java.awt.Color(0, 0, 0));
        ciudadOrigen.setBorder(null);
        ciudadOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudadOrigenActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Ciudad Destino:");

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Hora Llegada:");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ciudadDestino.setBackground(new java.awt.Color(224, 225, 221));
        ciudadDestino.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        ciudadDestino.setForeground(new java.awt.Color(0, 0, 0));
        ciudadDestino.setBorder(null);

        jButton1.setBackground(new java.awt.Color(224, 225, 221));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.1.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        combominute1.setBackground(new java.awt.Color(224, 225, 221));
        combominute1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        combominute1.setForeground(new java.awt.Color(0, 0, 0));
        combominute1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));
        combominute1.setBorder(null);
        combominute1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combominute1ActionPerformed(evt);
            }
        });

        combohora1.setBackground(new java.awt.Color(224, 225, 221));
        combohora1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        combohora1.setForeground(new java.awt.Color(0, 0, 0));
        combohora1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", " " }));
        combohora1.setBorder(null);
        combohora1.setMinimumSize(new java.awt.Dimension(48, 26));
        combohora1.setName(""); // NOI18N
        combohora1.setPreferredSize(new java.awt.Dimension(48, 26));
        combohora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohora1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText(":");

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText(":");

        combohora2.setBackground(new java.awt.Color(224, 225, 221));
        combohora2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        combohora2.setForeground(new java.awt.Color(0, 0, 0));
        combohora2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        combohora2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohora2ActionPerformed(evt);
            }
        });

        combominute2.setBackground(new java.awt.Color(224, 225, 221));
        combominute2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        combominute2.setForeground(new java.awt.Color(0, 0, 0));
        combominute2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));
        combominute2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combominute2ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Hora Salida:");

        javax.swing.GroupLayout panelRuLayout = new javax.swing.GroupLayout(panelRu);
        panelRu.setLayout(panelRuLayout);
        panelRuLayout.setHorizontalGroup(
            panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRuLayout.createSequentialGroup()
                .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRuLayout.createSequentialGroup()
                        .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRuLayout.createSequentialGroup()
                                .addContainerGap(259, Short.MAX_VALUE)
                                .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combohora1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelRuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(combohora2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRuLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combominute1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRuLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combominute2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ciudadOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addComponent(jSeparator7))
                            .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12)
                                .addComponent(ciudadDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                .addComponent(jSeparator8)))))
                .addGap(280, 280, 280))
            .addGroup(panelRuLayout.createSequentialGroup()
                .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRuLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRuLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRuLayout.setVerticalGroup(
            panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRuLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ciudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combohora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combominute1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ciudadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(8, 8, 8)
                .addGroup(panelRuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combohora2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combominute2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        menutodo.add(panelRu, "card3");
        panelRu.getAccessibleContext().setAccessibleName("");

        getContentPane().add(menutodo, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseEntered
//        buttonClose.setBackground(new Color(39, 44, 52));
    }//GEN-LAST:event_buttonCloseMouseEntered

    private void buttonCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseExited
//        buttonClose.setBackground(new Color(26, 29, 34));
    }//GEN-LAST:event_buttonCloseMouseExited

    private void buttonMiniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMiniMouseEntered
//        buttonMini.setBackground(new Color(39, 44, 52));
    }//GEN-LAST:event_buttonMiniMouseEntered

    private void buttonMiniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMiniMouseExited
//        buttonMini.setBackground(new Color(26, 29, 34));
    }//GEN-LAST:event_buttonMiniMouseExited

    private void buttonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_buttonCloseMouseClicked

    private void buttonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseClicked
        labelingresarBu.setVisible(true);
        labelingresarEm.setVisible(true);
        labelingresarRU.setVisible(true);
        mostrarBu.setVisible(false);
        mostrarEm1.setVisible(false);
        mostrarRu.setVisible(false);

        if (a == true) {

            menuHide(menuShow, a);
            SwingUtilities.updateComponentTreeUI(this);
            labelingresarBu.setVisible(true);
            labelingresarEm.setVisible(true);
            labelingresarRU.setVisible(true);
            mostrarBu.setVisible(false);
            mostrarEm1.setVisible(false);
            mostrarRu.setVisible(false);

            a = false;
        } else {
            menuHide(menuShow, a);
            SwingUtilities.updateComponentTreeUI(this);
            a = true;
        }
    }//GEN-LAST:event_buttonAddMouseClicked

    private void buttonAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseEntered
        // buttonAdd.setBackground(new Color(53,58,71));
    }//GEN-LAST:event_buttonAddMouseEntered

    private void buttonAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseExited
        //buttonAdd.setBackground(new Color(26, 29, 34));
    }//GEN-LAST:event_buttonAddMouseExited

    private void mostrarBuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrarBuMouseClicked
        panelEm.setVisible(false);
        panelFlo.setVisible(false);
        panelRu.setVisible(false);
        panelMostrarEM.setVisible(false);
        panelmostrarFL.setVisible(true);
        panelMostrarRU.setVisible(false);

    }//GEN-LAST:event_mostrarBuMouseClicked

    private void labelingresarBuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelingresarBuMouseClicked

        panelEm.setVisible(false);
        panelFlo.setVisible(true);
        panelRu.setVisible(false);
        panelMostrarRU.setVisible(false);
        panelMostrarEM.setVisible(false);
        panelmostrarFL.setVisible(false);
    }//GEN-LAST:event_labelingresarBuMouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        //buttonShow.setBackground(new Color(39, 44, 52));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // buttonShow.setBackground(new Color(26, 29, 34));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

        mostrarBu.setVisible(true);
        mostrarEm1.setVisible(true);
        mostrarRu.setVisible(true);

        labelingresarRU.setVisible(false);
        labelingresarEm.setVisible(false);
        labelingresarBu.setVisible(false);

        if (a == true) {

            menuHide(menuShow, a);
            SwingUtilities.updateComponentTreeUI(this);

            labelingresarBu.setVisible(false);
            labelingresarEm.setVisible(false);
            labelingresarRU.setVisible(false);

            mostrarBu.setVisible(true);
            mostrarEm1.setVisible(true);
            mostrarRu.setVisible(true);
            a = false;
        } else {
            menuHide(menuShow, a);
            SwingUtilities.updateComponentTreeUI(this);
            a = true;
        }


    }//GEN-LAST:event_jLabel6MouseClicked

    private void labelingresarEmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelingresarEmMouseClicked
        panelEm.setVisible(true);
        panelFlo.setVisible(false);
        panelRu.setVisible(false);
        panelMostrarRU.setVisible(false);
        panelMostrarEM.setVisible(false);
        panelmostrarFL.setVisible(false);

    }//GEN-LAST:event_labelingresarEmMouseClicked

    private void labelingresarRUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelingresarRUMouseClicked
        panelEm.setVisible(false);
        panelFlo.setVisible(false);
        panelRu.setVisible(true);
        panelMostrarRU.setVisible(false);
        panelMostrarEM.setVisible(false);
        panelmostrarFL.setVisible(false);
    }//GEN-LAST:event_labelingresarRUMouseClicked

    private void mostrarEm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrarEm1MouseClicked

        panelEm.setVisible(false);
        panelFlo.setVisible(false);
        panelRu.setVisible(false);
        panelMostrarEM.setVisible(true);
        panelmostrarFL.setVisible(false);
        panelMostrarRU.setVisible(false);
    }//GEN-LAST:event_mostrarEm1MouseClicked

    private void mostrarRuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrarRuMouseClicked
        panelEm.setVisible(false);
        panelFlo.setVisible(false);
        panelRu.setVisible(false);
        panelmostrarFL.setVisible(false);
        panelMostrarRU.setVisible(true);
        panelMostrarEM.setVisible(false);
    }//GEN-LAST:event_mostrarRuMouseClicked

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cargoActionPerformed

    private void Button_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_guardarActionPerformed
        ingresarEmpleado();
    }//GEN-LAST:event_Button_guardarActionPerformed

    private void ciudadOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudadOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadOrigenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ingresarRuta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboConductorActionPerformed

    }//GEN-LAST:event_comboConductorActionPerformed

    private void comboConductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboConductorMouseClicked
        mostrarcomboconductor();
        // leertxtEM();
    }//GEN-LAST:event_comboConductorMouseClicked

    private void comboRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboRutaMouseClicked
        mostrarcomboruta();
    }//GEN-LAST:event_comboRutaMouseClicked

    private void combominute1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combominute1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combominute1ActionPerformed

    private void combohora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combohora1ActionPerformed

    private void combohora2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohora2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combohora2ActionPerformed

    private void combominute2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combominute2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combominute2ActionPerformed

    private void comboRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRutaActionPerformed
        //  mostrarcomboruta();
    }//GEN-LAST:event_comboRutaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        mostrarempleado();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTableEMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEMMouseClicked
        editarempleado();
    }//GEN-LAST:event_jTableEMMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        eliminarempleado();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        editarempleado();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        mostrarflota();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        editarFlota();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        mostrarRuta();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        editarRuta();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        eliminarFlota();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        eliminarRuta();

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        ingresarFlota();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        xx = evt.getX();
        yy = evt.getY();

    }//GEN-LAST:event_barraMousePressed

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - xx, this.getLocation().y + evt.getY() - yy);
    }//GEN-LAST:event_barraMouseDragged

    private void jTableFLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFLMouseClicked
       editarFlota();
    }//GEN-LAST:event_jTableFLMouseClicked

    private void jTableRuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRuMouseClicked
        editarRuta();
    }//GEN-LAST:event_jTableRuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_guardar;
    private javax.swing.JPanel barra;
    private javax.swing.JPanel buttonAdd;
    private javax.swing.JPanel buttonClose;
    private javax.swing.JPanel buttonMini;
    private javax.swing.JPanel buttonShow;
    private javax.swing.JTextField ciudadDestino;
    private javax.swing.JTextField ciudadOrigen;
    private javax.swing.JComboBox<String> comboConductor;
    private javax.swing.JComboBox<String> comboRuta;
    private javax.swing.JComboBox<String> combohora1;
    private javax.swing.JComboBox<String> combohora2;
    private javax.swing.JComboBox<String> combominute1;
    private javax.swing.JComboBox<String> combominute2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTableEM;
    private javax.swing.JTable jTableFL;
    private javax.swing.JTable jTableRu;
    private javax.swing.JLabel labelingresarBu;
    private javax.swing.JLabel labelingresarEm;
    private javax.swing.JLabel labelingresarRU;
    private javax.swing.JPanel menuShow;
    private javax.swing.JPanel menutodo;
    private javax.swing.JLabel mostrarBu;
    private javax.swing.JLabel mostrarEm1;
    private javax.swing.JLabel mostrarRu;
    private javax.swing.JPanel panelEm;
    private javax.swing.JPanel panelFlo;
    private javax.swing.JPanel panelMostrarEM;
    private javax.swing.JPanel panelMostrarRU;
    private javax.swing.JPanel panelRu;
    private javax.swing.JPanel panelmostrarFL;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txtcantidadPasajeros;
    private javax.swing.JTextField txtgalones;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtplaca;
    // End of variables declaration//GEN-END:variables
}
