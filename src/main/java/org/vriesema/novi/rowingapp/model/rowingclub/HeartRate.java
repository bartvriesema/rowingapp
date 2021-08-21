package org.vriesema.novi.rowingapp.model.rowingclub;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference(value = "rower")
    private Rower rower;

    @Transient
    private long averageHeartRate;

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

    public Long getHeartRateId() {
        return heartRateId;
    }

    public void setHeartRateId(Long heartRateId) {
        this.heartRateId = heartRateId;
    }

    public long getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(long averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }
}
