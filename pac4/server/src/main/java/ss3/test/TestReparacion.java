/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.test;

import java.util.ArrayList;
import java.util.Locale;
import common.utils.TDSLanguageUtils;
import java.util.Iterator;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Reparacion;
import ss3.beans.Vehiculo;
import ss3.service.ReparacionService;
import ss3.service.VehiculoService;
import ss3.service.impl.ReparacionServiceImpl;
import ss3.service.impl.VehiculoServiceImpl;

/**
 *
 * @author Fernando Gomez
 */
public final class TestReparacion { 

    ArrayList<Reparacion> lreparacion;

    //final private ClientService	gClient;
    public TestReparacion() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionErrorDataBase {
        // TODO code application logic here

        if (args.length == 0) {
            TDSLanguageUtils.setDefaultLanguage("conf/messages");
        }
        if (args.length == 1) {
            Locale locale = new Locale(args[0]);
            try {
                TDSLanguageUtils.setLanguage("conf/messages", locale);
            } catch (Exception ex) {    
            }
        }

        System.out.println("Obteniendo datos de reparación. Consulta por Orden: \n");
        ReparacionService gReparacion1 = new ReparacionServiceImpl();
        
        try {
            Reparacion reparacion = gReparacion1.ConsultaOrden(1);
            System.out.println(">>" + reparacion + "<<\n");
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("\nObteniendo datos de reparación. Consulta por Fecha de Asignacion: \n");
        ReparacionService gReparacion2 = new ReparacionServiceImpl();
        try{
            ArrayList<Reparacion> reparacionesAsig = gReparacion2.ConsultaFechaAsig("2013-03-02");
            Iterator it = reparacionesAsig.iterator();
            if (!it.hasNext())
                System.out.println("No hay datos.");
            while (it.hasNext())
                System.out.println(">>" + it.next() + "<<");
        
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("\nObteniendo datos de reparación. Consulta por Fecha de Inicio: \n");
        ReparacionService gReparacion3 = new ReparacionServiceImpl();
        try{
            ArrayList<Reparacion> reparacionesIni = gReparacion3.ConsultaFechaIni("2013-04-04");
            Iterator it2 = reparacionesIni.iterator();
            if (!it2.hasNext())
                System.out.println("No hay datos.");
            while (it2.hasNext())
                System.out.println(">>" + it2.next() + "<<");
        }catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("\nObteniendo datos de reparación. Consulta por Fecha de Fin: \n");
        ReparacionService gReparacion4 = new ReparacionServiceImpl();
        try{
            ArrayList<Reparacion> reparacionesFin = gReparacion4.ConsultaFechaFin("2013-04-04");
            Iterator it3 = reparacionesFin.iterator();
            if (!it3.hasNext())
                System.out.println("No hay datos.");
            while (it3.hasNext())
                System.out.println(">>" + it3.next() + "<<");
        }catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("\nObteniendo datos de reparación. Consulta por Asignadas: \n");
        ReparacionService gReparacion5 = new ReparacionServiceImpl();
        try{
            ArrayList<Reparacion> reparacionesAsignadas = gReparacion5.ConsultaAsignadas(true);
            Iterator it4 = reparacionesAsignadas.iterator();
            if (!it4.hasNext())
                System.out.println("No hay datos.");
            while (it4.hasNext())
                System.out.println(">>" + it4.next() + "<<");
        }catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("\nObteniendo datos de reparación. Consulta por Aceptadas: \n");
        ReparacionService gReparacion6 = new ReparacionServiceImpl();
        try{
            ArrayList<Reparacion> reparacionesAceptadas = gReparacion6.ConsultaAceptadas(true);
            Iterator it5 = reparacionesAceptadas.iterator();
            if (!it5.hasNext())
                System.out.println("No hay datos.");
            while (it5.hasNext())
                System.out.println(">>" + it5.next() + "<<");
        }catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("Obteniendo datos de vehiculo. Consulta por Chasis: \n");
        VehiculoService gVehiculo1 = new VehiculoServiceImpl();
        try {
            Vehiculo vehiculo = gVehiculo1.ConsultaChasis("123456777");
            System.out.println(">>" + vehiculo + "<<\n");
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("\nObteniendo datos de Vehiculo. Consulta por MArca: \n");
        VehiculoService gVehiculo2 = new VehiculoServiceImpl();
        try{
            ArrayList<Vehiculo> vehiculoMarca = gVehiculo2.ConsultaMarca("Renault");
            Iterator it2 = vehiculoMarca.iterator();
            if (!it2.hasNext())
                System.out.println("No hay datos.");
            while (it2.hasNext())
                System.out.println(">>" + it2.next() + "<<");
        }catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("\nObteniendo datos de Vehiculo. Consulta por Matricula: \n");
        VehiculoService gVehiculo3 = new VehiculoServiceImpl();
        try{
            ArrayList<Vehiculo> vehiculoMatricula = gVehiculo3.ConsultaMatricula("654321");
            Iterator it2 = vehiculoMatricula.iterator();
            if (!it2.hasNext())
                System.out.println("No hay datos.");
            while (it2.hasNext())
                System.out.println(">>" + it2.next() + "<<");
        }catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("\nObteniendo datos de Vehiculo. Consulta por Modelo: \n");
        VehiculoService gVehiculo4 = new VehiculoServiceImpl();
        try{
            ArrayList<Vehiculo> vehiculoModelo = gVehiculo4.ConsultaModelo("320");
            Iterator it3 = vehiculoModelo.iterator();
            if (!it3.hasNext())
                System.out.println("No hay datos.");
            while (it3.hasNext())
                System.out.println(">>" + it3.next() + "<<");
        }catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
        System.out.println("\nObteniendo datos para Pantalla REPARACIONES. Filtrando por datos Reparacion: \n");
        ReparacionService gSalida1 = new ReparacionServiceImpl();
        try{
            ArrayList<Reparacion> rep1 = gSalida1.ConsultaAceptadas(true);
            Iterator itS1 = rep1.iterator();
            if (!itS1.hasNext())
                System.out.println("No hay datos.");
            while (itS1.hasNext()){
                Reparacion r = (Reparacion) itS1.next();
                VehiculoService gSalida2 = new VehiculoServiceImpl();
                try
                {
                    ArrayList<Vehiculo> veh1 = gSalida2.ConsultaReparacion(r.getIdOrden());
                    Iterator itS2 = veh1.iterator();
                    while(itS2.hasNext()){
                        Vehiculo v = (Vehiculo) itS2.next();
                        System.out.println(">>" + "ORDEN: " + r.getIdOrden() + "\n"
                                                + "MATRICULA: " + v.getMatricula() + "\n"
                                                + "MARCA: " + v.getMarca() + "\n"
                                                + "MODELO: " + v.getModelo() + "\n"
                                                + "ASIGNADA: " + r.isAsignada() + "\n"
                                                + "ACEPTADA: " + r.isAceptada() + "\n"
                                                + "OBSERVACIONES: " + r.getObservaciones() + "\n"
                                                + "FECHA ASIGNACIÓN: " + r.getFechaAsigna() + "\n" 
                                                + "FECHA INICIO: " + r.getFechaIni() + "\n"
                                                + "FECHA FIN: " + r.getFechaFin() + "\n"
                                                + "CONTADOR: " + r.getContador() + "\n"+ "<<\n\n");
                    }
                        
                }catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                    exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                
            }
        }catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
