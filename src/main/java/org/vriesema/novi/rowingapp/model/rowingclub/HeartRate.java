package org.vriesema.novi.rowingapp.model.rowingclub;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class HeartRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long heartRateId;

    @Column
    private LocalDate heartRateDate;

    @Column
    private int heartRate;

    @ManyToOne
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
    // TODO json ignore while fetching rower?
    public Rower getRower() {
        return rower;
    }

    public void setRower(Rower rower) {
        this.rower = rower;
    }

    public Long getHeartRateId() {
        return heartRateId;
    }

    public void setHeartRateId(Long heartRateId) {
        this.heartRateId = heartRateId;
    }
}
