package com.example.ordertaskteamvoy_hrymovskyi.repository;


import com.example.ordertaskteamvoy_hrymovskyi.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
