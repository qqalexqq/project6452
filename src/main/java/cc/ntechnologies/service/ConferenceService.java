package cc.ntechnologies.service;

import cc.ntechnologies.dao.ConferenceDao;
import cc.ntechnologies.entities.Conference;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Service
public class ConferenceService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ConferenceDao conferenceDao;

    public void save(Conference conference) {
        conferenceDao.save(conference);
    }

    public void delete(Conference conference) {
        conferenceDao.delete(conference);
    }

    public Conference findConferenceById(Long id) {
        return conferenceDao.findById(id);
    }

    public List<Conference> getAll(int first, int pageSize) {
        return conferenceDao.getAll(first, pageSize);
    }

    public int getNumberOfConferences() {
        return conferenceDao.getNumberOfConferences();
    }
}
