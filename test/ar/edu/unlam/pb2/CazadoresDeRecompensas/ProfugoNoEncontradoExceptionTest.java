package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import org.junit.Test;


public class ProfugoNoEncontradoExceptionTest {

	   @Test (expected = ProfugoNoEncontradoException.class)
	    public void removerProfugoNoExistenteLanzaException() throws ProfugoNoEncontradoException {
	        Zona zona = new Zona("Montaña");
	        zona.removerProfugo("Inexistente");
	    }
}
