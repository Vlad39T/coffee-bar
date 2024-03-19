package com.example.coffeebar.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "clients", schema = "cafe")
@Component
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_clients", nullable = false)
    private Long idClient;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    private String phone;

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @Basic
    @Column(name = "day_of_birth", nullable = true)
    private Date birthday;

    @Basic
    @Column(name = "discount", nullable = true, precision = 2)
    private Integer discount;

    @OneToMany(mappedBy = "client")
    Set<Order> orderSet;
}
