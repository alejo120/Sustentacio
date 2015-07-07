package Vista;

import Entidades.AvionEnt;
import Negocio.AvionNg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

public class Aviones extends JPanel implements ActionListener, MouseListener, KeyListener {

    JLabel jlbCodigo;
    JLabel jlbCapacidad;
    JLabel jlbEstado;
    JLabel jlbValidar;

    JTextField jtxtCodigo;
    JTextField jtxtCapacidad;

    JComboBox jcbEstado;

    JPanel jpBotones;
    JPanel jpError;

    JButton jbtnListar;
    JButton jbtnBuscar;
    JButton jbtnActualizar;
    JButton jbtnLimpiar;

    private Object[][] Detalle_Usuario = new Object[0][0];//Creamos La matriz
    private Object[] Columnas_Usuario = {"Código", "Capacidad", "Estado"};//Los nombres de las filas
    private DefaultTableModel dataModel = new DefaultTableModel(Detalle_Usuario, Columnas_Usuario);
    JScrollPane pnDatos;//Barra desplazamiento abajo
    JTable tbDatos;//datos de la tabla DATAMODEL nesecito cargarlo en un objeto pra poderlo visualisa

    public Aviones() {
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
        jlbCodigo.setBounds(90, 135, 220, 25);
        jlbCodigo.setForeground(Color.BLACK);
        jlbCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCodigo);

        jtxtCodigo = new JTextField("");
        jtxtCodigo.setBounds(90, 160, 520, 30);
        jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCodigo.addKeyListener(this);
        this.add(jtxtCodigo);

        jlbCapacidad = new JLabel("*Capacidad");
        jlbCapacidad.setBounds(90, 215, 120, 25);
        jlbCapacidad.setForeground(Color.BLACK);
        jlbCapacidad.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCapacidad);

        jtxtCapacidad = new JTextField("");
        jtxtCapacidad.setBounds(90, 240, 520, 30);
        jtxtCapacidad.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCapacidad.addKeyListener(this);
        this.add(jtxtCapacidad);

        jlbEstado = new JLabel("*Estado");
        jlbEstado.setBounds(90, 295, 150, 25);
        jlbEstado.setForeground(Color.BLACK);
        jlbEstado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbEstado);

        jcbEstado = new JComboBox();
        jcbEstado.setBorder(null);
        jcbEstado.setBackground(Color.WHITE);
        jcbEstado.addItem("Activo");
        jcbEstado.addItem("Inactivo");
        jcbEstado.setBounds(90, 320, 520, 30);
        this.add(jcbEstado);

        jbtnListar = new JButton(" Lista");
        jbtnListar.setBounds(0, 0, 233, 60);
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

        jbtnBuscar = new JButton(" Buscar");
        jbtnBuscar.setBounds(233, 0, 234, 60);
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
        jbtnLimpiar.setBounds(467, 0, 233, 60);
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
        jpBotones.add(jbtnBuscar);
        jpBotones.add(jbtnActualizar);
        jpBotones.add(jbtnLimpiar);
        jpBotones.setLayout(null);
        jpBotones.setBounds(0, 478, 700, 60);
        this.add(jpBotones);

        jlbValidar = new JLabel("Los campos con (*) son obligatorios");
        jlbValidar.setForeground(Color.WHITE);
        jlbValidar.setBounds(80, 8, 300, 27);
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
        AvionEnt avionE = new AvionEnt();
        AvionNg avionN = new AvionNg();
        if (ae.getSource() == jbtnListar) {
            LimpiarCampos();
            pnDatos.setVisible(true);
            jpBotones.setVisible(false);
            jpError.setVisible(false);
            vaciar();
            llenarDatos();
        }
        if (ae.getSource() == jbtnBuscar) {
            LimpiarCampos();
            String Codigo;
            Codigo = jtxtCodigo.getText();
            if (Codigo.trim().length() != 0) {
                avionE = avionN.buscarAvionCodigo(Codigo);
                if (avionE != null) {
                    jtxtCodigo.setText(avionE.getCodigo());
                    jtxtCapacidad.setText(avionE.getCapacidad());
                    jcbEstado.setSelectedItem(avionE.getEstado());
                    jtxtCodigo.setFocusable(false);
                    jbtnBuscar.setVisible(false);
                    jbtnActualizar.setVisible(true);
                    if (jbtnActualizar.getBounds().x == 0) {
                        jbtnListar.setBounds(0, 0, 350, 60);
                        jbtnLimpiar.setBounds(350, 0, 350, 60);
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    jpError.setBackground(new Color(237, 28, 36));
                    jlbValidar.setText("El avión no se ha encontrado");
                }
            } else {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese el Código");
                jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }
        }

        if (ae.getSource() == jbtnActualizar) {
            if (jtxtCapacidad.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                jpError.setBackground(new Color(237, 28, 36));
                jlbValidar.setText("Ingrese los campos en rojo");
                jtxtCapacidad.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                return;
            } else {
                jtxtCapacidad.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea actualizar el avión?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (option == JOptionPane.YES_OPTION) {
                if (jtxtCodigo.getText().trim().length() > 0) {
                    avionE.setCodigo(jtxtCodigo.getText());
                }

                if (jtxtCapacidad.getText().trim().length() > 0) {
                    avionE.setCapacidad(jtxtCapacidad.getText());
                }

                avionE.setEstado((String) jcbEstado.getSelectedItem());

                boolean respuestau = avionN.modificarAvion(avionE);
                if (respuestau) {
                    LimpiarCampos();
                    jpError.setBackground(new Color(0, 154, 225));
                    jlbValidar.setText("Se ha actualizado el avión");
                }
            }
        }

        if (ae.getSource() == jbtnLimpiar) {
            LimpiarCampos();
            VaciarCampos();
            jtxtCodigo.setFocusable(true);
            jbtnBuscar.setVisible(true);
            jbtnActualizar.setVisible(false);
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
        Negocio.AvionNg avionN = new Negocio.AvionNg();
        setDataModel(avionN.cargarAviones(getDataModel()));

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
        if (ke.getSource() == jtxtCapacidad) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtCapacidad.getText().length() >= 2 || (c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACK_SPACE) && (c != (char) KeyEvent.VK_DELETE)) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
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
        if (ke.getSource() == jtxtCapacidad) {
            if (jtxtCapacidad.getText().trim().length() < 0) {
                jtxtCapacidad.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtCapacidad.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    public void LimpiarCampos() {
        jpError.setBackground(new Color(0, 123, 183));
        jlbValidar.setText("Los campos con (*) son obligatorios");
        jtxtCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCapacidad.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    public void VaciarCampos() {
        jtxtCodigo.setText("");
        jtxtCapacidad.setText("");
        jcbEstado.setSelectedItem("Activo");
    }

}
