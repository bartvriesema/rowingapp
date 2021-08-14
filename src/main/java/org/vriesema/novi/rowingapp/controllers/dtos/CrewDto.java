package org.vriesema.novi.rowingapp.controllers.dtos;

import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.Person;
import org.vriesema.novi.rowingapp.model.rowingclub.Result;

import java.io.Serializable;
import java.util.List;

public class CrewDto implements Serializable {
    private long crewId;
    private String crewName;
    private List<Person> crewMembers;
    private List<Result> resultsList;

    public static CrewDto fromCrew(Crew crew) {
        if (crew == null) return null;

        CrewDto crewDto = new CrewDto();

        crewDto.crewId = crew.getId();
        crewDto.crewName = crew.getCrewName();
        crewDto.crewMembers = crew.getCrewMembers();
        crewDto.resultsList = crew.getResults();

        return crewDto;
    }

    public Crew toCrew() {
        Crew crew = new Crew();

        crew.setId(crewId);
        crew.setCrewName(crewName);
        crew.setCrewMembers(crewMembers);
        crew.setResults(resultsList);

        return crew;
    }

    public long getCrewId() {
        return crewId;
    }

    public void setCrewId(long crewId) {
        this.crewId = crewId;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public List<Person> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<Person> crewMembers) {
        this.crewMembers = crewMembers;
    }

    public List<Result> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Result> resultsList) {
        this.resultsList = resultsList;
    }
}
