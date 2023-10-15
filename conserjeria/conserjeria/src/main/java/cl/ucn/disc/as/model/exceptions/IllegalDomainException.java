package cl.ucn.disc.as.model.exceptions;

/**
 * Domain Violation Exception.
 *
 * @author Arquitectura de Sistemas
 */
public class IllegalDomainException extends RuntimeException {
    /**
     * The Constructor.
     *
     * @param message to use.
     */
    public IllegalDomainException(String message) {
        super (message);
    }
}
