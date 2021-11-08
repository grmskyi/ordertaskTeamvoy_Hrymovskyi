package com.example.ordertaskteamvoy_hrymovskyi.service;

import com.example.ordertaskteamvoy_hrymovskyi.Model.Item;
import com.example.ordertaskteamvoy_hrymovskyi.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemImplementation implements ItemService{

    private  final ItemRepo itemRepo;

    @Override
    public void save(Item item) {
        log.info("IN ItemRepoImplementation save {}",item);
        itemRepo.save(item);
    }

    @Override
    public List<Item> getAllItem() {
        log.info("IN ItemRepoImplementation getAllItem {}");
        return itemRepo.findAll();
    }

    @Override
    public Optional<Item> getById(Long id) {
        log.info("IN ItemRepoImplementation getById {}",id);
        return itemRepo.findById(id);
    }

    @Override
    public List<Item> getAllByMinPrice() {
        log.info("IN ItemRepoImplementation getAllByMinPrice {}");
        return itemRepo.findAllByMinPrice();
    }

    @Override
    public List<Item> getAllByMaxPrice() {
        log.info("IN ItemRepoImplementation getAllByMaxPrice {}");
        return itemRepo.findAllByMaxPrice();
    }

    @Override
    public List<Item> getAllByLowestPrice(String name_item) {
        log.info("IN ItemRepoImplementation getAllByLowestPrice {}",name_item);
        return itemRepo.findAllByLowestPrice(name_item);
    }
}
