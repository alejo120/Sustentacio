package Negocio;

import Entidades.AvionEnt;
import Persistencia.AvionDts;
import javax.swing.table.DefaultTableModel;

public class AvionNg {

    AvionDts AvionD = new AvionDts();
    AvionEnt AvionE = null;

    public AvionEnt buscarAvionCodigo(String codigo) {
        return AvionD.buscarAvionCodigo(codigo);
    }

    public boolean modificarAvion(AvionEnt codigo) {
        return AvionD.modificarAvion(codigo);
    }

    public DefaultTableModel cargarAviones(DefaultTableModel model) {
        String[][] result;

        result = AvionD.cargarAviones();
        for (int i = 0; i < AvionDts.cont; i++) {
            Object nuevo[] = {result[i][0], result[i][1], result[i][2]};
            model.addRow(nuevo);
        }
        return model;
    }
}
