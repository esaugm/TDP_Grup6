
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ComboBoxModel;


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
public class ClientCBModel {
    private ArrayList<Client> data        = null;

    public ComboBoxModel Client2ComboBoxModel(ArrayList<Client> listaObjetos) {
        int               numcols = 0,
                          numrows = 0;
        DefaultComboBoxModel model;

        // Creamos un Default Table model
          model = new DefaultComboBoxModel() {};
	  model.addElement("");

        // Obtenemos los miembros de la clase Client
        Field[] fields = new Client().getClass().getDeclaredFields();

        numcols = fields.length;

        // Para cada uno de los campos lo aÃ±adimos como nombre del header de
        // la tabla que devolvemos

        // Y si la lista tiene contenido...
        if (!listaObjetos.isEmpty()) {

            // Guardamos los datos mientras exista el table model
            data = listaObjetos;

            // Guardamos el nÃºmero de elementos
            numrows = listaObjetos.size();

            // Iteramos para cada uno de las filas aÃ±adiendola
            Iterator<Client> iteratorr = listaObjetos.iterator();

            while (iteratorr.hasNext()) {
		Client elc = iteratorr.next();
                model.addElement(elc.getNif()+": "+elc.getcognoms()+", "+elc.getnom());
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

    public Client getClientbyPos(Integer pos) {
        Client elcliente;
	elcliente = data.get(pos-1);
        return elcliente;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
