package cc.ntechnologies.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.*;


@Entity
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Index
    private String title;

    @Index
    private String text;

    private GenericImage image;

    //relations
    @Index
    private Ref<Organizer> organizer;

    public News() {

    }

    public News(String title, String text, Organizer organizer, GenericImage image) {
        this.title = title;
        this.text = text;
        this.setOrganizer(organizer);
        this.image = image;
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
    public GenericImage getImage() {
        return image;
    }
    public void setImage(GenericImage image) {
        this.image = image;
    }
    public Organizer getOrganizer() {
        return organizer.get();
    }
    public void setOrganizer(Organizer organizer) {
        this.organizer = Ref.create(organizer);
    }
}
