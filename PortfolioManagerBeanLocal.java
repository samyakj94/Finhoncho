package student.portfoliomanager.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;


import student.portfoliomanager.jpa.Product;
import student.portfoliomanager.jpa.Stock;
import student.portfoliomanager.jpa.Transactions;

@Local
public interface PortfolioManagerBeanLocal {

	 public void addCategoriesAndProducts();
	 public List<Product> getAllProducts();
	 public List<Product> getProductsByName(String productName);
	 public List<Product> getProductsInCategory(String categoryName);
	 
	 public void insertPortfolio(String name,String type);
	public List<Stock> getStocksByDate();
	public void insertTransaction(Transactions j);
	 
}
