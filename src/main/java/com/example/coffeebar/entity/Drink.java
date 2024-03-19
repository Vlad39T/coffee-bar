package com.example.coffeebar.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
@Table(name = "drinks", schema = "cafe")
public class Drink {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_drinks", nullable = false)
    private Integer idDrink;

    @Basic
    @Column(name = "name_ua", nullable = false, length = 255)
    private String nameUa;

    @Basic
    @Column(name = "name_en", nullable = false, length = 255)
    private String nameEn;

    @Basic
    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToMany(mappedBy = "drinkSet")
    Set<Order> orderSet;
}
