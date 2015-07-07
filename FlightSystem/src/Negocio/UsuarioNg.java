package Negocio;

import Entidades.UsuarioEnt;
import Persistencia.UsuarioDts;
import javax.swing.table.DefaultTableModel;

public class UsuarioNg {

    UsuarioDts UsuarioD = new UsuarioDts();
    UsuarioEnt UsuarioE = null;

    public String verificarUsuario(String Correo, String Contraseña) {
        UsuarioEnt UsuarioE = UsuarioD.buscarUsuarioCorreo(Correo);

        if (UsuarioE != null) {
            //si encuentra el usuario

            if (Contraseña.equals(UsuarioE.getClave())) {
                if (UsuarioE.getEstado() == "Inactivo") {
                    return "Inactivo";
                }
                if (UsuarioE.getPerfil() == "Administrador") {
                    return "Administrador";
                } else if (UsuarioE.getPerfil() == "Secretaria") {
                    return "Secretaria";
                } else {
                    return "Cliente";
                }
            } else {
                //Lo encuentra pero la clave esta errada
                return "none";
            }
        } else {
            //no encuentre usuario
            return "none";
        }

    }

    public boolean guardarUsuario(UsuarioEnt m) {
        boolean resp = false;
        UsuarioE = UsuarioD.buscarUsuarioDocumento(m.getDocumento());
        if (UsuarioE == null) {
            resp = UsuarioD.guardarUsuario(m);
        }
        return resp;
    }

    public UsuarioEnt buscarUsuarioDocumento(String documento) {
        return UsuarioD.buscarUsuarioDocumento(documento);
    }

    public UsuarioEnt buscarUsuarioCorreo(String correo) {
        return UsuarioD.buscarUsuarioCorreo(correo);
    }

    public boolean modificarUsuario(UsuarioEnt documento) {
        return UsuarioD.modificarUsuario(documento);
    }

    public boolean modificarPerfil(UsuarioEnt documento) {
        return UsuarioD.modificarPerfil(documento);
    }

    public boolean eliminarUsuario(String documento) {
        return UsuarioD.eliminarUsuario(documento);
    }

    public DefaultTableModel cargarUsuario(DefaultTableModel model) {
        String[][] result;

        result = UsuarioD.cargarUsuario();
        for (int i = 0; i < UsuarioDts.cont; i++) {
            Object nuevo[] = {result[i][0], result[i][1], result[i][2], result[i][3], result[i][4], result[i][5], result[i][6], result[i][7]};
            model.addRow(nuevo);
        }
        return model;
    }

}
