package com.example.ordertaskteamvoy_hrymovskyi.testsForAPI;

import com.example.ordertaskteamvoy_hrymovskyi.model.Item;
import com.example.ordertaskteamvoy_hrymovskyi.repository.ItemRepository;
import com.example.ordertaskteamvoy_hrymovskyi.service.ItemServiceImplementation;
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

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ItemTest {

    @InjectMocks
    private ItemServiceImplementation itemServiceImplementation;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void itemGetTest() {
        Optional<Item> exp = Optional.of(new Item(1L, "NoteBook",
                BigDecimal.valueOf(123123.5), 4, new ArrayList<>()));
        when(itemRepository.findById(1L)).thenReturn(exp);
        Optional<Item> actual = itemServiceImplementation.getById(1L);
        Assert.assertEquals(exp, actual);
    }

    @Test
    public void itemWithLowerPriceTest() {
        List<Item> exp = List.of(new Item(1L, "name",
                BigDecimal.valueOf(123.5), 5, new ArrayList<>()));
        when(itemRepository.findAllByLowestPrice("Phone")).thenReturn(exp);
        List<Item> act = itemServiceImplementation.getAllByLowestPrice("Phone");
        Assert.assertEquals(exp, act);
    }

}
