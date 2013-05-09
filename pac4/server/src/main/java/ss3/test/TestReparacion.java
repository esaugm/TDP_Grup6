/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.test;

import java.util.ArrayList;
import java.util.Locale;
import ss2.exception.AppException;
import common.utils.TDSLanguageUtils;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Reparacion;
import ss3.service.ReparacionService;
import ss3.service.impl.ReparacionServiceImpl;

/**
 *
 * @author Fernando Gomez
 */
public final class TestReparacion { 

    ArrayList<Reparacion> lreparacion;

    //final private ClientService	gClient;
    public TestReparacion() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionErrorDataBase {
        // TODO code application logic here

        if (args.length == 0) {
            TDSLanguageUtils.setDefaultLanguage("conf/messages");
        }
        if (args.length == 1) {
            Locale locale = new Locale(args[0]);
            try {
                TDSLanguageUtils.setLanguage("conf/messages", locale);
            } catch (Exception ex) {
                
            }
        }

        System.out.println("Obteniendo datos de reparaci�n. Consulta por Orden: \n");
        ReparacionService gReparacion1 = new ReparacionServiceImpl();
        Reparacion reparacion = gReparacion1.ConsultaOrden(1);
        System.out.println(">>" + reparacion + "<<\n");
        
        
        System.out.println("\nObteniendo datos de reparaci�n. Consulta por Orden: \n");
        ReparacionService gReparacion2 = new ReparacionServiceImpl();
        ArrayList<Reparacion> reparaciones = gReparacion2.ConsultaFechaAsig("2013-03-02");
        Iterator it = reparaciones.iterator();
        if (!it.hasNext())
            System.out.println("No hay datos.");
        while (it.hasNext())
            System.out.println(">>" + it.next() + "<<");
        
        

    }
}
