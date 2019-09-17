package br.com.llapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.llapi.resource.ProductResource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LlapiApplication.class)
public class ClassTest {

	@Autowired
	ProductResource prod;
	
	@Test
	public void test() {

		System.out.println(prod.getById("2b505fab-d865-e164-345d-efbd4c2045b6"));
	}
}
