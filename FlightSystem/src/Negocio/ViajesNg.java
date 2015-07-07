package Negocio;

import Entidades.ViajesEnt;
import Persistencia.ViajesDts;
import javax.swing.table.DefaultTableModel;

public class ViajesNg {

    ViajesDts ViajesD = new ViajesDts();
    ViajesEnt ViajesE = null;

    public ViajesEnt buscarViajeCodigo(String codigo) {
        return ViajesD.buscarViajeCodigo(codigo);
    }

    public boolean modificarViaje(ViajesEnt codigo) {
        return ViajesD.modificarViaje(codigo);
    }

    public DefaultTableModel cargarViajes(DefaultTableModel model) {
        String[][] result;

        result = ViajesD.cargarViajes();
        for (int i = 0; i < ViajesDts.cont; i++) {
            Object nuevo[] = {result[i][0], result[i][1], result[i][2], result[i][3], result[i][4]};
            model.addRow(nuevo);
        }
        return model;
    }

}
