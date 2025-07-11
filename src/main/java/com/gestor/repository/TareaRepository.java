package com.gestor.repository;

import com.gestor.model.Tarea;
import com.gestor.model.Prioridad;
import com.gestor.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByPrioridad(Prioridad prioridad);
    List<Tarea> findByEstado(Estado estado);
} 