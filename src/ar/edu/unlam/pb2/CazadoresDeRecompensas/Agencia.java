package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agencia {
	private List<CazadorDeRecompensas> cazadores = new ArrayList<>();
    private List<Zona> zonas = new ArrayList<>();

    public void agregarCazador(CazadorDeRecompensas c) throws CazadorDuplicadoException {
        for (CazadorDeRecompensas ex : cazadores) {
            if (ex.getNombre().equals(c.getNombre())) {
                throw new CazadorDuplicadoException("Cazador duplicado: " + c.getNombre());
            }
        }
        cazadores.add(c);
    }

    public void agregarZona(Zona z) throws ZonaDuplicadaException {
        for (Zona ex : zonas) {
            if (ex.getNombre().equals(z.getNombre())) {
                throw new ZonaDuplicadaException("Zona duplicada: " + z.getNombre());
            }
        }
        zonas.add(z);
    }

    public List<Profugo> getTodosLosProfugosCapturados() {
        Set<Profugo> todos = new HashSet<>();
        for (CazadorDeRecompensas c : cazadores) {
            todos.addAll(c.getCapturados());
        }
        return new ArrayList<>(todos);
    }

    public Profugo getProfugoMasHabilCapturado() {
        Profugo masHabil = null;
        for (Profugo p : getTodosLosProfugosCapturados()) {
            if (masHabil == null || p.getHabilidad() > masHabil.getHabilidad()) {
                masHabil = p;
            }
        }
        return masHabil;
    }

    public CazadorDeRecompensas getCazadorConMasCapturas() {
        CazadorDeRecompensas mejor = null;
        Integer max = -1;
        for (CazadorDeRecompensas c : cazadores) {
            Integer t = c.getCapturados().size();
            if (t > max) {
                max = t;
                mejor = c;
            }
        }
        return mejor;
    }
}
