package Vista;

import Entidades.ReservaEnt;
import Negocio.ReservaNg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

public class Reservas extends JPanel implements ActionListener, MouseListener, KeyListener {

    JLabel jlbCodigo;
    JLabel jlbVuelo;
    JLabel jlbDocumento;
    JLabel jlbPuesto;
    JLabel jlbEstado;
    JLabel jlbValidar;

    JTextField jtxtCodigo;
    JTextField jtxtVuelo;
    JTextField jtxtDocumento;
    JTextField jtxtPuesto;

    JComboBox jcbEstado;

    JPanel jpBotones;
    JPanel jpError;

    JButton jbtnListar;
    JButton jbtnGuardar;
    JButton jbtnBuscar;
    JButton jbtnActualizar;
    JButton jbtnEliminar;
    JButton jbtnLimpiar;

    String doc_ident;

    private Object[][] Detalle_Usuario = new Object[0][0];//Creamos La matriz
    private Object[] Columnas_Usuario = {"Código", "Vuelo", "Documento", "Puesto", "Estado"};//Los nombres de las filas
    private DefaultTableModel dataModel = new DefaultTableModel(Detalle_Usuario, Columnas_Usuario);
    JScrollPane pnDatos;//Barra desplazamiento abajo
    JTable tbDatos;//datos de la tabla DATAMODEL nesecito cargarlo en un objeto pra poderlo visualisa

    public Reservas() {
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

        jlbCodigo = new JLabel("*Código");
        jlbCodigo.setBounds(90, 100, 220, 25);
        jlbCodigo.setForeground(Color.BLACK);
        jlbCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCodigo);

        jtxtCodigo = new JTextField("");
        jtxtCodigo.setBounds(90, 125, 520, 30);
        jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCodigo.addKeyListener(this);
        this.add(jtxtCodigo);

