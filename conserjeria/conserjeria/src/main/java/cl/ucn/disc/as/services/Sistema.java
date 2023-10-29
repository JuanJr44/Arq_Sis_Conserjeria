package cl.ucn.disc.as.services;

import cl.ucn.disc.as.model.Edificio;
import cl.ucn.disc.as.model.Persona;
import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * System Operations
 *
 * @autor Arquitectura de sistemas
 */
public interface Sistema {
    /**
     * Agregar un edificio al sistema
     *
     * @param edificio a agregar
     */
   Edificio add(Edificio edificio);

   Persona add(Persona persona);
}
