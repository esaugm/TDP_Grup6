
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package ss2.helpers;

//~--- non-JDK imports --------------------------------------------------------


import ss3.beans.Vehiculo;

//~--- JDK imports ------------------------------------------------------------

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ComboBoxModel;


/**
 *
 * ss2.helpers
 * VehiculoTableModel.java (UTF-8)
 *
 * Uoc Primavera 2013, Grup06
 * Fecha: 2013.05.25 18:44:30
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class VehiculoCBModel {
    private ArrayList<Vehiculo> data        = null;

    public ComboBoxModel Vehiculo2ComboBoxModel(ArrayList<Vehiculo> listaObjetos) {
        int               numcols = 0,
                          numrows = 0;
        DefaultComboBoxModel model;

        // Creamos un Default Table model
          model = new DefaultComboBoxModel() {};
	  model.addElement("");

        // Obtenemos los miembros de la clase Vehiculo
        Field[] fields = new Vehiculo().getClass().getDeclaredFields();

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
            Iterator<Vehiculo> iteratorr = listaObjetos.iterator();

            while (iteratorr.hasNext()) {
		Vehiculo elc = iteratorr.next();
                model.addElement(elc.getMatricula());
            }
        }

        return model;
    }

    public Vehiculo getVehiculotbyMatricula(String matricula) {
        Boolean found   = false;
        Vehiculo  present,
                vehiculo = null;

        // Recorremos la lista de Usuarios almacenada hasta que encontramos
        // el ID que buscamos.
        Iterator<Vehiculo> iterator = data.iterator();

        while (iterator.hasNext() &&!found) {
            present = iterator.next();

            if (!matricula.equals(present.getMatricula())) {
            } else {
			vehiculo = present;
			found   = true;
		}
        }

        return vehiculo;
    }

    public Vehiculo getVehiculotbyPos(Integer pos) {
        Vehiculo elvehiculo;
	elvehiculo = data.get(pos-1);
        return elvehiculo;
    }
}
