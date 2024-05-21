package com.masanz.da.spc.service;

import com.masanz.da.spc.dao.ReservaDao;
import com.masanz.da.spc.dto.Reserva;

import java.util.List;

public class ReservaService {

    private ReservaDao reservaDao;
    public Reserva obtenerReserva(int idReserva) {
            return reservaDao.obtenerReserva(idReserva);
    }

    public boolean eliminarReserva(int idReserva) {
        return reservaDao.eliminarReserva(idReserva);
    }

    public List<Reserva> obtenerReservas() {
        return reservaDao.obtenerReservas();
    }
}
