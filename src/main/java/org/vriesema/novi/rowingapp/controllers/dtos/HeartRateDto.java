package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.rowingclub.HeartRate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

import java.io.Serializable;
import java.time.LocalDate;

public class HeartRateDto implements Serializable {
    private Long heartRateId;
    private LocalDate heartRateDate;
    private int heartRate;
    private Rower rower;

    public static HeartRateDto fromHeartRate(HeartRate heartRate) {
        if (heartRate == null) return null;

        HeartRateDto heartRateDto = new HeartRateDto();

        heartRateDto.heartRateId = heartRate.getHeartRateId();
        heartRateDto.heartRateDate = heartRate.getHeartRateDate();
        heartRateDto.heartRate = heartRate.getHeartRate();
        heartRateDto.rower = heartRate.getRower();

        return heartRateDto;
    }

    public HeartRate toHeartRate() {
        HeartRate heartRate = new HeartRate();

        heartRate.setHeartRateId(heartRateId);
        heartRate.setHeartRateDate(heartRateDate);
        heartRate.setHeartRate(this.heartRate);
        heartRate.setRower(rower);

        return heartRate;
    }

    public Long getHeartRateId() {
        return heartRateId;
    }

    public void setHeartRateId(Long heartRateId) {
        this.heartRateId = heartRateId;
    }

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
