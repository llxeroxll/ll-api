package br.com.llapi.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;


@Entity
@Getter
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;
    
    @Column(nullable = false)
    private String brand;
    
    @Column(nullable = false)
    private long reviewScore;
    
    @Column(nullable = false)
    private BigDecimal price;

}