/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.tests;

import ss2.dao.impl.SolicitudDAO;
import java.util.ArrayList;
import java.util.Locale;
import ss2.exception.AppException;
import common.utils.TDSLanguageUtils;
import java.util.Date;
import ss2.dao.ISolicitud;
import ss2.entity.Solicitud;

/**
 *
 * @author josi
 */
public final class TestSolicitudService { //implements ISolicitud{

    //final SolicitudDAO gestorSolicitud;
    //final ArrayList <Solicitud> lsolicitud;
    ArrayList<Solicitud> lsolicitud;

    //final private SolicitudDAO	gSolicitud;
    public TestSolicitudService() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            TDSLanguageUtils.setDefaultLanguage("conf/messages");
        }
        if (args.length == 1) {
            Locale locale = new Locale(args[0]);
            try {
                TDSLanguageUtils.setLanguage("conf/messages", locale);
            } catch (Exception ex) {
                //DialogException eOKd =
                //        new DialogException(null, true, "IO Exception", ex);
                //eOKd.setVisible(true);
            }
        }


        ISolicitud gSolicitud = new SolicitudDAO();

        try {
            gSolicitud.checkAndInitDAO();
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        try {
            ArrayList<Solicitud> lsolicitud = gSolicitud.getSolicitud();
            System.out.println(">>" + lsolicitud + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        try {
            Solicitud cliente = gSolicitud.getSolicitudbyNumSolicitud(1);
            System.out.println(">>" + cliente + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        try {
            ArrayList<Solicitud> lsolicitud = gSolicitud.getSolicitudbyANY("fuita");
            System.out.println(">>" + lsolicitud + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }


        Solicitud newsolicitud = new Solicitud("blah", "45547465", 0, 0, "123", 1);

        try {
            System.out.println(gSolicitud.createSolicitud(newsolicitud));
        } catch (AppException ex) {
            ex.printStackTrace();
        }

 //       newsolicitud.setnom("modnom4");
 //       newsolicitud.setcognoms("modcognom4");
 //       try {
 //           System.out.println(gSolicitud.modifySolicitud(newsolicitud));
 //       } catch (AppException ex) {
 //           ex.printStackTrace();
 //       }


  //      try {
  //          System.out.println(gSolicitud.deleteSolicitud(newsolicitud));
  //      } catch (AppException ex) {
  //          ex.printStackTrace();
  //      }
    }
}
