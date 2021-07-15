package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import javax.persistence.*;
import java.util.List;

@Entity
public class TrainingSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @OneToOne
    private Crew crew;

    @OneToMany
    private List<TrainingSession> trainingSessions;

}
