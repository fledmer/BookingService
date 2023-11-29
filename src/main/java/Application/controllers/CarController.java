package Application.controllers;

import Application.entities.Car;
import Application.pojo.MyUserPrincipal;
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
    public Car addCar(@RequestBody Car car, MyUserPrincipal principal) {
        return carService.addCar(car, principal);
    }

    @PostMapping("/{carId}/book")
    public Car bookCar(@PathVariable Long carId, MyUserPrincipal principal) {
        return carService.bookCar(carId, principal);
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable Long carId, MyUserPrincipal principal) {
        carService.deleteCar(carId, principal);
    }
}
