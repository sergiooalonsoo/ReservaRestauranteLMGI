package com.masanz.da.spc.dao;

import com.masanz.da.spc.database.ConnectionManager;
import com.masanz.da.spc.dto.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaDao {
    public Reserva obtenerLocal(long idReserva) {
        String sql = "SELECT id, nombre, turno, numComensales, fechaHora, numeroTelefono " +
                "FROM local " +
                "WHERE id = ? ";
        Object[] params = {idReserva};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        List<Reserva> reservas = new ArrayList<>();
        if (resultado != null && resultado.length == 1) {
            Reserva reserva = new Reserva();

            reserva.setId((int) resultado[0][0]);
            reserva.setNombre((String) resultado[0][1]);
            reserva.setTurno((String) resultado[0][2]);
            reserva.setNumComensales((int) resultado[0][2]);
            reserva.setFechaHora((String) resultado[0][3]);
            reserva.setNumeroTelefono((Integer) resultado[0][3]);

            return reserva;
        }
        return null;
    }
}
