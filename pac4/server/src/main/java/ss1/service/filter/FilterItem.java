package ss1.service.filter;

import java.util.HashMap;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 18:59
 */
public class FilterItem {
    
    private HashMap<String, String> filterMap;

    public FilterItem() {
        filterMap = new HashMap<String, String>();
    }
    
    public void addFilterValue(String pAttributeName, String pValue){
        filterMap.put(pAttributeName,pValue);
    }
    
    public boolean isFilteringByAttribute(String pAttributeName){
        return filterMap.containsKey(pAttributeName);
    }
    
    public String getFilterValueForAttribute(String pAttributeName){
        return filterMap.get(pAttributeName);
    }
}
