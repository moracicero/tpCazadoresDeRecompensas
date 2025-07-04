package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CazadorUrbanoTest {

	private Zona zona;
    private CazadorUrbano cazador;
    private Profugo p1, p2;

    @Before
    public void setUp() {
        zona = new Zona("Tren");
        cazador = new CazadorUrbano("Urban", 40);
        p1 = new Profugo("X", 30, 50, false);
        p2 = new Profugo("Y", 20, 60, true);
    }

    @Test
    public void CapturaSoloSiNoEsNervioso() throws Exception {
        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);
        Set<Profugo> res = cazador.realizarCaptura(zona);
        assertTrue(res.contains(p1));
        assertFalse(res.contains(p2));
    }

    @Test
    public void experienciaYEstadoDespuesDeCapturado() throws Exception {
        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);

        Set<Profugo> res = cazador.realizarCaptura(zona);

        assertEquals(Integer.valueOf(102), cazador.getExperiencia());

        assertFalse(p2.esNervioso());

        assertTrue(res.contains(p1));
        assertFalse(res.contains(p2));
    }

}
