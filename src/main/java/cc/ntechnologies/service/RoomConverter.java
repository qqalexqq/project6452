package cc.ntechnologies.service;

import cc.ntechnologies.entities.Room;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoomConverter implements Converter {
    @Inject
    private RoomService roomService;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return roomService.findRoomById(Long.parseLong(value));
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
            String roomIdString = ((Room) object).getId().toString();

            return roomIdString;
        }
        else {
            return null;
        }
    }
}
