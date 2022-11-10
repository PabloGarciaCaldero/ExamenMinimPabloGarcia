package edu.upc.dsa;
import edu.upc.dsa.Usuario;


import java.util.List;

public interface JuegoManager {


    public int size();

    public List<Usuario> getUsers();

    public Usuario Usuario(String UsuarioId);
    public Juego Juego (String juegoId, String Descripcion, int numNiveles);

    public void CreacionJuego (String juegoId, String NombreJuego, String UsuarioId, String Descripcion, int numNiveles);

    public void InicioPartida (String Nombre, String juegoId, String UsuarioId, int puntos, boolean encurso) throws UsuarioNoExisteException, JuegoNoExisteException, PartidaYaCreadaException;

    public int numNivel () throws UsuarioNoExisteException, PartidaHayPartidaEnCursoException, NoHayPartidaEnCursoException;

    void CreacionJuego(String s, String proba1, String usu1, String primer_juego);

    void InicioPartida(String partida1, String proba1, String usu1, int i);
}
