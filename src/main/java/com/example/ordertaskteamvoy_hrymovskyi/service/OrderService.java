package com.example.ordertaskteamvoy_hrymovskyi.service;


import com.example.ordertaskteamvoy_hrymovskyi.Model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    void save(Order order);

    void delete(Long id);

    Optional<Order> getById(Long id);

    List<Order> getAll();

}