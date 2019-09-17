package br.com.llapi.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ClientProductKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8959843101865454088L;

	private long clientId;
	
	private String productId;
	
}