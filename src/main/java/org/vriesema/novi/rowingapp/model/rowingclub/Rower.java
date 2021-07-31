package org.vriesema.novi.rowingapp.model.rowingclub;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Rower extends Person {

    @Column
    int numberOfVictoryPoints;

    @OneToMany(mappedBy = "rower")
    List<Heartrate> heartrateList;

    @Column
    boolean isRower;

    public int getNumberOfVictoryPoints() {
        return numberOfVictoryPoints;
    }

    public void setNumberOfVictoryPoints(int numberOfVictoryPoints) {
        this.numberOfVictoryPoints = numberOfVictoryPoints;
    }

    public List<Heartrate> getHeartrateList() {
        return heartrateList;
    }

    public void setHeartrateList(List<Heartrate> heartrateList) {
        this.heartrateList = heartrateList;
    }

    public boolean isRower() {
        return isRower;
    }

    public void setRower(boolean rower) {
        isRower = rower;
    }

}
