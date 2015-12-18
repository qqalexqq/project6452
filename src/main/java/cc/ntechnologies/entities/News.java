package cc.ntechnologies.entities;

import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.*;


@Entity
public class News {
    @Id
    private Long id;

    @Index
    private String title;

    @Index
    private String text;
    // PHOTO

    //relations
    @Index
    private List<Ref<Organizer>> organizers;


    public News() {

    }

    public News(String title, String text, List<Ref<Organizer>> organizers) {
        this.title = title;
        this.text = text;
        this.organizers = organizers;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
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
    public List<Ref<Organizer>> getOrganizers() {
        return organizers;
    }
    public void setOrganizers(List<Ref<Organizer>> organizers) {
        this.organizers = organizers;
    }
}
