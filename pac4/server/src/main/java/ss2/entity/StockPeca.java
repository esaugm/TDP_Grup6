/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ss2.entity;

import java.util.ArrayList;

/**
 ***************************************
 * ss2.entity
 * StockPeca.java (windows-1252)
 ***************************************
 * Uoc Primavera 2013, Grup06
 * Fecha: 2013.05.13 19:16:18
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class StockPeca {

	private	Integer idstockpeca;
	private	Integer codipeca;
	private	Integer stock;
	private	Integer idtaller;
	private	Integer stockminim;

	public static final Integer STOCK_PECA_UNDEF = -1;


	public StockPeca() {
	}

	public StockPeca(Integer codipeca, Integer stock, Integer idtaller, Integer stockminim) {
		this.codipeca = codipeca;
		this.stock = stock;
		this.idtaller = idtaller;
		this.stockminim = stockminim;
		this.idstockpeca = STOCK_PECA_UNDEF;
	}

	public StockPeca(Integer idstockpeca, Integer codipeca, Integer stock, Integer idtaller, Integer stockminim) {
		this.idstockpeca = idstockpeca;
		this.codipeca = codipeca;
		this.stock = stock;
		this.idtaller = idtaller;
		this.stockminim = stockminim;
	}

	public Integer getIdstockpeca() {
		return idstockpeca;
	}

	public void setIdstockpeca(Integer idstockpeca) {
		this.idstockpeca = idstockpeca;
	}

	public Integer getCodipeca() {
		return codipeca;
	}

	public void setCodipeca(Integer codipeca) {
		this.codipeca = codipeca;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getIdtaller() {
		return idtaller;
	}

	public void setIdtaller(Integer idtaller) {
		this.idtaller = idtaller;
	}

	public Integer getStockminim() {
		return stockminim;
	}

	public void setStockminim(Integer stockminim) {
		this.stockminim = stockminim;
	}

	@Override
	public String toString() {
		return "\nStockPeca{" + "idstockpeca=" + idstockpeca + ", codipeca=" + codipeca + ", stock=" + stock + ", idtaller=" + idtaller + ", stockminim=" + stockminim + "}\n";
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();

		values.add(idstockpeca);
		values.add(codipeca);
		values.add(stock);
		values.add(idtaller);
		values.add(stockminim);

		return values.toArray();
	}
}

