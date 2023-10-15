package cl.ucn.disc.as.model;


import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.Instant;


@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Pago {

    /**
     * The date of pay
     */
    @Getter
    @NotNull
    Instant fechaPago;

    /**
     * The amount
     */
    @Getter
    @NotNull
    int monto;
}
