package Application.repositories;

import Application.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Репозиторий для работы с данными автомобилей
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBooked(boolean booked);
}
