package co.edu.uceva.cursoservice.controller;

import co.edu.uceva.cursoservice.model.Curso;
import co.edu.uceva.cursoservice.model.Ova;
import co.edu.uceva.cursoservice.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso-service")
@CrossOrigin("*")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @PostMapping("/cursos")
    public Curso agregarCurso(@RequestBody Curso curso) {
        return cursoService.agregarCurso(curso);
    }

    @DeleteMapping("/cursos/{id}")
    public boolean eliminarCurso(@PathVariable Long id) {
        return cursoService.eliminarCurso(id);
    }

    @GetMapping("/curso/{id}/ovas")
    public List<Ova> obtenerOvas(@PathVariable Long id) {
        return cursoService.obtenerOvasDelCurso(id);
    }
}


