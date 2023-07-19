package co.com.bancolombia.entities.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.bancolombia.entities.Product;

public interface IProductDAO extends CrudRepository<Product, Integer> {

	@Query("SELECT u FROM Product u WHERE u.nombre=:nombre") // Dialecto SQL
	Optional<Product> findByName(@Param("nombre") String nombre);

}
