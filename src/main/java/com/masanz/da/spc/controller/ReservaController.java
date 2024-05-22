package com.masanz.da.spc.controller;

import com.masanz.da.spc.dto.Reserva;
import com.masanz.da.spc.service.ReservaService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservaController {

    private  static ReservaService reservaService = new ReservaService();
    public static ModelAndView servirIndice(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();
        model.put("titulo", "Reservas de Restaurante");
        model.put("encabezado", "Reservas de Restaurante");
        return new ModelAndView(model, "index.ftl");
    }


    public static ModelAndView servirLista(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();
//

        List<Reserva> listaReservas = reservaService.obtenerReservas();
        model.put("reservas", listaReservas);
        return new ModelAndView(model, "lista-reservas.ftl");
    }

    public static ModelAndView servirReserva(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();

        int idReserva = Integer.parseInt(request.params(":id"));
        Reserva reserva = reservaService.obtenerReserva(idReserva);


        model.put("eliminar", false);
        model.put("reserva", reserva);

        return new ModelAndView(model, "reserva.ftl");

    }

    public static ModelAndView servirCrearReserva(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();
        Reserva reserva = new Reserva();
        model.put("agregar", true);
        model.put("reserva", reserva);
        return new ModelAndView(model, "form-reserva.ftl");
    }


    public static ModelAndView crearReserva(Request request, Response response) {
        String nombre = request.queryParams("nombre");
        String turno = request.queryParams("turno");
        int numComensales = Integer.parseInt(request.queryParams("numComensales"));
        String fecha = request.queryParams("fecha");
        int numeroTelefono = Integer.parseInt(request.queryParams("numeroTelefono"));
        Reserva reserva = new Reserva(nombre, turno, numComensales, fecha, numeroTelefono);

        reserva = reservaService.guadarReserva(reserva);
        if (reserva.getId() != 0) {
//            response.redirect("/lista-reserva");
            response.redirect("/reserva/" + reserva.getId());
        }else {
            response.redirect("/error");
        }
        return null;
    }

    public static ModelAndView servirEliminarReseva(Request request, Response response) {
        int idReserva = Integer.parseInt((request.params(":id")));
        Map<String, Object> model = new HashMap<>();
        Reserva reserva = reservaService.obtenerReserva(idReserva);
        model.put("eliminar", true);
        model.put("reserva", reserva);
        if (reserva.getId() == 0) {
            model.put("mensajeError", "Reserva no encontrada");
        }
        return new ModelAndView(model, "reserva.ftl");
    }


    public static ModelAndView eliminarReserva(Request request, Response response) {
        int idReserva = Integer.parseInt(request.params(":id"));
        if (reservaService.eliminarReserva(idReserva)) {
            response.redirect("/lista-reservas");
        }else {
            response.redirect("/error");
        }
        return null;

    }
}

