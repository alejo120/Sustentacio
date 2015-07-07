package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ayuda extends JPanel implements MouseListener {

    JLabel jlbPreguntasFrecuentes;
    JLabel jlbAyuda;
    JLabel jlbAyudaReserva;
    JLabel jlbAyudaTiempoReserva;
    JLabel jlbAyudaContactarnos;
    JLabel jlbAyudaPerfil;

    JButton jbtnAyudaReserva;
    JButton jbtnAyudaTiempoReserva;
    JButton jbtnAyudaContactarnos;
    JButton jbtnAyudaPerfil;

    public Ayuda() {
        super.setBounds(181, 61, 700, 538);  //(ancho,alto)
        super.setLayout(null);
        super.setOpaque(false);
        super.setVisible(false);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        jlbPreguntasFrecuentes = new JLabel("Preguntas Frecuentes");
        jlbPreguntasFrecuentes.setForeground(Color.BLACK);
        jlbPreguntasFrecuentes.setBounds(270, 15, 170, 25);
        jlbPreguntasFrecuentes.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        this.add(jlbPreguntasFrecuentes);

        jlbAyuda = new JLabel();
        jlbAyuda.setBounds(45, 101, 610, 346);
        jlbAyuda.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ayuda/Ayuda.png")));
        this.add(jlbAyuda);

        jlbAyudaReserva = new JLabel();
        jlbAyudaReserva.setBounds(45, 101, 610, 346);
        jlbAyudaReserva.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ayuda/Reservas.png")));
        jlbAyudaReserva.setVisible(false);
        this.add(jlbAyudaReserva);

        jlbAyudaTiempoReserva = new JLabel();
        jlbAyudaTiempoReserva.setBounds(45, 101, 610, 346);
        jlbAyudaTiempoReserva.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ayuda/TiempoReservas.png")));
        jlbAyudaTiempoReserva.setVisible(false);
        this.add(jlbAyudaTiempoReserva);

        jlbAyudaContactarnos = new JLabel();
        jlbAyudaContactarnos.setBounds(45, 101, 610, 346);
        jlbAyudaContactarnos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ayuda/Contactarnos.png")));
        jlbAyudaContactarnos.setVisible(false);
        this.add(jlbAyudaContactarnos);

        jlbAyudaPerfil = new JLabel();
        jlbAyudaPerfil.setBounds(45, 101, 610, 346);
        jlbAyudaPerfil.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ayuda/Perfil.png")));
        jlbAyudaPerfil.setVisible(false);
        this.add(jlbAyudaPerfil);

        jbtnAyudaReserva = new JButton("¿Comó realizar una reserva?");
        jbtnAyudaReserva.setBounds(95, 50, 250, 40);
        jbtnAyudaReserva.addMouseListener(this);
        jbtnAyudaReserva.setBorder(null);
        jbtnAyudaReserva.setBackground(new Color(0, 154, 225));
        jbtnAyudaReserva.setForeground(Color.WHITE);
        jbtnAyudaReserva.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        jbtnAyudaReserva.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAyudaReserva.setFocusPainted(false);
        this.add(jbtnAyudaReserva);

        jbtnAyudaTiempoReserva = new JButton("¿Cuánto tiempo dura una reserva?");
        jbtnAyudaTiempoReserva.setBounds(355, 50, 250, 40);
        jbtnAyudaTiempoReserva.addMouseListener(this);
        jbtnAyudaTiempoReserva.setBorder(null);
        jbtnAyudaTiempoReserva.setBackground(new Color(0, 154, 225));
        jbtnAyudaTiempoReserva.setForeground(Color.WHITE);
        jbtnAyudaTiempoReserva.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        jbtnAyudaTiempoReserva.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAyudaTiempoReserva.setFocusPainted(false);
        this.add(jbtnAyudaTiempoReserva);

        jbtnAyudaContactarnos = new JButton("¿Comó Contáctarnos?");
        jbtnAyudaContactarnos.setBounds(95, 458, 250, 40);
        jbtnAyudaContactarnos.addMouseListener(this);
        jbtnAyudaContactarnos.setBorder(null);
        jbtnAyudaContactarnos.setBackground(new Color(0, 154, 225));
        jbtnAyudaContactarnos.setForeground(Color.WHITE);
        jbtnAyudaContactarnos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        jbtnAyudaContactarnos.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAyudaContactarnos.setFocusPainted(false);
        this.add(jbtnAyudaContactarnos);

        jbtnAyudaPerfil = new JButton("¿Para qué sirve mi perfil?");
        jbtnAyudaPerfil.setBounds(355, 458, 250, 40);
        jbtnAyudaPerfil.addMouseListener(this);
        jbtnAyudaPerfil.setBorder(null);
        jbtnAyudaPerfil.setBackground(new Color(0, 154, 225));
        jbtnAyudaPerfil.setForeground(Color.WHITE);
        jbtnAyudaPerfil.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        jbtnAyudaPerfil.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAyudaPerfil.setFocusPainted(false);
        this.add(jbtnAyudaPerfil);

        this.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == jbtnAyudaReserva) {
            jbtnAyudaReserva.setBackground(new Color(0, 154, 225));
        }
        if (arg0.getSource() == jbtnAyudaTiempoReserva) {
            jbtnAyudaTiempoReserva.setBackground(new Color(0, 154, 225));
        }
        if (arg0.getSource() == jbtnAyudaContactarnos) {
            jbtnAyudaContactarnos.setBackground(new Color(0, 154, 225));
        }
        if (arg0.getSource() == jbtnAyudaPerfil) {
            jbtnAyudaPerfil.setBackground(new Color(0, 154, 225));
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == jbtnAyudaReserva) {
            jbtnAyudaReserva.setBackground(new Color(0, 123, 183));
        }
        if (arg0.getSource() == jbtnAyudaTiempoReserva) {
            jbtnAyudaTiempoReserva.setBackground(new Color(0, 123, 183));
        }
        if (arg0.getSource() == jbtnAyudaContactarnos) {
            jbtnAyudaContactarnos.setBackground(new Color(0, 123, 183));
        }
        if (arg0.getSource() == jbtnAyudaPerfil) {
            jbtnAyudaPerfil.setBackground(new Color(0, 123, 183));
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jbtnAyudaReserva) {
            jlbAyudaReserva.setVisible(true);
            jlbAyudaTiempoReserva.setVisible(false);
            jlbAyudaContactarnos.setVisible(false);
            jlbAyudaPerfil.setVisible(false);
            jlbAyuda.setVisible(false);
        }

        if (e.getSource() == jbtnAyudaTiempoReserva) {
            jlbAyudaReserva.setVisible(false);
            jlbAyudaTiempoReserva.setVisible(true);
            jlbAyudaContactarnos.setVisible(false);
            jlbAyudaPerfil.setVisible(false);
            jlbAyuda.setVisible(false);
        }

        if (e.getSource() == jbtnAyudaContactarnos) {
            jlbAyudaReserva.setVisible(false);
            jlbAyudaTiempoReserva.setVisible(false);
            jlbAyudaContactarnos.setVisible(true);
            jlbAyudaPerfil.setVisible(false);
            jlbAyuda.setVisible(false);
        }

        if (e.getSource() == jbtnAyudaPerfil) {
            jlbAyudaReserva.setVisible(false);
            jlbAyudaTiempoReserva.setVisible(false);
            jlbAyudaContactarnos.setVisible(false);
            jlbAyudaPerfil.setVisible(true);
            jlbAyuda.setVisible(false);
        }

    }
}
