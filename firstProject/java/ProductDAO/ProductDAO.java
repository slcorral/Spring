package ProductDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Modelo.Product;
import Modelo.Excepciones.LogicException;
import WebServices.InterfazProduct;

public class ProductDAO implements InterfazProduct {

	public ProductDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProduct(Product product) throws LogicException {
		// TODO Auto-generated method stub
		if(product == null)
			throw new LogicException("The product musnt be null",0);
		
		int timeout=10;
		int timmer=0;
	    if(timmer>timeout)
	    	throw new LogicException("Service not available, try again later",1);
	   
	    System.out.println("El producto ha sido añadido");
	   
	}

	@Override
	public int deleteProduct(Product product) throws LogicException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateProduct(Product product) throws LogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Map<String, Object> mapProperties)
			throws LogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteProductById(Long id) throws LogicException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProductBatch(List<Product> product) throws LogicException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProductBatch(Product product) throws LogicException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProductBatch(Map<Long, Map<String, Object>> mapProperties)
			throws LogicException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getProductById(Long id) throws LogicException,OutOfMemoryError {
		// TODO Auto-generated method stub
		Product product=null;
		product = new Product();
		product.setName("Modificado");
		product.setCode("codigo Modificado");
		return product;
	}

	@Override
	public List<Product> getListProduct(Long inic, Long fin) throws LogicException,OutOfMemoryError {
		// TODO Auto-generated method stub
		
		List<Product> productList=new ArrayList<Product>();
		
		for(int i=0;i<10;i++){
			Product producto=new Product();
			producto.setCantidad("a");
			producto.setCode("b");
			producto.setName("b");
			producto.setNorma("norma");
			productList.add(producto);
		}
		
		return productList;
	}

}
