package org.vriesema.novi.rowingapp.controllers.dto;
/*
 * @created:  2021-07-18
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.vriesema.novi.rowingapp.model.rowingclub.Crew;

public class CrewDto {
    private long id;
    private String crewName;

    public static CrewDto fromCrew(Crew crew) {
        CrewDto dto = new CrewDto();
        dto.setId(crew.getId());
        dto.setCrewName(crew.getCrewName());
        return dto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }
}
