package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.rowingclub.HeartRate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

import java.io.Serializable;
import java.time.LocalDate;

public class HeartRateDto implements Serializable {
    private long heartRateId;
    private LocalDate heartRateDate;
    private int heartRate;
    private Rower rower;
    private long averageHeartRate;

    public static HeartRateDto fromHeartRate(HeartRate heartRate) {
        if (heartRate == null) return null;

        HeartRateDto heartRateDto = new HeartRateDto();

        heartRateDto.heartRateId = heartRate.getHeartRateId();
        heartRateDto.heartRateDate = heartRate.getHeartRateDate();
        heartRateDto.heartRate = heartRate.getHeartRate();
        heartRateDto.rower = heartRate.getRower();
        heartRateDto.averageHeartRate = heartRate.getAverageHeartRate();

        return heartRateDto;
    }

    public HeartRate toHeartRate() {
        HeartRate newHeartRate = new HeartRate();

        newHeartRate.setHeartRateId(heartRateId);
        newHeartRate.setHeartRateDate(heartRateDate);
        newHeartRate.setHeartRate(heartRate);
        newHeartRate.setRower(rower);
        newHeartRate.setAverageHeartRate(averageHeartRate);

        return newHeartRate;
    }

    public long getHeartRateId() {
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

    public long getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(long averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }
}
