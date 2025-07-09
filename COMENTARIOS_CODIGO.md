# Documentación del Sistema de Empleados

## Estructura del Proyecto

### 1. Clase Principal - EmpleadosApplication.java
- **@SpringBootApplication**: Habilita auto-configuración, escaneo de componentes y configuración
- **main()**: Punto de entrada que inicia el contexto Spring Boot y servidor embebido

### 2. Modelo - Empleado.java
- **@Entity**: Marca la clase como entidad JPA para mapeo a tabla de BD
- **@Data**: Lombok genera getters, setters, equals, hashCode automáticamente
- **@Id + @GeneratedValue**: Clave primaria con auto-incremento
- **Campos**: idEmpleado, nombreEmpleado, departamento, sueldo

### 3. Repositorio - EmpleadoRepositorio.java
- **extends JpaRepository**: Proporciona métodos CRUD automáticos
- **No implementación necesaria**: Spring Data JPA lo hace automáticamente
- **Métodos incluidos**: findAll(), findById(), save(), delete(), etc.

### 4. Servicio - IEmpleadoServicio.java + EmpleadoServicio.java
- **Interfaz**: Define el contrato de servicios de negocio
- **@Service**: Marca la implementación como servicio Spring
- **@Autowired**: Inyección automática del repositorio
- **Métodos**: listar, buscar, guardar, eliminar empleados

### 5. Controlador - IndexControlador.java
- **@Controller**: Marca como controlador Spring MVC
- **@RequestMapping**: Mapea URLs a métodos
- **Métodos principales**:
  - `GET /`: Lista empleados (index.jsp)
  - `GET /agregar`: Muestra formulario (agregar.jsp)
  - `POST /agregar`: Procesa nuevo empleado
  - `GET /editar`: Muestra formulario con datos
  - `POST /editar`: Actualiza empleado
  - `GET /eliminar`: Elimina empleado (debería ser DELETE)

### 6. Vistas JSP

#### Archivos Comunes:
- **cabecero.jsp**: HTML head, Bootstrap CSS, librerías JSTL
- **navegacion.jsp**: Navbar Bootstrap responsiva
- **pie.jsp**: Bootstrap JavaScript, cierre HTML

#### Páginas Principales:
- **index.jsp**: Tabla de empleados con formateo de moneda
- **agregar.jsp**: Formulario para nuevo empleado

## Configuración - application.properties
- **Base de datos**: MySQL en localhost:3306
- **Context path**: `/empleados` (acceso: localhost:8080/empleados)
- **Vistas JSP**: Prefijo `/WEB-INF/jsp/`, sufijo `.jsp`
- **JPA**: Auto-creación de tablas, logs SQL habilitados

## Tecnologías Utilizadas
- **Spring Boot**: Framework principal
- **Spring MVC**: Controladores web
- **Spring Data JPA**: Acceso a datos
- **JSP + JSTL**: Vistas dinámicas
- **Bootstrap 5**: Estilos responsivos
- **MySQL**: Base de datos
- **Lombok**: Reducción de código boilerplate

## Patrones Implementados
- **MVC**: Separación Modelo-Vista-Controlador
- **Repository**: Abstracción de acceso a datos
- **Service Layer**: Lógica de negocio
- **Dependency Injection**: Inyección automática de dependencias
- **Post-Redirect-Get**: Evita reenvío accidental de formularios

## Problemas Identificados
1. **URLs inconsistentes**: Usar `pageContext.request.contextPath` en lugar de `application.contextPath`
2. **Método HTTP**: Eliminar debería usar DELETE en lugar de GET
3. **Validación**: Falta validación de datos en servidor
4. **Manejo de errores**: No hay manejo de excepciones