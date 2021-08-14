package org.vriesema.novi.rowingapp.model.rowingclub;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column
    private String crewName;

    @OneToMany(mappedBy = "crew")
    private List<Person> crewMembers;

    @OneToMany(mappedBy = "crew")
    private List<Result> results;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
