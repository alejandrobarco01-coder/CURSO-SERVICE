package co.edu.uceva.cursoservice.model;

public class Curso {
    private Long id;
    private String nombre;

    public Curso() {}

    public Curso(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}


