package com.masanz.da.spc.dao;

import com.masanz.da.spc.database.ConnectionManager;
import com.masanz.da.spc.dto.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaDao {

    public Reserva obtenerReserva(long idReserva) {
        String sql = "SELECT id, nombre, turno, numComensales, fecha, numeroTelefono " +
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
            reserva.setFecha((String) resultado[0][3]);
            reserva.setNumeroTelefono((Integer) resultado[0][3]);

            return reserva;
        }
        return null;
    }

    public boolean eliminarReserva(long idReserva) {
        String sql = "DELETE FROM mesa WHERE id = ?";
        Object[] params = {idReserva};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
        return true;
    }

    public List<Reserva> obtenerReservas() {
        String sql = "SELECT id, nombre, turno, numComensales, fecha " +
                "FROM local " +
                "WHERE id = ? ";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        List<Reserva> reservas = new ArrayList<>();
        if (resultado != null) {
            for (Object[] fila : resultado) {
                Reserva reserva = new Reserva();
                reserva.setId((Integer) fila[0]);
                reserva.setNombre((String) fila[1]);
                reserva.setTurno((String) fila[2]);
                reserva.setNumComensales((Integer) fila[3]);
                reserva.setFecha((String) fila[3]);

                reservas.add(reserva);
            }

        }
        return reservas;
    }

//    public Reserva guardarReserva(Reserva reserva) {
//        String sql = "INSERT INTO local (nombre, turno, numComensales, fecha, numeroTelefono) " +
//                "VALUES (?, ?, ?, ?, ?)";
//        Object[] params = {reserva.getNombre(), reserva.getTurno(), reserva.getNumComensales(), reserva.getFecha(), reserva.getNumeroTelefono()};
//        int id = (int) ConnectionManager.ejecutarInsertSQL(sql, params);
//        if (id > 0){
//            reserva.setId(id);
//        }
//        return reserva;
//    }
}
