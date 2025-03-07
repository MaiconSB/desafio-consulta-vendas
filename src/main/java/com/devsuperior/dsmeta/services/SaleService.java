package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleMinDTO> findSale(String name, String minDate, String maxDate, Pageable pageable) {
		LocalDate convertedMinDate = (minDate != null && !minDate.isEmpty()) ?
				LocalDate.parse(minDate, DateTimeFormatter.ISO_LOCAL_DATE) : LocalDate.now().minusYears(1L);
		LocalDate convertedMaxDate = (maxDate != null && !maxDate.isEmpty()) ?
				LocalDate.parse(maxDate, DateTimeFormatter.ISO_LOCAL_DATE) : LocalDate.now();

		Page<Sale> sales = repository.searchSale(name, convertedMinDate, convertedMaxDate, pageable);

		return sales.map(sale -> new SaleMinDTO(sale));
	}

	public List<SellerMinDTO> findSeller(String name, String minDate, String maxDate) {
		LocalDate convertedMinDate = (minDate != null && !minDate.isEmpty()) ?
				LocalDate.parse(minDate, DateTimeFormatter.ISO_LOCAL_DATE) : LocalDate.now().minusYears(1L);
		LocalDate convertedMaxDate = (maxDate != null && !maxDate.isEmpty()) ?
				LocalDate.parse(maxDate, DateTimeFormatter.ISO_LOCAL_DATE) : LocalDate.now();

		List<Seller> sellers = repository.searchSeller(name, convertedMinDate, convertedMaxDate);

			return sellers.stream().map(seller -> new SellerMinDTO(seller, convertedMinDate, convertedMaxDate)).collect(Collectors.toList());
	}
}
