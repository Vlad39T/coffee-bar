package com.example.coffeebar.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
@Entity
@Table(name = "personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal")
    Long idPersonal;

    String name;

    String phone;

    String address;

    @OneToMany(mappedBy = "personal")
    Set<Order> orderSet;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    Position position;

    @ManyToMany
    @JoinTable(
            name = "personal_graphiks",
            joinColumns = @JoinColumn(name = "personal_id"),
            inverseJoinColumns = @JoinColumn(name = "graphiks_id"))
    Set<Graphik> graphicSet;

    public Personal(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
