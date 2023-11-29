package Application.services;

import Application.entities.Car;
import Application.exception.CarNotFoundException;
import Application.pojo.MyUserPrincipal;
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

    public Car addCar(Car car, MyUserPrincipal principal) {
        car.setOwner_id(principal.getId());
        return carRepository.save(car);
    }

    public Car bookCar(Long carId, MyUserPrincipal principal) {
        byId = carRepository.findById(carId);
        Optional<Car> optionalCar = byId;
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setBooked(principal);
            return carRepository.save(car);
        } else {
            throw new CarNotFoundException("Car not found with id: " + carId);
        }
    }

    public void deleteCar(Long carId, MyUserPrincipal principal) {
        carRepository.deleteById(carId);
    }
}
