package br.com.produto.web.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.models.Product;
import br.com.produto.service.ProductService;

@RestController
@RequestMapping("/product")
// @Controller
public class ProductResource {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/rest/products", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> list() {
		return productService.listAllProducts();
	}

	@RequestMapping(value = "/rest/products/{id:\\d+}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Product productGetId = productService.getProductById(id);
		return new ResponseEntity<Product>(productGetId, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/products", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product productSave = productService.saveProduct(product);
		return new ResponseEntity<Product>(productSave, HttpStatus.CREATED);
	}
	
//	@RequestMapping(value = "/rest/products/{id:\\d+}", method = RequestMethod.PUT, 
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public String updateProduct(@PathVariable Integer id){
//		productService.getProductById(id);
//		System.out.println("#####TESTE-UPDATE#####");
//		return "redirect:/rest/products";
//	}
	@RequestMapping(value = "/rest/products/{id:\\d+}", method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@PathVariable Integer id,Product product){
		Product products = productService.getProductById(id);
		if (products == null){
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		products.setId(product.getId());
		products.setDescription(product.getDescription());
		products.setPrice(product.getPrice());
		
		productService.saveProduct(product);
		return new ResponseEntity<Product>(products, HttpStatus.OK);
	}
	
//	 @ResponseStatus(HttpStatus.OK)
//	 @RequestMapping(value = "/rest/products/{id:\\d+}", method =  RequestMethod.DELETE,
//			 produces = MediaType.APPLICATION_JSON_VALUE)
//	 public String deleteProduct(@PathVariable Integer id){
//		 productService.deleteProduct(id);
//		 return "redirect:/rest/products";
//	 }

	@RequestMapping(value = "/rest/products/{id:\\d+}", method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id) {
		this.productService.deleteProduct(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

}
