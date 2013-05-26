/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.service;

import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Vehiculo;

/**
 *
 * @author Fernando
 */
public interface VehiculoService {

    public Vehiculo ConsultaChasis(String numChasis) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> ConsultaMarca(String marca) throws ExceptionErrorDataBase;
    public Vehiculo ConsultaMatricula(String matricula) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> ConsultaModelo(String modelo) throws ExceptionErrorDataBase;
    public Vehiculo ConsultaReparacion(Integer orden) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> ConsultaMatriculas(String matricula) throws ExceptionErrorDataBase;

}
