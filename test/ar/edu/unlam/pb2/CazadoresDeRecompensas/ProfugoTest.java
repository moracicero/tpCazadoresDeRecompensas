package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfugoTest {

	@Test
    public void creacionYModificaciones() {
        Profugo p = new Profugo("Evans", 80, 30, true);
        assertEquals("Evans", p.getNombre());
        assertEquals(Integer.valueOf(80), p.getInocencia());
        assertEquals(Integer.valueOf(30), p.getHabilidad());
        assertTrue(p.esNervioso());

        p.bajarInocencia(50);
        assertEquals(Integer.valueOf(30), p.getInocencia());
        p.bajarInocencia(100);
        assertEquals(Integer.valueOf(0), p.getInocencia());

        p.reducirHabilidad(10);
        assertEquals(Integer.valueOf(20), p.getHabilidad());
        p.reducirHabilidad(50);
        assertEquals(Integer.valueOf(0), p.getHabilidad());
    }

    @Test
    public void entrenamientos() {
        Profugo p = new Profugo("Lee", 10, 20, false);
        p.entrenarArtesMarciales();
        assertEquals(Integer.valueOf(40), p.getHabilidad());

        p = new Profugo("Kim", 20, 15, true);
        p.entrenarElite();
        assertFalse(p.esNervioso());

        p = new Profugo("Park", 5, 50, false);
        p.entrenarProteccionLegal();
        assertEquals(Integer.valueOf(40), p.getInocencia());
    }


}
