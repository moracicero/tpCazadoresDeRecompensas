package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZonaDuplicadaExceptionTest {

    @Test(expected = ZonaDuplicadaException.class)
    public void agregarZonaDuplicadaLanzaException() throws ZonaDuplicadaException {
        Agencia agencia = new Agencia();
        Zona z = new Zona("Ciudad");
        agencia.agregarZona(z);
        agencia.agregarZona(z);
    }

}
