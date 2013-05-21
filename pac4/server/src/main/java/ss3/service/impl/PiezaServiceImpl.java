/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.service.impl;

import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Pieza;
import ss3.dao.PiezaDAO;
import ss3.dao.impl.PiezaDAOImpl;
import ss3.service.PiezaService;

/**
 *
 * @author Fernando
 */
public class PiezaServiceImpl implements PiezaService {
    
    private PiezaDAO pieza;
    
    /**
     *
     * @param OrdenID
     * @return
     * @throws ExceptionErrorDataBase
     */
    public PiezaServiceImpl(){
        this.pieza = new PiezaDAOImpl();
    }
    
    public Pieza ConsultaCodigo(Integer codigo) throws ExceptionErrorDataBase{
        return pieza.findByCodiPieza(codigo);
    }
    
    public ArrayList<Pieza> ConsultaPiezas() throws ExceptionErrorDataBase{
        return pieza.findPiezas();
    }
    
    public ArrayList<Pieza> ConsultaDescripcion(String descripcion) throws ExceptionErrorDataBase{
        return pieza.findByDescripcion(descripcion);
    }
    
}
