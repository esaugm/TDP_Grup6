/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Reparacion;
import ss3.dao.ReparacionDAO;
import ss3.dao.impl.ReparacionDAOImpl;
import ss3.service.ReparacionService;

/**
 *
 * @author Fernando
 */
public class ReparacionServiceImpl implements ReparacionService {
    
    private ReparacionDAO reparacion;
    
    /**
     *
     * @param OrdenID
     * @return
     * @throws ExceptionErrorDataBase
     */
    public ReparacionServiceImpl(){
        this.reparacion = new ReparacionDAOImpl();
    }
    
    public Reparacion ConsultaOrden(Integer OrdenID) throws ExceptionErrorDataBase{
        return reparacion.findByPK(OrdenID);
    }
    
    public ArrayList<Reparacion> ConsultaFechaAsig(String fechaAsig) throws ExceptionErrorDataBase{
        return reparacion.findByDataAssignacio(fechaAsig);
    }
}
