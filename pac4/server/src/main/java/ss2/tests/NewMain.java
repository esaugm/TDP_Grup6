/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.tests;

import ss2.dao.ClientDAOImpl;
import ss2.dao.GestorClientInterface;
import ss2.beans.Client;
import java.util.ArrayList;
import java.util.Locale;
import ss2.exception.AppException;
import common.utils.TDSLanguageUtils;

/**
 *
 * @author josi
 */
public final class NewMain { //implements GestorClientInterface{

    //final ClientDAOImpl gestorClient;
    //final ArrayList <Client> lcliente;
    ArrayList<Client> lcliente;

    //final private ClientDAOImpl	gClient;
    public NewMain() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

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


        GestorClientInterface gClient = new ClientDAOImpl();
        try {
            ArrayList<Client> lcliente = gClient.getClient();
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        try {
            ArrayList<Client> lcliente = gClient.getClientbyPK("12465857");
            System.out.println(">>" + lcliente + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        try {
            Client cliente = gClient.getClientbyNC(24250);
            System.out.println(">>" + cliente + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }

    }
}
