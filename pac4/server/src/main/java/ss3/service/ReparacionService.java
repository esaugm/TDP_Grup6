/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.service;

import java.sql.Date;
import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Reparacion;

/**
 *
 * @author Fernando
 */
public interface ReparacionService {
    
    public Reparacion ConsultaOrden(Integer OrdenID) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaFechaAsig(String fechaAsig) throws ExceptionErrorDataBase;
}