package com.commerce.interfazProduct;

import java.util.List;
import java.util.Map;

import com.commerce.modelo.Product;
import com.commerce.modelo.exception.LogicException;

public interface InterfazProduct {

	
     public void addProduct(Product product) throws LogicException;
     public int deleteProduct(Product product) throws LogicException;
     
     public void updateProduct(Product product) throws LogicException;
     public void updateProduct(Map<String,Object> mapProperties) throws LogicException;
     
     public int deleteProductById(Long id) throws LogicException;
     public int addProductBatch(List<Product> product) throws LogicException;
     
     public int deleteProductBatch(Product product) throws LogicException;
     public int updateProductBatch(Map<Long,Map<String,Object>> mapProperties) throws LogicException;
     
     /**
      * This method looks for the product by IdProduct
      * @param id
      * @return The product associate to this id.
      * 		null if not exit anything product.
      * @throws LogicException
      */
     public Product getProductById(Long id) throws LogicException;
     
     public List<Product> getListProduct(Long inic,Long fin) throws LogicException;
    	 
}
