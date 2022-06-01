package com.dbchispano.hispacoins.controller;

import com.dbchispano.hispacoins.domain.ShopItem;
import com.dbchispano.hispacoins.service.ShopItemService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/shop")
public class ShopItemController {

    private final ShopItemService SHOP_SERVICE;

    public ShopItemController(ShopItemService shopService) {
        SHOP_SERVICE = shopService;
    }

    @GetMapping("/all")
    public Iterable<ShopItem> all() {
        return SHOP_SERVICE.getAll();
    }

    @GetMapping
    public ShopItem getItem(@RequestParam("item") UUID itemId) {
        return SHOP_SERVICE.getById(itemId).orElseThrow(NullPointerException::new);
    }

    @PostMapping
    public ShopItem postItem(@RequestBody ShopItem item) {
        return SHOP_SERVICE.create(item);
    }

}
