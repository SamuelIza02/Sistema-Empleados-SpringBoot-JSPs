package com.empleados.repositorio;

import com.empleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para operaciones CRUD de la entidad Empleado
 * Extiende JpaRepository que proporciona métodos básicos como:
 * - findAll(), findById(), save(), delete(), etc.
 */
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
    // JpaRepository ya incluye todos los métodos CRUD necesarios
    // No necesitamos implementar nada, Spring Data JPA lo hace automáticamente
}
