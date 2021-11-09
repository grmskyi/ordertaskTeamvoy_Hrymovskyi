package com.example.ordertaskteamvoy_hrymovskyi.service;

import com.example.ordertaskteamvoy_hrymovskyi.model.Order;
import com.example.ordertaskteamvoy_hrymovskyi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService {


    private final OrderRepository orderRepository;

    @Override
    public void save(Order order) {
        log.info("IN OrderRepoImplementation save {}", order);
        orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        log.info("IN OrderRepoImplementation delete {}", id);
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> getById(Long id) {
        log.info("IN OrderRepoImplementation getById {}", id);
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAll() {
        log.info("IN OrderRepoImplementation getAll");
        return orderRepository.findAll();
    }

}
