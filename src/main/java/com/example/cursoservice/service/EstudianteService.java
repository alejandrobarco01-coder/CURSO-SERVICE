package com.example.cursoservice.service;

import com.example.cursoservice.model.Estudiante;
import com.example.cursoservice.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // Crear estudiante
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // Buscar estudiantes por nombre
    public List<Estudiante> buscarEstudiantes(String nombre) {
        return estudianteRepository.findByNombreContaining(nombre);
    }

    // Listar todos los estudiantes
    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    // Obtener estudiante por ID
    public Estudiante obtenerPorId(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }

    // Eliminar estudiante
    public void eliminarEstudiante(Long id) {
        if (!estudianteRepository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado con id: " + id);
        }
        estudianteRepository.deleteById(id);
    }
}