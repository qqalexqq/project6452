package cc.ntechnologies.service;

import cc.ntechnologies.dao.OrganizerDao;
import cc.ntechnologies.entities.Organizer;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Service
public class OrganizerService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private OrganizerDao organizerDao;

    public void save(Organizer organizer) {
        organizerDao.save(organizer);
    }

    public void delete(Organizer organizer) {
        organizerDao.delete(organizer);
    }

    public Organizer findOrganizerById(Long id) {
        return organizerDao.findById(id);
    }

    public List<Organizer> getAll(int first, int pageSize) {
        return organizerDao.getAll(first, pageSize);
    }

    public int getNumberOfOrganizers() {
        return organizerDao.getNumberOfOrganizers();
    }
}
