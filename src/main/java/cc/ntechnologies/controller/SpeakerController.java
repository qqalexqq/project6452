package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.GenericImage;
import cc.ntechnologies.entities.Speaker;
import cc.ntechnologies.service.SpeakerService;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Controller
@Scope("request")
public class SpeakerController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SpeakerService speakerService;

    @Inject
    private FacesUtils facesUtils;

    @Size(min=1, message="Please provide speaker first name.")
    private String firstname;

    @Size(min=1, message="Please provide speaker last name.")
    private String lastname;

    @Size(min=1, message="Please provide speaker description.")
    private String description;

    @NotNull(message="Please provide speaker image.")
    private UploadedFile image;

    public void createSpeaker() {
        GenericImage genericImage = new GenericImage();
        genericImage.createImageFromFile(image);

        Speaker speaker = new Speaker(firstname, lastname, description, genericImage);
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
    public UploadedFile getImage() {
        return this.image;
    }
    public void setImage(UploadedFile image) {
        this.image = image;
    }
}
