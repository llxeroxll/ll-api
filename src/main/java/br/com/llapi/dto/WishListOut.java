package br.com.llapi.dto;

import java.util.List;

import br.com.llapi.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishListOut {
	 
	private long clientId;
    
	private List<Product> favoritProducts;
	
	private int page;
	
	private int nextPage;
    
}
