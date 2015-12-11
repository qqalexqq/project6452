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
}
