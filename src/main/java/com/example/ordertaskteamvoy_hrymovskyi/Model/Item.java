package com.example.ordertaskteamvoy_hrymovskyi.Model;

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

    private String name_item;

    private BigDecimal price;

    private Integer quantity;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private List<Order> orders;
}
