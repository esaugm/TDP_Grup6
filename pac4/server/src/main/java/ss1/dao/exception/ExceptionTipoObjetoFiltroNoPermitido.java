package ss1.dao.exception;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 8/05/13
 * Time: 23:46
 * Exception lanzada cuando intentamos construir una query filtrando por tipo de Object que no está permitido respecto
 * a los atributos de la entidad que se trata
 */
public class ExceptionTipoObjetoFiltroNoPermitido extends Exception{
    public ExceptionTipoObjetoFiltroNoPermitido(String message) {
        super(message);
    }
}
