package Vista;

import Entidades.UsuarioEnt;
import Negocio.UsuarioNg;
import javax.swing.*;            // para los botones
import java.awt.*;               //Paquete que contiene imagenes y eventos "awt"
import java.awt.event.*;

public class Login extends JFrame implements MouseListener, KeyListener, MouseMotionListener, ActionListener {

    static String tipoU;
    Negocio.UsuarioNg usuarioNg = new Negocio.UsuarioNg();
    JLabel jlbAirlineTravel;
    JLabel jlbLogin;
    JLabel jlbCorreo;
    JLabel jlbClave;
    JLabel jlb_x1, jlb_x2;
    JLabel jlbValidarC;
    JLabel jlbValidarP;
    JLabel jlbValidarCC;
    JLabel jlbValidarH;
    JLabel jlbNotiene;
    JLabel jlbsub;
    JLabel jlbRegistrate;
    JButton jbtnIngresar;
    JTextField jtxtCorreo;
    JTextField jtxtClave;
    String Clave;
    String Correo;

    JPanel movedor;
    int x, y;

    public Login() {
        super.setTitle("Inicio");
        super.setSize(658, 519);
        super.setLayout(null);
        super.setUndecorated(true);
        super.getContentPane().setBackground(Color.BLACK);
        super.setResizable(true);
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        this.setVisible(true);

        jlb_x1 = new JLabel("-");
        jlb_x1.setBounds(585, 20, 25, 25);
        jlb_x1.setForeground(Color.DARK_GRAY);
        jlb_x1.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        jlb_x1.addMouseListener(this);
        jlb_x1.setToolTipText("Minimizar");
        jlb_x1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x1);

