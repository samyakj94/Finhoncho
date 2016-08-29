package student.portfoliomanager.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int transactionID;
	private Date date;
	private int numberOfUnits;
	private double unitPrice;
	private String BuySell;
	private String stocks_stockID;
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNumberOfUnits() {
		return numberOfUnits;
	}
	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getBuySell() {
		return BuySell;
	}
	public void setBuySell(String buySell) {
		this.BuySell = buySell;
	}
	
	public String getStocks_stockID() {
		return stocks_stockID;
	}
	public void setStocks_stockID(String stocks_stockID) {
		this.stocks_stockID = stocks_stockID;
	}
	
}
