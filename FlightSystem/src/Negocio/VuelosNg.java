package Negocio;

import Entidades.VuelosEnt;
import Persistencia.VuelosDts;
import javax.swing.table.DefaultTableModel;

public class VuelosNg {

    VuelosDts VuelosD = new VuelosDts();
    VuelosEnt VuelosE = null;

    public boolean guardarVuelo(VuelosEnt m) {
        boolean resp = false;
        VuelosE = VuelosD.buscarVueloCodigo(m.getCodigo());
        if (VuelosE == null) {
            resp = VuelosD.guardarVuelo(m);
        }
        return resp;
    }

    public VuelosEnt buscarVueloCodigo(String codigo) {
        return VuelosD.buscarVueloCodigo(codigo);
    }

    public boolean modificarVuelo(VuelosEnt codigo) {
        return VuelosD.modificarVuelo(codigo);
    }

    public DefaultTableModel cargarVuelos(DefaultTableModel model) {
        String[][] result;

        result = VuelosD.cargarVuelos();
        for (int i = 0; i < VuelosDts.cont; i++) {
            Object nuevo[] = {result[i][0], result[i][1], result[i][2], result[i][3], result[i][4], result[i][5]};
            model.addRow(nuevo);
        }
        return model;
    }

}
