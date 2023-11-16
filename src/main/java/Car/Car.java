package Car;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

public class Car {
    private Long id;
    private String brand;
    private String model;
    private boolean booked;
    private Optional<LocalDateTime> bookingStartTime;

    public void setBooked() {
        if(this.booked){
            throw new CarAlreadyBookedException("Car already booked, id:" + this.id);
        }
        this.booked = true;
        this.bookingStartTime = Optional.of(LocalDateTime.now());
    }

    public void setUnband() {
        if(!this.booked){
            throw new CarNotBookedException("Car not booked, id:" + this.id);
        }
        this.booked = false;
        this.bookingStartTime = Optional.empty();
    }
}

