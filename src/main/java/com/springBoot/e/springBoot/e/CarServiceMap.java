package com.springBoot.e.springBoot.e;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarServiceMap {

    private final CarRepository carRepository;
    private Map<Integer, Car> mapOfCars = new HashMap<>();

    @Autowired
    public CarServiceMap(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        Car savedCar = carRepository.save(car);
        saveCarToMap(savedCar);
        return savedCar;
    }

    public void deleteCar(int id) {
        deleteCarFromMap(id);
        carRepository.deleteById(id);
    }

    //***********************************************************************************************

    @PostConstruct
    private void loadFromSQL() {
        List<Car> cars = carRepository.findAll();
        for (Car i : cars) {
            mapOfCars.put(i.getId(), i);
        }
    }

    public void saveCarToMap(Car car) {
        mapOfCars.put(car.getId(), car);
    }

    public void deleteCarFromMap(int id) {
        mapOfCars.remove(id);
    }
}