        jlb_x2 = new JLabel("x");
        jlb_x2.setBounds(615, 5, 20, 40);
        jlb_x2.setForeground(Color.DARK_GRAY);
        jlb_x2.setFont(new Font("Segoe UI", Font.PLAIN, 35));
        jlb_x2.addMouseListener(this);
        jlb_x2.setToolTipText("Cerrar");
        jlb_x2.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x2);

        jlbAirlineTravel = new JLabel("Airline Travel");
        jlbAirlineTravel.setBounds(130, 18, 150, 20);
        jlbAirlineTravel.setForeground(Color.BLACK);
        jlbAirlineTravel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbAirlineTravel);

        movedor = new JPanel();
        movedor.setOpaque(false);
        movedor.setLayout(null);
        movedor.add(jlb_x1);
        movedor.add(jlb_x2);
        movedor.add(jlbAirlineTravel);
        movedor.setBounds(1, 1, 656, 60);
        movedor.addMouseListener(this);
        movedor.addMouseMotionListener(this);
        this.add(movedor);

        jlbLogin = new JLabel("Iniciar Sesión");
        jlbLogin.setBounds(80, 85, 250, 30);
        jlbLogin.setForeground(Color.WHITE);
        jlbLogin.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        this.add(jlbLogin);

        jlbCorreo = new JLabel("Correo electrónico");
        jlbCorreo.setBounds(90, 175, 160, 25);
        jlbCorreo.setForeground(Color.BLACK);
        jlbCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCorreo);

        jtxtCorreo = new JTextField("cliente@hotmail.com");
        jtxtCorreo.setBounds(90, 200, 478, 30);
        jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCorreo.addKeyListener(this);
        this.add(jtxtCorreo);

        jlbClave = new JLabel("Contraseña");
        jlbClave.setBounds(90, 265, 150, 25);
        jlbClave.setForeground(Color.BLACK);
        jlbClave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbClave);

        jtxtClave = new JPasswordField("cliente123");
        jtxtClave.setBounds(90, 290, 478, 30);
        jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtClave.addKeyListener(this);
        this.add(jtxtClave);

        jbtnIngresar = new JButton("Iniciar Sesión");
        jbtnIngresar.setBorder(null);
        jbtnIngresar.setBounds(90, 360, 200, 35);
        jbtnIngresar.setBackground(new Color(0, 154, 225));
        jbtnIngresar.setForeground(Color.WHITE);
        jbtnIngresar.addActionListener(this);
        jbtnIngresar.addMouseListener(this);
        jbtnIngresar.setFocusPainted(false);
        jbtnIngresar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jbtnIngresar);

        jlbNotiene = new JLabel("¿No dispones de una cuenta?");
        jlbNotiene.setBounds(90, 410, 200, 25);
        jlbNotiene.setForeground(Color.BLACK);
        jlbNotiene.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        this.add(jlbNotiene);

        jlbRegistrate = new JLabel("Regístrate ahora");
        jlbRegistrate.setBounds(290, 410, 150, 25);
        jlbRegistrate.setForeground(new Color(0, 154, 225));
        jlbRegistrate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jlbRegistrate.addMouseListener(this);
        jlbRegistrate.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlbRegistrate);

        jlbsub = new JLabel("___________________");
        jlbsub.setBounds(289, 410, 150, 25);
        jlbsub.setForeground(Color.BLACK);
        jlbsub.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jlbsub.addMouseListener(this);
        jlbsub.setVisible(false);
        jlbsub.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlbsub);

        jlbValidarC = new JLabel();
        jlbValidarC.setForeground(Color.RED);
        jlbValidarC.setBounds(90, 225, 250, 27);
        jlbValidarC.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarC.setVisible(false);
        this.add(jlbValidarC);

        jlbValidarP = new JLabel();
        jlbValidarP.setForeground(Color.RED);
        jlbValidarP.setBounds(90, 315, 250, 27);
        jlbValidarP.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarP.setVisible(false);
        this.add(jlbValidarP);

        jlbValidarCC = new JLabel("Por favor, asegúrese de escribir los datos correctamente");
        jlbValidarCC.setForeground(Color.RED);
        jlbValidarCC.setBounds(160, 325, 350, 27);
        jlbValidarCC.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarCC.setVisible(false);
        this.add(jlbValidarCC);

        jlbValidarH = new JLabel("¡Actualmente esta cuenta esta Inactiva!");
        jlbValidarH.setForeground(Color.RED);
        jlbValidarH.setBounds(210, 325, 250, 27);
        jlbValidarH.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarH.setVisible(false);
        this.add(jlbValidarH);

        JLabel icono = new JLabel();
        icono.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Login-32.png")));
        icono.setBounds(35, 82, 40, 40);
        this.add(icono);

        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/Login.png")));
        fondo.setBounds(0, 0, 658, 519);
        this.add(fondo);

        this.repaint();

    }

    public static void main(String[] args) {
        Login l = new Login();
    }

    public void actionPerformed(ActionEvent e) {

        boolean valido;
        String validoClave;
        UsuarioEnt usuarioE = new UsuarioEnt();
        UsuarioNg usuarioN = new UsuarioNg();

        if (e.getSource() == jbtnIngresar) {
            valido = validarCampos();
            int cont = 0, cont2 = 0;
            String usuario;
            usuario = jtxtCorreo.getText();
            usuarioE = usuarioN.buscarUsuarioCorreo(usuario);
            if (valido) {

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
                    jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    jlbValidarC.setVisible(true);
                    jlbValidarP.setVisible(false);
                    jlbValidarC.setText("Ingrese una dirección de correo válida");
                    jlbValidarCC.setVisible(false);
                    jlbValidarH.setVisible(false);
                } else {
                    validoClave = usuarioNg.verificarUsuario(Correo, Clave);
                    tipoU = validoClave;
                    if (validoClave != "none" && validoClave != "Inactivo") {
                        if (validoClave == "Administrador") {
                            Menu mi = new Menu();
                            mi.jlbNombre.setText(usuarioE.getNombre() + " " + usuarioE.getApellido());
                            mi.jlbCorreo.setText(usuarioE.getCorreo());
                            mi.jlbimage.setIcon(new ImageIcon(getClass().getResource("/Imagenes/admin.png")));
                            this.setVisible(false);
                            this.dispose();
                        } else if (validoClave == "Secretaria") {
                            Menu mi = new Menu();
                            mi.jlbNombre.setText(usuarioE.getNombre() + " " + usuarioE.getApellido());
                            mi.jlbCorreo.setText(usuarioE.getCorreo());
                            mi.jlbimage.setIcon(new ImageIcon(getClass().getResource("/Imagenes/secre.png")));

                            mi.jpUsuarios.jbtnActualizar.setBounds(0, 0, 0, 0);
                            mi.jpUsuarios.jbtnEliminar.setBounds(0, 0, 0, 0);

                            mi.jpAviones.jbtnActualizar.setBounds(0, 0, 0, 0);

                            mi.jpViajes.jbtnActualizar.setBounds(0, 0, 0, 0);

                            mi.jpVuelos.jbtnGuardar.setBounds(0, 0, 0, 0);
                            mi.jpVuelos.jbtnActualizar.setBounds(0, 0, 0, 0);
                            mi.jpVuelos.jbtnBuscar.setBounds(233, 0, 234, 60);
                            mi.jpVuelos.jbtnListar.setBounds(0, 0, 233, 60);
                            mi.jpVuelos.jbtnLimpiar.setBounds(467, 0, 233, 60);

                            this.setVisible(false);
                            this.dispose();
                        } else if (validoClave == "Cliente") {
                            Menu mi = new Menu();
                            mi.jbtnUsuarios.setVisible(false);
                            mi.jbtnAviones.setVisible(false);
                            mi.jbtnViajes.setVisible(false);
                            mi.jbtnPerfil.setVisible(true);
                            mi.jbtnAyuda.setVisible(true);
                            mi.jbtnContactanos.setVisible(true);
                            mi.jbtnVuelos.setBounds(0, 60, 180, 60);
                            mi.jbtnReservas.setBounds(0, 120, 180, 60);

                            mi.jpVuelos.jbtnGuardar.setBounds(0, 0, 0, 0);
                            mi.jpVuelos.jbtnActualizar.setBounds(0, 0, 0, 0);
                            mi.jpVuelos.jbtnBuscar.setBounds(233, 0, 234, 60);
                            mi.jpVuelos.jbtnListar.setBounds(0, 0, 233, 60);
                            mi.jpVuelos.jbtnLimpiar.setBounds(467, 0, 233, 60);

                            mi.jpReservas.jbtnBuscar.setBounds(0, 0, 0, 0);
                            mi.jpReservas.jbtnActualizar.setBounds(0, 0, 0, 0);
                            mi.jpReservas.jbtnGuardar.setBounds(233, 0, 234, 60);
                            mi.jpReservas.jbtnListar.setBounds(0, 0, 233, 60);
                            mi.jpReservas.jbtnLimpiar.setBounds(467, 0, 233, 60);

                            mi.jlbNombre.setText(usuarioE.getNombre() + " " + usuarioE.getApellido());
                            mi.jlbCorreo.setText(usuarioE.getCorreo());

                            mi.jpPerfil.Doc = usuarioE.getDocumento();
                            mi.Nombre = usuarioE.getNombre();
                            mi.Apellido = usuarioE.getApellido();
                            mi.Correo = usuarioE.getCorreo();
                            mi.Clave = usuarioE.getClave();
                            mi.Telefono = usuarioE.getTelefono();
                            mi.Celular = usuarioE.getCelular();
                            mi.jpPerfil.nombre.setText("Ninguna imagen seleccionada");
                            mi.jpPerfil.jlbimage.setIcon(mi.jlbimage.getIcon());
                            mi.jpPerfil.jtxtNombre.setText(mi.Nombre);
                            mi.jpPerfil.jtxtApellido.setText(mi.Apellido);
                            mi.jpPerfil.jtxtCorreo.setText(mi.Correo);
                            mi.jpPerfil.jtxtClave.setText(mi.Clave);
                            mi.jpPerfil.jtxtTelefono.setText(mi.Telefono);
                            mi.jpPerfil.jtxtCelular.setText(mi.Celular);

                            if (usuarioE.getImage() == null) {
                                mi.jlbimage.setIcon(new ImageIcon(getClass().getResource("/Imagenes/defecto.png")));
                                mi.jpPerfil.jlbimage.setIcon(mi.jlbimage.getIcon());
                            } else {
                                mi.image.setImage(usuarioE.getImage());
                                mi.jlbimage.setIcon(new ImageIcon(mi.image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
                                mi.jpPerfil.jlbimage.setIcon(mi.jlbimage.getIcon());
                            }
                            this.setVisible(false);
                            this.dispose();
                        }
                    } else {
                        if (validoClave == "Inactivo") {
                            Toolkit.getDefaultToolkit().beep();
                            jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                            jlbValidarP.setVisible(false);
                            jlbValidarCC.setVisible(false);
                            jlbValidarC.setVisible(false);
                            jlbValidarH.setVisible(true);
                        }
                        if (validoClave == "none") {
                            Toolkit.getDefaultToolkit().beep();
                            jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                            jlbValidarCC.setVisible(true);
                            jlbValidarC.setVisible(false);
                            jlbValidarH.setVisible(false);
                            jlbValidarP.setVisible(false);
                        }
                    }
                }
            }
        }
    }

    public boolean validarCampos() {

        boolean resp = true;

        Correo = jtxtCorreo.getText();
        Clave = jtxtClave.getText();

        if (Correo.trim().length() == 0 && Clave.trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jlbValidarC.setVisible(true);
            jlbValidarP.setVisible(true);
            jlbValidarC.setText("Ingrese el correo");
            jlbValidarP.setText("Ingrese la contraseña");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        if (Correo.trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            jlbValidarC.setVisible(true);
            jlbValidarP.setVisible(false);
            jlbValidarC.setText("Ingrese el correo");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        if (Clave.trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            jlbValidarC.setVisible(false);
            jlbValidarP.setVisible(true);
            jlbValidarP.setText("Ingrese la contraseña");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        if (jtxtCorreo.getText().length() <= 10) {
            Toolkit.getDefaultToolkit().beep();
            jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            jlbValidarC.setVisible(true);
            jlbValidarP.setVisible(false);
            jlbValidarC.setText("El correo debe ser mayor que 10");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        if (jtxtClave.getText().length() <= 6) {
            Toolkit.getDefaultToolkit().beep();
            jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            jtxtClave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            jlbValidarC.setVisible(false);
            jlbValidarP.setVisible(true);
            jlbValidarP.setText("La contraseña debe ser mayor que 6");
            jlbValidarCC.setVisible(false);
            jlbValidarH.setVisible(false);
            resp = false;
            return resp;
        }

        return resp;

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == movedor) {
            x = arg0.getX();
            y = arg0.getY();
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == jbtnIngresar) {
            jbtnIngresar.setBackground(new Color(0, 154, 225));
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(Color.DARK_GRAY);
        }
        if (arg0.getSource() == jlbRegistrate) {
            jlbRegistrate.setForeground(new Color(0, 154, 225));
            jlbsub.setVisible(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == jbtnIngresar) {
            jbtnIngresar.setBackground(new Color(0, 123, 183));
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(new Color(0, 154, 225));
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(new Color(0, 154, 225));
        }
        if (arg0.getSource() == jlbRegistrate) {
            jlbRegistrate.setForeground(Color.BLACK);
            jlbsub.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jlb_x1) {
            super.setState(JFrame.ICONIFIED);
        }

        if (e.getSource() == jlb_x2) {
            System.exit(0);
        }

        if (e.getSource() == jlbRegistrate) {
            this.setVisible(false);
            this.dispose();
            Registros r = new Registros();
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource() == jtxtCorreo) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if ("null".equals(jtxtCorreo.getText().toLowerCase())) {
                jtxtCorreo.setText("");
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtClave) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if ("null".equals(jtxtClave.getText().toLowerCase())) {
                jtxtClave.setText("");
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

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

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource() == movedor) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(point.x - x, point.y - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

}
