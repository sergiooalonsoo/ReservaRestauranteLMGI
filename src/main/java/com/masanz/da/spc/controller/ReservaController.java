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
        List<Reserva> listaReservas =new ArrayList<>();
        listaReservas.add(new Reserva(1,"javier","CENA",4,"21-'03-2024",452));
        listaReservas.add(new Reserva(2,"Sergio","COMIDA",6,"24-'03-2024",452));
        listaReservas.add(new Reserva(3,"Simon","CENA",2,"21-'03-2024",452));
        listaReservas.add(new Reserva(4,"Robert","COMIDA",13,"21-'03-2024",452));

//        List<Reserva> listaMesas = reservaService.obtenerResrvas();
       model.put("reservas", listaReservas);
        return new ModelAndView(model, "lista-reservas.ftl");
    }

    public static ModelAndView servirReserva(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();

        int idReserva = Integer.parseInt(request.params(":id"));
        Reserva reserva = reservaService.obtenerReserva(idReserva);

//         COnsultar BD usuario con ese ID;
        System.out.println("SELECT LOCAL BD");
        Reserva reserva1 = new Reserva(idReserva, "nombre", "turno", 89, "2015-12-12", 89);

//        model.put("eliminar", false);
//        model.put("local", reserva);

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
        int numComensales = Integer.parseInt(request.queryParams("numcomensales"));
        String fecha = request.queryParams("fecha");
        int numeroTelefono = Integer.parseInt(request.queryParams("numeroTelefono"));
        Reserva reserva = new Reserva(nombre, turno, numComensales, fecha, numeroTelefono);

        System.out.println("INSERT RESERVA BD");
        System.out.println(reserva.toString());
        // Meter en la BD el usuario
        // obtener el ID del usuario

        response.redirect("/lista-reservas");

        return null;

//        reserva = reservaService.guardarReserva(reserva);
//        if (reserva.getId() != 0) {
//            response.redirect("/lista-reservas");
//            response.redirect("/reserva/" + reserva.getId());
//        }else {
//            response.redirect("/error");
//        }
//        return null;
    }
}

