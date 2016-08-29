package student.portfoliomanager.ejb;

import java.util.Date;
//import java.util.ArrayList;
import java.util.List;

import student.portfoliomanager.ejb.PortfolioManagerBeanLocal;
import student.portfoliomanager.ejb.PortfolioManagerBeanRemote;
import student.portfoliomanager.jpa.Category;
import student.portfoliomanager.jpa.Portfolio;
import student.portfoliomanager.jpa.Product;
import student.portfoliomanager.jpa.Stock;
import student.portfoliomanager.jpa.Transactions;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class OnlineRetailerBean
 */
@Stateless
@Remote(PortfolioManagerBeanRemote.class)
@Local(PortfolioManagerBeanLocal.class) 
public class PortfolioManagerBean implements PortfolioManagerBeanRemote, PortfolioManagerBeanLocal {

	
	@PersistenceContext(unitName = "StudentPortfolioManagerJPA-PU")
	private EntityManager em; 
	
	
    /**
     * Default constructor. 
     */
    public PortfolioManagerBean() {
        // TODO Auto-generated constructor stub
    }
    
    public void addCategoriesAndProducts(){
    	  Category cat1 = new Category();
          cat1.setCategoryName("Auto");
          cat1.setDescription("Cars, vans, and motor bikes");
          em.persist(cat1);
          //cat1.setCategoryID(12);
          System.out.println("Just persisted category: " + cat1);
          
          Product prod1 = new Product();
          
          prod1.setProductName("Bugatti");
          prod1.setUnitPrice(1000000);
          prod1.setUnitsInStock(2);
          prod1.setReorderLevel(1);
          prod1.setCategory(cat1);
          cat1.getProducts().add(prod1);
          em.persist(prod1);
          System.out.println("Just persisted product: " + prod1);

    	
    } 
    
    @Override
	public List<Product> getAllProducts(){
    	
    	TypedQuery<Product> query = em.createQuery("SELECT p FROM Product AS p", Product.class);
    	List<Product> prod1 = query.getResultList();
		return prod1;
		
    }
    
    @Override
	public List<Product> getProductsByName(String productName){
    	//List<Product> prod1 = new ArrayList<>();
    	TypedQuery<Product> query = em.createQuery("SELECT p FROM Product AS p WHERE p.productName LIKE '%" + productName + "%'", Product.class);
    	List<Product> prod1 = query.getResultList();
		return prod1;
    }

	@Override
	public List<Product> getProductsInCategory(String categoryName) {
		// TODO Auto-generated method stub
		
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product AS p WHERE p.category.categoryName = :name", Product.class);
        query.setParameter("name", categoryName);

        // Execute the query, and get a collection of products back.
        List<Product> products = query.getResultList();

		return products;
	}

	@Override
	public void insertPortfolio(String name,String type){
		// TODO Auto-generated method stub
		Portfolio object = new Portfolio();
		object.setPortfolioName(name);
		object.setPortfolioType(type);
		em.persist(object);
		System.out.println("persisted object"+ object);
	}

	@Override
	public void insertTransaction(Transactions t){
		// TODO Auto-generated method stub
//		Transactions object = new Transactions();
//		object.setBuySell(t.getBuySell());
//		object.setNumberOfUnits(t.getNumberOfUnits());
//		object.setDate(t.getDate());
//		object.setStocks_stockID(t.getStocks_stockID());
//		object.setUnitPrice(t.getUnitPrice());
		em.persist(t);
		System.out.println("persisted object"+ t);
	}
	
	
	@Override
	public List<Stock> getStocksByDate() {
		// TODO Auto-generated method stub
		
		TypedQuery<Stock> query = em.createQuery("SELECT s FROM Stock AS s", Stock.class);
    	List<Stock> stock = query.getResultList();
		return stock;
	}
	
	
    
    
    
    
    

}
