package Persistencia;

import Entidades.ViajesEnt;

public class ViajesDts {

    public static ViajesEnt inicio, fin, nodo, nodo1, nodo2, nodoI;
    public static int cont = 0;

    static {
        inicio = new ViajesEnt(null, null, null, null, null);
        nodo = inicio.Liga = new ViajesEnt("12345", "Medellin", "Bogota", "100000", "Activo");
        nodo1 = nodo.Liga = new ViajesEnt("321", "Cali", "Barranquilla", "201000", "Inactivo");
        nodo2 = nodo1.Liga = new ViajesEnt("213", "Cartagena", "Medellin", "300000", "Inactivo");
        fin = nodo2.Liga = new ViajesEnt("312", "Medellin", "Cartagena", "400000", "Activo");
        fin.Liga = null;
    }

    public ViajesEnt buscarViajeCodigo(String cr) {
        ViajesEnt respuesta = null;
        ViajesEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Codigo)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Codigo)) {
            respuesta = new ViajesEnt();
            respuesta.setCodigo(aux.Codigo);
            respuesta.setOrigen(aux.Origen);
            respuesta.setDestino(aux.Destino);
            respuesta.setPrecio(aux.Precio);
            respuesta.setEstado(aux.Estado);
            return respuesta;
        }
        return respuesta;
    }

    public boolean modificarViaje(ViajesEnt viajes) {
        ViajesEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Codigo.equals(viajes.getCodigo())) {
            aux = aux.Liga;
        }
        aux.Codigo = viajes.getCodigo();
        aux.Origen = viajes.getOrigen();
        aux.Destino = viajes.getDestino();
        aux.Precio = viajes.getPrecio();
        aux.Estado = viajes.getEstado();
        return true;
    }

    public String[][] cargarViajes() {
        ViajesEnt aux;
        cont = 0;
        aux = inicio.Liga;
        while (aux != fin.Liga) {
            cont++;
            aux = aux.Liga;
        }
        String[][] viajeDatos = new String[cont][5];
        aux = inicio.Liga;
        for (int i = 0; i < cont; i++) {
            viajeDatos[i][0] = aux.Codigo;
            viajeDatos[i][1] = aux.Origen;
            viajeDatos[i][2] = aux.Destino;
            viajeDatos[i][3] = aux.Precio;
            viajeDatos[i][4] = aux.Estado;
            aux = aux.Liga;
        }
        return viajeDatos;
    }
}
