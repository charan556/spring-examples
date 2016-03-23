package charan.example.repositories;

import org.springframework.data.repository.CrudRepository;

import charan.example.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
