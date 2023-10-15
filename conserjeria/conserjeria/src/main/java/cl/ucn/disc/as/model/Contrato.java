package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

@ToString
@AllArgsConstructor
@Builder
@Entity
public class Contrato extends BaseModel {

    /**
     *The Contador
     */
    @NotNull
    private Instant fechaPago;

    /**
     * the one who had to pay
     */
    @NotNull
    @Getter
    Persona persona;

    /**
     * the departem of Persona
     */
    @Getter
    @NotNull
    Departamento departamento;

    /**
     * List of Pays
     */
    @Getter
    ArrayList<Pago> listaPagos;

    /**
     *
     * @param fecha
     * @return diferences between the days of paid
     */
    public long diferenciaDeDias(Instant fecha) {
        Instant ahora = Instant.now();
        Duration diferencia = Duration.between(ahora, fecha);
        return diferencia.toMinutes();
    }
}
