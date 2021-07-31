package org.vriesema.novi.rowingapp.model.rowingclub;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Coach extends Person {

    @Column
    private boolean clubCoach;

    @Column
    private boolean crewCoach;

    public Coach() {
        this.crewCoach = true;
        this.clubCoach = false;
    }

    public boolean isClubCoach() {
        return clubCoach;
    }

    public void setClubCoach(boolean clubCoach) {
        this.clubCoach = clubCoach;
    }

    public boolean isCrewCoach() {
        return crewCoach;
    }

    public void setCrewCoach(boolean crewCoach) {
        this.crewCoach = crewCoach;
    }
}
