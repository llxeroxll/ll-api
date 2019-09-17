package br.com.llapi.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product {
	
	@Id
    private String id;
    
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