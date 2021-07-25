package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

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
