package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.GenericImage;
import cc.ntechnologies.entities.Partner;
import cc.ntechnologies.service.PartnerService;
import org.primefaces.event.FileUploadEvent;
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
public class PartnerTableController implements Serializable {
    private static final long serialVersionUID = 1L;

    private PartnerService partnerService;
    private FacesUtils facesUtils;

    private LazyDataModel<Partner> partnerModel;
    private Partner selectedPartner;
    private GenericImage image;

    private static final Logger log = Logger.getLogger(PartnerTableController.class.getName());

    @Inject
    public PartnerTableController(final PartnerService partnerService, FacesUtils facesUtils) {
        partnerModel = new LazyDataModel<Partner>() {
            @Override
            public List<Partner> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                return partnerService.getAll(first, pageSize);
            }
        };

        partnerModel = new LazyDataModel<Partner>() {
            @Override
            public List<Partner> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                return partnerService.getAll(first, pageSize);
            }

            @Override
            public Long getRowKey(Partner partner) {
                return (partner == null ? null : partner.getId());
            }

            @Override
            public Partner getRowData(String rowKey) {
                Long id = Long.parseLong(rowKey);

                for (Partner partner : (List<Partner>) this.getWrappedData()) {
                    if (partner.getId().equals(id)) {
                        return partner;
                    }
                }

                return null;
            }
        };

        partnerModel.setRowCount(partnerService.getNumberOfPartners());

        this.partnerService = partnerService;
        this.facesUtils = facesUtils;
    }

    public void deletePartner() {
        partnerService.delete(selectedPartner);
        partnerModel.setRowCount(partnerModel.getRowCount() - 1);

        facesUtils.addSuccessMessage("Partner successfully deleted.");
    }

    public void handleImageUpload(FileUploadEvent event) {
        this.image = new GenericImage();
        this.image.createImageFromFile(event.getFile());

        facesUtils.addSuccessMessage("Successfully uploaded " + event.getFile().getFileName() + ". Right click and select Save to save changes to the speaker.");
    }

    public void updatePartner() {
        if (this.image != null) {
            this.selectedPartner.setImage(this.image);
        }

        partnerService.save(selectedPartner);

        facesUtils.addSuccessMessage("Partner successfully updated.");
    }

    public LazyDataModel<Partner> getPartnerModel() {
        return partnerModel;
    }
    public void setPartnerModel(LazyDataModel<Partner> partnerModel) {
        this.partnerModel = partnerModel;
    }
    public Partner getSelectedPartner() {
        return selectedPartner;
    }
    public void setSelectedPartner(Partner selectedPartner) {
        this.selectedPartner = selectedPartner;
    }
}
