import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import student.portfoliomanager.ejb.PortfolioManagerBeanRemote;
import student.portfoliomanager.jpa.Product;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Properties for JNDI InitialContext.
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName()); 
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		prop.put("jboss.naming.client.ejb.context", true);

		// Create the JNDI InitialContext.
		Context context = null;
		try {
			context = new InitialContext(prop);
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Formulate the full JNDI name for the OnlineRetailer session bean.
		String appName     = "StudentPortfolioManager";
		String moduleName  = "StudentPortfolioManagerEJB";
		String beanName    = "StudentPortfolioManagerBean";
		String packageName = "student.portfoliomanager.ejb";
		String className   = "PortfolioManagerBeanRemote";

		// Lookup the bean using the full JNDI name.
		String fullJndiName = String.format("%s/%s/%s!%s.%s", appName, moduleName, beanName, packageName, className);
		try {
			PortfolioManagerBeanRemote bean = (PortfolioManagerBeanRemote) context.lookup("StudentPortfolioManager/StudentPortfolioManagerEJB/PortfolioManagerBean!student.portfoliomanager.ejb.PortfolioManagerBeanRemote");
			//System.out.println(bean.toString());
			bean.addCategoriesAndProducts();
			List<Product> allprod = bean.getAllProducts();
			for(Product prod : allprod){
				System.out.println("Product is: "+ prod.getProductName());
			}
			//bean.insertPortfolio();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}