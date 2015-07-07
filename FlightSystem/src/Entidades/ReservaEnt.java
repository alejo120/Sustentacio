package Entidades;

public class ReservaEnt {

    public String Codigo;
    public String Vuelo;
    public String Documento;
    public String Puesto;
    public String Estado;
    public ReservaEnt Liga;

    public ReservaEnt() {
        Codigo = null;
        Vuelo = null;
        Documento = null;
        Puesto = null;
        Estado = null;
        Liga = null;
    }

    public ReservaEnt(String Codigo, String Vuelo, String Documento, String Puesto, String Estado) {
        this();
        this.Codigo = Codigo;
        this.Vuelo = Vuelo;
        this.Documento = Documento;
        this.Puesto = Puesto;
        this.Estado = Estado;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getVuelo() {
        return Vuelo;
    }

    public void setVuelo(String Vuelo) {
        this.Vuelo = Vuelo;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public ReservaEnt getLS() {
        return Liga;
    }

    public void setLS(ReservaEnt LS) {
        this.Liga = Liga;
    }
}
