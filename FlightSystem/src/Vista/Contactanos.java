package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.*;
import javax.mail.Authenticator;
import javax.mail.*;
import javax.mail.internet.*;

public class Contactanos extends JPanel implements ActionListener, KeyListener, MouseListener {

    JLabel jlbCorreo;
    JLabel jlbAsunto;
    JLabel jlbMensaje;

    JTextField jtxtCorreo;
    JTextField jtxtAsunto;
    JTextArea jtxtMensaje;

    JButton jbtnEnviar;
    JButton jbtnLimpiar;

    String Asunto = "";
    String Mensaje = "";

    JPanel jpBotones;
    JScrollPane spMensaje;//Barra desplazamiento abajo

    public Contactanos() {
        super.setBounds(181, 61, 700, 538);  //(ancho,alto)
        super.setLayout(null);
        super.setOpaque(false);
        super.setVisible(false);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        jlbCorreo = new JLabel("Correo");
        jlbCorreo.setBounds(90, 65, 220, 25);
        jlbCorreo.setForeground(Color.BLACK);
        jlbCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCorreo);

        jtxtCorreo = new JTextField();
        jtxtCorreo.setBounds(90, 90, 520, 30);
        jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCorreo.addKeyListener(this);
        jtxtCorreo.setFocusable(false);
        this.add(jtxtCorreo);

        jlbAsunto = new JLabel("Asunto");
        jlbAsunto.setBounds(90, 145, 120, 25);
        jlbAsunto.setForeground(Color.BLACK);
        jlbAsunto.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbAsunto);

        jtxtAsunto = new JTextField();
        jtxtAsunto.setBounds(90, 170, 520, 30);
        jtxtAsunto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtAsunto.addKeyListener(this);
        this.add(jtxtAsunto);

        jlbMensaje = new JLabel("Mensaje");
        jlbMensaje.setBounds(90, 225, 150, 25);
        jlbMensaje.setForeground(Color.BLACK);
        jlbMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbMensaje);

        jtxtMensaje = new JTextArea();
        jtxtMensaje.setLineWrap(true); //Se logra que haya salto de línea en el TextArea
        jtxtMensaje.setWrapStyleWord(true); //Se impide la división de palabras en el TestArea
        jtxtMensaje.setBorder(null);
        jtxtMensaje.addKeyListener(this);
        spMensaje = new JScrollPane(jtxtMensaje);
        spMensaje.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        spMensaje.setBounds(90, 250, 520, 150);
        this.add(spMensaje);

        jbtnEnviar = new JButton("Enviar");
        jbtnEnviar.setBounds(0, 0, 350, 60);
        jbtnEnviar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/List-26.png")));
        jbtnEnviar.setBorder(null);
        jbtnEnviar.setBackground(new Color(0, 154, 225));
        jbtnEnviar.setForeground(Color.WHITE);
        jbtnEnviar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnEnviar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEnviar.addMouseListener(this);
        jbtnEnviar.addActionListener(this);
        jbtnEnviar.setFocusPainted(false);
        this.add(jbtnEnviar);

        jbtnLimpiar = new JButton(" Limpiar");
        jbtnLimpiar.setBounds(350, 0, 350, 60);
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
        jpBotones.add(jbtnEnviar);
        jpBotones.add(jbtnLimpiar);
        jpBotones.setLayout(null);
        jpBotones.setBounds(0, 478, 700, 60);
        this.add(jpBotones);

        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbtnEnviar) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea contactarse con nosotros?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (option == JOptionPane.YES_OPTION) {
                Asunto = jtxtAsunto.getText();
                Mensaje = "Correo: " + jtxtCorreo.getText() + "\nMensaje: " + jtxtMensaje.getText();
                SendMail();
                LimpiarCampos();
                VaciarCampos();
            }

        }
        if (ae.getSource() == jbtnLimpiar) {
            LimpiarCampos();
            VaciarCampos();
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getSource() == jtxtAsunto) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtAsunto.getText().length() >= 30) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtMensaje) {
            char c;
            //capturar el caracter digitado 
            c = ke.getKeyChar();
            if (jtxtMensaje.getText().length() >= 200) {
                ke.consume();//ignora el caracter digitado
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (ke.getSource() == jtxtAsunto) {
            if (jtxtAsunto.getText().length() <= 3) {
                jtxtAsunto.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtAsunto.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

        if (ke.getSource() == jtxtMensaje) {
            if (jtxtMensaje.getText().length() <= 10) {
                spMensaje.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                spMensaje.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getSource() == jtxtAsunto) {
            if (jtxtAsunto.getText().length() < 0) {
                jtxtAsunto.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtAsunto.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

        if (ke.getSource() == jtxtMensaje) {
            if (jtxtMensaje.getText().length() < 0) {
                spMensaje.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                spMensaje.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == jbtnEnviar) {
            jbtnEnviar.setBackground(new Color(0, 123, 183));
        }
        if (e.getSource() == jbtnLimpiar) {
            jbtnLimpiar.setBackground(new Color(0, 123, 183));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == jbtnEnviar) {
            jbtnEnviar.setBackground(new Color(0, 154, 225));
        }
        if (e.getSource() == jbtnLimpiar) {
            jbtnLimpiar.setBackground(new Color(0, 154, 225));
        }
    }

    public void LimpiarCampos() {
        jtxtAsunto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        spMensaje.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    public void VaciarCampos() {
        jtxtAsunto.setText("");
        jtxtMensaje.setText("");
    }

    public void SendMail() {
        Properties props = System.getProperties();
        props.put("mail.smtp.ssl.host", "smtp.live.com");
        props.put("mail.transport.protocol", "SMPT");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.user", "airlinetravel15@hotmail.com");
        props.put("mail.password", "proyecto2015");
        props.put("mail.smtp.auth", "true");
        
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", "465");

        try {
            Authenticator auth = new SMTPAuthenticator();
            //cramos una sesion del servidor de mail
            javax.mail.Session session = Session.getInstance(props, auth);
            javax.mail.Message message = new MimeMessage(session);

            message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress("airlinetravel15@hotmail.com"));
            InternetAddress dir = new InternetAddress("airlinetravel15@hotmail.com");
            message.addFrom(new InternetAddress[]{dir});

            message.setSubject(Asunto);
            message.setContent(Mensaje, "text/plain");

            Transport transport = session.getTransport("smtp");
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            JOptionPane.showMessageDialog(this, "Su mensaje a sido enviado", "Airline Travel", JOptionPane.OK_OPTION);

        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (Exception me) {
            me.printStackTrace();
        }
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("airlinetravel15@hotmail.com", "proyecto2015");
        }
    }

}
