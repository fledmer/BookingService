package Application.services;

import Application.entities.Car;
import Application.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Сервис для бизнес-логики автомобилей
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    private Optional<Car> byId;

    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Car bookCar(Long carId) {
        byId = carRepository.findById(carId);
        Optional<Car> optionalCar = byId;
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setBooked();
            return carRepository.save(car);
        } else {
            throw new CarNotFoundException("Car not found with id: " + carId);
        }
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
