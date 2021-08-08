package org.vriesema.novi.rowingapp.model.rowingclub;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Heartrate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long heartRateId;

    @Column
    private LocalDate heartRateDate;

    @Column
    private int heartRate;

    @ManyToOne
    @JoinColumn(name = "rower_person_id")
    private Rower rower;

    public LocalDate getHeartRateDate() {
        return heartRateDate;
    }

    public void setHeartRateDate(LocalDate heartRateDate) {
        this.heartRateDate = heartRateDate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public Rower getRower() {
        return rower;
    }

    public void setRower(Rower rower) {
        this.rower = rower;
    }
}
