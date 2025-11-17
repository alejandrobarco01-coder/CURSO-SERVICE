package com.example.cursoservice.service;

import com.example.cursoservice.model.Curso;
import com.example.cursoservice.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Crear curso
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Buscar cursos por nombre
    public List<Curso> buscarCursos(String nombre) {
        return cursoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Eliminar curso por ID
    public void eliminarCurso(Long id) {
        // En lugar de lanzar excepción, podrías verificar silenciosamente
        cursoRepository.findById(id).ifPresent(cursoRepository::delete);

        // O si quieres mantener la validación:
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
        cursoRepository.delete(curso);
    }
}
