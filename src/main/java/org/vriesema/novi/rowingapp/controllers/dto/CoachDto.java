package org.vriesema.novi.rowingapp.controllers.dto;
/*
 * @created:  2021-07-18
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;

public class CoachDto {
    private long id;
    private String firstname;
    private String lastName;
    private Crew crew;
    private boolean isCoach;
    private boolean isClubCoach;

    public static CoachDto fromCoach(Coach coach) {
        CoachDto dto = new CoachDto();
        dto.setId(coach.getId());
        dto.setFirstname(coach.getFirstName());
        dto.setLastName(coach.getLastName());
        dto.setCrew(coach.getCrew());
        dto.setCoach(coach.isCrewCoach());
        dto.setClubCoach(coach.isClubCoach());
        return dto;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isCoach() {
        return isCoach;
    }

    public void setCoach(boolean coach) {
        isCoach = coach;
    }

    public boolean isClubCoach() {
        return isClubCoach;
    }

    public void setClubCoach(boolean clubCoach) {
        isClubCoach = clubCoach;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
