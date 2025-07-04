package ar.edu.unlam.pb2.CazadoresDeRecompensas;

public class ProfugoDuplicadoException extends Exception {
	private static final long serialVersionUID = 1L; // Profes, agregue esta linea porque si no el exception me chillaba y la solucion que encontre fue esta linea.

	public ProfugoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
