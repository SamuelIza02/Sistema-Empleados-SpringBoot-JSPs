<%-- Configuración de URLs de la aplicación usando JSTL --%>
<%-- NOTA: Debería usar pageContext.request.contextPath en lugar de application.contextPath --%>
 <c:set var="urlInicio">
    <c:url value="${application.contextPath}/" />
 </c:set>

 <c:set var="urlAgregar">
    <c:url value="${application.contextPath}/agregar" />
 </c:set>

<%-- Barra de navegación Bootstrap responsiva --%>
<div class="container">
    <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
        <div class="container-fluid">
            <%-- Logo/Título de la aplicación --%>
            <a class="navbar-brand" href="${urlInicio}">Sistema de Empleados</a>
            
            <%-- Botón hamburguesa para dispositivos móviles --%>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNav" aria-controls="navbarNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <%-- Menú de navegación colapsable --%>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${urlInicio}">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${urlAgregar}">Agregar Empleado</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>