package ar.edu.unlam.pb2.CazadoresDeRecompensas;

import java.util.ArrayList;
import java.util.List;

public class Zona implements AreaDeBusqueda{
    private String nombre;
    private List<Profugo> profugos = new ArrayList<>();

    public Zona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Profugo> getProfugos() {
        return new ArrayList<>(profugos);
    }

    public void agregarProfugo(Profugo p) throws ProfugoDuplicadoException {
        for (Profugo existente : profugos) {
            if (existente.getNombre().equals(p.getNombre())) {
                throw new ProfugoDuplicadoException("Prófugo duplicado: " + p.getNombre());
            }
        }
        profugos.add(p);
    }

    public void removerProfugo(String nombre) throws ProfugoNoEncontradoException {
        for (Profugo p : profugos) {
            if (p.getNombre().equals(nombre)) {
                profugos.remove(p);
                return;
            }
        }
        throw new ProfugoNoEncontradoException("Prófugo no encontrado: " + nombre);
    }
}
