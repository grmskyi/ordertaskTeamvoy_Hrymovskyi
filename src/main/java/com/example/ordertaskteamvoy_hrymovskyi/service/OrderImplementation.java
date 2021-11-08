package com.example.ordertaskteamvoy_hrymovskyi.service;

import com.example.ordertaskteamvoy_hrymovskyi.Model.Order;
import com.example.ordertaskteamvoy_hrymovskyi.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderImplementation implements OrderService{


    private final OrderRepo orderRepo;

    @Override
    public void save(Order order) {
        log.info("IN OrderRepoImplementation save {}",order);
        orderRepo.save(order);
    }

    @Override
    public void delete(Long id) {
        log.info("IN OrderRepoImplementation delete {}",id);
        orderRepo.deleteById(id);
    }

    @Override
    public Optional<Order> getById(Long id) {
        log.info("IN OrderRepoImplementation getById {}",id);
        return orderRepo.findById(id);
    }

    @Override
    public List<Order> getAll() {
        log.info("IN OrderRepoImplementation getAll {}");
        return orderRepo.findAll();
    }

}
