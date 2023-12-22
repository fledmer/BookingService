package Application.entities;

import Application.exception.CarAlreadyBookedException;
import Application.exception.CarNotBookedException;
import javax.persistence.*;

import Application.pojo.MyUserPrincipal;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    public Long id;
    @Column(name = "brand")
    public String brand;
    @Column(name = "model")
    public String model;
    @Column(name = "owner_id")
    public Long owner_id;
    @Column(name = "booked")
    public boolean booked;
    @Column(name = "booker_id")
    private Long booker_id;
    @Column(name = "booking_start_time")
    private LocalDateTime bookingStartTime;


    public void setBooked(MyUserPrincipal user) {
        if(this.booked){
              throw new CarAlreadyBookedException("Car already booked, id:" + this.id);
        }
        this.booked = true;
        this.bookingStartTime = LocalDateTime.now();
        this.booker_id = user.getId();
    }

    public void setUnband(MyUserPrincipal user) {
        if (user.getId() != this.booker_id){
            throw new CarNotBookedException("You are not booker, id:" + this.id);
        }
        if(!this.booked){
              throw new CarNotBookedException("Car not booked, id:" + this.id);
        }
        this.booked = false;
        this.bookingStartTime = null;
    }
}

