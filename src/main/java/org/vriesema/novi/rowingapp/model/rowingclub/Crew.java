package org.vriesema.novi.rowingapp.model.rowingclub;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    long id;

    @Column
    String crewName;

    @OneToMany(mappedBy = "crew")
    List<Person> crewMembers;

    @OneToMany(mappedBy = "crew")
    List<Results> results;

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

    @JsonIgnore
    public List<Person> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<Person> crewMembers) {
        this.crewMembers = crewMembers;
    }

    @JsonIgnore
    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
