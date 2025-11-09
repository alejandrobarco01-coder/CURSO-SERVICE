package com.example.cursoservice.controller;

import com.example.cursoservice.model.Estudiante;
import com.example.cursoservice.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // Crear estudiante
    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.crearEstudiante(estudiante));
    }

    // Buscar estudiantes por nombre
    @GetMapping("/buscar")
    public ResponseEntity<List<Estudiante>> buscarEstudiantes(@RequestParam String nombre) {
        return ResponseEntity.ok(estudianteService.buscarEstudiantes(nombre));
    }

    // Listar todos los estudiantes
    @GetMapping
    public ResponseEntity<List<Estudiante>> listarTodos() {
        return ResponseEntity.ok(estudianteService.listarTodos());
    }

    // Obtener estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.obtenerPorId(id));
    }

    // Eliminar estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.ok("Estudiante eliminado correctamente");
    }

}