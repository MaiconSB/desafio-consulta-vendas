package com.devsuperior.dsmeta.dto;

import antlr.collections.List;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

public class SellerMinDTO {
    private String name;
    private Double total;

    public SellerMinDTO(String name, Double total) {
        this.name = name;
        this.total = total;
    }

    public SellerMinDTO(Seller entity) {
        name = entity.getName();

        for (Sale obj : entity.getSales()) {
            total = obj.getAmount();
        }
    }


    public String getName() {
        return name;
    }

    public Double getTotal() {
        return total;
    }
}
