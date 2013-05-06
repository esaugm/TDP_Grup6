package ss4.dao;

import common.dao.GenericDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 6/05/13
 * Time: 9:22
 * To change this template use File | Settings | File Templates.
 */
public interface EjemploDao extends GenericDao {

    public List<?> findAll();
}
