package com.masanz.da.spc.service;

import com.masanz.da.spc.dao.ReservaDao;
import com.masanz.da.spc.dto.Reserva;

import java.util.List;

public class ReservaService {

    private ReservaDao reservaDao = new ReservaDao();
    public Reserva obtenerReserva(int idReserva) {
            return reservaDao.obtenerReserva(idReserva);
    }

    public boolean eliminarReserva(int idReserva, int numeroTelefono) {
        return reservaDao.eliminarReserva(idReserva,numeroTelefono);
    }

    public List<Reserva> obtenerReservas() {
        return reservaDao.obtenerReservas();
    }

    public Reserva guadarReserva(Reserva reserva) {
        return reservaDao.guardarReserva(reserva);
    }
}
