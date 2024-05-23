package com.masanz.da.spc.dao;

import com.masanz.da.spc.database.ConnectionManager;
import com.masanz.da.spc.dto.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaDao {
    public ReservaDao(){
        ConnectionManager.conectar(
                "reservas_db",
                "proy",
                "password");
    }

    public Reserva obtenerReserva(long idReserva) {
        String sql = "SELECT id, nombre, turno, numComensales, fecha " +
                "FROM reserva " +
                "WHERE id = ? ";
        Object[] params = {idReserva};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        List<Reserva> reservas = new ArrayList<>();
        if (resultado != null && resultado.length == 1) {
            Reserva reserva = new Reserva();
            int id = (int)((long)((Long)resultado[0][0]));
            reserva.setId(id);
            reserva.setNombre((String) resultado[0][1]);
            reserva.setTurno((String) resultado[0][2]);
            reserva.setNumComensales((int) resultado[0][3]);
            reserva.setFecha((String) resultado[0][4]);

            return reserva;
        }
        return null;
    }

    public boolean eliminarReserva(int idReserva) {
        String sql = "DELETE FROM reserva WHERE id = ?";
        Object[] params = {idReserva};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
        return true;
    }

    public List<Reserva> obtenerReservas() {
        String sql = "SELECT id, nombre, turno, numComensales, fecha " +
                "FROM reserva " +
                "ORDER BY id DESC ";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        List<Reserva> reservas = new ArrayList<>();
        if (resultado != null) {
            for (Object[] fila : resultado) {
                Reserva reserva = new Reserva();
                int id = (int)((long)((Long)fila[0]));
                reserva.setId(id);
                reserva.setNombre((String) fila[1]);
                reserva.setTurno((String) fila[2]);
                reserva.setNumComensales((Integer) fila[3]);
                reserva.setFecha((String) fila[4]);

                reservas.add(reserva);
            }

        }
        return reservas;
    }


    public Reserva guardarReserva(Reserva reserva) {
        String sql = "INSERT INTO reserva (nombre, turno, numComensales, fecha, numeroTelefono) " +
                "VALUES (?, ?, ?, ?, ?)";
        Object[] params = {
                reserva.getNombre(),
                reserva.getTurno(),
                reserva.getNumComensales(),
                reserva.getFecha(),
                reserva.getNumeroTelefono()};
        int id = (int) ConnectionManager.ejecutarInsertSQL(sql, params);
        if (id > 0){
            reserva.setId(id);
        }
        return reserva;
    }
}
