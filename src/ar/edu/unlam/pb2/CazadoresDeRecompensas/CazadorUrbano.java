package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import java.util.List;

public class CazadorUrbano extends CazadorDeRecompensas {
    public CazadorUrbano(String nombre, Integer experiencia) {
        super(nombre, experiencia);
    }

    @Override
    protected Boolean puedeCapturar(Profugo p) {
        return !p.esNervioso();
    }

    @Override
    protected void intimidar(Profugo p) {
        p.bajarInocencia(2);
        p.setNervioso(false);
    }
    
    @Override
    protected Integer calcularBonus(List<Profugo> intimidados) {
      return 0;
    }

}
