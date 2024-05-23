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
                <input type="text" id="id" name="id" value="${reserva.id}" disabled="disabled" required="required"/>
            </div>
        </#if>
        <div>
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="nombre" value="${reserva.nombre}" required="required"/>
        </div>
        <div>
            <label for="turno">Turno</label>
            <select name="turno" id="turno">
                <option value="COMIDA" selected="selected">COMIDA</option>
                <option value="CENA">CENA</option>
            </select>
        </div>
        <br/>
        <div>
            <label for="numComensales">Numero de Comensales: </label>
            <input type="number" id="numComensales" name="numComensales" min="1"  value="${reserva.numComensales}" required="required"/>
        </div>
        <br/>
        <div>
            <label for="fecha">Fecha: </label>
            <input type="date" id="fecha" name="fecha" value="${reserva.fecha}" required="required"/>
        </div>
        <br/>
        <div>
            <label for="numeroTelefono">Numero de Telefono: </label>
            <input type="tel" pattern="[0-9]{9}" id="numeroTelefono" name="numeroTelefono" value="${reserva.numeroTelefono}" required="required"/>
        </div>
        <br/>


        <input type="submit" value="${texto}" />
    </form>

    <br/>

</#if>

</body>
</html>