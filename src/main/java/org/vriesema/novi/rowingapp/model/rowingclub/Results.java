package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private LocalDate resultDate;

    @Column
    private String description;

    @Column
    private int distance;

    @Column
    private int timeInSeconds;

    @ManyToOne
    private Crew crew;

}
