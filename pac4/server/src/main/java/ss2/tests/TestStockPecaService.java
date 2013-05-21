/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.tests;

import ss2.dao.impl.StockPecaDAO;
import ss2.dao.IStockPecaDAO;
import ss2.entity.StockPeca;
import java.util.ArrayList;
import java.util.Locale;
import ss2.exception.AppException;
import common.utils.TDSLanguageUtils;
import java.util.Date;

/**
 *
 * @author josi
 */
public final class TestStockPecaService { //implements IStockPecaDAO{

    //final StockPecaDAO gestorStockPeca;
    //final ArrayList <StockPeca> lstockpeca;
    ArrayList<StockPeca> lstockpeca;
    public static Integer IDTALLER = 1;

    //final private StockPecaDAO	gStockPeca;
    public TestStockPecaService() {
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


        IStockPecaDAO gStockPeca = new StockPecaDAO();


        try {
            gStockPeca.checkAndInitDAO();
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        try {
            ArrayList<StockPeca> lstockpeca = gStockPeca.getStockPeca(IDTALLER);
            System.out.println(">>" + lstockpeca + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        try {
            StockPeca stockpeca = gStockPeca.getStockPecabyNumStockPeca(1, IDTALLER);
            System.out.println(">>" + stockpeca + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        Integer cantidad = 0;

        System.out.println("##########");

        try {
            cantidad = gStockPeca.getStockbyPieza(1, IDTALLER);
            System.out.println(">>" + cantidad + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }
        System.out.println("##########");
        try {
            cantidad = gStockPeca.modifyStockPecaStock(1, IDTALLER, cantidad + 1);
            System.out.println(">>" + cantidad + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }
        try {
            cantidad = gStockPeca.modifyStockPecaStock(1, IDTALLER, cantidad - 1);
            System.out.println(">>" + cantidad + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }

        try {
            cantidad = gStockPeca.getStockMinimbyNumStockPeca(1, IDTALLER);
            System.out.println(">>" + cantidad + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }
        System.out.println("##########");
        try {
            cantidad = gStockPeca.modifyStockPecaStockMinim(1, IDTALLER, cantidad + 1);
            System.out.println(">>" + cantidad + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }
        try {
            cantidad = gStockPeca.modifyStockPecaStockMinim(1, IDTALLER, cantidad - 1);
            System.out.println(">>" + cantidad + "<<");
        } catch (AppException ex) {
            ex.printStackTrace();
        }
        System.out.println("##########");

        StockPeca newstockpeca = new StockPeca(2, 40, IDTALLER, 8);

        try {
            newstockpeca = gStockPeca.createStockPecaRetStockPeca(newstockpeca);
            System.out.println(newstockpeca);

        } catch (AppException ex) {
            ex.printStackTrace();
        }

        newstockpeca.setStock(42);
        try {
            System.out.println(gStockPeca.modifyStockPeca(newstockpeca));
        } catch (AppException ex) {
            ex.printStackTrace();
        }


        try {
            System.out.println(gStockPeca.deleteStockPeca(newstockpeca));
        } catch (AppException ex) {
            ex.printStackTrace();
        }
    }
}
