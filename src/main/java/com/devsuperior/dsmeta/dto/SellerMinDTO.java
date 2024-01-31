package com.devsuperior.dsmeta.dto;

import antlr.collections.List;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

import java.time.LocalDate;

public class SellerMinDTO {

    private String name;
    private Double total;

    public SellerMinDTO(Long id, String name, Double total) {
        this.name = name;
        this.total = total;
    }

    public SellerMinDTO(Seller entity, LocalDate minDate, LocalDate maxDate) {
        name = entity.getName();
        total = 0.0;

        for (Sale obj : entity.getSales()) {
            if (obj.getDate().isAfter(minDate) && obj.getDate().isBefore(maxDate)) {
                total += obj.getAmount();
            }
        }
    }


    public String getName() {
        return name;
    }

    public Double getTotal() {
        return total;
    }
}
