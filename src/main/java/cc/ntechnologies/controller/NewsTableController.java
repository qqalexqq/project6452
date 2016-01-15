package cc.ntechnologies.controller;

import cc.ntechnologies.FacesUtils;
import cc.ntechnologies.entities.GenericImage;
import cc.ntechnologies.entities.News;
import cc.ntechnologies.entities.Organizer;
import cc.ntechnologies.service.NewsService;
import cc.ntechnologies.service.OrganizerConverter;
import cc.ntechnologies.service.OrganizerService;
import org.primefaces.event.FileUploadEvent;
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
public class NewsTableController implements Serializable {
    private static final long serialVersionUID = 1L;

    private NewsService newsService;
    private FacesUtils facesUtils;

    private List<Organizer> organizersList;
    private LazyDataModel<News> newsModel;
    private News selectedNews;
    private GenericImage image;

    private static final Logger log = Logger.getLogger(NewsTableController.class.getName());

    @Inject
    public NewsTableController(final NewsService newsService, final OrganizerService organizerService, FacesUtils facesUtils) {
        this.organizersList = organizerService.getAll(0, Integer.MAX_VALUE);

        newsModel = new LazyDataModel<News>() {
            @Override
            public List<News> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                return newsService.getAll(first, pageSize);
            }

            @Override
            public Long getRowKey(News news) {
                return (news == null ? null : news.getId());
            }

            @Override
            public News getRowData(String rowKey) {
                Long id = Long.parseLong(rowKey);

                List<News> newsList = (List<News>) this.getWrappedData();

                if (newsList != null) {
                    for (News news : newsList) {
                        if (news.getId().equals(id)) {
                            return news;
                        }
                    }
                }

                return null;
            }
        };

        newsModel.setRowCount(newsService.getNumberOfNews());

        this.newsService = newsService;
        this.facesUtils = facesUtils;
    }

    public void deleteNews() {
        newsService.delete(selectedNews);
        newsModel.setRowCount(newsModel.getRowCount() - 1);

        facesUtils.addSuccessMessage("News successfully deleted.");
    }

    public void handleImageUpload(FileUploadEvent event) {
        this.image = new GenericImage();
        this.image.createImageFromFile(event.getFile());

        facesUtils.addSuccessMessage("Successfully uploaded " + event.getFile().getFileName() + ". Right click and select Save to save changes to the news.");
    }

    public void updateNews() {
        if (this.image != null) {
            this.selectedNews.setImage(this.image);
        }

        newsService.save(selectedNews);

        facesUtils.addSuccessMessage("News successfully updated.");
    }

    public LazyDataModel<News> getNewsModel() {
        return newsModel;
    }
    public void setNewsModel(LazyDataModel<News> newsModel) {
        this.newsModel = newsModel;
    }
    public List<Organizer> getOrganizersList() {
        return this.organizersList;
    }
    public News getSelectedNews() {
        return selectedNews;
    }
    public void setSelectedNews(News selectedNews) {
        this.selectedNews = selectedNews;
    }
}
