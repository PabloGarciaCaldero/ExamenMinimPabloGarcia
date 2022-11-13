import edu.upc.dsa.Excepciones.JuegoNoExisteException;
import edu.upc.dsa.Excepciones.UsuarioYaJugandoException;
import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class JuegoManagerImplTest {

    final static Logger logger = Logger.getLogger(String.valueOf(JuegoManagerImpl.class));
    JuegoManager JuegoManager;


    @Before
    public void setUp() throws JuegoNoExisteException, UsuarioYaJugandoException{
        JuegoManager = new JuegoManagerImpl();

        JuegoManager.CrearJuego("League of Legends", "mejor no juegues", 4);
        JuegoManager.CrearJuego("Dota 2", "League of Legends pero de valve", 6);
        JuegoManager.CrearJuego("Half-Life 3", "Ni siquiera existe", 2);

        JuegoManager.IniciarPartida("Dota 2", "Pau");
    }

    @After
    public void tearDown(){

    }

}
