package cl.ucn.disc.as.model;


import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.Instant;


@ToString(callSuper = true)
//@AllArgsConstructor
//@Builder
@Entity
public class Pago extends BaseModel{
    @NotNull
    private Instant fechaPago;

    @NotNull
    private Integer monto;

    public Pago(Instant fechaPago, Integer monto) {
        this.fechaPago = fechaPago;
        this.monto = monto;
    }

    public Instant getFechaPago() {
        return fechaPago;
    }

    public Integer getMonto() {
        return monto;
    }
}
