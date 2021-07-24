package org.vriesema.novi.rowingapp.controllers.dto;
/*
 * @created:  2021-07-24
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

public class RowerDto {
    private long id;
    private String firstName;
    private String lastName;
    private Crew crew;
    private int numberOfVictoryPoints;
    private String gender;

    public static RowerDto fromRower(Rower rower) {
        RowerDto dto = new RowerDto();
        dto.setId(rower.getId());
        dto.setFirstName(rower.getFirstName());
        dto.setLastName(rower.getLastName());
        dto.setCrew(rower.getCrew());
        dto.setNumberOfVictoryPoints(rower.getNumberOfVictoryPoints());
        dto.setGender(rower.getGender());
        return dto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
