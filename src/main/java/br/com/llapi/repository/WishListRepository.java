package br.com.llapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.llapi.dto.ClientProductKey;
import br.com.llapi.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, ClientProductKey> {
	
}
