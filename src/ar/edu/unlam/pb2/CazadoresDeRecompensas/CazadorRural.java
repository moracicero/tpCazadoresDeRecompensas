package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import java.util.List;

public class CazadorRural extends CazadorDeRecompensas {
    public CazadorRural(String nombre, Integer experiencia) {
        super(nombre, experiencia);
    }

    @Override
    protected Boolean puedeCapturar(Profugo p) {
        return p.esNervioso();
    }

    @Override
    protected void intimidar(Profugo p) {
        p.bajarInocencia(2);
        p.setNervioso(true);

    }
    
    @Override
    protected Integer calcularBonus(List<Profugo> intimidados) {
    	
      return intimidados.isEmpty()? 0 : intimidados.get(0).getHabilidad();
    }
}