        jlbVuelo = new JLabel("*Vuelo");
        jlbVuelo.setBounds(90, 180, 150, 25);
        jlbVuelo.setForeground(Color.BLACK);
        jlbVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbVuelo);

        jtxtVuelo = new JTextField("");
        jtxtVuelo.setBounds(90, 205, 250, 30);
        jtxtVuelo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtVuelo.addKeyListener(this);
        this.add(jtxtVuelo);

        jlbDocumento = new JLabel("*Documento");
        jlbDocumento.setBounds(360, 180, 150, 25);
        jlbDocumento.setForeground(Color.BLACK);
        jlbDocumento.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbDocumento);

        jtxtDocumento = new JTextField();
        jtxtDocumento.setBounds(360, 205, 250, 30);
        jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtDocumento.addKeyListener(this);
        this.add(jtxtDocumento);

        jlbPuesto = new JLabel("*Puesto");
        jlbPuesto.setBounds(90, 260, 120, 25);
        jlbPuesto.setForeground(Color.BLACK);
        jlbPuesto.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbPuesto);

        jtxtPuesto = new JTextField("");
        jtxtPuesto.setBounds(90, 285, 520, 30);
        jtxtPuesto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtPuesto.addKeyListener(this);
        this.add(jtxtPuesto);

        jlbEstado = new JLabel("*Estado");
        jlbEstado.setBounds(90, 340, 150, 25);
        jlbEstado.setForeground(Color.BLACK);
        jlbEstado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbEstado);

        jcbEstado = new JComboBox();
        jcbEstado.setBorder(null);
        jcbEstado.setBackground(Color.WHITE);
        jcbEstado.addItem("Activo");
        jcbEstado.addItem("Inactivo");
        jcbEstado.setBounds(90, 365, 520, 30);
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
        ReservaEnt reservaE = new ReservaEnt();
        ReservaNg reservaN = new ReservaNg();
        if (ae.getSource() == jbtnListar) {
            LimpiarCampos();
            pnDatos.setVisible(true);
            jpBotones.setVisible(false);
            jpError.setVisible(false);
            vaciar();
            if (jbtnBuscar.getBounds().x == 0) {
                llenarDatosDocumento();
            } else {
                llenarDatos();
            }
        }
        if (ae.getSource() == jbtnGuardar) {
            if (jtxtCodigo.getText().trim().length() == 0 || jtxtVuelo.getText().trim().length() == 0 || jtxtDocumento.getText().trim().length() == 0 || jtxtPuesto.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese los campos en rojo");

                if (jtxtCodigo.getText().trim().length() == 0) {
                    jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtVuelo.getText().trim().length() == 0) {
                    jtxtVuelo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtVuelo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtDocumento.getText().trim().length() == 0) {
                    jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtPuesto.getText().trim().length() == 0) {
                    jtxtPuesto.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtPuesto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                return;
            }
            if (jtxtDocumento.getText().trim().length() <= 7) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese un tamaño mayor en los campos rojos");
                jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                return;
            } else {
                jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea guardar la reserva?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (option == JOptionPane.YES_OPTION) {
                if (jtxtCodigo.getText().trim().length() > 0) {
                    reservaE.setCodigo(jtxtCodigo.getText());
                }

                if (jtxtVuelo.getText().trim().length() > 0) {
                    reservaE.setVuelo(jtxtVuelo.getText());
                }

                if (jtxtDocumento.getText().trim().length() > 0) {
                    reservaE.setDocumento(jtxtDocumento.getText());
                }

                if (jtxtPuesto.getText().trim().length() > 0) {
                    reservaE.setPuesto(jtxtPuesto.getText());
                }

                reservaE.setEstado((String) jcbEstado.getSelectedItem());

                boolean guarda = reservaN.guardarReserva(reservaE);
                if (guarda) {
                    VaciarCampos();
                    LimpiarCampos();
                    jpError.setBackground(new Color(0, 154, 225));
                    jlbValidar.setText("Se ha guardado la reserva");
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    jpError.setBackground(new Color(237, 28, 36));
                    jlbValidar.setText("La reserva ya estaba guardada");

                }
            }
        }

        if (ae.getSource() == jbtnBuscar) {
            LimpiarCampos();
            String Codigo;
            Codigo = jtxtCodigo.getText();
            if (Codigo.trim().length() != 0) {
                reservaE = reservaN.buscarReservaCodigo(Codigo);
                if (reservaE != null) {
                    jtxtCodigo.setText(reservaE.getCodigo());
                    jtxtPuesto.setText(reservaE.getPuesto());
                    jtxtVuelo.setText(reservaE.getVuelo());
                    jtxtDocumento.setText(reservaE.getDocumento());
                    jcbEstado.setSelectedItem(reservaE.getEstado());
                    jtxtCodigo.setFocusable(false);
                    jbtnGuardar.setVisible(false);
                    jbtnBuscar.setVisible(false);
                    jbtnActualizar.setVisible(true);
                    jbtnEliminar.setVisible(true);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    jpError.setBackground(new Color(237, 28, 36));
                    jlbValidar.setText("La reserva no se ha encontrado");
                }
            } else {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese el Código");
                jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }
        }

        if (ae.getSource() == jbtnActualizar) {
            if (jtxtVuelo.getText().trim().length() == 0 || jtxtDocumento.getText().trim().length() == 0 || jtxtPuesto.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese los campos en rojo");

                if (jtxtCodigo.getText().trim().length() == 0) {
                    jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtVuelo.getText().trim().length() == 0) {
                    jtxtVuelo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtVuelo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtDocumento.getText().trim().length() == 0) {
                    jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtPuesto.getText().trim().length() == 0) {
                    jtxtPuesto.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtPuesto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                return;
            }
            if (jtxtDocumento.getText().trim().length() <= 7) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese un tamaño mayor en los campos rojos");
                jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                return;
            } else {
                jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea actualizar la reserva?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (option == JOptionPane.YES_OPTION) {
                if (jtxtCodigo.getText().trim().length() > 0) {
                    reservaE.setCodigo(jtxtCodigo.getText());
                }

                if (jtxtVuelo.getText().trim().length() > 0) {
                    reservaE.setVuelo(jtxtVuelo.getText());
                }

                if (jtxtDocumento.getText().trim().length() > 0) {
                    reservaE.setDocumento(jtxtDocumento.getText());
                }

                if (jtxtPuesto.getText().trim().length() > 0) {
                    reservaE.setPuesto(jtxtPuesto.getText());
                }

                reservaE.setEstado((String) jcbEstado.getSelectedItem());

                boolean respuestau = reservaN.modificarReserva(reservaE);
                if (respuestau) {
                    LimpiarCampos();
                    jpError.setBackground(new Color(0, 154, 225));
                    jlbValidar.setText("Se ha actualizado la reserva");
                }
            }
        }

        if (ae.getSource() == jbtnEliminar) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar la reserva?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (option == JOptionPane.YES_OPTION) {
                String codigo = jtxtCodigo.getText();
                boolean respuestap;
                if (codigo != null) {
                    respuestap = reservaN.eliminarReserva(codigo);
                    if (respuestap) {
                        jtxtCodigo.setFocusable(true);
                        jbtnGuardar.setVisible(true);
                        jbtnBuscar.setVisible(true);
                        jbtnActualizar.setVisible(false);
                        jbtnEliminar.setVisible(false);
                        LimpiarCampos();
                        VaciarCampos();
                        jpError.setBackground(new Color(0, 154, 225));
                        jlbValidar.setText("La Reserva fue eliminada");
                    }
                }
            }
        }

        if (ae.getSource() == jbtnLimpiar) {
            LimpiarCampos();
            VaciarCampos();
            jtxtCodigo.setFocusable(true);
            jbtnGuardar.setVisible(true);
            jbtnBuscar.setVisible(true);
            jbtnActualizar.setVisible(false);
            jbtnEliminar.setVisible(false);
        }

    }

    public void setDataModel(DefaultTableModel dataModel) {
        this.dataModel = dataModel;
    }

    public DefaultTableModel getDataModel() {
        return dataModel;
    }

    public void llenarDatos() {
        Negocio.ReservaNg ReservaN = new Negocio.ReservaNg();
        setDataModel(ReservaN.cargarReservas(getDataModel()));
    }

    public void llenarDatosDocumento() {
        Negocio.ReservaNg ReservaN = new Negocio.ReservaNg();
        setDataModel(ReservaN.cargarReservasDocumento(getDataModel(), doc_ident));
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
        if (ke.getSource() == jtxtCodigo) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtCodigo.getText().length() >= 5 || (c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }
        if (ke.getSource() == jtxtVuelo) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtVuelo.getText().length() >= 5 || (c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }
        if (ke.getSource() == jtxtDocumento) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtDocumento.getText().length() >= 20 || (c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }
        if (ke.getSource() == jtxtPuesto) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtPuesto.getText().length() >= 2 || (c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtDocumento) {
            if (jtxtDocumento.getText().length() <= 7) {
                jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getSource() == jtxtCodigo) {
            if (jtxtCodigo.getText().trim().length() < 0) {
                jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtVuelo) {
            if (jtxtVuelo.getText().trim().length() < 0) {
                jtxtVuelo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtVuelo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtDocumento) {
            if (jtxtDocumento.getText().trim().length() < 0) {
                jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtPuesto) {
            if (jtxtPuesto.getText().trim().length() < 0) {
                jtxtPuesto.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtPuesto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    public void LimpiarCampos() {
        jpError.setBackground(new Color(0, 123, 183));
        jlbValidar.setText("Los campos con (*) son obligatorios");
        jtxtPuesto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtVuelo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtDocumento.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    public void VaciarCampos() {
        jtxtCodigo.setText("");
        jtxtPuesto.setText("");
        jtxtVuelo.setText("");
        if (jbtnBuscar.getBounds().x != 0) {
            jtxtDocumento.setText("");
        }
        jcbEstado.setSelectedItem("Activo");
    }

}
