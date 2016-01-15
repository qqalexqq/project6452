package cc.ntechnologies.service;

import cc.ntechnologies.dao.NewsDao;
import cc.ntechnologies.entities.News;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Service
public class NewsService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private NewsDao newsDao;

    public void save(News news) {
        newsDao.save(news);
    }

    public void delete(News news) {
        newsDao.delete(news);
    }

    public News findNewsById(Long id) {
        return newsDao.findById(id);
    }

    public List<News> getAll(int first, int pageSize) {
        return newsDao.getAll(first, pageSize);
    }

    public int getNumberOfNews() {
        return newsDao.getNumberOfNews();
    }
}
