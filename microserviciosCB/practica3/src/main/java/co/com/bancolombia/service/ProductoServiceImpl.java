package co.com.bancolombia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.com.bancolombia.entities.Product;
import co.com.bancolombia.entities.repository.IProductDAO;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductDAO dao;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return (List<Product>) dao.findAll();
	}

	@Override
	public Product save(Product p) {
		// TODO Auto-generated method stub
		return dao.save(p);
	}

	@Override
	public boolean update(Product p) {
		// TODO Auto-generated method stub
		if (dao.existsById(p.getId())) {
			dao.save(p);
		}
		return false;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		if (dao.existsById(id)) {
			dao.deleteById(id);
			;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado ");

	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name).stream().findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

	}

}
