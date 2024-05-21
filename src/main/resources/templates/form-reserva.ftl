<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if agregar>Crear Reservas<#else>Editar Reserva</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1><#if agregar>Crear Reserva<#else>Editar Reserva</#if></h1>
<a href="/lista-reservas">Regresar al listado</a>
<br/><br/>

<#if mensajeError?has_content>
    <div class="error">${mensajeError}</div>
<#else>
    <#if agregar>
        <#assign accion>/crea-reserva</#assign>
        <#assign texto>Crear</#assign>
    <#else>
        <#assign accion>${'/edita-reserva/' + reserva.id}</#assign>
        <#assign texto>Guardar</#assign>
    </#if>
    <form action="${accion}" method="POST">
        <div class="container">
            <div class="w75">
                <label for="titulo">Título</label>
                <input type="text" name="titulo" value="${reserva.titulo}"/>
            </div>
            <div class="w25 center">
                <#if reserva.id != 0>
                    <label for="id">ID</label>
                    <input type="text" name="id" value="${reserva.id}" disabled="disabled"/>
                </#if>
            </div>
        </div>

        <label for="contenido">Contenido</label>
        <textarea name="contenido">${nota.contenido}</textarea>

        <#if nota.id != 0>
            <div class="container">
                <div class="w50 center">
                    <label for="creado">Creado</label>
                    <input type="text" name="creado" value="${reserva.creado}" disabled="disabled"/>
                </div>
            </div>
        </#if>

        <input type="submit" value="${texto}" />
    </form>

    <br/>

</#if>

</body>
</html>