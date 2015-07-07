package Entidades;

import java.awt.image.BufferedImage;

public class UsuarioEnt {

    public String Documento;
    public String Correo;
    public String Clave;
    public String Nombre;
    public String Apellido;
    public String Telefono;
    public String Celular;
    public String Perfil;
    public String Estado;
    public BufferedImage image;
    public UsuarioEnt Liga;

    public UsuarioEnt() {
        Documento = null;
        Correo = null;
        Clave = null;
        Nombre = null;
        Apellido = null;
        Telefono = null;
        Celular = null;
        Perfil = null;
        Estado = null;
        Liga = null;
    }

    public UsuarioEnt(String Documento, String Correo, String Clave, String Nombre, String Apellido,
            String Telefono, String Celular, String Perfil, String Estado, BufferedImage image) {
        this();
        this.Documento = Documento;
        this.Correo = Correo;
        this.Clave = Clave;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Perfil = Perfil;
        this.Estado = Estado;
        this.image = image;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public UsuarioEnt getLS() {
        return Liga;
    }

    public void setLS(UsuarioEnt LS) {
        this.Liga = Liga;
    }

}
