package org.vriesema.novi.rowingapp.model.rowingclub;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Heartrate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long heartRateId;

    @Column
    LocalDate heartRateDate;

    @Column
    int heartRate;

    @ManyToOne
    Rower rower;

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
