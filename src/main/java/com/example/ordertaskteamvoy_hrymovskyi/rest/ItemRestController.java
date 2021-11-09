package com.example.ordertaskteamvoy_hrymovskyi.rest;


import com.example.ordertaskteamvoy_hrymovskyi.model.Item;
import com.example.ordertaskteamvoy_hrymovskyi.model.Order;
import com.example.ordertaskteamvoy_hrymovskyi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/items/")
@RequiredArgsConstructor
public class ItemRestController {
    private final ItemService itemService;

    //method saveItems
    @PostMapping
    public ResponseEntity<Item> saveItems(@RequestBody Item item) {
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    //method getAllItems
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> item = itemService.getAllItem();
        if (item.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //method getItemById
    @GetMapping(value = "{id}")
    public ResponseEntity<Order> getItemById(@PathVariable("id") Long itemId) {
        if (itemId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Item> item = itemService.getById(itemId);

        if (item.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //method getAllByMinItems
    @GetMapping("/allMinPrice")
    public List<Item> getAllByMinItems() {
        return itemService.getAllByMinPrice();
    }

    //method getAllByMaxItems
    @GetMapping("/allMaxPrice")
    public List<Item> getAllByMaxItems() {
        return itemService.getAllByMaxPrice();
    }

    //method getAllByLowestPrice
    @GetMapping("/allByLowestPrice")
    public List<Item> getAllByLowestPrice(String name_item) {
        return itemService.getAllByLowestPrice(name_item);
    }
}
