package ss4.dao.impl;

import common.dao.impl.GenericDaoImpl;
import common.utils.ConnectionFactory;
import ss4.dao.EstadisticaDao;
import ss4.model.EstadisticaReparaciones;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 22/05/13
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
public class EstadisticaDaoImpl extends GenericDaoImpl implements EstadisticaDao {
    private SimpleDateFormat _fmt = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public List<EstadisticaReparaciones> findReparacionesByTerms(Map values) {
        List list = new ArrayList();
        Boolean isFirst = new Boolean(true);

        try {

            String queryString = "SELECT " +
                    " reparacio.ordrereparacio , client.nom , usuari.nom , reparacio.datainici , reparacio.datafi , solicitud.finalitzada , solicitud.pendent , reparacio.observacions" +
                    " FROM reparacio  " +
                    " JOIN solicitud ON reparacio.ordrereparacio = solicitud.numreparacio" +
                    " JOIN client   ON solicitud.client = client.nif " +
                    " JOIN usuari ON reparacio.idmecanic = usuari.id";

            if (values.size() > 0) {
                queryString += " WHERE ";
            }

            Iterator itr = values.entrySet().iterator();


            while (itr.hasNext()) {
                Map.Entry e = (Map.Entry) itr.next();

                if (e.getKey().equals("idReparacion")) {
                    if (isFirst) {
                        queryString += " reparacio.ordrereparacio = " + e.getValue();
                        isFirst = false;
                    } else {
                        queryString += " AND reparacio.ordrereparacio = " + e.getValue();
                    }

                } else if (e.getKey().equals("cliente")) {
                    if (isFirst) {
                        queryString += "  LOWER(client.nom) like '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(client.nom) like '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }

                } else if (e.getKey().equals("mecanico")) {
                    if (isFirst) {
                        queryString += "  LOWER(usuari.nom)  like  '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(usuari.nom)  like  '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }

                } else if (e.getKey().equals("inicio")) {
                    if (isFirst) {
                        queryString += " reparacio.datainici > '" + e.getValue() + "'";
                        isFirst = false;

                    } else {
                        queryString += " AND reparacio.datainici > '" + e.getValue() + "'";
                    }


                } else if (e.getKey().equals("fin")) {
                    if (isFirst) {
                        queryString += "  reparacio.datafi < '" + e.getValue() + "'";
                        isFirst = false;

                    } else {
                        queryString += " AND reparacio.datafi < '" + e.getValue() + "'";
                    }

                }

            }
            System.out.println(queryString);
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                EstadisticaReparaciones repa = new EstadisticaReparaciones();
                repa.setIdReparacio(resultSet.getInt(1));
                repa.setNomClient(resultSet.getString(2));
                repa.setNomMencanic(resultSet.getString(3));
                repa.setInici(resultSet.getDate(4));
                repa.setFin(resultSet.getDate(5));
                if (resultSet.getBoolean(6)) {
                    repa.setEstado("Finalizada");
                } else {
                    if (resultSet.getBoolean(7)) {
                        repa.setEstado("Pendiente");
                    } else {
                        repa.setEstado("En curso");
                    }

                }
                repa.setTipoReparacio(resultSet.getString(8));
                list.add(repa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);


        }

        return list;
    }

    @Override
    public List<EstadisticaReparaciones> findReparacionesByTermsClientes(Map values) {


        List list = new ArrayList();
        Boolean isFirst = new Boolean(true);

        try {

            String queryString = "SELECT" +
                    "        reparacio.ordrereparacio, client.nom,vehicle.marca,asseguradora.nom ,peca.pvp" +
                    "        FROM               reparacio" +
                    "        JOIN solicitud ON reparacio.ordrereparacio = solicitud.numreparacio" +
                    "        JOIN client ON solicitud.client = client.nif" +
                    "        JOIN vehicle ON reparacio.ordrereparacio = vehicle.numreparacio" +
                    "        JOIN asseguradora ON solicitud.asseguradora = asseguradora.idasseguradora" +
                    "        JOIN comanda ON reparacio.numcom = comanda.numcom" +
                    "        JOIN peca ON comanda.codipeca = peca.codipeca";

            if (values.size() > 0) {
                queryString += " WHERE ";
            }

            Iterator itr = values.entrySet().iterator();


            while (itr.hasNext()) {
                Map.Entry e = (Map.Entry) itr.next();

                if (e.getKey().equals("idReparacion")) {
                    if (isFirst) {
                        queryString += " reparacio.ordrereparacio = " + e.getValue();
                        isFirst = false;
                    } else {
                        queryString += " AND reparacio.ordrereparacio = " + e.getValue();
                    }

                } else if (e.getKey().equals("cliente")) {
                    if (isFirst) {
                        queryString += "  LOWER(client.nom) like '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(client.nom) like '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }

                } else if (e.getKey().equals("marca")) {
                    if (isFirst) {
                        queryString += "  LOWER(vehicle.marca)  like  '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(vehicle.marca)  like  '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }

                } else if (e.getKey().equals("compania")) {
                    if (isFirst) {
                        queryString += "  LOWER(asseguradora.nom)  like  '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(asseguradora.nom)  like  '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }

                } else if (e.getKey().equals("inicio")) {
                    if (isFirst) {
                        queryString += " reparacio.datainici > '" + e.getValue() + "'";
                        isFirst = false;

                    } else {
                        queryString += " AND reparacio.datainici > '" + e.getValue() + "'";
                    }


                } else if (e.getKey().equals("fin")) {
                    if (isFirst) {
                        queryString += "  reparacio.datafi < '" + e.getValue() + "'";
                        isFirst = false;

                    } else {
                        queryString += " AND reparacio.datafi < '" + e.getValue() + "'";
                    }

                }

            }
            System.out.println(queryString);
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                EstadisticaReparaciones repa = new EstadisticaReparaciones();
                repa.setIdReparacio(resultSet.getInt(1));
                repa.setNomClient(resultSet.getString(2));
                repa.setMarca(resultSet.getString(3));
                repa.setCompañia(resultSet.getString(4));
                repa.setImporte(resultSet.getString(5));
                list.add(repa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);


        }

        return list;
    }
}
