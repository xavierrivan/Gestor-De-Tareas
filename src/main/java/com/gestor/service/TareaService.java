package com.gestor.service;

import com.gestor.model.Tarea;
import com.gestor.model.Prioridad;
import com.gestor.model.Estado;
import com.gestor.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> findById(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea changeEstado(Long id, Estado nuevoEstado) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        if (tarea.isPresent()) {
            Tarea tareaActualizada = tarea.get();
            tareaActualizada.setEstado(nuevoEstado);
            return tareaRepository.save(tareaActualizada);
        }
        return null;
    }

    public void deleteById(Long id) {
        tareaRepository.deleteById(id);
    }

    public List<Tarea> findByEstado(String estado) {
        return tareaRepository.findByEstado(Estado.valueOf(estado));
    }

    public List<Tarea> findByPrioridad(String prioridad) {
        return tareaRepository.findByPrioridad(Prioridad.valueOf(prioridad));
    }
} 