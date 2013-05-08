package ss1.dao.exception;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 8/05/13
 * Time: 23:03
 * Exception que se lanza cuando se intenta hacer un cambio de contrasenya en un usuario pero la contrasenya antigua
 * no coincide con la que persiste en BD
 */
public class ExceptionContrasenyaIncorrecta extends Exception{

    public ExceptionContrasenyaIncorrecta(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionContrasenyaIncorrecta(String message) {
        super(message);
    }
}
