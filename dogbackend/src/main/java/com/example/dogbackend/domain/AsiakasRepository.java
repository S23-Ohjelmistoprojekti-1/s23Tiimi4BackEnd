package com.example.dogbackend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsiakasRepository extends CrudRepository<Asiakas, Long>{
	List<Asiakas> findBySukunimi(String sukunimi);

}
