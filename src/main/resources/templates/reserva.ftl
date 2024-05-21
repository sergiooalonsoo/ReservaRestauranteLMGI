<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Reserva</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<#if eliminar>
    <h1>Eliminar la Reserva</h1>
<#else>
    <h1>Vista de la Reserva</h1>
</#if>
<a href="/lista-reservas">Volver a la lista</a>
<br/><br/>
<#if mensajeError?has_content>
    <div class="error">${mensajeError}</div>
<#else>
    <table id="reservas">
        <tr>
            <th>ID</th>
            <td>${reserva.id}</td>
        </tr>
        <tr>
            <th>Nombre</th>
            <td>${reserva.nombre}</td>
        </tr>
        <tr>
            <th>Turno</th>
            <td>${reserva.turno}</td>
        </tr>
        <tr>
            <th>Numero de Comensales</th>
            <td>${reserva.numComensales}</td>
        </tr>
        <tr>
            <th>Fecha</th>
            <td>${reserva.fecha}</td>
        </tr>
        <tr>
            <th>Creado</th>
            <td>${reserva.creado}</td>
        </tr>
    </table>
    <br/><br/>

    <#if eliminar>
        <form action="${'/elimina-reserva/' + reserva.id}" method="POST">
            ¿Seguro que desea eliminar la reserva? <input type="submit" value="Confirmar" />
        </form>
    <#else>
        <div>
            <a href="${'/elimina-reserva/' + reserva.id}">Eliminar</a>
        </div>
    </#if>

</#if>
</body>
</html>