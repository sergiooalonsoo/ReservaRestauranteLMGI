<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Listado de Reservas</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Listado de Reservas</h1>
<div>
    <a class="btn" href="/">Volver al inicio</a>
    <a class="btn" href="/crea-reserva">Añadir Reserva</a>
</div>
<br/><br/>
<div>
    <table id="reservas">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Turno</th>
            <th>Numero Comensales</th>
            <th>Fecha</th>
            <th>Eliminar</th>
        </tr>
        <#list reservas as reserva>
            <tr>
                <td><a href="${'reserva/' + reserva.id}">${reserva.id}</a></td>
                <td>${reserva.nombre}</td>
                <td>${reserva.turno}</td>
                <td>${reserva.numComensales}</td>
                <td>${reserva.fecha}</td>
                <td><a href="${'elimina-reserva/' + reserva.id}">Borrar</a></td>
            </tr>
        </#list>
    </table>
</div>
<br/><br/>
</body>
</html>