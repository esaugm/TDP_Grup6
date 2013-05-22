package ss1.service.filter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 18:59
 * Clase que contiene un HashMap<String, Object> donde el String es el nombre del campo de BD por el que tenemos que filtrar
 * y Object es el objeto (String, Integer, Date, Boolean, ...) que contiene el valor a filtrar
 */
public class FilterItems implements Serializable {
    private static final long serialVersionUID = 1L;

    private HashMap<String, Object> filterMap;

    public FilterItems() {
        filterMap = new HashMap<String, Object>();
    }
    
    public void addFilterValue(String pAttributeName, Object pValue){
        filterMap.put(pAttributeName,pValue);
    }
    
    public boolean isFilteringByAttribute(String pAttributeName){
        return filterMap.containsKey(pAttributeName);
    }
    
    public Object getFilterValueForAttribute(String pAttributeName){
        return filterMap.get(pAttributeName);
    }
    
    public Set<String> getAllAtributeNames(){
        return filterMap.keySet();
    }
    
    
}
