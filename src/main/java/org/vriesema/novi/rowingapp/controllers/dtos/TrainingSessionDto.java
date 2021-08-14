package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TrainingSessionDto implements Serializable {
    private long trainingSessionId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String shortDescription;
    private String longDescription;
    private TrainingType trainingType;
    private TrainingSchedule trainingSchedule;

    public static TrainingSessionDto fromTrainingSession(TrainingSession trainingSession) {
        if (trainingSession == null) return null;

        TrainingSessionDto trainingSessionDto = new TrainingSessionDto();

        trainingSessionDto.trainingSessionId = trainingSession.getTrainingSessionId();
        trainingSessionDto.startTime = trainingSession.getStartTime();
        trainingSessionDto.endTime = trainingSession.getEndTime();
        trainingSessionDto.shortDescription = trainingSession.getShortDescription();
        trainingSessionDto.longDescription = trainingSession.getLongDescription();
        trainingSessionDto.trainingType = trainingSession.getTrainingType();
        trainingSessionDto.trainingSchedule = trainingSession.getTrainingSchedule();

        return trainingSessionDto;
    }

    public TrainingSession toTrainingSession() {
        TrainingSession trainingSession = new TrainingSession();

        trainingSession.setTrainingSessionId(trainingSessionId);
        trainingSession.setStartTime(startTime);
        trainingSession.setEndTime(endTime);
        trainingSession.setShortDescription(shortDescription);
        trainingSession.setLongDescription(longDescription);
        trainingSession.setTrainingType(trainingType);
        trainingSession.setTrainingSchedule(trainingSchedule);

        return trainingSession;
    }

    public long getTrainingSessionId() {
        return trainingSessionId;
    }

    public void setTrainingSessionId(long trainingSessionId) {
        this.trainingSessionId = trainingSessionId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public TrainingSchedule getTrainingSchedule() {
        return trainingSchedule;
    }

    public void setTrainingSchedule(TrainingSchedule trainingSchedule) {
        this.trainingSchedule = trainingSchedule;
    }
}
