package common.rmi;

import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.dao.exception.ExceptionUsuariNoExisteix;
import ss1.entity.Taller;
import ss1.entity.Usuari;
import ss1.server.ISS1ConexioManteniment;
import ss1.service.filter.FilterItems;
import ss2.entity.Solicitud;
import ss2.entity.StockPeca;
import ss2.exception.AppException;
import ss2.server.ISS2GestionAdministrativa;
import ss3.beans.Pieza;
import ss3.beans.Reparacion;
import ss3.beans.Vehiculo;
import ss3.server.SS3Reparaciones;
import ss4.server.ISS4Estadisticas;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 19/05/13
 * Time: 12:12
 */
public class Client {

    private final String URL = "localhost";
    private final int PORT = 1099;

    private ISS1ConexioManteniment remoteSS1;
    private final String JNDI_SS1_NAME = "ConexioManteniment";

    private ISS2GestionAdministrativa remoteSS2;
    private final String JNDI_SS2_NAME = "GestionAdministrativa";

    private SS3Reparaciones remoteSS3;
    private final String JNDI_SS3_NAME = "Reparaciones";
    private ISS4Estadisticas _remoteSS4 ;
    private final String JNDI_SS4_NAME = "Estadisticas";


    /**
     * Starts the connection with the server
     * @throws java.rmi.RemoteException if there's some problem connecting with the server
     */
    public void connect() throws Exception{
        System.out.println("Connecting with the server...");
        Registry registry = LocateRegistry.getRegistry(URL, PORT);
        remoteSS1 = (ISS1ConexioManteniment) registry.lookup(JNDI_SS1_NAME);
        remoteSS2 = (ISS2GestionAdministrativa) registry.lookup(JNDI_SS2_NAME);
        remoteSS3 = (SS3Reparaciones) registry.lookup(JNDI_SS3_NAME);
        _remoteSS4 = (ISS4Estadisticas) registry.lookup(JNDI_SS4_NAME);
        System.out.println("Connected!");
    }

    public void disconnect(){
        System.out.println("Disconnecting from server...");
        System.exit(0);
    }

    //SS1
    public Usuari makeLogin(String pUsuari, String pPasswd) throws RemoteException, ExceptionUsuariNoExisteix, ExceptionContrasenyaIncorrecta, ExceptionErrorDataBase {
        return remoteSS1.usuariLogin(pUsuari, pPasswd);
    }

    public void altaUsuari(Usuari newUsuari) throws ExceptionErrorDataBase, RemoteException {
        remoteSS1.altaUsuari(newUsuari);
    }

    public void modificaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase, RemoteException {
        remoteSS1.modificaUsuari(pUsuari);
    }

    public void baixaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase, RemoteException {
        remoteSS1.baixaUsuari(pUsuari);
    }

    public List<Taller> listaTallers() throws ExceptionErrorDataBase, RemoteException {
        return remoteSS1.getAllTallers();
    }

    public List<Usuari> filtrarUsuaris(FilterItems pFilterItems) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido, RemoteException {
        return remoteSS1.getAllUsuarisByFilter(pFilterItems);

    }

    public Taller findTallerById(Integer pTallerId) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS1.getTallerById(pTallerId);
    }


    public void altaTaller(Taller taller) throws ExceptionErrorDataBase, RemoteException {
        remoteSS1.altaTaller(taller);
    }

    public List<Usuari> listaCapsTaller() throws ExceptionErrorDataBase, RemoteException, ExceptionTipoObjetoFiltroNoPermitido {
        return remoteSS1.getAllCapsTaller();
    }


    public List<Taller> filtrarTaller(FilterItems filterItems) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido, RemoteException {
        return remoteSS1.getAllTallerByFilter(filterItems);
    }

    public Usuari buscarUsuariPorId(Integer pId) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS1.findUsuariByPK(pId);
    }

    public void modificaTaller(Taller pTaller) throws ExceptionErrorDataBase, RemoteException {
        remoteSS1.modificaTaller(pTaller);
    }

    // final SS1
    public Solicitud buscaSolicitudbynumrep(Integer orden) throws AppException, RemoteException {
        return remoteSS2.buscaSolicitudbynumrep(orden);


    }

    public StockPeca consultaStockPiezabyCodigoPieza(Integer codigoPieza, Integer idTaller) throws AppException, RemoteException{
        return remoteSS2.consultaStockPiezabyCodigoPieza(codigoPieza, idTaller);
    }

    public Boolean modificaSolicitud (Solicitud solicitud) throws AppException, RemoteException{
        return remoteSS2.modificaSolicitud(solicitud);
    }

    public ArrayList<StockPeca> consultaStockPiezas(Integer idTaller) throws AppException, RemoteException{
        return remoteSS2.consultaStockPiezas(idTaller);
    }

    public Reparacion ConsultaOrden(Integer OrdenID) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaOrden(OrdenID);
    }

    public ArrayList<Reparacion> ConsultaTodas() throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaTodas();
    }

    public ArrayList<Reparacion> ConsultaFechaAsig(String fechaAsig) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaFechaAsig(fechaAsig);
    }

    public ArrayList<Reparacion> ConsultaFechaIni(String fechaIni) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaFechaIni(fechaIni);
    }

    public ArrayList<Reparacion> ConsultaFechaFin(String fechaFin) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaFechaFin(fechaFin);
    }

    public ArrayList<Reparacion> ConsultaAceptadas(Boolean aceptada) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaAceptadas(aceptada);
    }

    public ArrayList<Reparacion> ConsultaAsignadas(Boolean asignada) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaAsignadas(asignada);
    }

    public ArrayList<Reparacion> ConsultaReparacionesByTerms(Map values) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.findReparacionesByTerms(values);
    }

    public Boolean anotaObs(Integer orden, String observaciones) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.anotaObs(orden, observaciones);
    }

    public Vehiculo ConsultaReparacion(Integer orden) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.ConsultaReparacion(orden);
    }

    public Boolean aceptaReparacion(Integer orden) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.aceptaReparacion(orden);
    }



    public ISS2GestionAdministrativa get_remoteSS2() {
        return remoteSS2;
    }

    public SS3Reparaciones get_remoteSS3() {
        return remoteSS3;
    }

    public Pieza ConsultaPiezaPorOrden(Integer orden) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.ConsultaPorOrden(orden);
    }

    public Pieza ConsultaCodigo(Integer codigo) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.ConsultaCodigo(codigo);
    }

    public ArrayList<Pieza> ConsultaDescripcion(String descripcion) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.ConsultaDescripcion(descripcion);
    }

    public Boolean desasignaMec(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.desasignaMec(orden, idMecanico);
    }

    public Boolean asignaAMec(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.asignaAMec(orden, idMecanico);
    }

    public ISS4Estadisticas get_remoteSS4() {
        return _remoteSS4;
    }

    public void set_remoteSS4(ISS4Estadisticas _remoteSS4) {
        this._remoteSS4 = _remoteSS4;
    }
}
