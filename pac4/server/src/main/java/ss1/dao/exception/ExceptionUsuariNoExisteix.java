package ss1.dao.exception;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 12/05/13
 * Time: 13:29
 */
public class ExceptionUsuariNoExisteix extends Exception{
    public ExceptionUsuariNoExisteix(String message) {
        super(message);
    }

    public ExceptionUsuariNoExisteix(String message, Throwable cause) {
        super(message, cause);
    }
}
