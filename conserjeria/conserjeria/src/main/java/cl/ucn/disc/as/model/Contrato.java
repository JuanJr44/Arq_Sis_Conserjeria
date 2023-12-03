package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;

@ToString
@AllArgsConstructor
@Builder
@Entity
public class Contrato extends BaseModel {
    @NotNull
    private Instant fechaPago;

    // Persona que asociada al contrato
    @NotNull
    private Persona persona;

    // Departamento el asociado al contrato
    @NotNull
    private Departamento departamento;

    // Lista de pagos asociados al contrato
    private List<Pago> pagos;

    public Contrato(Persona persona, Departamento departamento, Instant fechaPago) {
        this.persona = persona;
        this.departamento = departamento;
        this.fechaPago = fechaPago;
    }

    public Instant getFechaPago() {
        return fechaPago;
    }

    public Persona getPersona() {
        return persona;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public List<Pago> getPagos() {
        return pagos;
    }
}
