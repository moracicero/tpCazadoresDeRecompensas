package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ZonaTest {


	private Zona zona;
    private Profugo p1, p2;

    @Before
    public void setUp() {
        zona = new Zona("Playa");
        p1 = new Profugo("A", 10, 20, false);
        p2 = new Profugo("B", 15, 25, true);
    }

    @Test
    public void agregarYListarProfugos() throws ProfugoDuplicadoException {
        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);
        List<Profugo> lista = zona.getProfugos();
        assertTrue(lista.contains(p1));
        assertTrue(lista.contains(p2));
    }

    @Test
    public void removerProfugoExistente() throws Exception {
        zona.agregarProfugo(p1);
        zona.removerProfugo("A");
        assertFalse(zona.getProfugos().contains(p1));
    }

}
