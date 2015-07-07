package Vista;

import Entidades.VuelosEnt;
import Negocio.VuelosNg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

public class Vuelos extends JPanel implements ActionListener, MouseListener, KeyListener {

    JLabel jlbCodigo;
    JLabel jlbViaje;
    JLabel jlbAvion;
    JLabel jlbDia;
    JLabel jlbHora;
    JLabel jlbEstado;
    JLabel jlbValidar;

    JTextField jtxtCodigo;
    JTextField jtxtViaje;
    JTextField jtxtAvion;
    JTextField jtxtDia;
    JTextField jtxtHora;

    JComboBox jcbEstado;

    JPanel jpBotones;
    JPanel jpError;

    JButton jbtnListar;
    JButton jbtnGuardar;
    JButton jbtnBuscar;
    JButton jbtnActualizar;
    JButton jbtnLimpiar;

    private Object[][] Detalle_Usuario = new Object[0][0];//Creamos La matriz
    private Object[] Columnas_Usuario = {"Código", "Viaje", "Avión", "Día", "Hora", "Estado"};//Los nombres de las filas
    private DefaultTableModel dataModel = new DefaultTableModel(Detalle_Usuario, Columnas_Usuario);
    JScrollPane pnDatos;//Barra desplazamiento abajo
    JTable tbDatos;//datos de la tabla DATAMODEL nesecito cargarlo en un objeto pra poderlo visualisa

    public Vuelos() {
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

        jlbViaje = new JLabel("*Viaje");
        jlbViaje.setBounds(90, 180, 120, 25);
        jlbViaje.setForeground(Color.BLACK);
        jlbViaje.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbViaje);

        jtxtViaje = new JTextField("");
        jtxtViaje.setBounds(90, 205, 250, 30);
        jtxtViaje.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtViaje.addKeyListener(this);
        this.add(jtxtViaje);

