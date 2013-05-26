/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.service;

import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Pieza;

/**
 *
 * @author Fernando
 */
public interface PiezaService {
    
    public Pieza ConsultaCodigo(Integer codigo) throws ExceptionErrorDataBase;
    public Pieza ConsultaPorOrden(Integer pOrden) throws ExceptionErrorDataBase;
    public ArrayList<Pieza> ConsultaPiezas() throws ExceptionErrorDataBase;
    public ArrayList<Pieza> ConsultaDescripcion(String descripcion) throws ExceptionErrorDataBase;
}
