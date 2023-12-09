package com.example.dogbackend.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
// import com.example.dogbackend.domain.Vaate;

public interface TuoteRepository extends CrudRepository<Tuote, Long>{

		List<Tuote> findByTyyppi(Tyyppi tyyppi);
		List<Tuote> findByValmistaja(Valmistaja valmistaja);
}