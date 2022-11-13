package edu.upc.dsa;

import edu.upc.dsa.Excepciones.JuegoNoExisteException;
import edu.upc.dsa.Excepciones.UsuarioNoEstaJugandoException;
import edu.upc.dsa.Excepciones.UsuarioNoExisteException;
import edu.upc.dsa.Excepciones.UsuarioYaJugandoException;
import edu.upc.dsa.Usuario;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class JuegoManagerImpl implements JuegoManager{
    private static JuegoManager instance;

    protected Map<String, Usuario> ListaUsuarios;
    protected List<Juego> juegos;
    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);

    public JuegoManagerImpl(){
        this.ListaUsuarios = new HashMap<>();
        this.juegos = new ArrayList<>();
    }

    public static JuegoManager getInstance(){
        if (instance==null) instance= new JuegoManagerImpl();
        return instance;
    }



    @Override
    public int size() {
        return juegos.size();
    }
    @Override
    public Juego CrearJuego(String idJuego, String Descripcion, Integer numero) {
        try {
            Juego juego = getJuego(idJuego);
        }
        catch (JuegoNoExisteException e){
            Juego a = new Juego (idJuego, Descripcion, numero);
            juegos.add(a);
            return a;
        }
        return null;
    }

    @Override
    public Partida IniciarPartida(String idJuego, String idUsuario) throws JuegoNoExisteException, UsuarioYaJugandoException {
        Juego juego = getJuego(idJuego);
        if(juego == null){
            throw new JuegoNoExisteException();
        }
        Usuario usuario = this.ListaUsuarios.get(idUsuario);
        if (usuario==null){
            Usuario juegadornuevo = new Usuario(idUsuario);
            this.ListaUsuarios.put(idUsuario, juegadornuevo);
        }
        else{
            if(usuario.getUsuarioJugando()){
                throw new UsuarioYaJugandoException();
            }
        }
        Partida nuevaPartida = new Partida(idUsuario, idJuego);
        this.ListaUsuarios.get(idUsuario).añadirPartida(nuevaPartida);
        return nuevaPartida;
    }

    @Override
    public String getnvlActual(String idUsuario) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException {
        Partida partida = getPartidaActual(idUsuario);
        if(partida!=null){
            return partida.getNvlActual().toString();
        }


        return null;
    }

    @Override
    public String getPuntuacionActual(String idUsuario) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException {
        Partida partida = getPartidaActual(idUsuario);
        if (partida!=null){
            return partida.getPuntos().toString();
        }

        return null;
    }

    @Override
    public Usuario SiguienteNvl(String idUsuario, Integer masPuntos, String data) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException, JuegoNoExisteException {
        Partida partida = getPartidaActual(idUsuario);
        if(partida!=null){
            if (partida.getNvlActual()==getJuego(partida.getNombreJuego()).getNumNvls()){
                this.ListaUsuarios.get(idUsuario).getPartidasJugadas().get(partida.getIdPartida()).añadirPuntos(100);
                FinPartida(idUsuario);
                return this.ListaUsuarios.get(idUsuario);
            }
            Rendimiento rendimiento = new Rendimiento(partida.getNvlActual(), partida.getPuntos(), data);
            this.ListaUsuarios.get(idUsuario).getPartidasJugadas().get(partida.getIdPartida()).AñadirRendimiento(rendimiento);
            this.ListaUsuarios.get(idUsuario).getPartidasJugadas().get(partida.getIdPartida()).añadirPuntos(masPuntos);
            this.ListaUsuarios.get(idUsuario).getPartidasJugadas().get(partida.getIdPartida()).sumnvlActual(1);
        }

        return null;
    }

    @Override
    public Usuario FinPartida(String idUsuario) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException {
       Partida partida = getPartidaActual(idUsuario);
       if (partida!=null){
           this.ListaUsuarios.get(idUsuario).setUsuarioJugando(false);
           return this.ListaUsuarios.get(idUsuario);
       }

        return null;
    }

    @Override
    public List<Usuario> OrdenUsuarios(Juego juego) throws JuegoNoExisteException {
        Juego a = getJuego(juego.getNombreJuego());
        List<Partida> partidadeunjuego = new ArrayList<>();
        for (Map.Entry<String , Usuario> entry : this.ListaUsuarios.entrySet()){
            try {
                Partida partida = getPartida(juego.getNombreJuego(), entry.getKey());
                if (partida!=null){
                    partidadeunjuego.add(partida);
                }
            } catch (UsuarioNoExisteException e) {
            }
        }
        if (partidadeunjuego.size()!=0){
            partidadeunjuego.sort((Partida p1, Partida p2) -> Integer.compare(p2.getPuntos(), p1.getPuntos()));
            List<Usuario> resultado = new ArrayList<>();
            for (Partida partida : partidadeunjuego){
                resultado.add(this.ListaUsuarios.get(partida.getNombreUsuario()));

            }
            return resultado;
        }


        return null;
    }

    @Override
    public List<Partida> getPartidasUsuario(String NombreUsuario) throws UsuarioNoExisteException {
        List <Partida> lista = getUsuario(NombreUsuario).getPartidasJugadas().values().stream().collect(toList());

        return lista;
    }

    @Override
    public List<Rendimiento> getRendimiento(String idJuego, String idUsuario) throws JuegoNoExisteException, UsuarioNoExisteException {
        List<Rendimiento> lista = getPartida(idJuego, idUsuario).getListaRendimiento();
        if (lista.size()!=0){
            for (Rendimiento a : lista){
                logger.info(a);
            }
            return lista;
        }


        return null;
    }

    @Override
    public Juego getJuego(String NombreJuego) throws JuegoNoExisteException {
        for(Juego juego : this.juegos){
            if(juego.getNombreJuego().equals(NombreJuego)){
                return juego;
            }
        }
        throw new JuegoNoExisteException();
    }

    @Override
    public Usuario getUsuario(String usuario) throws UsuarioNoExisteException {
        if(this.ListaUsuarios.get(usuario)==null){
            throw new UsuarioNoExisteException();
        }

        return this.ListaUsuarios.get(usuario);
    }

    @Override
    public Partida getPartida(String idJuego, String idUsuario) throws JuegoNoExisteException, UsuarioNoExisteException {
        List<Partida> lista = getPartidas(idJuego, idUsuario);
        if(lista.size()!=0){
            return lista.get(lista.size() - 1);
        }

        return null;
    }

    @Override
    public List<Partida> getPartidas(String idJuego, String idUsuario) throws JuegoNoExisteException, UsuarioNoExisteException {
       Juego juego = getJuego(idJuego);
       if (juego==null){
           return null;
       }
       Usuario usuario = this.ListaUsuarios.get(idUsuario);
       if(usuario==null){
           throw new UsuarioNoExisteException();
       }
       HashMap<String, Partida> partidas = usuario.getPartidasJugadas();
       List<Partida> PartidasJugadas = new ArrayList<>();
       for (Map.Entry<String, Partida> entry : partidas.entrySet()){
           if (entry.getValue().getNombreJuego().equals(idJuego)){
               PartidasJugadas.add(entry.getValue());
           }
       }


        return PartidasJugadas;
    }

    @Override
    public Partida getPartidaActual(String Usuario) throws UsuarioNoExisteException, UsuarioNoEstaJugandoException {
        Usuario usuario = getUsuario(Usuario);
        if (usuario.getUsuarioJugando()){
            List<Partida> PartidasJugadas = (List<Partida>) usuario.getPartidasJugadas().values().stream().collect(toList());
            return PartidasJugadas.get(PartidasJugadas.size()-1);
        }

        throw new UsuarioNoEstaJugandoException();
    }

}
