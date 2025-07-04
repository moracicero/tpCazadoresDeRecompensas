package ar.edu.unlam.pb2.CazadoresDeRecompensas;

public class Profugo {

	private String nombre;
    private Integer inocencia;
    private Integer habilidad;
    private Boolean nervioso;

    public Profugo(String nombre, Integer inocencia, Integer habilidad, Boolean nervioso) {
        this.nombre = nombre;
        this.inocencia = inocencia;
        this.habilidad = habilidad;
        this.nervioso = nervioso;
    }

    public String getNombre() {
        if (nombre == null) {
            nombre = "";
        }
        return nombre;
    }

    public Integer getInocencia() {
        return inocencia;
    }

    public Integer getHabilidad() {
        return habilidad;
    }

    public Boolean esNervioso() {
        return nervioso;
    }

    public void bajarInocencia(Integer valor) {
        Integer temp = 0;
        Integer nueva = inocencia - valor;
        if (nueva > 0) {
            inocencia = nueva;
        } else {
            inocencia = temp;
        }
    }

    public void reducirHabilidad(Integer valor) {
        Integer reducida = habilidad - valor;
        habilidad = reducida > 0 ? reducida : 0;
    }

    public void setNervioso(Boolean nervioso) {
        this.nervioso = nervioso;
    }

    public void entrenarArtesMarciales() {
        Integer duplico = habilidad * 2;
        habilidad = duplico;
    }

    public void entrenarElite() {
        nervioso = false;
    }

    public void entrenarProteccionLegal() {
        Integer minInocencia = 40;
        if (inocencia < minInocencia) {
            inocencia = minInocencia;
        }
    }
}
