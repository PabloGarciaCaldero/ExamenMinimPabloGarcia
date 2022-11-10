package edu.upc.dsa;

public class Juego {

    private String juegoId;
    private String Descripcion;
    private String NombreJuego;
    private int numNivel;

    public Juego (String juegoId, String Descripcion, int NombreJuego){
        this.juegoId=juegoId;
        this.Descripcion=Descripcion;
        this.NombreJuego=NombreJuego;
        this.numNivel=numNivel;
    }

    public String getJuegoId() {
        return juegoId;
    }

    public void setJuegoId(String juegoId) {
        this.juegoId = juegoId;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getNombreJuego() {
        return NombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        NombreJuego = nombreJuego;
    }

    public int getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(int numNivel) {
        this.numNivel = numNivel;
    }
}
