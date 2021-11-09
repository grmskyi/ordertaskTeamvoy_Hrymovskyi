package com.example.ordertaskteamvoy_hrymovskyi.repository;


import com.example.ordertaskteamvoy_hrymovskyi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
