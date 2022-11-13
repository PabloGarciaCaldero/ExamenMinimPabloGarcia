package edu.upc.dsa;

import java.util.HashMap;

public class Usuario {

    String Usuario;

    Boolean UsuarioJugando;

    HashMap<String, Partida>partidasJugadas;


    public Usuario (String Usuario){
        this.setUsuario(Usuario);
        this.setUsuarioJugando(false);
        this.setPartidasJugadas();
    }



    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public Boolean getUsuarioJugando() {
        return UsuarioJugando;
    }

    public void setUsuarioJugando(Boolean usuarioJugando) {
        UsuarioJugando = usuarioJugando;
    }

    public HashMap<String, Partida> getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas() {
        this.partidasJugadas = partidasJugadas;
    }

public void añadirPartida(Partida partida){
    this.partidasJugadas.put(partida.getIdPartida(), partida);
    this.setUsuarioJugando(true);
}






}
