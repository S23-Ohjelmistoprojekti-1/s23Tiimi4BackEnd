package com.example.dogbackend.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.dogbackend.domain.Vaate;

public class VaateRepository {
	public interface BookRepository extends CrudRepository<Vaate, Long>{
	    List<Vaate> findbyTitle(String tyyppi);
}
}
