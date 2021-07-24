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
    private boolean ClubCoach;

    @Column
    private boolean CrewCoach;

    public Coach() {
        this.CrewCoach = true;
    }

    public boolean isClubCoach() {
        return ClubCoach;
    }

    public void setClubCoach(boolean clubCoach) {
        this.ClubCoach = clubCoach;
    }

    public boolean isCrewCoach() {
        return CrewCoach;
    }

    public void setCrewCoach(boolean crewCoach) {
        this.CrewCoach = crewCoach;
    }
}
