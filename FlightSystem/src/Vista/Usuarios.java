package Vista;

import Entidades.UsuarioEnt;
import Negocio.UsuarioNg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends JPanel implements ActionListener, MouseListener, KeyListener {

    JLabel jlbDoc_ident;
    JLabel jlbCorreo;
    JLabel jlbClave;
    JLabel jlbNombre;
    JLabel jlbApellido;
    JLabel jlbTelefono;
    JLabel jlbCelular;
    JLabel jlbPerfil;
    JLabel jlbEstado;
    JLabel jlbValidar;

    JTextField jtxtDoc_ident;
    JTextField jtxtCorreo;
    JTextField jtxtClave;
    JTextField jtxtNombre;
    JTextField jtxtApellido;
    JTextField jtxtTelefono;
    JTextField jtxtCelular;

    JComboBox jcbPerfil;
    JComboBox jcbEstado;

    JPanel jpBotones;
    JPanel jpError;

    JButton jbtnListar;
    JButton jbtnGuardar;
    JButton jbtnBuscar;
    JButton jbtnActualizar;
    JButton jbtnEliminar;
    JButton jbtnLimpiar;

    private Object[][] Detalle_Usuario = new Object[0][0];//Creamos La matriz
    private Object[] Columnas_Usuario = {"Documento", "Correo", "Nombre", "Apellido", "Teléfono", "Celular", "Perfil", "Estado"};//Los nombres de las filas
    private DefaultTableModel dataModel = new DefaultTableModel(Detalle_Usuario, Columnas_Usuario);
    JScrollPane pnDatos;//Barra desplazamiento abajo
    JTable tbDatos;//datos de la tabla DATAMODEL nesecito cargarlo en un objeto pra poderlo visualisa

    public Usuarios() {
        super.setBounds(181, 61, 700, 538);  //(ancho,alto)
        super.setLayout(null);
        super.setOpaque(false);
        super.setVisible(false);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        tbDatos = new JTable(dataModel);
        tbDatos.setEnabled(false);
        tbDatos.setAutoResizeMode(5);
        tbDatos.setCellSelectionEnabled(true);
        tbDatos.setForeground(Color.BLACK);
        pnDatos = new JScrollPane(tbDatos);
        pnDatos.setBounds(30, 30, 640, 478);
        pnDatos.setVisible(false);
        this.add(pnDatos);
        llenarDatos();

        jlbDoc_ident = new JLabel("*Documento de identidad");
        jlbDoc_ident.setBounds(90, 65, 220, 25);
        jlbDoc_ident.setForeground(Color.BLACK);
        jlbDoc_ident.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbDoc_ident);

        jtxtDoc_ident = new JTextField("");
        jtxtDoc_ident.setBounds(90, 90, 520, 30);
        jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtDoc_ident.addKeyListener(this);
        this.add(jtxtDoc_ident);

        jlbCorreo = new JLabel("*Correo");
        jlbCorreo.setBounds(90, 145, 120, 25);
        jlbCorreo.setForeground(Color.BLACK);
        jlbCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCorreo);

        jtxtCorreo = new JTextField("");
        jtxtCorreo.setBounds(90, 170, 250, 30);
        jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCorreo.addKeyListener(this);
        this.add(jtxtCorreo);

        jlbClave = new JLabel("*Contraseña");
        jlbClave.setBounds(360, 145, 150, 25);
        jlbClave.setForeground(Color.BLACK);
        jlbClave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbClave);

        jtxtClave = new JPasswordField();
        jtxtClave.setBounds(360, 170, 250, 30);
        jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtClave.addKeyListener(this);
        this.add(jtxtClave);

        jlbNombre = new JLabel("*Nombre");
        jlbNombre.setBounds(90, 225, 120, 25);
        jlbNombre.setForeground(Color.BLACK);
        jlbNombre.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbNombre);

        jtxtNombre = new JTextField("");
        jtxtNombre.setBounds(90, 250, 250, 30);
        jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtNombre.addKeyListener(this);
        this.add(jtxtNombre);

        jlbApellido = new JLabel("*Apellido");
        jlbApellido.setBounds(360, 225, 150, 25);
        jlbApellido.setForeground(Color.BLACK);
        jlbApellido.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbApellido);

        jtxtApellido = new JTextField();
        jtxtApellido.setBounds(360, 250, 250, 30);
        jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtApellido.addKeyListener(this);
        this.add(jtxtApellido);

        jlbTelefono = new JLabel("*Teléfono");
        jlbTelefono.setBounds(90, 305, 120, 25);
        jlbTelefono.setForeground(Color.BLACK);
        jlbTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbTelefono);

        jtxtTelefono = new JTextField("");
        jtxtTelefono.setBounds(90, 330, 250, 30);
        jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtTelefono.addKeyListener(this);
        this.add(jtxtTelefono);

        jlbCelular = new JLabel("Celular");
        jlbCelular.setBounds(360, 305, 150, 25);
        jlbCelular.setForeground(Color.BLACK);
        jlbCelular.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCelular);

        jtxtCelular = new JTextField();
        jtxtCelular.setBounds(360, 330, 250, 30);
        jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCelular.addKeyListener(this);
        this.add(jtxtCelular);

        jlbPerfil = new JLabel("*Perfil");
        jlbPerfil.setBounds(90, 385, 150, 25);
        jlbPerfil.setForeground(Color.BLACK);
        jlbPerfil.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbPerfil);

        jcbPerfil = new JComboBox();
        jcbPerfil.setBorder(null);
        jcbPerfil.setBackground(Color.WHITE);
        jcbPerfil.addItem("Cliente");
        jcbPerfil.addItem("Administrador");
        jcbPerfil.addItem("Secretaria");
        jcbPerfil.setBounds(90, 410, 250, 30);
        this.add(jcbPerfil);

        jlbEstado = new JLabel("*Estado");
        jlbEstado.setBounds(360, 385, 150, 25);
        jlbEstado.setForeground(Color.BLACK);
        jlbEstado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbEstado);

        jcbEstado = new JComboBox();
        jcbEstado.setBorder(null);
        jcbEstado.setBackground(Color.WHITE);
        jcbEstado.addItem("Activo");
        jcbEstado.addItem("Inactivo");
        jcbEstado.setBounds(360, 410, 250, 30);
        this.add(jcbEstado);

        jbtnListar = new JButton(" Lista");
        jbtnListar.setBounds(0, 0, 175, 60);
        jbtnListar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/List-26.png")));
        jbtnListar.setBorder(null);
        jbtnListar.setBackground(new Color(0, 154, 225));
        jbtnListar.setForeground(Color.WHITE);
        jbtnListar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnListar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnListar.addMouseListener(this);
        jbtnListar.addActionListener(this);
        jbtnListar.setFocusPainted(false);
        this.add(jbtnListar);

        jbtnGuardar = new JButton(" Guardar");
        jbtnGuardar.setBounds(175, 0, 175, 60);
        jbtnGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Save-26.png")));
        jbtnGuardar.setBorder(null);
        jbtnGuardar.setBackground(new Color(0, 154, 225));
        jbtnGuardar.setForeground(Color.WHITE);
        jbtnGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnGuardar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGuardar.addMouseListener(this);
        jbtnGuardar.addActionListener(this);
        jbtnGuardar.setFocusPainted(false);
        this.add(jbtnGuardar);

        jbtnBuscar = new JButton(" Buscar");
        jbtnBuscar.setBounds(350, 0, 175, 60);
        jbtnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Search-26.png")));
        jbtnBuscar.setBorder(null);
        jbtnBuscar.setBackground(new Color(0, 154, 225));
        jbtnBuscar.setForeground(Color.WHITE);
        jbtnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnBuscar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnBuscar.addMouseListener(this);
        jbtnBuscar.addActionListener(this);
        jbtnBuscar.setFocusPainted(false);
        this.add(jbtnBuscar);

        jbtnActualizar = new JButton(" Actualizar");
        jbtnActualizar.setBounds(175, 0, 175, 60);
        jbtnActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Edit-26.png")));
        jbtnActualizar.setBorder(null);
        jbtnActualizar.setBackground(new Color(0, 154, 225));
        jbtnActualizar.setForeground(Color.WHITE);
        jbtnActualizar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnActualizar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnActualizar.addMouseListener(this);
        jbtnActualizar.setVisible(false);
        jbtnActualizar.addActionListener(this);
        jbtnActualizar.setFocusPainted(false);
        this.add(jbtnActualizar);

        jbtnEliminar = new JButton(" Eliminar");
        jbtnEliminar.setBounds(350, 0, 175, 60);
        jbtnEliminar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Delete-26.png")));
        jbtnEliminar.setBorder(null);
        jbtnEliminar.setBackground(new Color(0, 154, 225));
        jbtnEliminar.setForeground(Color.WHITE);
        jbtnEliminar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnEliminar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEliminar.addMouseListener(this);
        jbtnEliminar.setVisible(false);
        jbtnEliminar.addActionListener(this);
        jbtnEliminar.setFocusPainted(false);
        this.add(jbtnEliminar);

        jbtnLimpiar = new JButton(" Limpiar");
        jbtnLimpiar.setBounds(525, 0, 175, 60);
        jbtnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Clean-26.png")));
        jbtnLimpiar.setBorder(null);
        jbtnLimpiar.setBackground(new Color(0, 154, 225));
        jbtnLimpiar.setForeground(Color.WHITE);
        jbtnLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnLimpiar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnLimpiar.addMouseListener(this);
        jbtnLimpiar.addActionListener(this);
        jbtnLimpiar.setFocusPainted(false);
        this.add(jbtnLimpiar);

        jpBotones = new JPanel();
        jpBotones.setBackground(new Color(0, 123, 183));
        jpBotones.add(jbtnListar);
        jpBotones.add(jbtnGuardar);
        jpBotones.add(jbtnBuscar);
        jpBotones.add(jbtnActualizar);
        jpBotones.add(jbtnEliminar);
        jpBotones.add(jbtnLimpiar);
        jpBotones.setLayout(null);
        jpBotones.setBounds(0, 478, 700, 60);
        this.add(jpBotones);

        jlbValidar = new JLabel("Los campos con (*) son obligatorios");
        jlbValidar.setForeground(Color.WHITE);
        jlbValidar.setBounds(80, 8, 400, 27);
        jlbValidar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        this.add(jlbValidar);

        jpError = new JPanel();
        jpError.add(jlbValidar);
        jpError.setLayout(null);
        jpError.setBackground(new Color(0, 123, 183));
        jpError.setBounds(0, 0, 700, 45);
        this.add(jpError);

        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        UsuarioEnt usuarioE = new UsuarioEnt();
        UsuarioNg usuarioN = new UsuarioNg();
        if (ae.getSource() == jbtnListar) {
            LimpiarCampos();
            pnDatos.setVisible(true);
            jpBotones.setVisible(false);
            jpError.setVisible(false);
            vaciar();
            llenarDatos();
        }
        if (ae.getSource() == jbtnGuardar) {
            if (jtxtDoc_ident.getText().trim().length() == 0 || jtxtCorreo.getText().trim().length() == 0 || jtxtClave.getText().trim().length() == 0 || jtxtNombre.getText().trim().length() == 0 || jtxtApellido.getText().trim().length() == 0 || jtxtTelefono.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese los campos en rojo");

                if (jtxtDoc_ident.getText().trim().length() == 0) {
                    jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtCorreo.getText().trim().length() == 0) {
                    jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtClave.getText().trim().length() == 0) {
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtNombre.getText().trim().length() == 0) {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtApellido.getText().trim().length() == 0) {
                    jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtTelefono.getText().trim().length() == 0) {
                    jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                return;
            }
            if (jtxtDoc_ident.getText().trim().length() <= 7 || jtxtCorreo.getText().trim().length() <= 10 || jtxtClave.getText().trim().length() <= 6 || jtxtNombre.getText().trim().length() <= 3 || jtxtApellido.getText().trim().length() <= 3 || jtxtTelefono.getText().trim().length() <= 6 || (jtxtCelular.getText().length() <= 9 && jtxtCelular.getText().length() != 0)) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese un tamaño mayor en los campos rojos");

                if (jtxtDoc_ident.getText().length() <= 7) {
                    jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtNombre.getText().length() <= 3) {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtApellido.getText().length() <= 3) {
                    jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtCorreo.getText().length() <= 10) {
                    jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtClave.getText().length() <= 6) {
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtTelefono.getText().length() <= 6) {
                    jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtCelular.getText().length() <= 9 && jtxtCelular.getText().length() != 0) {
                    jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }
                return;
            }
            int cont = 0, cont2 = 0;
            String usuario;
            usuario = jtxtCorreo.getText();
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
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese una dirección de correo válida");
                jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea guardar el usuario?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (option == JOptionPane.YES_OPTION) {
                    if (jtxtDoc_ident.getText().trim().length() > 0) {
                        usuarioE.setDocumento(jtxtDoc_ident.getText());
                    }

                    if (jtxtCorreo.getText().trim().length() > 0) {
                        usuarioE.setCorreo(jtxtCorreo.getText());
                    }

                    if (jtxtClave.getText().trim().length() > 0) {
                        usuarioE.setClave(jtxtClave.getText());
                    }

                    if (jtxtNombre.getText().trim().length() > 0) {
                        usuarioE.setNombre(jtxtNombre.getText());
                    }

                    if (jtxtApellido.getText().trim().length() > 0) {
                        usuarioE.setApellido(jtxtApellido.getText());
                    }

                    if (jtxtTelefono.getText().trim().length() > 0) {
                        usuarioE.setTelefono(jtxtTelefono.getText());
                    }

                    if (jtxtCelular.getText().trim().length() > 0) {
                        usuarioE.setCelular(jtxtCelular.getText());
                    }

                    usuarioE.setPerfil((String) jcbPerfil.getSelectedItem());
                    usuarioE.setEstado((String) jcbEstado.getSelectedItem());

                    boolean guarda = usuarioN.guardarUsuario(usuarioE);
                    if (guarda) {
                        VaciarCampos();
                        LimpiarCampos();
                        jpError.setBackground(new Color(0, 154, 225));
                        jlbValidar.setText("Se ha guardado el usuario");
                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        jpError.setBackground(new Color(237, 28, 36));
                        jlbValidar.setText("El usuario ya estaba guardado");

                    }
                }
            }
        }

        if (ae.getSource() == jbtnBuscar) {
            LimpiarCampos();
            String Documento;
            Documento = jtxtDoc_ident.getText();
            if (Documento.trim().length() != 0) {
                usuarioE = usuarioN.buscarUsuarioDocumento(Documento);
                if (usuarioE != null) {
                    jtxtDoc_ident.setText(usuarioE.getDocumento());
                    jtxtNombre.setText(usuarioE.getNombre());
                    jtxtApellido.setText(usuarioE.getApellido());
                    jtxtCorreo.setText(usuarioE.getCorreo());
                    jtxtClave.setText(usuarioE.getClave());
                    jtxtTelefono.setText(usuarioE.getTelefono());
                    jtxtCelular.setText(usuarioE.getCelular());
                    jcbPerfil.setSelectedItem(usuarioE.getPerfil());
                    jcbEstado.setSelectedItem(usuarioE.getEstado());
                    jtxtDoc_ident.setFocusable(false);
                    jbtnGuardar.setVisible(false);
                    jbtnBuscar.setVisible(false);
                    jbtnActualizar.setVisible(true);
                    jbtnEliminar.setVisible(true);
                    if (jbtnActualizar.getBounds().x == 0) {
                        jbtnListar.setBounds(0, 0, 350, 60);
                        jbtnLimpiar.setBounds(350, 0, 350, 60);
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    jpError.setBackground(new Color(237, 28, 36));
                    jlbValidar.setText("El usuario no se ha encontrado");
                }
            } else {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese el Documento de identidad");
                jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }
        }

        if (ae.getSource() == jbtnActualizar) {
            if (jtxtCorreo.getText().trim().length() == 0 || jtxtClave.getText().trim().length() == 0 || jtxtNombre.getText().trim().length() == 0 || jtxtApellido.getText().trim().length() == 0 || jtxtTelefono.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese los campos en rojo");

                if (jtxtDoc_ident.getText().trim().length() == 0) {
                    jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtCorreo.getText().trim().length() == 0) {
                    jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtClave.getText().trim().length() == 0) {
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtNombre.getText().trim().length() == 0) {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtApellido.getText().trim().length() == 0) {
                    jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtTelefono.getText().trim().length() == 0) {
                    jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }
                return;
            }
            if (jtxtCorreo.getText().trim().length() <= 10 || jtxtClave.getText().trim().length() <= 6 || jtxtNombre.getText().trim().length() <= 3 || jtxtApellido.getText().trim().length() <= 3 || jtxtTelefono.getText().trim().length() <= 6 || (jtxtCelular.getText().length() <= 9 && jtxtCelular.getText().length() != 0)) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese un tamaño mayor en los campos rojos");

                if (jtxtNombre.getText().length() <= 3) {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtApellido.getText().length() <= 3) {
                    jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtCorreo.getText().length() <= 10) {
                    jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtClave.getText().length() <= 6) {
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtTelefono.getText().length() <= 6) {
                    jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }

                if (jtxtCelular.getText().length() <= 9 && jtxtCelular.getText().length() != 0) {
                    jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }
                return;
            }
            int cont = 0, cont2 = 0;
            String usuario;
            usuario = jtxtCorreo.getText();
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
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese una dirección de correo válida");
                jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea actualizar el usuario?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (option == JOptionPane.YES_OPTION) {
                    if (jtxtDoc_ident.getText().trim().length() > 0) {
                        usuarioE.setDocumento(jtxtDoc_ident.getText());
                    }

                    if (jtxtCorreo.getText().trim().length() > 0) {
                        usuarioE.setCorreo(jtxtCorreo.getText());
                    }

                    if (jtxtClave.getText().trim().length() > 0) {
                        usuarioE.setClave(jtxtClave.getText());
                    }

                    if (jtxtNombre.getText().trim().length() > 0) {
                        usuarioE.setNombre(jtxtNombre.getText());
                    }

                    if (jtxtApellido.getText().trim().length() > 0) {
                        usuarioE.setApellido(jtxtApellido.getText());
                    }

                    if (jtxtTelefono.getText().trim().length() > 0) {
                        usuarioE.setTelefono(jtxtTelefono.getText());
                    }

                    if (jtxtCelular.getText().trim().length() > 0) {
                        usuarioE.setCelular(jtxtCelular.getText());
                    }

                    usuarioE.setPerfil((String) jcbPerfil.getSelectedItem());
                    usuarioE.setEstado((String) jcbEstado.getSelectedItem());

                    boolean respuestau = usuarioN.modificarUsuario(usuarioE);
                    if (respuestau) {
                        LimpiarCampos();
                        jpError.setBackground(new Color(0, 154, 225));
                        jlbValidar.setText("Se ha actualizado el usuario");
                    }
                }
            }
        }

        if (ae.getSource() == jbtnEliminar) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el usuario?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (option == JOptionPane.YES_OPTION) {
                String codigo = jtxtDoc_ident.getText();
                boolean respuestap;
                if (codigo != null) {
                    respuestap = usuarioN.eliminarUsuario(codigo);
                    if (respuestap) {
                        jtxtDoc_ident.setFocusable(true);
                        jbtnGuardar.setVisible(true);
                        jbtnBuscar.setVisible(true);
                        jbtnActualizar.setVisible(false);
                        jbtnEliminar.setVisible(false);
                        LimpiarCampos();
                        VaciarCampos();
                        jpError.setBackground(new Color(0, 154, 225));
                        jlbValidar.setText("El Usuario fue eliminado");
                        if (jbtnActualizar.getBounds().x == 0) {
                            jbtnListar.setBounds(0, 0, 175, 60);
                            jbtnLimpiar.setBounds(525, 0, 175, 60);
                        }
                    }
                }
            }
        }

        if (ae.getSource() == jbtnLimpiar) {
            LimpiarCampos();
            VaciarCampos();
            jtxtDoc_ident.setFocusable(true);
            jbtnGuardar.setVisible(true);
            jbtnBuscar.setVisible(true);
            jbtnActualizar.setVisible(false);
            jbtnEliminar.setVisible(false);
            if (jbtnActualizar.getBounds().x == 0) {
                jbtnListar.setBounds(0, 0, 175, 60);
                jbtnLimpiar.setBounds(525, 0, 175, 60);
            }
        }

    }

    public void setDataModel(DefaultTableModel dataModel) {
        this.dataModel = dataModel;
    }

    public DefaultTableModel getDataModel() {
        return dataModel;
    }

    public void llenarDatos() {
        Negocio.UsuarioNg UsuarioN = new Negocio.UsuarioNg();
        setDataModel(UsuarioN.cargarUsuario(getDataModel()));

    }

    public void vaciar() {
        int i = getDataModel().getRowCount();
        while (i > 0) {
            getDataModel().removeRow(0);
            i--;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == jbtnListar) {
            jbtnListar.setBackground(new Color(0, 123, 183));
        }
        if (me.getSource() == jbtnGuardar) {
            jbtnGuardar.setBackground(new Color(0, 123, 183));
        }
        if (me.getSource() == jbtnBuscar) {
            jbtnBuscar.setBackground(new Color(0, 123, 183));
        }
        if (me.getSource() == jbtnActualizar) {
            jbtnActualizar.setBackground(new Color(0, 123, 183));
        }
        if (me.getSource() == jbtnEliminar) {
            jbtnEliminar.setBackground(new Color(0, 123, 183));
        }
        if (me.getSource() == jbtnLimpiar) {
            jbtnLimpiar.setBackground(new Color(0, 123, 183));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == jbtnListar) {
            jbtnListar.setBackground(new Color(0, 154, 225));
        }
        if (me.getSource() == jbtnGuardar) {
            jbtnGuardar.setBackground(new Color(0, 154, 225));
        }
        if (me.getSource() == jbtnBuscar) {
            jbtnBuscar.setBackground(new Color(0, 154, 225));
        }
        if (me.getSource() == jbtnActualizar) {
            jbtnActualizar.setBackground(new Color(0, 154, 225));
        }
        if (me.getSource() == jbtnEliminar) {
            jbtnEliminar.setBackground(new Color(0, 154, 225));
        }
        if (me.getSource() == jbtnLimpiar) {
            jbtnLimpiar.setBackground(new Color(0, 154, 225));
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getSource() == jtxtDoc_ident) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtDoc_ident.getText().length() >= 20 || (c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtNombre) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtNombre.getText().length() >= 25) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtApellido) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtApellido.getText().length() >= 30) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtCorreo) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtCorreo.getText().length() >= 30) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtClave) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtClave.getText().length() >= 20) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtTelefono) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtTelefono.getText().length() >= 15 || (c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE) && (c != (char) KeyEvent.VK_MINUS)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtCelular) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtCelular.getText().length() >= 20 || (c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE) && (c != (char) KeyEvent.VK_MINUS)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtDoc_ident) {
            if (jtxtDoc_ident.getText().length() <= 7) {
                jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

        if (ke.getSource() == jtxtNombre) {
            if (jtxtNombre.getText().length() <= 3) {
                jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

        if (ke.getSource() == jtxtApellido) {
            if (jtxtApellido.getText().length() <= 3) {
                jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

        if (ke.getSource() == jtxtCorreo) {
            if (jtxtCorreo.getText().length() <= 10) {
                jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

        if (ke.getSource() == jtxtClave) {
            if (jtxtClave.getText().length() <= 6) {
                jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtClave.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

        if (ke.getSource() == jtxtTelefono) {
            if (jtxtTelefono.getText().length() <= 6) {
                jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

        if (ke.getSource() == jtxtCelular) {
            if (jtxtCelular.getText().length() <= 9) {
                jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getSource() == jtxtDoc_ident) {
            if (jtxtDoc_ident.getText().trim().length() < 0) {
                jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtCorreo) {
            if (jtxtCorreo.getText().trim().length() < 0) {
                jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtClave) {
            if (jtxtClave.getText().trim().length() < 0) {
                jtxtClave.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtNombre) {
            if (jtxtNombre.getText().trim().length() < 0) {
                jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtApellido) {
            if (jtxtApellido.getText().trim().length() < 0) {
                jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtTelefono) {
            if (jtxtTelefono.getText().trim().length() < 0) {
                jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtCelular) {
            if (jtxtCelular.getText().trim().length() < 0) {
                jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    public void LimpiarCampos() {
        jpError.setBackground(new Color(0, 123, 183));
        jlbValidar.setText("Los campos con (*) son obligatorios");
        jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    public void VaciarCampos() {
        jtxtDoc_ident.setText("");
        jtxtNombre.setText("");
        jtxtApellido.setText("");
        jtxtCorreo.setText("");
        jtxtClave.setText("");
        jtxtTelefono.setText("");
        jtxtCelular.setText("");
        jcbPerfil.setSelectedItem("Cliente");
        jcbEstado.setSelectedItem("Activo");
    }

}
