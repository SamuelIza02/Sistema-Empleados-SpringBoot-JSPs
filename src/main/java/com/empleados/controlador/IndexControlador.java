package com.empleados.controlador;

import com.empleados.modelo.Empleado;
import com.empleados.servicio.EmpleadoServicio;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Controlador principal que maneja las peticiones HTTP del sistema de empleados
 * Implementa el patrón MVC - recibe peticiones, procesa datos y retorna vistas
 */
@Controller // Marca la clase como controlador Spring MVC
public class IndexControlador {
    
    // Logger para registrar eventos y depuración
    private static final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class);

    @Autowired // Inyección automática del servicio
    EmpleadoServicio empleadoServicio;

    /**
     * Maneja GET "/" - Página principal que muestra lista de empleados
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
        // Obtiene todos los empleados del servicio
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        
        // Log para depuración - muestra cada empleado en consola
        empleados.forEach((empleado) -> logger.info(empleado.toString()));
        
        // Agrega la lista al modelo para la vista JSP
        modelo.put("empleados", empleados);
        return "index"; // Retorna index.jsp
    }

    /**
     * Maneja GET "/agregar" - Muestra formulario para agregar empleado
     */
    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar"; // Retorna agregar.jsp
    }

    /**
     * Maneja POST "/agregar" - Procesa formulario de nuevo empleado
     */
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a agregar: " + empleado);
        empleadoServicio.guardarEmpleado(empleado); // Guarda en BD
        return "redirect:/"; // Patrón Post-Redirect-Get
    }

    /**
     * Maneja GET "/editar" - Muestra formulario de edición con datos del empleado
     */
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo){
        // Busca el empleado por ID
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        logger.info("Empleado a editar: " + empleado);
        
        // Pasa el empleado al modelo para pre-llenar el formulario
        modelo.put("empleado", empleado);
        return "editar"; // Retorna editar.jsp
    }

    /**
     * Maneja POST "/editar" - Procesa formulario de edición
     */
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a guardar (editar): " + empleado);
        empleadoServicio.guardarEmpleado(empleado); // save() detecta si es UPDATE
        return "redirect:/"; // Vuelve a la lista
    }

    /**
     * Maneja GET "/eliminar" - Elimina empleado por ID
     * NOTA: Usa GET por simplicidad, idealmente debería ser DELETE
     */
    @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado){
        // Crea objeto empleado solo con ID para eliminación
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleadoServicio.eliminarEmpleado(empleado);
        return "redirect:/"; // Vuelve a la lista actualizada
    }

}
