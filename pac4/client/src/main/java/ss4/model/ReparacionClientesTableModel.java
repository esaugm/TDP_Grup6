package ss4.model;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 23/05/13
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class ReparacionClientesTableModel extends AbstractTableModel {
    private List<EstadisticaReparaciones> data;
    private LinkedList listeners = new LinkedList();


    public ReparacionClientesTableModel(List data) {

        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id Reparacion";
            case 1:
                return "Nombre Cliente";
            case 2:
                return "Marca";
            case 3:
                return "Compañia";
            case 4:
                return "Importe";

            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;

            default:
                return Object.class;
        }

    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EstadisticaReparaciones esta = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return esta.getIdReparacio();
            case 1:
                return esta.getNomClient();
            case 2:
                return esta.getMarca();
            case 3:
                return esta.getCompañia();
            case 4:
                return esta.getImporte();

            default:
                return null;
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    public void reloadData(List data) {
        this.data = data;
        fireTableStructureChanged();
    }


}