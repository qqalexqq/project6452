package cc.ntechnologies.service;

import cc.ntechnologies.entities.Speaker;
import org.springframework.stereotype.Service;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;

@Service
public class SpeakerConverter implements Converter {
    @Inject
    private SpeakerService speakerService;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return speakerService.findSpeakerById(Long.parseLong(value));
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
            String speakerIdString = ((Speaker) object).getId().toString();

            return speakerIdString;
        }
        else {
            return null;
        }
    }
}
