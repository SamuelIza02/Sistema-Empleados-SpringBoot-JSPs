package com.empleados.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entidad JPA que representa un empleado en la base de datos
 * Utiliza Lombok para generar automáticamente getters, setters y constructores
 */
@Entity // Marca la clase como entidad JPA para mapeo a tabla de BD
@Data // Lombok: genera getters, setters, equals, hashCode automáticamente
@NoArgsConstructor // Lombok: genera constructor sin parámetros
@AllArgsConstructor // Lombok: genera constructor con todos los parámetros
@ToString // Lombok: genera método toString() automáticamente
public class Empleado {

    @Id // Marca el campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento en BD
    Integer idEmpleado; // ID único del empleado
    
    String nombreEmpleado; // Nombre completo del empleado
    String departamento; // Departamento donde trabaja
    Double sueldo; // Salario del empleado

}
