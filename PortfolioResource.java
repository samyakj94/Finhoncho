import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import student.portfoliomanager.ejb.PortfolioManagerBeanLocal;
import student.portfoliomanager.jpa.Product;
import student.portfoliomanager.jpa.Stock;
import student.portfoliomanager.jpa.Transactions;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Path("/portfolio")
public class PortfolioResource {
	
	private PortfolioManagerBeanLocal bean;

	Context context = null;

	public PortfolioResource() {
		//super();
		try {
			context = new InitialContext();
			bean = (PortfolioManagerBeanLocal) context.lookup("java:app/StudentPortfolioManagerEJB/PortfolioManagerBean!student.portfoliomanager.ejb.PortfolioManagerBeanLocal");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GET
	@Produces("application/json")
	public List<Product> allProducts(@QueryParam("filter") @DefaultValue("") String filter) {
		//if(bean==null)
			
		System.out.println("Received a GET request for persons");
		//System.out.println(bean.toString());
		List<Product> products = new ArrayList<Product>();
		products = bean.getProductsByName(filter);
		return products;
		//return null;
		
	}
	
	@POST
	@Consumes("application/json")
	@Path("/update")
	public String putText(TestProduct[] j) {
	System.out.println("PersonResource received a POST request with " + j[1].productName);
	return "cool che";
	}
	
	@POST
	@Consumes("application/json")
	@Path("/add")
	public void putPortfolio(TestPortfolio j) {
		
		bean.insertPortfolio(j.portfolioName,j.portfolioType);
		System.out.println("Portfolio inserted");
	}
	
	
	
	@GET
	@Path("/stocks")
	@Produces("application/json")
	public List<Stock> allStocks() {
		//if(bean==null)
			
		System.out.println("Received a GET request for stocks");
		//System.out.println(bean.toString());
		List<Stock> stocks = new ArrayList<Stock>();
		stocks = bean.getStocksByDate();
		System.out.println(stocks);
		return stocks;
		//return null;
		
	}
	
	@POST
	@Consumes("application/json")
	@Path("/trans")
	public void putTransaction(Transactions j) {
		bean.insertTransaction(j);
		System.out.println("Transaction inserted" + j.getBuySell());
	}
	
	@GET
	@Produces("application/json")
	@Path("/{categoryName}")
	public List<Product> getProductsInCategory(@PathParam("categoryName") @DefaultValue("") String category){
		
		List<Product> products = new ArrayList<Product>();
		products = bean.getProductsInCategory(category);
		return products;
	}
	
	

}

class TestJson{
	int user;
	int password;
	
	public int getUser(){
		return user;
	}
	
	public void setUser(int user){
		this.user = user;
	}
	
	public int getPassword(){
		return password;
	}
	
	public void setPassword(int password){
		this.password = password;
	}
}

class TestProduct{
	
	int productID;
	//private int categoryID;
	String productName;
double unitPrice;
int unitsInStock;
	int reorderLevel;
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public int getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
}

class TestPortfolio{
	String portfolioName;
	String portfolioType;
	
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
class TestStock{
	
	String stockName;
	Date date;
	double openPrice;
	double highPrice;
	double lowPrice;
	double closePrice;
	int volume;
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
}

class TestTransactions {
	
	 
	 Date date;
	 int numberOfUnits;
	 double unitPrice;
	 String buySell;
	 String stocks_stockID;
	
	
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
		return buySell;
	}
	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}
	public String getStocks_stockID() {
		return stocks_stockID;
	}
	public void setStocks_stockID(String stocks_stockID) {
		this.stocks_stockID = stocks_stockID;
	}
}
	
	

