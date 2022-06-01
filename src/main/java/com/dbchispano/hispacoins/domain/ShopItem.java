package com.dbchispano.hispacoins.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "shop_items")
public class ShopItem extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "MEDIUMTEXT")
    private String description;
    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long price;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @ElementCollection
    @Column(name = "command")
    private List<String> commands;

    public ShopItem(String name, String description, Long price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ShopItem() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
