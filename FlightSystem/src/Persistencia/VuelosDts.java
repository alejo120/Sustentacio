package Persistencia;

import Entidades.VuelosEnt;

public class VuelosDts {

    public static VuelosEnt inicio, fin, nodo, nodo1, nodo2, nodoI;
    public static int cont = 0;

    static {
        inicio = new VuelosEnt(null, null, null, null, null, null);
        nodo = inicio.Liga = new VuelosEnt("123", "123", "1", "01/02/15", "12:32", "Activo");
        nodo1 = nodo.Liga = new VuelosEnt("321", "321", "2", "02/03/16", "1:02", "Activo");
        nodo2 = nodo1.Liga = new VuelosEnt("213", "12345", "3", "02/07/12", "4:34", "Inactivo");
        fin = nodo2.Liga = new VuelosEnt("312", "213", "4", "20/12/10", "6:13", "Activo");
        fin.Liga = null;
    }

    public VuelosEnt buscarVueloCodigo(String codigo) {
        VuelosEnt respuesta = null;
        VuelosEnt aux = inicio.Liga;
        while (aux != fin && !codigo.equals(aux.Codigo)) {
            aux = aux.Liga;
        }
        if (codigo.equals(aux.Codigo)) {
            respuesta = new VuelosEnt();
            respuesta.setCodigo(aux.Codigo);
            respuesta.setViaje(aux.Viaje);
            respuesta.setAvion(aux.Avion);
            respuesta.setDia(aux.Dia);
            respuesta.setHora(aux.Hora);
            respuesta.setEstado(aux.Estado);
            return respuesta;
        }
        return respuesta;
    }

    public boolean guardarVuelo(VuelosEnt nueva) {
        nodoI = new VuelosEnt(nueva.Codigo, nueva.Viaje, nueva.Avion, nueva.Dia, nueva.Hora, nueva.Estado);
        nodoI.Liga = null;
        fin.Liga = nodoI;
        fin = nodoI;
        return true;
    }

    public boolean modificarVuelo(VuelosEnt vuelos) {
        VuelosEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Codigo.equals(vuelos.getCodigo())) {
            aux = aux.Liga;
        }
        aux.Codigo = vuelos.getCodigo();
        aux.Viaje = vuelos.getViaje();
        aux.Avion = vuelos.getAvion();
        aux.Dia = vuelos.getDia();
        aux.Hora = vuelos.getHora();
        aux.Estado = vuelos.getEstado();
        return true;
    }

    public String[][] cargarVuelos() {
        VuelosEnt aux;
        cont = 0;
        aux = inicio.Liga;
        while (aux != fin.Liga) {
            cont++;
            aux = aux.Liga;
        }
        String[][] vueloDatos = new String[cont][6];
        aux = inicio.Liga;
        for (int i = 0; i < cont; i++) {
            vueloDatos[i][0] = aux.Codigo;
            vueloDatos[i][1] = aux.Viaje;
            vueloDatos[i][2] = aux.Avion;
            vueloDatos[i][3] = aux.Dia;
            vueloDatos[i][4] = aux.Hora;
            vueloDatos[i][5] = aux.Estado;
            aux = aux.Liga;
        }
        return vueloDatos;
    }

}
