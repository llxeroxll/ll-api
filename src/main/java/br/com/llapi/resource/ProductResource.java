package br.com.llapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.llapi.entity.Product;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductResource {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${operations.restURL}")
	private String serviceURL;

	public Product getById(String id) {
		Product product = null;
		try {
			product = restTemplate.getForObject(serviceURL + "/product/" + id, Product.class);
			
		}catch(HttpClientErrorException e) {
			//do nothing
		}catch(Exception e2) {
			log.error("Error while getting product from api.", e2);
		}
		
		return product;
	
	}
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

}