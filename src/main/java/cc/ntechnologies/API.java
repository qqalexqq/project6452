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

@Api(name="api", version = "v1", namespace = @ApiNamespace(ownerDomain="project645-2.appspot.com", ownerName="ntech", packagePath=""))
public class API {
    private SpeakerDao speakerDao = new SpeakerDao();
    private ConferenceDao conferenceDao = new ConferenceDao();
    private NewsDao newsDao = new NewsDao();
    private OrganizerDao organizerDao = new OrganizerDao();
    private PartnerDao partnerDao = new PartnerDao();

    @ApiMethod(name = "getAllSpeakers")
    public List<Speaker> allSpeakers() {
        return speakerDao.getAll();
    }
    @ApiMethod(name = "getAllConferences")
    public List<Conference> allConferences() {
        return conferenceDao.getAll();
    }
    @ApiMethod(name = "getAllOrganizers")
    public List<Organizer> allOrganizers() {
        return organizerDao.getAll();
    }
    @ApiMethod(name = "getAllPartners")
    public List<Partner> allPartners() {
        return partnerDao.getAll();
    }
    @ApiMethod(name = "getAllNews")
    public List<News> allNews() {
        return newsDao.getAll();
    }

    @ApiMethod(name="insertTestSpeaker")
    public Speaker insertTestSpeaker() {
        return speakerDao.save(new Speaker("John", "Smith", "Some of those speaking guys we have."));
    }
}
