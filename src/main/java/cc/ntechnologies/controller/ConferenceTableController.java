package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.Conference;
import cc.ntechnologies.entities.Room;
import cc.ntechnologies.entities.Speaker;
import cc.ntechnologies.service.ConferenceService;
import cc.ntechnologies.service.RoomService;
import cc.ntechnologies.service.SpeakerConverter;
import cc.ntechnologies.service.SpeakerService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@Scope("view")
public class ConferenceTableController implements Serializable {
    private static final long serialVersionUID = 1L;

    private ConferenceService conferenceService;
    private FacesUtils facesUtils;

    private List<Speaker> speakersList;
    private List<Room> roomsList;
    private LazyDataModel<Conference> conferenceModel;
    private Conference selectedConference;

    private static final Logger log = Logger.getLogger(ConferenceTableController.class.getName());

    @Inject
    public ConferenceTableController(final ConferenceService conferenceService, final SpeakerService speakerService, final RoomService roomService, FacesUtils facesUtils) {
        this.speakersList = speakerService.getAll(0, Integer.MAX_VALUE);
        this.roomsList = roomService.getAll(0, Integer.MAX_VALUE);

        conferenceModel = new LazyDataModel<Conference>() {
            @Override
            public List<Conference> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                return conferenceService.getAll(first, pageSize);
            }

            @Override
            public Long getRowKey(Conference conference) {
                return (conference == null ? null : conference.getId());
            }

            @Override
            public Conference getRowData(String rowKey) {
                Long id = Long.parseLong(rowKey);

                List<Conference> conferenceList = (List<Conference>) this.getWrappedData();

                if (conferenceList != null) {
                    for (Conference conference : conferenceList) {
                        if (conference.getId().equals(id)) {
                            return conference;
                        }
                    }
                }

                return null;
            }
        };

        conferenceModel.setRowCount(conferenceService.getNumberOfConferences());

        this.conferenceService = conferenceService;
        this.facesUtils = facesUtils;
    }

    public void deleteConference() {
        conferenceService.delete(selectedConference);
        conferenceModel.setRowCount(conferenceModel.getRowCount() - 1);

        facesUtils.addSuccessMessage("Talk successfully deleted.");
    }

    public void updateConference() {
        conferenceService.save(selectedConference);

        facesUtils.addSuccessMessage("Talk successfully updated.");
    }

    public LazyDataModel<Conference> getConferenceModel() {
        return conferenceModel;
    }
    public void setConferenceModel(LazyDataModel<Conference> conferenceModel) {
        this.conferenceModel = conferenceModel;
    }
    public List<Speaker> getSpeakersList() {
        return this.speakersList;
    }
    public List<Room> getRoomsList() {
        return this.roomsList;
    }
    public Conference getSelectedConference() {
        return selectedConference;
    }
    public void setSelectedConference(Conference selectedConference) {
        this.selectedConference = selectedConference;
    }
}
