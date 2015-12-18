package cc.ntechnologies.entities;

import com.googlecode.objectify.annotation.*;


@Entity
public class Organizer {
    @Id
    private Long id;

    @Index
    private String firstname;

    @Index
    private String lastname;


    public Organizer () {

    }

    public Organizer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
