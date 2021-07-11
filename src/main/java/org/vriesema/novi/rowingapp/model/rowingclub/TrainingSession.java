package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TrainingSession {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long Id;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private String shortDescription;

    @Column
    private String longDescription;

    @OneToOne
    private TrainingType trainingType;

    @ManyToOne
    private TrainingSchedule trainingSchedule;


}
