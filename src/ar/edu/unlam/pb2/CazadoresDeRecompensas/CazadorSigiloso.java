package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import java.util.List;

public class CazadorSigiloso extends CazadorDeRecompensas {
    public CazadorSigiloso(String nombre, Integer experiencia) {
        super(nombre, experiencia);
    }

    @Override
    protected Boolean puedeCapturar(Profugo p) {
        return p.getHabilidad() < 50;
    }

    @Override
    protected void intimidar(Profugo p) {
        p.bajarInocencia(2);
        p.reducirHabilidad(5);
        p.reducirHabilidad(0);
    }
    
    @Override
    protected Integer calcularBonus(List<Profugo> intimidados) {
        if (intimidados.isEmpty()) {
            return 0;
        }
        Integer maxInocencia = Integer.MIN_VALUE;
        for (Profugo p : intimidados) {
            if (p.getInocencia() > maxInocencia) {
                maxInocencia = p.getInocencia();
            }
        }
        return maxInocencia;
    }
}