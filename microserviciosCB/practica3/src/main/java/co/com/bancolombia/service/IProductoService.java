package co.com.bancolombia.service;

import java.util.List;

import co.com.bancolombia.entities.Product;

public interface IProductoService {

	List<Product> findAll();

	Product save(Product p);

	boolean update(Product p);

	void deleteById(int id);

	Product findByName(String name);

	Product findById(int id);
}
