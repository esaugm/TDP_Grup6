package ss1.service.filter;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 8/05/13
 * Time: 23:27
 * Clase de utilidad que contiene el objeto (String, Integer, Date, Boolean, ...) con el valor a filtrar y un int con la
 * posición que ocupa dicho objeto en la query.
 */
public class FilterTupla {

    private int queryPosition;
    private Object fieldToFilter;

    public FilterTupla(int queryPosition, Object fieldToFilter) {
        this.queryPosition = queryPosition;
        this.fieldToFilter = fieldToFilter;
    }

    public int getQueryPosition() {
        return queryPosition;
    }

    public Object getFieldToFilter() {
        return fieldToFilter;
    }
}
