/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao;

import java.rmi.Remote;
import java.util.ArrayList;
import ss2.entity.StockPeca;
import ss2.exception.AppException;

/**
 ***************************************
 * ss2.dao.impl IStockPecaDAO.java (windows-1252)
 * ************************************** Uoc Primavera 2013, Grup06 Fecha:
 * 2013.05.13 19:30:24
 *
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public interface IStockPecaDAO extends Remote {

    void checkAndInitDAO() throws AppException;

    Boolean createStockPecaRetBoolean(StockPeca stockpeca) throws AppException;

    Integer createStockPecaRetNumStockPeca(StockPeca stockpeca) throws AppException;

    StockPeca createStockPecaRetStockPeca(StockPeca stockpeca) throws AppException;

    Boolean deleteStockPeca(StockPeca stockpeca) throws AppException;

    ArrayList<StockPeca> getStockPeca(Integer idtaller) throws AppException;

    StockPeca getStockPecabyNumStockPeca(Integer numstockpeca, Integer idtaller) throws AppException;

    StockPeca getStockPecabyCodiPeca(Integer codipeca, Integer idtaller) throws AppException;

    public Integer getStockMinimbyNumStockPeca(Integer numstockpeca, Integer idtaller) throws AppException;

    public Integer getStockbyNumStockPeca(Integer numstockpeca, Integer idtaller) throws AppException;

    Boolean modifyStockPeca(StockPeca stockpeca) throws AppException;

    StockPeca modifyStockPecaRet(StockPeca stockpeca) throws AppException;
}
