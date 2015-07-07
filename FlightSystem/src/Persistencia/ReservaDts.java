package Persistencia;

import Entidades.ReservaEnt;

public class ReservaDts {

    public static ReservaEnt inicio, fin, nodo, nodo1, nodo2, nodoI;
    public static int cont = 0;

    static {
        inicio = new ReservaEnt(null, null, null, null, null);
        nodo = inicio.Liga = new ReservaEnt("321", "123", "98038459232", "1", "Activo");
        nodo1 = nodo.Liga = new ReservaEnt("123", "321", "97285343443", "2", "Activo");
        nodo2 = nodo1.Liga = new ReservaEnt("212", "213", "10768786", "3", "Inactivo");
        fin = nodo2.Liga = new ReservaEnt("213", "312", "95312320877", "4", "Activo");
        fin.Liga = null;
    }

    public ReservaEnt buscarReservaCodigo(String cr) {
        ReservaEnt respuesta = null;
        ReservaEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Codigo)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Codigo)) {
            respuesta = new ReservaEnt();
            respuesta.setCodigo(aux.Codigo);
            respuesta.setVuelo(aux.Vuelo);
            respuesta.setDocumento(aux.Documento);
            respuesta.setPuesto(aux.Puesto);
            respuesta.setEstado(aux.Estado);
            return respuesta;
        }
        return respuesta;
    }

    public boolean guardarReserva(ReservaEnt nueva) {
        nodoI = new ReservaEnt(nueva.Codigo, nueva.Vuelo, nueva.Documento, nueva.Puesto, nueva.Estado);
        nodoI.Liga = null;
        fin.Liga = nodoI;
        fin = nodoI;
        return true;
    }

    public boolean modificarReserva(ReservaEnt reserva) {
        ReservaEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Codigo.equals(reserva.getCodigo())) {
            aux = aux.Liga;
        }
        aux.Codigo = reserva.getCodigo();
        aux.Vuelo = reserva.getVuelo();
        aux.Documento = reserva.getDocumento();
        aux.Puesto = reserva.getPuesto();
        aux.Estado = reserva.getEstado();
        return true;
    }

    public boolean eliminarReserva(String codigo) {
        ReservaEnt aux, con;
        aux = inicio.Liga;
        con = inicio;
        while (aux != fin && !codigo.equals(aux.Codigo)) {
            con = aux;
            aux = aux.Liga;
        }
        aux.Codigo = null;
        aux.Vuelo = null;
        aux.Documento = null;
        aux.Puesto = null;
        aux.Estado = null;
        if (aux.Liga == null && inicio.Liga == aux) {
            inicio.Liga = null;
        } else {
            con.Liga = aux.Liga;
            if (aux.Liga == null) {
                fin = con;
            }
        }

        return true;
    }

    public String[][] cargarReservas() {
        ReservaEnt aux;
        cont = 0;
        aux = inicio.Liga;
        while (aux != fin.Liga) {
            cont++;
            aux = aux.Liga;
        }
        String[][] reservaDatos = new String[cont][5];
        aux = inicio.Liga;
        for (int i = 0; i < cont; i++) {
            reservaDatos[i][0] = aux.Codigo;
            reservaDatos[i][1] = aux.Vuelo;
            reservaDatos[i][2] = aux.Documento;
            reservaDatos[i][3] = aux.Puesto;
            reservaDatos[i][4] = aux.Estado;
            aux = aux.Liga;
        }
        return reservaDatos;
    }

    public String[][] cargarReservasDocumento(String Documento) {
        ReservaEnt aux;
        cont = 1;
        int cont2 = 1;
        aux = inicio.Liga;
        while (aux != fin) {
            if (Documento.equals(aux.Documento)) {
                cont++;
            }
            cont2++;
            aux = aux.Liga;
        }
        String[][] reservaDatos = new String[cont][5];
        aux = inicio.Liga;
        int cont3 = 0;
        for (int i = 0; i < cont2; i++) {
            if (Documento.equals(aux.Documento)) {
                reservaDatos[cont3][0] = aux.Codigo;
                reservaDatos[cont3][1] = aux.Vuelo;
                reservaDatos[cont3][2] = aux.Documento;
                reservaDatos[cont3][3] = aux.Puesto;
                reservaDatos[cont3][4] = aux.Estado;
                cont3++;
            }
            aux = aux.Liga;
        }

        return reservaDatos;
    }
}
