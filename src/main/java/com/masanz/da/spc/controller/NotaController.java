package com.masanz.da.spc.controller;

import com.masanz.da.spc.dto.Nota;
import com.masanz.da.spc.service.NotaService;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class NotaController {

    private static final int NOTAS_POR_PAGINA = 5;

    private static NotaService notaService = new NotaService();


    public static ModelAndView servirIndice(Request request, Response response){
        Map<String, Object> model = new HashMap<>();
        model.put("titulo", "Notas");
        model.put("encabezado", "Ejemplo CRUD con Spark y FreeMarker");
        return new ModelAndView(model, "index.ftl");
    }

    public static ModelAndView servirLista(Request request, Response response){
        Map<String, Object> model = new HashMap<>();
        Integer numeroPagina = 1;
        try {
            numeroPagina = Integer.parseInt(request.queryParams("pagina"));
        } catch (NumberFormatException e) { }
        int numeroNotas = notaService.obtenerNumeroNotas();
        Boolean tieneAnterior = numeroPagina > 1;
        Boolean tieneSiguiente = (numeroPagina * NOTAS_POR_PAGINA) < numeroNotas;

        model.put("numeroPagina", numeroPagina);
        model.put("tieneAnterior", tieneAnterior);
        model.put("paginaAnterior", numeroPagina - 1);
        model.put("tieneSiguiente", tieneSiguiente);
        model.put("paginaSiguiente", numeroPagina + 1);

        model.put("notas", notaService.obtenerNotas(numeroPagina, NOTAS_POR_PAGINA));

        return new ModelAndView(model, "lista-notas.ftl");
    }

    public static ModelAndView servirNota(Request request, Response response){
        int idNota = Integer.parseInt(request.params(":id"));
        Map<String, Object> model = new HashMap<>();
        Nota nota = notaService.obtenerNota(idNota);
        model.put("eliminar", false);
        model.put("nota", nota);
        if (nota.getId() == 0) {
            model.put("mensajeError", "Nota no encontrada");
        }
        return new ModelAndView(model, "nota.ftl");
    }

    public static ModelAndView servirCrearNota(Request request, Response response){
        Map<String, Object> model = new HashMap<>();
        Nota nota = new Nota();
        model.put("agregar", true);
        model.put("nota", nota);
        return new ModelAndView(model, "form-nota.ftl");
    }

    public static ModelAndView crearNota(Request request, Response response){
        String titulo = request.queryParams("titulo");
        String contenido = request.queryParams("contenido");
        Nota nota = new Nota(titulo, contenido);
        nota = notaService.guardarNota(nota);
        if (nota.getId() != 0) {
            response.redirect("/lista-notas");
//            response.redirect("/nota/" + nota.getId());
        }else {
            response.redirect("/error");
        }
        return null;
    }

    public static ModelAndView servirEditarNota(Request request, Response response){
        int idNota = Integer.parseInt(request.params(":id"));
        Map<String, Object> model = new HashMap<>();
        Nota nota = notaService.obtenerNota(idNota);
        model.put("agregar", false);
        model.put("nota", nota);
        if (nota.getId() == 0) {
            model.put("mensajeError", "Nota no encontrada");
        }
        return new ModelAndView(model, "form-nota.ftl");
    }

    public static ModelAndView editarNota(Request request, Response response){
        int idNota = Integer.parseInt(request.params(":id"));
        String titulo = request.queryParams("titulo");
        String contenido = request.queryParams("contenido");
        Nota nota = new Nota((long) idNota, titulo, contenido);
        if (notaService.actualizarNota(nota)) {
            response.redirect("/nota/" + nota.getId());
        }else {
            response.redirect("/error");
        }
        return null;
    }

    public static ModelAndView servirEliminarNota(Request request, Response response){
        int idNota = Integer.parseInt(request.params(":id"));
        Map<String, Object> model = new HashMap<>();
        Nota nota = notaService.obtenerNota(idNota);
        model.put("eliminar", true);
        model.put("nota", nota);
        if (nota.getId() == 0) {
            model.put("mensajeError", "Nota no encontrada");
        }
        return new ModelAndView(model, "nota.ftl");
    }

    public static ModelAndView eliminarNota(Request request, Response response){
        int idNota = Integer.parseInt(request.params(":id"));
        if (notaService.eliminarNota(idNota)) {
            response.redirect("/lista-notas");
        }else {
            response.redirect("/error");
        }
        return null;
    }

    public static ModelAndView servirError(Request request, Response response){
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "error.ftl");
    }

}