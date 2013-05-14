/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.service.impl;

import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Vehiculo;
import ss3.dao.VehiculoDAO;
import ss3.dao.impl.VehiculoDAOImpl;
import ss3.service.VehiculoService;

/**
 *
 * @author Fernando
 */
public class VehiculoServiceImpl implements VehiculoService {
    
    private VehiculoDAO reparacion;
    
    /**
     *
     * @param OrdenID
     * @return
     * @throws ExceptionErrorDataBase
     */
    public VehiculoServiceImpl(){
        this.reparacion = new VehiculoDAOImpl();
    }
    
    public Vehiculo ConsultaChasis(Integer numChasis) throws ExceptionErrorDataBase{
        return reparacion.findByChasis(numChasis);
    }
    
    public ArrayList<Vehiculo> ConsultaMarca(String marca) throws ExceptionErrorDataBase{
        return reparacion.findByMarca(marca);
    }
    
    public ArrayList<Vehiculo> ConsultaMatricula(String matricula) throws ExceptionErrorDataBase{
        return reparacion.findByMatricula(matricula);
    }
    
    public ArrayList<Vehiculo> ConsultaModelo(String modelo) throws ExceptionErrorDataBase{
        return reparacion.findByModelo(modelo);
    }
}
