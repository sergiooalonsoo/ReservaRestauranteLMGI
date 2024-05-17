import com.masanz.da.spc.controller.ReservaController;
import freemarker.template.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("ARRANCANDO APLICACION");

        staticFileLocation("/public");
//        port(8080);

        FreeMarkerEngine freeMarker = new FreeMarkerEngine();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setClassForTemplateLoading(Main.class, "/templates");
        freeMarker.setConfiguration(configuration);

        get("/", ReservaController::servirIndice, freeMarker);
//        get("/lista-notas", NotaController::servirLista, freeMarker);
        get("/nota/:id", ReservaController::servirReserva, freeMarker);
//        get("/crea-nota", NotaController::servirCrearNota, freeMarker);
//        post("/crea-nota", NotaController::crearNota, freeMarker);
//        get("/edita-nota/:id", NotaController::servirEditarNota, freeMarker);
//        post("/edita-nota/:id", NotaController::editarNota, freeMarker);
//        get("/elimina-nota/:id", NotaController::servirEliminarNota, freeMarker);
//        post("/elimina-nota/:id", NotaController::eliminarNota, freeMarker);
//        get("/error", NotaController::servirError, freeMarker);
//
//        init();
//
    }
//
}