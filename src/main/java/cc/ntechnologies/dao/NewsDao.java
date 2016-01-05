package cc.ntechnologies.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.Serializable;
import java.util.List;

import cc.ntechnologies.entities.News;
import org.springframework.stereotype.Repository;


@Repository
public class NewsDao implements Serializable {

    private final static long serialVersionUID = 1L;

    public News findById(Long id) {
        return ofy().load().type(News.class).id(id).now();
    }

    public void delete(News news) {
        ofy().delete().entity(news).now();
    }

    public News save(News news) {
        ofy().save().entities(news).now();

        return news;
    }

    public List<News> getAll(int start, int max) {
        return ofy().load().type(News.class).offset(start).limit(max).list();
    }

    public int getNumberOfNews() {
        return ofy().load().type(News.class).count();
    }
}
