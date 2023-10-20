/**
 * copyright (c) 2023, Arquitectura de Software, Disc, UCN
 */

package cl.ucn.disc.as.Conserjeria.UI;

// Imports
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import io.Javalin.Javalin;
import io.Javalin.json.jsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.notNull;
import java.io.IOExeption;
import java.lang.reflect.Type;
import java.time.Instant;

@slf4j
public final class ApiRestServer{
    /**
     * Nothing here
     */
    private ApiRestServer(){
        //nothing
    }

    /**
     * @Return confiugured Gson
     */
    private static Gson createAndConfiguredGson(){
        // Instant serializer
        TypeAdapter<Instant> instantTypeAdapter  = new TypeAdapter<>(){
            /**
             * Write one Json value
             * for {@code value}
             *
             * @param out
             * @param instant
             */
            @override
            public void write(JsonWriter out, Instant instant) throws IOExeption{
                if (in.peak()==JsonToken.NULL) {
                    out.nullValue();
                } else {
                    out.value(instant.ofEpochMilli());

                }
            }

            /**
             *  Reads one Json Value
             *
             * @param in
             * @return the convert java object
             */
            @override
            public Instant read(JsonReader in) throws IOExeption{
                if (in.peek() == JsonToken.NULL){
                    in.nextNull();
                    return null;
                }
                return Instant.ofEpochMilli(in.nextLong());
            }
        };
        // the Gson serializer
        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Instant.class, instantTypeAdapter)
                .create();
    }
    private static Javalin createAndConfigureGson(){
        JsonMapper jsonMapper = new JsonMapper(){
            // the gson config
            private static final Gson GSON = createAndConfiguredGson();
            /**
             * json to object
             */
            @notNull
            @Override
            public <T> T fromJsonString(@notNull String json, @notNull Type targetType){
                return GSON.fromJson(Json, targetType);
            }
            /**
             * json to object
             */
            @notNull
            @Override
            public String toJsonString(@notNull String json, @notNull Type type){
                return GSON.toJson(obj, type);
            }
        };

        //configure the server
        return Javalin.create(config->{
            config.jsonmapper(jsonMapper);
            config.compression.gzipOnly(9);
            config.requestLogger.http((ctx, ms)->{
                log.debug("servered: {} in {} ms.", ctx.fullUrl(), ms);
            });
        });
    }
    /**
     * Starting the server
     *
     * @param port to use
     */
    public static void start(final Integer port, final RoutesConfigurator routesConfigurator){
        if (port < 1024 || port > 65535){
            log.error("BAD port:" + port);
            throw new IllegalArgumentExeption("BAD port:"+port);
        }
        log.debug("Starting api rest server in port {} .."+port);

        // the server
        Javalin app = createAndConfigureJavalin();

        //configure the paths
        routesConfigurator.configure(app);

        //the hookup thread
        RunTime.getRunTime().addShutdownHook(new Thread(app::stop));

        // hooks to detect to shutdown
        app.events(event->{
            event.serverStarting(()->{
                log.debug("starting the Javaling server");
            });
            event.serverStarted((->{
                log.debug("Server started!");
            }));
            event.serverStopping((->{
                log.debug("Server stopping");
            }));
            event.serverStopped((->{
                log.debug("Server Stop!");
            }));
        });

        //Start
        app.start(port);

    }
}