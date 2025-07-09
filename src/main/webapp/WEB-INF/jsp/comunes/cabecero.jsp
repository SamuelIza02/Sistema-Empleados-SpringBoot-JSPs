<%-- Importa las librerías JSTL para usar etiquetas como <c:forEach>, <c:url> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Importa JSTL para formateo de números y fechas --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%-- Enlace a Bootstrap CSS desde CDN para estilos responsivos --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

    <title>Sistema de Empleados</title>
</head>
<body>
<%-- El contenido de la página se incluirá entre cabecero y pie --%>