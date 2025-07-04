package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import java.util.List;

public interface AreaDeBusqueda {
    void agregarProfugo(Profugo p) throws ProfugoDuplicadoException;
    void removerProfugo(String nombre) throws ProfugoNoEncontradoException;
    List<Profugo> getProfugos();
    String getNombre();
}
