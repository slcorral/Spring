package WebServicesDAO;

import java.util.List;
import java.util.Map;

import Modelo.Product;
import Modelo.Excepciones.LogicException;
import WebServices.InterfazProduct;


public class ProductWebService  implements InterfazProduct {

	@Override
	public void addProduct(Product product) throws LogicException {
		// TODO Auto-generated method stub
		
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
	public Product getProductById(Long id) throws LogicException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getListProduct(Long inic, Long fin)
			throws LogicException {
		// TODO Auto-generated method stub
		return null;
	}

}
