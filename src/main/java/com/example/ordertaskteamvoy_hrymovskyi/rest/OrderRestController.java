package com.example.ordertaskteamvoy_hrymovskyi.rest;

import com.example.ordertaskteamvoy_hrymovskyi.Model.Order;
import com.example.ordertaskteamvoy_hrymovskyi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders/")
@RequiredArgsConstructor
public class OrderRestController {


    private final OrderService orderService;


    //method GetOrderById
    @GetMapping(value = "{id}")
    public ResponseEntity<Order> GetOrderById(@PathVariable("id") Long orderId){
        if(orderId==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Order> order = orderService.getById(orderId);

        if(order.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //method SaveOrder
    @PostMapping
    public ResponseEntity<Order> saveOrders(@RequestBody Order order){
        HttpHeaders headers = new HttpHeaders();

        if(order==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.orderService.save(order);
        return new ResponseEntity<>(order,headers, HttpStatus.CREATED);
    }

    //method DeleteOrder
    @DeleteMapping(value = "{id}")
    public void deleteOrders(Long id){
        List<Order> orders = orderService.getAll();
        for (Order order: orders) {
            if(Duration.between(order.getDateOfCreation(), LocalTime.now()).toMinutes() > 10){
                order.setItems(null);
                orderService.delete(id);
            }
        }
    }
    //method GetAllOrders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAll();
        if(orders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

