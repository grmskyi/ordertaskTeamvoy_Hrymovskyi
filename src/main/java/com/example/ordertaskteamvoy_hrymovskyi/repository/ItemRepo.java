package com.example.ordertaskteamvoy_hrymovskyi.repository;


import com.example.ordertaskteamvoy_hrymovskyi.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

    @Query(value = "select * from item pr " +
            "where price = (select min(price) from  item )"
            , nativeQuery = true)
    List<Item> findAllByMinPrice();

    @Query(value = "select * from item pr " +
            "where price = (select max(price) from  item )"
            , nativeQuery = true)
    List<Item> findAllByMaxPrice();

    @Query(value = "select * from item pr where price " +
            "= (select min(price) from item where pr.name_item =:name) and name_item =:name",
            nativeQuery = true)
    List<Item> findAllByLowestPrice(String name);
}
