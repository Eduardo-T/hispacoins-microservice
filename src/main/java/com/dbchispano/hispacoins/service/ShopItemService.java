package com.dbchispano.hispacoins.service;

import com.dbchispano.hispacoins.domain.ShopItem;
import com.dbchispano.hispacoins.repository.ShopItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ShopItemService {

    private final ShopItemRepository REPOSITORY;

    public ShopItemService(ShopItemRepository shopItemRepository) {
        this.REPOSITORY = shopItemRepository;
    }

    public ShopItem create(ShopItem item) {
        return REPOSITORY.save(item);
    }

    public boolean contains(ShopItem shopItem) {
        return getById(shopItem.getId()).isPresent();
    }

    public Optional<ShopItem> getById(UUID uuid) {
        return REPOSITORY.findById(uuid);
    }

    public Iterable<ShopItem> getAll() {
        return REPOSITORY.findAll();
    }

}
