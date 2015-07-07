package Vista;

import Entidades.UsuarioEnt;
import Negocio.UsuarioNg;
import javax.swing.*;            // para los botones
import java.awt.*;               //Paquete que contiene imagenes y eventos "awt"
import java.awt.event.*;
import Vista.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    JLabel jlbAirlineTravel, cancelar;
    JLabel jlbNombre, jlbCorreo, jlbimage;
    JLabel jlb_x1, jlb_x2;

    JButton jbtnInicio;
    JButton jbtnUsuarios;
    JButton jbtnAviones;
    JButton jbtnViajes;
    JButton jbtnVuelos;
    JButton jbtnReservas;
    JButton jbtnCerrarSesion;
    JButton jbtnPerfil, jbtnGuardar;
    JButton jbtnAyuda;
    JButton jbtnContactanos;

    JPanel jpMovedor, jpInicio;

    Perfil jpPerfil = new Perfil();
    Usuarios jpUsuarios = new Usuarios();
    Aviones jpAviones = new Aviones();
    Viajes jpViajes = new Viajes();
    Vuelos jpVuelos = new Vuelos();
    Reservas jpReservas = new Reservas();
    Ayuda jpAyuda = new Ayuda();
    Contactanos jpContactanos = new Contactanos();

    String Correo, Clave, Nombre, Apellido, Telefono, Celular;

    int x, y;
    Color a = Color.GRAY;
    Color b = Color.DARK_GRAY;
    Color c = Color.DARK_GRAY;
    Color d = Color.DARK_GRAY;
    Color e = Color.DARK_GRAY;
    Color f = Color.DARK_GRAY;
    Color g = Color.DARK_GRAY;
    Color h = Color.DARK_GRAY;
    Color i = Color.DARK_GRAY;

    MenuItem aboutItem, ayuda;
    MenuItem exitItem, exitItem2;
    MenuItem errorItem;
    MenuItem warningItem;
    MenuItem infoItem;
    MenuItem noneItem;
    PopupMenu displayMenu;

    ImageIcon image = new ImageIcon();

    PopupMenu popup = new PopupMenu();
    TrayIcon trayIcon = new TrayIcon(createImage("/Imagenes/icono.png", "tray icon"));
    SystemTray tray = SystemTray.getSystemTray();

    public Menu() {
        super.setTitle("Menu");
        super.setSize(882, 600);
        super.setLayout(null);
        super.setUndecorated(true);
        super.getContentPane().setBackground(Color.BLACK);
        super.setResizable(true);
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        this.setVisible(true);

        jlb_x1 = new JLabel("-");
        jlb_x1.setBounds(809, 20, 25, 25);
        jlb_x1.setForeground(Color.DARK_GRAY);
        jlb_x1.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        jlb_x1.addMouseListener(this);
        jlb_x1.setToolTipText("Minimizar");
        jlb_x1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x1);

        jlb_x2 = new JLabel("x");
        jlb_x2.setBounds(839, 10, 20, 30);
        jlb_x2.setForeground(Color.DARK_GRAY);
        jlb_x2.setFont(new Font("Segoe UI", Font.PLAIN, 35));
        jlb_x2.addMouseListener(this);
        jlb_x2.setToolTipText("Cerrar");
        jlb_x2.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x2);

        jlbAirlineTravel = new JLabel("Airline Travel");
        jlbAirlineTravel.setBounds(290, 18, 150, 20);
        jlbAirlineTravel.setForeground(Color.BLACK);
        jlbAirlineTravel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbAirlineTravel);

        jbtnInicio = new JButton("  Inicio");
        jbtnInicio.setBounds(0, 0, 180, 60);
        jbtnInicio.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Home-32.png")));
        jbtnInicio.setBorder(null);
        jbtnInicio.setBackground(a);
        jbtnInicio.setForeground(Color.WHITE);
        jbtnInicio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnInicio.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnInicio.addMouseListener(this);
        jbtnInicio.setFocusPainted(false);
        this.add(jbtnInicio);

        jbtnUsuarios = new JButton("  Usuarios");
        jbtnUsuarios.setBounds(0, 60, 180, 60);
        jbtnUsuarios.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/User-26.png")));
        jbtnUsuarios.setBorder(null);
        jbtnUsuarios.setBackground(b);
        jbtnUsuarios.setForeground(Color.WHITE);
        jbtnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnUsuarios.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnUsuarios.addMouseListener(this);
        jbtnUsuarios.setFocusPainted(false);
        this.add(jbtnUsuarios);

        jbtnAviones = new JButton("  Aviones");
        jbtnAviones.setBounds(0, 120, 180, 60);
        jbtnAviones.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Airport-26.png")));
        jbtnAviones.setBorder(null);
        jbtnAviones.setBackground(c);
        jbtnAviones.setForeground(Color.WHITE);
        jbtnAviones.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnAviones.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAviones.addMouseListener(this);
        jbtnAviones.setFocusPainted(false);
        this.add(jbtnAviones);

        jbtnViajes = new JButton("  Viajes");
        jbtnViajes.setBounds(0, 180, 180, 60);
        jbtnViajes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Trip-26.png")));
        jbtnViajes.setBorder(null);
        jbtnViajes.setBackground(d);
        jbtnViajes.setForeground(Color.WHITE);
        jbtnViajes.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnViajes.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnViajes.addMouseListener(this);
        jbtnViajes.setFocusPainted(false);
        this.add(jbtnViajes);

        jbtnPerfil = new JButton("  Perfil");
        jbtnPerfil.setBounds(0, 180, 180, 60);
        jbtnPerfil.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Profile-26.png")));
        jbtnPerfil.setBorder(null);
        jbtnPerfil.setBackground(d);
        jbtnPerfil.setForeground(Color.WHITE);
        jbtnPerfil.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnPerfil.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnPerfil.addMouseListener(this);
        jbtnPerfil.setVisible(false);
        jbtnPerfil.setFocusPainted(false);
        this.add(jbtnPerfil);

        jbtnVuelos = new JButton("  Vuelos");
        jbtnVuelos.setBounds(0, 240, 180, 60);
        jbtnVuelos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Flight-26.png")));
        jbtnVuelos.setBorder(null);
        jbtnVuelos.setBackground(e);
        jbtnVuelos.setForeground(Color.WHITE);
        jbtnVuelos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnVuelos.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnVuelos.addMouseListener(this);
        jbtnVuelos.setFocusPainted(false);
        this.add(jbtnVuelos);

        jbtnAyuda = new JButton("  Ayuda");
        jbtnAyuda.setBounds(0, 240, 180, 60);
        jbtnAyuda.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Help-26.png")));
        jbtnAyuda.setBorder(null);
        jbtnAyuda.setBackground(e);
        jbtnAyuda.setForeground(Color.WHITE);
        jbtnAyuda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnAyuda.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAyuda.addMouseListener(this);
        jbtnAyuda.setVisible(false);
        jbtnAyuda.setFocusPainted(false);
        this.add(jbtnAyuda);

        jbtnReservas = new JButton("  Reservas");
        jbtnReservas.setBounds(0, 300, 180, 60);
        jbtnReservas.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Reservation-26.png")));
        jbtnReservas.setBorder(null);
        jbtnReservas.setBackground(f);
        jbtnReservas.setForeground(Color.WHITE);
        jbtnReservas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnReservas.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnReservas.addMouseListener(this);
        jbtnReservas.setFocusPainted(false);
        this.add(jbtnReservas);

        jbtnContactanos = new JButton("  Contáctanos");
        jbtnContactanos.setBounds(0, 300, 180, 60);
        jbtnContactanos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Message-26.png")));
        jbtnContactanos.setBorder(null);
        jbtnContactanos.setBackground(i);
        jbtnContactanos.setForeground(Color.WHITE);
        jbtnContactanos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnContactanos.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnContactanos.addMouseListener(this);
        jbtnContactanos.setVisible(false);
        jbtnContactanos.setFocusPainted(false);
        this.add(jbtnContactanos);

        jbtnCerrarSesion = new JButton(" Cerrar Sesión");
        jbtnCerrarSesion.setBounds(0, 538, 180, 60);
        jbtnCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Shutdown-26.png")));
        jbtnCerrarSesion.setBorder(null);
        jbtnCerrarSesion.setBackground(Color.DARK_GRAY);
        jbtnCerrarSesion.setForeground(Color.WHITE);
        jbtnCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnCerrarSesion.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCerrarSesion.addMouseListener(this);
        jbtnCerrarSesion.addActionListener(this);
        jbtnCerrarSesion.setFocusPainted(false);
        this.add(jbtnCerrarSesion);

        JPanel jpBotones = new JPanel();
        jpBotones.setBackground(Color.DARK_GRAY);
        jpBotones.add(jbtnInicio);
        jpBotones.add(jbtnUsuarios);
        jpBotones.add(jbtnAviones);
        jpBotones.add(jbtnViajes);
        jpBotones.add(jbtnVuelos);
        jpBotones.add(jbtnReservas);
        jpBotones.add(jbtnCerrarSesion);
        jpBotones.add(jbtnPerfil);
        jpBotones.add(jbtnAyuda);
        jpBotones.add(jbtnContactanos);
        jpBotones.setLayout(null);
        jpBotones.setBounds(1, 1, 180, 598);
        this.add(jpBotones);

        jpMovedor = new JPanel();
        jpMovedor.setOpaque(false);
        jpMovedor.setLayout(null);
        jpMovedor.add(jlb_x1);
        jpMovedor.add(jlb_x2);
        jpMovedor.add(jlbAirlineTravel);
        jpMovedor.setBounds(1, 1, 880, 60);
        jpMovedor.addMouseListener(this);
        jpMovedor.addMouseMotionListener(this);
        this.add(jpMovedor);

        jlbNombre = new JLabel("");
        jlbNombre.setBounds(222, 50, 300, 30);
        jlbNombre.setForeground(Color.BLACK);
        jlbNombre.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbNombre);

        jlbCorreo = new JLabel("");
        jlbCorreo.setBounds(222, 80, 300, 30);
        jlbCorreo.setForeground(Color.BLACK);
        jlbCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.add(jlbCorreo);

        jlbimage = new JLabel("");
        jlbimage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jlbimage.setBounds(55, 16, 150, 150);
        this.add(jlbimage);

        JLabel slider = new JLabel();
        slider.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        slider.setIcon(new ImageIcon(getClass().getResource("/Imagenes/slider.gif")));
        slider.setBounds(55, 210, 600, 300);
        this.add(slider);

        JLabel fondoI = new JLabel();
        fondoI.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/Inicio.png")));
        fondoI.setBounds(0, 0, 700, 538);
        this.add(fondoI);

        jpInicio = new JPanel();
        jpInicio.setOpaque(false);
        jpInicio.setLayout(null);
        jpInicio.add(jlbNombre);
        jpInicio.add(jlbCorreo);
        jpInicio.add(jlbimage);
        jpInicio.add(slider);
        jpInicio.add(fondoI);
        jpInicio.setBounds(181, 61, 700, 538);
        this.add(jpInicio);

        Container guardapaneles = getContentPane();
        guardapaneles.add(jpUsuarios);
        guardapaneles.add(jpAviones);
        guardapaneles.add(jpPerfil);
        guardapaneles.add(jpViajes);
        guardapaneles.add(jpVuelos);
        guardapaneles.add(jpReservas);
        guardapaneles.add(jpAyuda);
        guardapaneles.add(jpContactanos);

        cancelar = new JLabel("Cancelar");
        cancelar.setBounds(250, 476, 57, 20);
        cancelar.setForeground(Color.DARK_GRAY);
        cancelar.addMouseListener(this);
        cancelar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jpPerfil.add(cancelar);

        jbtnGuardar = new JButton("Guardar Cambios");
        jbtnGuardar.setBounds(90, 467, 150, 40);
        jbtnGuardar.addActionListener(this);
        jbtnGuardar.addMouseListener(this);
        jbtnGuardar.setBorder(null);
        jbtnGuardar.setBackground(new Color(0, 154, 225));
        jbtnGuardar.setForeground(Color.WHITE);
        jbtnGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jbtnGuardar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGuardar.setFocusPainted(false);
        jpPerfil.add(jbtnGuardar);

        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/Menu.png")));
        fondo.setBounds(0, 0, 882, 600);
        this.add(fondo);

        this.repaint();

        createSystemTray();
    }

    public static void main(String[] args) {
        Menu m = new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnCerrarSesion) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int i = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (JOptionPane.YES_OPTION == i) {
                this.setVisible(false);
                Login l = new Login();
                this.dispose();
                tray.remove(trayIcon);
            }
        }
        if (e.getSource() == aboutItem) {
            this.setVisible(true);
        }
        if (e.getSource() == trayIcon) {
            this.setVisible(true);
        }

        if (e.getSource() == ayuda) {
            goToURL("http://localhost:8083/FlightSystem/ayuda.html");
        }

        if (e.getSource() == exitItem2) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int i = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (JOptionPane.YES_OPTION == i) {
                this.setVisible(false);
                Login l = new Login();
                this.dispose();
                tray.remove(trayIcon);
            }
        }

        if (e.getSource() == exitItem) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int i = JOptionPane.showConfirmDialog(null, "¿Está seguro cerrar la aplicación?", "Cerrar Aplicación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (JOptionPane.YES_OPTION == i) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        }

        if (e.getSource() == jbtnGuardar) {
            UsuarioEnt usuarioE = new UsuarioEnt();
            UsuarioNg usuarioN = new UsuarioNg();
            if (jpPerfil.jtxtCorreo.getText().trim().length() == 0 || jpPerfil.jtxtClave.getText().trim().length() == 0 || jpPerfil.jtxtNombre.getText().trim().length() == 0 || jpPerfil.jtxtApellido.getText().trim().length() == 0 || jpPerfil.jtxtTelefono.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                jpPerfil.jpError.setBackground(new Color(237, 28, 36));
                jpPerfil.jlbValidar.setText("Ingrese los campos en rojo");

                if (jpPerfil.jtxtCorreo.getText().trim().length() == 0) {
                    jpPerfil.jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jpPerfil.jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jpPerfil.jtxtClave.getText().trim().length() == 0) {
                    jpPerfil.jtxtClave.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jpPerfil.jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jpPerfil.jtxtNombre.getText().trim().length() == 0) {
                    jpPerfil.jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jpPerfil.jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jpPerfil.jtxtApellido.getText().trim().length() == 0) {
                    jpPerfil.jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jpPerfil.jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jpPerfil.jtxtTelefono.getText().trim().length() == 0) {
                    jpPerfil.jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jpPerfil.jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }
                return;
            }
            if (jpPerfil.jtxtCorreo.getText().trim().length() <= 10 || jpPerfil.jtxtClave.getText().trim().length() <= 6 || jpPerfil.jtxtNombre.getText().trim().length() <= 3 || jpPerfil.jtxtApellido.getText().trim().length() <= 3 || jpPerfil.jtxtTelefono.getText().trim().length() <= 6 || (jpPerfil.jtxtCelular.getText().length() <= 9 && jpPerfil.jtxtCelular.getText().length() != 0)) {
                Toolkit.getDefaultToolkit().beep();
                jpPerfil.jpError.setBackground(new Color(237, 28, 36));
                jpPerfil.jlbValidar.setText("Ingrese un tamaño mayor en los campos rojos");

                if (jpPerfil.jtxtNombre.getText().length() <= 3) {
                    jpPerfil.jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jpPerfil.jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jpPerfil.jtxtApellido.getText().length() <= 3) {
                    jpPerfil.jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jpPerfil.jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jpPerfil.jtxtCorreo.getText().length() <= 10) {
                    jpPerfil.jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jpPerfil.jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jpPerfil.jtxtClave.getText().length() <= 6) {
                    jpPerfil.jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jpPerfil.jtxtClave.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jpPerfil.jtxtTelefono.getText().length() <= 6) {
                    jpPerfil.jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jpPerfil.jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jpPerfil.jtxtCelular.getText().length() <= 9 && jpPerfil.jtxtCelular.getText().length() != 0) {
                    jpPerfil.jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jpPerfil.jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }
                return;
            }
            int cont = 0, cont2 = 0;
            String usuario;
            usuario = jpPerfil.jtxtCorreo.getText();
            for (int i = 0; i < usuario.length(); i++) {
                if ("@".equals(usuario.substring(i, i + 1))) {
                    cont++;
                }
                if (cont == 1) {
                    if (".".equals(usuario.substring(i, i + 1))) {
                        cont2++;
                    }
                }
            }

            if (cont != 1 || cont2 == 0) {
                LimpiarCampos();
                Toolkit.getDefaultToolkit().beep();
                jpPerfil.jpError.setBackground(new Color(237, 28, 36));
                jpPerfil.jlbValidar.setText("Ingrese una dirección de correo válida");
                jpPerfil.jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea actualizar su perfil?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (option == JOptionPane.YES_OPTION) {

                    if (jpPerfil.jtxtCorreo.getText().trim().length() > 0) {
                        usuarioE.setCorreo(jpPerfil.jtxtCorreo.getText());
                    }

                    if (jpPerfil.jtxtClave.getText().trim().length() > 0) {
                        usuarioE.setClave(jpPerfil.jtxtClave.getText());
                    }

                    if (jpPerfil.jtxtNombre.getText().trim().length() > 0) {
                        usuarioE.setNombre(jpPerfil.jtxtNombre.getText());
                    }

                    if (jpPerfil.jtxtApellido.getText().trim().length() > 0) {
                        usuarioE.setApellido(jpPerfil.jtxtApellido.getText());
                    }

                    if (jpPerfil.jtxtTelefono.getText().trim().length() > 0) {
                        usuarioE.setTelefono(jpPerfil.jtxtTelefono.getText());
                    }

                    if (jpPerfil.jtxtCelular.getText().trim().length() > 0) {
                        usuarioE.setCelular(jpPerfil.jtxtCelular.getText());
                    }

                    usuarioE.setDocumento(jpPerfil.Doc);
                    usuarioE.setImage(jpPerfil.bmp);

                    boolean respuesta = usuarioN.modificarPerfil(usuarioE);
                    if (respuesta) {
                        LimpiarCampos();
                        jpPerfil.nombre.setText("Ninguna imagen seleccionada");
                        jpPerfil.jpError.setBackground(new Color(0, 154, 225));
                        jpPerfil.jlbValidar.setText("Se guardaron los cambios correctamente");
                        jlbimage.setIcon(jpPerfil.jlbimage.getIcon());
                        Nombre = jpPerfil.jtxtNombre.getText();
                        Apellido = jpPerfil.jtxtApellido.getText();
                        Correo = jpPerfil.jtxtCorreo.getText();
                        Clave = jpPerfil.jtxtClave.getText();
                        Telefono = jpPerfil.jtxtTelefono.getText();
                        Celular = jpPerfil.jtxtCelular.getText();
                        jlbNombre.setText(Nombre + " " + Apellido);
                        jlbCorreo.setText(Correo);
                        trayIcon.displayMessage("Flight System", "Se a actualizado su perfil", TrayIcon.MessageType.INFO);
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == jpMovedor) {
            x = arg0.getX();
            y = arg0.getY();
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == jbtnInicio) {
            jbtnInicio.setBackground(a);
        }

        if (arg0.getSource() == jbtnUsuarios) {
            jbtnUsuarios.setBackground(b);
        }

        if (arg0.getSource() == jbtnAviones) {
            jbtnAviones.setBackground(c);
        }

        if (arg0.getSource() == jbtnViajes) {
            jbtnViajes.setBackground(d);
        }

        if (arg0.getSource() == jbtnVuelos) {
            jbtnVuelos.setBackground(e);
        }

        if (arg0.getSource() == jbtnReservas) {
            jbtnReservas.setBackground(f);
        }

        if (arg0.getSource() == jbtnPerfil) {
            jbtnPerfil.setBackground(g);
        }

        if (arg0.getSource() == jbtnAyuda) {
            jbtnAyuda.setBackground(h);
        }

        if (arg0.getSource() == jbtnContactanos) {
            jbtnContactanos.setBackground(i);
        }

        if (arg0.getSource() == jbtnCerrarSesion) {
            jbtnCerrarSesion.setBackground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jbtnGuardar) {
            jbtnGuardar.setBackground(new Color(0, 154, 225));
        }
        
        if (arg0.getSource() == cancelar) {
            cancelar.setForeground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(Color.DARK_GRAY);
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == jbtnInicio) {
            jbtnInicio.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnUsuarios) {
            jbtnUsuarios.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnAviones) {
            jbtnAviones.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnViajes) {
            jbtnViajes.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnVuelos) {
            jbtnVuelos.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnReservas) {
            jbtnReservas.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnPerfil) {
            jbtnPerfil.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnAyuda) {
            jbtnAyuda.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnContactanos) {
            jbtnContactanos.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnCerrarSesion) {
            jbtnCerrarSesion.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnGuardar) {
            jbtnGuardar.setBackground(new Color(0, 123, 183));
        }

        if (arg0.getSource() == cancelar) {
            cancelar.setForeground(new Color(237, 28, 36));
        }
        
        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(new Color(0, 154, 225));
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(new Color(0, 154, 225));
        }
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        if (ev.getSource() == jbtnInicio) {
            a = Color.GRAY;
            b = c = d = e = f = g = h = i = Color.DARK_GRAY;
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jbtnContactanos.setBackground(i);
            jpInicio.setVisible(true);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
            jpViajes.setVisible(false);
            jpVuelos.setVisible(false);
            jpReservas.setVisible(false);
            jpAyuda.setVisible(false);
            jpContactanos.setVisible(false);
        }

        if (ev.getSource() == jbtnUsuarios) {
            b = Color.GRAY;
            a = c = d = e = f = g = h = i = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnAviones.setBackground(c);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jbtnContactanos.setBackground(i);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(true);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
            jpViajes.setVisible(false);
            jpVuelos.setVisible(false);
            jpReservas.setVisible(false);
            jpAyuda.setVisible(false);
            jpContactanos.setVisible(false);

            jpUsuarios.LimpiarCampos();
            jpUsuarios.pnDatos.setVisible(false);
            jpUsuarios.jpBotones.setVisible(true);
            jpUsuarios.jpError.setVisible(true);

        }

        if (ev.getSource() == jbtnAviones) {
            c = Color.GRAY;
            a = b = d = e = f = g = h = i = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jbtnContactanos.setBackground(i);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(true);
            jpViajes.setVisible(false);
            jpVuelos.setVisible(false);
            jpReservas.setVisible(false);
            jpAyuda.setVisible(false);
            jpContactanos.setVisible(false);

            jpAviones.LimpiarCampos();
            jpAviones.pnDatos.setVisible(false);
            jpAviones.jpBotones.setVisible(true);
            jpAviones.jpError.setVisible(true);
        }

        if (ev.getSource() == jbtnViajes) {
            d = Color.GRAY;
            a = b = c = e = f = g = h = i = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnVuelos.setBackground(e);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jbtnContactanos.setBackground(i);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
            jpViajes.setVisible(true);
            jpVuelos.setVisible(false);
            jpReservas.setVisible(false);
            jpAyuda.setVisible(false);
            jpContactanos.setVisible(false);

            jpViajes.LimpiarCampos();
            jpViajes.pnDatos.setVisible(false);
            jpViajes.jpBotones.setVisible(true);
            jpViajes.jpError.setVisible(true);
        }

        if (ev.getSource() == jbtnVuelos) {
            e = Color.GRAY;
            a = b = c = d = f = g = h = i = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnViajes.setBackground(d);
            jbtnAviones.setBackground(c);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jbtnContactanos.setBackground(i);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
            jpViajes.setVisible(false);
            jpVuelos.setVisible(true);
            jpReservas.setVisible(false);
            jpAyuda.setVisible(false);
            jpContactanos.setVisible(false);

            jpVuelos.LimpiarCampos();
            jpVuelos.pnDatos.setVisible(false);
            jpVuelos.jpBotones.setVisible(true);
            jpVuelos.jpError.setVisible(true);

        }

        if (ev.getSource() == jbtnReservas) {
            f = Color.GRAY;
            a = b = c = d = e = g = h = i = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jbtnContactanos.setBackground(i);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
            jpViajes.setVisible(false);
            jpVuelos.setVisible(false);
            jpReservas.setVisible(true);
            jpAyuda.setVisible(false);
            jpContactanos.setVisible(false);

            jpReservas.LimpiarCampos();
            jpReservas.pnDatos.setVisible(false);
            jpReservas.jpBotones.setVisible(true);
            jpReservas.jpError.setVisible(true);
            if (jpReservas.jbtnBuscar.getBounds().x == 0) {
                jpReservas.doc_ident = jpPerfil.Doc;
                jpReservas.jtxtDocumento.setText(jpReservas.doc_ident);
                jpReservas.jtxtDocumento.setFocusable(false);
            }
        }

        if (ev.getSource() == jbtnPerfil) {
            g = Color.GRAY;
            a = b = c = d = e = f = h = i = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnReservas.setBackground(f);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnAyuda.setBackground(h);
            jbtnContactanos.setBackground(i);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(true);
            jpAviones.setVisible(false);
            jpViajes.setVisible(false);
            jpVuelos.setVisible(false);
            jpReservas.setVisible(false);
            jpAyuda.setVisible(false);
            jpContactanos.setVisible(false);

        }

        if (ev.getSource() == cancelar) {
            jpPerfil.nombre.setText("Ninguna imagen seleccionada");
            jpPerfil.jlbimage.setIcon(jlbimage.getIcon());
            jpPerfil.jtxtNombre.setText(Nombre);
            jpPerfil.jtxtApellido.setText(Apellido);
            jpPerfil.jtxtCorreo.setText(Correo);
            jpPerfil.jtxtClave.setText(Clave);
            jpPerfil.jtxtTelefono.setText(Telefono);
            jpPerfil.jtxtCelular.setText(Celular);
            LimpiarCampos();
        }

        if (ev.getSource() == jbtnAyuda) {
            h = Color.GRAY;
            a = b = c = d = e = f = g = i = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnReservas.setBackground(f);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnPerfil.setBackground(g);
            jbtnContactanos.setBackground(i);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
            jpViajes.setVisible(false);
            jpVuelos.setVisible(false);
            jpReservas.setVisible(false);
            jpAyuda.setVisible(true);
            jpContactanos.setVisible(false);

            jpAyuda.jlbAyudaReserva.setVisible(false);
            jpAyuda.jlbAyudaTiempoReserva.setVisible(false);
            jpAyuda.jlbAyudaContactarnos.setVisible(false);
            jpAyuda.jlbAyudaPerfil.setVisible(false);
            jpAyuda.jlbAyuda.setVisible(true);
        }

        if (ev.getSource() == jbtnContactanos) {
            i = Color.GRAY;
            a = b = c = d = e = f = g = h = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnReservas.setBackground(f);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jbtnContactanos.setBackground(i);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
            jpViajes.setVisible(false);
            jpVuelos.setVisible(false);
            jpReservas.setVisible(false);
            jpAyuda.setVisible(false);
            jpContactanos.setVisible(true);

            jpContactanos.LimpiarCampos();
            jpContactanos.jtxtCorreo.setText(Correo);
        }

        if (ev.getSource() == jlb_x1) {
            super.setState(JFrame.ICONIFIED);
        }

        if (ev.getSource() == jlb_x2) {
            trayIcon.displayMessage("Flight System", "Pasando a segundo plano...", TrayIcon.MessageType.INFO);
            super.setVisible(false);
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource() == jpMovedor) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(point.x - x, point.y - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    public void createSystemTray() {
        //si si soporta SystemTray
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
        } else {

            // Crear los componentes del popup menu
            aboutItem = new MenuItem("Abrir interfaz de usuario de Flight System!");
            aboutItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
            aboutItem.addActionListener(this);

            exitItem2 = new MenuItem("Finalizar sesión en Flight System");
            exitItem2.addActionListener(this);

            ayuda = new MenuItem("Ayuda");
            ayuda.addActionListener(this);

            exitItem = new MenuItem("Cerrar");
            exitItem.addActionListener(this);

            //añadimos los componentes popup menu
            popup.add(aboutItem);
            popup.add(exitItem2);
            popup.addSeparator();
            popup.add(ayuda);
            popup.addSeparator();
            popup.add(exitItem);

            //propiedades del icono
            trayIcon.setPopupMenu(popup);
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Flight System");
            trayIcon.addActionListener(this);

            //verificar que si funcione
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.out.println("No se pudo agregar TrayIcon.");
                return;

            }
        }
    }

    //obtener la url de la image
    protected static Image createImage(String path, String description) {
        URL imageURL = Menu.class
                .getResource(path);

        if (imageURL
                == null) {
            System.err.println("Imagen no encontrada: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

    public void goToURL(String URL) {
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(URL);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void LimpiarCampos() {
        jpPerfil.jpError.setBackground(new Color(0, 123, 183));
        jpPerfil.jlbValidar.setText("Aquí puedes administrar la información básica sobre tu cuenta");
        jpPerfil.jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jpPerfil.jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jpPerfil.jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jpPerfil.jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jpPerfil.jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jpPerfil.jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

}
