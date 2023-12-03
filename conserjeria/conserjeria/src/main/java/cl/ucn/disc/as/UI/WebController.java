/*
* CopyRight (c) 2023. Arquitectura de Software, Disc, UCN
*/

package cl.ucn.disc.as.UI;

import cl.ucn.disc.as.grpc.PersonaGrpc;
import cl.ucn.disc.as.grpc.PersonaGrpcRequest;
import cl.ucn.disc.as.grpc.PersonaGrpcResponse;
import cl.ucn.disc.as.grpc.PersonaGrpcServiceGrpc;
import cl.ucn.disc.as.model.Persona;
import cl.ucn.disc.as.services.Sistema;
import cl.ucn.disc.as.services.SistemaImpl;
import io.ebean.DB;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.Optional;



public final class WebController implements RoutesConfigurator {

    /**
     * The Sistema.
     */
    private final Sistema sistema;

    public WebController() {
        this.sistema = new SistemaImpl(DB.getDefault());
        // FIXME: Populate only on new database
        this.sistema.populate();
    }

    /**
     * Configure the routes.
     *
     * @param app to configure.
     */
    @Override
    public void configure(final Javalin app) {
        app.get("/", ctx -> {
            ctx.result("Welcome to Conserjería API REST");
        });

        app.get("/personas", ctx -> {
            ctx.json(this.sistema.getPersonas());
        });

        app.get("/personas/rut/{rut}", ctx -> {
            String rut = ctx.pathParam("rut");
            Optional<Persona> oPersona = this.sistema.getPersona(rut);
            ctx.json(oPersona.orElseThrow(() -> new NotFoundResponse("Can't find Persona with rut: " + rut)));
        });

        app.get("/grpc/personas/rut/{rut}", ctx -> {
            String rut = ctx.pathParam("rut");

            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("localhost", 50123)
                    .usePlaintext()
                    .build();

            PersonaGrpcServiceGrpc.PersonaGrpcServiceBlockingStub stub =
                    PersonaGrpcServiceGrpc.newBlockingStub(channel);

            PersonaGrpcResponse response = stub.retrieve(PersonaGrpcRequest
                    .newBuilder()
                    .setRut(rut)
                    .build());

            PersonaGrpc personaGrpc = response.getPersona();

            Optional<Persona> oPersona = Optional.of(Persona.builder()
                    .rut(personaGrpc.getRut())
                    .nombre(personaGrpc.getNombre())
                    .apellidos(personaGrpc.getApellidos())
                    .email(personaGrpc.getEmail())
                    .telefono(personaGrpc.getTelefono())
                    .build());
            ctx.json(oPersona.orElseThrow(() -> new NotFoundResponse("Can't find Persona with rut: " + rut)));
        });
    }
}