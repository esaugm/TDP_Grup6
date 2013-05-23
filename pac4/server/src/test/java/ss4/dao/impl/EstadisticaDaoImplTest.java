package ss4.dao.impl;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 23/05/13
 * Time: 10:12
 * To change this template use File | Settings | File Templates.
 */
public class EstadisticaDaoImplTest {
    EstadisticaDaoImpl dao = new EstadisticaDaoImpl();

    @Test
    public void testFindReparacionesByTerms() throws Exception {
        Map values = new LinkedHashMap();

        dao.findReparacionesByTerms(values);
    }
    @Test
    public void testFindReparacionesByTermsCliente() throws Exception{
        Map values = new LinkedHashMap();
        dao.findReparacionesByTermsClientes(values);
    }

}
