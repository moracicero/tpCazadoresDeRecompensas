package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.Cazadores.Agencia;
import ar.edu.unlam.pb2.Cazadores.CazadorDuplicadoException;
import ar.edu.unlam.pb2.Cazadores.CazadorUrbano;

public class CazadorDuplicadoExceptionTest {

    @Test(expected = CazadorDuplicadoException.class)
    public void agregarCazadorDuplicadoLanzaException() throws CazadorDuplicadoException {
        Agencia agencia = new Agencia();
        CazadorUrbano cazador = new CazadorUrbano("Jill", 50);
        agencia.agregarCazador(cazador);
        agencia.agregarCazador(cazador);
    }
}
