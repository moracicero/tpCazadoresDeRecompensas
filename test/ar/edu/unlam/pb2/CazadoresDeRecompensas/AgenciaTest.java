package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AgenciaTest {

	private Agencia agencia;
    private CazadorDeRecompensas c1, c2;
    private Zona z1;
    private Profugo p;

    @Before
    public void setUp() throws Exception {
        agencia = new Agencia();
        c1 = new CazadorUrbano("A", 20);
        c2 = new CazadorUrbano("B", 30);
        z1 = new Zona("Lugar");
        p = new Profugo("Z", 10, 10, false);
        agencia.agregarCazador(c1);
        agencia.agregarCazador(c2);
        agencia.agregarZona(z1);
        z1.agregarProfugo(p);
        c1.realizarCaptura(z1);
    }

    @Test
    public void todosLosProfugosCapturados() {
        List<Profugo> lista = agencia.getTodosLosProfugosCapturados();
        assertEquals(1, lista.size());
    }

    @Test
    public void profugoMasHabilCapturado() {
        Profugo ph = agencia.getProfugoMasHabilCapturado();
        assertEquals(p, ph);
    }

    @Test
    public void cazadorConMasCapturas() {
        assertEquals(c1, agencia.getCazadorConMasCapturas());
    }
}
