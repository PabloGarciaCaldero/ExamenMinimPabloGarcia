package edu.upc.dsa;

public class Partida {

    private String juegoId;
    private String usuarioId;
    int puntos = 50;

    private boolean encurso = true;

    public Partida (String juegoId, String usuarioId, int puntos, boolean encurso){
        this.juegoId = juegoId;
        this.usuarioId = usuarioId;
        this.puntos = puntos;
        this.encurso = encurso;
    }

    public boolean isEncurso() {
        return encurso;
    }

    public void setEncurso(boolean encurso) {
        this.encurso = encurso;
    }

    public String getJuegoId() {
        return juegoId;
    }

    public void setJuegoId(String juegoId) {
        this.juegoId = juegoId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }



}
