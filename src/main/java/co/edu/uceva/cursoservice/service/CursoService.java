package co.edu.uceva.cursoservice.service;

import co.edu.uceva.cursoservice.model.Curso;
import co.edu.uceva.cursoservice.model.Ova;

import java.util.List;

public interface CursoService {
    List<Curso> listarCursos();
    Curso agregarCurso(Curso curso);
    boolean eliminarCurso(Long id);
    List<Ova> obtenerOvasDelCurso(Long idCurso);
}



