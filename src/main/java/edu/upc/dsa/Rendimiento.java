package edu.upc.dsa;

public class Rendimiento {

Integer nivel;
Integer puntos;
String data;

    public Rendimiento(Integer nivel, Integer puntos, String data){
        this.nivel = nivel;
        this.puntos = puntos;
        this.data=data;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
