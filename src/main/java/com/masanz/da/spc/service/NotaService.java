package com.masanz.da.spc.service;

import com.masanz.da.spc.dao.INotaDao;
import com.masanz.da.spc.dao.NotaDaoDb;
import com.masanz.da.spc.dto.Nota;

import java.util.List;

public class NotaService {

    private INotaDao notaDao;

    public NotaService(){
//        notaDao = new NotaDaoMap();
        notaDao = new NotaDaoDb();
    }

    public int obtenerNumeroNotas() {
        return notaDao.obtenerNumeroNotas();
    }

    public List<Nota> obtenerNotas(int pagina, int notasPorPagina) {
        return notaDao.obtenerNotas(pagina, notasPorPagina);
    }

    public Nota obtenerNota(long idNota) {
        return notaDao.obtenerNota(idNota);
    }

    public Nota guardarNota(Nota nota) {
        return notaDao.guardarNota(nota);
    }

    public boolean actualizarNota(Nota nota) {
        return notaDao.actualizarNota(nota);
    }

    public boolean eliminarNota(int idNota) {
        return notaDao.eliminarNota(idNota);
    }

}
