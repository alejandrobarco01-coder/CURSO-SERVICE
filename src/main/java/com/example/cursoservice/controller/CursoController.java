package com.example.cursoservice.controller;

import com.example.cursoservice.model.Curso;
import com.example.cursoservice.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Crear curso
    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.crearCurso(curso));
    }

    // Buscar curso
    @GetMapping("/buscar")
    public ResponseEntity<List<Curso>> buscarCursos(@RequestParam String nombre) {
        return ResponseEntity.ok(cursoService.buscarCursos(nombre));
    }

    // Eliminar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable Long id) {
        try {
            cursoService.eliminarCurso(id);
            return ResponseEntity.ok().build(); // ✅ Devuelve 200 OK en lugar de error
        } catch (RuntimeException e) {
            // Si el curso no existe, podrías considerar devolver 200 igualmente
            // o manejar de forma diferente
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Curso no encontrado con ID: " + id);
        }
    }
}

