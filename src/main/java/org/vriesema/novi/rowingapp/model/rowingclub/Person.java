package org.vriesema.novi.rowingapp.model.rowingclub;

import org.vriesema.novi.rowingapp.model.authentication.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {
    /**
     * Users en persons kunnen onafhankelijk van elkaar bestaan. Er kan een relatie gelegd worden
     * tussen een user en een person.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long personId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String gender;

    @OneToOne
    private User user;

    @ManyToOne
    private Crew crew;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long id) {
        this.personId = id;
    }
}
