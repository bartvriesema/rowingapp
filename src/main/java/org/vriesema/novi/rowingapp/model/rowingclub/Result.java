package org.vriesema.novi.rowingapp.model.rowingclub;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resultId;

    @Column
    private LocalDate resultDate;

    @Column
    private String description;

    @Column
    private int distance;

    @Column
    private int timeInSeconds;

    @ManyToOne
    private Crew crew;

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long id) {
        this.resultId = id;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }
}
