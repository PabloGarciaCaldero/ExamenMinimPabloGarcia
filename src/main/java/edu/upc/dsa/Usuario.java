package edu.upc.dsa;

public class Usuario {

    private String Nombre;
    private String UsuarioId;

    private String puntuacion;


    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Usuario (String Nombre, String UsuarioId, int puntos){
            this.Nombre = Nombre;
            this.UsuarioId = IdsRandom.getId();
            this.puntuacion= puntuacion;
        }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        UsuarioId = usuarioId;
    }
}
