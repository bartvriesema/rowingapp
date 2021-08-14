package org.vriesema.novi.rowingapp.model.rowingclub;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingSessionId;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    @OneToOne
    private TrainingType trainingType;

    @ManyToOne
    private TrainingSchedule trainingSchedule;

    @OneToMany(mappedBy = "trainingSession")
    private List<TrainingReport> trainingReportList;

    public Long getTrainingSessionId() {
        return trainingSessionId;
    }

    public void setTrainingSessionId(Long trainingSessionId) {
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

    @JsonIgnore
    public TrainingSchedule getTrainingSchedule() {
        return trainingSchedule;
    }

    public void setTrainingSchedule(TrainingSchedule trainingSchedule) {
        this.trainingSchedule = trainingSchedule;
    }

    public List<TrainingReport> getTrainingReportList() {
        return trainingReportList;
    }

    public void setTrainingReportList(List<TrainingReport> trainingReportList) {
        this.trainingReportList = trainingReportList;
    }
}
