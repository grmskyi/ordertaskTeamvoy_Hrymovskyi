package com.example.ordertaskteamvoy_hrymovskyi.testsForAPI;

import com.example.ordertaskteamvoy_hrymovskyi.Model.Order;
import com.example.ordertaskteamvoy_hrymovskyi.repository.OrderRepo;
import com.example.ordertaskteamvoy_hrymovskyi.service.OrderImplementation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {
    @InjectMocks
    private OrderImplementation orderImplementation;

    @Mock
    private OrderRepo repo;

    @Test
    public void removeOrderTest() {
        Order order = new Order(1L,"Phone",
                BigDecimal.valueOf(12312412.5),3, LocalTime.now(), new ArrayList<>());
        orderImplementation.delete(order.getId());
        verify(repo,times(1)).delete(eq(order));
    }

    @Test
    public void saveOrderTest(){
        Order order = new Order(1L,"Phone",
                BigDecimal.valueOf(12233.5),3, LocalTime.now(), new ArrayList<>());
        orderImplementation.save(order);
        verify(repo,times(1)).save(eq(order));
    }

    @Test
    public void getAllOrdersTest(){
        List<Order> exp = List.of(new Order(1L,"Phone",
                        BigDecimal.valueOf(12332.5),3, LocalTime.now(), new ArrayList<>()),
            new Order(2L,"Printer",BigDecimal.valueOf(121233.5),3, LocalTime.now(), new ArrayList<>()));
        when(repo.findAll()).thenReturn(exp);
        List<Order> act = orderImplementation.getAll();
        Assert.assertEquals(exp,act);
    }
}
