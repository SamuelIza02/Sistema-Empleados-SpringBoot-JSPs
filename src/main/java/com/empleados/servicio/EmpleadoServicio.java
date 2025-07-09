package com.empleados.servicio;

import com.empleados.modelo.Empleado;
import com.empleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio de empleados
 * Contiene la lógica de negocio y actúa como intermediario entre el controlador y el repositorio
 */
@Service // Marca la clase como un servicio de Spring para inyección de dependencias
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired // Inyección automática de dependencia
    private EmpleadoRepositorio empleadoRepositorio;

    /**
     * Obtiene todos los empleados de la base de datos
     */
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll(); // Delega al repositorio
    }

    /**
     * Busca un empleado por su ID
     * Utiliza Optional para manejar casos donde el empleado no existe
     */
    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        // findById retorna Optional<Empleado>, orElse(null) maneja el caso de no encontrado
        Empleado empleado = empleadoRepositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }

    /**
     * Guarda un empleado (crear nuevo o actualizar existente)
     * JPA determina automáticamente si es INSERT o UPDATE según el ID
     */
    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado); // save() maneja tanto INSERT como UPDATE
    }

    /**
     * Elimina un empleado de la base de datos
     */
    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado); // Elimina por objeto completo
    }
}
