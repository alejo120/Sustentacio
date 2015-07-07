package Negocio;

import Entidades.ReservaEnt;
import Persistencia.ReservaDts;
import javax.swing.table.DefaultTableModel;

public class ReservaNg {

    ReservaDts ReservaD = new ReservaDts();
    ReservaEnt ReservaE = null;

    public boolean guardarReserva(ReservaEnt m) {
        boolean resp = false;
        ReservaE = ReservaD.buscarReservaCodigo(m.getCodigo());
        if (ReservaE == null) {
            resp = ReservaD.guardarReserva(m);
        }
        return resp;
    }

    public ReservaEnt buscarReservaCodigo(String codigo) {
        return ReservaD.buscarReservaCodigo(codigo);
    }

    public boolean modificarReserva(ReservaEnt codigo) {
        return ReservaD.modificarReserva(codigo);
    }

    public boolean eliminarReserva(String codigo) {
        return ReservaD.eliminarReserva(codigo);
    }

    public DefaultTableModel cargarReservas(DefaultTableModel model) {
        String[][] result;

        result = ReservaD.cargarReservas();
        for (int i = 0; i < ReservaDts.cont; i++) {
            Object nuevo[] = {result[i][0], result[i][1], result[i][2], result[i][3], result[i][4]};
            model.addRow(nuevo);
        }
        return model;
    }
    
    public DefaultTableModel cargarReservasDocumento(DefaultTableModel model, String doc_ident) {
        String[][] result;
        
        result = ReservaD.cargarReservasDocumento(doc_ident);
        for (int i = 0; i < ReservaDts.cont; i++) {
            Object nuevo[] = {result[i][0], result[i][1], result[i][2], result[i][3], result[i][4]};
            model.addRow(nuevo);
        }
        return model;
    }
}
