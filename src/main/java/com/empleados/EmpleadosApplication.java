package com.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot
 * Punto de entrada del sistema de gestión de empleados
 */
@SpringBootApplication // Habilita auto-configuración, escaneo de componentes y configuración
public class EmpleadosApplication {

	/**
	 * Método principal que inicia la aplicación Spring Boot
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		// Inicia el contexto de Spring Boot y el servidor embebido
		SpringApplication.run(EmpleadosApplication.class, args);
	}

}
