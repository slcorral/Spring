package InterfazAlmacen;
import java.util.List;
import Modelo.Almacen;

public interface InterfazAlmacen {
	
	/**
	 * gets all store associate to the company.
	 * @param idCompany
	 * @return
	 */
	public List<Almacen> getStoresByIdCompany(long idCompany);
	
}
