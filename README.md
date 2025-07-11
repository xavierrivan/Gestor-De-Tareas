# Gestor de Tareas

Sistema de gestión de tareas desarrollado con Spring Boot.

## Descripción

Aplicación web para crear, editar, eliminar y visualizar tareas con sistema de prioridades y control de estado.

## Características

- Gestión completa de tareas (crear, editar, eliminar, visualizar)
- Sistema de prioridades (Alta, Media, Baja)
- Estados de progreso (Pendiente, En Progreso, Completada)
- Interfaz web simple
- Base de datos H2 embebida
- API REST

## Tecnologías

- Spring Boot 3
- Java 17
- H2 Database
- JPA/Hibernate
- HTML/CSS/JavaScript
- Maven

## Requisitos

- Java 17 o superior
- Maven 3.6+

## Instalación

1. Clonar el repositorio
2. Compilar el proyecto:
   ```bash
   mvn clean compile
   ```
3. Ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```
4. Acceder a la aplicación:
   ```
   http://localhost:8081/gestor-tareas
   ```

## Estructura del Proyecto

```
src/main/java/com/gestor/
├── model/
│   ├── Tarea.java
│   ├── Prioridad.java
│   └── Estado.java
├── repository/
│   └── TareaRepository.java
├── service/
│   └── TareaService.java
├── controller/
│   └── TareaController.java
└── GestorTareasApplication.java
```

## API REST

- GET `/api/tareas` - Obtener todas las tareas
- POST `/api/tareas` - Crear nueva tarea
- PUT `/api/tareas/{id}` - Actualizar tarea
- DELETE `/api/tareas/{id}` - Eliminar tarea
- PUT `/api/tareas/{id}/estado` - Cambiar estado
- GET `/api/tareas/estado/{estado}` - Filtrar por estado
- GET `/api/tareas/prioridad/{prioridad}` - Filtrar por prioridad

## Funcionalidades

### Crear Tarea
- Título (obligatorio, máximo 100 caracteres)
- Descripción (opcional, máximo 500 caracteres)
- Prioridad (Alta, Media, Baja)
- Estado (Pendiente, En Progreso, Completada)
- Fecha límite (opcional)

### Gestión de Tareas
- Visualización de todas las tareas
- Estadísticas en tiempo real
- Edición de tareas mediante modal
- Eliminación de tareas con confirmación
- Cambio de estado automático
- Filtros por estado y prioridad

## Configuración

La aplicación utiliza H2 Database embebida. Los datos se mantienen en memoria durante la ejecución.

## Autor

**Xavier Gordillo**

## Link del video

https://youtu.be/EeOHD-KcMQI

