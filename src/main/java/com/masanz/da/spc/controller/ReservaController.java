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

}

