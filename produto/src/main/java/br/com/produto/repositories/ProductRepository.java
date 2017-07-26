package br.com.produto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.produto.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
