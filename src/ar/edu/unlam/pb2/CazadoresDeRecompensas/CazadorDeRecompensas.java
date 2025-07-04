package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class CazadorDeRecompensas implements Capturador{

	protected String nombre;
    protected Integer experiencia;
    protected Set<Profugo> capturados = new HashSet<>();

    public CazadorDeRecompensas(String nombre, Integer experiencia) {
        this.nombre = nombre;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public Set<Profugo> getCapturados() {
        return capturados;
    }
    
    protected void sumarExperienciaPorIntimidacion(List<Profugo> intimidados) {
    	  for (Profugo p : intimidados) {
    	    this.experiencia += p.getHabilidad();
    	  }
    	}

    public Set<Profugo> realizarCaptura(Zona zona)
            throws ZonaSinProfugosException, ProfugoNoEncontradoException {
        if (zona.getProfugos().isEmpty()) {
            throw new ZonaSinProfugosException("La zona está vacía");
        }
        Set<Profugo> capturadosEsta = new HashSet<>();
        List<Profugo> intimidados = new ArrayList<>();
        for (Profugo p : zona.getProfugos()) {
            Boolean condicion = experiencia > p.getInocencia() && puedeCapturar(p);
            if (condicion) {
                capturados.add(p);
                capturadosEsta.add(p);
            } else {
                intimidar(p);
                intimidados.add(p);
            }
        }
        for (Profugo p : capturadosEsta) {
            zona.removerProfugo(p.getNombre());
        }
        Integer minHabilidad = Integer.MAX_VALUE;
        for (Profugo p : intimidados) {
            if (p.getHabilidad() < minHabilidad) {
                minHabilidad = p.getHabilidad();
            }
        }
        Integer bonus = intimidados.isEmpty() ? 0 : minHabilidad;
        experiencia = experiencia + bonus + (capturadosEsta.size() * 2);
        return capturadosEsta;
    }
    
    protected Integer calcularBonus(List<Profugo> intimidados) {
    	  if(intimidados.isEmpty()) return 0;
    	  Integer min = Integer.MAX_VALUE;
    	  for(Profugo p: intimidados) min = Math.min(min, p.getHabilidad());
    	  return min;
    	}

    protected abstract Boolean puedeCapturar(Profugo p);
    protected abstract void intimidar(Profugo p);
}