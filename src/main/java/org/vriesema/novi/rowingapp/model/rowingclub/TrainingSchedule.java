package org.vriesema.novi.rowingapp.model.rowingclub;

import javax.persistence.*;
import java.util.List;

@Entity
public class TrainingSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @OneToOne
    private Crew crew;

    @OneToMany(mappedBy = "trainingSchedule")
    private List<TrainingSession> trainingSessions;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public List<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(List<TrainingSession> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }
}
