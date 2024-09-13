package com.springBoot.e.springBoot.e;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<Car> getAllCars();

    Optional<Car> getCarById(int id);

    Car saveCar(Car car);

    void deleteCar(int id);
}
