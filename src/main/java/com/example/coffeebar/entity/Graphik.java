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
@Table(name = "graphiks", schema = "cafe")
public class Graphik {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_graphiks", nullable = false)
    private Integer idGraphik;

    @Basic
    @Column(name = "day_of_work", nullable = false)
    private Integer dayOfWork;

    @ManyToMany(mappedBy = "graphicSet")
    Set<Personal> personalSet;

}
