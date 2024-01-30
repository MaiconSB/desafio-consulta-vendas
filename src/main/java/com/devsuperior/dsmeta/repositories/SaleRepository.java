package com.devsuperior.dsmeta.repositories;

<<<<<<< HEAD
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.entities.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT s FROM Sale s " +
            "LEFT JOIN s.seller sa " +
            "WHERE UPPER(sa.name) LIKE UPPER(concat('%', :name, '%')) " +
            "AND s.date BETWEEN :minDate AND :maxDate",
            countQuery = "SELECT COUNT(s) FROM Sale s " +
                    "LEFT JOIN s.seller sa " +
                    "WHERE UPPER(sa.name) LIKE UPPER(concat('%', :name, '%')) " +
                    "AND s.date BETWEEN :minDate AND :maxDate")
    Page<Sale> searchSale(String name, LocalDate minDate, LocalDate maxDate, Pageable pageable);

    @Query(value = "SELECT s FROM Seller s " +
            "LEFT JOIN s.sales sa " +
            "WHERE UPPER(s.name) LIKE UPPER(concat('%', :name, '%')) " +
            "AND sa.date BETWEEN :minDate AND :maxDate",
            countQuery = "SELECT COUNT(s) FROM Seller s WHERE UPPER(s.name) LIKE UPPER(concat('%', :name, '%'))")
    Page<Seller> searchSeller(String name, LocalDate minDate, LocalDate maxDate, Pageable pageable);

}
