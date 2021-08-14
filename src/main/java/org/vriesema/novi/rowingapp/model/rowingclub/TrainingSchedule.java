package org.vriesema.novi.rowingapp.model.rowingclub;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class TrainingSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingScheduleId;

    @OneToOne
    private Crew crew;

    @OneToMany(mappedBy = "trainingSchedule")
    private List<TrainingSession> trainingSessions;

    public Long getTrainingScheduleId() {
        return trainingScheduleId;
    }

    public void setTrainingScheduleId(Long trainingScheduleId) {
        this.trainingScheduleId = trainingScheduleId;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    @JsonIgnore
    public List<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(List<TrainingSession> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }
}
