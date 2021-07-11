package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import javax.persistence.*;
import java.util.List;

@Entity
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String crewName;

    @OneToMany (mappedBy = "crew")
    List<Person> crewMembers;

    @OneToMany (mappedBy = "crew")
    List<Results> results;

}
