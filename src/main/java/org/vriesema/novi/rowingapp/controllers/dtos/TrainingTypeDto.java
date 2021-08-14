package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;

import java.io.Serializable;

public class TrainingTypeDto implements Serializable {
    private Long trainingTypeId;
    private String shortDescription;
    private int lowerHeartRate;
    private int upperHeartRate;

    public static TrainingTypeDto fromTrainingType(TrainingType trainingType) {
        if (trainingType == null) return null;

        TrainingTypeDto trainingTypeDto = new TrainingTypeDto();

        trainingTypeDto.trainingTypeId = trainingType.getTrainingTypeId();
        trainingTypeDto.shortDescription = trainingType.getShortDescription();
        trainingTypeDto.lowerHeartRate = trainingType.getLowerHeartRate();
        trainingTypeDto.upperHeartRate = trainingType.getUpperHeartRate();

        return trainingTypeDto;
    }

    public TrainingType toTrainingType() {
        TrainingType trainingType = new TrainingType();

        trainingType.setTrainingTypeId(trainingTypeId);
        trainingType.setShortDescription(shortDescription);
        trainingType.setLowerHeartRate(lowerHeartRate);
        trainingType.setUpperHeartRate(upperHeartRate);

        return trainingType;
    }

    public Long getTrainingTypeId() {
        return trainingTypeId;
    }

    public void setTrainingTypeId(Long trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getLowerHeartRate() {
        return lowerHeartRate;
    }

    public void setLowerHeartRate(int lowerHeartRate) {
        this.lowerHeartRate = lowerHeartRate;
    }

    public int getUpperHeartRate() {
        return upperHeartRate;
    }

    public void setUpperHeartRate(int upperHeartRate) {
        this.upperHeartRate = upperHeartRate;
    }
}
