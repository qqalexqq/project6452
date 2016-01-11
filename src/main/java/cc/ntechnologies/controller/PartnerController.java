package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.GenericImage;
import cc.ntechnologies.entities.Partner;
import cc.ntechnologies.service.PartnerService;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Controller
@Scope("request")
public class PartnerController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PartnerService PartnerService;

    @Inject
    private FacesUtils facesUtils;

    @Size(min=1, message="Please provide partner name.")
    private String name;

    @NotNull(message="Please provide partner image.")
    private UploadedFile image;


    public void createPartner() {
        GenericImage genericImage = new GenericImage();
        genericImage.createImageFromFile(image);

        Partner partner = new Partner(name, genericImage);
        PartnerService.save(partner);

        facesUtils.addSuccessMessage("Added Partner " + partner.getName());
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UploadedFile getImage() {
        return this.image;
    }
    public void setImage(UploadedFile image) {
        this.image = image;
    }
}
