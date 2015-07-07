package Persistencia;

import Entidades.AvionEnt;

public class AvionDts {

    public static AvionEnt inicio, fin, nodo, nodo1, nodo2, nodoI;
    public static int cont = 0;

    static {
        inicio = new AvionEnt(null, null, null);
        nodo = inicio.Liga = new AvionEnt("123", "1", "Activo");
        nodo1 = nodo.Liga = new AvionEnt("321", "2", "Inactivo");
        nodo2 = nodo1.Liga = new AvionEnt("213", "3", "Inactivo");
        fin = nodo2.Liga = new AvionEnt("312", "4", "Activo");
        fin.Liga = null;
    }

    public AvionEnt buscarAvionCodigo(String cr) {
        AvionEnt respuesta = null;
        AvionEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Codigo)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Codigo)) {
            respuesta = new AvionEnt();
            respuesta.setCodigo(aux.Codigo);
            respuesta.setCapacidad(aux.Capacidad);
            respuesta.setEstado(aux.Estado);
            return respuesta;
        }
        return respuesta;
    }

    public boolean modificarAvion(AvionEnt aviones) {
        AvionEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Codigo.equals(aviones.getCodigo())) {
            aux = aux.Liga;
        }
        aux.Codigo = aviones.getCodigo();
        aux.Capacidad = aviones.getCapacidad();
        aux.Estado = aviones.getEstado();
        return true;
    }

    public String[][] cargarAviones() {
        AvionEnt aux;
        cont = 0;
        aux = inicio.Liga;
        while (aux != fin.Liga) {
            cont++;
            aux = aux.Liga;
        }
        String[][] avionDatos = new String[cont][3];
        aux = inicio.Liga;
        for (int i = 0; i < cont; i++) {
            avionDatos[i][0] = aux.Codigo;
            avionDatos[i][1] = aux.Capacidad;
            avionDatos[i][2] = aux.Estado;
            aux = aux.Liga;
        }
        return avionDatos;
    }

}
