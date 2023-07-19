package co.com.bancolombia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancolombia.entities.Product;
import co.com.bancolombia.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService servicio;

	@GetMapping("/producto")
	public List<Product> findAll() {
		return servicio.findAll();
	}

	@PostMapping("/producto")
	public Product salvarProducto(@RequestBody Product pr) {
		return servicio.save(pr);
	}

	@DeleteMapping("/producto/{id}")
	public void deleteById(@PathVariable("id") int id) {
		servicio.deleteById(id);
	}

	@PutMapping("/productou")
	public void update(@RequestBody Product pr) {
		servicio.update(pr);
	}

	@GetMapping("/producton/{name}")
	public Product findByName(@PathVariable("name") String name) {
		return servicio.findByName(name);
	}

	@GetMapping("/productoid/{id}")
	public Product findById(@PathVariable("id") int id) {
		return servicio.findById(id);
	}

}
