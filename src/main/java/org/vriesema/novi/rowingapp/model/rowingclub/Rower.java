package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import javax.persistence.*;
import java.util.List;

@Entity
public class Rower extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

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
