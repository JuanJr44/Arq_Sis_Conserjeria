package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;

@ToString
@AllArgsConstructor
@Builder
@Entity
public class Departamento extends BaseModel  {
    private Integer numero;
    private Integer piso;

    public Departamento(Integer numero, Integer piso) {
        this.numero = numero;
        this.piso = piso;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getPiso() {
        return piso;
    }
}
