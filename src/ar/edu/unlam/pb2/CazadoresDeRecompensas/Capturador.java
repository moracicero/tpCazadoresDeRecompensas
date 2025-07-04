package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import java.util.Set;

public interface Capturador {
    Set<Profugo> realizarCaptura(Zona zona)
        throws ZonaSinProfugosException, ProfugoNoEncontradoException;
    String getNombre();
    Integer getExperiencia();
    Set<Profugo> getCapturados();
}