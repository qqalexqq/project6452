package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.Organizer;
import cc.ntechnologies.service.OrganizerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Controller
@Scope("view")
public class OrganizerController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private OrganizerService organizerService;

    @Inject
    private FacesUtils facesUtils;


    @Size(min=1,message="Please provide organizer's first name.")
    private String firstname;

    @Size(min=1,message="Please provide organizer's last name.")
    private String lastname;

    public void createOrganizer() {
        Organizer organizer = new Organizer(firstname, lastname);

        organizerService.save(organizer);

        facesUtils.addSuccessMessage("Added organizer " + organizer.getFullName());
    }

    public String getFirstname() {
        return this.firstname;
    }
    public void setFirstname(String name) {
        this.firstname = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

