package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.authentication.User;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;

import java.io.Serializable;
import java.time.LocalDate;

public class CoachDto implements Serializable {
    private long coachId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private User user;
    private Crew crew;
    private boolean clubCoach;
    private boolean crewCoach;

    public static CoachDto fromCoach(Coach coach) {
        if (coach == null) return null;

        CoachDto coachDto = new CoachDto();

        coachDto.coachId = coach.getPersonId();
        coachDto.firstName = coach.getFirstName();
        coachDto.lastName = coach.getLastName();
        coachDto.dateOfBirth = coach.getDateOfBirth();
        coachDto.gender = coach.getGender();
        coachDto.user = coach.getUser();
        coachDto.crew = coach.getCrew();
        coachDto.clubCoach = coach.isClubCoach();
        coachDto.crewCoach = coach.isCrewCoach();

        return coachDto;
    }

    public Coach toCoach() {
        Coach coach = new Coach();

        coach.setPersonId(coachId);
        coach.setFirstName(firstName);
        coach.setLastName(lastName);
        coach.setDateOfBirth(dateOfBirth);
        coach.setGender(gender);
        coach.setUser(user);
        coach.setCrew(crew);
        coach.setClubCoach(clubCoach);
        coach.setCrewCoach(crewCoach);

        return coach;
    }

    public long getCoachId() {
        return coachId;
    }

    public void setCoachId(long coachId) {
        this.coachId = coachId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
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
