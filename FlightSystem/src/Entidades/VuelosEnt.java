package Entidades;

public class VuelosEnt {

    public String Codigo;
    public String Viaje;
    public String Avion;
    public String Dia;
    public String Hora;
    public String Estado;
    public VuelosEnt Liga;

    public VuelosEnt() {
        Codigo = null;
        Viaje = null;
        Avion = null;
        Dia = null;
        Hora = null;
        Estado = null;
        Liga = null;
    }

    public VuelosEnt(String Codigo, String Viaje, String Avion, String Dia, String Hora, String Estado) {
        this();
        this.Codigo = Codigo;
        this.Viaje = Viaje;
        this.Avion = Avion;
        this.Dia = Dia;
        this.Hora = Hora;
        this.Estado = Estado;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getViaje() {
        return Viaje;
    }

    public void setViaje(String Viaje) {
        this.Viaje = Viaje;
    }

    public String getAvion() {
        return Avion;
    }

    public void setAvion(String Avion) {
        this.Avion = Avion;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public VuelosEnt getLS() {
        return Liga;
    }

    public void setLS(VuelosEnt LS) {
        this.Liga = Liga;
    }
}
