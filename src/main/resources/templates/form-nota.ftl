<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if agregar>Crear Nota<#else>Editar Nota</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1><#if agregar>Crear Nota<#else>Editar Nota</#if></h1>
<a href="/lista-notas">Regresar al listado</a>
<br/><br/>

<#if mensajeError?has_content>
    <div class="error">${mensajeError}</div>
<#else>
    <#if agregar>
        <#assign accion>/crea-nota</#assign>
        <#assign texto>Crear</#assign>
    <#else>
        <#assign accion>${'/edita-nota/' + nota.id}</#assign>
        <#assign texto>Guardar</#assign>
    </#if>
    <form action="${accion}" method="POST">
        <div class="container">
            <div class="w75">
                <label for="titulo">Título</label>
                <input type="text" name="titulo" value="${nota.titulo}"/>
            </div>
            <div class="w25 center">
                <#if nota.id != 0>
                    <label for="id">ID</label>
                    <input type="text" name="id" value="${nota.id}" disabled="disabled"/>
                </#if>
            </div>
        </div>

        <label for="contenido">Contenido</label>
        <textarea name="contenido">${nota.contenido}</textarea>

        <#if nota.id != 0>
            <div class="container">
                <div class="w50 center">
                    <label for="creado">Creado</label>
                    <input type="text" name="creado" value="${nota.creado}" disabled="disabled"/>
                </div>
                <div class="w50 center">
                    <label for="creado">Actualizado</label>
                    <input type="text" name="creado" value="${nota.modificado}" disabled="disabled"/>
                </div>
            </div>
        </#if>

        <input type="submit" value="${texto}" />
    </form>

    <br/>

</#if>

</body>
</html>