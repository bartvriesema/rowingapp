package org.vriesema.novi.rowingapp.model.rowingclub;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private String shortDescription;

    @Column
    private String longDescription;

    @OneToOne
    private TrainingType trainingType;

    @ManyToOne
    private TrainingSchedule trainingSchedule;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    @JsonIgnore
    public TrainingSchedule getTrainingSchedule() {
        return trainingSchedule;
    }

    public void setTrainingSchedule(TrainingSchedule trainingSchedule) {
        this.trainingSchedule = trainingSchedule;
    }
}
