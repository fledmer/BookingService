package Application.controllers;

import Application.entities.Car;
import Application.pojo.MyUserPrincipal;
import Application.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

// Контроллер для обработки HTTP-запросов
@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping()
    public String getAllCars(Map<String, Object> model) {
        var cars = carService.getAllCars();
        model.put("cars", cars);
        return "/cars.html";
    }
    @GetMapping("/list")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/add")
    public String addCar(Map<String, Object> model) {
        return "/addCar.html";
    }

    @PostMapping()
    public Car addCar(@RequestBody Car car, @AuthenticationPrincipal  MyUserPrincipal principal) {
        return carService.addCar(car, principal);
    }

    @PostMapping("/{carId}/book")
    public Car bookCar(@PathVariable Long carId,@AuthenticationPrincipal   MyUserPrincipal principal) {
        return carService.bookCar(carId, principal);
    }

    @PostMapping("/{carId}/unbook")
    public Car unbookCar(@PathVariable Long carId,@AuthenticationPrincipal   MyUserPrincipal principal) {
        return carService.unbookCar(carId, principal);
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable Long carId,@AuthenticationPrincipal   MyUserPrincipal principal) {
        carService.deleteCar(carId, principal);
    }
}
