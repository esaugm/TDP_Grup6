/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.service.impl;

import ss2.service.IStockPiezasService;
import java.util.ArrayList;
import ss2.dao.IStockPecaDAO;
import ss2.dao.impl.StockPecaDAO;
import ss2.entity.StockPeca;
import ss2.exception.AppException;

/**
 ***************************************
 * ss2.service.impl StockPiezaService.java (UTF-8)
 * **************************************
 *
 * Uoc Primavera 2013, Grup06 Fecha: 2013.05.14 10:15:02
 *
 * @author jiquintana (José Ignacio Quintana)
 *
 */
public class StockPiezasService implements IStockPiezasService {

    IStockPecaDAO stockPiezaDAO;

    public StockPiezasService() throws AppException {
        this.stockPiezaDAO = new StockPecaDAO();
        this.stockPiezaDAO.checkAndInitDAO();
    }

    @Override
    public ArrayList<StockPeca> consultaStockPiezas(Integer idTaller) throws AppException {
        return stockPiezaDAO.getStockPeca(idTaller);
    }

    @Override
    public StockPeca consultaStockPiezabyCodigoPieza(Integer codigoPieza, Integer idTaller) throws AppException {
        return stockPiezaDAO.getStockPecabyCodiPeca(codigoPieza, idTaller);
    }

    @Override
    public StockPeca consultaStockPiezabyCodigoStockPieza(Integer codigoPieza, Integer idTaller) throws AppException {
        return stockPiezaDAO.getStockPecabyCodiPeca(codigoPieza, idTaller);
    }

    @Override
    public Integer modificaStockPieza_Stock(Integer codigoPieza, Integer idTaller, Integer incremento) throws AppException {
        Integer cantidad = stockPiezaDAO.getStockbyNumStockPeca(codigoPieza, idTaller);


        cantidad += incremento;

        cantidad = stockPiezaDAO.modifyStockPecaStock(codigoPieza, idTaller, cantidad);

        return cantidad;
    }

    @Override
    public Integer modificaStockPieza_StockMinimo(Integer codigoPieza, Integer idTaller, Integer incremento) throws AppException {
        Integer cantidad = stockPiezaDAO.getStockMinimbyNumStockPeca(codigoPieza, idTaller);


        cantidad += incremento;

        cantidad = stockPiezaDAO.modifyStockPecaStockMinim(codigoPieza, idTaller, cantidad);

        return cantidad;
    }
    /*
     public StockPeca modificaStockPieza(StockPeca stockPieza) throws AppException {
     StockPeca newstockPeca = new StockPeca();

     newstockPeca = consultaStockPiezabyCodigoStockPieza(
     stockPieza.getCodipeca(),
     stockPieza.getIdtaller());

     newstockPeca.setStock(stockPieza.getStock());
     newstockPeca.setStockminim(stockPieza.getStockminim());

     return stockPiezaDAO.modifyStockPecaRet(newstockPeca);
     }

     public StockPeca incrementaStockPieza(StockPeca stockPieza) throws AppException {



     return stockPiezaDAO.modifyStockPecaRet(newstockPeca);
     }
     /*
     Boolean createStockPecaRetBoolean(StockPeca stockpeca) throws AppException;
     Integer createStockPecaRetNumStockPeca(StockPeca stockpeca) throws AppException;
     StockPeca createStockPecaRetStockPeca(StockPeca stockpeca) throws AppException;
     Boolean deleteStockPeca(StockPeca stockpeca) throws AppException;
     ArrayList<StockPeca> getStockPeca(Integer idtaller) throws AppException;
     StockPeca getStockPecabyNumStockPeca(Integer numstockpeca, Integer idtaller) throws AppException;
     public Integer getStockMinimbyNumStockPeca(Integer numstockpeca, Integer idtaller) throws AppException;
     public Integer getStockbyNumStockPeca(Integer numstockpeca, Integer idtaller) throws AppException;
     Boolean modifyStockPeca(StockPeca stockpeca) throws AppException;
     */
}
