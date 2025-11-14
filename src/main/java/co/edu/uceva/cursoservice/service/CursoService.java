package co.edu.uceva.cursoservice.service;

import co.edu.uceva.cursoservice.model.Curso;
import co.edu.uceva.cursoservice.model.Ova;

import java.util.List;
import java.util.Map;

public interface CursoService {
    List<Curso> listarCursos();
    Curso agregarCurso(Curso curso);
    boolean eliminarCurso(Long id);
    List<Ova> obtenerOvasDelCurso(Long idCurso);
    Map<String, Object> ejecutarBiseccion(Map<String, Object> body);
    Map<String, Object> ejecutarCesar(Map<String, Object> body);
    Map<String, Object> ejecutarEscitala(Map<String, Object> body);

}



