package br.com.llapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.llapi.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
