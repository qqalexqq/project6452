package cc.ntechnologies.service;

import cc.ntechnologies.entities.Organizer;
import org.springframework.stereotype.Service;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;

@Service
public class OrganizerConverter implements Converter {
    @Inject
    private OrganizerService organizerService;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return organizerService.findOrganizerById(Long.parseLong(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", e.getMessage()));
            }
        }
        else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            String organizerIdString = ((Organizer) object).getId().toString();

            return organizerIdString;
        }
        else {
            return null;
        }
    }
}
