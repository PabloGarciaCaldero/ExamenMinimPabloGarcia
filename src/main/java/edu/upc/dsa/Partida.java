package edu.upc.dsa;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    String idPartida;
    String NombreUsuario;
    String NombreJuego;
    Integer puntos;
    Integer nvlActual;
    List<Rendimiento> ListaRendimiento;


    public Partida(String NombreUsuario, String NombreJuego) {
        this.idPartida = IdsRandom.getId();
        this.setNombreUsuario(NombreUsuario);
        this.setNombreJuego(NombreJuego);
        this.setPuntos(50);
        this.setNvlActual(1);
        this.setListaRendimiento(new ArrayList<Rendimiento>());
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getNombreJuego() {
        return NombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        NombreJuego = nombreJuego;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    public void añadirPuntos (Integer puntos){
        this.puntos = this.puntos + puntos;
    }

    public Integer getNvlActual() {
        return nvlActual;
    }

    public void setNvlActual(Integer nvlActual) {
        this.nvlActual = nvlActual;
    }

    public void sumnvlActual(Integer numnvl) {this.nvlActual=this.nvlActual+numnvl; }
    public List<Rendimiento> getListaRendimiento() {
        return ListaRendimiento;
    }

    public void setListaRendimiento(List<Rendimiento> listaRendimiento) {
        ListaRendimiento = listaRendimiento;
    }

    public void AñadirRendimiento(Rendimiento rendimiento) {
        this.ListaRendimiento.add(rendimiento);
    }
}
