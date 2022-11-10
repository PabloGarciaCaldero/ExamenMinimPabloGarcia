import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JuegoManagerImplTest {

    JuegoManager JuegoManager;

    @Before
    public void setUp() {
        this.JuegoManager = new JuegoManagerImpl();

        this.JuegoManager.CreacionJuego("011", "Proba1", "Usu1", "primer juego");

        this.JuegoManager.InicioPartida("Partida1", "Proba1", "Usu1", 50);
    }

    @After
    public void setDown(){
        this.JuegoManager = null;
    }

    @Test
    public void test_creacion_partida(){

    }



}
