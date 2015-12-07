package cc.ntechnologies;

import java.util.List;

import cc.ntechnologies.dao.ConferenceDao;
import cc.ntechnologies.dao.NewsDao;
import cc.ntechnologies.dao.OrganizerDao;
import cc.ntechnologies.dao.PartnerDao;
import cc.ntechnologies.dao.SpeakerDao;
import cc.ntechnologies.entities.Conference;
import cc.ntechnologies.entities.News;
import cc.ntechnologies.entities.Organizer;
import cc.ntechnologies.entities.Partner;
import cc.ntechnologies.entities.Speaker;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Inject;

@Api(name="api", version = "v1", namespace = @ApiNamespace(ownerDomain="project645-2.appspot.com", ownerName="ntech", packagePath=""))
public class API {
    @Inject
    @ApiMethod(name = "getAllSpeakers")
    public List<Speaker> allSpeakers(SpeakerDao speakerDao) {
        return speakerDao.getAll();
    }

    @Inject
    @ApiMethod(name = "getAllConferences")
    public List<Conference> allConferences(ConferenceDao conferenceDao) {
        return conferenceDao.getAll();
    }

    @Inject
    @ApiMethod(name = "getAllOrganizers")
    public List<Organizer> allOrganizers(OrganizerDao organizerDao) {
        return organizerDao.getAll();
    }

    @Inject
    @ApiMethod(name = "getAllPartners")
    public List<Partner> allPartners(PartnerDao partnerDao) {
        return partnerDao.getAll();
    }

    @Inject
    @ApiMethod(name = "getAllNews")
    public List<News> allNews(NewsDao newsDao) {
        return newsDao.getAll();
    }

    @Inject
    @ApiMethod(name="insertTestSpeaker")
    public Speaker insertTestSpeaker(SpeakerDao speakerDao) {
        return speakerDao.save(new Speaker("John", "Smith", "Some of those speaking guys we have."));
    }
}
