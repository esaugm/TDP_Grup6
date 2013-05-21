
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao.impl;

//~--- non-JDK imports --------------------------------------------------------
import ss2.dao.IStockPecaDAO;
import common.dao.impl.GenericDaoImpl;

import common.utils.ConnectionFactory;

//import ss2.dao.IStockPecaDAO;

import ss2.entity.StockPeca;

import ss2.exception.AppException;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * StockPecaDAO.java (UTF8)
 *
 * Uoc Primavera 2013, Grup06 Fecha: 2013.05.09 21:56:32
 *
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class StockPecaDAO extends GenericDaoImpl implements IStockPecaDAO {

    public StockPecaDAO() {
    }

    @Override
    public void checkAndInitDAO() throws AppException {
        checkSequence("stockpeca_id_seq");
    }

    private void checkSequence(String sequenceName) throws AppException {
        String SQL1 = "SELECT * from " + sequenceName;
        String SQL2 = "CREATE SEQUENCE " + sequenceName + " start 4";
        Boolean wasconnected = false;
        Boolean sequenceexists = false;
        Integer result;
        StockPeca stockpeca = new StockPeca();

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL1);
            resultSet = ptmt.executeQuery();
        } catch (ClassNotFoundException ex) {
        } catch (IOException ex) {
        } catch (SQLException ex) {
            if (wasconnected && !sequenceexists) {

                // No existe la secuencia => la creamos
                try {
                    ptmt = connection.prepareStatement(SQL2);
                    ptmt.executeUpdate();
                } catch (SQLException ex2) {

                    // no hemos podido crear la secuencia => throw
                    throw new AppException(ex2);
                }
            } else {
                // la secuencia ya existe => do nothing
            }
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }
    }

    @Override
    public ArrayList<StockPeca> getStockPeca(Integer idtaller) throws AppException {
        String SQL = "SELECT * from stockpeca where idtaller = ?";
        ArrayList<StockPeca> listastockpeca = new ArrayList<StockPeca>();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, idtaller);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {

                StockPeca stockpeca = new StockPeca(
                    resultSet.getInt("idstockpeca"),
                    resultSet.getInt("codipeca"),
                    resultSet.getInt("stock"),
                    resultSet.getInt("idtaller"),
                    resultSet.getInt("stockminim"));
                listastockpeca.add(stockpeca);
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return listastockpeca;
    }

    @Override
    public StockPeca getStockPecabyNumStockPeca(Integer numstockpeca, Integer idtaller) throws AppException {
        String SQL = "SELECT * from stockpeca where idstockpeca = ? and idtaller = ?";
        StockPeca stockpeca = new StockPeca();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, numstockpeca);
            ptmt.setInt(2, idtaller);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                stockpeca = new StockPeca(
                    resultSet.getInt("idstockpeca"),
                    resultSet.getInt("codipeca"),
                    resultSet.getInt("stock"),
                    resultSet.getInt("idtaller"),
                    resultSet.getInt("stockminim"));
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return stockpeca;
    }

    @Override
    public StockPeca getStockPecabyCodiPeca(Integer codipeca, Integer idtaller) throws AppException {
        String SQL = "SELECT * from stockpeca where codipeca = ? and idtaller = ?";
        StockPeca stockpeca = new StockPeca();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, codipeca);
            ptmt.setInt(2, idtaller);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                stockpeca = new StockPeca(
                    resultSet.getInt("idstockpeca"),
                    resultSet.getInt("codipeca"),
                    resultSet.getInt("stock"),
                    resultSet.getInt("idtaller"),
                    resultSet.getInt("stockminim"));
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return stockpeca;
    }

    @Override
    public Integer getStockbyNumStockPeca(Integer numstockpeca, Integer idtaller) throws AppException {
        String SQL = "SELECT stock from stockpeca where idstockpeca = ? and idtaller = ?";
        Integer stock = StockPeca.STOCK_PECA_UNDEF;

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, numstockpeca);
            ptmt.setInt(2, idtaller);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                stock = resultSet.getInt("stock");
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return stock;
    }

    @Override
    public Integer getStockMinimbyNumStockPeca(Integer numstockpeca, Integer idtaller) throws AppException {
        String SQL = "SELECT stockminim from stockpeca where idstockpeca = ? and idtaller = ?";
        Integer stockminim = StockPeca.STOCK_PECA_UNDEF;

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, numstockpeca);
            ptmt.setInt(2, idtaller);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                stockminim = resultSet.getInt("stockminim");
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return stockminim;
    }

    @Override
    public Integer getStockbyPieza(Integer idpieza, Integer idtaller) throws AppException {
        String SQL = "SELECT stock from stockpeca where codipeca = ? and idtaller = ?";
        Integer stock = StockPeca.STOCK_PECA_UNDEF;

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, idpieza);
            ptmt.setInt(2, idtaller);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                stock = resultSet.getInt("stock");
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return stock;
    }

    @Override
    public Integer getStockMinimbyPieza(Integer idpieza, Integer idtaller) throws AppException {
        String SQL = "SELECT stockminim from stockpeca where codipeca = ? and idtaller = ?";
        Integer stockminim = StockPeca.STOCK_PECA_UNDEF;

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, idpieza);
            ptmt.setInt(2, idtaller);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                stockminim = resultSet.getInt("stockminim");
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return stockminim;
    }

    @Override
    public Boolean createStockPecaRetBoolean(StockPeca stockpeca) throws AppException {
        Boolean succeded = false;
        Boolean wasconnected = false;
        String SQL = "INSERT INTO stockpeca "
            + "(codipeca,stock,idtaller,stockminim) "
            + "VALUES (?,?,?,?)";

        if (!modifyStockPeca(stockpeca)) {
            try {
                connection = getConnection();
                wasconnected = true;
                ptmt = connection.prepareStatement(SQL);
                ptmt.setInt(1, stockpeca.getCodipeca());
                ptmt.setInt(2, stockpeca.getStock());
                ptmt.setInt(3, stockpeca.getIdtaller());
                ptmt.setInt(4, stockpeca.getStockminim());

                if (ptmt.executeUpdate() > 0) {
                    succeded = true;
                } else {
                    System.err.println(ptmt.getWarnings());
                }
            } catch (ClassNotFoundException ex) {
                throw new AppException(ex);
            } catch (IOException ex) {
                throw new AppException(ex);
            } catch (SQLException ex) {
                if (!wasconnected) {
                    throw new AppException(ex);
                }
            } finally {
                ConnectionFactory.freeResources(connection, ptmt, resultSet);
            }
        }
        return succeded;
    }

    @Override
    public Integer createStockPecaRetNumStockPeca(StockPeca stockpeca) throws AppException {
        Boolean succeded = false;
        Boolean wasconnected = false;
        //StockPeca stockpeca;
        Integer numstockpeca = new Integer(0);

        String SQL = "INSERT INTO stockpeca "
            + "(codipeca,stock,idtaller,stockminim) "
            + "VALUES (?,?,?,?) returning idstockpeca";

        if (!modifyStockPeca(stockpeca)) {
            try {
                connection = getConnection();
                wasconnected = true;
                ptmt = connection.prepareStatement(SQL);

                ptmt.setInt(1, stockpeca.getCodipeca());
                ptmt.setInt(2, stockpeca.getStock());
                ptmt.setInt(3, stockpeca.getIdtaller());
                ptmt.setInt(4, stockpeca.getStockminim());

                resultSet = ptmt.executeQuery();
                while (resultSet.next()) {
                    numstockpeca = resultSet.getInt("idstockpeca");
                }

            } catch (ClassNotFoundException ex) {
                throw new AppException(ex);
            } catch (IOException ex) {
                throw new AppException(ex);
            } catch (SQLException ex) {
                if (!wasconnected) {
                    throw new AppException(ex);
                }
            } finally {
                ConnectionFactory.freeResources(connection, ptmt, resultSet);
            }
        } else {
            numstockpeca =
                getStockPecabyNumStockPeca(stockpeca.getCodipeca(), stockpeca.getIdtaller()).getIdstockpeca();
        }

        return numstockpeca;
    }

    @Override
    public StockPeca createStockPecaRetStockPeca(StockPeca stockpeca) throws AppException {
        Boolean succeded = false;
        Boolean wasconnected = false;
        //StockPeca stockpeca;

        String SQL = "INSERT INTO stockpeca "
            + "(codipeca,stock,idtaller,stockminim) "
            + "VALUES (?,?,?,?) returning *";

        if (!modifyStockPeca(stockpeca)) {
            try {
                connection = getConnection();
                wasconnected = true;
                ptmt = connection.prepareStatement(SQL);
                ptmt.setInt(1, stockpeca.getCodipeca());
                ptmt.setInt(2, stockpeca.getStock());
                ptmt.setInt(3, stockpeca.getIdtaller());
                ptmt.setInt(4, stockpeca.getStockminim());

                resultSet = ptmt.executeQuery();
                while (resultSet.next()) {
                    stockpeca = new StockPeca(
                        resultSet.getInt("idstockpeca"),
                        resultSet.getInt("codipeca"),
                        resultSet.getInt("stock"),
                        resultSet.getInt("idtaller"),
                        resultSet.getInt("stockminim"));
                }

            } catch (ClassNotFoundException ex) {
                throw new AppException(ex);
            } catch (IOException ex) {
                throw new AppException(ex);
            } catch (SQLException ex) {
                if (!wasconnected) {
                    throw new AppException(ex);
                }
            } finally {
                ConnectionFactory.freeResources(connection, ptmt, resultSet);
            }
        } else {
            stockpeca =
                getStockPecabyNumStockPeca(stockpeca.getCodipeca(), stockpeca.getIdtaller());
        }

        return stockpeca;
    }

    @Override
    public Boolean modifyStockPeca(StockPeca stockpeca) throws AppException {
        Integer rowsmodified;
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE stockpeca SET stock = ?, stockminim  = ? where codipeca = ? and idtaller = ? ";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, stockpeca.getStock());
            ptmt.setInt(2, stockpeca.getStockminim());
            ptmt.setInt(3, stockpeca.getCodipeca());
            ptmt.setInt(4, stockpeca.getIdtaller());

            if (ptmt.executeUpdate() > 0) {
                succeded = true;
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            if (!wasconnected) {
                throw new AppException(ex);
            }
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return succeded;
    }

    @Override
    public StockPeca modifyStockPecaRet(StockPeca stockpeca) throws AppException {
        Integer rowsmodified;
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE stockpeca SET stock = ?, stockminim  = ? where codipeca = ? and idtaller = ? returning *";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, stockpeca.getStock());
            ptmt.setInt(2, stockpeca.getStockminim());
            ptmt.setInt(3, stockpeca.getCodipeca());
            ptmt.setInt(4, stockpeca.getIdtaller());


            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                stockpeca = new StockPeca(
                    resultSet.getInt("idstockpeca"),
                    resultSet.getInt("codipeca"),
                    resultSet.getInt("stock"),
                    resultSet.getInt("idtaller"),
                    resultSet.getInt("stockminim"));
            }

        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            if (!wasconnected) {
                throw new AppException(ex);
            }
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return stockpeca;
    }

    @Override
    public Integer modifyStockPecaStock(Integer codigoPieza, Integer idTaller, Integer valor) throws AppException {
        Integer rowsmodified;
        Integer result = 0;
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE stockpeca SET stock = ? where codipeca = ? and idtaller = ? returning stock";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, valor);
            ptmt.setInt(2, codigoPieza);
            ptmt.setInt(3, idTaller);


            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("stock");
            }

        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            if (!wasconnected) {
                throw new AppException(ex);
            }
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return result;
    }

    @Override
    public Integer modifyStockPecaStockMinim(Integer codigoPieza, Integer idTaller, Integer valor) throws AppException {
        Integer rowsmodified;
        Integer result = 0;
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE stockpeca SET stockminim = ? where codipeca = ? and idtaller = ? returning stockminim";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, valor);
            ptmt.setInt(2, codigoPieza);
            ptmt.setInt(3, idTaller);

            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("stockminim");
            }

        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            if (!wasconnected) {
                throw new AppException(ex);
            }
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return result;
    }

    @Override
    public Boolean deleteStockPeca(StockPeca stockpeca) throws AppException {
        Integer rowsmodified;
        Boolean succeded = false;
        Boolean wasconnected = false;
        String SQL = "DELETE FROM StockPeca WHERE idstockpeca = ? and idtaller = ?";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, stockpeca.getIdstockpeca());
            ptmt.setInt(2, stockpeca.getIdtaller());

            if (ptmt.executeUpdate() > 0) {
                succeded = true;
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            if (!wasconnected) {
                throw new AppException(ex);
            }
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return succeded;
    }
}
