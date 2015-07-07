package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bienvenido extends JFrame implements MouseListener, MouseMotionListener {

    JLabel jlb_x1, jlb_x2;
    JLabel jlbIniciando;
    JLabel jlbAirlineTravel;
    JProgressBar JpbProgreso;
    JPanel jpmovedor;
    int x, y;

    public Bienvenido() {
        super.setTitle("Cargando");
        super.setSize(650, 450);  //(ancho,alto)
        super.setLayout(null);
        super.getContentPane().setBackground(Color.BLACK);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setUndecorated(true);
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        this.setVisible(true);

        jlb_x1 = new JLabel("-");
        jlb_x1.setBounds(577, 20, 25, 25);
        jlb_x1.setForeground(Color.DARK_GRAY);
        jlb_x1.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        jlb_x1.addMouseListener(this);
        jlb_x1.setToolTipText("Minimizar");
        jlb_x1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x1);

        jlb_x2 = new JLabel("x");
        jlb_x2.setBounds(607, 10, 20, 30);
        jlb_x2.setForeground(Color.DARK_GRAY);
        jlb_x2.setFont(new Font("Segoe UI", Font.PLAIN, 35));
        jlb_x2.addMouseListener(this);
        jlb_x2.setToolTipText("Cerrar");
        jlb_x2.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x2);

        jlbAirlineTravel = new JLabel("Airline Travel");
        jlbAirlineTravel.setBounds(119, 17, 150, 20);
        jlbAirlineTravel.setForeground(Color.BLACK);
        jlbAirlineTravel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbAirlineTravel);

        jpmovedor = new JPanel();
        jpmovedor.setOpaque(false);
        jpmovedor.setLayout(null);
        jpmovedor.add(jlb_x1);
        jpmovedor.add(jlb_x2);
        jpmovedor.add(jlbAirlineTravel);
        jpmovedor.setBounds(1, 1, 648, 54);
        jpmovedor.addMouseListener(this);
        jpmovedor.addMouseMotionListener(this);
        this.add(jpmovedor);

        jlbIniciando = new JLabel("Iniciando");
        jlbIniciando.setBounds(75, 170, 302, 20);
        jlbIniciando.setForeground(Color.BLACK);
        jlbIniciando.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbIniciando);

        JpbProgreso = new JProgressBar();
        JpbProgreso.setBorder(null);//Eliminarle el borde al boton
        JpbProgreso.setOpaque(false);
        JpbProgreso.setForeground(new Color(0, 154, 225));
        JpbProgreso.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        JpbProgreso.setBounds(75, 240, 500, 9);
        this.add(JpbProgreso);

        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/Bienvenido.PNG")));
        fondo.setBounds(0, 0, 650, 450);
        this.add(fondo);

        this.repaint();

        run();
    }

    public static void main(String[] args) {
        Bienvenido b = new Bienvenido();
    }

    int k = 0;

    public void run() {
        for (k = 0; k < 101; k++) {
            JpbProgreso.setValue(k);
            delaySegundo();

            if (k > 70) {
                delaySegundo();
            }

            if (k == 100) {
                Login l = new Login();
                this.setVisible(false);
                this.dispose();

            }
        }
    }

    public void delaySegundo() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == jpmovedor) {
            x = arg0.getX();
            y = arg0.getY();
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(Color.DARK_GRAY);
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(new Color(0, 154, 225));
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(new Color(0, 154, 225));
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
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource() == jpmovedor) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(point.x - x, point.y - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

}
