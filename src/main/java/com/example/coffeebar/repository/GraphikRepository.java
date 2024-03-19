package com.example.coffeebar.repository;

import com.example.coffeebar.entity.Graphik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphikRepository extends JpaRepository<Graphik,Long> {
}
