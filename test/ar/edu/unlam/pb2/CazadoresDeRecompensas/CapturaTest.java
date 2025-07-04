package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import org.junit.Test;


public class CapturaTest {

	@Test(expected = ZonaSinProfugosException.class)
	public void realizarCapturaEnZonaVaciaLanzaException() throws Exception {
	    Zona zona = new Zona("Nada");
	    CazadorUrbano c = new CazadorUrbano("Solo", 10);
	    c.realizarCaptura(zona);
	}

    @Test(expected = ZonaSinProfugosException.class)
    public void removerDespuesDeCapturaLanzaSiNoExiste() throws Exception {
        Zona zona = new Zona("Vacío");
        CazadorUrbano c = new CazadorUrbano("Solo", 10);
        zona.agregarProfugo(new Profugo("X", 5, 5, false));
        c.realizarCaptura(zona);
        c.realizarCaptura(zona);
    }

}
