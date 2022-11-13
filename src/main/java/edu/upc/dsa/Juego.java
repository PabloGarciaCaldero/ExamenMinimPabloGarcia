package edu.upc.dsa;

public class Juego {

    String NombreJuego;
    String Descripcion;
    Integer numNvls;


    public Juego (String NombreJuego, String Descripcion, Integer numNvls){
        this.NombreJuego=NombreJuego;
        this.Descripcion=Descripcion;
        this.NombreJuego=NombreJuego;
        this.numNvls=numNvls;
    }

    public String getNombreJuego() {
        return NombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        NombreJuego = nombreJuego;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Integer getNumNvls() {
        return numNvls;
    }

    public void setNumNvls(Integer numNvls) {
        this.numNvls = numNvls;
    }


}
