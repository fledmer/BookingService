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
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "owner_id")
    private Long owner_id;
    @Column(name = "booked")
    private boolean booked;
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
            return;
        }
        if(!this.booked){
              throw new CarNotBookedException("Car not booked, id:" + this.id);
        }
        this.booked = false;
        this.bookingStartTime = null;
    }
}

