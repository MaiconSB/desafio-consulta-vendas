package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class SellerService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleMinDTO> findSeller (String name, String minDate, String maxDate, Pageable pageable){
		LocalDate convertedMinDate = (minDate != null && !minDate.isEmpty()) ?
				LocalDate.parse(minDate, DateTimeFormatter.ISO_LOCAL_DATE) : LocalDate.now().minusYears(1L);
		LocalDate convertedMaxDate = (maxDate != null && !maxDate.isEmpty()) ?
				LocalDate.parse(maxDate, DateTimeFormatter.ISO_LOCAL_DATE) : LocalDate.now();

		Page<Sale> dto = repository.searchSale(name, convertedMaxDate, convertedMinDate, pageable);
		return dto.map(x -> new SaleMinDTO(x));
	}
}
