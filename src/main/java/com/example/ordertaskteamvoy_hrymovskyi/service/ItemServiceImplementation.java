package com.example.ordertaskteamvoy_hrymovskyi.service;

import com.example.ordertaskteamvoy_hrymovskyi.model.Item;
import com.example.ordertaskteamvoy_hrymovskyi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImplementation implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        log.info("IN ItemRepoImplementation save {}", item);
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItem() {
        log.info("IN ItemRepoImplementation getAllItem");
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getById(Long id) {
        log.info("IN ItemRepoImplementation getById {}", id);
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> getAllByMinPrice() {
        log.info("IN ItemRepoImplementation getAllByMinPrice");
        return itemRepository.findAllByMinPrice();
    }

    @Override
    public List<Item> getAllByMaxPrice() {
        log.info("IN ItemRepoImplementation getAllByMaxPrice");
        return itemRepository.findAllByMaxPrice();
    }

    @Override
    public List<Item> getAllByLowestPrice(String name_item) {
        log.info("IN ItemRepoImplementation getAllByLowestPrice {}", name_item);
        return itemRepository.findAllByLowestPrice(name_item);
    }
}
