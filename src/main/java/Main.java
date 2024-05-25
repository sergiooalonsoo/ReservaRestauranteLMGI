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
        get("/lista-reservas", ReservaController::servirLista, freeMarker);
        get("/reserva/:id", ReservaController::servirReserva, freeMarker);
        get("/reserva-con/:id", ReservaController::servirReservaCon, freeMarker);
        get("/crea-reserva", ReservaController::servirCrearReserva, freeMarker);
        post("/crea-reserva", ReservaController::crearReserva, freeMarker);
        get("/elimina-reserva/:id", ReservaController::servirEliminarReseva, freeMarker);
        post("/elimina-reserva/:id", ReservaController::eliminarReserva, freeMarker);
        get("/error", ReservaController::servirError, freeMarker);
//
        init();
//
    }
//
}