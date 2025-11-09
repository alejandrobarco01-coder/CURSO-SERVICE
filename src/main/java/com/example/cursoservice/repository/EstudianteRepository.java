package com.example.cursoservice.repository;

import com.example.cursoservice.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // Buscar estudiantes por nombre (contiene)
    List<Estudiante> findByNombreContaining(String nombre);

    // Buscar por código de estudiante
    List<Estudiante> findByCodigoEstudiante(String codigoEstudiante);

    // Buscar estudiantes activos
    List<Estudiante> findByActivoTrue();
}