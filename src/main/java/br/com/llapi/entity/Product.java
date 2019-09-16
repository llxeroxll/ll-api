package br.com.llapi.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Product {
	
	@Id
	@Column(nullable = false, unique = true)
    private long id;
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;
    
    @Column(nullable = false)
    private String brand;
    
    private long reviewScore;
    
    @Column(nullable = false)
    private BigDecimal price;

}