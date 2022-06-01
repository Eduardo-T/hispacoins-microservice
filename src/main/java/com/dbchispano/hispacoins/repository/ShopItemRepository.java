package com.dbchispano.hispacoins.repository;

import com.dbchispano.hispacoins.domain.ShopItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShopItemRepository extends CrudRepository<ShopItem, UUID> {
}
