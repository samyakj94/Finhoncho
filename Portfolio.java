package student.portfoliomanager.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio implements Serializable{

	private static final long serialVersionUID = 171417625280032998L;
	
	@Id
	private int portfolioID;
	private String portfolioName;
	private String portfolioType;
	
	
	public int getPortfolioID() {
		return portfolioID;
	}
	public void setPortfolioID(int portfolioID) {
		this.portfolioID = portfolioID;
	}
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public String getPortfolioType() {
		return portfolioType;
	}
	public void setPortfolioType(String portfolioType) {
		this.portfolioType = portfolioType;
	}
	
	
}
