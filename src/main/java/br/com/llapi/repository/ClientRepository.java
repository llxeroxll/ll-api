package br.com.llapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.llapi.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
