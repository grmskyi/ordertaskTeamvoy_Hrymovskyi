package com.example.ordertaskteamvoy_hrymovskyi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_item")
    private long id;

    @Column(name = "name_item")
    private String nameItem;

    private BigDecimal price;

    private int quantity;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private List<Order> orders;
}
