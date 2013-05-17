package ss3.server.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss2.exception.AppException;
import ss3.beans.Pieza;
import ss3.beans.Reparacion;
import ss3.beans.Vehiculo;
import ss3.server.SS3Reparaciones;
import ss3.service.PiezaService;
import ss3.service.ReparacionService;
import ss3.service.VehiculoService;
import ss3.service.impl.PiezaServiceImpl;
import ss3.service.impl.ReparacionServiceImpl;
import ss3.service.impl.VehiculoServiceImpl;

/**
 * TDP Grup6 User: Esaú González Date: 12/05/13 Time: 13:20
 */
public class SS3ReparacionesImpl extends UnicastRemoteObject implements SS3Reparaciones {

    private static final long serialVersionUID = 1L;
    private ReparacionService reparacionService;
    private PiezaService piezaService;
    private VehiculoService vehiculoService;

    protected SS3ReparacionesImpl() throws RemoteException {
        super();
        reparacionService = new ReparacionServiceImpl();
        piezaService = new PiezaServiceImpl();
        vehiculoService = new VehiculoServiceImpl();
    }

    @Override
    public Reparacion ConsultaOrden(Integer OrdenID) throws ExceptionErrorDataBase{
        return reparacionService.ConsultaOrden(OrdenID);
    }
    
    @Override
    public ArrayList<Reparacion> ConsultaFechaAsig(String fechaAsig) throws ExceptionErrorDataBase{
        return reparacionService.ConsultaFechaAsig(fechaAsig);
    }
    
    @Override
    public ArrayList<Reparacion> ConsultaFechaIni(String fechaIni) throws ExceptionErrorDataBase{
        return reparacionService.ConsultaFechaIni(fechaIni);
    }
    
    @Override
    public ArrayList<Reparacion> ConsultaFechaFin(String fechaFin) throws ExceptionErrorDataBase{
        return reparacionService.ConsultaFechaFin(fechaFin);
    }
    
    @Override
    public ArrayList<Reparacion> ConsultaAceptadas(Boolean aceptada) throws ExceptionErrorDataBase{
        return reparacionService.ConsultaAceptadas(aceptada);
    }
    
    @Override
    public ArrayList<Reparacion> ConsultaAsignadas(Boolean asignada) throws ExceptionErrorDataBase{
        return reparacionService.ConsultaAsignadas(asignada);
    }
    
    @Override
    public ArrayList<Reparacion> ConsultaAsigMecanico(Integer idMecanico) throws ExceptionErrorDataBase{
        return reparacionService.ConsultaAsigMecanico(idMecanico);
    }
    
    @Override
    public Boolean anotaObs(Integer orden, String observaciones) throws ExceptionErrorDataBase{
        return reparacionService.anotaObs(orden,observaciones);
    }
    
    @Override
    public Boolean asignaAMec(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase{
        return reparacionService.asignaAMec(orden,idMecanico);
    }
    
    @Override
    public Pieza ConsultaCodigo(Integer codigo) throws ExceptionErrorDataBase{
        return piezaService.ConsultaCodigo(codigo);
    }
    
    @Override
    public ArrayList<Pieza> ConsultaPiezas() throws ExceptionErrorDataBase{
        return piezaService.ConsultaPiezas();
    }
    
    @Override
    public ArrayList<Pieza> ConsultaDescripcion(String descripcion) throws ExceptionErrorDataBase{
        return piezaService.ConsultaDescripcion(descripcion);
    }
    @Override
    public Vehiculo ConsultaChasis(String numChasis) throws ExceptionErrorDataBase{
        return vehiculoService.ConsultaChasis(numChasis);
    }
    
    @Override
    public ArrayList<Vehiculo> ConsultaMarca(String marca) throws ExceptionErrorDataBase{
        return vehiculoService.ConsultaMarca(marca);
    }
    
    @Override
    public ArrayList<Vehiculo> ConsultaMatricula(String matricula) throws ExceptionErrorDataBase{
        return vehiculoService.ConsultaMatricula(matricula);
    }
    
    @Override
    public ArrayList<Vehiculo> ConsultaModelo(String modelo) throws ExceptionErrorDataBase{
        return vehiculoService.ConsultaModelo(modelo);
    }
    
    @Override
    public ArrayList<Vehiculo> ConsultaReparacion(Integer orden) throws ExceptionErrorDataBase{
        return vehiculoService.ConsultaReparacion(orden);
    }
     
    public Boolean creaReparacion(Reparacion rep) throws ExceptionErrorDataBase, AppException{
        return reparacionService.creaReparacion(rep);
    }
}
