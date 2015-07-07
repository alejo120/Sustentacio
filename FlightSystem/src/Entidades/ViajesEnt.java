package Entidades;

public class ViajesEnt {

    public String Codigo;
    public String Origen;
    public String Destino;
    public String Precio;
    public String Estado;
    public ViajesEnt Liga;

    public ViajesEnt() {
        Codigo = null;
        Origen = null;
        Destino = null;
        Precio = null;
        Estado = null;
        Liga = null;
    }

    public ViajesEnt(String Codigo, String Origen, String Destino, String Precio, String Estado) {
        this();
        this.Codigo = Codigo;
        this.Origen = Origen;
        this.Destino = Destino;
        this.Precio = Precio;
        this.Estado = Estado;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public ViajesEnt getLS() {
        return Liga;
    }

    public void setLS(ViajesEnt LS) {
        this.Liga = Liga;
    }
}
