package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Perfil extends JPanel implements ActionListener, KeyListener, MouseListener {

    JLabel jlbCorreo;
    JLabel jlbClave;
    JLabel jlbNombre;
    JLabel jlbApellido;
    JLabel jlbTelefono;
    JLabel jlbCelular;
    JLabel jlbValidar;
    JPanel jpError;

    JTextField jtxtCorreo;
    JTextField jtxtClave;
    JTextField jtxtNombre;
    JTextField jtxtApellido;
    JTextField jtxtTelefono;
    JTextField jtxtCelular;

    JButton jbtnCargarI;
    JLabel jlbimage, nombre, jbtnQuitarI;
    String x = null;
    String Doc;
    BufferedImage bmp = null, algo;
    ImageIcon image = new ImageIcon();

    public Perfil() {
        super.setBounds(181, 61, 700, 538);  //(ancho,alto)
        super.setLayout(null);
        super.setOpaque(false);
        super.setVisible(false);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        jbtnQuitarI = new JLabel("x");
        jbtnQuitarI.setBounds(226, 70, 12, 25);
        jbtnQuitarI.setForeground(Color.DARK_GRAY);
        jbtnQuitarI.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        jbtnQuitarI.setToolTipText("Quitar Imagen");
        jbtnQuitarI.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnQuitarI.addMouseListener(this);
        this.add(jbtnQuitarI);

        jlbimage = new JLabel();
        jlbimage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jlbimage.setBounds(90, 76, 150, 150);
        this.add(jlbimage);

        nombre = new JLabel("Ninguna imagen seleccionada");
        nombre.setBounds(90, 256, 200, 40);
        nombre.setForeground(Color.GRAY);
        this.add(nombre);

        jbtnCargarI = new JButton("Cargar imagen");
        jbtnCargarI.setBounds(90, 226, 150, 40);
        jbtnCargarI.addActionListener(this);
        jbtnCargarI.setBorder(null);
        jbtnCargarI.setBackground(new Color(0, 154, 225));
        jbtnCargarI.setForeground(Color.WHITE);
        jbtnCargarI.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jbtnCargarI.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCargarI.setFocusPainted(false);
        jbtnCargarI.addMouseListener(this);
        this.add(jbtnCargarI);

        jlbNombre = new JLabel("Nombre");
        jlbNombre.setBounds(270, 96, 120, 25);
        jlbNombre.setForeground(Color.BLACK);
        jlbNombre.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbNombre);

        jtxtNombre = new JTextField();
        jtxtNombre.setBounds(270, 121, 340, 30);
        jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtNombre.addKeyListener(this);
        this.add(jtxtNombre);

        jlbApellido = new JLabel("Apellido");
        jlbApellido.setBounds(270, 176, 150, 25);
        jlbApellido.setForeground(Color.BLACK);
        jlbApellido.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbApellido);

        jtxtApellido = new JTextField();
        jtxtApellido.setBounds(270, 201, 340, 30);
        jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtApellido.addKeyListener(this);
        this.add(jtxtApellido);

        jlbCorreo = new JLabel("Correo");
        jlbCorreo.setBounds(90, 305, 120, 25);
        jlbCorreo.setForeground(Color.BLACK);
        jlbCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCorreo);

        jtxtCorreo = new JTextField();
        jtxtCorreo.setBounds(90, 330, 250, 30);
        jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCorreo.addKeyListener(this);
        this.add(jtxtCorreo);

        jlbClave = new JLabel("Contraseña");
        jlbClave.setBounds(360, 305, 150, 25);
        jlbClave.setForeground(Color.BLACK);
        jlbClave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbClave);

        jtxtClave = new JPasswordField();
        jtxtClave.setBounds(360, 330, 250, 30);
        jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtClave.addKeyListener(this);
        this.add(jtxtClave);

        jlbTelefono = new JLabel("Teléfono");
        jlbTelefono.setBounds(90, 385, 120, 25);
        jlbTelefono.setForeground(Color.BLACK);
        jlbTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbTelefono);

        jtxtTelefono = new JTextField();
        jtxtTelefono.setBounds(90, 410, 250, 30);
        jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtTelefono.addKeyListener(this);
        this.add(jtxtTelefono);

        jlbCelular = new JLabel("Celular");
        jlbCelular.setBounds(360, 385, 150, 25);
        jlbCelular.setForeground(Color.BLACK);
        jlbCelular.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCelular);

        jtxtCelular = new JTextField();
        jtxtCelular.setBounds(360, 410, 250, 30);
        jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCelular.addKeyListener(this);
        this.add(jtxtCelular);

        jlbValidar = new JLabel("Aquí puedes administrar la información básica sobre tu cuenta");
        jlbValidar.setForeground(Color.WHITE);
        jlbValidar.setBounds(80, 8, 500, 27);
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
        if (ae.getSource() == jbtnCargarI) {

            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }

            //Creamos un nuevo cuadro de diálogo para seleccionar imagen
            JFileChooser selector = new JFileChooser();
            //Le damos un título
            selector.setDialogTitle("Seleccione una imagen");
            //Filtramos los tipos de archivos
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
            selector.setFileFilter(filtroImagen);
            //Abrimos el cuadro de diálog
            int flag = selector.showOpenDialog(null);
            //Comprobamos que pulse en aceptar
            if (flag == JFileChooser.APPROVE_OPTION) {
                try {
                    //Devuelve el fichero seleccionado
                    File imagenSeleccionada = selector.getSelectedFile();
                    //sacamos el nombre de la imagen
                    x = imagenSeleccionada.getName();
                    //Asignamos a la variable bmp la imagen leida
                    bmp = ImageIO.read(imagenSeleccionada);
                } catch (Exception e) {
                    System.out.print("El error es: " + e);
                }
                image.setImage(bmp);
                jlbimage.setIcon(new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
                nombre.setText(x);
            }

            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {
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
            if (jtxtCelular.getText().length() <= 11) {
                jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
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
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jbtnQuitarI) {
            jlbimage.setIcon(new ImageIcon(getClass().getResource("/Imagenes/defecto.png")));
            bmp = null;
            nombre.setText("Ninguna imagen seleccionada");
            x = null;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == jbtnCargarI) {
            jbtnCargarI.setBackground(new Color(0, 123, 183));
        }
        if (e.getSource() == jbtnQuitarI) {
            jbtnQuitarI.setForeground(new Color(237, 28, 36));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == jbtnCargarI) {
            jbtnCargarI.setBackground(new Color(0, 154, 225));
        }
        if (e.getSource() == jbtnQuitarI) {
            jbtnQuitarI.setForeground(Color.DARK_GRAY);
        }
    }

}
