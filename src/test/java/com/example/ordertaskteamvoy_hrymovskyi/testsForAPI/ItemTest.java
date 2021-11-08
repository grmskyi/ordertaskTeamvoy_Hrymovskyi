package com.example.ordertaskteamvoy_hrymovskyi.testsForAPI;
import com.example.ordertaskteamvoy_hrymovskyi.Model.Item;
import com.example.ordertaskteamvoy_hrymovskyi.repository.ItemRepo;
import com.example.ordertaskteamvoy_hrymovskyi.service.ItemImplementation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ItemTest {

    @InjectMocks
    private ItemImplementation itemImplementation;

    @Mock
    ItemRepo itemRepo;

    @Test
    public void itemGetTest(){
        Optional<Item> exp = Optional.of(new Item(1L, "NoteBook",
                BigDecimal.valueOf(123123.5), 4,new ArrayList<>()));
        when(itemRepo.findById(1L)).thenReturn(exp);
        Optional<Item> actual = itemImplementation.getById(1L);
        Assert.assertEquals(exp,actual);
    }

    @Test
    public void itemWithLowerPriceTest(){
        List<Item> exp = List.of(new Item(1L, "name",
                BigDecimal.valueOf(123.5),5, new ArrayList<>()));
        when(itemRepo.findAllByLowestPrice("name")).thenReturn(exp);
        List<Item> act = itemImplementation.getAllByLowestPrice("name");
        Assert.assertEquals(exp,act);
    }

}
