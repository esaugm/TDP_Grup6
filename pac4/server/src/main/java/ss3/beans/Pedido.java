package ss3.beans;

import java.util.ArrayList;
import ss3.beans.*;
import java.util.Date;

/**
 * TDP Grup6
 * User: Fernando Gomez
 * Date: 7/05/13
 * Time: 19:00
 */
public class Pedido implements java.io.Serializable {
    
    private Integer numcom;
    private Boolean estat;
    private Date date;
    private Integer codipeca;
    private Integer idcaptaller;
    private Integer idproveidor;
    private Integer ordrereparacio;

    public static final Integer NUMCOM_UNDEF = -1;
    public Pedido(){
    }

    public Pedido(Integer numcom, Boolean estat, Date date, Integer codipeca, Integer idcaptaller, Integer idproveidor, Integer ordrereparacio, Boolean tipusreparacio) {
        super();
        this.numcom = numcom;
        this.estat = estat;
        this.date = date;
        this.codipeca = codipeca;
        this.idcaptaller = idcaptaller;
        this.idproveidor = idproveidor;
        this.ordrereparacio = ordrereparacio;
    }
    
    public Pedido(Boolean estat, Date date, Integer codipeca, Integer idcaptaller, Integer idproveidor, Integer ordrereparacio, Boolean tipusreparacio) {
        super();
        this.numcom = NUMCOM_UNDEF;
        this.estat = estat;
        this.date = date;
        this.codipeca = codipeca;
        this.idcaptaller = idcaptaller;
        this.idproveidor = idproveidor;
        this.ordrereparacio = ordrereparacio;
    }
    

    

@Override
	public String toString() {
		return "\n\nPedido{\n" + "Numero Pedido= " + numcom + ", Estado= " + estat + ", Fecha= " + date + ", Codigo Pieza= " + codipeca + ", Id JefeTaller= " + idcaptaller + ", Id Proveedor= " + idproveidor + ", Orden Reparacion= " + ordrereparacio + "\n}";
        
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(numcom);
		values.add(estat);
		values.add(date);
		values.add(codipeca);
		values.add(idcaptaller);
		values.add(idproveidor);
		values.add(ordrereparacio);
                
		return values.toArray();
	}

    public Integer getNumcom() {
        return numcom;
    }

    public void setNumcom(Integer numcom) {
        this.numcom = numcom;
    }

    public Boolean getEstat() {
        return estat;
    }

    public void setEstat(Boolean estat) {
        this.estat = estat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCodipeca() {
        return codipeca;
    }

    public void setCodipeca(Integer codipeca) {
        this.codipeca = codipeca;
    }

    public Integer getIdcaptaller() {
        return idcaptaller;
    }

    public void setIdcaptaller(Integer idcaptaller) {
        this.idcaptaller = idcaptaller;
    }

    public Integer getIdproveidor() {
        return idproveidor;
    }

    public void setIdproveidor(Integer idproveidor) {
        this.idproveidor = idproveidor;
    }

    public Integer getOrdrereparacio() {
        return ordrereparacio;
    }

    public void setOrdrereparacio(Integer ordrereparacio) {
        this.ordrereparacio = ordrereparacio;
    }
}