        jlbAvion = new JLabel("*Avión");
        jlbAvion.setBounds(360, 180, 150, 25);
        jlbAvion.setForeground(Color.BLACK);
        jlbAvion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbAvion);

        jtxtAvion = new JTextField();
        jtxtAvion.setBounds(360, 205, 250, 30);
        jtxtAvion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtAvion.addKeyListener(this);
        this.add(jtxtAvion);

        jlbDia = new JLabel("*Día");
        jlbDia.setBounds(90, 260, 120, 25);
        jlbDia.setForeground(Color.BLACK);
        jlbDia.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbDia);

        jtxtDia = new JTextField("");
        jtxtDia.setBounds(90, 285, 250, 30);
        jtxtDia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtDia.addKeyListener(this);
        this.add(jtxtDia);

        jlbHora = new JLabel("*Hora");
        jlbHora.setBounds(360, 260, 150, 25);
        jlbHora.setForeground(Color.BLACK);
        jlbHora.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbHora);

        jtxtHora = new JTextField();
        jtxtHora.setBounds(360, 285, 250, 30);
        jtxtHora.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtHora.addKeyListener(this);
        this.add(jtxtHora);

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
        jbtnActualizar.setBounds(233, 0, 234, 60);
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
        VuelosEnt vuelosE = new VuelosEnt();
        VuelosNg vuelosN = new VuelosNg();
        if (ae.getSource() == jbtnListar) {
            LimpiarCampos();
            pnDatos.setVisible(true);
            jpBotones.setVisible(false);
            jpError.setVisible(false);
            vaciar();
            llenarDatos();
        }
        if (ae.getSource() == jbtnGuardar) {
            if (jtxtCodigo.getText().trim().length() == 0 || jtxtViaje.getText().trim().length() == 0 || jtxtAvion.getText().trim().length() == 0 || jtxtDia.getText().trim().length() == 0 || jtxtHora.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese los campos en rojo");

                if (jtxtCodigo.getText().trim().length() == 0) {
                    jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtViaje.getText().trim().length() == 0) {
                    jtxtViaje.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtViaje.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtAvion.getText().trim().length() == 0) {
                    jtxtAvion.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtAvion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtDia.getText().trim().length() == 0) {
                    jtxtDia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtDia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtHora.getText().trim().length() == 0) {
                    jtxtHora.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtHora.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                return;
            }
            if (jtxtDia.getText().trim().length() != 8 || jtxtHora.getText().trim().length() < 9) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese un tamaño mayor en los campos rojos");

                if (jtxtDia.getText().trim().length() != 8) {
                    jtxtDia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtDia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

                }
                if (jtxtHora.getText().trim().length() < 9) {
                    jtxtHora.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtHora.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }
                return;
            }
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea guardar el vuelo?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (option == JOptionPane.YES_OPTION) {
                if (jtxtCodigo.getText().trim().length() > 0) {
                    vuelosE.setCodigo(jtxtCodigo.getText());
                }

                if (jtxtViaje.getText().trim().length() > 0) {
                    vuelosE.setViaje(jtxtViaje.getText());
                }

                if (jtxtAvion.getText().trim().length() > 0) {
                    vuelosE.setAvion(jtxtAvion.getText());
                }

                if (jtxtDia.getText().trim().length() > 0) {
                    vuelosE.setDia(jtxtDia.getText());
                }

                if (jtxtHora.getText().trim().length() > 0) {
                    vuelosE.setHora(jtxtHora.getText());
                }

                vuelosE.setEstado((String) jcbEstado.getSelectedItem());

                boolean guarda = vuelosN.guardarVuelo(vuelosE);
                if (guarda) {
                    VaciarCampos();
                    LimpiarCampos();
                    jpError.setBackground(new Color(0, 154, 225));
                    jlbValidar.setText("Se ha guardado el vuelo");
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    jpError.setBackground(new Color(237, 28, 36));
                    jlbValidar.setText("El vuelo ya estaba guardado");
                }
            }
        }

        if (ae.getSource() == jbtnBuscar) {
            LimpiarCampos();
            String Codigo;
            Codigo = jtxtCodigo.getText();
            if (Codigo.trim().length() != 0) {
                vuelosE = vuelosN.buscarVueloCodigo(Codigo);
                if (vuelosE != null) {
                    jtxtCodigo.setText(vuelosE.getCodigo());
                    jtxtDia.setText(vuelosE.getDia());
                    jtxtHora.setText(vuelosE.getHora());
                    jtxtViaje.setText(vuelosE.getViaje());
                    jtxtAvion.setText(vuelosE.getAvion());
                    jcbEstado.setSelectedItem(vuelosE.getEstado());
                    jtxtCodigo.setFocusable(false);
                    jbtnGuardar.setVisible(false);
                    jbtnBuscar.setVisible(false);
                    jbtnActualizar.setVisible(true);
                    jbtnListar.setBounds(0, 0, 233, 60);
                    jbtnLimpiar.setBounds(467, 0, 233, 60);
                    if (jbtnActualizar.getBounds().x == 0) {
                        jbtnListar.setBounds(0, 0, 350, 60);
                        jbtnLimpiar.setBounds(350, 0, 350, 60);
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    jpError.setBackground(new Color(237, 28, 36));
                    jlbValidar.setText("El vuelo no se ha encontrado");
                }
            } else {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese el Código");
                jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }
        }

        if (ae.getSource() == jbtnActualizar) {
            if (jtxtViaje.getText().trim().length() == 0 || jtxtAvion.getText().trim().length() == 0 || jtxtDia.getText().trim().length() == 0 || jtxtHora.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese los campos en rojo");

                if (jtxtCodigo.getText().trim().length() == 0) {
                    jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtViaje.getText().trim().length() == 0) {
                    jtxtViaje.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtViaje.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtAvion.getText().trim().length() == 0) {
                    jtxtAvion.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtAvion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtDia.getText().trim().length() == 0) {
                    jtxtDia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtDia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtHora.getText().trim().length() == 0) {
                    jtxtHora.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtHora.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                return;
            }
            if (jtxtDia.getText().trim().length() != 8 || jtxtHora.getText().trim().length() < 9) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese un tamaño mayor en los campos rojos");

                if (jtxtDia.getText().trim().length() != 8) {
                    jtxtDia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtDia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

                }
                if (jtxtHora.getText().trim().length() < 9) {
                    jtxtHora.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtHora.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }
                return;
            }
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea actualizar el vuelo?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (option == JOptionPane.YES_OPTION) {
                if (jtxtCodigo.getText().trim().length() > 0) {
                    vuelosE.setCodigo(jtxtCodigo.getText());
                }

                if (jtxtViaje.getText().trim().length() > 0) {
                    vuelosE.setViaje(jtxtViaje.getText());
                }

                if (jtxtAvion.getText().trim().length() > 0) {
                    vuelosE.setAvion(jtxtAvion.getText());
                }

                if (jtxtDia.getText().trim().length() > 0) {
                    vuelosE.setDia(jtxtDia.getText());
                }

                if (jtxtHora.getText().trim().length() > 0) {
                    vuelosE.setHora(jtxtHora.getText());
                }

                vuelosE.setEstado((String) jcbEstado.getSelectedItem());

                boolean respuestau = vuelosN.modificarVuelo(vuelosE);
                if (respuestau) {
                    LimpiarCampos();
                    jpError.setBackground(new Color(0, 154, 225));
                    jlbValidar.setText("Se ha actualizado el vuelo");
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
            jbtnListar.setBounds(0, 0, 175, 60);
            jbtnLimpiar.setBounds(525, 0, 175, 60);
            if (jbtnActualizar.getBounds().x == 0) {
                jbtnListar.setBounds(0, 0, 233, 60);
                jbtnLimpiar.setBounds(467, 0, 233, 60);
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
        Negocio.VuelosNg VuelosN = new Negocio.VuelosNg();
        setDataModel(VuelosN.cargarVuelos(getDataModel()));

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
        if (ke.getSource() == jtxtViaje) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtViaje.getText().length() >= 5 || (c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }
        if (ke.getSource() == jtxtAvion) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtAvion.getText().length() >= 5 || (c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }
        if (ke.getSource() == jtxtDia) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtDia.getText().length() >= 8) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }
        if (ke.getSource() == jtxtHora) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtHora.getText().length() >= 10) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtDia) {
            if (jtxtDia.getText().trim().length() != 8) {
                jtxtDia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtDia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }

        if (ke.getSource() == jtxtHora) {
            if (jtxtHora.getText().trim().length() < 9) {
                jtxtHora.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtHora.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
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
        if (ke.getSource() == jtxtViaje) {
            if (jtxtViaje.getText().trim().length() < 0) {
                jtxtViaje.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtViaje.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtAvion) {
            if (jtxtAvion.getText().trim().length() < 0) {
                jtxtAvion.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtAvion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtDia) {
            if (jtxtDia.getText().trim().length() != 8) {
                jtxtDia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtDia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtHora) {
            if (jtxtHora.getText().trim().length() < 9) {
                jtxtHora.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtHora.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    public void LimpiarCampos() {
        jpError.setBackground(new Color(0, 123, 183));
        jlbValidar.setText("Los campos con (*) son obligatorios");
        jtxtDia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtHora.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtViaje.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtAvion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    public void VaciarCampos() {
        jtxtCodigo.setText("");
        jtxtDia.setText("");
        jtxtHora.setText("");
        jtxtViaje.setText("");
        jtxtAvion.setText("");
        jcbEstado.setSelectedItem("Activo");
    }

}
