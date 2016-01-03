package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.Speaker;
import cc.ntechnologies.service.SpeakerService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@Scope("view")
public class SpeakerTableController implements Serializable {
    private static final long serialVersionUID = 1L;

    private SpeakerService speakerService;
    private FacesUtils facesUtils;

    private LazyDataModel<Speaker> speakerModel;
    private Speaker selectedSpeaker;

    private static final Logger log = Logger.getLogger(SpeakerTableController.class.getName());

    @Inject
    public SpeakerTableController(final SpeakerService speakerService, FacesUtils facesUtils) {
        this.facesUtils = facesUtils;

        speakerModel = new LazyDataModel<Speaker>() {
            @Override
            public List<Speaker> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                return speakerService.getAll(first, pageSize);
            }

            @Override
            public Long getRowKey(Speaker speaker) {
                return (speaker == null ? null : speaker.getId());
            }

            @Override
            public Speaker getRowData(String rowKey) {
                Long id = Long.parseLong(rowKey);

                for (Speaker speaker : (List<Speaker>) this.getWrappedData()) {
                    if (speaker.getId().equals(id)) {
                        return speaker;
                    }
                }

                return null;
            }
        };

        speakerModel.setRowCount(speakerService.getNumberOfSpeakers());

        this.speakerService = speakerService;
        this.facesUtils = facesUtils;
    }

    public void deleteSpeaker() {
        speakerService.delete(selectedSpeaker);
        speakerModel.setRowCount(speakerModel.getRowCount() - 1);

        facesUtils.addSuccessMessage("Speaker successfully deleted.");
    }

    public void updateSpeaker() {
        speakerService.save(selectedSpeaker);

        facesUtils.addSuccessMessage("Speaker successfully updated.");
    }

    public LazyDataModel<Speaker> getSpeakerModel() {
        return speakerModel;
    }
    public void setSpeakerModel(LazyDataModel<Speaker> speakerModel) {
        this.speakerModel = speakerModel;
    }
    public Speaker getSelectedSpeaker() {
        return selectedSpeaker;
    }
    public void setSelectedSpeaker(Speaker selectedSpeaker) {
        this.selectedSpeaker = selectedSpeaker;
    }
}
