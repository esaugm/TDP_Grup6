package ss2.server.impl;

import ss2.server.ISS2GestionAdministrativa;
import ss2.server.impl.*;
/*
 * import ss2.dao.exception.ExceptionContrasenyaIncorrecta;
 import ss2.dao.exception.ExceptionErrorDataBase;
 import ss2.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
 import ss2.dao.exception.ExceptionUsuariNoExisteix;
 */
import ss2.entity.*;
import ss2.service.impl.*;
import ss2.service.*;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import ss2.exception.AppException;

/**
 * TDP Grup6 User: Esaú González Date: 12/05/13 Time: 13:20
 */
public class SS2GestionAdministrativaImpl extends UnicastRemoteObject implements ISS2GestionAdministrativa {

    private static final long serialVersionUID = 1L;
    private ClientService clientService;
    private SolicitudService solicitudService;
    private StockPiezasService stockpiezasService;

    public SS2GestionAdministrativaImpl() throws RemoteException {
        super();
        clientService = new ClientService();
        solicitudService = new SolicitudService();
        stockpiezasService = new StockPiezasService();
    }

    @Override
    public StockPeca consultaStockPiezabyCodigoPieza(Integer codigoPieza, Integer idTaller) throws AppException {
        return stockpiezasService.consultaStockPiezabyCodigoPieza(codigoPieza, idTaller);
    }

    @Override
    public StockPeca consultaStockPiezabyCodigoStockPieza(Integer codigoPieza, Integer idTaller) throws AppException {
        return stockpiezasService.consultaStockPiezabyCodigoStockPieza(codigoPieza, idTaller);
    }

    @Override
    public ArrayList<StockPeca> consultaStockPiezas(Integer idTaller) throws AppException {
        return stockpiezasService.consultaStockPiezas(idTaller);
    }

    @Override
    public Integer modificaStockPieza_Stock(Integer codigoPieza, Integer idTaller, Integer incremento) throws AppException {
        return stockpiezasService.modificaStockPieza_Stock(codigoPieza, idTaller, incremento);
    }

    @Override
    public Integer modificaStockPieza_StockMinimo(Integer codigoPieza, Integer idTaller, Integer incremento) throws AppException {
        return stockpiezasService.modificaStockPieza_StockMinimo(codigoPieza, idTaller, incremento);
    }

    @Override
    public Boolean altaCliente(Client client) throws AppException {
        return clientService.altaCliente(client);
    }

    @Override
    public Boolean bajaCliente(Client client) throws AppException {
        return clientService.bajaCliente(client);
    }

    @Override
    public ArrayList<Client> buscaCliente(String freetext) throws AppException {
        return clientService.buscaCliente(freetext);
    }

    @Override
    public ArrayList<Client> buscaClientebyNIF(String nif) throws AppException {
        return clientService.buscaClientebyNIF(nif);
    }

    @Override
    public Client buscaClientebynumclient(Integer numclient) throws AppException {
        return clientService.buscaClientebynumclient(numclient);
    }

    @Override
    public ArrayList<Client> listaClientes() throws AppException {
        return clientService.listaClientes();
    }

    @Override
    public Boolean modificaCliente(Client client) throws AppException {
        return clientService.modificaCliente(client);
    }

    @Override
    public Boolean altaSolicitud(Solicitud solicitud) throws AppException {
        return solicitudService.altaSolicitud(solicitud);
    }

    @Override
    public Integer altaSolicitudRetNumsol(Solicitud solicitud) throws AppException {
        return solicitudService.altaSolicitudRetNumsol(solicitud);
    }
    
    @Override
    public Solicitud altaSolicitudRetSolicitud(Solicitud solicitud) throws AppException {
        return solicitudService.altaSolicitudRetSolicitud(solicitud);
    }

    @Override
    public ArrayList<Solicitud> buscaSolicitudbyANY(String freetext) throws AppException {
        return solicitudService.buscaSolicitudbyANY(freetext);
    }

    @Override
    public Solicitud buscaSolicitudbynumsol(Integer numsolicitud) throws AppException {
        return solicitudService.buscaSolicitudbynumsol(numsolicitud);
    }
    
    @Override
    public Solicitud buscaSolicitudbynumrep(Integer orden) throws AppException {
        return solicitudService.buscaSolicitudbynumrep(orden);
    }

    @Override
    public ArrayList<Solicitud> consultaSolicitudes() throws AppException {
        return solicitudService.consultaSolicitudes();
    }

    @Override
    public Solicitud finalizaSolicitud(Integer numsolicitud) throws AppException {
        return solicitudService.finalizaSolicitud(numsolicitud);
    }
    /*
     Boolean deleteSolicitud(Solicitud solicitud) throws AppException;
     */

    @Override
    public Boolean modificaSolicitud(Solicitud solicitud) throws AppException {
        return solicitudService.modificaSolicitud(solicitud);
    }

    @Override
    public Solicitud modificaSolicitudwithRet(Solicitud solicitud) throws AppException {
        return solicitudService.modificaSolicitudwithRet(solicitud);
    }
}
