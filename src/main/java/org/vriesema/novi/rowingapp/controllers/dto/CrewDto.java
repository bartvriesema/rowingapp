package org.vriesema.novi.rowingapp.controllers.dto;
/*
 * @created:  2021-07-18
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.vriesema.novi.rowingapp.model.rowingclub.Crew;

public class CrewDto {
    public long id;
    public String crewName;

    public static CrewDto fromCrew(Crew crew) {
        CrewDto dto = new CrewDto();
        dto.id = crew.getId();
        dto.crewName = crew.getCrewName();
        return dto;
    }


}
