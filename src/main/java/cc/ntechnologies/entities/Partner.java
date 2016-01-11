package cc.ntechnologies.entities;

import com.googlecode.objectify.annotation.*;

import java.io.Serializable;


@Entity
public class Partner implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Index
    private String name;

    private GenericImage image;

    public Partner() {

    }

    public Partner(String name, GenericImage image) {
        this.name = name;
        this.image = image;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public GenericImage getImage() {
        return image;
    }
    public void setImage(GenericImage image) {
        this.image = image;
    }
}
