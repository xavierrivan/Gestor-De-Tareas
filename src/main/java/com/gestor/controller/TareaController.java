package com.gestor.controller;

import com.gestor.model.Tarea;
import com.gestor.model.Estado;
import com.gestor.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<Tarea>> getAllTareas() {
        List<Tarea> tareas = tareaService.findAll();
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable Long id) {
        Optional<Tarea> tarea = tareaService.findById(id);
        return tarea.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tarea> createTarea(@RequestBody Tarea tarea) {
        Tarea savedTarea = tareaService.save(tarea);
        return ResponseEntity.ok(savedTarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        Optional<Tarea> existingTarea = tareaService.findById(id);
        if (existingTarea.isPresent()) {
            tarea.setId(id);
            Tarea updatedTarea = tareaService.save(tarea);
            return ResponseEntity.ok(updatedTarea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Tarea> changeEstado(@PathVariable Long id, @RequestBody String nuevoEstado) {
        Optional<Tarea> tarea = tareaService.findById(id);
        if (tarea.isPresent()) {
            try {
                Estado estado = Estado.valueOf(nuevoEstado);
                Tarea updatedTarea = tareaService.changeEstado(id, estado);
                return ResponseEntity.ok(updatedTarea);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
        Optional<Tarea> tarea = tareaService.findById(id);
        if (tarea.isPresent()) {
            tareaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Tarea>> getTareasByEstado(@PathVariable String estado) {
        List<Tarea> tareas = tareaService.findByEstado(estado);
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<List<Tarea>> getTareasByPrioridad(@PathVariable String prioridad) {
        List<Tarea> tareas = tareaService.findByPrioridad(prioridad);
        return ResponseEntity.ok(tareas);
    }
} 