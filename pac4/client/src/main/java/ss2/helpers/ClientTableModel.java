
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package ss2.helpers;

//~--- non-JDK imports --------------------------------------------------------

import common.utils.TDSLanguageUtils;

import ss2.entity.Client;

//~--- JDK imports ------------------------------------------------------------

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * ss2.helpers
 * ClientTableModel.java (UTF-8)
 *
 * Uoc Primavera 2013, Grup06
 * Fecha: 2013.05.25 18:44:30
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class ClientTableModel {
    private ArrayList<Client> data        = null;
    private ArrayList<String> columnnames = new ArrayList();
    private ArrayList<Class>  columntypes = new ArrayList();

    public TableModel Client2TableModel(ArrayList<Client> listaObjetos) {
        int               numcols = 0,
                          numrows = 0;
        DefaultTableModel model;

        // Creamos un Default Table model
          model = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public String getColumnName(int column) {
                return columnIdentifiers.get(column).toString();
            }
        };

        // Obtenemos los miembros de la clase Client
        Field[] fields = new Client().getClass().getDeclaredFields();

        numcols = fields.length;

        // Para cada uno de los campos lo aÃ±adimos como nombre del header de
        // la tabla que devolvemos
        for (Field field : fields) {
            model.addColumn(TDSLanguageUtils.getMessage("client.SS2.Client." + field.getName()));
            columnnames.add(field.getName());
            columntypes.add(field.getType().getClass());

            // System.out.println(field.getName());
        }

        // Y si la lista tiene contenido...
        if (!listaObjetos.isEmpty()) {

            // Guardamos los datos mientras exista el table model
            data = listaObjetos;

            // Guardamos el nÃºmero de elementos
            numrows = listaObjetos.size();

            // Iteramos para cada uno de las filas aÃ±adiendola
            Iterator<Client> iteratorr = listaObjetos.iterator();

            while (iteratorr.hasNext()) {
                model.addRow(iteratorr.next().toArray());
            }
        }

        return model;
    }

    public Client getClientbyID(Integer id) {
        Boolean found   = false;
        Client  present,
                usuario = null;

        // Recorremos la lista de Usuarios almacenada hasta que encontramos
        // el ID que buscamos.
        Iterator<Client> iterator = data.iterator();

        while (iterator.hasNext() &&!found) {
            present = iterator.next();

            if (id.equals(present.getNumClient())) {
                usuario = present;
                found   = true;
            }
        }

        return usuario;
    }

    public Integer getColumnByName(String columnname) {
        return columnnames.indexOf(columnname);
    }

    public Class getColumnType(Integer column) {
        return columntypes.get(column);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
