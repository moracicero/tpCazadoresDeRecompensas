package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class CazadorRuralTest {

	private Zona zona;
    private CazadorRural cazador;
    private Profugo p1, p2;

    @Before
    public void setUp() throws ProfugoDuplicadoException {
        zona = new Zona("Imperio");
        cazador = new CazadorRural("Rural", 50);
        p1 = new Profugo("N", 20, 30, true);
        p2 = new Profugo("M", 25, 40, false);
        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);
    }

    @Test
    public void capturaSoloSiEsNervioso() throws Exception {
        Set<Profugo> res = cazador.realizarCaptura(zona);
        assertTrue(res.contains(p1));
        assertFalse(res.contains(p2));
    }

    @Test
    public void inocenciaYExperienciaDespuesDeIntimidacion() throws Exception {
        Set<Profugo> capturados = cazador.realizarCaptura(zona);
        Profugo profugoIntimidado = p2;
        assertEquals(Integer.valueOf(23), profugoIntimidado.getInocencia());
        assertTrue(profugoIntimidado.esNervioso());

        assertEquals(Integer.valueOf(92), cazador.getExperiencia());

        assertTrue(capturados.contains(p1));
        assertFalse(capturados.contains(p2));
    }

}
