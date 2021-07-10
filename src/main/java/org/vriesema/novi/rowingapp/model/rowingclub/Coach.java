package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import javax.persistence.*;

@Entity
public class Coach extends Person {

    @Column
    private boolean isClubCoach;

    @Column
    private boolean isCoach;


}
