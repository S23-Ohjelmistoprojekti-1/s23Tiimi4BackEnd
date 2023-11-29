package com.example.dogbackend.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
// import com.example.dogbackend.domain.Vaate;

public interface VaateRepository extends CrudRepository<Vaate, Long>{
		List<Vaate> findByTyyppiIgnoreCase(String tyyppi);
		List<Vaate> findByValmistaja(Valmistaja valmistaja);
}

