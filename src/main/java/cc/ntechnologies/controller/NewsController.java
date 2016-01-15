package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.GenericImage;
import cc.ntechnologies.entities.News;
import cc.ntechnologies.entities.Organizer;
import cc.ntechnologies.service.NewsService;
import cc.ntechnologies.service.OrganizerService;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("request")
public class NewsController implements Serializable {

    private static final long serialVersionUID = 1L;

    private NewsService newsService;
    private OrganizerService organizerService;
    private FacesUtils facesUtils;

    private Map<String, Long> organizersMap = new HashMap<String, Long>();

    @Size(min=1, message="Please provide news title.")
    private String title;

    @Size(min=1, message="Please provide news text.")
    private String text;

    @NotNull(message="Please provide news image.")
    private UploadedFile image;

    @NotNull(message="Please provide news organizer.")
    private Long organizerId;

    @Inject
    public NewsController(final NewsService newsService, final OrganizerService organizerService, FacesUtils facesUtils) {
        List<Organizer> organizersList = organizerService.getAll(0, Integer.MAX_VALUE);

        for (Organizer organizer : organizersList) {
            this.organizersMap.put(organizer.getFullName(), organizer.getId());
        }

        this.newsService = newsService;
        this.organizerService = organizerService;
        this.facesUtils = facesUtils;
    }

    public void createNews() {
        Organizer organizer = organizerService.findOrganizerById(this.organizerId);

        GenericImage genericImage = new GenericImage();
        genericImage.createImageFromFile(image);

        News news = new News(title, text, organizer, genericImage);
        newsService.save(news);

        facesUtils.addSuccessMessage("Added news " + news.getTitle());
    }

    public Map<String, Long> getOrganizersMap() {
        return this.organizersMap;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public UploadedFile getImage() {
        return this.image;
    }
    public void setImage(UploadedFile image) {
        this.image = image;
    }
    public Long getOrganizerId() {
        return this.organizerId;
    }
    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }
}
