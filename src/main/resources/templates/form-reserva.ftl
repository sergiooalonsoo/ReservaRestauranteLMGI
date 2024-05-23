<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Crear Reserva</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Crear Reserva</h1>
<a href="/lista-reservas">Regresar al listado</a>
<br/><br/>

<#if mensajeError?has_content>
    <div class="error">${mensajeError}</div>
<#else>
    <#if agregar>
        <#assign accion>/crea-reserva</#assign>
        <#assign texto>Crear</#assign>
    </#if>
    <form action="${accion}" method="POST">
        <#if reserva.id != 0>
            <div>
                <label for="id">ID</label>
                <input type="text" id="id" name="id" value="${reserva.id}" disabled="disabled"/>
            </div>
        </#if>
        <div>
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="nombre" value="${reserva.nombre}"/>
        </div>
        <div>
            <label for="turno">Turno</label>
            <select name="turno" id="turno">
                <option value="COMIDA">COMIDA</option>
                <option value="CENA">CENA</option>
            </select>
        </div>
        <br/>
        <div>
            <label for="numComensales">Numero de Comensales: </label>
            <input type="text" id="numComensales" name="numComensales" value="${reserva.numComensales}"/>
        </div>
        <div>
            <label for="fecha">Fecha: </label>
            <input type="date" id="fecha" name="fecha" value="${reserva.fecha}"/>
        </div>
        <br/>
        <div>
            <label for="numeroTelefono">Numero de Telefono: </label>
            <input type="text" id="numeroTelefono" name="numeroTelefono" value="${reserva.numeroTelefono}"/>
        </div>


        <input type="submit" value="${texto}" />
    </form>

    <br/>

</#if>

</body>
</html>