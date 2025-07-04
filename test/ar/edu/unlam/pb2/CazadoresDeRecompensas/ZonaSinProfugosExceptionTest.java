package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZonaSinProfugosExceptionTest {

    @Test(expected = ZonaSinProfugosException.class)
    public void capturaEnZonaVaciaLanzaException() throws ZonaSinProfugosException, ProfugoNoEncontradoException {
        CazadorUrbano cazador = new CazadorUrbano("Max", 40);
        Zona zona = new Zona("Bosque");
        cazador.realizarCaptura(zona);
    }

}
