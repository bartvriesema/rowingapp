package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.authentication.User;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

import java.io.Serializable;
import java.time.LocalDate;

public class RowerDto implements Serializable {
    private long rowerId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private User user;
    private Crew crew;
    private int numberOfVictoryPoints;

    public static RowerDto fromRower(Rower rower) {
        if (rower == null) return null;

        RowerDto rowerDto = new RowerDto();

        rowerDto.rowerId = rower.getPersonId();
        rowerDto.firstName = rower.getFirstName();
        rowerDto.lastName = rower.getLastName();
        rowerDto.dateOfBirth = rower.getDateOfBirth();
        rowerDto.gender = rower.getGender();
        rowerDto.crew = rower.getCrew();
        rowerDto.numberOfVictoryPoints = rower.getNumberOfVictoryPoints();

        return rowerDto;
    }

    public Rower toRower() {
        Rower rower = new Rower();

        rower.setPersonId(rowerId);
        rower.setFirstName(firstName);
        rower.setLastName(lastName);
        rower.setDateOfBirth(dateOfBirth);
        rower.setGender(gender);
        rower.setUser(user);
        rower.setCrew(crew);
        rower.setNumberOfVictoryPoints(numberOfVictoryPoints);

        return rower;
    }

    public long getRowerId() {
        return rowerId;
    }

    public void setRowerId(long rowerId) {
        this.rowerId = rowerId;
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

    public int getNumberOfVictoryPoints() {
        return numberOfVictoryPoints;
    }

    public void setNumberOfVictoryPoints(int numberOfVictoryPoints) {
        this.numberOfVictoryPoints = numberOfVictoryPoints;
    }

}
