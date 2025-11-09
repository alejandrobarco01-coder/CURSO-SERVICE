package com.example.cursoservice.controller;

import com.example.cursoservice.model.Curso;
import com.example.cursoservice.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<String> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.ok("Curso eliminado correctamente");
    }
}

