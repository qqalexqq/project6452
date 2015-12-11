package cc.ntechnologies.service;

import cc.ntechnologies.dao.SpeakerDao;
import cc.ntechnologies.entities.Speaker;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Service
public class SpeakerService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SpeakerDao speakerDao;

    public void save(Speaker speaker) {
        speakerDao.save(speaker);
    }

    public void delete(Speaker speaker) {
        speakerDao.delete(speaker);
    }

    public Speaker findSpeakerById(Long id) {
        return speakerDao.findById(id);
    }

    public List<Speaker> getAll(int first, int pageSize) {
        return speakerDao.getAll(first, pageSize);
    }

    public int getNumberOfSpeakers() {
        return speakerDao.getNumberOfSpeakers();
    }
}
