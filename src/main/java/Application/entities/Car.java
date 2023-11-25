package Application.entities;

import Application.services.CarAlreadyBookedException;
import Application.services.CarNotBookedException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Setter
@Getter
public class Car {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "booked")
    private boolean booked;
    @Column(name = "booking_start_time")
    private LocalDateTime bookingStartTime;

    public void setBooked() {
        if(this.booked){
              throw new CarAlreadyBookedException("Car already booked, id:" + this.id);
        }
        this.booked = true;
        this.bookingStartTime = LocalDateTime.now();
    }

    public void setUnband() {
        if(!this.booked){
              throw new CarNotBookedException("Car not booked, id:" + this.id);
        }
        this.booked = false;
        this.bookingStartTime = null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getBookingStartTime() {
        return bookingStartTime;
    }

    public void setBookingStartTime(LocalDateTime bookingStartTime) {
        this.bookingStartTime = bookingStartTime;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isBooked() {
        return booked;
    }
}

