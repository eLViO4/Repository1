package com.springBoot.e.springBoot.e.Repository;

import com.springBoot.e.springBoot.e.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
