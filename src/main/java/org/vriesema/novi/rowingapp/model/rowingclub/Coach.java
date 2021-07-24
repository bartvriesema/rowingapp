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
    private boolean isClubCoach;

    @Column
    private boolean isCoach;

    public boolean isClubCoach() {
        return isClubCoach;
    }

    public void setClubCoach(boolean clubCoach) {
        isClubCoach = clubCoach;
    }

    public boolean isCoach() {
        return isCoach;
    }

    public void setCoach(boolean coach) {
        isCoach = coach;
    }
}
