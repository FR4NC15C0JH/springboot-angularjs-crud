package br.com.produto;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.produto.service.ProductService;
import br.com.produto.web.resources.ProductResource;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(ProductResource.class)
public class ProdutoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
//	@Test
//	public void testDelete() throws Exception{
//		this.mockMvc.perform(MockMvcRequestBuilders.delete("/product/rest/products/delete/9"))
//			.andExpect(status().isOk());
//	}
	
	@Test
	public void testUpdate() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.put("/product/rest/products/update/130"))
		.andExpect(status().isOk());
	}
	
//	@Test
//	public void testGetAll() throws Exception{
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/product/rest/products/"))
//			.andExpect(status().isOk());
//		
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/product/rest/products/"))
//	    	.andExpect(status().isNotFound());
//		
//	}
	
//	@Test
//	public void testGetByProduct() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/product/rest/products/9"))
//			.andExpect(status().isOk());
//	}
}
