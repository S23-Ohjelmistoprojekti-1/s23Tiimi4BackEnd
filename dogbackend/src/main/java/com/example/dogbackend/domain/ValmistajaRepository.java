package com.example.dogbackend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValmistajaRepository extends CrudRepository<Valmistaja, Long> {

	List<Valmistaja> findbyName(String nimi);
}
