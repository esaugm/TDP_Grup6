package ss4.model;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ReparacionTableModel extends AbstractTableModel {
    private List<EstadisticaReparaciones> data;
    private LinkedList listeners = new LinkedList();


    public ReparacionTableModel(List data) {

        this.data = data;
//        EstadisticaReparaciones a = new EstadisticaReparaciones();
//        a.setIdReparacio(1111);
//        data.add(a);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id Reparacion";
            case 1:
                return "Nombre Cliente";
            case 2:
                return "Nombre Mecanico";
            case 3:
                return "Tipo Reparacion";
            case 4:
                return "Fecha Inicio";
            case 5:
                return "Fecha Fin";
            case 6:
                return "Estado";
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
                return Date.class;
            case 5:
                return Date.class;
            case 6:
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
                return esta.getNomMencanic();
            case 3:
                return esta.getTipoReparacio();
            case 4:
                return esta.getInici();
            case 5:
                return esta.getFin();
            case 6:
                return esta.getEstado();
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
