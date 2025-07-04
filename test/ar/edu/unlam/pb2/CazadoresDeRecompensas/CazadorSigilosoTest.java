package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class CazadorSigilosoTest {

	private Zona zona;
    private CazadorSigiloso cazador;
    private Profugo p1, p2;

    @Before
    public void setUp() throws Exception {
        zona = new Zona("Selva");
        cazador = new CazadorSigiloso("Sigilo", 30);
        p1 = new Profugo("A1", 10, 45, false);
        p2 = new Profugo("B2", 5, 55, false);
        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);
    }

    @Test
    public void capturaHabilidadInferior50() throws Exception {
        Set<Profugo> res = cazador.realizarCaptura(zona);
        assertTrue(res.contains(p1));
        assertFalse(res.contains(p2));
    }

    @Test
    public void reducirInocenciaYHabilidadAlIntimidar() throws Exception {
        Set<Profugo> res = cazador.realizarCaptura(zona);

        assertEquals(Integer.valueOf(3),  p2.getInocencia());
        assertEquals(Integer.valueOf(50), p2.getHabilidad());

        assertTrue(res.contains(p1));
        assertFalse(res.contains(p2));
    }

}
