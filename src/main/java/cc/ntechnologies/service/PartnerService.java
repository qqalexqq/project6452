package cc.ntechnologies.service;

import cc.ntechnologies.dao.PartnerDao;
import cc.ntechnologies.entities.Partner;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Service
public class PartnerService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PartnerDao partnerDao;

    public void save(Partner partner) {
        partnerDao.save(partner);
    }

    public void delete(Partner partner) {
        partnerDao.delete(partner);
    }

    public Partner findPartnerById(Long id) {
        return partnerDao.findById(id);
    }

    public List<Partner> getAll(int first, int pageSize) {
        return partnerDao.getAll(first, pageSize);
    }

    public int getNumberOfPartners() {
        return partnerDao.getNumberOfPartners();
    }
}
