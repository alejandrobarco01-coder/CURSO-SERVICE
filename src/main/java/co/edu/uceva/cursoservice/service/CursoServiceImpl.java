package co.edu.uceva.cursoservice.service;

import co.edu.uceva.cursoservice.model.Curso;
import co.edu.uceva.cursoservice.model.Ova;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CursoServiceImpl implements CursoService {

    private final List<Curso> cursos = new ArrayList<>();
    private final RestTemplate restTemplate = new RestTemplate();

    public CursoServiceImpl() {
        cursos.add(new Curso(1L, "Análisis"));
        cursos.add(new Curso(2L, "Matemáticas Discretas"));
    }

    @Override
    public List<Curso> listarCursos() {
        return cursos;
    }

    @Override
    public Curso agregarCurso(Curso curso) {
        curso.setId((long) (cursos.size() + 1));
        cursos.add(curso);
        return curso;
    }

    @Override
    public boolean eliminarCurso(Long id) {
        // NO permitir borrar los dos cursos principales
        if (id == 1 || id == 2) {
            return false;
        }
        return cursos.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public Map<String, Object> ejecutarBiseccion(Map<String, Object> body) {
        String url = "http://localhost:8080/api/ova/analisis-numerico";
        return restTemplate.postForObject(url, body, Map.class);
    }

    @Override
    public Map<String, Object> ejecutarCesar(Map<String, Object> body) {
        String url = "http://localhost:8080/api/ova/matematicas-discretas";
        return restTemplate.postForObject(url, body, Map.class);
    }

    @Override
    public Map<String, Object> ejecutarEscitala(Map<String, Object> body) {
        String url = "http://localhost:8080/api/ova/matematicas-discretas";
        return restTemplate.postForObject(url, body, Map.class);
    }


    @Override
    public List<Ova> obtenerOvasDelCurso(Long idCurso) {

        String url = "http://localhost:8080/api/ova/curso/" + idCurso;

        try {
            Ova[] respuesta = restTemplate.getForObject(url, Ova[].class);
            return Arrays.asList(respuesta);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
