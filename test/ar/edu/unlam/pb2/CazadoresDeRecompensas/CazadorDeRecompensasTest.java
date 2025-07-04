package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CazadorDeRecompensasTest {

    @Test
    public void creacionDeCazadorDeRecompensas() {
        CazadorDeRecompensas c = new CazadorUrbano("Test", 25);
        assertEquals("Test", c.getNombre());
        assertEquals(Integer.valueOf(25), c.getExperiencia());
        assertTrue(c.getCapturados().isEmpty());
    }

}