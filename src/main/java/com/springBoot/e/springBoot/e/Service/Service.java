package com.springBoot.e.springBoot.e.Service;

import com.springBoot.e.springBoot.e.Entity.Car;

import java.util.List;
import java.util.Optional;

public interface Service {

    List<Car> getAllCars();

    Optional<Car> getCarById(int id);

    Car saveCar(Car car);

    void deleteCar(int id);
}
