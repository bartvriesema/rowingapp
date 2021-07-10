package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import javax.persistence.*;

@Entity
public class TrainingType {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String shortDescription;

    @Column
    private int lowerHeartRate;

    @Column
    private int upperHeartRate;


}
