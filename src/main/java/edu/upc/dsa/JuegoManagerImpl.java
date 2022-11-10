package edu.upc.dsa;

import edu.upc.dsa.Usuario;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JuegoManagerImpl implements JuegoManager{

    private static JuegoManager instance;
    protected Map<String, Usuario> usuario;
    protected List<Partida> partidas;
    protected List<Juego> Juego;

    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);
    


    public JuegoManagerImpl(){
        this.partidas= new ArrayList<>();
        this.usuario = new HashMap<>();
    }

    public static JuegoManager getInstance() {
        if (instance==null) instance = new JuegoManagerImpl();
        return instance;
    }

    public int size() {
        int ret = this.usuario.size();
        logger.info("size " + ret);

        return ret;
    }

    public Usuario usuario(String UsuarioId){
        return this.usuario.get(UsuarioId);
    }
    public Partida partida(Boolean encurso){
        return this.partida(encurso);
    }

    @Override
    public List<Usuario> getUsers() {
    List<Usuario> usuarios = new ArrayList<>(this.usuario.values());
    usuarios.sort((Usuario u1, Usuario u2) ->{
        int value = u1.getPuntuacion().compareToIgnoreCase(u2.getPuntuacion());
        if (value == 0){
            value =u1.getUsuarioId().compareToIgnoreCase(u2.getUsuarioId());
        }
        return value;
    } );

        return usuarios;
    }


    @Override
    public Usuario Usuario(String UsuarioId) {
        return this.Usuario(UsuarioId);
    }

    @Override
    public Juego Juego(String juegoId, String Descripcion, int numNiveles) {
        return this.Juego(juegoId, Descripcion, numNiveles);
    }

    @Override
    public void CreacionJuego(String juegoId, String NombreJuego, String UsuarioId, String Descripcion, int numNiveles) {
        Juego juego = new Juego(juegoId, Descripcion, numNiveles);

    }

    @Override
    public void InicioPartida(String Nombre, String juegoId, String UsuarioId, int puntos, boolean encurso) throws UsuarioNoExisteException, JuegoNoExisteException, PartidaYaCreadaException{
        Partida partida = new Partida(juegoId, UsuarioId, puntos, encurso);
        Usuario usuario1 = new Usuario(Nombre, UsuarioId, puntos);
        if (encurso == false){
            throw new PartidaYaCreadaException();
        }
        else {
            encurso = true;
        }

        if (usuario1 == null){

        }
    }

    @Override
    public int numNivel() throws UsuarioNoExisteException, NoHayPartidaEnCursoException{
        if (usuario == null) {
            throw new UsuarioNoExisteException();
        }
        return this.Juego.getNumNivel();
    }



    public int numPuntos (){
        return this.Usuario();
    }


    public void finalizarpartida(){


    }

}
