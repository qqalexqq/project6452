package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.Organizer;
import cc.ntechnologies.service.OrganizerService;
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
public class OrganizerTableController implements Serializable {
    private static final long serialVersionUID = 1L;

    private OrganizerService organizerService;
    private FacesUtils facesUtils;

    private LazyDataModel<Organizer> organizerModel;
    private Organizer selectedOrganizer;

    private static final Logger log = Logger.getLogger(OrganizerTableController.class.getName());

    @Inject
    public OrganizerTableController(final OrganizerService organizerService, FacesUtils facesUtils) {
        organizerModel = new LazyDataModel<Organizer>() {
            @Override
            public List<Organizer> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                return organizerService.getAll(first, pageSize);
            }

            @Override
            public Long getRowKey(Organizer organizer) {
                return (organizer == null ? null : organizer.getId());
            }

            @Override
            public Organizer getRowData(String rowKey) {
                Long id = Long.parseLong(rowKey);

                for (Organizer organizer : (List<Organizer>) this.getWrappedData()) {
                    if (organizer.getId().equals(id)) {
                        return organizer;
                    }
                }

                return null;
            }
        };

        organizerModel.setRowCount(organizerService.getNumberOfOrganizers());

        this.organizerService = organizerService;
        this.facesUtils = facesUtils;
    }

    public void deleteOrganizer() {
        organizerService.delete(selectedOrganizer);
        organizerModel.setRowCount(organizerModel.getRowCount() - 1);

        facesUtils.addSuccessMessage("Organizer successfully deleted.");
    }

    public void updateOrganizer() {
        organizerService.save(selectedOrganizer);

        facesUtils.addSuccessMessage("Organizer successfully updated.");
    }

    public LazyDataModel<Organizer> getOrganizerModel() {
        return organizerModel;
    }
    public void setOrganizerModel(LazyDataModel<Organizer> organizerModel) {
        this.organizerModel = organizerModel;
    }
    public Organizer getSelectedOrganizer() {
        return selectedOrganizer;
    }
    public void setSelectedOrganizer(Organizer selectedOrganizer) {
        this.selectedOrganizer = selectedOrganizer;
    }
}
