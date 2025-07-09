package com.empleados.servicio;

import com.empleados.modelo.Empleado;

import java.util.List;

/**
 * Interfaz que define los servicios de negocio para la gestión de empleados
 * Establece el contrato que debe cumplir cualquier implementación del servicio
 */
public interface IEmpleadoServicio {
    
    /**
     * Obtiene todos los empleados registrados
     * @return Lista de todos los empleados
     */
    public List<Empleado> listarEmpleados();
    
    /**
     * Busca un empleado por su ID
     * @param idEmpleado ID del empleado a buscar
     * @return Empleado encontrado o null si no existe
     */
    public Empleado buscarEmpleadoPorId(Integer idEmpleado);
    
    /**
     * Guarda un empleado (crear nuevo o actualizar existente)
     * @param empleado Empleado a guardar
     */
    public void guardarEmpleado(Empleado empleado);
    
    /**
     * Elimina un empleado del sistema
     * @param empleado Empleado a eliminar
     */
    public void eliminarEmpleado(Empleado empleado);
}
