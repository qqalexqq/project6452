package cc.ntechnologies.entities;

import com.googlecode.objectify.annotation.*;


@Entity
public class Partner {
    @Id
    private Long id;

    @Index
    private String name;


    public Partner() {

    }

    public Partner(String name) {
        this.name = name;
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
}
