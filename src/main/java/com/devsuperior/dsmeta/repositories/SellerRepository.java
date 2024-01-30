package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query(value = "SELECT s FROM Seller s " +
            "LEFT JOIN s.sales sa " +
            "WHERE UPPER(s.name) LIKE UPPER(concat('%', :name, '%')) " +
            "AND sa.date BETWEEN :minDate AND :maxDate",
            countQuery = "SELECT COUNT(s) FROM Seller s WHERE UPPER(s.name) LIKE UPPER(concat('%', :name, '%'))")
    Page<Seller> searchSale(String name, LocalDate minDate, LocalDate maxDate, Pageable pageable);

}
