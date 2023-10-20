/*
* CopyRight (c) 2023. Arquitectura de Software, Disc, UCN
*/

package cl.ucn.disc.as.Conserjeria.UI;

import cl.ucn.disc.as.conserjeria.model.Persona;
import cl.ucn.disc.as.conserjeria.services.Sistema;
import cl.ucn.disc.as.conserjeria.services.SistemaImpl;
import io.ebean.DB;
import io.javalin.Javalin;
import io.javalin.http.NotFound.Response;

public final class WebController implements RouterConfigurator{

    /**
     * The Sistema
     */
    private final Sistema sistema;

    /**
     * the webController
     */
    public WebController() {
        this.sistema = new SistemaImpl(DB.getDefoult());
        // FIXME: only populate in case of new database
        this.sistema.populate();
    }

    @Override
    public void configure(final Javalin app) {
        app.get("/", ctx,->{
            ctx.results("Welcome to Conserjeria API REST")
        });
        app.get("/persona/rut/{rut}", ctx->{
           String rut = ctx.pathParam("rut");
           Optional<Persona> oPersona = this.sistema.getPersona(rut);
           ctx.json(oPersona.orElseThrow(()-> new NotFoundResponse("Can't find Persona with rut:"+ rut)));
        });
    }
}