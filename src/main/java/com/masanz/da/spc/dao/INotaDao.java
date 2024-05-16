package com.masanz.da.spc.dao;

import com.masanz.da.spc.dto.Nota;

import java.util.List;

public interface INotaDao {

    int obtenerNumeroNotas();

    List<Nota> obtenerNotas(int pagina, int notasPorPagina);

    Nota obtenerNota(long idNota);

    Nota guardarNota(Nota nota);

    boolean actualizarNota(Nota nota);

    boolean eliminarNota(long idNota);

}
