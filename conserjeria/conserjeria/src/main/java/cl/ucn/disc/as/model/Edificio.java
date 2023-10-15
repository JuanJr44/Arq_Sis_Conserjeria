package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.ArrayList;

/**
 * Class Edificio
 *
 * @autor Arquitectura de sistemas
 */

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Edificio extends BaseModel {

    /**
     * The Name
     */
    @Getter
    @NotNull
    private String nombre;

    /**
     * The direction
     */
    @Getter
    @NotNull
    private String direccion;

    /**
     * The list of apartment
     */
    ArrayList<Departamento> lista;

}