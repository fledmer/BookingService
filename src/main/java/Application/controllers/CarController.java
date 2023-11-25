package Application.controllers;

import Application.entities.Car;
import Application.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Контроллер для обработки HTTP-запросов
@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PostMapping("/{carId}/book")
    public Car bookCar(@PathVariable Long carId) {
        return carService.bookCar(carId);
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
    }
}
