package com.masanz.da.spc.service;

import com.masanz.da.spc.dao.ReservaDao;
import com.masanz.da.spc.dto.Reserva;

public class ReservaService {

    private ReservaDao reservaDao;
    public Reserva obtenerReserva(long idReserva) {
            return reservaDao.obtenerLocal(idReserva);

    }
}
