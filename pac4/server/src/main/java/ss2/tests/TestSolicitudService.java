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
import ss2.dao.ISolicitudDAO;
import ss2.entity.Solicitud;

/**
 *
 * @author josi
 */
public final class TestSolicitudService { //implements ISolicitudDAO{

    //final SolicitudDAO gestorSolicitud;
    //final ArrayList <Solicitud> lsolicitud;


    //final private SolicitudDAO	gSolicitud;
    public TestSolicitudService() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

		ArrayList<Solicitud> lsolicitud;
		Solicitud solicitud, newsolicitud = null;

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


        ISolicitudDAO gSolicitud = new SolicitudDAO();

        try {
            gSolicitud.checkAndInitDAO();
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        System.out.println("++ getSolicitud()");
        try {
            lsolicitud = gSolicitud.getSolicitud();
            System.out.println(">>" + lsolicitud + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }



        System.out.println("++ gSolicitud.getSolicitudbyANY(\"fuita\")");
        try {
            lsolicitud = gSolicitud.getSolicitudbyANY("fuita");
            System.out.println(">>" + lsolicitud + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        // comentaris,client,numreparacio,asseguradora,numpoliza,idtaller
        newsolicitud = new Solicitud("blah", "45547465", -1, -1, "123", 1);
        Integer returnedsol;
        System.out.println("++ gSolicitud.createSolicitud(newsolicitud)");
        try {
            newsolicitud = gSolicitud.createSolicitudRetSolicitud(newsolicitud);
            //newsolicitud = gSolicitud.getSolicitudbyNumSolicitud(returnedsol);
            System.out.println(newsolicitud);
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        newsolicitud.setComentaris("modnom4");
        newsolicitud.setFinalitzada(true);
        try {
            System.out.println(gSolicitud.modifySolicitud(newsolicitud));
        } catch (AppException ex) {
            ex.printStackTrace();
        }


        try {
            System.out.println(gSolicitud.deleteSolicitud(newsolicitud));
        } catch (AppException ex) {
            ex.printStackTrace();
        }

		solicitud = new Solicitud();
		System.out.println("++ getSolicitudbyNumSolicitud(1)");
        try {
			solicitud = gSolicitud.getSolicitudbyNumSolicitud(1);
            System.out.println(">>" + solicitud + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }

		solicitud.setComentaris(solicitud.getComentaris()+" test");
		try {
            System.out.println(gSolicitud.modifySolicitud(solicitud));
        } catch (AppException ex) {
            ex.printStackTrace();
        }
		solicitud.setComentaris("Reparacio rapida");
		try {
            System.out.println(gSolicitud.modifySolicitud(solicitud));
        } catch (AppException ex) {
            ex.printStackTrace();
        }

    }
}
