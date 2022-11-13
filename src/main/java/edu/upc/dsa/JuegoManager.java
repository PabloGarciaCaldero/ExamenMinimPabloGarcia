package edu.upc.dsa;
import edu.upc.dsa.Excepciones.JuegoNoExisteException;
import edu.upc.dsa.Excepciones.UsuarioNoEstaJugandoException;
import edu.upc.dsa.Excepciones.UsuarioNoExisteException;
import edu.upc.dsa.Excepciones.UsuarioYaJugandoException;
import edu.upc.dsa.Usuario;
import io.swagger.models.auth.In;


import java.util.List;

public interface JuegoManager {

    public Juego CrearJuego (String idJuego, String Descripcion, Integer numero);
    public Partida IniciarPartida(String idJuego, String idUsuario) throws JuegoNoExisteException, UsuarioYaJugandoException;
    public String getnvlActual(String idUsuario) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException;
    public String getPuntuacionActual(String idUsuario) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException;
    public Usuario SiguienteNvl(String idUsuario, Integer masPuntos, String data) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException, JuegoNoExisteException;
    public Usuario FinPartida(String idUsuario) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException;
    public List<Usuario> OrdenUsuarios(Juego juego) throws JuegoNoExisteException;
    public List<Partida> getPartidasUsuario(String NombreUsuario) throws UsuarioNoExisteException;
    public List<Rendimiento> getRendimiento(String idJuego, String idUsuario) throws JuegoNoExisteException, UsuarioNoExisteException;
    public Juego getJuego(String NombreJuego) throws JuegoNoExisteException;
    public Usuario getUsuario(String username) throws UsuarioNoExisteException;
    public Partida getPartida (String idJuego, String idUsuario) throws JuegoNoExisteException, UsuarioNoExisteException;
    public List<Partida> getPartidas (String idJuego, String idUsuario) throws JuegoNoExisteException, UsuarioNoExisteException;
    public Partida getPartidaActual (String Usuario) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException;
    public int size();

}
