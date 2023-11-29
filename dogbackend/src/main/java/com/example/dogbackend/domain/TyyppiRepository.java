package com.example.dogbackend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TyyppiRepository extends CrudRepository<Tyyppi, Long> {

	List<Tyyppi> findByNimi(String nimi);
}
