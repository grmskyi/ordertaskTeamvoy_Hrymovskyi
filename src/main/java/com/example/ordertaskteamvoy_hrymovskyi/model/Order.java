package com.example.ordertaskteamvoy_hrymovskyi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "OrderItems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    @Column(name = "name_order")
    private String nameOrder;

    private BigDecimal price;

    private int quantity;

    private LocalTime dateOfCreation;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "order_item",
            joinColumns = {@JoinColumn(name = "id_order")},
            inverseJoinColumns = {@JoinColumn(name = "id_item")}
    )
    private List<Item> items;

}
