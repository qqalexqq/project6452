package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.Speaker;
import cc.ntechnologies.service.SpeakerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Controller
@Scope("view")
public class SpeakerController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SpeakerService speakerService;

    @Inject
    private FacesUtils facesUtils;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String description;

    public void createSpeaker() {
        Speaker speaker = new Speaker(firstname, lastname, description);

        speakerService.save(speaker);

        facesUtils.addSuccessMessage("Added speaker " + speaker.getFullName());
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

