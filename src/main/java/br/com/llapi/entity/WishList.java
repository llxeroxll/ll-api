package br.com.llapi.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import br.com.llapi.dto.ClientProductKey;
import lombok.Getter;
import lombok.Setter;

@Entity
public class WishList {

	@EmbeddedId
	@Getter
	@Setter
	private ClientProductKey id;
	
	public void setId(long clientId, String productId) {
		
		if(id == null)
			id = new ClientProductKey();
		
		this.id.setClientId(clientId);
		this.id.setProductId(productId);
	}
	
	public long getClientId() {
		
		return this.getClientId();
	}
	
	public String getProductId() {
		
		return this.getProductId();
	}
	
}
