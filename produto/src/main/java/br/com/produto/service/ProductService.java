package br.com.produto.service;

import java.util.List;

import br.com.produto.models.Product;

public interface ProductService {
	
	List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
