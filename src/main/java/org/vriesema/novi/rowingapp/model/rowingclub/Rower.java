package org.vriesema.novi.rowingapp.model.rowingclub;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Rower extends Person {

    @Column
    private int numberOfVictoryPoints;

    @OneToMany(mappedBy = "rower")
    @JsonManagedReference(value = "rower")
    private List<HeartRate> heartrateList;

    @Column
    private boolean isRower;

    public int getNumberOfVictoryPoints() {
        return numberOfVictoryPoints;
    }

    public void setNumberOfVictoryPoints(int numberOfVictoryPoints) {
        this.numberOfVictoryPoints = numberOfVictoryPoints;
    }

    @JsonIgnore
    public List<HeartRate> getHeartrateList() {
        return heartrateList;
    }

    public void setHeartrateList(List<HeartRate> heartrateList) {
        this.heartrateList = heartrateList;
    }

    public boolean isRower() {
        return isRower;
    }

    public void setRower(boolean rower) {
        isRower = rower;
    }

}
