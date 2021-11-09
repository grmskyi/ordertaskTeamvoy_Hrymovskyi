package com.example.ordertaskteamvoy_hrymovskyi.service;


import com.example.ordertaskteamvoy_hrymovskyi.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    List<Item> getAllItem();

    Optional<Item> getById(Long id);

    List<Item> getAllByMinPrice();

    List<Item> getAllByMaxPrice();

    List<Item> getAllByLowestPrice(String name_item);


}
